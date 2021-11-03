import 'babel-polyfill'
import Vue from 'vue'
import App from '@/components/Info/Char'
import i18n from '@/messages/info/char'
import router from '../router/info/char'

new Vue({
  el: '#kakaoWrap',
  router,
  i18n,
  render: h => h(App),
})
