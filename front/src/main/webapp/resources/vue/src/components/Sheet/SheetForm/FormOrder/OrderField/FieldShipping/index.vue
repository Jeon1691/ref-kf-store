<template>
  <div class="info_order info_shipping">
    <shipping-title></shipping-title>
    <shipping-type v-if="!anonymousUser"></shipping-type>
    <shipping-nation></shipping-nation>
    <shipping-name></shipping-name>
    <shipping-phone></shipping-phone>
    <shipping-address></shipping-address>
    <shipping-save v-if="!anonymousUser"></shipping-save>
    <shipping-memo></shipping-memo>
    <shipping-guide></shipping-guide>
  </div>
</template>

<script>
import { mapState } from 'vuex'
import ShippingTitle from './ShippingTitle'
import ShippingType from './ShippingType'
import ShippingNation from './ShippingNation'
import ShippingName from './ShippingName'
import ShippingPhone from './ShippingPhone'
import ShippingAddress from './ShippingAddress'
import ShippingSave from './ShippingSave'
import ShippingMemo from './ShippingMemo'
import ShippingGuide from './ShippingGuide'

export default {
  name: 'field-shipping',
  components: {
    ShippingTitle,
    ShippingType,
    ShippingNation,
    ShippingName,
    ShippingPhone,
    ShippingAddress,
    ShippingSave,
    ShippingMemo,
    ShippingGuide,
  },
  computed: {
    ...mapState(['anonymousUser']),
  },
}
</script>
