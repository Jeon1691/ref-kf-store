export const order_validate_kr = {
  buyer: {
    name:
      '주문을 위해서 주문자명이 입력되어야 합니다.<br>주문자명은 2-30자 사이 한글/영문만 가능합니다.',
    email: '주문을 위해서 이메일 주소가 입력되어야 합니다.<br>올바른 이메일 주소를 입력해주세요.',
    phone_country:
      '주문을 위해서 국가번호가 입력되어야 합니다.<br>국가번호는 +를 제외한 숫자만 입력해주세요.',
    phone:
      '주문을 위해서 연락처가 입력되어야 합니다.<br>숫자가 포함된 올바른 연락처를 입력해주세요.',
  },
  shipping: {
    name:
      '주문을 위해서 수령자명이 입력되어야 합니다.<br>수령자명은 2-30자 사이 영문만 가능합니다.',
    phone_country:
      '주문을 위해서 국가번호가 입력되어야 합니다.<br>국가번호는 +를 제외한 숫자만 입력해주세요.',
    phone:
      '주문을 위해서 연락처가 입력되어야 합니다.<br>숫자가 포함된 올바른 연락처를 입력해주세요.',
    phone_set:
      '주문을 위해서 연락처가 입력되어야 합니다.<br>숫자, - 가 포함된 올바른 연락처를 입력해주세요.',
    addr1: '주문을 위해서 주소가 입력되어야 합니다.<br>주소는 2-100자 사이로 작성해주세요.',
    addr1_is_alpha: '영문으로만 입력해주세요.',
    addr2: '주문을 위해서 상세주소가 입력되어야 합니다.<br>상세주소는 2-100자 사이로 작성해주세요.',
    addr2_is_not_special_char: '상세주소는 특수문자 & < > ;를 제외하고 작성해주세요.',
    zone_code: '주문을 위해서 ZIP 코드가 입력되어야 합니다.<br>올바른 ZIP 코드를 입력해주세요.',
    memo: '배송메모는 특수문자 & < > ;를 제외하고 작성해주세요.',
  },
  quantity: '수량의 변경을 확정해주세요.',
  pay_type: '결제수단을 정해주세요.',
  agreement: '약관 확인 후 동의하여 주시기 바랍니다.',
  not_eligible: '배송이 불가능한 상품이 있습니다<br>배송 국가와 구매 상품을 한번 더 확인해주세요',
  not_compatible_chrome:
    'Flash Player 설치 후 다시 시도해 주시기 바랍니다. 크롬 브라우저에서 신용카드 결제 시 Flash player를 설치하셔야 정상적으로 결제 가능합니다. Internet Explorer 10, 11 버전 또는 사파리를 사용하시면 더욱 편안하게 결제하실 수 있습니다.',
  not_compatible_edge:
    '엣지 브라우저에서 사용 제한된 결제수단입니다.<br/>Internet Explorer 10, 11 버전으로 결제해 주시기 바랍니다.',
  not_compatible_tablet:
    '태블릿 PC에서는 결제모드가 지원되지 않고 있습니다<br>제품 구매에 따른 결제는 일반 PC 또는 모바일 기기를 통해 확인해주세요',
  flash_download: 'Flash Player 다운로드 가기',
}

export const order_validate_en = {
  buyer: {
    name:
      'To place an order, you must enter the name of the buyer. The buyer’s name must be from 2 to 30 characters, in English or Korean.',
    email:
      'To place an order, you must enter your email address. Please enter a valid email address.',
    phone_country:
      'To place an order, you must enter a valid International phone number. International phone number must not contain +.',
    phone:
      'To place an order, you must enter a valid phone number. Phone numbers must contain only numeric values, when appropriate.',
  },
  shipping: {
    name:
      'To place an order, you must enter the name of the recipient. The recipient’s name must be from 2 to 30 characters, in English.',
    phone_country:
      'To place an order, you must enter a valid International phone number. International phone number must not contain +.',
    phone:
      'To place an order, you must enter a valid phone number. Phone numbers must contain only numeric values, when appropriate.',
    phone_set:
      'To place an order, you must enter a valid phone number. Phone numbers must contain only numeric values and hyphens [-], when appropriate.',
    addr1:
      'To place an order, you must enter a valid mailing address. The address must be from 2 to 100 characters long.',
    addr1_is_alpha: 'Please enter only in English.',
    addr2:
      'To place an order, you must enter the full mailing address. The full address must be from 2 to 100 characters long.',
    addr2_is_not_special_char:
      'The delivery notes must not contain the following special characters & < > ;',
    zone_code: 'To place an order, you must enter a valid postal code.',
    memo: 'The delivery notes must not contain the following special characters & < > ;',
  },
  quantity: 'Please confirm the change in quantity.',
  pay_type: 'Please select a payment method.',
  agreement: 'Please agree to our privacy policy to continue.',
  not_eligible:
    'Some of your items in the order include products that cannot be shipped globally.',
  not_compatible_chrome:
    'Please try again after installing Flash Player. If you are using Google Chrome, you must install Flash Player to make a purchase using your credit card. Payment transactions are easier to make on Internet Explorer 10 or 11, or Safari.',
  not_compatible_edge:
    'This payment method is not allowed on Microsoft Edge. Please make your payment using Internet Explorer 10 or 11.',
  not_compatible_tablet:
    'Billing mode is not supported on Tablet PC<br>Please check your payment on the PC or mobile device',
  flash_download: 'Download Flash Player.',
}
