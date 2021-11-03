<template>
  <div class="group_order">
    <h3 class="tit_orderit">{{ $t('agree_payinfo.title') }}</h3>
    <div class="info_price">
      <payinfo-basket></payinfo-basket>
      <payinfo-discount></payinfo-discount>
      <payinfo-delivery></payinfo-delivery>
      <payinfo-total></payinfo-total>
    </div>
  </div>
</template>

<script>
import PayinfoBasket from './PayinfoBasket'
import PayinfoDelivery from './PayinfoDelivery'
import PayinfoDiscount from './PayinfoDiscount'
import PayinfoTotal from './PayinfoTotal'

export default {
  name: 'agree-payinfo',
  components: {
    PayinfoBasket,
    PayinfoDelivery,
    PayinfoDiscount,
    PayinfoTotal,
  },
}
</script>
