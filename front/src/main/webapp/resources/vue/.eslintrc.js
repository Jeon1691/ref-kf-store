module.exports = {
  extends: ['eslint:recommended', 'plugin:vue/essential'],
  rules: {
    // 'vue/no-unused-vars': 'error'
  },
  parserOptions: {
    parser: 'babel-eslint',
  },
  env: {
    browser: true,
  },
  plugins: ['vue'],
}
