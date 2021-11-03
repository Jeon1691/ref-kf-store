import cond from 'lodash/cond'
import constant from 'lodash/constant'
import stubTrue from 'lodash/stubTrue'
import property from 'lodash/property'
import get from 'lodash/get'

const isMatch = key => property(key + '.$invalid')

export function handleAlert(conditions, nested = []) {
  const { $t, $v } = this

  const validate = cond([
    ...conditions.map(c => {
      return [isMatch(c[0]), constant($t(c[1]))]
    }),
    [stubTrue, constant(false)],
  ])

  const message = validate($v)

  if (message) {
    this.SHOW_DIALOG({
      message,
    })
  }

  nested.forEach(([p, m]) => {
    if (!get($v, p)) {
      this.SHOW_DIALOG({
        message: $t(m),
      })
    }
  })
}
