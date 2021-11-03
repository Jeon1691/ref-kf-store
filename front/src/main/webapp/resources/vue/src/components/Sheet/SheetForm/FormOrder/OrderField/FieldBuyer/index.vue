<template>
  <div class="info_order info_shipping">
    <h3 class="tit_orderit">{{ $t('buyer.title') }}</h3>

    <buyer-country></buyer-country>
    <buyer-name></buyer-name>
    <buyer-email></buyer-email>
    <buyer-phone></buyer-phone>
  </div>
</template>

<script>
import BuyerCountry from './BuyerCountry'
import BuyerName from './BuyerName'
import BuyerEmail from './BuyerEmail'
import BuyerPhone from './BuyerPhone'

export default {
  name: 'field-buyer',
  components: {
    BuyerCountry,
    BuyerName,
    BuyerEmail,
    BuyerPhone,
  },
}
</script>
