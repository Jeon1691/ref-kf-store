<template>
  <div class="order_detail order_readonly">
    <div class="group_order">
      <detail-order></detail-order>
      <detail-buyer></detail-buyer>
    </div>
    <detail-shipping></detail-shipping>
  </div>
</template>

<script>
import DetailBuyer from './DetailBuyer'
import DetailOrder from './DetailOrder'
import DetailShipping from './DetailShipping'

export default {
  name: 'complete-detail',
  components: {
    DetailBuyer,
    DetailOrder,
    DetailShipping,
  },
}
</script>
