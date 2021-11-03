<template>
  <dl class="list_inp list_phone">
    <dt class="screen_out">
      <label class="screen_out"
             for="oaPhone1">{{ isGlobal ? $t('fields.phone.label_phone') : $t('fields.phone.label_cell') }}
        <span class="screen_out">{{ $t('common.input_necessary') }}</span>
      </label>
    </dt>
    <dd>
      <div class="sort_country">
        <input type="text"
               class="tf_g tf_country"
               id="oaBuyerPhoneCountry"
               :value="phoneCountry"
               :title="$t('fields.phone.label')"
               maxlength="6"
               readonly>
      </div>
      <input type="text"
             class="tf_g tf_phone"
             id="buyerPhone"
             :placeholder="isGlobal ? $t('fields.phone.label_phone') : $t('fields.phone.label_cell')"
             v-model="phone">
    </dd>
  </dl>
</template>

<script>
import { mapState, mapMutations } from 'vuex'

export default {
  name: 'field-phone',
  props: {
    field: {
      type: String,
      required: true,
    },
  },
  computed: {
    ...mapState(['buyer', 'shipping']),
    phoneCountry: {
      get() {
        if (this.field === 'buyer') {
          return this.buyer.oaBuyerPhoneCountry
        } else {
          return this.shipping.oaPhoneCountry
        }
      },
    },
    phone: {
      get() {
        if (this.field === 'buyer') {
          return this.buyer.oaBuyerPhone
        } else {
          return this.shipping.oaPhone1
        }
      },
      set(phone) {
        if (this.field === 'buyer') {
          this.CHANGE_BUYER_FIELD({
            oaBuyerPhone: phone,
          })
        } else {
          this.CHANGE_SHIPPING_FIELDS({
            oaPhone1: phone,
          })
        }
      },
    },
    isGlobal() {
      if (this.field === 'buyer') {
        return this.phoneCountry !== 82
      } else {
        return this.shipping.oaCountryCode !== 'KR'
      }
    },
  },
  methods: {
    ...mapMutations(['CHANGE_BUYER_FIELD', 'CHANGE_SHIPPING_FIELDS']),
  },
}
</script>
