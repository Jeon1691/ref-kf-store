<template>
  <div class="info_order info_shipping">
    <h4>{{ $t('shipping.header.title') }}</h4>
    <div class="btn_copy_info area_checkbox">
      <template v-if="!anonymousUser">
        <a class="link_shipping"
           @click="handleModal" v-show="false">
          {{ $t('shipping.header.recent') }}
          <span class="ico_newfriends_v1 ico_arrow"></span>
        </a>
      </template>
      <template v-if="false">
        <label for="chkCopyInfo" class="txt_label">주문고객과 동일</label>
        <div class="chk_common">
          <input type="checkbox" id="chkCopyInfo" />
          <label for="chkCopyInfo"></label>
        </div>
      </template>
    </div>
    <shipping-type v-if="!anonymousUser"></shipping-type>
    <shipping-nation></shipping-nation>
    <shipping-name></shipping-name>
    <shipping-phone></shipping-phone>
    <shipping-address></shipping-address>

    <shipping-memo></shipping-memo>
    <shipping-guide v-show="false"></shipping-guide>

  </div>
</template>

<script>
  import { mapGetters, mapMutations, mapState } from 'vuex'
  import ShippingHistory from './ShippingHistory'
  import ShippingType from './ShippingType'
  import ShippingNation from './ShippingNation'
  import ShippingName from './ShippingName'
  import ShippingPhone from './ShippingPhone'
  import ShippingAddress from './address/ShippingAddress'
  import ShippingSave from './ShippingSave'
  import ShippingMemo from './ShippingMemo'
  import ShippingGuide from './ShippingGuide'

  export default {
    name: 'field-shipping',
    data () {
      return {
        isShowModal: false
      }
    },
    components: {
      ShippingType,
      ShippingNation,
      ShippingName,
      ShippingPhone,
      ShippingAddress,
      ShippingSave,
      ShippingMemo,
      ShippingGuide
    },
    computed: {
      ...mapState(['anonymousUser']),
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
