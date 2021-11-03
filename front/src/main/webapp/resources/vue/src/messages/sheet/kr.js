import { order_validate_kr } from '../common/validations'

export default {
  common: {
    krw: '원',
    ok: '확인',
    cancel: '취소',
    out_of_stock_global: '현재 글로벌 배송 재고가 부족합니다.<br>구매에 불편을 드려 죄송합니다.',
    input_necessary: '필수입력',
    selected: '선택됨',
    select_option: '선택 옵션'
  },
  cart: {
    title: '01 주문상품',
    price: '금액',
    option: '옵션',
    quantity: '수량',
    decrease: '빼기',
    increase: '더하기',
    ok: '변경',
    ea: '개',
    total_items: '상품가',
    price_item: '상품가',
    price_delivery: '배송비',
    price_total: '총합',
    not_eligible_global: '글로벌 배송 불가 상품입니다',
    is_soldout: '품절된 상품입니다',
    out_of_stock: '재고가 부족합니다.',
    out_of_stock_currently: [
      '{names} 상품의 재고가 부족합니다.',
      '요청하신 상품 중 재고가 부족한 상품이 있습니다.'
    ],
    min_quantity: '수량은 0 으로 변경하실 수 없습니다.',
    purchase_exceeded:
      '구매 가능 수량을 초과하였습니다. 기프트백은 다른 상품과 함께 구매 상품 개수만큼 구매하실 수 있습니다.'
  },
  discount: {
    title: '포인트 / 쿠폰 입력',
    notice: '알림',
    information: '안내사항',
    coupon: {
      title: '쿠폰',
      available_coupon: '사용이 가능 한 쿠폰',
      search: '검색'
    },
    coupon_list: {
      title: '할인 쿠폰 선택',
      overlap_discount: '중복 할인',
      not_applicable: '적용 안함',
      discount_coupon: '할인 쿠폰',
      all: '전상품',
      regular_discount: '일반 할인',
      category: '카테고리',
      discounted_price: '할인 금액'
    },
    coupon_selected: {
      discount: '할인',
      coupon_name: '쿠폰명',
      purchase_over: '{price} 원 이상 구매시',
      no_limit: '금액 제한없음',
      freeshipping: '배송비',
      coupon_delete: '쿠폰 삭제',
      category: '카테고리',
      discount_subject: '할인대상',
      expiration_date: '유효기간'
    },
    point: {
      title: '포인트 / 쿠폰 입력',
      earn_points: '현재 적립된 포인트',
      available_points: '사용 가능 포인트',
      enter_points: '포인트 입력',
      apply: '적용',
      at_least_point: '포인트는 3,000포인트 부터 결제 시 사용이 가능합니다',
      at_least_price:
        '쿠폰/포인트 사용 시 최소 결제 금액인 1,000원 (배송비 제외) 이상 결제하셔야 정상적으로 주문하실 수 있습니다.'
    },
    total: {
      discounted_price: '할인금액',
      coupon: '쿠폰',
      points: '포인트',
      total_discounted: '총 상품 금액'
    },
    note: {
      title: '포인트 및 쿠폰 사용 안내',
      cautions: [
        '포인트/쿠폰 사용 시 부분 반품 및 부분 환불이 불가합니다. <br class="rw_hide">(현재 시스템의 제약으로 부분 반품을 원하시는 경우 전체 반품 후 재구매 부탁드립니다.)',
        '포인트는 상품구매 시에만 사용 가능하며, 배송비는 포인트로 지급하실 수 없습니다.',
        '포인트와 쿠폰은 해당 금액 이상 주문 시 사용하실 수 있습니다. <br class="rw_hide">(쿠폰 금액은 나누어 사용하실 수 없습니다.)',
        '포인트/쿠폰 사용 시 최소 결제 금액은 1,000원 (배송비 제외)입니다. 1,000원 이상 결제하셔야 정상적으로 주문하실 수 있습니다.',
        '중복 쿠폰과 일반 쿠폰은 함께 사용하실 수 있습니다. <br class="rw_hide">(단, 같은 항목 쿠폰은 동시 적용 불가합니다.)',
        '배송비 쿠폰은 배송 상품에 한하여 사용하실 수 있습니다.',
        '할인 쿠폰 적용 시 포인트 적립금과 결제수단 설정이 변경될 수 있습니다. 쿠폰 적용 후 설정하신 결제수단 정보를 확인해 주세요.',
        '포인트/쿠폰 금액은 원화 기준으로 적용 및 지급됩니다.',
        '구매 취소 시 취소/환불 규정에 따라 포인트 및 쿠폰이 회수될 수 있습니다.',
        '주문 시 사용한 포인트/쿠폰의 유효기간이 남아 있는 경우, 주문 취소 및 반품 후 재사용이 가능한 상태로 변경됩니다. <br class="rw_hide">(단, 반품 시 주문상태가 반품완료일 때 변경됩니다.)',
        '포인트/쿠폰 악용 사례를 주기적으로 조사하고 있으며, 리셀러의 경우 회원 박탈 및 피해 보상 청구 등 법적 조치가 진행될 수 있습니다.',
        '일부 상품은 포인트/쿠폰 적용 대상에서 제외될 수 있습니다.'
      ]
    }
  },
  fields: {
    name: {
      label: '이름',
      placeholder: '이름'
    },
    phone: {
      label_cell: '휴대전화(숫자만 입력해 주세요)',
      label_phone: '전화번호(숫자만 입력해 주세요)'
    },
    countries: {
      label: '국가 항목 선택'
    }
  },
  buyer: {
    title: '주문고객',
    email: {
      label: '아이디 (이메일) 입력',
      input_directly: '직접입력',
      select_email: '이메일 항목 선택'
    }
  },
  agree_payinfo: {
    title: '결제 정보',
    basket: {
      title: '상품 금액'
    },
    delivery: {
      title: '배송비'
    },
    discount: {
      title: '할인 금액 (추가내용 쿠폰+포인트)'
    },
    total: {
      title: '총 결제금액'
    }
  },
  agree_checkbox: {
    title: '약관 동의',
    agree: '동의',
    details: '자세히보기',
    agree_list: [
      '아래 내용에 모두 동의합니다.',
      '상품 주문 및 배송정보 수집에 동의합니다.',
      '주문할 상품설명에 명시된 내용과 사용조건을 확인하였으며, 취소 환불규정에 동의합니다.'
    ],
    required: '필수'
  },
  agree_detail: {
    title: '개인정보 수집 및 이용안내 <br class="rw_hide">(배송정보 수집 시)',
    caption: '개인정보 수집 및 이용안내 (배송정보 수집 시)',
    th: ['구분', '필수항목'],
    tr: [
      ['목적', '상품 주문 배송 및 고객 문의 대응'],
      ['항목', '이름, 이메일주소, 휴대폰번호, 주소'],
      [
        '보유 및 이용기간',
        '배송완료 후 3개월 후 삭제 <br>(단, 법령에서 일정기간 보관을 요구하는 경우 5년간 보관 후 파기)'
      ]
    ],
    desc:
      '서비스 이용을 위해 제공되는 정보입니다. 개인 정보 제공에 동의하지 않을 수 있으며, 동의하지 않는 경우 서비스 이용이 제한될 수 있습니다.'
  },
  order_form: {
    legend: '주문하기 양식'
  },
  order_pay_method: {
    title: '결제 수단',
    kakaopay: '카카오페이',
    credit_card: '신용카드',
    caution: {
      refund: {
        title: '부분 반품 신청이 되지 않아요! (해외카드 결제)',
        desc:
          '해외카드로 결제하시는 경우 부분 결제 취소가 불가합니다. <br> 따라서, 해외카드로 국내 배송 주문을 하실 때에는 부분 반품이 되지 않습니다. 구매 시 참고해주세요.'
      },
      currency: {
        title: '결제 수단별로 기준 통화가 달라 최종 결제액에 차이가 날 수 있습니다.',
        desc: '신용카드 : KRW 기준 | 페이팔 : USD 기준'
      },
      global: {
        title: '주문 전 꼭 확인하세요!',
        desc: [
          '현재 고객님께서 신청하신 배송은 글로벌 배송으로, <em>“주문접수”</em> 인 상태에서만 구매 취소가 가능합니다. 이후 배송단계부터는 교환/취소/반품이 불가함을 원칙으로 하되, 상품에 원시적인 하자가 있어 회사가 승인하는 경우에만 교환이 가능합니다.<br> 상품의 원시적 하자에 따른 교환을 요청하시려면 객관적 증빙 자료를 바탕으로 1:1 문의 게시판 또는 이메일(global@kakaofriends.com)로 연락주시기 바랍니다.',
          '해외 통관 거부, 주소지 불명, 수취인 거부에 따른 반송은 구매자 귀책으로 간주하여 이로 인하여 발생하는 추가 배송비는 고객님께서 부담하셔야 합니다. 또한 글로벌 배송 서비스 이용시 배송 국가에 따라 발생 할 수 있는 관세 및 각종 세금 등 기타 비용은 수취인이 부담하여야 합니다.'
        ]
      }
    }
  },
  order_submit: {
    check_out: '결제하기',
    cancel_payment: '결제가 취소되었습니다.'
  },
  order_validate: order_validate_kr,
  shipping: {
    header: {
      title: '받으시는 분',
      recent: '최근배송지'
    },
    address: {
      zip_code: 'Zip 코드',
      postal: '우편번호',
      addr1: '주소를 입력해주세요',
      addr2: '상세주소를 입력해주세요.',
      city: 'City (영어로만 입력해주세요)',
      street: 'Street (영어로만 입력해주세요)',
      state: 'State / Province (영어로만 입력해주세요)',
      select_us_state: '미국 주코드 선택'
    },
    save: {
      label: '기본 배송지로 저장'
    },
    guide: {
      ko:
        '주소, 상세주소 및 배송메모 작성 시 특수문자 &amp; &lt; &gt; &#59; 는 제외하고 입력해 주시기 바랍니다.',
      en:
        '주소, 상세주소 및 배송메모 작성 시 특수문자 &amp; &lt; &gt; &#59; 는 제외하고 영문으로 입력해 주시기 바랍니다.'
    },
    history: {
      title: '최근 배송지 선택',
      legend: '배송지 선택',
      phone: '연락처',
      address: '주소',
      select_up: '배송지 선택은 최근 배송된 3개 주소지까지 선택 가능합니다.',
      empty: '이전 주문내역이 없습니다'
    },
    memo: {
      label: '배송메모',
      max: '50자',
      placeholder: '주소록 작성란이 아닙니다. \n배송 메모만 50자 이내로 작성해주세요.'
    },
    type: {
      label: {
        default: '기본 배송지',
        new: '새로운 배송지'
      }
    }
  },
  shipping_info: {
    title: '배송비 정보',
    total_boxes: '위 상품은 총 <em>{boxes}개</em>의 박스로 글로벌 배송됩니다',
    box: '배송박스',
    weight: '중량',
    price: '배송비',
    total_shipping: '총 배송비',
    information: '유의사항',
    information_list: [
      '글로벌 배송비는 상품 무게와 배송 박스 무게를 합산하여 책정합니다.',
      '주문하신 상품 부피에 따라 1개의 주문건을 1박스로 포장할 수 없는 경우 박스가 추가됩니다.'
    ]
  }
}
