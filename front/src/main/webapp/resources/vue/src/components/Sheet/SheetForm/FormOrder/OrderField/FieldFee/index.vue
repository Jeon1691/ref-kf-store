<template>
  <div id="deliForm"
       class="info_order info_shippingfee">
    <h3 class="tit_orderit">{{ $t('shipping_info.title') }}</h3>
    <div class="guide_shipping">
      <p class="desc_shipping global_show">
        <span class="ico_newfriends_v1 ico_car">!</span>
        <span v-html="$t('shipping_info.total_boxes', { boxes: basket.boxList.length })"></span>
      </p>

      <ul class="list_shippingbox global_show">
        <li v-for="(box, index) in basket.boxList"
            :key="index">
          <span class="tit_shippingbox">{{ $t('shipping_info.box') }} {{ index + 1 }}</span>
          <dl class="list_append">
            <dt>{{ $t('shipping_info.weight') }}</dt>
            <dd>{{ box.weight }} g</dd>
            <dt>{{ $t('shipping_info.price') }}</dt>
            <dd class="usd_check usd_show">{{ box.amount | krw }} {{ $t('common.krw') }}</dd>
            <dd class="usd_check">{{ box.exchangeAmount | usd }} USD</dd>
          </dl>
        </li>
      </ul>

      <div class="info_price">
        <dl class="list_price price_total">
          <dt>{{ $t('shipping_info.total_shipping') }}</dt>
          <dd class="usd_check usd_show">
            <strong id="totalDeliPrice">
              {{ basket.deliveryCharge | krw }} {{ $t('common.krw') }}
            </strong>
            <span class="txt_usd totalDeliPriceEn">
              {{ basket.exchangeDeliveryCharge | usd }} USD
            </span>
          </dd>
          <dd class="usd_check">
            <strong class="totalDeliPriceEn">
              {{ basket.exchangeDeliveryCharge | usd }} USD
            </strong>
          </dd>
        </dl>
      </div>

      <dl class="list_warning global_show">
        <dt>{{ $t('shipping_info.information') }}</dt>
        <dd v-for="(dd, index) in $t('shipping_info.information_list')"
            :key="index">{{ dd }}</dd>
      </dl>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'field-fee',
  computed: {
    ...mapGetters(['basket']),
  },
}
</script>
