import { mapGetters } from 'vuex'

export const discount = {
  computed: {
    ...mapGetters(['discount']),
  },
}

export const basket = {
  computed: {
    ...mapGetters(['basket']),
  },
}

export const payment = {
  computed: {
    ...mapGetters(['payment']),
  },
}
