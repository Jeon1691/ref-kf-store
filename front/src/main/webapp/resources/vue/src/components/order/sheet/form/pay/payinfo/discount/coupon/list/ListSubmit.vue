<template>
  <div class="option_btns">
    <button type="submit"
            class="btn_check btn_confirm"
            id="btn_confirm">{{ $t('common.ok') }}</button>
    <button type="button"
            class="btn_check btn_cancel"
            @click="HIDE_MODAL">{{ $t('common.cancel') }}</button>
  </div>
</template>

<script>
import { mapMutations } from 'vuex'

export default {
  name: 'list-submit',
  methods: {
    ...mapMutations(['HIDE_MODAL']),
  },
}
</script>
