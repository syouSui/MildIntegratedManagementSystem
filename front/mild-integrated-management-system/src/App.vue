<template>
  <v-app :style="background">
    <transition name="slowOutIn">
      <router-view></router-view>
    </transition>
  </v-app>
</template>

<script>
export default {
  name: 'App',

  components: {},

  data: () => ({
    //
    background: {
      backgroundImage: `url(${require('./assets/background.png')})`,
      backgroundAttachment: 'fixed',
    },
    // routerAnimationName: 'slide-left',
  }),

  // watch: {
  //   $route(to) {
  //     this.routerAnimationName =
  //       to.name === 'Login' ? 'slide-left' : 'slide-right';
  //   },
  // },
  methods: {},
};
</script>

<style lang="css">
html {
  height: 100%;
  overflow-y: auto !important;
}
/* 去除 Google Chrome 自动填充账号出现的背景 */
input {
  background-color: transparent !important;
}
input:-webkit-autofill {
  -webkit-transition: background-color 1s ease-in-out 6000s;
  -webkit-text-fill-color: #fff !important;
}

/* animation of router */
.slowOutIn-enter {
  opacity: 0;
}
.slowOutIn-enter-active {
  transition: 0.8s;
}
.slowOutIn-enter-to {
  opacity: 1;
}
.slowOutIn-leave {
  opacity: 1;
}
.slowOutIn-leave-to {
  opacity: 0;
}
.slowOutIn-leave-active {
  transition: 0.5s;
}
</style>
