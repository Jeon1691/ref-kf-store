import 'babel-polyfill'
import Vue from 'vue'
import App from '@/components/Info/Store'
import store from '@/store/info/store'
import i18n from '@/messages/info/store'
import router from '../router/info/store'

new Vue({
  el: '#kakaoWrap',
  store,
  router,
  i18n,
  render: h => h(App),
})
