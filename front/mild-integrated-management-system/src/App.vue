<template>
  <v-app>
    <router-view></router-view>
  </v-app>
</template>

<script>
export default {
  name: 'App',

  components: {},

  data: () => ({
    //
  }),
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
</style>
