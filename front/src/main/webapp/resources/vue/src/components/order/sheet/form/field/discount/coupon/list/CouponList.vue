<template>
  <div class="inner_layer">
    <div class="layer_head">
      <strong class="tit_order">{{ $t('discount.coupon_list.title') }}</strong>
    </div>
    <div class="layer_body">
      <form @submit.prevent="onSubmit">
        <fieldset class="order_coupon">
          <legend class="screen_out">{{ $t('discount.coupon_list.title') }}</legend>
          <div class="group_salecoupon"
               id="coupou_list">
            <list-duplicate></list-duplicate>
            <list-normal></list-normal>
            <list-sum></list-sum>
          </div>
          <list-submit></list-submit>
        </fieldset>
      </form>
    </div>
  </div>
</template>

<script>
import { mapState, mapGetters, mapMutations } from 'vuex'
import ListDuplicate from './ListDuplicate'
import ListNormal from './ListNormal'
import ListSum from './ListSum'
import ListSubmit from './ListSubmit'

export default {
  name: 'coupon-list',
  components: {
    ListDuplicate,
    ListNormal,
    ListSum,
    ListSubmit,
  },
  computed: {
    ...mapState(['membership']),
    ...mapGetters(['discount', 'basket']),
  },
  methods: {
    ...mapMutations(['CHANGE_DISCOUNT_FIELDS', 'HIDE_MODAL']),
    onSubmit() {
      const { duplicate, normal } = this.discount.coupon.selected

      if (this.discount.totalDiscountPrice > this.basket.paymentAccountNotDeli) {
        this.HIDE_MODAL()
        return
      }

      this.CHANGE_DISCOUNT_FIELDS({
        coupon: {
          ...this.discount.coupon,
          applied: {
            duplicate,
            normal,
          },
        },
      })

      this.HIDE_MODAL()
    },
  },
}
</script>

<style scoped>
.friends_layer .tit_order {
  padding-bottom: 0;
  border-bottom: 0;
}
</style>
