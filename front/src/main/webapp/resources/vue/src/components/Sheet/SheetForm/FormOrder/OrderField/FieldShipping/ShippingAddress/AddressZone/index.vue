<template>
  <dl class="list_inp list_zipcode">
    <dt class="global_hide"
        v-if="!shipping.isGlobal">
      <label class="lab_tf screen_out"
             for="orderPostal">{{ $t('shipping.address.zip_code') }}
        <span class="screen_out">{{ $t('common.input_necessary') }}</span>
      </label>
    </dt>
    <dt class="global_show">
      <label class="lab_tf screen_out"
             for="orderPostal">{{ $t('shipping.address.zip_code') }}
        <span class="screen_out">{{ $t('common.input_necessary') }}</span>
      </label>
    </dt>
    <dd>
      <input type="text"
             class="tf_g tf_zipcode"
             id="orderPostal"
             name="oaZoneCode_txt"
             :readonly="!shipping.isGlobal"
             :placeholder="`${shipping.isGlobal ? $t('shipping.address.zip_code') : $t('shipping.address.postal')}`"
             v-model="oaZoneCode">

      <div class="sort_btn">
        <button type="button"
                class="btn_g global_hide"
                v-if="!shipping.isGlobal"
                @click="handleModal">{{ $t('shipping.address.postal') }}</button>
      </div>
    </dd>
  </dl>
</template>

<script>
import Postcode from '@/components/common/Postcode'
import mixin, { shipping } from '../mixin'

export default {
  name: 'address-zone',
  mixins: [mixin, shipping],
  computed: {
    oaZoneCode: {
      get() {
        return this.$store.state.shipping.oaZoneCode
      },
      set(oaZoneCode) {
        this.CHANGE_SHIPPING_FIELDS({
          oaZoneCode,
        })
      },
    },
  },
  methods: {
    handleModal() {
      this.SHOW_MODAL({
        name: 'post_layer',
        component: Postcode,
        onComplete: ({ zonecode, oaAddr1 }) => {
          this.CHANGE_SHIPPING_FIELDS({
            oaZoneCode: zonecode,
            oaAddr1,
          })
          this.HIDE_MODAL()
        },
      })
    },
  },
}
</script>
