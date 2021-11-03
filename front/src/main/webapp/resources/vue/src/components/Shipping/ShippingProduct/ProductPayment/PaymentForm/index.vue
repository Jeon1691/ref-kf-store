<template>
  <form v-if="!isOrderAddDeliEmpty"
        id="ini"
        name="ini"
        method="post"
        action="/orderadddeli/inicis">
    <form-hidden></form-hidden>

    <template v-if="!orderAddDeli.odOdPgTid && !orderAddDeli.odPayType">
      <input v-for="name in ['odOmNum', 'odOsSeq', 'odOsSerial']"
             :key="name"
             type="hidden"
             :name="name"
             :value="orderAddDeli[name]">
      <input v-for="name in ['oaBuyerName', 'oaBuyerEmail', 'oaBuyerPhone']"
             :key="name"
             type="hidden"
             :name="name"
             :value="orderShippingInfo.orderAddressRequest[name]">

      <div class="recover_info">
        <strong class="tit_sub">{{ $t('payment_form.recovery_cost') }}</strong>

        <dl class="cost_recover">
          <dt>{{ $t('payment_form.additional_cost') }} : </dt>
          <dd id="addDeli_price">
            {{ orderAddDeli.odReqMoney | krw }} {{ $t('common.krw') }}</dd>
        </dl>

        <div class="info_pay">
          <ul class="list_pay">
            <li>
              <span class="choice_g choice_radio">
                <input v-model="payType"
                       name="payType"
                       class="inp_g"
                       id="ptid_kakaopay"
                       value="kakaopay"
                       type="radio">
                <label class="lab_g"
                       for="ptid_kakaopay">
                  <span class="ico_friends ico_radio"></span>
                  <span class="ico_friends ico_kakaopay">kakaopay</span>
                </label>
              </span>
            </li>
            <li>
              <span class="choice_g choice_radio">
                <input v-model="payType"
                       name="payType"
                       class="inp_g"
                       id="ptid_onlycard"
                       value="onlycard"
                       type="radio">
                <label class="lab_g"
                       for="ptid_onlycard">
                  <span class="ico_friends ico_radio"></span>
                  {{ $t('payment_form.credit_card') }}
                </label>
              </span>
            </li>
          </ul>
        </div>
      </div>
    </template>
  </form>
</template>

<script>
import isEmpty from 'lodash/isEmpty'
import { mapState, mapMutations } from 'vuex'
import FormHidden from './FormHidden'

export default {
  name: 'payment-form',
  components: {
    FormHidden,
  },
  computed: {
    ...mapState(['orderAddDeli', 'orderShippingInfo']),
    isOrderAddDeliEmpty() {
      return isEmpty(this.orderAddDeli)
    },
    payType: {
      get() {
        return this.$store.state.payType
      },
      set(type) {
        this.CHANGE_PAY_TYPE(type)
      },
    },
  },
  mounted() {
    window.flashPayClose = () => {
      setTimeout(() => {
        this.SHOW_DIALOG({
          message: this.$t('order_submit.cancel_payment'),
        })
      }, 500)
    }
  },
  methods: {
    ...mapMutations(['CHANGE_PAY_TYPE', 'SHOW_DIALOG']),
  },
}
</script>