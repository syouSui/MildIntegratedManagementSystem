import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    redirect: 'Login',
  },
  {
    path: '/Login',
    name: 'Login',
    component: () => import('../views/Login.vue'),
  },
  {
    path: '/Register',
    name: 'Register',
    component: () => import('../views/Register.vue'),
  },
  {
    path: '/Home',
    name: 'Home',
    component: () => import('../views/Home.vue'),
    children: [
      {
        path: '/',
        redirect: '/Home/Welcome',
      },
      {
        path: '/Home/Welcome',
        name: 'Welcome',
        component: () => import('../views/defaultPage/Welcome.vue'),
        meta: '欢迎使用!',
      },
      {
        path: '/Home/system/EmploymentManage',
        name: 'Employment',
        component: () => import('../views/system/EmploymentManage.vue'),
        meta: '雇员信息管理系统',
      },
      {
        path: '/Home/system/StudentManage',
        name: 'Student',
        component: () => import('../views/system/StudentManage.vue'),
        meta: '学生信息管理系统',
      },
      {
        path: '/Home/system/PersonnelManage',
        name: 'Personnel',
        component: () => import('../views/system/PersonnelManage.vue'),
        meta: '人事信息管理系统',
      },
      {
        path: '/Home/system/PhoneManage',
        name: 'Phone',
        component: () => import('../views/system/PhoneManage.vue'),
        meta: '手机信息管理系统',
      },
      {
        path: '/Home/system/HomeManage',
        name: 'Home',
        component: () => import('../views/system/HomeManage.vue'),
        meta: '房屋信息管理系统',
      },
      {
        path: '/Home/system/BookManage',
        name: 'Book',
        component: () => import('../views/system/BookManage.vue'),
        meta: '图书信息管理系统',
      },
      {
        path: '/Home/system/DepartmentManage',
        name: 'Department',
        component: () => import('../views/system/DepartmentManage.vue'),
        meta: '部门信息管理系统',
      },
      {
        path: '/Home/system/WarehouseManage',
        name: 'Warehouse',
        component: () => import('../views/system/WarehouseManage.vue'),
        meta: '仓库信息管理系统',
      },
      {
        path: '/Home/system/ProductManage',
        name: 'Product',
        component: () => import('../views/system/ProductManage.vue'),
        meta: '产品信息管理系统',
      },
      {
        path: '/Home/system/ProviderManage',
        name: 'Provider',
        component: () => import('../views/system/ProviderManage.vue'),
        meta: '供应商信息管理系统',
      },
      // {
      //   path: '/Home/plugin/prism',
      //   name: 'Prism',
      //   component: () => import('@/views/plugin/prism'),
      //   meta: '使用Prismjs',
      // },
      // {
      //   path: '/Home/plugin/icons',
      //   name: 'Icons',
      //   component: () => import('@/views/plugin/icons'),
      //   meta: '材质图标',
      // },
      // {
      //   path: '/Home/bulb/motion',
      //   name: 'Motion',
      //   component: () => import('@/views/bulb/motion'),
      //   meta: '转场动画',
      // },
      {
        path: '/Home/User',
        name: 'Motion',
        component: () => import('@/views/user/User'),
        meta: '用户管理',
      },
    ],
  },
];

const router = new VueRouter({
  routes,
});

export default router;
