<template>
  <dl class="info_shipping">
    <dt>
      <label class="lab_tf screen_out"
             for="tfEmailIdTemp">
        <span class="screen_out">{{ $t('common.input_necessary') }}</span>
      </label>
    </dt>
    <dd>
      <input type="text"
             id="tfEmailIdTemp"
             :placeholder="$t('buyer.email.label')"
             v-model="oaBuyerEmail">
    </dd>
  </dl>
</template>

<script>
  import { emails } from './buyerConstants'
  import { buyer } from './buyerMixin'

  export default {
    name: 'buyer-email',
    mixins: [buyer],
    data () {
      return {
        emails,
        isShowEmail: false
      }
    },
    computed: {
      oaBuyerEmail: {
        get () {
          return this.buyer.oaBuyerEmail
        },
        set (oaBuyerEmail) {
          this.CHANGE_BUYER_FIELD({
            oaBuyerEmail
          })
        }
      },
      oaBuyerEmailName: {
        get () {
          return this.buyer.oaBuyerEmailName
        },
        set (oaBuyerEmailName) {
          this.CHANGE_BUYER_FIELD({
            oaBuyerEmailName
          })
        }
      },
      oaBuyerEmailDomain: {
        get () {
          return this.buyer.oaBuyerEmailDomain
        },
        set (oaBuyerEmailDomain) {
          this.CHANGE_BUYER_FIELD({
            oaBuyerEmailDomain
          })
        }
      }
    },
    methods: {
      onChangeBuyerEmail (domain) {
        this.oaBuyerEmailDomain = domain
        this.isShowEmail = false
      },
      lazyHide () {
        setTimeout(() => {
          this.isShowEmail = false
        }, 250)
      }
    }
  }
</script>
