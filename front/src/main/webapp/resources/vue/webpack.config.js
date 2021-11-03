const path = require('path')
const webpack = require('webpack')

module.exports = {
  context: path.resolve(__dirname, './src/pages'),
  entry: {
    info_char: './info/char.js',
    info_store: './info/store.js',
    sheet: './sheet.js',
    shipping: './shipping.js',
    complete: './complete.js',
  },
  output: {
    path: path.resolve(__dirname, '../js/dist'),
    publicPath: '/resources/js/dist/',
    filename: '[name].js',
  },
  module: {
    rules: [
      {
        test: /\.css$/,
        use: ['vue-style-loader', 'css-loader'],
      },
      {
        test: /\.vue$/,
        loader: 'vue-loader',
        options: {
          loaders: {},
        },
      },
      {
        test: /\.js$/,
        loader: 'babel-loader',
        exclude: /node_modules/,
      },
      {
        test: /\.(png|jpg|gif|svg)$/,
        loader: 'file-loader',
        options: {
          name: '[name].[ext]?[hash]',
        },
      },
    ],
  },
  resolve: {
    alias: {
      vue$: 'vue/dist/vue.esm.js',
    },
    extensions: ['*', '.js', '.vue', '.json'],
  },
  devServer: {
    proxy: {
      '**': 'http://localhost:8480',
    },
    historyApiFallback: true,
    noInfo: true,
    overlay: {
      warnings: true,
      errors: true,
    },
    host: '0.0.0.0',
  },
  performance: {
    hints: false,
  },
  devtool: '#eval-source-map',
}

if (process.env.NODE_ENV === 'production') {
  module.exports.devtool = '#source-map'
  module.exports.plugins = (module.exports.plugins || []).concat([
    new webpack.DefinePlugin({
      'process.env': {
        NODE_ENV: '"production"',
      },
    }),
    new webpack.optimize.UglifyJsPlugin({
      sourceMap: true,
      compress: {
        warnings: false,
      },
    }),
    new webpack.LoaderOptionsPlugin({
      minimize: true,
    }),
    new webpack.IgnorePlugin(/^\.\/locale$/, /moment$/),
  ])
}
