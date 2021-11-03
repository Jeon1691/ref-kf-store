<template>
  <dl class="list_inp list_memo">
    <dt>
      <label class="lab_tf"
             for="osDeliMemo">{{ $t('shipping.memo.label') }}
        <span class="txt_limit">({{ memoLength }} / {{ $t('shipping.memo.max') }})</span>
      </label>
    </dt>
    <dd>
      <textarea id="osDeliMemo"
                maxlength="50"
                name="osDeliMemo"
                class="tf_g tf_textarea"
                :placeholder="$t('shipping.memo.placeholder')"
                v-model="memo"></textarea>
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
      get() {
        return this.shipping.memo
      },
      set(memo) {
        this.CHANGE_SHIPPING_FIELDS({
          memo,
        })
      },
    },
    memoLength() {
      return this.memo.length
    },
  },
  methods: {
    ...mapMutations(['CHANGE_SHIPPING_FIELDS']),
  },
}
</script>
