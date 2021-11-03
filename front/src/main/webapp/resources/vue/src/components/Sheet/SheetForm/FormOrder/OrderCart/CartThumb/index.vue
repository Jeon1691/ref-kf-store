<template>
  <span class="wrap_thumb">
    <img v-src="product.prImage1"
         :alt="product.prName"
         class="thumb_g">
  </span>
</template>

<script>
export default {
  name: 'cart-thumb',
  props: {
    product: {
      type: Object,
      required: true,
    },
  },
}
</script>
