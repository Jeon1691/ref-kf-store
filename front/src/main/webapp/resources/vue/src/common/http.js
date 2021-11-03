import axios from 'axios'
import qs from 'qs'
import isString from 'lodash/isString'

const { CSRF_TOKEN } = window

axios.defaults.headers['Content-Type'] = 'application/json'
axios.defaults.headers['X-CSRF-TOKEN'] = CSRF_TOKEN

axios.interceptors.response.use(
  response => {
    if (isString(response.data)) {
      window.location.href = '/signin?sessionExpired=true'
      return
    }

    return response
  },
  error => {
    if (error.response.status === 403) {
      window.location.href = '/signin?sessionExpired=true'
    }

    return Promise.reject(error)
  }
)

export const POST_JSON = (url, data, config) => axios.post(url, data, config)

export const POST_URL = (url, data, config) => {
  return axios.post(url, qs.stringify(data), {
    ...config,
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded',
    },
  })
}
