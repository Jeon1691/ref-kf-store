<template>
  <div class="order_detail order_agree list_agree">
    <agree-checkbox></agree-checkbox>
    <agree-payinfo></agree-payinfo>
  </div>
</template>

<script>
import AgreeCheckbox from './AgreeCheckbox'
import AgreePayinfo from './AgreePayinfo'

export default {
  name: 'order-agree',
  components: {
    AgreeCheckbox,
    AgreePayinfo,
  },
}
</script>
