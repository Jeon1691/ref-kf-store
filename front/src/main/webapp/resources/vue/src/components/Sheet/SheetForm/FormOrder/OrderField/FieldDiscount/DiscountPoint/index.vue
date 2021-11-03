<template>
  <div class="info_discount">
    <strong class="tit_discount">{{ $t('discount.point.title') }}
      <span class="ico_newfriends_v1 ico_discount">p</span>
    </strong>

    <dl class="list_append">
      <dt>{{ $t('discount.point.earn_points') }}</dt>
      <dd>
        {{ membership.pointPrice | krw }} P
      </dd>

      <dt>{{ $t('discount.point.available_points') }}</dt>
      <template v-if="!membership.pointPriceUse">
        <dd>0 P</dd>
      </template>
      <template v-else>
        <dd>
          {{ membership.pointPrice | krw }} P
        </dd>
      </template>
    </dl>

    <dl class="list_inp">
      <dt>
        <label for="pointIn"
               class="lab_tf"
               :class="{ screen_out: pointPrice || pointPrice === 0 }">{{ $t('discount.point.enter_points') }}</label>
      </dt>
      <dd>
        <input type="number"
               id="pointIn"
               name="cpnNum1"
               class="tf_g tf_point"
               v-model.number="pointPrice">
        <div class="sort_btn">
          <button type="button"
                  class="btn_g"
                  id="applyPoint"
                  @click="onApplyPoint">
            <span class="txt_g">{{ $t('discount.point.apply') }}</span>
          </button>
        </div>
      </dd>
    </dl>
  </div>
</template>

<script>
import { mapState, mapMutations } from 'vuex'

export default {
  name: 'discount-point',
  data() {
    return {
      pointPrice: null,
    }
  },
  computed: {
    ...mapState(['membership', 'discount', 'basket']),
  },
  methods: {
    ...mapMutations(['SHOW_DIALOG', 'APPLY_POINT']),
    onApplyPoint() {
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
              message: this.$t('discount.point.at_least_price'),
            })
            this.pointPrice = totAmt - 1000
          }
        }

        this.APPLY_POINT(this.pointPrice)
      } else {
        this.pointPrice = null
        this.SHOW_DIALOG({
          message: this.$t('discount.point.at_least_point'),
        })
      }
    },
  },
}
</script>
