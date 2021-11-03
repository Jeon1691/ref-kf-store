<template>
  <app-overlay>
    <div class="inner_layer">
      <div class="layer_head">
        <strong class="screen_out">{{ $t('information') }}</strong>
      </div>

      <div class="layer_body">
        <div class="box_desc">
          <p class="desc_layer"
             v-html="dialog.message"></p>
        </div>

        <button type="button"
                class="btn_verify btn_confirm"
                @click="HIDE_DIALOG">{{ $t('ok') }}</button>
      </div>
    </div>
  </app-overlay>
</template>

<script>
import { mapState, mapMutations } from 'vuex'
import AppOverlay from '../Overlay'

export default {
  name: 'app-dialog',
  components: {
    AppOverlay,
  },
  computed: {
    ...mapState(['dialog']),
  },
  methods: {
    ...mapMutations(['HIDE_DIALOG']),
  },
  i18n: {
    messages: {
      kr: { information: '안내', ok: '확인' },
      en: { information: 'Information', ok: 'OK' },
    },
  },
}
</script>

<style scoped>
.friends_layer {
  display: block;
}
</style>
