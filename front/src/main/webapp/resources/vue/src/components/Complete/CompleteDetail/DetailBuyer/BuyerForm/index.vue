<template>
  <div id="buyerModify"
       class="inbox_readonly inbox_send inbox_delivery delivery_area delivery_modify">
    <h3 class="tit_orderit">{{ $t('buyer.title') }}</h3>

    <div class="change_delivery">
      <form ref="formBuyer"
            :action="`/${$LANG}/order/complete/buyer/change`"
            method="post"
            @submit.prevent="onSubmit">
        <form-hidden></form-hidden>

        <fieldset>
          <legend class="screen_out">{{ $t('buyer.legend') }}</legend>

          <dl class="list_delivery">
            <dt>
              <label for="buyerName">{{ $t('buyer.name') }}</label>
              <span class="ico_friends ico_star">{{ $t('input_necessary') }}</span>
            </dt>
            <dd>
              <div class="box_input">
                <input type="text"
                       name="buyerName"
                       id="buyerName"
                       class="tf_g"
                       :placeholder="$t('buyer.name')"
                       v-model="buyerName">
              </div>
            </dd>

            <dt>
              <label for="buyerEmail">{{ $t('buyer.email') }}</label>
              <span class="ico_friends ico_star">{{ $t('input_necessary') }}</span>
            </dt>
            <dd>
              <div class="box_input">
                <input type="text"
                       id="buyerEmail"
                       name="buyerEmail"
                       class="tf_g"
                       :placeholder="$t('buyer.email')"
                       v-model="buyerEmail">
              </div>
            </dd>
          </dl>

          <div class="wrap_btn">
            <button type="button"
                    class="btn_change btn_cancel"
                    @click="onCancel">
              <span class="txt_g">{{ $t('buyer.cancel') }}</span>
            </button>
            <button type="submit"
                    class="btn_change btn_modify">
              <span class="txt_g">{{ $t('buyer.ok') }}</span>
            </button>
          </div>
        </fieldset>
      </form>
    </div>
  </div>
</template>

<script>
import { mapMutations } from 'vuex'
import { validationMixin } from 'vuelidate'
import { handleAlert } from '@/common/validations'
import computed from './computed'
import validations from './validations'
import FormHidden from './FormHidden'

export default {
  name: 'buyer-form',
  mixins: [validationMixin],
  data() {
    return {
      buyerSnapshot: null,
    }
  },
  components: {
    FormHidden,
  },
  computed,
  mounted() {
    this.buyerSnapshot = {
      buyerName: this.buyerName,
      buyerEmail: this.buyerEmail,
    }
  },
  methods: {
    ...mapMutations(['CHANGE_ORDER_ADDRESS_REQUEST', 'SHOW_DIALOG', 'HIDE_DIALOG']),
    onSubmit() {
      if (this.$v.$invalid) {
        this.handleAlert([
          ['buyerName', 'order_validate.buyer.name'],
          ['buyerEmail', 'order_validate.buyer.email'],
        ])
      } else {
        this.$refs.formBuyer.submit()
      }
    },
    onCancel() {
      const { buyerName, buyerEmail } = this.buyerSnapshot

      this.buyerName = buyerName
      this.buyerEmail = buyerEmail

      this.$emit('hide')
    },
    handleAlert,
  },
  validations,
}
</script>
