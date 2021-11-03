import { mapMutations, mapState } from 'vuex'

export const buyer = {
  computed: {
    ...mapState(['buyer']),
  },
  methods: {
    ...mapMutations(['CHANGE_BUYER_FIELD']),
  },
}
