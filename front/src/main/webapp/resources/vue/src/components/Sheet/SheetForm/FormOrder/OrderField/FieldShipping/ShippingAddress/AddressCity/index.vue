<template>
  <dl class="list_inp">
    <dt class="global_hide"
        v-if="!shipping.isGlobal">
      <label class="lab_tf screen_out"
             for="orderAddress2">{{ $t('shipping.address.addr2') }}
        <span class="screen_out">{{ $t('common.input_necessary') }}</span>
      </label>
    </dt>
    <dt class="global_show">
      <label class="lab_tf screen_out"
             for="orderAddress2">{{ $t('shipping.address.city') }}
        <span class="screen_out">{{ $t('common.input_necessary') }}</span>
      </label>
    </dt>
    <dd>
      <input type="text"
             class="tf_g"
             id="orderAddress2"
             name="oaAddr2"
             :placeholder="`${!shipping.isGlobal ? $t('shipping.address.addr2') : $t('shipping.address.city')}`"
             v-model="oaAddr2">
    </dd>
  </dl>
</template>

<script>
import mixin, { shipping } from '../mixin'

export default {
  name: 'address-city',
  mixins: [mixin, shipping],
  computed: {
    oaAddr2: {
      get() {
        return this.$store.state.shipping.oaAddr2
      },
      set(oaAddr2) {
        this.CHANGE_SHIPPING_FIELDS({
          oaAddr2,
        })
      },
    },
  },
}
</script>