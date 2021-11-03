<template>
  <div class="order_detail order_form" :class="{on: accordian.active}">
    <a @click="toggleAccordian" class="link_accordion">
      <h3 class="tit_order on">02 배송지 입력</h3>
    </a>
    <field-shipping></field-shipping>
    <field-buyer></field-buyer>
    <field-fee v-show="false"></field-fee>
    <shipping-save v-if="!anonymousUser"></shipping-save>
    <button type="button" class="btn_order on" v-show="false">수정하기</button>
  </div>
  <!--<field-discount></field-discount>-->
</template>

<script>
  import { mapGetters, mapMutations, mapState } from 'vuex'

  import FieldDiscount from './discount/FieldDiscount'
  import FieldBuyer from './buyer/FieldBuyer'
  import FieldShipping from './shipping/FieldShipping'
  import ShippingSave from './shipping/ShippingSave'
  import FieldFee from './FieldFee'

  import accordian from '@/components/mixin/accordian'

  export default {
    name: 'order-field',
    components: {
      FieldDiscount,
      FieldBuyer,
      FieldShipping,
      FieldFee,
      ShippingSave
    },
    mixins: [accordian],
    computed: {
      ...mapState(['anonymousUser']),
    },
    created () {
      this.accordian.active = true
    }
  }
</script>
