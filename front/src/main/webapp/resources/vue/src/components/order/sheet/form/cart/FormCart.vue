<template>
  <div class="order_cart" :class="{on: accordian.active}">
    <div class="group_accordion">
      <a @click="toggleAccordian">
        <h3 class="tit_order on">{{ $t('cart.title') }}</h3>
      </a>

      <ul class="list_cart">
        <li v-for="(order, index) in basket.orderSheetExpansions"
            :key="order.product.prCode">

          <cart-thumb :product="order.product"></cart-thumb>
          <cart-status :order="order"></cart-status>
          <cart-item v-if="!(shipping.isGlobal && order.product.prForeigndeliyn === 'N') && !order.isSoldOut"
                     :order="order"
                     :index="index"></cart-item>

          <cart-empty :shipping="shipping"
                      :order="order"></cart-empty>
        </li>
      </ul>

      <cart-price :basket="basket" :payment="payment"></cart-price>
    </div>
  </div>
</template>

<script>
  import { mapGetters } from 'vuex'
  import CartEmpty from './CartEmpty'
  import CartItem from './CartItem'
  import CartThumb from './CartThumb'
  import CartStatus from './CartStatus'
  import CartInfo from './CartInfo'
  import CartPrice from './CartPrice'

  import accordian from '@/components/mixin/accordian'

  export default {
    name: 'order-cart',
    components: {
      CartEmpty,
      CartItem,
      CartThumb,
      CartStatus,
      CartInfo,
      CartPrice
    },
    mixins: [accordian],
    computed: {
      ...mapGetters(['basket', 'shipping', 'payment'])
    }
  }
</script>
