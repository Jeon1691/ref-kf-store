<template>
  <strong class="emph_cart">
    <template v-if="isNoProduct">
      <span class="ico_newfriends_v1 ico_noglobal"></span> {{ $t('cart.not_eligible_global') }}
    </template>
    <template v-else-if="order.isSoldOut">
      <span class="ico_newfriends_v1 ico_soldout"></span>{{ $t('cart.is_soldout') }}
    </template>
    <template v-else-if="isOutOfStock">
      <span class="ico_newfriends_v1 ico_soldout"></span>{{ $t('cart.out_of_stock') }}
    </template>
  </strong>
</template>

<script>
import { order } from '../props'
import mixin from './mixin'

export default {
  name: 'cart-empty',
  mixins: [mixin],
  props: {
    shipping: {
      type: Object,
    },
    order,
  },
  computed: {
    isNoProduct() {
      return this.shipping.isGlobal && this.order.product.prForeigndeliyn === 'N'
    },
  },
}
</script>
