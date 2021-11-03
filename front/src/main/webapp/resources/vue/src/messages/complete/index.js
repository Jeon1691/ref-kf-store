import Vue from 'vue'
import VueI18n from 'vue-i18n'
import Vuelidate from 'vuelidate'
import { messages } from '../shipping'

const { LANG } = window

Vue.use(VueI18n)
Vue.use(Vuelidate)

const i18n = new VueI18n({
  locale: LANG,
  messages,
  silentTranslationWarn: true,
})

export default i18n
