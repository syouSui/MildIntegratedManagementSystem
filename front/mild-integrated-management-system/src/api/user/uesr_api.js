import store from '@/store';
import axiosForVuePlugin from '@/plugins/axios';
// eslint-disable-next-line no-unused-vars
let axios = axiosForVuePlugin.axios;

let user = {
  name: 'user',
  getRole() {
    let role = store.getters['user/getState'];
    // -1 means user role not in vuex.
    // So we should send request to back system to get it.
    if (role === -1) {
      // todo: This is temporary values for development.
      role = 2;
      // todo:
      // vue.axios.get
    }
    return role;
  },
  // getMd(category, grade, fileName) {
  //   console.log(`${category}\t${grade}\t${fileName}`);
  //   // return vue.$http.post('/index/test.md', null);
  //   return vue.$index.user.post('/index/test.json', null);
  //   // return vue.$http.post('/index/FindGoodsServlet', {
  //   //   method: 'findAllGoods',
  //   //   currentPage: '1',
  //   //   pageSize: '100',
  //   // });
  // },
};

export default user;
