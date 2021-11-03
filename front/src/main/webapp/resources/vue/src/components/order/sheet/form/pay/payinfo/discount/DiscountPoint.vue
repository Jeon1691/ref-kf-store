<template>
  <li class="area_pay_group">
    <strong>{{ $t('discount.point.enter_points') }}<span>({{membership.pointPrice | krw}}P)</span></strong>
    <p>
      <input type="text"
             id="pointIn"
             name="cpnNum1"
             v-model.number="pointPrice"
             @change="onApplyPoint">
    </p>
  </li>
</template>

<script>
  import { mapMutations, mapState } from 'vuex'

  export default {
    name: 'discount-point',
    data () {
      return {
        pointPrice: null
      }
    },
    computed: {
      ...mapState(['membership', 'discount', 'basket'])
    },
    methods: {
      ...mapMutations(['SHOW_DIALOG', 'APPLY_POINT']),
      onApplyPoint () {
        if (this.membership.pointPriceUse) {
          const totAmt = this.basket.paymentAccountNotDeli || 0 - this.discount.totalCouponPrice || 0

          if (!this.pointPrice) {
            this.pointPrice = 0
          }

          if (
            this.pointPrice > this.membership.pointPrice ||
            this.pointPrice > totAmt ||
            this.pointPrice === totAmt
          ) {
            if (totAmt - 1000 > this.membership.pointPrice) {
              this.pointPrice = this.membership.pointPrice
            } else {
              this.SHOW_DIALOG({
                message: this.$t('discount.point.at_least_price')
              })
              this.pointPrice = totAmt - 1000
            }
          }

          this.APPLY_POINT(this.pointPrice)
        } else {
          this.pointPrice = null
          this.SHOW_DIALOG({
            message: this.$t('discount.point.at_least_point')
          })
        }
      }
    }
  }
</script>
