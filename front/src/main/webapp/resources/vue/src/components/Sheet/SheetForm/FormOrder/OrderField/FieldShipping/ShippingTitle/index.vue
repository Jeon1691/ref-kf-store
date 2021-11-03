<template>
  <h3 class="tit_orderit">
    {{ $t('shipping.header.title') }}
    <template v-if="!anonymousUser">
      <a class="link_shipping"
         @click="handleModal">
        {{ $t('shipping.header.recent') }}
        <span class="ico_newfriends_v1 ico_arrow"></span>
      </a>
    </template>
  </h3>
</template>

<script>
import { mapState, mapGetters, mapMutations } from 'vuex'
import ShippingHistory from '../ShippingHistory'

export default {
  name: 'shipping-title',
  data() {
    return {
      isShowModal: false,
    }
  },
  computed: {
    ...mapState(['anonymousUser']),
    ...mapGetters(['shipping']),
  },
  methods: {
    ...mapMutations(['SHOW_MODAL']),
    handleModal() {
      this.SHOW_MODAL({
        component: ShippingHistory,
      })
    },
  },
}
</script>
