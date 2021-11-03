<template>
  <div>
    <div class="choice_g"
         :class="{ on: shipping.oaAddressType === 'D' }">
      <label for="inpBasic"
             class="lab_g">{{ $t('shipping.type.label.default') }}</label>
      <input type="radio"
             id="inpBasic"
             name="oaAddressType"
             value="D"
             class="inp_g"
             :checked="shipping.oaAddressType === 'D'"
             @change="changeAddressType('D')">
      <span class="ico_newfriends_v1 ico_choice"></span>
    </div>

    <div class="choice_g"
         :class="{ on: shipping.oaAddressType === 'N' }">
      <label for="inpNew"
             class="lab_g">{{ $t('shipping.type.label.new') }}</label>
      <input type="radio"
             id="inpNew"
             name="oaAddressType"
             value="N"
             class="inp_g"
             :checked="shipping.oaAddressType === 'N'"
             @change="changeAddressType('N')">
      <span class="ico_newfriends_v1 ico_choice"></span>
    </div>
  </div>
</template>

<script>
import { mapState, mapGetters, mapMutations } from 'vuex'

export default {
  name: 'shipping-type',
  computed: {
    ...mapState(['oaCountryName', 'deliveryaddress', 'memberAddress', 'country']),
    ...mapGetters(['shipping']),
  },
  methods: {
    ...mapMutations(['CHANGE_SHIPPING_FIELDS', 'CHANGE_OA_ADDRESS_TYPE', 'RESET_SHIPPING_FIELDS']),
    changeAddressType(value) {
      const isNew = value === 'N'

      this.CHANGE_OA_ADDRESS_TYPE(isNew ? 'N' : 'D')

      if (isNew) {
        this.RESET_SHIPPING_FIELDS({
          oaCountryCode: 'KR',
          oaCountryName: '한국',
          oaPhoneCountry: '82',
        })
      } else {
        if (!Object.keys(this.memberAddress).length) {
          return
        }

        const { name, addr1, addr2, addr3, zoneCode, phone, countryCode } = this.memberAddress
        const [oaPhoneCountry, oaPhone1] = phone.split('-')

        this.CHANGE_SHIPPING_FIELDS({
          oaCountryName: this.oaCountryName,
          oaCountryCode: countryCode,
          oaName: name,
          oaPhoneCountry,
          oaPhone1,
          oaZoneCode: zoneCode,
          oaAddr1: addr1,
          oaAddr2: addr2,
          oaAddr3: addr3,
          defaultAddressType: 'D',
        })
      }
    },
  },
}
</script>
