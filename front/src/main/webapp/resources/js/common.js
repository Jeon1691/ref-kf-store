(function () {
  $.ajaxSetup({
    dataFilter: function (data, type) {
      if (type === 'html') {
        var $data = $(data)
        var isSignIn = $data.find('.cont_login').length

        if (isSignIn) {
          window.location.href = '/signin?sessionExpired=true'
          return
        }
      }

      return data
    }
  })
})()

function mapRendering (maps) {
  for (var idx in maps) {
    var container = document.getElementById('map' + maps[idx].stSeq)
    var options = { center: new daum.maps.LatLng(maps[idx].stMapx, maps[idx].stMapy), level: 3 }
    var map = new daum.maps.Map(container, options)
    var markerPosition = new daum.maps.LatLng(maps[idx].stMapx, maps[idx].stMapy)
    var marker = new daum.maps.Marker({ position: markerPosition })
    marker.setMap(map)
    map.setZoomable(false)
  }
}

function commonPopup (url, callback) {
  $('.dimmed_layer').show()
  $('.dimmed_layer').load(url, function (response, status, xhr) {
    if (status === 'error') {
      return $('.dimmed_layer').hide();
    }

    callback && callback();
  })
}

function alertNoti (messageCode) {
  commonPopup('/popup/noti?messageCode=' + messageCode)
}

function alertNoti (messageCode, returnUrl) {
  commonPopup('/popup/noti?messageCode=' + messageCode + '&returnUrl=' + returnUrl)
}

function alertPopup (popupMessage) {
  commonPopup('/popup/alert?popupMessage=' + popupMessage)
}

function confirmPopup (popupMessage, returnUrl) {
  commonPopup('/popup/confirm?popupMessage=' + popupMessage + '&returnUrl=' + returnUrl)
}

function provisionPopup (provisionCode) {
  commonPopup('/popup/provision/' + provisionCode)
}

function popupCenter () {
  var ua = window.navigator.userAgent
  if (ua.indexOf('Chrome') != -1) {
    dTop = document.body.scrollTop
  } else if (($('html').hasClass('iphone')) || ($('html').hasClass('ipad'))) {
    dTop = document.body.scrollTop
  } else {
    dTop = document.documentElement.scrollTop
  }
  $('html, body').scrollTop(dTop)
  var wHeight = $(window).height()
  var height = $('.friends_layer').height()
  var top = (wHeight - height) / 2 + dTop
  $('.friends_layer').css('top', top + 'px')
}

function sideClose () {
  $('.side_menu').removeClass('navi_on')
  $('.side_menu').css('left', '-1000px')
  $('#mFeature').css('z-index', -1)
  $('html').removeClass('lock_on')
}

function dimmedHeight () {
  var maskHeight = $(document).height()
  $('.dimmed_layer').css('height', maskHeight)
}

function globalNationPopup () {
  commonPopup('/popup/globalNation')
  sideClose()
  dimmedHeight()
}

function orderAlertPopup () {
  commonPopup('/popup/orderAlert')
  sideClose()
  dimmedHeight()
}

function orderInfoPopup () {
  commonPopup('/popup/orderInfo')
  sideClose()
  dimmedHeight()
}

function loginPopup () {
  commonPopup('/popup/login')
  sideClose()
  dimmedHeight()
}

function basketPopup () {
  commonPopup('/popup/basket')
}

function intPopup () {
  commonPopup('/popup/int')
}

function privacyWritePopup () {
  commonPopup('/popup/privacywrite')
}

function privacyOrderPopup (privacyType) {
  commonPopup('/popup/privacyorder/' + privacyType)
}

function orderAttentionPopup () {
  commonPopup('/popup/orderAttention')
}

function nonMemberPopup () {
  commonPopup('/popup/nonmember')
  sideClose()
  dimmedHeight()
}

function orderCancelPopup (popupMessage, orderNumber, returnUrl) {
  commonPopup('/popup/orderCancel?popupMessage=' + popupMessage + '&orderNumber=' + orderNumber + '&returnUrl=' + returnUrl)
}

