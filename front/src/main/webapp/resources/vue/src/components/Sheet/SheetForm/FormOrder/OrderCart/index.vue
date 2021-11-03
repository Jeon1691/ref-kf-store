<template>
  <div class="order_cart">
    <h3 class="tit_orderit">{{ $t('cart.title') }}</h3>
    <ul class="list_cart">
      <li v-for="(order, index) in basket.orderSheetExpansions"
          :key="order.product.prCode">
        <cart-empty :shipping="shipping"
                    :order="order"></cart-empty>
        <cart-thumb :product="order.product"></cart-thumb>
        <cart-status :order="order"></cart-status>
        <cart-item v-if="!(shipping.isGlobal && order.product.prForeigndeliyn === 'N') && !order.isSoldOut"
                   :order="order"
                   :index="index"></cart-item>
      </li>
    </ul>

    <cart-price :basket="basket"></cart-price>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import CartEmpty from './CartEmpty'
import CartItem from './CartItem'
import CartThumb from './CartThumb'
import CartStatus from './CartStatus'
import CartPrice from './CartPrice'

export default {
  name: 'order-cart',
  components: {
    CartEmpty,
    CartItem,
    CartThumb,
    CartStatus,
    CartPrice,
  },
  computed: {
    ...mapGetters(['basket', 'shipping']),
  },
}
</script>
