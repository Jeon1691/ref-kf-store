<template>
  <dl class="list_price">
    <dt>{{ $t('agree_payinfo.discount.title') }}</dt>
    <dd class="usd_check usd_show">
      <strong id="discount_price">
        <span class="num_price">{{ discount.totalDiscountPrice | krw }}</span>{{ $t('common.krw') }}
      </strong>
      <!--<span class="txt_usd">{{ discount.exchangeTotalDiscountPrice | usd }} USD</span>-->
    </dd>
    <dd class="usd_check">
      <strong id="discount_price">{{ discount.exchangeTotalDiscountPrice | usd }} USD</strong>
    </dd>
  </dl>
</template>

<script>
import { discount } from './payinfoMixin'

export default {
  name: 'payinfo-discount',
  mixins: [discount],
}
</script>
