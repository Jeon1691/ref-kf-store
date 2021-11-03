import { order_validate_en } from '../common/validations'

export default {
  common: {
    krw: 'KRW',
    ok: 'OK',
    cancel: 'Cancel',
    out_of_stock_global:
      'We are currently out of our global delivery stock of this product.<br>We apologize for the inconvenience.',
    input_necessary: 'input necessary',
    selected: 'selected',
    select_option: 'select option',
  },
  cart: {
    title: 'Item list',
    price: 'Price',
    option: 'Option',
    quantity: 'Quantity',
    decrease: 'decrease',
    increase: 'increase',
    ea: '',
    ok: 'OK',
    total_items: 'Total Items',
    not_eligible_global: 'This product is not eligible for global shipping',
    is_soldout: 'Out of stock',
    out_of_stock: 'We don’t have enough stock',
    out_of_stock_currently: [
      'The product you requested is currently out of stock. {names}',
      'Some products in your order is out of stock.',
    ],
    min_quantity: 'You cannot change the quantity to 0.',
    purchase_exceeded:
      'The maximum number allowed for purchase has been exceeded. <br> You may only purchase the same amount of gift bags equaling your purchase order.',
  },
  discount: {
    title: 'Enter points / coupon',
    notice: 'notice',
    information: 'Information',
    coupon: {
      title: 'Coupon',
      available_coupon: 'Available coupon',
      search: 'Search',
    },
    coupon_list: {
      title: 'Select a discount coupon',
      overlap_discount: 'Overlap discount',
      not_applicable: 'Not applicable',
      discount_coupon: 'discount coupon',
      all: 'All',
      regular_discount: 'Regular discount',
      category: 'Category',
      discounted_price: 'Discounted price',
    },
    coupon_selected: {
      discount: 'discount',
      coupon_name: 'Coupon name',
      purchase_over: 'Purchase over {price}',
      no_limit: 'No limit on amount',
      freeshipping: 'FREESHIPPING',
      coupon_delete: '쿠폰 삭제',
      category: 'Category',
      discount_subject: 'Purchase over',
      expiration_date: 'Expiration date',
    },
    point: {
      title: 'Points',
      earn_points: 'Earn Points',
      available_points: 'Available Points',
      enter_points: 'Enter points',
      apply: 'Apply',
      at_least_point: 'You need at least 3,000 points to use them to pay for your purchase',
      at_least_price:
        'The minimum amount of purchase must be KRW 1,000 (excluding shipping) if you are using a coupon or points.',
    },
    total: {
      discounted_price: 'Discounted price',
      coupon: 'Coupon',
      points: 'Points',
      total_discounted: 'Total product price',
    },
    note: {
      title: 'Points and coupons usage note',
      cautions: [
        'Partial return or refund is not allowed when you use points or coupons. <br class="rw_hide">(Due to our system limitation, please return your entire purchase and make a new purchase when you want a partial return.)',
        'You can use points for purchasing products only. Points cannot be used for shipping.',
        'You may use points or coupons for purchases over a certain amount. <br class="rw_hide">(You cannot split the coupons for purchases.)',
        'The minimum amount of purchase needed to use points or coupons is KRW 1,000 (excluding shipping). You can only make a normal purchase for an amount KRW 1,000 or more.',
        'Duplicate coupons can be used. <br class="rw_hide">(Please note the same kind of coupons cannot be used at the same time.)',
        'Coupons for shipping can be used only for products available for shipping.',
        'When using a discount coupon, accumulated points and payment method settings may be changed. Please check your payment method and information after applying the coupon.',
        'Points/coupons are applied and given in KRW.',
        'Points/coupons may be returned when canceling a purchase according to cancellation/refund policy.',
        'If points/coupons that were used for purchasing have not expired, they will be available for use when a purchase is canceled or returned. <br class="rw_hide">(Please note they will become available when the order status changes to ‘return completed’ for returns.)',
        'We are constantly investigating into points/coupons misuse. Any resellers will have their membership revoked and may be subject to legal action such as compensation for damage.',
        'Points/coupons may not be applicable for certain products.',
      ],
    },
  },
  fields: {
    name: {
      label: 'Name',
      placeholder: 'Name',
    },
    phone: {
      label_cell: 'Mobile number (enter numbers only)',
      label_phone: 'Phone number (enter numbers only)',
    },
    countries: {
      label: 'select country',
    },
  },
  buyer: {
    title: 'Orderer information',
    email: {
      label: 'ID (Email)',
      input_directly: 'Input directly',
      select_email: 'select email',
    },
  },
  agree_payinfo: {
    title: 'Payment information',
    basket: {
      title: 'Items',
    },
    delivery: {
      title: 'Shipping to',
    },
    discount: {
      title: 'Discounted price',
    },
    total: {
      title: 'Subtotal',
    },
  },
  agree_checkbox: {
    title: 'Agree to Terms & Condition',
    agree: 'Agree',
    details: 'Details',
    agree_list: [
      'I agree to all terms and conditions.',
      'I agree to the collection of order product and delivery information',
      "I have read the descriptions and conditions for use of the product I'm purchasing and I agree to the cancellation policy.",
    ],
    required: 'Required',
  },
  agree_detail: {
    title: 'Collection and use of personal information <br>(Collecting shipping information)',
    caption: 'Collection and use of personal information (Collecting shipping information)',
    th: ['Category', 'Required field'],
    tr: [
      ['Purpose', 'Product order delivery / Customer contact us'],
      ['Items', 'name, e-mail, cellphone number, address'],
      [
        'Storage period',
        'Will be terminated in 3 months after the shipping. <br/>(Depending on the law of electronic commerce, the storage period could be extended to 5 years)',
      ],
    ],
    desc:
      'This is the minimum of personal information we need to provide you with the following services. Please select “Agree” to continue.',
  },
  order_form: {
    legend: 'order form',
  },
  order_submit: {
    check_out: 'Check Out',
    cancel_payment: 'You have canceled your payment.',
  },
  order_validate: order_validate_en,
  order_pay_method: {
    title: 'Payment method',
    kakaopay: 'KakaoPay',
    credit_card: 'Credit Card',
    caution: {
      currency: {
        title: 'The total amount may vary depending on the currency used for the payment method.',
        desc: 'Credit Card : KRW | Paypal : USD',
      },
      refund: {
        title:
          'I cannot receive a partial refund of my purchase! (paid with a foreign issued card)',
        desc:
          'You cannot receive a partial refund if you made payment with a foreign issued card. Therefore, even if you make a purchase for domestic delivery but made payment with a foreign issued card, you cannot receive a partial refund. Please keep that in mind before you make a purchase.',
      },
      global: {
        title: 'Check before ordering!',
        desc: `You have opted for our global shipping service, meaning that you can only cancel your purchase when you are at the <em class="emph_terms">&ldquo;order received&rdquo;</em> stage.
        Once your order has proceeded to any of the following stages of shipment, then as a rule you will not be eligible for exchanges,
        cancellations or returns. Exceptions are made when your product has a defect and an exchange is approved by the company.<br><br>
        To request an exchange because of a flaw in the product, please use the Contact Us or email global@kakaofriends.com,
        accompanying your request with documented evidence of the product defect.<br><br>
        If the delivery is automatically sent back due to issues with overseas customs clearance,
        an incorrect address, or because the receiver rejected the item,
        the return will be attributed to buyer negligence and any additional shipping fees will become the burden of the buyer.<br><br>
        In addition, the recipient of the item must bear the burden of any customs fees and taxes imposed on products sent through the global shipping service,
        whatever the fees and taxes may be, depending on the destination country.`,
      },
    },
  },
  shipping: {
    header: {
      title: 'Shipping address',
      recent: 'Recent',
    },
    address: {
      zip_code: 'ZIP code',
      postal: 'ZIP code',
      addr1: 'Address 1',
      addr2: 'Address 2',
      state: 'State / Province',
      select_us_state: 'select a US state code',
      city: 'City',
      street: 'Street',
    },
    save: {
      label: 'Save as default address',
    },
    guide: {
      ko:
        'The delivery notes must not contain the following special characters &amp; &lt; &gt; &#59;',
      en:
        'The delivery notes must not contain the following special characters &amp; &lt; &gt; &#59;',
    },
    history: {
      title: 'Select recent shipping address',
      legend: 'Select shipping address',
      phone: 'Phone',
      address: 'Address',
      select_up:
        'You can select up to three recently used addresses when entering a shipping address.',
      empty: 'There are no records of any previous orders.',
    },
    memo: {
      label: 'Delivery note',
      max: '50',
      placeholder:
        'Not for writing address. \nPlease write the shipping memo within 50 letters in English.',
    },
    type: {
      label: {
        default: 'Default address',
        new: 'New address',
      },
    },
  },
  shipping_info: {
    title: 'Shipping information',
    total_boxes: 'The above products will be delivered to you in a total of <em>{boxes}</em> boxes',
    box: 'Box',
    weight: 'Weight',
    price: 'Price',
    total_shipping: 'Total Shipping to',
    information: 'Information',
    information_list: [
      'The global shipping costs are calculated by weight, including the weight of the boxes as well as the products.',
      'If the products ordered do not fit into a single boxes because of their size, they will be shipped in multiple boxes.',
    ],
  },
}
