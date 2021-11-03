<template>
  <div class="group_order">
    <h3 class="tit_orderit">{{ $t('discount.title') }}</h3>
    <a class="link_attention"
       @click="orderAttentionPopup">
      <span class="ico_newfriends_v1 ico_attention">{{ $t('discount.notice') }}</span>{{ $t('discount.information') }}
    </a>

    <div class="box_discount">
      <discount-coupon></discount-coupon>
      <discount-point></discount-point>
      <discount-total></discount-total>
    </div>
  </div>
</template>

<script>
import { mapState, mapGetters, mapMutations } from 'vuex'
import DiscountCoupon from './DiscountCoupon'
import DiscountPoint from './DiscountPoint'
import DiscountNote from './DiscountNote'
import DiscountTotal from './DiscountTotal'

export default {
  name: 'field-discount',
  components: {
    DiscountCoupon,
    DiscountPoint,
    DiscountTotal,
  },
  data() {
    return {
      couponPrice: '',
    }
  },
  computed: {
    ...mapState(['membership']),
    ...mapGetters(['payment', 'basket', 'discount']),
  },
  methods: {
    ...mapMutations(['SHOW_MODAL']),
    orderAttentionPopup() {
      this.SHOW_MODAL({
        name: 'attention_layer',
        component: DiscountNote,
      })
    },
  },
}
</script>
