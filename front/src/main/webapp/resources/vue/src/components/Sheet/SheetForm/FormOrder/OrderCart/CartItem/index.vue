<template>
  <div :class="{ change_on: !order.isDisabled && order.bsEa && !isOutOfStock }">
    <div class="box_quantity">
      <em class="screen_out">{{ $t('cart.quantity') }} :</em>

      <input type="text"
             class="inp_quantity"
             name="bsEa"
             v-model.number="ea">

      <button type="button"
              class="btn_g btn_minus"
              @click="decrement">
        <span class="ico_newfriends_v1 ico_minus">{{ $t('cart.decrease') }}</span>
      </button>

      <button type="button"
              class="btn_g btn_plus"
              :disabled="isOutOfStock"
              @click="increment">
        <span class="ico_newfriends_v1 ico_plus">{{ $t('cart.increase') }}</span>
      </button>
    </div>

    <button type="button"
            class="btn_change"
            :disabled="!order.bsEa || order.isDisabled || isOutOfStock"
            @click="basketChange">
      <span class="txt_g">{{ $t('cart.ok') }}</span>
    </button>
  </div>
</template>

<script>
import { mapGetters, mapMutations, mapActions } from 'vuex'
import { order } from '../props'
import mixin from '../CartEmpty/mixin'

export default {
  name: 'cart-item',
  mixins: [mixin],
  props: {
    order,
    index: {
      type: Number,
      required: true,
    },
  },
  data() {
    return {
      initialEa: this.order.bsEa,
    }
  },
  computed: {
    ...mapGetters(['basket', 'shipping']),
    ea: {
      get() {
        return this.basket.orderSheetExpansions[this.index].bsEa
      },
      set(ea) {
        if (/[^0-9]/g.test(ea) || ea > 999) {
          return
        }

        if (ea === 0 || ea < 0) {
          this.SHOW_DIALOG({
            message: this.$t('cart.min_quantity'),
          })

          return
        }

        this.CHANGE_BASKET_DISABLED({
          index: this.index,
          disabled: ea === this.initialEa ? true : false,
        })

        this.CHANGE_BASKET_EA({
          index: this.index,
          ea: ea || 1,
        })
      },
    },
  },
  methods: {
    ...mapMutations(['CHANGE_BASKET_EA', 'CHANGE_BASKET_DISABLED', 'SHOW_DIALOG']),
    ...mapActions(['changeBasket']),
    async basketChange() {
      const result = await this.changeBasket({
        bsPrCode: this.order.product.prCode,
        bsSeq: this.order.bsSeq,
        bsEa: this.order.bsEa,
        displayGoodsId: this.order.displayGoodsId
      })

      if (result) {
        this.CHANGE_BASKET_DISABLED({
          index: this.index,
          disabled: result,
        })

        this.initialEa = this.order.bsEa
      }
    },
    increment() {
      if (this.order.product.prType === '8') {
        if (this.basket.giftbagCount > this.basket.productCount - 1) {
          this.SHOW_DIALOG({
            message: this.$t('cart.purchase_exceeded'),
          })
          return
        }
      }

      this.ea++
    },
    decrement() {
      this.ea--
    },
  },
}
</script>