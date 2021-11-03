<template>
  <div class="inner_layer">
    <div class="layer_head">
      <strong class="tit_privacy"
              v-html="$t('agree_detail.title')"></strong>
    </div>
    <div class="layer_body">
      <div class="group_privacy">
        <table class="tbl_privacy">
          <caption class="screen_out">{{ $t('agree_detail.caption') }}</caption>
          <thead>
            <tr>
              <th scope="col"
                  style="width:20%">{{ $t('agree_detail.th[0]') }}</th>
              <th scope="col"
                  style="width:80%">{{ $t('agree_detail.th[1]') }}</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(row, index) in $t('agree_detail.tr')"
                :key="index">
              <th scope="row">{{ row[0] }}</th>
              <td v-html="row[1]"></td>
            </tr>
          </tbody>
        </table>
        <p class="desc_privacy">
          <span class="ico_friends ico_bullet"></span>{{ $t('agree_detail.desc') }}</p>
      </div>
      <button type="button"
              class="btn_verify btn_confirm"
              @click="HIDE_MODAL">{{ $t('common.ok') }}</button>
    </div>
  </div>
</template>

<script>
import { mapMutations } from 'vuex'

export default {
  name: 'agree-detail',
  methods: {
    ...mapMutations(['HIDE_MODAL']),
  },
}
</script>
