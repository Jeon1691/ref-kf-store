<template>
  <dl class="list_inp global_show">
    <dt class="global_show">
      <label class="lab_tf screen_out"
             for="orderAddress3">{{ $t('shipping.address.street') }}
        <span class="screen_out">{{ $t('common.input_necessary') }}</span>
      </label>
    </dt>
    <dd class="global_show">
      <input type="text"
             class="tf_g"
             id="orderAddress3"
             name="oaAddr3"
             :placeholder="$t('shipping.address.street')"
             v-model="oaAddr3">
    </dd>
  </dl>
</template>

<script>
import mixin from '../mixin'

export default {
  name: 'address-street',
  mixins: [mixin],
  computed: {
    oaAddr3: {
      get() {
        return this.$store.state.shipping.oaAddr3
      },
      set(oaAddr3) {
        this.CHANGE_SHIPPING_FIELDS({
          oaAddr3,
        })
      },
    },
  },
}
</script>
