<template>

  <div class="group_order">
    <div class="area_order">
      <strong class="tit_product">{{ order.product[$i18n.locale === 'kr' ? 'prName' : 'prName1'] }}</strong>
      <span class="txt_price"></span>
    </div>
    <div class="box_select"><!-- 셀렉트박스를 클릭했을때 on 추가 -->
      <label for="tfItemCount" class="screen_out">{{ $t('cart.quantity') }}</label>
      <select id="tfItemCount" value="" class="tf_opt">
        <option value="20">{{ order.bsEa }}</option>
      </select>
    </div>
    <em class="txt_subtotal">
      <template v-if="!order.isDiscountPeriod">
        {{ order.productLevelPrice.prlpSaleprice1 * order.bsEa | krw }} {{ $t('common.krw') }}
      </template>
      <template v-else>
        {{ order.productLevelPrice.prlpDiscountprice1 * order.bsEa | krw }} {{ $t('common.krw') }}
        <br>
        <span class="prev_price">
            {{ order.productLevelPrice.prlpSaleprice1 * order.bsEa | krw }} {{ $t('common.krw') }}
          </span>
      </template>
      <template v-if="!order.isDiscountPeriod">
        {{ order.productLevelPrice.exchangePrice * order.bsEa | usd }} USD
      </template>
      <template v-else>
        {{ order.productLevelPrice.exchangeDiscountPrice * order.bsEa | usd }} USD
        <br>
        <span class="prev_price">
            {{ order.productLevelPrice.exchangePrice * order.bsEa | usd }} USD
          </span>
      </template>
    </em>
    <button type="button" class="btn_delete"><span class="ico_friends ico_delete">choice item delete</span></button>
  </div>

</template>

<script>
  import { order } from './cartProps'

  export default {
    name: 'cart-status',
    props: {
      order
    }
  }
</script>
