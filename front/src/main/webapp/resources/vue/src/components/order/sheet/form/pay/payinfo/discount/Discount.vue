<template>
  <div class="group_order">
    <div class="box_discount">

    </div>
  </div>
</template>

<script>
import { mapState, mapGetters, mapMutations } from 'vuex'
import DiscountCoupon from './coupon/DiscountCoupon'
import DiscountPoint from './DiscountPoint'
import DiscountNote from './DiscountNote'
import DiscountTotal from './DiscountTotal'

export default {
  name: 'discount',
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
