<template>
  <div class="info_discount info_discounttotal">
    <strong class="tit_discount">{{ $t('discount.total.discounted_price') }}</strong>

    <dl class="list_price">
      <dt>{{ $t('discount.total.coupon') }}</dt>
      <dd id="coupon_price"
          class="usd_check usd_show">{{ discount.totalCouponPrice | krw }} {{ $t('common.krw') }}</dd>
      <dd id="coupon_price"
          class="usd_check">{{ discount.totalCouponPrice | exchange | usd }} USD</dd>
    </dl>

    <dl class="list_price">
      <dt>{{ $t('discount.total.points') }}</dt>
      <dd id="point_price"
          class="usd_check usd_show">{{ discount.pointPrice || 0 | krw }} {{ $t('common.krw') }}</dd>
      <dd id="point_price"
          class="usd_check">{{ discount.exchangePointPrice || 0 | usd }} USD</dd>
    </dl>

    <dl class="list_price price_total">
      <dt>{{ $t('discount.total.total_discounted') }}</dt>
      <dd id="total_product_price"
          class="txt_total usd_check usd_show">
        <strong class="txt_price">
          <span class="num_price">
            {{ basket.basketAccount - discount.pointPrice | krw }}
          </span> {{ $t('common.krw') }}
        </strong>
      </dd>
      <dd id="total_product_price"
          class="txt_total usd_check">
        <strong class="txt_price">
          <span class="num_price">
            {{ basket.exchangeBasketAccount - discount.exchangePointPrice | usd }}
          </span> USD
        </strong>
      </dd>
    </dl>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'discount-total',
  computed: {
    ...mapGetters(['basket', 'discount']),
  },
}
</script>
