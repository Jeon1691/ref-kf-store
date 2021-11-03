import 'babel-polyfill'
import Vue from 'vue'
import store from '@/store/shipping'
import i18n from '@/messages/shipping'
import Shipping from '@/components/Shipping'

new Vue({
  el: '#mArticle',
  store,
  i18n,
  render: h => h(Shipping),
})
