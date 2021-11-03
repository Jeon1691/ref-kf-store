<template>
  <dl class="list_inp">
    <dt class="global_hide"
        v-if="!shipping.isGlobal">
      <label class="lab_tf screen_out"
             for="orderAddress1">{{ $t('shipping.address.addr1') }}
        <span class="screen_out">{{ $t('common.input_necessary') }}</span>
      </label>
    </dt>
    <dt class="global_show">
      <label class="lab_tf lab_flow screen_out"
             for="orderAddress1">{{ $t('shipping.address.state') }}
        <span class="screen_out">{{ $t('common.input_necessary') }}</span>
      </label>
    </dt>
    <dd v-if="!shipping.isGlobal">
      <input type="text"
             class="tf_g"
             id="orderAddress1"
             name="oaAddr1_txt"
             maxlength="100"
             :placeholder="$t('shipping.address.addr1')"
             :readonly="!shipping.isGlobal"
             v-model="oaAddr1">
    </dd>
    <dd v-else-if="shipping.oaCountryCode === 'US'">
      <div class="opt_g opt_country"
           :class="{ opt_on: isShowState }">
        <strong class="screen_out">{{ $t('shipping.address.select_us_state') }}</strong>
        <a class="link_selected"
           tabindex="-1"
           @click="isShowState = !isShowState"
           @blur="lazyHide">
          <span class="txt_opt"
                id="usState">{{ oaAddr1 || 'CA (California)' }}</span>
          <span class="screen_out">{{ $t('common.selected') }}</span>
          <span class="ico_newfriends_v1 ico_opt"></span>
        </a>
        <div class="box_opt">
          <em class="screen_out">{{ $t('common.select_option') }}</em>
          <ul class="list_opt">
            <li v-for="usState in country.usStateList"
                :key="usState.CODE">
              <a class="link_opt"
                 @click="changeState(`${usState.CODE} (${usState.STATE_EN})`)">
                {{ usState.CODE }} ({{ usState.STATE_EN }})
              </a>
            </li>
          </ul>
          <input class="tf_g"
                 type="hidden"
                 id="orderAddress1"
                 name="oaAddr1_txt"
                 maxlength="100"
                 :value="shipping.oaAddr1">
        </div>
      </div>
    </dd>
    <dd v-else>
      <input type="text"
             class="tf_g"
             id="orderAddress1"
             name="oaAddr1_txt"
             maxlength="100"
             :placeholder="$t('shipping.address.state')"
             v-model="oaAddr1">
    </dd>
  </dl>
</template>

<script>
import mixin, { shipping, country } from '../mixin'

export default {
  name: 'address-state',
  mixins: [mixin, shipping, country],
  data() {
    return {
      isShowState: false,
    }
  },
  computed: {
    oaAddr1: {
      get() {
        return this.$store.state.shipping.oaAddr1
      },
      set(oaAddr1) {
        this.CHANGE_SHIPPING_FIELDS({
          oaAddr1,
        })
      },
    },
  },
  methods: {
    changeState(state) {
      this.oaAddr1 = state
      this.isShowState = false
    },
    lazyHide() {
      setTimeout(() => {
        this.isShowState = false
      }, 250)
    },
  },
}
</script>