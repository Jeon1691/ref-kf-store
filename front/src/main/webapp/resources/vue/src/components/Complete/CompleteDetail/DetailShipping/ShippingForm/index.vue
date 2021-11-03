<template>
  <div class="change_delivery">
    <form ref="formShipping"
          :action="`/${$LANG}/order/shipping/address/change`"
          method="post"
          @submit.prevent="onSubmit"
          :class="{ form_global: globalOrder }">
      <form-hidden></form-hidden>

      <fieldset>
        <legend class="screen_out">{{ $t('shipping_address.change_form') }}</legend>
        <dl class="list_delivery">
          <dt>
            <label for="orderName">{{ $t('shipping_address.name') }}</label>
            <span class="ico_friends ico_star">{{ $t('input_necesary') }}</span>
          </dt>
          <dd>
            <div class="box_input">
              <input type="text"
                     name="oaName"
                     id="orderName"
                     class="tf_g"
                     :placeholder="$t('shipping_address.name')"
                     v-model="oaName">
            </div>
          </dd>

          <dt>
            <label for="orderPhone">{{ $t('shipping_address.phone_complete') }}</label>
            <span class="ico_friends ico_star">{{ $t('input_necesary') }}</span>
          </dt>
          <dd>
            <div class="box_input">
              <input type="text"
                     name="oaOrderErTel"
                     id="orderPhone"
                     class="tf_g"
                     :placeholder="$t('shipping_address.phone_complete')"
                     v-model="oaPhone">
            </div>
          </dd>

          <dt>
            <label for="orderPostal">{{ globalOrder ? $t('shipping_address.zip_code') : $t('shipping_address.postal')}}</label>
            <span class="ico_friends ico_star">{{ $t('input_necesary') }}</span>
          </dt>
          <dd class="subject_postal">
            <div class="box_input box_postal">
              <input type="text"
                     name="oaZoneCode_txt"
                     id="orderPostal"
                     class="tf_g tf_on"
                     :placeholder="$t('shipping_address.postal')"
                     v-model="oaZoneCode"
                     :disabled="!globalOrder">
            </div>

            <button v-if="!globalOrder"
                    type="button"
                    class="btn_postal"
                    @click="execDaumPostcode">{{ $t('shipping_address.postal') }}</button>
          </dd>

          <template v-if="globalOrder">
            <dt>
              <label class="lab_flow"
                     for="orderAddress1">State / Province</label>
              <span class="ico_friends ico_star">{{ $t('input_necesary') }}</span>
            </dt>
          </template>
          <template v-else>
            <dt>
              <label for="orderAddress1">{{ $t('shipping_address.addr1') }}</label>
              <span class="ico_friends ico_star">{{ $t('input_necesary') }}</span>
            </dt>
          </template>

          <template v-if="isUs">
            <dd class="wrap_opt">
              <div class="opt_sort"
                   :class="{ sort_open: isVisibleState }">
                <strong class="screen_out">select a US state code</strong>
                <a class="link_selected"
                   tabindex="-1"
                   @click="isVisibleState = !isVisibleState"
                   @blur="lazyHide">
                  <span class="txt_sort"
                        id="usState">{{ orderAddressRequest.oaAddr1 }}</span>
                  <span class="screen_out">selected</span>
                  <span class="ico_friends ico_arr"></span>
                </a>
                <div class="box_sort">
                  <em class="screen_out">select option</em>
                  <ul class="list_sort">
                    <li v-for="usState in usStateList"
                        :key="usState.CODE">
                      <a @click="changeState(usState)"
                         class="link_sort">{{ usState.CODE }} ({{ usState.STATE_EN }})</a>
                    </li>
                  </ul>
                </div>
              </div>
            </dd>
          </template>
          <template v-else>
            <dd>
              <div class="box_input">
                <input type="text"
                       name="oaAddr1_txt"
                       id="orderAddress1"
                       class="tf_g tf_on"
                       :placeholder="!globalOrder && $t('shipping_address.address')"
                       v-model="oaAddr1"
                       :disabled="!globalOrder">
              </div>
            </dd>
          </template>

          <dt>
            <label for="orderAddress2">{{ globalOrder ? 'City' : $t('shipping_address.addr2')}}</label>
            <span class="ico_friends ico_star">{{ $t('input_necesary') }}</span>
          </dt>
          <dd>
            <div class="box_input">
              <input type="text"
                     name="oaAddr2"
                     id="orderAddress2"
                     class="tf_g"
                     :placeholder="!globalOrder && $t('shipping_address.addr2')"
                     v-model="oaAddr2">
            </div>
          </dd>

          <template v-if="globalOrder">
            <dt>
              <label for="orderAddress3">Street</label>
              <span class="ico_friends ico_star">{{ $t('input_necesary') }}</span>
            </dt>
            <dd>
              <div class="box_input">
                <input type="text"
                       name="oaAddr3"
                       id="orderAddress3"
                       class="tf_g"
                       :placeholder="$t('shipping_address.write_english')"
                       v-model="oaAddr3">
              </div>
            </dd>
          </template>

          <dt>
            <label for="osDeliMemo">{{ $t('shipping_address.delivery_note') }}</label>
            <span class="txt_limit">
              <span class="txt_counter">({{ oaDeliMemoLength }}</span> / {{ $t('shipping_address.max_length') }})</span>
          </dt>
          <dd>
            <div class="box_input box_textarea">
              <textarea name="oaDeliMemo"
                        maxlength="50"
                        id="osDeliMemo"
                        class="tf_g"
                        v-model="oaDeliMemo"></textarea>
            </div>
            <p class="note_info">
              <span class="ico_friends ico_bullet"></span>
              <span v-html="$t('shipping_address.caution')"></span>
            </p>
          </dd>
        </dl>

        <div class="wrap_btn">
          <button type="button"
                  class="btn_change btn_cancel"
                  @click="onCancel">
            <span class="txt_g">{{ $t('shipping_address.cancel') }}</span>
          </button>
          <button type="submit"
                  class="btn_change btn_modify">
            <span class="txt_g">{{ $t('shipping_address.ok') }}</span>
          </button>
        </div>
      </fieldset>
    </form>
  </div>
