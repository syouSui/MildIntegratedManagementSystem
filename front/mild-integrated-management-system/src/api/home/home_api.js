import axiosForVuePlugin from '@/plugins/axios';
let axios = axiosForVuePlugin.axios;

let home = {
  name: 'home',
  getAll: () => axios.post('/Home/', {}),
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

export default home;
