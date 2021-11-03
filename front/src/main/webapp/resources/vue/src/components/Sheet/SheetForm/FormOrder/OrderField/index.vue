<template>
  <div class="order_detail order_form">
    <field-discount></field-discount>
    <div class="group_order">
      <field-buyer></field-buyer>
      <field-shipping></field-shipping>
      <field-fee></field-fee>
    </div>
  </div>
</template>

<script>
import FieldDiscount from './FieldDiscount'
import FieldBuyer from './FieldBuyer'
import FieldShipping from './FieldShipping'
import FieldFee from './FieldFee'

export default {
  name: 'order-field',
  components: {
    FieldDiscount,
    FieldBuyer,
    FieldShipping,
    FieldFee,
  },
}
</script>
