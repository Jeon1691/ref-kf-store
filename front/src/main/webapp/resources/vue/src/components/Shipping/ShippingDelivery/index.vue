<template>
  <div class="delivery_area"
       :class="{ delivery_modify: isShowForm }">
    <h3 class="tit_sub">{{ $t('shipping_address.title') }}</h3>
    <dl class="list_order">
      <template v-if="globalOrder">
        <dt>{{ $t('shipping_address.country') }}</dt>
        <dd>
          <span class="txt_g">{{ orderAddressRequest.oaCountryName }}</span>
        </dd>
      </template>
    </dl>

    <dl class="list_order">
      <dt>{{ $t('shipping_address.name') }}</dt>
      <dd id="oaName">
        <span class="txt_g">{{ orderAddressRequest.oaName }}</span>
      </dd>

    </dl>

    <dl class="list_order">
      <dt>{{ $t('shipping_address.phone') }}</dt>
      <dd id="oaPhone">
        <span class="txt_g">{{ orderAddressRequest.oaPhone }}</span>
      </dd>
    </dl>

    <dl class="list_order">
      <dt>
        {{ globalOrder ? $t('shipping_address.zip_code') : $t('shipping_address.postal') }}
      </dt>
      <dd>
        <span class="txt_g">{{ orderAddressRequest.oaZoneCode }}
          <template v-if="orderAddressRequest.oaZoneCode !== orderAddressRequest.oaZipCode">
            ({{ orderAddressRequest.oaZoneCode }})
          </template>
        </span>
      </dd>
    </dl>

    <dl v-if="!globalOrder"
        class="list_order">
      <dt>{{ $t('shipping_address.addr1') }}</dt>
      <dd>
        <span class="txt_g">{{ orderAddressRequest.oaAddr1 }}</span>
      </dd>
    </dl>

    <dl v-if="globalOrder"
        class="list_order">
      <dt>State / Province</dt>
      <dd>
        <span class="txt_g">{{ orderAddressRequest.oaAddr1 }}</span>
      </dd>
    </dl>

    <dl v-if="!globalOrder"
        class="list_order">
      <dt>{{ $t('shipping_address.addr2') }}</dt>
      <dd>
        <span class="txt_g">{{ orderAddressRequest.oaAddr2 }}</span>
      </dd>
    </dl>

    <template v-if="globalOrder">
      <dl class="list_order">
        <dt>City</dt>
        <dd>
          <span class="txt_g">{{ orderAddressRequest.oaAddr2 }}</span>
        </dd>
      </dl>
      <dl class="list_order">
        <dt>Street</dt>
        <dd>
          <span class="txt_g">{{ orderAddressRequest.oaAddr3 }}</span>
        </dd>
      </dl>
    </template>

    <dl class="list_order">
      <dt>{{ $t('shipping_address.delivery_note') }}</dt>
      <dd>
        <span class="txt_g">{{ orderAddressRequest.oaDeliMemo }}</span>
      </dd>
    </dl>

    <template v-if="shippingStatusType.code === 1">
      <a @click="isShowForm = true"
         class="link_g">{{ $t('shipping_address.change') }}</a>

      <delivery-form v-if="isShowForm"
                     @close="isShowForm = false"></delivery-form>
    </template>
  </div>
</template>

<script>
import { mapState } from 'vuex'
import DeliveryForm from './DeliveryForm'

export default {
  name: 'shipping-delivery',
  data() {
    return {
      isShowForm: false,
    }
  },
  components: {
    DeliveryForm,
  },
  computed: {
    ...mapState({
      globalOrder: state => state.basket.globalOrder,
      orderAddressRequest: state => state.orderShippingInfo.orderAddressRequest,
    }),
    ...mapState(['shippingStatusType']),
  },
}
</script>

<style scoped>
.link_g {
  cursor: pointer;
}
</style>