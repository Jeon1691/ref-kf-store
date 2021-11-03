<template>
  <div class="inbox_readonly inbox_delivery delivery_area"
       :class="{ delivery_modify: isShowForm }">
    <h3 class="tit_orderit">{{ $t('shipping_address.title') }}</h3>

    <dl v-if="globalOrder"
        class="list_orderit">
      <dt>{{ $t('shipping_address.country') }}</dt>
      <dd>
        <span class="inner_txt">{{ orderAddressRequest.oaCountryName }}</span>
      </dd>
    </dl>

    <dl class="list_orderit">
      <dt>{{ $t('shipping_address.name') }}</dt>
      <dd id="oaName">
        <span class="inner_txt">{{ orderAddressRequest.oaName }}</span>
      </dd>
    </dl>

    <dl class="list_orderit">
      <dt>{{ $t('shipping_address.phone_complete') }}</dt>
      <dd id="oaPhone">
        <span class="inner_txt">{{ orderAddressRequest.oaPhone }}</span>
      </dd>
    </dl>

    <dl class="list_orderit">
      <template v-if="globalOrder">
        <dt>{{ $t('shipping_address.zip_code') }}</dt>
      </template>
      <template v-else>
        <dt>{{ $t('shipping_address.postal') }}</dt>
      </template>
      <dd>
        <span class="inner_txt">{{ orderAddressRequest.oaZoneCode }}
          <template v-if="orderAddressRequest.oaZoneCode !== orderAddressRequest.oaZipCode">
            ({{ orderAddressRequest.oaZoneCode }})
          </template>
        </span>
      </dd>
    </dl>

    <dl class="list_orderit">
      <template v-if="globalOrder">
        <dt>State / <br>Province</dt>
      </template>
      <template v-else>
        <dt>{{ $t('shipping_address.addr1') }}</dt>
      </template>
      <dd>
        <span class="inner_txt">{{ orderAddressRequest.oaAddr1 }}</span>
      </dd>
    </dl>

    <dl class="list_orderit">
      <template v-if="globalOrder">
        <dt>City</dt>
      </template>
      <template v-else>
        <dt>{{ $t('shipping_address.addr2') }}</dt>
      </template>
      <dd>
        <span class="inner_txt">{{ orderAddressRequest.oaAddr2 }}</span>
      </dd>
    </dl>

    <dl v-if="globalOrder"
        class="list_orderit">
      <dt>Street</dt>
      <dd>
        <span class="inner_txt">{{ orderAddressRequest.oaAddr3 }}</span>
      </dd>
    </dl>

    <dl class="list_orderit noti_orderit">
      <dt>{{ $t('shipping_address.delivery_note') }}</dt>
      <dd>
        <span class="inner_txt">{{ orderAddressRequest.oaDeliMemo }}</span>
      </dd>
    </dl>

    <template v-if="shippingStatusType.code === 1">
      <a id="deliveryChange"
         class="link_edit"
         @click="isShowForm = true">{{ $t('shipping_address.change_complete') }}</a>
      <shipping-form v-if="isShowForm"
                     @close="isShowForm = false"></shipping-form>
    </template>
  </div>
</template>

<script>
import { mapState } from 'vuex'
import ShippingForm from './ShippingForm'

export default {
  name: 'detail-shipping',
  components: {
    ShippingForm,
  },
  data() {
    return {
      isShowForm: false,
    }
  },
  computed: {
    ...mapState(['shippingStatusType']),
    ...mapState({
      orderAddressRequest: state => state.orderShippingInfo.orderAddressRequest,
      globalOrder: state => state.basket.globalOrder,
    }),
  },
}
</script>

<style>
.link_edit {
  cursor: pointer;
}
</style>