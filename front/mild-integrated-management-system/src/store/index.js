import Vue from 'vue';
import Vuex from 'vuex';
import user from './modules/user';
import layout from '@/store/modules/layout';

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    user,
    layout,
  },
});
