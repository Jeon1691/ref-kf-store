<template>
  <fieldset>
    <input type="hidden"
           name="_csrf"
           :value="CSRF_TOKEN" />
    <input type="hidden"
           name="_csrf_header"
           :value="CSRF_HEADER_NAME" />
    <input type="hidden"
           name="oaOmNum"
           :value="orderInfo.omNum" />
    <input type="hidden"
           name="oaBuyerName"
           :value="orderAddressRequest.oaBuyerName" />
    <input type="hidden"
           name="oaBuyerEmail"
           :value="orderAddressRequest.oaBuyerEmail" />
    <input type="hidden"
           name="oaAddr1"
           :value="orderAddressRequest.oaAddr1">
    <input type="hidden"
           name="oaZoneCode"
           :value="orderAddressRequest.oaZoneCode">
  </fieldset>
</template>

<script>
import { mapState } from 'vuex'

const { CSRF_TOKEN, CSRF_HEADER_NAME } = window

export default {
  name: 'form-hidden',
  data() {
    return {
      CSRF_TOKEN,
      CSRF_HEADER_NAME,
    }
  },
  computed: {
    ...mapState({
      orderInfo: state => state.orderShippingInfo.orderInfo,
      orderAddressRequest: state => state.orderShippingInfo.orderAddressRequest,
    }),
  },
}
</script>