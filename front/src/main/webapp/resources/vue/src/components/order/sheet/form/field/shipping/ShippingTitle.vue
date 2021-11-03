<template>

</template>

<script>
  import { mapGetters, mapMutations, mapState } from 'vuex'
  import ShippingHistory from './ShippingHistory'

  export default {
    name: 'shipping-title',
    data () {
      return {
        isShowModal: false
      }
    },
    computed: {
      ...mapGetters(['shipping'])
    },
    methods: {
      ...mapMutations(['SHOW_MODAL']),
      handleModal () {
        this.SHOW_MODAL({
          component: ShippingHistory
        })
      }
    }
  }
</script>
