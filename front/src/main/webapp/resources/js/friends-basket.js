;(function() {
  'use strict'

  var $listBasket = $('.list_basket')
  var $selectGroup = $('[data-select-group]')

  var optionTemplate = _.template(
    '<li class="${item.isSoldOut ? "item_soldout" : ""}">\
      <a href="#none" class="link_opt" data-${item.isSoldOut ? "_value" : "value"}="${index}" data-id="${item.id}" data-goods-id="${item.goodsId}" data-parent-goods-option-id="${item.parentGoodsOptionId}" data-name="${item.name}" data-name-en="${item.nameEn}">\
        <span class="tit_option">${isEn ? item.nameEn : item.name} ${item.isSoldOut ? isEn ? "(Sold Out)" : "(품절)" : ""}</span>\
      </a>\
    </li>'
  )
  var cloneBasket

  function toggleSelect(e) {
    e.preventDefault()

    var $target = $(e.currentTarget)
    var $parent = $target.parents('.opt_g')
    var $ul = $target.next().find('.list_opt')

    function hide(e) {
      if (!$parent.is(e.target) && !$parent.has(e.target).length) {
        $ul.hide()
        $parent.removeClass('opt_on')
      }
    }

    if ($parent.hasClass('opt_on')) {
      $ul.show()
      $(document.body).on('click', hide)
    } else {
      $ul.hide()
      $(document.body).off('click', hide)
    }
  }

  function toggleBasketOption(e) {
    var $target = $(e.currentTarget)
    var $parent = $target.parents('li')
    var $basketOption = $parent.find('.basket_option')
    var $optionSelect = $parent.find('.option_select')
    var isOpened = $basketOption.is(':visible')

    cloneBasket = $basketOption.clone(true)

    $target.find('.ico_arrow').text(isOpened ? '펼치기' : '접기')
    $basketOption.toggle()
    $parent.toggleClass('option_on')
  }

  function onChangeValue() {
    function init(e) {
      e.preventDefault()

      var $target = $(e.currentTarget)
      var $parent = $target.parents('[data-id]')

      $parent.find('ul.list_opt').hide()

      return [$target, $parent]
    }

    function setOptions(args) {
      var $target = args[0]
      var $parent = args[1]
      var $optionSelect = $parent.parents('.option_select')

      var order = $parent.data('id')

      $parent.addClass('opt_selected').removeClass('opt_on')
      $parent
        .find('[data-toggle]')
        .find('span.txt_opt')
        .text($target.text().trim())

      return [order, $target, $optionSelect]
    }

    function changeItems(args) {
      var order = args[0]
      var $target = args[1]
      var $optionSelect = args[2]
      var data = $target.data()
      var optionData = $optionSelect.data()
      var bsSeq = optionData.bsSeq
      var isLast = order + 1 === optionData.optionsLength
      var displayGoodsId = $('[data-display-goods-id]').data('displayGoodsId')

      if (isLast) {
        callApi({
          url: '/kr/displayGoods/findProducts',
          method: 'post',
          data: {
            goodsOptionId: data.id
          }
        }).then(function(productDetail) {
          if (productDetail.length === 0) {
            console.error('🚨')
            return
          }

          var $btnChange = $optionSelect
            .parents('.basket_option')
            .find('[data-ctseq]')
          var prevPrCode = $btnChange.val()
          var prCode = productDetail[0].product.prCode

          $btnChange
            .data('goodsId', displayGoodsId)
            .data('isDiff', prevPrCode !== prCode)
            .val(prCode)
        })
      } else {
        callApi({
          url: '/kr/displayGoods/findByDisplayGoodsIdOption',
          method: 'post',
          data: {
            goodsId: data.goodsId,
            parentGoodsOptionId: data.id || 0
          }
        }).then(function(options) {
          if (options.length === 0) {
            console.error('🚨')
            return
          }

          render(order + 1, options, $optionSelect)
        })
      }
    }

    return _.flow([init, setOptions, changeItems])
  }

  function render(index, options, target) {
    var $target = target
    var $options = $target.find('.opt_g[data-id]').eq(index)

    var isFirst = index === 0

    var optionsHtml = _.map(options, function(item, index) {
      return optionTemplate({ item: item, index: index })
    }).join('')

    $options.find('.txt_opt').text($options.data('label'))

    $options
      .show()
      .find('ul.list_opt')
      .html(optionsHtml)
  }

  function resetBasketOption(e) {
    var $target = $(e.currentTarget)
    var $parent = $target.parents('.basket_option')

    $parent.replaceWith(cloneBasket)
    $parent.hide()
  }

  function updateBasket(e) {
    var $target = $(e.currentTarget)
    var $parent = $target.parents('li')
    var $prCodes = $parent.find('[name="prCodes"]')

    var id = $target.val()

    $prCodes.val(id)
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

  function changeQtyWithSummary(e) {
    var $target = $(e.currentTarget)
    var $parent = $target.parents('.option_info')

    var $krw = $parent.find('.emph_g')
    var $usd = $parent.find('.usd_price')
    var $qty = $parent.find('.inp_quantity')

    var krw = $krw.data('price')
    var usd = $usd.data('price')
    var qty = parseInt($qty.val(), 10)

    $krw.text(withComma(krw * qty))
    $usd.text('(' + (usd * qty).toFixed(2) + ' USD)')
  }

  function main() {
    var onChangeValue$ = onChangeValue()

    $selectGroup.on('click', '[data-toggle]', toggleSelect)
    $selectGroup.on('click', '[data-value]', onChangeValue$)

    $listBasket.on('click', '.btn_option', toggleBasketOption)
    $listBasket.on('click', '.btn_cancel', resetBasketOption)
    $listBasket.on('click', '[data-ctseq]', updateBasket)

    $listBasket.on('keydown', preventReturnKey)

    $listBasket.on('click', '.btn_g', changeQtyWithSummary)
    $listBasket.on('change', '.inp_quantity', changeQtyWithSummary)
  }

  main()
})()
