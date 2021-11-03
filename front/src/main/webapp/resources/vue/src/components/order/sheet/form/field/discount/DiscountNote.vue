<template>
  <div class="inner_layer">
    <div class="layer_head">
      <strong class="tit_attention">{{ $t('discount.note.title') }}</strong>
    </div>
    <div class="layer_body">
      <div class="group_attention">
        <ul class="list_attention">
          <li v-for="(caution, index) in $t('discount.note.cautions')"
              v-html="caution"
              :key="index"></li>
        </ul>
      </div>
    </div>
    <div class="layer_foot">
      <button type="button"
              class="btn_verify btn_confirm"
              @click="HIDE_MODAL">{{ $t('common.ok') }}</button>
    </div>
  </div>
</template>

<script>
import { mapMutations } from 'vuex'

export default {
  name: 'discount-note',
  methods: {
    ...mapMutations(['HIDE_MODAL']),
  },
}
</script>
