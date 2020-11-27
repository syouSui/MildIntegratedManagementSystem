import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    redirect: 'login',
  },
  {
    path: '/Login',
    component: () => import('../views/Login.vue'),
  },
  {
    path: '/Register',
    component: () => import('../views/Register.vue'),
  },
  {
    path: '/Home',
    component: () => import('../views/Home.vue'),
  },
];

const router = new VueRouter({
  routes,
});

export default router;
