<template>
  <div class="order_detail order_pay">
    <h3 class="tit_orderit">{{ $t('order_pay_method.title') }}</h3>
    <div class="group_order">
      <div class="area_order">
        <ul class="list_orderpay list_pay">
          <li class="global_hide"
              v-if="!shipping.isGlobal">
            <div class="choice_g">
              <label for="ptid_kakaopay"
                     class="lab_g">
                <img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/img_kakaopay_180226.png"
                     class="thumb_g img_kakaopay"
                     :alt="$t('order_pay_method.kakaopay')">
              </label>
              <input type="radio"
                     id="ptid_kakaopay"
                     name="payType"
                     class="inp_g"
                     value="kakaopay"
                     v-model="payType">
              <span class="ico_newfriends_v1 ico_choice"></span>
            </div>
          </li>
          <li v-if="basket.payOnly > 0">
            <div class="choice_g">
              <label for="ptid_onlycard"
                     class="lab_g">{{ $t('order_pay_method.credit_card') }}</label>
              <input type="radio"
                     id="ptid_onlycard"
                     name="payType"
                     class="inp_g"
                     value="onlycard"
                     v-model="payType">
              <span class="ico_newfriends_v1 ico_choice"></span>
            </div>
          </li>
          <li class="global_show">
            <div class="choice_g">
              <label for="ptid_paypal"
                     class="lab_g">
                <img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/img_paypal.png"
                     class="thumb_g img_paypal"
                     alt="paypal">
              </label>
              <input type="radio"
                     id="ptid_paypal"
                     name="payType"
                     class="inp_g"
                     value="paypal"
                     v-model="payType">
              <span class="ico_newfriends_v1 ico_choice"></span>
            </div>
          </li>
        </ul>
      </div>

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

export default {
  name: 'order-pay-method',
  computed: {
    ...mapGetters(['basket', 'shipping']),
    payType: {
      get() {
        return this.$store.state.payType
      },
      set(type) {
        this.CHANGE_PAY_TYPE(type)
      },
    },
  },
  methods: {
    ...mapMutations(['CHANGE_PAY_TYPE']),
  },
}
</script>
