import { mapState, mapGetters, mapMutations } from 'vuex'

export default {
  methods: {
    ...mapMutations(['CHANGE_SHIPPING_FIELDS', 'SHOW_MODAL', 'HIDE_MODAL']),
  },
}

export const country = {
  computed: {
    ...mapState(['country']),
  },
}

export const shipping = {
  computed: {
    ...mapGetters(['shipping']),
  },
}
