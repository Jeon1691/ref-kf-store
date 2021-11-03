<template>
  <form ref="ini"
        id="ini"
        name="ini"
        method="post"
        action="/order/inicis"
        :class="{ form_global: shipping.isGlobal }">
    <form-hidden></form-hidden>
    <form-order></form-order>
  </form>
</template>

<script>
import { mapState, mapGetters, mapMutations } from 'vuex'
import { validationMixin } from 'vuelidate'
import ua from '@/common/ua'
import FormHidden from './FormHidden'
import FormOrder from './FormOrder'

export default {
  name: 'sheet-form',
  mixins: [validationMixin],
  components: {
    FormHidden,
    FormOrder,
  },
  computed: {
    ...mapState(['orderCommon', 'errMsg']),
    ...mapGetters(['shipping']),
  },
  methods: {
    ...mapMutations(['SHOW_DIALOG']),
  },
  mounted() {
    const { StartSmartUpdate } = window

    if (!ua.device.type && ua.browser.name !== 'chrome') {
      StartSmartUpdate()
    }

    if (this.errMsg) {
      this.SHOW_DIALOG({
        message: this.errMsg,
      })
    }
  },
}
</script>
