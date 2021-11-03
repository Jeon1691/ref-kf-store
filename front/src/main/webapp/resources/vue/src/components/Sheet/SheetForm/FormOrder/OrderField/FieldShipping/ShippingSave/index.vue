<template>
  <div class="group_baseaddress">
    <div class="chk_g">
      <input type="checkbox"
             id="chkDefatulAddress"
             class="inp_g"
             v-model="defaultAddressType">
      <label for="chkDefatulAddress"
             class="lab_g">
        <span class="ico_newfriends_v1 ico_choice"></span>
        {{ $t('shipping.save.label') }}
      </label>
    </div>
  </div>
</template>

<script>
import { mapMutations } from 'vuex'

export default {
  name: 'shipping-save',
  computed: {
    defaultAddressType: {
      get() {
        return this.$store.state.defaultAddressType
      },
      set(checked) {
        this.CHANGE_SHIPPING_FIELDS({
          defaultAddressType: checked ? 'S' : 'D',
        })
      },
    },
  },
  methods: {
    ...mapMutations(['CHANGE_SHIPPING_FIELDS']),
  },
}
</script>
