<template>
  <ul class="list_agree">
    <li v-show="false">
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
    <li class="area_checkbox">
      <div class="chk_common">
        <input type="checkbox" id="checkAgree2"
               value="A"
               v-model="checkedAgree" />
        <label for="checkAgree2"></label>
      </div>
      <label for="checkAgree2" class="txt_label">
        <a @click="privacyOrderPopup('3')">{{ $t('agree_checkbox.agree_list[1]') }}</a>
        <span>[{{ $t('agree_checkbox.required') }}]</span>
      </label>
    </li>
    <li class="area_checkbox">
      <div class="chk_common">
        <input type="checkbox" id="checkAgree3"
               value="B"
               v-model="checkedAgree" />
        <label for="checkAgree3"></label>
      </div>
      <label for="checkAgree3" class="txt_label">
        {{ $t('agree_checkbox.agree_list[2]') }}<span>[{{ $t('agree_checkbox.required') }}]</span>
      </label>
    </li>
  </ul>

</template>

<script>
  import { mapMutations } from 'vuex'
  import AgreeDetail from './AgreeDetail'

  export default {
    name: 'agree-checkbox',
    data () {
      return {
        checkedAgree: []
      }
    },
    watch: {
      checkedAgree (value) {
        this.CHANGE_AGREEMENT(value)
      }
    },
    methods: {
      ...mapMutations(['CHANGE_AGREEMENT', 'SHOW_MODAL']),
      privacyOrderPopup () {
        this.SHOW_MODAL({
          name: 'privacy_layer',
          component: AgreeDetail
        })
      },
      onChangeAgree (e) {
        this.checkedAgree = e.target.checked ? ['A', 'B'] : []
      }
    }
  }
</script>
