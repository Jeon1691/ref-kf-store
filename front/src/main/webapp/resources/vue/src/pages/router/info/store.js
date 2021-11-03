import Vue from 'vue'
import VueRouter from 'vue-router'
import { loadLanguageAsync } from '@/messages/info/store'

Vue.use(VueRouter)

const { LANG } = window

const routes = [
  {
    path: '/',
    redirect: `/${LANG}`,
    children: [
      {
        path: ':lang',
      },
    ],
  },
]

const router = new VueRouter({
  routes,
  linkActiveClass: 'lang_on',
})

router.beforeEach(async (to, from, next) => {
  const { lang } = to.params

  await loadLanguageAsync(lang)

  next()
})

export default router
