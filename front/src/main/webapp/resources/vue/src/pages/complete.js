import 'babel-polyfill'
import Vue from 'vue'
import Vuelidate from 'vuelidate'
import store from '@/store/complete'
import i18n from '@/messages/complete'
import Complete from '@/components/Complete'

Vue.use(Vuelidate)

new Vue({
  el: '#mArticle',
  store,
  i18n,
  render: h => h(Complete),
})
