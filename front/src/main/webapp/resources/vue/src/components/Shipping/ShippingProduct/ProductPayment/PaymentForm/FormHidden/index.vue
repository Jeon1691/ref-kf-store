<template>
  <fieldset>
    <input type="hidden"
           name="encrypted"
           value="">
    <input type="hidden"
           name="ini_encfield"
           :value="inicis.inicisEncfield">
    <input type="hidden"
           name="ini_certid"
           :value="inicis.inicisTid">
    <input type="hidden"
           name="orderNumber"
           :value="inicis.orderNumber">
    <input type="hidden"
           name="uid"
           :value="inicis.uid">
    <input type="hidden"
           name="cardquota"
           :value="inicis.cardquota">
    <input type="hidden"
           name="sessionkey"
           :value="inicis.sessionkey">
    <input type="hidden"
           name="paymethod"
           :value="inicis.paymethod">
    <input type="hidden"
           name="cardcode"
           :value="inicis.cardcode">
    <input type="hidden"
           name="price"
           :value="orderAddDeli.odReqMoney">
    <input type="hidden"
           name="clickcontrol"
           value="enable" />
    <input type="hidden"
           name="reqsign"
           value="DONE" />
    <input type="hidden"
           name="version"
           value="5000" />
    <input type="hidden"
           name="gopaymethod"
           value="onlycard">
    <input type="hidden"
           name="goodname"
           value="추가회수비">
    <input type="hidden"
           name="currency"
           value="WON" />
    <input type="hidden"
           name="paymentAmount"
           :value="orderAddDeli.odReqMoney">

    <input type="hidden"
           name="buyername"
           :value="this.orderAddressRequest.oaBuyerName">

    <input type="hidden"
           name="buyeremail"
           :value="this.orderAddressRequest.oaBuyerEmail">

    <input type="hidden"
           name="buyertel"
           :value="this.orderAddressRequest.oaBuyerPhone">
  </fieldset>
</template>

<script>
import { mapState } from 'vuex'

const { PG_INI_PAY_50: { mid }, CSRF_TOKEN, CSRF_HEADER_NAME } = window

export default {
  name: 'form-hidden',
  data() {
    return {
      CSRF_TOKEN,
      CSRF_HEADER_NAME,
      mid,
    }
  },
  computed: {
    ...mapState(['orderAddDeli', 'inicis']),
    ...mapState({
      orderAddressRequest: state => state.orderShippingInfo.orderAddressRequest,
    }),
  },
}
</script>
