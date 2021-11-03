if (!String.prototype.startsWith) {
  String.prototype.startsWith = function(search, pos) {
    return this.substr(!pos || pos < 0 ? 0 : +pos, search.length) === search;
  };
}

if (!String.prototype.endsWith) {
  String.prototype.endsWith = function(searchString, position) {
    var subjectString = this.toString();
    if (typeof position !== 'number' || !isFinite(position) || Math.floor(position) !== position || position > subjectString.length) {
      position = subjectString.length;
    }
    position -= searchString.length;
    var lastIndex = subjectString.indexOf(searchString, position);
    return lastIndex !== -1 && lastIndex === position;
  };
}

function isMobile() {
  return window.matchMedia("(max-width:768px)").matches;
}

function isMain() {
  return window.location.pathname.indexOf("kr/index") > -1 ||
    window.location.pathname.indexOf("en/index") > -1;
}

function isPromotion() {
  return window.location.pathname.indexOf("promotion") > -1;
}

function isCategory() {
  return window.location.pathname.indexOf("categories") > -1;
}

function isBasket() {
  return window.location.pathname.indexOf("basket") > -1;
}

$(document).ready(function($) {
  function Velocity() {
    this.positionQueue = [];
    this.timeQueue = [];
  }

  Velocity.prototype.reset = function() {
    this.positionQueue.splice(0);
    this.timeQueue.splice(0);
  };

  Velocity.prototype.pruneQueue = function(ms) {
    //pull old values off of the queue
    while (this.timeQueue.length && this.timeQueue[0] < Date.now() - ms) {
      this.timeQueue.shift();
      this.positionQueue.shift();
    }
  };

  Velocity.prototype.updatePosition = function(position) {
    this.positionQueue.push(position);
    this.timeQueue.push(Date.now());
    this.pruneQueue(50);
  };

  Velocity.prototype.getVelocity = function() {
    this.pruneQueue(1000);

    var length = this.timeQueue.length;

    if (length < 2) return 0;

    var distance = this.positionQueue[length - 1] - this.positionQueue[0],
      time = (this.timeQueue[length - 1] - this.timeQueue[0]) / 1000;

    return distance / time;
  };

  var velocity = new Velocity();
  var mainSlideCount = $(".slide_friends .slide_pannel").length || 0;
  var initialPageIndicatorWidth = 1 / mainSlideCount * 100 + "%";


  $(".main-slide-indicator").width(initialPageIndicatorWidth);

  // slick 슬라이드
  function slickSlide(selector, slickArrow, slickFade, slickAuto) {
    var slickArrow = true;
    var slickFade = true;

    if ($("#kakaoContent").hasClass("cont_brand") == true) {
      slickFade = false;
    } else {
      slickFade = true;
    }

    $(selector).slick({
      useTimeout: !isMobile(),
      speed: isMobile() ? 300 : 500,
      autoplay: slickAuto,
      // autoplay: isMobile ? false : slickAuto,
      autoplaySpeed: 2500,
      infinite: true,
      arrows: slickArrow,
      fade: isMobile() ? false : slickFade,
      dots: true,
      cssEase: "linear",
      prevArrow:
        '<button type="button" class="btn_slide btn_prev"><span class="ico_newfriends_v1 ico_prev">이전</span></button>',
      nextArrow:
        '<button type="button" class="btn_slide btn_next"><span class="ico_newfriends_v1 ico_next">다음</span></button>',
      customPaging: function(slider, i) {
        return (
          '<button type="button" class="btn_paging">' +
          '<span class="ico_paging">' +
          (i + 1) +
          "</span>" +
          "</button>"
        );
      },
      selector: selector,
      touchThreshold: 9,
      waitForAnimate: false,
      mobileFirst: true,
      swipeToSlide: true
    });
  }

  slickSlide(".slide_friends", true, true, true);
  slickSlide(".slide_recent", false, true, true);
  $(".slick-dots").wrap($('<div class="paging_comm">')); // 페이징을 .paging_comm 으로 감싸기

  function pageSet() {
    $(".slick-dots li")
      .siblings()
      .children()
      .remove(".screen_out"); // 현재페이지 텍스트 쌓이지 않도록 함

    if ($(".slick-dots li").hasClass("slick-active") == true) {
      $("li.slick-active").prepend(
        $('<strong class="screen_out" />').text("현재 페이지")
      ); // .slick-active에 현재 페이지 텍스트 넣기
    }
  }

  pageSet();

  var direction;
  var swipeMoved = false;
  var $swipeSlide;

  function getVwValue(ratio) {
    var initialLeft = 5.3;
    var vpWidth = $(window).width();
    var v = velocity.getVelocity();
    var absVel = Math.abs(v);
    var vel = (absVel > 500 ? 500 : absVel) * (v > 0 ? 1 : -1);

    return initialLeft - parseFloat(vel / vpWidth) * ratio + "vw";
  }

  function moveTexts() {
    var $active = $(".slick-slide.slick-active");
    var $prev = $active.prev();
    var $next = $active.next();
    var $text1 = $([
      $prev.find(".main-slide-text-1"),
      $next.find(".main-slide-text-1")
    ]);
    var $text2 = $([
      $prev.find(".main-slide-text-2"),
      $next.find(".main-slide-text-2")
    ]);

    $text1.each(function() {
      $(this)
        .css({
          transition: "transform .1s linear",
          transform: "translate3d(" + getVwValue(40) + ", 0, 0)"
        })
        .off("transitionend")
        .one("transitionend", function() {
          $(this).css({
            transition: "transform .5s ease", // cubic-bezier(0.175, 0.885, 0.3, 1.2)',
            transform: "translate3d(5.3vw, 0, 0)"
          });
        });
    });

    $text2.each(function() {
      $(this)
        .css({
          transition: "transform .1s linear",
          transform: "translate3d(" + getVwValue(60) + ", 0, 0)"
        })
        .off("transitionend")
        .one("transitionend", function() {
          $(this).css({
            transition: "transform .6s ease", // cubic-bezier(0.175, 0.885, 0.3, 1.2)',
            transform: "translate3d(5.3vw, 0, 0)"
          });
        });
    });
  }

  $(".slick-slider")
    .on("beforeChange", function(event, slick, currentSlide, nextSlide) {
      var totalSlide = slick.$slides.length;
      var currentSlide = nextSlide + 1;
      var indicatorWidth = currentSlide / totalSlide * 100 + "%";

      $(".main-slide-indicator").width(indicatorWidth);
    })
    .on("afterChange", function(event, slick) {
      pageSet();
    })
    .on("swipeMove", function(event, slick, delta, posX, curX, originalEvent) {
      direction = delta > 0 ? "right" : "left";
      swipeMoved = true;
      $swipeSlide = slick.$slides.eq(slick.currentSlide).find("a");

      var d = Math.abs(delta) * 0.8 * (delta > 0 ? -1 : 1);

      if (originalEvent !== "touchmove") {
        return;
      }

      velocity.updatePosition(posX);
      moveTexts();
    });

  function hideToast() {
    var $toast = $(".toast");
    var height = $toast.outerHeight(true);

    setTimeout($toast.find("> *").remove, 500);

    return $toast.css({
      transform: "translate3d(0, " + height + "px, 0)",
      opacity: 0
    });
  }

  function showToast() {
    $(".toast").css({
      transform: "translate3d(0, 0, 0)",
      opacity: 1
    });
  }

  function addToast(el) {
    $(".toast").prepend(el);
    showToast();
    setTimeout(function() {
      $(".toast > *").css({ opacity: 1 });
    }, 100);
  }

  function getNotice(text, isBanner) {
    var $notice = $(
      '<div class="notice">' +
        '<div class="header">공지</div>' +
        '<div class="content">' +
        '<a href="customcenter/bnotice/#1">' +
        text +
        "</a>" +
        // '<span class="img_emoticon ico_careers" style="width: 45px;height: 68px;background-position: -339px -99px;"></span>' +
        "</div>" +
        '<div class="close">닫기</div>' +
        "</div>"
    );

    $notice.find(".close").on("click", function() {
      localStorage.setItem("not_show_notice_today", new Date().toDateString());
      hideToast();
    });

    return $notice;
  }

  function getPromotion(text, isBanner) {
    var $notice = $(
      '<p class="promotion_toast">' +
        '<a href="customcenter/bnotice/#1">' +
        text +
        "</a>" +
        // '<span class="img_emoticon ico_careers" style="width: 45px;height: 68px;background-position: -339px -99px;"></span>' +
        '<a href="javascript:;" class="btn_banner_close">닫기</a>' +
        "</p>"
    );

    $notice.find(".btn_banner_close").on("click", function() {
      localStorage.setItem("not_show_notice_today", new Date().toDateString());
      hideToast();
    });

    return $notice;
  }

  function getCartSuccess(message) {
    var $cartSuccess = $(
      '<div class="cart">' +
        '<div class="dot"></div>' +
        '<div class="content">' +
        (message || cartSuccessText) +
        "</div>" +
        "</div>"
    );

    setTimeout(function() {
      $cartSuccess
        .css({
          opacity: 0,
          "margin-bottom": $cartSuccess.outerHeight() * -1 + "px"
        })
        .on("transitionend", function() {
          $cartSuccess.remove();
          $(".toast > *").length || hideToast();
        });
    }, 1500);

    return $cartSuccess;
  }

  function addNotice(text) {
    addToast(getPromotion(text));
  }

  function addCartSuccessToToast(message) {
    $(".toast")
      .css({ display: "flex" })
      .find(".notice, .promotion_toast")
      .remove();
    addToast(getCartSuccess(message));
  }

  function addCartSuccess(message) {
    var y = $(document).scrollTop();

    if (y < 500) {
      hideToast();
      return setTimeout(function() {
        addCartSuccessToToast(message);
      }, 300);
    }

    addCartSuccessToToast(message);
  }

  function addToCartAsync(event, url, urlReplace) {
    $.ajax({
      headers: { "X-CSRF-TOKEN": _csrfToken },
      url: url,
      type: "GET",
      success: function(data) {
        var addedItemCount = parseInt(data, 10);

        if (addedItemCount > 0) {
          var $mainCartNum = $(".wrap_util .link_cart .num_total");
          var $menuCartNum = $(".inner_head .link_navi .num_total");
          var $cartInMenuNum = $(
            ".side_login .list_personal .link_personal .num_total"
          );
          var cartNum = $mainCartNum.length
            ? parseInt($mainCartNum.text(), 10)
            : 0;

          if ($mainCartNum.length) {
            $mainCartNum.text(cartNum + addedItemCount);
          } else {
            $(".wrap_util .link_cart").append(
              '<span class="num_total">' + addedItemCount + "</span>"
            );
          }

          if (kakaotalkAgent) {
            cartNum = $menuCartNum.length
              ? parseInt($menuCartNum.text(), 10)
              : 0;

            if ($menuCartNum.length) {
              $menuCartNum.text(cartNum + addedItemCount);
            } else {
              $(".inner_head .link_navi").append(
                '<span class="num_total">' + addedItemCount + "</span>"
              );
            }
          }

          if ($cartInMenuNum.length) {
            $cartInMenuNum.text(cartNum + addedItemCount);
          } else {
            $(".side_login .list_personal .link_personal .ico_cart")
              .parent()
              .append(
                '<span class="num_total">' + addedItemCount + "</span>"
              );
          }

          $('a[href="' + url + '"]')
            .addClass("on link_cart_on_img")
            .off("click")
            .on("click", function() {
              event && event.preventDefault();
              return false;
            });

          addCartSuccess();

          if (urlReplace && history.replaceState) {
            history.replaceState(null, null, '/' + (language || 'kr') + '/index');
          }
        }
      },
      error: function(jqXHR, textStatus, errorThrown) {
        console.log("error", textStatus, errorThrown);
      }
    });
  }

  function parseQueryString(query) {
    var vars = query.split("&");
    var query_string = {};
    for (var i = 0; i < vars.length; i++) {
      var pair = vars[i].split("=");
      var key = decodeURIComponent(pair[0]);
      var value = decodeURIComponent(pair[1]);
      // If first entry with this name
      if (typeof query_string[key] === "undefined") {
        query_string[key] = decodeURIComponent(value);
        // If second entry with this name
      } else if (typeof query_string[key] === "string") {
        var arr = [query_string[key], decodeURIComponent(value)];
        query_string[key] = arr;
        // If third or later entry with this name
      } else {
        query_string[key].push(decodeURIComponent(value));
      }
    }
    return query_string;
  }

  var queryString = window.location.href.split('?')[1];

  if (queryString) {
    var parsedQs = parseQueryString(queryString);

    if (parsedQs.action && parsedQs.item) {
      switch (parsedQs.action) {
        case 'basket':
          addToCartAsync(null, parsedQs.item, true);
          break;
      }
    }
  }

  $(".item_state a.on").on("click", function(e) {
    e.preventDefault();
    return false;
  });

  $(".item_state a")
    .not(".on")
    .on("click", function(e) {
      e.preventDefault();

      var $this = $(this);
      var url = $this.attr("href");

      if (url.startsWith("/kr/products") || url.startsWith("/en/products") || url.indexOf('_async') < 0) {
        return (location.href = url);
      }

      addToCartAsync(e, url);
    });

  if (isMain() && isMobile()) {
    $(window).on("load", function() {
      var prevY = 0;
      var showNotice = localStorage !== null && typeof localStorage.getItem === 'function' &&
        (localStorage.getItem('not_show_notice_today') !== new Date().toDateString())

      if (noticeText && showNotice) {
        // addNotice(noticeText);
        addNotice(promotionText);
      }

      $(document).on("scroll", function(e) {
        var y = $(this).scrollTop();
        var direction = prevY - y > 0 ? "down" : "up";
        prevY = y;

        // if (direction === 'up') {
        if (y > 500) {
          hideToast();

          // if (isMobile()) {
          //   $(".goto_top").show();
          // }
        }
      });
      $(".inner_head .link_navi").on("click", hideToast);
      $(".toast").on("click", hideToast);
    });
  }

  // 모바일 띠 베너
  $(".banner_page .banner_close").on("click", function() {
    $(".banner_page").hide();

    if (isKakao) {
      $("#kakaoContent").css("margin-top", "50px");
    } else {
      $("#kakaoContent").css("margin-top", "60px");
    }

    localStorage.setItem("not_show_banner_today_mobile", new Date().toDateString());
  });

  if (localStorage !== null && typeof localStorage.getItem === 'function' && localStorage.getItem('not_show_banner_today_mobile') ===
    new Date().toDateString()) {
    $(".banner_page").hide();

    if (isKakao) {
      $("#kakaoContent").css("margin-top", "50px");
    } else {
      $("#kakaoContent").css("margin-top", "60px");
    }

  } else {
    if (isMobile()) {
      var showMobileThinBanner = !(isMain() || isPromotion() || isCategory());

      if (!showMobileThinBanner) {
        if (isKakao) {
          $("#kakaoContent").css("margin-top", "50px");
        } else {
          $("#kakaoContent").css("margin-top", "60px");
        }
      } else {
        $(".banner_page").show();

        if (showMobileThinBanner && isKakao) {
          $("#kakaoContent").css("margin-top", "50px");
        } else {
          $("#kakaoContent").css("margin-top", "95px");
        }
      }
    }
  }

  // 데스크탑 띠 베너
  $(".banner_top .btn_banner_close").on("click", function() {
    $(".banner_top").hide();
    $("#kakaoContent").css("marginTop", "72px");
    $("#kakaoHead").css("top", "0");
    localStorage.setItem("not_show_banner_today", new Date().toDateString());
  });

  if (language === 'en' || (localStorage !== null && typeof localStorage.getItem === 'function' && localStorage.getItem('not_show_banner_today') === new Date().toDateString())) {
    $('.banner_top').hide();
    $("#kakaoContent").css("marginTop", "72px");
    $("#kakaoHead").css("top", "0");
  } else {
    if (!isMobile()) {
      $('.banner_top').show();
      $("#kakaoContent").css("marginTop", "132px");
      $("#kakaoHead").css("top", "60px");
    }
  }

  $("#btn_kakaotalk").on("click", function(e) {
    $.ajax({
      headers: { "X-CSRF-TOKEN": _csrfToken },
      url: "/api/plusfriend/add",
      type: "GET",
      success: function(data) {
        if (data[0].success) {
          console.log("플러스 친구가 되었습니다.");
          addCartSuccess("플러스 친구가 되었습니다.");
        } else {
          console.log("실패하였습니다.");
          addCartSuccess("실패하였습니다.");
        }
      },
      error: function(jqXHR, textStatus, errorThrown) {
        console.log("error", textStatus, errorThrown);
      }
    });
  });

  $("#btn_kakaotalk_login_kr").on("click", function(e) {
      location.href = "/kr/signin";
  });

  $("#btn_kakaotalk_login_en").on("click", function(e) {
      location.href = "/en/signin";
  });
});

