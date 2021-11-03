<template>
  <dl class="info_schoice">
    <dt>{{ $t('discount.coupon_list.regular_discount') }}</dt>
    <dd class="item_type1">
      <div class="choice_g choice_sale">
        <label for="inpCoupon3"
               class="lab_g">{{ $t('discount.coupon_list.not_applicable') }}</label>
        <input type="radio"
               id="inpCoupon3"
               value=""
               name="coupon2"
               class="inp_g"
               v-model="selectedCoupon">
        <span class="ico_newfriends_v1 ico_choice"></span>
      </div>
    </dd>
    <dd v-for="(coupon, index) in coupon.normalCoupon"
        :key="coupon.cph_CODE"
        :id="`coup_${index}`">
      <div class="choice_g choice_sale">
        <label :for="`nomCoupon${index}`"
               class="lab_g">
          <template v-if="coupon.cph_OPTION_TYPE === '무료배송'">
            {{ coupon.cph_OPTION_TYPE }}
          </template>

          <template v-if="coupon.cph_OPTION_TYPE !== 'D'">
            <span class="usd_check usd_show">
              {{ coupon.cph_PRICE | krw }} {{ $t('common.krw') }}
            </span>
            <span class="usd_check">
              {{ coupon.cph_PRICE_EXCHANGE | usd }} USD
            </span>
            {{ $t('discount.coupon_list.discount_coupon') }}
          </template>

          <em class="txt_info">
            {{ coupon.CT_NAME || $t('discount.coupon_list.all') }}
            <template v-if="coupon.CT_NAME">{{ $t('discount.coupon_list.category') }}</template>
            / {{ coupon.cph_SDATE | date }} ~ {{ coupon.cph_EDATE | date }} {{ $i18n.locale === 'kr' ? '까지' : '' }}
          </em>
        </label>
        <input type="radio"
               :id="`nomCoupon`"
               :value="coupon"
               name="coupon2"
               class="inp_g"
               v-model="selectedCoupon">
        <span class="ico_newfriends_v1 ico_choice"></span>
      </div>
    </dd>
  </dl>
</template>

<script>
import { mapGetters, mapMutations } from 'vuex'

export default {
  name: 'list-normal',
  computed: {
    ...mapGetters(['coupon', 'discount']),
    selectedCoupon: {
      get() {
        return this.$store.state.discount.coupon.selected.normal
      },
      set(normal) {
        this.CHANGE_DISCOUNT_FIELDS({
          coupon: {
            ...this.discount.coupon,
            selected: {
              ...this.discount.coupon.selected,
              normal,
            },
          },
        })
      },
    },
  },
  methods: {
    ...mapMutations(['CHANGE_DISCOUNT_FIELDS']),
  },
}
</script>
