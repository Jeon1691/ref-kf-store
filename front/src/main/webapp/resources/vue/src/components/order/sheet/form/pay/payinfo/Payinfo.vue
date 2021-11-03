<template>
  <ul class="list_info_price">
    <payinfo-basket></payinfo-basket>
    <payinfo-discount v-show="false"></payinfo-discount>
    <payinfo-delivery></payinfo-delivery>
    <discount-coupon></discount-coupon>
    <discount-point></discount-point>
    <discount-total v-show="false"></discount-total>
    <payinfo-total></payinfo-total>
  </ul>
</template>

<script>
  import { mapGetters, mapMutations, mapState } from 'vuex'
  import PayinfoBasket from './PayinfoBasket'
  import PayinfoDelivery from './PayinfoDelivery'
  import PayinfoDiscount from './PayinfoDiscount'
  import PayinfoTotal from './PayinfoTotal'
  import DiscountCoupon from './discount/coupon/DiscountCoupon'
  import DiscountPoint from './discount/DiscountPoint'
  import DiscountTotal from './discount/DiscountTotal'

  export default {
    name: 'agree-payinfo',
    components: {
      PayinfoBasket,
      PayinfoDelivery,
      PayinfoDiscount,
      DiscountCoupon,
      DiscountPoint,
      DiscountTotal,
      PayinfoTotal
    },
    data () {
      return {
        couponPrice: ''
      }
    },
    computed: {
      ...mapState(['membership']),
      ...mapGetters(['payment', 'basket', 'discount'])
    },
    methods: {
      ...mapMutations(['SHOW_MODAL'])

    }
  }
</script>
