<template>
  <div class="card_coupon">
    <div class="head_coupon"
         :style="{backgroundColor: coupon.cph_OPTION_CATEGORY === 0 ? '#1fd080' : '#ffcd00'}">
      <div class="coupon_tit">
        <strong class="tit_coupon">
          {{ coupon.cph_OPTION_TYPE_NM }}
          <br> {{ coupon.cph_OPTION_TYPE === 'D' ? '' : $t('discount.coupon_selected.discount') }}
        </strong>
      </div>
    </div>
    <div class="body_coupon">
      <dl class="info_name">
        <dt class="screen_out">{{ $t('discount.coupon_selected.coupon_name') }} : </dt>
        <dd>
          <template v-if="coupon.cph_OPTION_VALUE > 0">
            <span class="txt_name usd_check usd_show">{{ $t('discount.coupon_selected.purchase_over', coupon.cph_OPTION_VALUE | krw) }}</span>
            <span class="txt_name usd_check">{{ $t('discount.coupon_selected.purchase_over', coupon.cph_OPTION_VALUE | exchange | usd) }}</span>
          </template>
          <template v-else>
            <span class="txt_name">{{ $t('discount.coupon_selected.no_limit') }}</span>
          </template>

          <template v-if="coupon.cph_PRICE > 0">
            <span class="txt_price usd_check usd_show">
              <span class="num_price">{{ coupon.cph_PRICE | krw }}</span> {{ $t('common.krw') }}
            </span>
            <span class="txt_price usd_check">
              <span class="num_price">{{ coupon.cph_PRICE_EXCHANGE }}</span> USD
            </span>
          </template>
          <template v-else>
            <span class="txt_price">
              <span class="num_price">{{ $t('discount.coupon_selected.freeshipping') }}</span>
            </span>
          </template>
        </dd>
      </dl>

      <dl class="info_desc">
        <dt>{{ $t('discount.coupon_selected.discount_subject') }} : </dt>
        <dd>
          {{ !coupon.CT_NAME ? coupon.cph_OPTION_TYPE_NM : coupon.CT_NAME }}{{ !coupon.CT_NAME ? '' : $t('discount.coupon_selected.category') }}
        </dd>
        <dt>{{ $t('discount.coupon_selected.expiration_date') }} : </dt>
        <dd>{{ coupon.cph_SDATE | date }} ~ {{ coupon.cph_EDATE | date }}</dd>
      </dl>
    </div>

    <button type="button"
            class="btn_del"
            @click="deleteCoupon(couponType)">
      <span class="ico_newfriends_v1 ico_del">{{ $t('discount.coupon_selected.coupon_delete') }}</span>
    </button>

    <div class="screen_out coupon_info"></div>
  </div>
</template>

<script>
export default {
  name: 'coupon-selected',
  props: {
    coupon: {
      type: Object,
      required: true,
    },
    deleteCoupon: {
      type: Function,
      required: true,
    },
    couponType: {
      type: String,
      required: true,
    },
  },
}
</script>
