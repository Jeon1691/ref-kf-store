import Vue from 'vue'
import VueI18n from 'vue-i18n'
import en from './en'
import ko from './ko'

const { LANG } = window

Vue.use(VueI18n)

const messages = {
  en,
  ko,
}

const i18n = new VueI18n({
  locale: LANG,
  messages,
  silentTranslationWarn: true,
  fallbackLocale: 'en',
})

const loadedLanguages = ['ko', 'en']

export default i18n

function setI18nLanguage(lang) {
  i18n.locale = lang
  document.querySelector('html').setAttribute('lang', lang)
  return lang
}

export async function loadLanguageAsync(lang) {
  if (i18n.locale !== lang) {
    if (!loadedLanguages.includes(lang)) {
      const msgs = await import(`./${lang}`)

      i18n.setLocaleMessage(lang, msgs.default)
      loadedLanguages.push(lang)

      return setI18nLanguage(lang)
    }
    return Promise.resolve(setI18nLanguage(lang))
  }
  return Promise.resolve(lang)
}