function orderReturnAllPopup (popupMessage, orderNumber, returnUrl) {
  commonPopup('/popup/orderReturnAll?popupMessage=' + popupMessage + '&orderNumber=' + orderNumber + '&returnUrl=' + returnUrl)
}

function orderPurchaseFinalizedPopup (popupMessage, orderNumber, orderSubSequence, returnUrl) {
  $('.dimmed_layer').show()
  $('.dimmed_layer').
    load(
      '/popup/orderPurchaseFinalized?popupMessage=' + popupMessage + '&orderNumber=' + orderNumber + '&orderSubSequence=' + orderSubSequence + '&returnUrl=' +
      returnUrl)
}

function orderExchangeReturnPopup (popupMessage, orderNumber, orderSubSequence, returnUrl) {
  $('.dimmed_layer').show()
  $('.dimmed_layer').
    load('/popup/orderExchangeReturn?popupMessage=' + popupMessage + '&orderNumber=' + orderNumber + '&orderSubSequence=' + orderSubSequence + '&returnUrl=' +
      returnUrl)
}

function nonPaymentlPopup () {
  commonPopup('/popup/nonpayment')
}

function deliveryAddressPopup () {
  commonPopup('/popup/deliveryaddress')
}

function globalShipSearchPopup (boxNum) {
  commonPopup('/popup/globalShipSearch/' + boxNum)
}

function globalShipTrackingPopup (orderNumber) {
  commonPopup('/popup/globalShipTracking/' + orderNumber)
}

function shippingInQueryNewWindowPopup (url, deliNum) {
  window.open(url + deliNum, 'window',
    'width=800, height=600, toolbar=no, location=no, directories=no, status=no, menubar=no, resizable=yes, scrollbars=yes, copyhistory=no')
}

function myPagePopup (popupMessage, returnUrl) {
  commonPopup('/popup/myPage?popupMessage=' + popupMessage + '&returnUrl=' + returnUrl)
}

function couponPopup () {
  commonPopup('/popup/coupon', $('#orderCoupon').serialize())
}

function payonlyPopup () {
  commonPopup('/popup/payonly')
}

function benefitPopup (callback) {
  commonPopup('/popup/benefit', callback);
}

/** 2017.11.04 Breeze
 * Text에 타이핑 할 때, Label에 Class 추가(혹은 삭제)
 * @param element
 */
function toggleLabel (element, className) {
  var label = $('label[for="' + $(element).attr('id') + '"]')
  if ($(element).val().length > 0) {
    label.addClass(className)
  } else {
    label.removeClass(className)
  }
}

/**
 * 숫자 앞에 자릿수만큼 0 채우기
 * @param n
 * @param digits
 * @returns {string}
 */
function pullZero (n, digits) {
  var zero = ''
  n = n.toString()

  if (n.length < digits) {
    for (var i = 0; i < digits - n.length; i++)
      zero += '0'
  }
  return zero + n
}

// input에 숫자만 입력될 수 있도록 함
function onlyNumber () {
  if ((event.keyCode < 48) || (event.keyCode > 57))
    event.returnValue = false
}

/**
 * 시간을 초로 변환
 * @param time
 * @returns {number}
 */
function timeToSeconds (time) {
  time = time.split(/:/)
  if (time.length == 2) {
    // 분:초만 있을 경우
    return parseInt(time[0]) * 60 + parseInt(time[1])
  } else if (time.length == 3) {
    // 시:분:초 다 있을 경우
    return parseInt(time[0]) * 3600 + parseInt(time[1]) * 60 + parseInt(time[2])
  }
}

/**
 * 초를 시간으로 변환
 * @param sec
 * @returns {string}
 */
function secondsToTime (sec) {
  var hour = parseInt(sec / 3600)
  sec = sec % 3600
  var min = parseInt(sec / 60)
  sec = sec % 60

  if (hour == 0) {
    return pullZero(min, 2) + ':' + pullZero(sec, 2)
  } else {
    return hour + ':' + pullZero(min, 0) + ':' + pullZero(sec, 0)
  }
}