;(function() {
  'use strict'

  var optionsData = {}
  var selectedOption = {
    mainGoodsList: [],
    mainGoodsOptionList: [],
    subGoodsList: [],
    subGoodsOptionList: []
  }

  var mainGoodsOptionDepth = displayGoodsGroup.mainGoodsOptionTitleList.length
  var subGoodsOptionDepth =
    displayGoodsGroup.subGoodsOptionTitleList &&
    displayGoodsGroup.subGoodsOptionTitleList.length

  var $selectGroup = $('[data-select-group]')
  var $groupPurchase = $('.group_purchase')
  var $groupOption = $('.group_option')
  var $dimmedOption = $('.dimmed_option').hide()
  var $boxPurchase = $('.box_purchase').addClass('option_close')
  var $btnOptionbar = $('.btn_optionbar').hide()

  var $basketItems = $('ul.list_option').hide()
  var $selectOptions = $('[data-option-type="options"]')
  var $selectAdditional = $('[data-option-type="additional"]')

  var computeBasketSummary$ = computeBasketSummary()

  var isMatchMedia = window.matchMedia('(max-width: 768px)').matches

  var template = {
    product: _.template(
      '<li class="${item.isSoldOut ? "item_soldout" : ""}" data-salePrice="${item.salePrice}" data-exchangePrice="${item.exchangePrice}">\
        <a href="#none" class="link_opt" data-value="${index}" data-option-type="${item.optionType}" data-id="${item.id}" data-display-goods-id="${item.displayGoodsId}" data-goods-option-id="${item.goodsOptionId}" data-name="${item.name}" data-name-en="${item.nameEn}">\
          <span class="tit_option">${isEn ? item.nameEn : item.name} ${item.isDiscountPeriod ? isEn ? "(Sale)" : "(할인)" : ""} ${item.isSoldOut ? isEn ? "(Sold Out)" : "(품절)" : ""}</span>\
          <span class="info_option">\
            <span class="${item.foreigndeliCheck > 0 ? "ico_newfriends_v1 ico_delivery" : "ico_newfriends_v1 ico_nodelivery"}"></span>\
            <span class="txt_delivery">${isEn ? "Global shipping" : "글로벌 배송"} ${item.foreigndeliCheck > 0 ? ["가능", "available"][isEn] : ["불가", "not available"][isEn]}</span>\
            <span class="txt_price">\
              <span class="screen_out">${isEn ? "Price" : "금액"}</span>\
              <span class="num_price">\
                <em class="emph_g">${item.salePrice}</em>${isEn ? "KRW" : "원"}\
                <span class="usd_price">(${item.exchangePrice} USD)</span>\
              </span>\
            </span>\
          </span>\
        </a>\
      </li>'
    ),
    option: _.template(
      '<li class="${item.isSoldOut ? "item_soldout" : ""}">\
        <a href="#none" class="link_opt" data-value="${index}" data-id="${item.id}" data-goods-id="${item.goodsId}" data-parent-goods-option-id="${item.parentGoodsOptionId}" data-name="${item.name}" data-name-en="${item.nameEn}">\
          <span class="tit_option">${isEn ? item.nameEn : item.name} ${item.isSoldOut ? isEn ? "(Sold Out)" : "(품절)" : ""}</span>\
        </a>\
      </li>'
    ),
    optionWithPrice: _.template(
      '<li class="${item.isSoldOut ? "item_soldout" : ""}">\
        <a href="#none" class="link_opt" data-value="${index}" data-id="${item.id}" data-goods-id="${item.goodsId}" data-parent-goods-option-id="${item.parentGoodsOptionId}" data-name="${item.name}" data-name-en="${item.nameEn}">\
          <span class="tit_option">${isEn ? item.nameEn : item.name} ${item.isSoldOut ? isEn ? "(Sold Out)" : "(품절)" : ""}</span>\
          <span class="info_option">\
            <span class="${item.prForeigndeliyn !== "N" ? "ico_newfriends_v1 ico_delivery" : "ico_newfriends_v1 ico_nodelivery"}"></span>\
            <span class="txt_delivery">${isEn ? "Global shipping" : "글로벌 배송"} ${item.prForeigndeliyn !== "N" ? ["가능", "available"][isEn] : ["불가", "not available"][isEn]}</span>\
            <span class="txt_price" style="display: ${item.salePrice === "0" ? "none" : "block"}">\
              <span class="screen_out">${isEn ? "Price" : "금액"}</span>\
              <span class="num_price">\
                <em class="emph_g">${item.salePrice}</em>${isEn ? "KRW" : "원"}\
                <span class="usd_price">(${item.exchangePrice} USD)</span>\
              </span>\
            </span>\
          </span>\
        </a>\
      </li>'
    ),
    button: _.template(
      '<a href="#none" class="link_selected" data-toggle>\
        <span class="txt_opt">${text}</span>\
        <span class="screen_out">${isEn ? "Select a product" : "선택됨"}</span>\
        <span class="ico_newfriends_v1 ico_opt"></span>\
      </a>'
    ),
    buttonWithPrice: _.template(
      '<span class="link_selected">\
        <span class="txt_opt">${item[isEn ? "nameEn" : "name"]}</span>\
        <span class="txt_price">\
          <span class="screen_out">${isEn ? "Price" : "금액"}</span>\
          <span class="num_price">\
            <em class="emph_g">${item.salePrice}</em>${isEn ? "KRW" : "원"}\
            <span class="usd_price">(${item.exchangePrice} USD)</span>\
          </span>\
        </span>\
        <span class="screen_out">${isEn ? "Select a product" : "선택됨"}</span>\
      </span>'
    ),
    basketItem: _.template(
      '<li id="${item.id}" data-id="${item.id}" data-prcode="${item.prCode}" data-salePrice="${item.salePrice}" data-exchangePrice="${item.exchangePrice}">\
        <input type="hidden" name="prCode" value="${item.prCode}">\
        <input type="hidden" name="prCodes" value="${item.prCode}">\
        <input type="hidden" name="ctSeq" value="${item.ctseq}">\
        <input type="hidden" name="isGiftBag" value="false">\
        <span class="tit_option">${isEn ? item.nameEn : item.name}</span>\
        <span class="box_quantity">\
          <label class="screen_out" for="prEa">${isEn ? "Quantity" : "수량"}</label>\
          <input type="text" class="inp_quantity" name="prEa" value="${item.qty}">\
          <button type="button" class="btn_g btn_minus" data-qty="-1"><span class="ico_newfriends_v1 ico_minus">${isEn ? "minus" : "빼기"}</span></button>\
          <button type="button" class="btn_g btn_plus" data-qty="1"><span class="ico_newfriends_v1 ico_plus">${isEn ? "plus" : "더하기"}</span></button>\
        </span>\
        <span class="txt_price">\
          <span class="screen_out">${isEn ? "Price" : "금액"}</span>\
          <span class="num_price">\
            <em class="emph_g">${item.salePriceLocale}</em> ${isEn ? "KRW" : "원"}\
            <span class="usd_price">(${item.exchangePrice} USD)</span>\
          </span>\
        </span>\
        <button type="button" class="btn_close" data-remove>\
          <span class="ico_newfriends_v1 ico_close">${isEn ? "Option delete" : "옵션 삭제"}</span>\
        </button>\
      </li>'
    ),
    summaryPrice: _.template(
      '<em class="emph_price">\
        ${salePrice}\
        <span class="txt_won">${isEn ? "KRW" : "원"}\
          <span class="usd_price">(${exchangePrice} USD)</span>\
        </span>\
      </em>'
    ),
    itemPrice: _.template(
      '<span class="num_price">\
        <em class="emph_g">${salePrice}</em>${isEn ? "KRW" : "원"}\
        <span class="usd_price">(${exchangePrice} USD)</span>\
      </span>'
    )
  }

  function toggleSelect(e) {
    e.preventDefault()

    var $target = $(e.currentTarget)
    var $ul = $target.next()
    var $select = $target.parents('.opt_g')

    function hide(e) {
      if (!$select.is(e.target) && !$select.has(e.target).length) {
        $select.removeClass('opt_on')
        $ul.hide()
      }
    }

    if ($select.hasClass('opt_on')) {
      $(document.body).off('click', hide)
    } else {
      $(document.body).on('click', hide)
    }

    $ul.toggle()
    $select.toggleClass('opt_on')
  }

  function onChangeValue() {
    function init(e) {
      e.preventDefault()

      var $target = $(e.currentTarget)
      var $parent = $target.parents('[data-id]')
      var isSoldOut = $parent.hasClass('item_soldout')

      if (isSoldOut) {
        return
      }

      $parent
        .removeClass('opt_on')
        .find('div.box_opt').hide()

      return [$target, $parent]
    }

    function setOptions(args) {
      var $target = args[0]
      var $parent = args[1]

      var options = $target.data()
      var parentData = $parent.data()
      var order = parentData.id
      var category = parentData.category

      var isAdditional = /^sub/g.test(category)
      var depth = isAdditional ? subGoodsOptionDepth : mainGoodsOptionDepth

      var isFirst = order === 0
      var isLast =
        order ===
        (displayGoodsGroup[isAdditional ? 'subGoodsList' : 'mainGoodsList'].length > 1 ? depth : isAdditional ? depth : depth - 1)

      selectedOption[category][order] = options

      if (!isLast) {
        $parent.addClass('opt_selected')
        $parent
          .find('[data-toggle]')
          .find('span.txt_opt')
          .text(options[isEn ? 'nameEn' : 'name'])
      }

      return [order, options, category, isLast, isAdditional, $parent]
    }

    function changeItems(args) {
      var order = args[0]
      var options = args[1]
      var category = args[2]
      var isLast = args[3]
      var isAdditional = args[4]
      var $parent = args[5]
      var appendToBasket$ = _.flow([appendToBasket, computeBasketSummary$])
      var depth = isAdditional ? subGoodsOptionDepth : mainGoodsOptionDepth

      if (isLast) {
        callApi({
          url: '/kr/displayGoods/findProducts',
          method: 'post',
          data: {
            goodsOptionId: options.optionType
              ? options.goodsOptionId
              : options.id
          }
        }).then(function(productDetail) {
          if (productDetail.length === 0) {
            console.error('🚨')
            alertPopup('alert_not_selected')
            return
          }

          var isDiscountPeriod = productDetail[0].isDiscountPeriod
          var product = productDetail[0].product
          var productLevelPrice = productDetail[0].productLevelPrice
          var name = _.chain(selectedOption[isAdditional ? 'subGoodsList' : 'mainGoodsList'])
            .concat(selectedOption[category])
            .filter(Boolean)
            .uniq()
            .map(function(item) {
              return item[isEn ? 'nameEn' : 'name']
            })
            .join(' - ')
            .replace(/-/, '/')

          var item = _.assign({}, options, {
            salePrice: productLevelPrice[isDiscountPeriod ? 'prlpDiscountprice1' : 'prlpSaleprice1'],
            exchangePrice: productLevelPrice[isDiscountPeriod ? 'exchangeDiscountPrice' : 'exchangePrice'],
            prCode: product.prCode,
            name: name,
            nameEn: name
          })
          appendToBasket$(
            item,
            isAdditional
          )
        })
      } else {
        callApi({
          url: '/kr/displayGoods/findByDisplayGoodsIdOption',
          method: 'post',
          data: {
            goodsId: options.optionType ? options.id : options.goodsId,
            parentGoodsOptionId: options.optionType ? 0 : depth === 2 ? options.id : options.parentGoodsOptionId
          }
        }).then(function(data) {
          if (!data || data.length === 0) {
            console.error('🚨')
            alertPopup('alert_not_selected')
            $parent.next().hide()
            return
          }

          render(
            order + 1,
            data,
            isAdditional ? 'subGoodsOptionList' : 'mainGoodsOptionList'
          )
        })
      }
    }

    return _.flow([init, setOptions, changeItems])
  }

  function changeQty() {
    function init(e) {
      var $target = $(e.currentTarget)
      var $parent = $target.parents('[data-id]')
      var $input = $parent.find('[name="prEa"]')
      var isChangeType = e.type === 'change'
      var qty = isChangeType ? parseInt($target.val(), 10) : $target.data('qty')
      var currentValue = parseInt($input.val().toString(), 10)
      var newValue = currentValue + (isChangeType ? 0 : qty) || 1

      return [$input, $parent, newValue]
    }

    function setValue(args) {
      var $input = args[0]
      var $parent = args[1]
      var value = args[2]

      if (value < 1) {
        return false
      }

      $input.val(value)

      return [$parent, value]
    }

    function updatePrice(args) {
      if (!args) {
        return
      }

      var $parent = args[0]
      var qty = args[1]

      var parentData = $parent.data()
      var $price = $parent.find('.num_price')

      var itemPriceHtml = template.itemPrice({
        salePrice: withComma(parentData.saleprice * qty),
        exchangePrice: (parentData.exchangeprice * qty).toFixed(2)
      })

      $price.html(itemPriceHtml)
    }

    return _.flow([init, setValue, updatePrice])
  }

  function removeItem(e) {
    var $target = $(e.target)
    var $parent = $target.parents('[data-id]')
    var isLast = $parent.siblings().length === 0

    if (isLast) {
      flipButton()
    }

    $parent.remove()

    if ($basketItems.is(':empty')) {
      $basketItems.hide()
    }
  }

  function resetBasket(isAdditional) {
    var $target = isAdditional ? $selectAdditional : $selectOptions
    var optionTitleList = isAdditional ? 'subGoodsOptionTitleList' : 'mainGoodsOptionTitleList'

    $target.find('.opt_g[data-id]').each(function(index, select) {
      var $select = $(select)
      var $button = $select.find('[data-toggle]').find('span.txt_opt')
      var optionLabel =
        optionsData[optionTitleList].length && optionsData[optionTitleList][index][isEn ? 'nameEn' : 'name']
      var buttonText = isEn
        ? 'Select a ' + optionLabel
        : optionLabel + ' 을(를) 선택해주세요'

      $select.removeClass('opt_selected')

      if (index > 0) {
        $select.hide()
      }

      $button.text(buttonText)
    })
  }

  function computeBasketSummary() {
    function mapBasketItems() {
      var price = _.map($basketItems.find('[data-id]'), function(item) {
        var $item = $(item)
        var qty = parseInt($item.find('[name="prEa"]').val(), 10)
        var data = $item.data()

        return {
          salePrice: data.saleprice * qty,
          exchangePrice: data.exchangeprice * qty
        }
      })

      return price
    }

    function sumBasketItemsPrice(price) {
      var salePrice = _.sumBy(price, 'salePrice')
      var exchangePrice = _.sumBy(price, 'exchangePrice')

      return {
        salePrice: salePrice,
        exchangePrice: exchangePrice
      }
    }

    function setBasketSummaryHtml(price) {
      var $emphPrice = $('.emph_price[data-saleprice]')
      var emphPriceData = $emphPrice.data()
      var summaryPriceHtml = template.summaryPrice({
        salePrice: price.salePrice
          ? withComma(price.salePrice)
          : emphPriceData.saleprice,
        exchangePrice: price.exchangePrice
          ? price.exchangePrice.toFixed(2)
          : emphPriceData.exchangeprice
      })

      $emphPrice.html(summaryPriceHtml)
    }

    return _.flow([mapBasketItems, sumBasketItemsPrice, setBasketSummaryHtml])
  }

  function appendToBasket(item, isAdditional) {
    var $item = $basketItems.find('#' + item.id)
    var $input = $item.find('input[name="prEa"]')
    var isExist = $item.length

    if (isExist) {
      $input.val(parseInt($input.val().toString(), 10) + 1)
    } else {
      var title = _.chain(selectedOption.mainGoodsOptionList)
        .filter(Boolean)
        .map(function(option) {
          return option[isEn ? 'nameEn' : 'name']
        })
        .join(' - ')

      $basketItems.append(
        template.basketItem({
          item: _.assign(item, {
            title: title,
            qty: 1,
            ctseq: $basketItems.data('ctseq'),
            salePriceLocale: withComma(item.salePrice)
          })
        })
      ).show()

      if ($basketItems.children().length === 1) {
        flipButton()
      }
    }

    resetBasket(isAdditional)
  }

  function render(index, options, category) {
    var isAdditional = /^sub/g.test(category)
    var isOptionType = /OptionList$/g.test(category)
    var $target = isAdditional ? $selectAdditional : $selectOptions
    var $existSelect = $target.find('.opt_g[data-id]').eq(index)
    var isExist = Boolean($existSelect.length)

    var optionsHtml = _.map(options, function(item, index) {
      var compiled = isOptionType
        ? item.salePrice
          ? template.optionWithPrice
          : template.option
        : template.product

      return compiled({
        item: item.salePrice ? _.assign(item, {
          salePrice: withComma(item.isDiscountPeriod ? item.discountPrice : item.salePrice),
          exchangePrice: parseFloat(item.isDiscountPeriod ? item.exchangeDiscountPrice : item.exchangePrice).toFixed(2)
        }) : item,
        index: index,
        isEn: ~~isEn
      })
    }).join('')

    if (isExist) {
      $existSelect
        .show()
        .find('ul.list_opt')
        .html(optionsHtml)
    } else {
      var isFixed = options.length === 1 && !isOptionType && !isAdditional
      var optionLabel = !isFixed &&
        optionsData[
          isAdditional ? 'subGoodsOptionTitleList' : 'mainGoodsOptionTitleList'
        ][index][isEn ? 'nameEn' : 'name']

      var $select = $('<div />', {
        class: 'opt_g' + (isFixed ? ' opt_disabled' : ''),
        'data-category': category
      }).attr(isFixed ? 'data-_id' : 'data-id', index)

      var $label = $('<strong />', {
        class: 'screen_out',
        text: isEn ? 'Select a' + optionLabel : optionLabel + ' 항목 선택'
      })

      var $list = $(
        '<div class="box_opt">\
          <em class="screen_out"></em>\
          <ul class="list_opt"></ul>\
        </div>'
      )
      $list.find('screen_out').text(isEn ? 'select option' : '선택 옵션')
      $list.find('ul.list_opt').html(optionsHtml)

      var buttonHtml = template[isFixed ? 'buttonWithPrice' : 'button']({
        text: isEn
          ? 'Select a ' + optionLabel
          : optionLabel + ' 을(를) 선택해주세요',
        item: options[0]
      })

      if (optionsData.mainGoodsOptionTitleList.length === 0) {
        $selectAdditional.removeClass('opt_addition')
      }

      if (isFixed) {
        selectedOption.mainGoodsList = optionsData.mainGoodsList[0]
      }

      $select.append([$label, buttonHtml, $list])
      $select.appendTo($target.show())
    }
  }

  function handleOpen(e) {
    e.preventDefault()

    var $target = $(e.currentTarget)
    var isGroupOptionVisible = $groupOption.is(':visible')
    var hasMainGoodsList = displayGoodsGroup.mainGoodsList && displayGoodsGroup.mainGoodsList.length

    function hide(e) {
      var isRemoveButton = e.target.className === 'ico_newfriends_v1 ico_close'

      if (!$boxPurchase.is(e.target) && !$boxPurchase.has(e.target).length && !isRemoveButton) {
        $groupOption.hide()
        $dimmedOption.hide()


        // 20181213 이민정
        $boxPurchase.removeClass("purchase_open");

        if (isMatchMedia) {
          $boxPurchase.removeClass('box_option')
        }

        if ($boxPurchase.hasClass('option_close')) {
          $boxPurchase.toggleClass('option_open')
          $boxPurchase.toggleClass('option_close')
        }

        if (!$basketItems.is(':empty')) {
          $btnOptionbar.show()
        } else {
          $btnOptionbar.hide()
        }
      }
    }

    if (!$basketItems.is(':empty')) {
      return
    }

    if (isGroupOptionVisible) {
      if ($target.hasClass('btn_basket') && !$basketItems.is(':empty')) {
        return
      }

      $groupOption.hide()

      if (isMatchMedia) {
        $dimmedOption.hide()
        $boxPurchase.removeClass('box_option')
      }

      $(document.body).off('click', hide)
    } else {
      $(document.body).on('click', hide)

      $groupOption.show()

      if (isMatchMedia) {
        $dimmedOption.show()
        $boxPurchase.addClass('box_option')
      }

      optionsData = _.assign({}, optionsData, displayGoodsGroup)

      if (hasMainGoodsList && hasMainGoodsList > 1) {
        optionsData.mainGoodsOptionTitleList.unshift({
          name: '상품',
          nameEn: 'Product'
        })

        render(0, displayGoodsGroup.mainGoodsList, 'mainGoodsList')
      }

      if (
        displayGoodsGroup.mainGoodsList.length < 2 &&
        displayGoodsGroup.mainGoodsOptionList &&
        displayGoodsGroup.mainGoodsOptionList.length &&
        (displayGoodsGroup.mainGoodsList[0].optionType === '1' ||
          displayGoodsGroup.mainGoodsList[0].optionType === '2')
      ) {
        render(0, displayGoodsGroup.mainGoodsList, 'mainGoodsList')
        render(0, displayGoodsGroup.mainGoodsOptionList, 'mainGoodsOptionList')
      }

      if (displayGoodsGroup.subGoodsList) {
        if (displayGoodsGroup.subGoodsList.length) {
          if (!$selectAdditional.find('[data-id]').length) {
            optionsData.subGoodsOptionTitleList.unshift({
              name: '구성품',
              nameEn: 'Additional'
            })

            render(0, displayGoodsGroup.subGoodsList, 'subGoodsList')
          }
        }
      }
    }
  }

  function toggleGroupPurchase() {
    $groupOption.toggle()
  }

  function main() {
    var changeQty$ = changeQty()
    var changeQtyWithSummary$ = _.flow([changeQty$, computeBasketSummary$])
    var removeItem$ = _.flow([removeItem, computeBasketSummary$])
    var onChangeValue$ = onChangeValue()

    if (isMatchMedia) {
      $boxPurchase.removeClass('box_option')
    }

    $groupPurchase.on('click', 'button.btn_open, button.btn_basket', handleOpen)

    $selectGroup.on('click', '[data-toggle]', toggleSelect)
    $selectGroup.on('click', '[data-value]', onChangeValue$)

    $basketItems.on('click', '[data-qty]', changeQtyWithSummary$)
    $basketItems.on('click', '[data-remove]', removeItem$)
    $basketItems.on('change', '[name="prEa"]', changeQtyWithSummary$)

    $basketItems.on('keydown', preventReturnKey)

    $btnOptionbar.on('click', function() {
      $boxPurchase.toggleClass('option_open')
      $boxPurchase.toggleClass('option_close')

      if (isMatchMedia) {
        $boxPurchase.toggleClass('box_option')
      }

      $groupOption.toggle()
      $dimmedOption.toggle()
    })
  }

  function preventReturnKey(e) {
    if (e.keyCode === 13) {
      return false
    }
  }

  function callApi(options) {
    var mergedOptions = $.extend(
      {
        headers: { 'X-CSRF-TOKEN': X_CSRF_TOKEN },
        dataType: 'json'
      },
      options
    )

    return $.ajax(mergedOptions)
  }

  function withComma(price) {
    return price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')
  }

  function flipButton() {
    var $btnBuy = $groupPurchase.find('.btn_buy')
    var $btnOptn = $groupPurchase.find('.btn_open')

    $btnBuy.toggle()
    $btnOptn.toggle()
  }

  main()
})()