$(function() {
  $("img").unveil(300, function() {
    $(this).load(function() {
      // console.log(this);
    });
  });

  $("#tab1").click(function() {
    console.log("tab1");
    $('.slide_main').slick('init');

    $("#tabLayer1").css("display", "block");
    $("#tabLayer2").css("display", "none");
    $("#tabLayer3").css("display", "none");
    $("#tabLayer4").css("display", "none");

    $("#tab1 hr").addClass("on");
    $("#tab2 hr").removeClass("on");
    $("#tab3 hr").removeClass("on");
    $("#tab4 hr").removeClass("on");

    window.requestAnimationFrame(function(){
      $("html, body").animate({ scrollTop: 0 }, 500)
    });
  });
  $("#tab2 a").click(function() {
    console.log("tab2");
    $('.slide_main').slick('slickPause');

    $("#tabLayer1").css("display", "none");
    $("#tabLayer2").css("display", "block");
    $("#tabLayer3").css("display", "none");
    $("#tabLayer4").css("display", "none");

    $("#tab1 hr").removeClass("on");
    $("#tab2 hr").addClass("on");
    $("#tab3 hr").removeClass("on");
    $("#tab4 hr").removeClass("on");
    window.requestAnimationFrame(function(){
      $("html, body").animate({ scrollTop: 0 }, 500)
    });
  });
  $("#tab3 a").click(function() {
    console.log("tab3");
    $('.slide_main').slick('slickPause');

    $("#tabLayer1").css("display", "none");
    $("#tabLayer2").css("display", "none");
    $("#tabLayer3").css("display", "block");
    $("#tabLayer4").css("display", "none");

    $("#tab1 hr").removeClass("on");
    $("#tab2 hr").removeClass("on");
    $("#tab3 hr").addClass("on");
    $("#tab4 hr").removeClass("on");
    window.requestAnimationFrame(function(){
      $("html, body").animate({ scrollTop: 0 }, 500)
    });
  });
  $("#tab4 a").click(function() {
    console.log("tab4");
    $('.slide_main').slick('slickPause');

    $("#tabLayer1").css("display", "none");
    $("#tabLayer2").css("display", "none");
    $("#tabLayer3").css("display", "none");
    $("#tabLayer4").css("display", "block");

    $("#tab1 hr").removeClass("on");
    $("#tab2 hr").removeClass("on");
    $("#tab3 hr").removeClass("on");
    $("#tab4 hr").addClass("on");
    window.requestAnimationFrame(function(){
      $("html, body").animate({ scrollTop: 0 }, 500)
    });
  });
  $("#btn_more_new").click(function() {
    if (!isMobile()) {
      location.href = "https://store.kakaofriends.com" + (language || "kr") + "/products/groups/new";
      return;
    }
    $("#tabLayer1").css("display", "none");
    $("#tabLayer2").css("display", "block");
    $("#tabLayer3").css("display", "none");
    $("#tabLayer4").css("display", "none");

    $("#tab1 hr").removeClass("on");
    $("#tab2 hr").addClass("on");
    $("#tab3 hr").removeClass("on");
    $("#tab4 hr").removeClass("on");
    window.requestAnimationFrame(function(){
      $("html, body").animate({ scrollTop: 0 }, 500)
    });
  });
  $("#btn_more_best").click(function() {
    if (!isMobile()) {
      location.href = "https://store.kakaofriends.com/" + (language || "kr") + "/products/groups/best";
      return;
    }

    $("#tabLayer1").css("display", "none");
    $("#tabLayer2").css("display", "none");
    $("#tabLayer3").css("display", "block");
    $("#tabLayer4").css("display", "none");

    $("#tab1 hr").removeClass("on");
    $("#tab2 hr").removeClass("on");
    $("#tab3 hr").addClass("on");
    $("#tab4 hr").removeClass("on");
    window.requestAnimationFrame(function(){
      $("html, body").animate({ scrollTop: 0 }, 500)
    });
  });

  $(".goto_top").on("click", function(e) {
    e.stopPropagation();
    e.preventDefault();
    if ($(document).scrollTop() > 100) {
      $("html, body").animate({ scrollTop: 0 }, 500);
    }

    return false;
  });
  $(".gotopoint_kr").on("click", function(e) {
    location.href = "/kr/mypage/pointlist";
  })
  $(".gotopoint_en").on("click", function(e) {
    location.href = "/en/mypage/pointlist";
  })

});
