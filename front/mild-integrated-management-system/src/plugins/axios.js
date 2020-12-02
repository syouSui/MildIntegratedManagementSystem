'use strict';

import Vue from 'vue';
import axios from 'axios';

// Full config:  https://github.com/axios/axios#request-config
// axios.defaults.baseURL = process.env.baseURL || process.env.apiUrl || '';
// axios.defaults.headers.common['Authorization'] = AUTH_TOKEN;
// axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

// let baseUrl_dev = 'http://localhost:8888/api';
// let baseUrl_dev = 'http://localhost:8888';
// let baseUrl_pro = '';

let config = {
  baseURL: '/api',
  timeout: 60 * 1000, // Timeout
  withCredentials: true, // Check cross-site Access-Control
  headers: {
    'Content-Type': 'application/json',
  },
};

const _axios = axios.create(config);

let map = {
  0: '暂未设置',
  1: '一室一厅一卫',
  2: '两室一厅一卫',
  3: '三室一厅一卫',
  4: '四室一厅一卫',
  5: '五室一厅二卫',
  6: '六室一厅二卫',
  7: '双层别墅',
  8: '三层别墅',
  9: '四层别墅',
  10: '五层别墅',
  11: '六层别墅',
  12: '高层水景公寓',
  13: '豪华海景别墅',
  14: '山景别墅',
  15: '普通公寓',
  16: '四合院',
};

_axios.interceptors.request.use(
  function(config) {
    // Do something before request is sent
    // console.log(config);
    if (config.data.length) {
      let data = config.data;
      if (data['homeTypeId'] !== '') {
        data['homeTypeId'] = Object.keys(map).find(
          i => map[i] === data['homeTypeId']
        );
      } else if (data['homeTypeIdList'] !== '') {
        let arr = data['homeTypeIdList'];
        for (let i = 0; i < arr.length; ++i) {
          arr[i] = Object.keys(map).find(idx => map[idx] === arr[i]);
        }
        data['homeTypeIdList'] = arr;
      }
      config.data = data;
    }
    return config;
  },
  function(error) {
    // Do something with request error
    return Promise.reject(error);
  }
);

// Add a response interceptor
_axios.interceptors.response.use(
  function(response) {
    // Do something with response data
    // console.log(response);
    for (let i = 0; i < response.data.data.length; ++i) {
      response.data.data[i].homeTypeId = map[response.data.data[i].homeTypeId];
    }
    return response;
  },
  function(error) {
    // Do something with response error
    return Promise.reject(error);
  }
);

// eslint-disable-next-line no-unused-vars
Plugin.install = function(Vue, options) {
  Vue.axios = _axios;
  window.axios = _axios;
  Object.defineProperties(Vue.prototype, {
    axios: {
      get() {
        return _axios;
      },
    },
    $axios: {
      get() {
        return _axios;
      },
    },
  });
};

Vue.use(Plugin);

export default {
  // export this Plugin is for vue to install plugin and we can use in vue components.
  Plugin,
  // export this axios is for api.js to use.
  axios: _axios,
};
