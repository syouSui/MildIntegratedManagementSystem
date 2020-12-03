import axiosForVuePlugin from '@/plugins/axios';
let axios = axiosForVuePlugin.axios;

let home = {
  name: 'home',
  select: obj => axios.post('/Home/', obj),
  update: obj =>
    axios.post('/Home/update', {
      homeId: obj.homeId,
      title: obj.title,
      price: obj.price,
      updatedTime: obj.updatedTime,
      homeTypeId: obj.homeTypeId,
    }),
  insert: obj =>
    axios.post('/Home/insert', {
      homeId: obj.homeId,
      title: obj.title,
      price: obj.price,
      updatedTime: obj.updatedTime,
      homeTypeId: obj.homeTypeId,
    }),
  delete: homeId =>
    axios.post('/Home/delete', {
      homeId: homeId,
    }),
};

export default home;
