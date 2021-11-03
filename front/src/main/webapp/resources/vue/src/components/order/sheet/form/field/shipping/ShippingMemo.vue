<template>
  <dl class="info_shipping">
    <dt>
      <label class="lab_tf"
             for="osDeliMemo">{{ $t('shipping.memo.label') }}
      </label>
    </dt>
    <dd>
      <textarea name="osDeliMemo" maxlength="50" id="osDeliMemo" cols="30" rows="10" :placeholder="$t('shipping.memo.placeholder')" v-model="memo"></textarea>
      <p class="txt_memo">50자 이내로 입력해주세요 ({{ memoLength }} / {{ $t('shipping.memo.max') }})</p>
    </dd>
  </dl>
</template>

<script>
  import { mapMutations, mapState } from 'vuex'

  export default {
    name: 'shipping-memo',
    computed: {
      ...mapState(['shipping']),
      memo: {
        get () {
          return this.shipping.memo
        },
        set (memo) {
          this.CHANGE_SHIPPING_FIELDS({
            memo
          })
        }
      },
      memoLength () {
        return this.memo.length
      }
    },
    methods: {
      ...mapMutations(['CHANGE_SHIPPING_FIELDS'])
    }
  }
</script>
