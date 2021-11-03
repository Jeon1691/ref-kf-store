<template>
  <dl class="list_inp">
    <dt class="screen_out">
      {{ $t('common.select_country') }}
      <span class="screen_out">{{ $t('common.input_necessary') }}</span>
    </dt>
    <dd>
      <div class="opt_g opt_country"
           :class="{ opt_on: isShowCountry }">
        <strong class="screen_out">{{ $t('fields.countries.select_country') }}</strong>

        <a class="link_selected"
           tabindex="-1"
           @click="isShowCountry = !isShowCountry"
           @blur="lazyHide">
          <span class="txt_opt">
            {{ field === 'buyer' ? buyer.oaBuyerCountryName : shipping.oaCountryName }}
          </span>
          <span class="screen_out">{{ $t('common.selected') }}</span>
          <span class="ico_newfriends_v1 ico_opt"></span>
        </a>

        <div class="box_opt">
          <em class="screen_out">{{ $t('common.select_option') }}</em>
          <ul class="list_opt">
            <li v-for="country in country.countryList"
                :key="country.EC_CODE">
              <a class="link_opt"
                 @click="onChangeBuyerNation(country)">
                {{ $i18n.locale === 'kr' ? country.EC_COUNTRY : country.EC_COUNTRYENG }}
              </a>
            </li>
          </ul>
        </div>
      </div>
    </dd>
  </dl>
</template>

<script>
import { mapState, mapGetters, mapMutations, mapActions } from 'vuex'

export default {
  name: 'field-countries',
  props: {
    field: {
      type: String,
      required: true,
    },
  },
  data() {
    return {
      isShowCountry: false,
    }
  },
  computed: {
    ...mapState(['buyer', 'country']),
    ...mapGetters(['shipping']),
  },
  methods: {
    ...mapMutations(['CHANGE_BUYER_NATION']),
    ...mapActions(['changeNation']),
    onChangeBuyerNation(country) {
      const oaCountryName = this.$i18n.locale === 'kr' ? country.EC_COUNTRY : country.EC_COUNTRYENG
      const oaCountryCode = country.EC_CODE
      const oaPhoneCountry = country.EC_PHONECODE

      if (this.field === 'buyer') {
        this.CHANGE_BUYER_NATION({
          oaCountryName,
          oaCountryCode,
          oaPhoneCountry,
        })
      } else {
        this.changeNation({
          oaCountryName,
          oaCountryCode,
          oaPhoneCountry,
          oaAddr1: oaCountryCode === 'US' ? 'CA (California)' : '',
        })
      }

      this.isShowCountry = false
    },
    lazyHide() {
      setTimeout(() => {
        this.isShowCountry = false
      }, 250)
    },
  },
}
</script>
