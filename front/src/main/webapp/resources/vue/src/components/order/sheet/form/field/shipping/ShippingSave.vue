<template>
  <dl class="info_shipping">
    <dt>내 정보 및 최근 배송지로 저장</dt>
    <dd class="area_checkbox">
      <div class="chk_common">
        <input type="checkbox" id="chkDefatulAddress" v-model="defaultAddressType"/>
        <label for="chkDefatulAddress"></label>
      </div>
      <label for="chkDefatulAddress" class="txt_label">내 정보 및 최근 배송지로 저장</label>
    </dd>
  </dl>
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
