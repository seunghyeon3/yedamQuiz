<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
    <!-- <video controls autoplay muted loop>
      <source src="../assets/002.mp4" />
    </video> -->
  </div>

</template>

<script>
// jQuery(function(){
//   console.log('aaaa')
// });
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'HomeView',
  components: {
    HelloWorld
  },
  mounted () {
    this.$session.set('user_no', 'aaaa')
  }
}
</script>
