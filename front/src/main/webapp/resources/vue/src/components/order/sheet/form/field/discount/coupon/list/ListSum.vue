<template>
  <dl class="info_sprice">
    <dt>{{ $t('discount.coupon_list.discounted_price') }}</dt>
    <dd class="usd_check usd_show">
      <em class="num_price"
          id="tot_coupon_price">{{ discount.selectedCouponPrice | krw }} {{ $t('common.krw') }}</em>
      <span>{{ discount.exchangeselectedCouponPrice | usd }} USD</span>
    </dd>
    <dd class="usd_check">
      <em class="num_price"
          id="tot_coupon_price">{{ discount.exchangeselectedCouponPrice | usd }} USD</em>
    </dd>
  </dl>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'list-sum',
  computed: {
    ...mapGetters(['discount']),
  },
}
</script>

<style scoped>
.num_price {
  margin-right: 0;
}
</style>
