<template>
  <dl class="list_price">
    <dt>{{ $t('agree_payinfo.delivery.title') }}</dt>
    <dd class="usd_check usd_show">
      <strong id="delivery_price">
        <span class="num_price">{{ basket.deliveryCharge | krw }}</span>{{ $t('common.krw') }}</strong>
      <span class="txt_usd deliveryPrice">
        {{ basket.exchangeDeliveryCharge | usd }} USD
      </span>
    </dd>
    <dd class="usd_check">
      <strong id="delivery_price">
        <span class="num_price deliveryPrice">{{ basket.exchangeDeliveryCharge | usd }}</span>USD
      </strong>
    </dd>
  </dl>
</template>

<script>
import { basket } from '../mixin'

export default {
  name: 'payinfo-delivery',
  mixins: [basket],
}
</script>