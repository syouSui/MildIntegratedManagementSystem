module.exports = {
  transpileDependencies: ['vuetify'],
  chainWebpack: config => {
    config.plugin('html').tap(args => {
      args[0].title = '🔷轻度综合管理系统🔷';
      return args;
    });
  },
  configureWebpack: {
    devtool: 'source-map',
  },
  devServer: {
    open: false, // Open browser automatically.
    proxy: {
      '/api': {
        target: 'http://localhost:8888', //代理地址，这里设置的地址会代替axios中设置的baseURL
        changeOrigin: true,
        ws: true,
        pathRewrite: {
          '^/api': '',
          //pathRewrite: {'^/api': '/'} 重写之后url为 http://192.168.1.16:8085/xxxx
          //pathRewrite: {'^/api': '/api'} 重写之后url为 http://192.168.1.16:8085/api/xxxx
        },
      },
    },
  },
};
