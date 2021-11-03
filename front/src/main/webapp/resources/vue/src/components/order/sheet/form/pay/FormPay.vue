<template>
  <div class="order_pay" :class="{on: accordian.active}">
    <a @click="toggleAccordian" class="link_accordion">
      <h3 class="tit_order on">03 결제수단 선택</h3>
    </a>
    <button type="button" class="btn_coupon_info" @click="orderAttentionPopup">쿠폰/포인트 안내</button>
    <payinfo></payinfo>
    <div class="area_choice_pay">
      <strong>{{ $t('order_pay_method.title') }}</strong>
      <div class="group_order">
        <label for="ptid_kakaopay" v-if="!shipping.isGlobal" :class="{on: payType === 'kakaopay'}">
          <span class="ico_kakaopay"></span>
          <span class="txt_pay">카카오페이</span>
        </label>
        <label for="ptid_onlycard" :class="{on: payType === 'onlycard'}">
          <span class="ico_card"></span>
          <span class="txt_pay">신용카드</span>
        </label>
        <label for="ptid_paypal" v-if="shipping.isGlobal"  :class="{on: payType === 'paypal'}">
          <span class="ico_paypal"></span>
          <span class="txt_pay">Paypal</span>
        </label>
        <input type="radio" id="ptid_kakaopay" name="payType" value="kakaopay" class="screen_out" v-model="payType">
        <input type="radio" id="ptid_onlycard" name="payType" value="onlycard" class="screen_out" v-model="payType">
        <input type="radio" id="ptid_paypal" name="payType" value="paypal" class="screen_out" v-model="payType">
      </div>

      <form-agree></form-agree>
    </div>

    <h3 class="tit_orderit"></h3>
    <div class="group_order">
      <div class="guide_bubble box_attention_card global_hide"
           v-if="!shipping.isGlobal"
           v-show="payType === 'onlycard'"
           style="display: block">
        <span class="ico_newfriends_v1 ico_arrow"></span>
        <strong class="tit_bubble">{{ $t('order_pay_method.caution.refund.title') }}</strong>
        <p class="desc_bubble"
           v-html="$t('order_pay_method.caution.refund.desc')"></p>
      </div>

      <div class="guide_bubble global_show">
        <span class="ico_newfriends_v1 ico_arrow"></span>
        <strong class="tit_bubble">{{ $t('order_pay_method.caution.currency.title') }}</strong>
        <p class="desc_bubble">{{ $t('order_pay_method.caution.currency.desc') }}</p>
      </div>
    </div>

    <div class="guide_warning global_show">
      <strong class="tit_warning">{{ $t('order_pay_method.caution.global.title') }}</strong>
      <template v-if="$i18n.locale === 'kr'">
        <p class="desc_warning"
           v-html="$t('order_pay_method.caution.global.desc[0]')"></p>
        <p class="desc_warning">{{ $t('order_pay_method.caution.global.desc[1]') }}</p>
      </template>
      <template v-else>
        <p class="desc_warning"
           v-html="$t('order_pay_method.caution.global.desc')"></p>
      </template>
    </div>
  </div>
</template>

<script>
  import { mapGetters, mapMutations } from 'vuex'
  import Payinfo from './payinfo/Payinfo'
  import accordian from '@/components/mixin/accordian'
  import DiscountNote from './payinfo/discount/DiscountNote'
  import FormAgree from '../agree/FormAgree'

  export default {
    name: 'order-pay-method',
    components: {
      Payinfo,
      FormAgree
    },
    mixins: [accordian],
    computed: {
      ...mapGetters(['shipping']),
      payType: {
        get () {
          return this.$store.state.payType
        },
        set (type) {
          this.CHANGE_PAY_TYPE(type)
        }
      }
    },
    methods: {
      ...mapMutations(['CHANGE_PAY_TYPE', 'SHOW_MODAL']),
      orderAttentionPopup () {
        this.SHOW_MODAL({
          name: 'attention_layer',
          component: DiscountNote
        })
      }
    }
  }
</script>
