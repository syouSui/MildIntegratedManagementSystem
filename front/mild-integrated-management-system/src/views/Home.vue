<template>
  <div>
    <Header></Header>
    <div class="home">
      <HelloWorld msg="Welcome to Your Vue.js App" />
    </div>
    <Footer></Footer>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue';
import Header from '@/views/Header';
import Footer from '@/views/Footer';

export default {
  name: 'Home',
  components: {
    Footer,
    Header,
    HelloWorld,
  },
};
</script>
