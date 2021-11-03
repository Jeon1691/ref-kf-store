<template>
  <div class="order_layer">
    <div class="inner_layer">
      <div class="layer_head">
        <strong class="tit_order">{{ $t('shipping.history.title') }}</strong>
      </div>

      <div v-if="deliveryaddress.length > 0"
           class="layer_body">
        <form @submit.prevent="onSubmit">
          <fieldset>
            <legend class="screen_out">{{ $t('shipping.history.legend') }}</legend>
            <ul class="list_address">
              <li v-for="(address, index) in deliveryaddress"
                  :key="index">
                <span class="choice_g choice_radio">
                  <input type="radio"
                         id="checkAddress1"
                         name="chk"
                         class="inp_g"
                         :value="address"
                         v-model="selectedAddress">

                  <label for="checkAddress1"
                         class="lab_g">
                    <span class="ico_friends ico_radio"></span>
                    <span class="txt_name"
                          id="checkAddress1_name">{{ address.oaName }}</span>
                    <span class="txt_address">
                      <span class="tit_object">{{ $t('shipping.history.phone') }} : </span>
                      <span class="txt_object"
                            id="checkAddress1_phone">{{ address.oaPhone }}</span>
                    </span>
                    <span class="txt_address">
                      <span class="tit_object">{{ $t('shipping.history.address') }} : </span>
                      <span class="txt_object">{{ address.oaZipCode || address.oaZoneCode }} {{ address.oaAddr1 }} {{ address.oaAddr2 }} {{ address.oaAddr3 }}</span>
                    </span>
                  </label>
                </span>
              </li>
            </ul>

            <p class="desc_address">
              <span class="ico_friends ico_bullet"></span>
              {{ $t('shipping.history.select_up') }}
            </p>

            <button type="submit"
                    class="btn_check btn_confirm"
                    id="btn_confirm">{{ $t('common.ok') }}</button>
            <button type="button"
                    class="btn_check btn_cancel"
                    @click="HIDE_MODAL">{{ $t('common.cancel') }}</button>
          </fieldset>
        </form>
      </div>
      <div v-else
           class="layer_body">
        <div class="box_desc">
          <p class="desc_layer">
            {{ $t('shipping.history.empty') }}
          </p>
        </div>
        <button type="button"
                class="btn_verify btn_confirm"
                @click="HIDE_MODAL">
          {{ $t('common.ok') }}
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapGetters, mapMutations, mapActions } from 'vuex'

export default {
  name: 'shipping-history',
  data() {
    return {
      selectedAddress: {},
    }
  },
  computed: {
    ...mapState(['deliveryaddress']),
    ...mapGetters(['shipping']),
  },
  methods: {
    ...mapMutations(['CHANGE_SHIPPING_FIELDS', 'HIDE_MODAL']),
    ...mapActions(['changeNation']),
    onSubmit() {
      const {
        oaCountryName,
        oaCountryCode,
        oaName,
        oaPhone,
        oaZoneCode,
        oaAddr1,
        oaAddr2,
        oaAddr3,
      } = this.selectedAddress
      const [oaPhoneCountry, oaPhone1] = oaPhone.split('-')

      this.changeNation({
        oaCountryName,
        oaCountryCode,
        oaName,
        oaPhoneCountry,
        oaPhone1,
        oaZoneCode,
        oaAddr1,
        oaAddr2,
        oaAddr3,
      })

      this.HIDE_MODAL()
    },
  },
  mounted() {
    this.selectedAddress = this.deliveryaddress[0]
  },
}
</script>

<style>
.order_layer .tit_order {
  padding-bottom: 0;
  border-bottom: 0;
}

.info_shipping .order_layer .choice_g {
  margin: 0;
}
</style>
