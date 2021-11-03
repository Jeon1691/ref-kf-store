<template>
  <dl class="list_inp dl_email">
    <dt>
      <label class="lab_tf screen_out"
             for="tfEmailIdTemp">
        <span class="screen_out">{{ $t('common.input_necessary') }}</span>
      </label>
    </dt>
    <dd>
      <input type="text"
             id="tfEmailIdTemp"
             class="tf_g tf_id"
             :placeholder="$t('buyer.email.label')"
             v-model="oaBuyerEmailName">

      <span class="txt_email">@</span>

      <div class="opt_g opt_email opt_directwhite maillist1"
           :class="{ opt_on: isShowEmail, opt_directwhite: false }">
        <div class="write_domain">
          <label for="tfDomain1"
                 class="lab_tf"
                 :class="{ screen_out: true }">{{ $t('buyer.email.input_directly') }}</label>
          <input type="text"
                 class="tf_g"
                 :placeholder="$t('buyer.email.input_directly')"
                 v-model="oaBuyerEmailDomain">
        </div>

        <a class="link_selected"
           tabindex="-1"
           @click="isShowEmail = !isShowEmail"
           @blur="lazyHide">
          <strong class="screen_out">{{ $t('buyer.email.select_email') }}</strong>
          <span class="ico_newfriends_v1 ico_opt"></span>
        </a>

        <div class="box_opt">
          <em class="screen_out">{{ $t('common.select_option') }}</em>
          <ul class="list_opt">
            <li v-for="(email, index) in emails"
                :key="index">
              <a class="link_opt"
                 @click="onChangeBuyerEmail(email)">{{ email }}</a>
            </li>
          </ul>
        </div>
      </div>
    </dd>
  </dl>
</template>

<script>
import { emails } from './constants'
import { buyer } from '../mixin'

export default {
  name: 'buyer-email',
  mixins: [buyer],
  data() {
    return {
      emails,
      isShowEmail: false,
    }
  },
  computed: {
    oaBuyerEmailName: {
      get() {
        return this.buyer.oaBuyerEmailName
      },
      set(oaBuyerEmailName) {
        this.CHANGE_BUYER_FIELD({
          oaBuyerEmailName,
        })
      },
    },
    oaBuyerEmailDomain: {
      get() {
        return this.buyer.oaBuyerEmailDomain
      },
      set(oaBuyerEmailDomain) {
        this.CHANGE_BUYER_FIELD({
          oaBuyerEmailDomain,
        })
      },
    },
  },
  methods: {
    onChangeBuyerEmail(domain) {
      this.oaBuyerEmailDomain = domain
      this.isShowEmail = false
    },
    lazyHide() {
      setTimeout(() => {
        this.isShowEmail = false
      }, 250)
    },
  },
}
</script>
