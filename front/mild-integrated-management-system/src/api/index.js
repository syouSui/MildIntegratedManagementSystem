import user_api from './user/user_api';
import home_api from './home/home_api';

let api = {
  name: 'api',
  user: user_api,
  home: home_api,
};

export default api;
