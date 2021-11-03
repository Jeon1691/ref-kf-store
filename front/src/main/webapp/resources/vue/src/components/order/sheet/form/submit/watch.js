export default {
  'shipping.isGlobal'(isGlobal) {
    if (isGlobal) {
      this.renderPaypal()
    }
  },
  '$v.$invalid'(isTrue) {
    if (this.shipping.isGlobal) {
      if (isTrue) {
        this.actions.disable()
      } else {
        this.actions.enable()
      }
    }
  },
}
