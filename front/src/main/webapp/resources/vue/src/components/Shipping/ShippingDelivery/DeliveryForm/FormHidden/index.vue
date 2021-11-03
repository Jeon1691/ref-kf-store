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
           :value="omNum" />
    <input type="hidden"
           name="oaBuyerCountryName"
           :value="orderAddressRequest.oaBuyerCountryName" />
    <input type="hidden"
           name="oaBuyerName"
           :value="orderAddressRequest.oaBuyerName" />
    <input type="hidden"
           name="oaBuyerEmail"
           id="buyerEmail"
           :value="orderAddressRequest.oaBuyerEmail" />
    <input type="hidden"
           name="oaBuyerPhopne"
           :value="orderAddressRequest.oaBuyerPhone" />
    <input type="hidden"
           id="oaAddr1"
           name="oaAddr1"
           :value="orderAddressRequest.oaAddr1">
    <input type="hidden"
           id="oaZoneCode"
           name="oaZoneCode"
           :value="orderAddressRequest.oaZoneCode">
  </fieldset>
</template>

<script>
const { CSRF_TOKEN, CSRF_HEADER_NAME } = window

export default {
  name: 'form-hidden',
  props: {
    omNum: {
      type: String,
      required: true,
    },
    orderAddressRequest: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      CSRF_TOKEN,
      CSRF_HEADER_NAME,
    }
  },
}
</script>
