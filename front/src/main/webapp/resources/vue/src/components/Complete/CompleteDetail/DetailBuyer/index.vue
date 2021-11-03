<template>
  <div>
    <div v-show="!isEditable"
         id="buyerInfo"
         class="inbox_readonly inbox_send">
      <h3 class="tit_orderit">{{ $t('buyer.title') }}</h3>

      <dl class="list_orderit">
        <dt>{{ $t('buyer.name') }}</dt>
        <dd>
          <span class="inner_txt">{{ orderAddressRequest.oaBuyerName }}</span>
        </dd>
      </dl>

      <dl class="list_orderit">
        <dt>{{ $t('buyer.email') }}</dt>
        <dd>
          <span class="inner_txt">{{ orderAddressRequest.oaBuyerEmail }}</span>
        </dd>
      </dl>

      <a id="btnBuyerInfo"
         class="link_edit"
         @click="isEditable = true">
        {{ $t('buyer.change') }}
      </a>
    </div>

    <buyer-form v-if="isEditable"
                @hide="isEditable = false"></buyer-form>
  </div>
</template>

<script>
import { mapState } from 'vuex'
import BuyerForm from './BuyerForm'

export default {
  name: 'detail-buyer',
  components: {
    BuyerForm,
  },
  data() {
    return {
      isEditable: false,
    }
  },
  computed: {
    ...mapState({
      orderAddressRequest: state => state.orderShippingInfo.orderAddressRequest,
    }),
  },
}
</script>

<style scoped>
.link_edit {
  cursor: pointer;
}
</style>
