<template>
  <dl class="list_inp">
    <dt>
      <label class="lab_tf screen_out"
             for="tfoaN">{{ $t('fields.name.label') }}</label>
    </dt>
    <dd>
      <input class="tf_g"
             id="tfoaN"
             type="text"
             :placeholder="$t('fields.name.placeholder')"
             v-model.trim="name">
    </dd>
  </dl>
</template>

<script>
import { mapState, mapMutations } from 'vuex'

export default {
  name: 'field-name',
  props: {
    field: {
      type: String,
      required: true,
    },
  },
  computed: {
    ...mapState(['buyer', 'shipping']),
    name: {
      get() {
        if (this.field === 'buyer') {
          return this.buyer.oaBuyerName
        } else {
          return this.shipping.oaName
        }
      },
      set(name) {
        if (this.field === 'buyer') {
          this.CHANGE_BUYER_FIELD({
            oaBuyerName: name,
          })
        } else {
          this.CHANGE_SHIPPING_FIELDS({
            oaName: name,
          })
        }
      },
    },
  },
  methods: {
    ...mapMutations(['CHANGE_BUYER_FIELD', 'CHANGE_SHIPPING_FIELDS']),
  },
}
</script>
