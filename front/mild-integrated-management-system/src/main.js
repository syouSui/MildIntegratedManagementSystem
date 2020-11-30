import Vue from 'vue';
// import plugins ... begin.
import vuetify from './plugins/vuetify';
import './plugins/axios';
// import plugins ... end.
import App from './App.vue';
import router from './router';
import store from './store';
import api from '@/api';

Vue.prototype.$api = api;

Vue.config.productionTip = false;

let vue = new Vue({
  router,
  store,
  vuetify,
  render: h => h(App),
}).$mount('#app');

// Notice!!! low case vue was exported!
export default vue;
