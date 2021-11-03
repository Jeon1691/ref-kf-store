<template>
  <dl v-if="coupon.duplicateCoupon.length > 0"
      class="info_schoice"
      id="dupl_coupon">
    <dt>{{ $t('discount.coupon_list.overlap_discount') }}</dt>
    <dd class="item_type1">
      <div class="choice_g choice_sale">
        <label for="inpCoupon1"
               class="lab_g">{{ $t('discount.coupon_list.not_applicable') }}</label>
        <input type="radio"
               id="inpCoupon1"
               name="coupon1"
               class="inp_g"
               value=""
               v-model="selectedCoupon">
        <span class="ico_newfriends_v1 ico_choice"></span>
      </div>
    </dd>
    <dd v-for="(coupon, index) in coupon.duplicateCoupon"
        :key="coupon.cph_CODE"
        :id="`coup_${index}`">
      <div class="choice_g choice_sale">
        <label :for="`dulinpCoupon${index}`"
               class="lab_g">
          <template v-if="coupon.cph_OPTION_TYPE === 'D'">
            {{ coupon.cph_OPTION_TYPE_NM }}
          </template>
          <template v-else>
            <span class="usd_check usd_show">
              {{ coupon.cph_PRICE | krw }} {{ $t('common.krw') }}
            </span>
            <span class="usd_check">
              {{ coupon.cph_PRICE_EXCHANGE }} USD
            </span>
            {{ $t('discount.coupon_list.discount_coupon') }}
          </template>

          <em class="txt_info">
            {{ coupon.CT_NAME || $t('all') }}
            <template v-if="coupon.CT_NAME">
              {{ $t('discount.coupon_list.category') }}
            </template>
            / {{ coupon.cph_SDATE | date }} ~ {{ coupon.cph_EDATE | date }} {{ $i18n.locale === 'kr' ? '까지' : '' }}
          </em>
        </label>

        <input type="radio"
               :id="`dulinpCoupon${index}`"
               name="coupon1"
               class="inp_g"
               :value="coupon"
               v-model="selectedCoupon">
        <span class="ico_newfriends_v1 ico_choice"></span>
      </div>
    </dd>
  </dl>
</template>

<script>
import { mapGetters, mapMutations } from 'vuex'

export default {
  name: 'list-duplicate',
  computed: {
    ...mapGetters(['coupon']),
    selectedCoupon: {
      get() {
        return this.$store.state.discount.coupon.selected.duplicate
      },
      set(duplicate) {
        this.CHANGE_DISCOUNT_FIELDS({
          coupon: {
            ...this.discount.coupon,
            selected: {
              ...this.discount.coupon.selected,
              duplicate,
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