</template>

<script>
import { mapMutations } from 'vuex'
import validations from '@/components/Shipping/ShippingDelivery/DeliveryForm/validations'
import { handleAlert } from '@/common/validations'
import Postcode from '@/components/common/Postcode'
import computed from './computed'
import FormHidden from './FormHidden'

export default {
  name: 'shipping-form',
  components: {
    FormHidden,
  },
  data() {
    return {
      orderAddressSnapshot: null,
      isVisibleState: false,
    }
  },
  computed,
  mounted() {
    this.orderAddressSnapshot = this.orderAddressRequest
  },
  methods: {
    ...mapMutations(['CHANGE_ORDER_ADDRESS_REQUEST', 'SHOW_DIALOG', 'SHOW_MODAL', 'HIDE_MODAL']),
    onSubmit() {
      if (this.$v.$invalid) {
        this.handleAlert(
          [
            ['oaName', 'order_validate.buyer.name'],
            ['oaPhone', 'order_validate.shipping.phone_set'],
            ['oaDeliMemo', 'order_validate.shipping.memo'],
            ['oaZoneCode', 'order_validate.shipping.zone_code'],
          ],
          [
            ['oaAddr1.required', 'order_validate.shipping.addr1'],
            ['oaAddr2.required', 'order_validate.shipping.addr2'],
            ['oaAddr2.isNotSpecialChar', 'order_validate.shipping.addr2_is_not_special_char'],
            ...(this.globalOrder
              ? [
                  ['oaAddr3.required', 'order_validate.shipping.addr2'],
                  ['oaAddr1.isAlpha', 'order_validate.shipping.addr1_is_alpha'],
                  ['oaAddr2.isAlpha', 'order_validate.shipping.addr1_is_alpha'],
                  ['oaAddr3.isAlpha', 'order_validate.shipping.addr1_is_alpha'],
                  ['oaAddr3.isNotSpecialChar', 'order_validate.shipping.addr2_is_not_special_char'],
                ]
              : []),
          ]
        )
      } else {
        this.$refs.formShipping.submit()
      }
    },
    onCancel() {
      this.CHANGE_ORDER_ADDRESS_REQUEST(this.orderAddressSnapshot)
      this.$emit('close')
    },
    execDaumPostcode() {
      this.SHOW_MODAL({
        name: 'post_layer',
        component: Postcode,
        onComplete: ({ zonecode, oaAddr1 }) => {
          this.orderAddressRequest.oaAddr1 = oaAddr1
          this.orderAddressRequest.oaZoneCode = zonecode

          this.HIDE_MODAL()
        },
      })
    },
    changeState(state) {
      this.CHANGE_ORDER_ADDRESS_REQUEST({
        oaAddr1: `${state.CODE} (${state.STATE_EN})`,
      })
      this.isVisibleState = false
    },
    lazyHide() {
      setTimeout(() => {
        this.isVisibleState = false
      }, 250)
    },
    handleAlert,
  },
  validations,
}
</script>
