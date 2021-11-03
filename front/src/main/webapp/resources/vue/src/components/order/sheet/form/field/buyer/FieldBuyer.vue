<template>
  <div class="info_order info_shipping">
    <h4>{{ $t('buyer.title') }}</h4>

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
