<template>
  <div class="product_area">
    <product-info></product-info>
    <product-payment></product-payment>
  </div>
</template>

<script>
import ProductInfo from './ProductInfo'
import ProductPayment from './ProductPayment'

export default {
  name: 'shipping-product',
  components: {
    ProductInfo,
    ProductPayment,
  },
}
</script>
