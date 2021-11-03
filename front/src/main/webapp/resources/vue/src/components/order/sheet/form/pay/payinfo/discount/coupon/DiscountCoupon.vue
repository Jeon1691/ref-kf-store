<template>
  <li class="area_pay_group">
    <strong>{{ $t('discount.coupon.title') }}</strong>
    <p class="select_box">
      <label for="optCoupon">없음</label>
      <select name="opt_coupon" id="optCoupon" disabled>
        <option>없음</option>
        <option value="">10%할인</option>
        <option value="">20%할인</option>
        <option value="">30%할인</option>
      </select>
    </p>
  </li>
  <!--<div class="info_discount">-->
    <!--<strong class="tit_discount screen_out"></strong>-->
    <!--<div class="group_discount" v-show="false">-->
      <!--<dl class="list_append">-->
        <!--<dt>{{ $t('discount.coupon.available_coupon') }}</dt>-->
        <!--<dd id="coupon_count">{{ membership.myAvailableCouponCount }} {{ $i18n.locale === 'kr' ? '개' : '' }}</dd>-->
      <!--</dl>-->
      <!--<button type="button"-->
              <!--class="btn_g btn_coupon"-->
              <!--@click="showCouponModal">-->
        <!--<span class="txt_g">{{ $t('discount.coupon.search') }}</span>-->
      <!--</button>-->
    <!--</div>-->

    <!--<div class="group_coupon">-->
      <!--<coupon-selected v-if="Object.keys(discount.coupon.applied.duplicate).length"-->
                       <!--:coupon="discount.coupon.applied.duplicate"-->
                       <!--:deleteCoupon="deleteCoupon"-->
                       <!--:couponType="'duplicate'"></coupon-selected>-->
      <!--<coupon-selected v-if="Object.keys(discount.coupon.applied.normal).length"-->
                       <!--:coupon="discount.coupon.applied.normal"-->
                       <!--:deleteCoupon="deleteCoupon"-->
                       <!--:couponType="'normal'"></coupon-selected>-->
    <!--</div>-->
  <!--</div>-->
</template>

<script>
  import { mapGetters, mapMutations, mapState } from 'vuex'
  import CouponSelected from './CouponSelected'
  import CouponList from './list/CouponList'

  export default {
    name: 'discount-coupon',
    components: {
      CouponSelected
    },
    computed: {
      ...mapState(['membership']),
      ...mapGetters(['discount'])
    },
    methods: {
      ...mapMutations(['CHANGE_DISCOUNT_FIELDS', 'SHOW_MODAL']),
      showCouponModal () {
        this.SHOW_MODAL({
          name: 'salecoupon_layer',
          component: CouponList
        })
      },
      deleteCoupon (type) {
        this.CHANGE_DISCOUNT_FIELDS({
          coupon: {
            ...this.discount.coupon,
            applied: {
              ...this.discount.coupon.applied,
              [type]: {}
            }
          }
        })
      }
    }
  }
</script>
