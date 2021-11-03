<template>
  <div class="group_order">
    <h3 class="tit_orderit">{{ $t('agree_checkbox.title') }}</h3>

    <ul class="list_agree">
      <li>
        <strong class="tit_agree">
          {{ $t('agree_checkbox.agree_list[0]') }}
        </strong>
        <div class="chk_agree">
          <div class="area_agree">
            <input type="checkbox"
                   id="allAgree"
                   name="saveId"
                   class="inp_g"
                   :checked="checkedAgree.length === 2"
                   @change="onChangeAgree">
            <label for="allAgree"
                   class="lab_g">
              <span class="ico_newfriends_v1">{{ $t('agree_checkbox.agree') }}</span>
            </label>
          </div>
        </div>
      </li>

      <li>
        <strong class="tit_agree">
          {{ $t('agree_checkbox.agree_list[1]') }}
          <em class="emph_important"> ({{ $t('agree_checkbox.required') }})</em>
          <a class="link_agree"
             @click="privacyOrderPopup('3')">{{ $t('agree_checkbox.details') }}</a>
        </strong>
        <div class="chk_agree">
          <div class="area_agree">
            <input type="checkbox"
                   id="checkAgree2"
                   class="inp_g chkAgree"
                   value="A"
                   v-model="checkedAgree">
            <label for="checkAgree2"
                   class="lab_g">
              <span class="ico_newfriends_v1">{{ $t('agree_checkbox.agree') }}</span>
            </label>
          </div>
        </div>
      </li>

      <li>
        <strong class="tit_agree">
          {{ $t('agree_checkbox.agree_list[2]') }}
          <em class="emph_important"> ({{ $t('agree_checkbox.required') }})</em>
        </strong>
        <div class="chk_agree">
          <div class="area_agree">
            <input type="checkbox"
                   id="checkAgree3"
                   class="inp_g chkAgree"
                   value="B"
                   v-model="checkedAgree">
            <label for="checkAgree3"
                   class="lab_g">
              <span class="ico_newfriends_v1">{{ $t('agree_checkbox.agree') }}</span>
            </label>
          </div>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
import { mapMutations } from 'vuex'
import AgreeDetail from '../AgreeDetail'

export default {
  name: 'agree-checkbox',
  data() {
    return {
      checkedAgree: [],
    }
  },
  watch: {
    checkedAgree(value) {
      this.CHANGE_AGREEMENT(value)
    },
  },
  methods: {
    ...mapMutations(['CHANGE_AGREEMENT', 'SHOW_MODAL']),
    privacyOrderPopup() {
      this.SHOW_MODAL({
        name: 'privacy_layer',
        component: AgreeDetail,
      })
    },
    onChangeAgree(e) {
      this.checkedAgree = e.target.checked ? ['A', 'B'] : []
    },
  },
}
</script>
