var memberCardNo;

$('.membership_point .point_section .txt_point .txt_point_numbers').html(availablePoint);
$('.txt_point .point').html(availablePoint);

// 메뉴 열 때 포인트 확인 및 업데이트
$(".link_navi").on('click', function() {
  $.ajax({
    headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
    url: '/membership/barcode',
    type: "GET",
    success: function (data) {
      if (data.error) {
        return;
      }

      var pointNumbers = numberWithCommas(data.point.availablePoint);

      $('.membership_point .point_section .txt_point .txt_point_numbers').html(pointNumbers);
      $('.txt_point .point').html(pointNumbers);
    }
  });
});

function showBarcode(event) {
  $.ajax({
    headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
    url: '/membership/barcode',
    type: "GET",
    success: function (data) {
      if (data.error) {
        hideBarcode();
        return alert(data.error);
      }
      var pointNumbers = numberWithCommas(data.point.availablePoint);

      $('.membership_point .point_section .txt_point .txt_point_numbers').html(pointNumbers);
      $('.txt_point .point').html(pointNumbers);

      // TODO : 테스트용 바코
      // data.memberCardNo = '2015100000000064';

      // TODO: IE 에서 확인 필요
      if (data.memberCardNo.startsWith('BARCODE')) {
        // return alert('맴버십 가입 이후에 사용할 수 있습니다.');
        if(confirm('맴버십 가입 이후에 사용할 수 있습니다. 가입 화면으로 이동하시겠습니까?')) {
          if (syncPlusFriendUrl) {
            return window.location.href = syncPlusFriendUrl ;
          }

          return alert('가입 화면으로 이동하는데 실패했습니다.');
        }

        return;
      }

      if (memberCardNo !== data.memberCardNo) {
        memberCardNo = data.memberCardNo;
        $('.img_barcode .lds-ellipsis').remove();

        if (!$('.img_barcode svg').length) {
          $('.img_barcode').append('<svg></svg>');
        }

        JsBarcode && JsBarcode('.img_barcode svg', memberCardNo, {
          format: 'CODE128',
          width: 3,
          height: 70,
          displayValue: true,
          textMargin: 10
        });
      }

      $('.membership_barcode').css({display: 'block'});
      setTimeout(function () {
        $('.link_cart, .link_lang').hide();
        $('.membership_barcode .barcode_inner').css({bottom: 0});
        $('.membership_barcode .barcode_dim').css({opacity: 1});
      }, 100);
      setTimeout(function() {
        $('.membership_barcode_gnb').show();
      }, 600);
    },
    error: function (jqXHR, textStatus, errorThrown) {
      hideBarcode();
      alert('서버와의 통신에 실패했습니다.');
    }
  });
}

function hideBarcode(event, hideMenu) {
  $('.membership_barcode_gnb').hide();
  $('.membership_barcode .barcode_inner').css({bottom: '100%'});
  $('.membership_barcode .barcode_dim').css({opacity: 0});
  setTimeout(function () {
    $('.link_cart, .link_lang').show();

    if (hideMenu) {
      $(".side_menu").animate({left: "-100%"}, 300);
      $(".side_menu").removeClass("navi_on");
      $(".side_menu").css("display", "none");
      $("#kakaoHead").css("z-index", 120);
      $("#mFeature").css("z-index", -1);
      $("html").removeClass("lock_on");
    }
  }, 100);
  setTimeout(function () {
    $('.membership_barcode').css({display: 'none'});
  }, 500);
}

$('.barcode_section button').on('click', showBarcode);
$('.membership_close, .membership_x, .inner_head .link_navi').on('click', hideBarcode);