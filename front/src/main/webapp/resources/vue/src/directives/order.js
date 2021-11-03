import Vue from 'vue'

const TENTH_URL =
  'https://img1.daumcdn.net/thumb/R300x300/?fname=https%3A%2F%2Ft1.daumcdn.net%2Ffriends%2Fprod%2Fproduct%2F'

Vue.directive('src', {
  inserted(el, binding) {
    el.src = TENTH_URL + binding.value
  },
})
