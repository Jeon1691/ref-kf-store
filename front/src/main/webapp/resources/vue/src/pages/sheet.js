import 'babel-polyfill'
import Vue from 'vue'
import store from '@/store/sheet'
import i18n from '@/messages/sheet'
import Sheet from '@/components/order/sheet/Sheet'

window.App = new Vue({
  el: '#mArticle',
  store,
  i18n,
  render: h => h(Sheet),
})
