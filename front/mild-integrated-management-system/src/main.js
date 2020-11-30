import Vue from 'vue';
// import plugins ... begin.
import vuetify from './plugins/vuetify';
import './plugins/axios';
// import plugins ... end.
import App from './App.vue';
import router from './router';
import api from '@/api/api.js';

Vue.prototype.$api = api;

Vue.config.productionTip = false;

let vue = new Vue({
  router,
  vuetify,
  render: h => h(App),
}).$mount('#app');

// Notice!!! low case vue was exported!
export default vue;
