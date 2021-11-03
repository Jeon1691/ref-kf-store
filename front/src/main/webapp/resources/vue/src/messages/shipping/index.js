import Vue from 'vue'
import VueI18n from 'vue-i18n'
import en from './en'
import kr from './kr'

const { LANG } = window

Vue.use(VueI18n)

export const messages = {
  en,
  kr,
}

const i18n = new VueI18n({
  locale: LANG,
  messages,
  silentTranslationWarn: true,
})

export default i18n
