let navList = [
  {
    title: '面板首页',
    icon: 'mdi-home',
    path: '/Home/Welcome',
    items: [],
  },
  {
    title: '综合管理系统',
    icon: 'mdi-cog-sync',
    group: '/system',
    items: [
      {
        title: '雇员信息管理系统',
        path: '/Home/system/EmploymentManage',
        icon: 'mdi-account-supervisor-circle',
      },
      {
        title: '学生信息管理系统',
        path: '/Home/system/StudentManage',
        icon: 'mdi-account-box',
      },
      {
        title: '人事信息管理系统',
        path: '/Home/system/PersonnelManage',
        icon: 'mdi-clipboard-account',
      },
      {
        title: '手机信息管理系统',
        path: '/Home/system/PhoneManage',
        icon: 'mdi-cellphone-android',
      },
      {
        title: '房屋信息管理系统',
        path: '/Home/system/HomeManage',
        icon: 'mdi-home-account',
      },
      {
        title: '图书信息管理系统',
        path: '/Home/system/BookManage',
        icon: 'mdi-book',
      },
      {
        title: '部门信息管理系统',
        path: '/Home/system/DepartmentManage',
        icon: 'mdi-bank-outline',
      },
      {
        title: '仓库信息管理系统',
        path: '/Home/system/WarehouseManage',
        icon: 'mdi-warehouse',
      },
      {
        title: '产品信息管理系统',
        path: '/Home/system/ProductManage',
        icon: 'mdi-bag-personal',
      },
      {
        path: '/Home/system/ProviderManage',
        title: '供应商信息管理系统',
        icon: 'mdi-google-my-business',
      },
    ],
  },
  {
    title: '用户管理',
    icon: 'mdi-account-tie',
    path: '/Home/User',
    items: [],
  },
];
export default navList;
