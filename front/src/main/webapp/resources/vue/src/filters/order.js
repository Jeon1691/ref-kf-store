import Vue from 'vue'
import moment from 'moment'

const { __INITIAL_STATE__ } = window

export function exchangeRate(price) {
  const EXCHANGE_RATE = parseFloat(__INITIAL_STATE__.exchangeRate)

  if (isNaN(EXCHANGE_RATE) || EXCHANGE_RATE === 0) {
    return 0
  }

  return Math.round(price / EXCHANGE_RATE * 100) / 100
}

export function exchangeKrw(price) {
  const value = typeof price === 'number' ? price.toString() : price
  const krw = value.replace(/\B(?=(\d{3})+(?!\d))/g, ',')
  return krw
}

export function exchangeUsd(price) {
  const usd = price ? price.toFixed(2) : 0
  return usd
}

export function getDate(date) {
  return moment(date).format('YYYY.MM.DD')
}

export function getDatetime(date) {
  return moment(date).format('YYYY.MM.DD HH:mm:ss')
}

Vue.filter('exchange', exchangeRate)
Vue.filter('krw', exchangeKrw)
Vue.filter('usd', exchangeUsd)
Vue.filter('date', getDate)
Vue.filter('datetime', getDatetime)
