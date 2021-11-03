<template>
  <dl class="info_shipping">
    <dt>
      {{ $t('common.select_country') }}
    </dt>
    <dd>
      <p class="select_box">
        <label for="optCountry">{{ field === 'buyer' ? buyer.oaBuyerCountryName : shipping.oaCountryName }}</label>
        <select name="opt_country" id="optCountry" @change="onChangeBuyerNation" v-model="selectCountry">
          <option v-for="country in country.countryList"
                  :key="country.EC_CODE"
                  :value="country.EC_CODE.toLowerCase()">
            {{ $i18n.locale === 'kr' ? country.EC_COUNTRY : country.EC_COUNTRYENG }}
          </option>
        </select>
      </p>

    </dd>
  </dl>
</template>

<script>
  import { mapActions, mapGetters, mapMutations, mapState } from 'vuex'

  export default {
    name: 'form-field-country',
    props: {
      field: {
        type: String,
        required: true
      }
    },
    data () {
      return {
        isShowCountry: false,
        selectCountry: ''
      }
    },
    computed: {
      ...mapState(['buyer', 'country']),
      ...mapGetters(['shipping'])
    },
    mounted() {
      this.selectCountry = this.field === 'buyer' ? this.buyer.oaBuyerCountryCode.toLowerCase() : this.shipping.oaCountryCode.toLowerCase()
    },
    methods: {
      ...mapMutations(['CHANGE_BUYER_NATION']),
      ...mapActions(['changeNation']),
      onChangeBuyerNation () {
        const country = this.country.countryList.find(c => c.EC_CODE.toLowerCase() === this.selectCountry.toLowerCase())

        const oaCountryName = this.$i18n.locale === 'kr' ? country.EC_COUNTRY : country.EC_COUNTRYENG
        const oaCountryCode = country.EC_CODE
        const oaPhoneCountry = country.EC_PHONECODE

        if (this.field === 'buyer') {
          this.CHANGE_BUYER_NATION({
            oaCountryName,
            oaCountryCode,
            oaPhoneCountry
          })
        } else {
          this.changeNation({
            oaCountryName,
            oaCountryCode,
            oaPhoneCountry,
            oaAddr1: oaCountryCode === 'US' ? 'CA (California)' : ''
          })
        }

        this.isShowCountry = false
      },
      lazyHide () {
        setTimeout(() => {
          this.isShowCountry = false
        }, 250)
      }
    }
  }
</script>
