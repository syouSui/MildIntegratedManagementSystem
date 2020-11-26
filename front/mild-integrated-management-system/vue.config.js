module.exports = {
  transpileDependencies: ['vuetify'],
  chainWebpack: config => {
    config.plugin('html').tap(args => {
      args[0].title = '🔷轻度综合管理系统🔷';
      return args;
    });
  },
};
