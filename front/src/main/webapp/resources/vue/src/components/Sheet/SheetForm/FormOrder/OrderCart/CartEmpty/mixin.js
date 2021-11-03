export default {
  computed: {
    isOutOfStock() {
      return this.order.bsEa > this.order.stEa
    },
  },
}
