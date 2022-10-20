<template>
  <div id="app">
    <TopNav/>
    <div id="layoutSidenav">
      <SideNav/>
      <div id="layoutSidenav_content">
        <Transition name="fade" :duration="500">
          <router-view/>
        </Transition>
        <LayoutFooter/>
      </div>
    </div>
  </div>
</template>

<script>
import TopNav from './components/TopNav.vue'
import SideNav from './components/SideNav.vue'
import LayoutFooter from './components/LayoutFooter.vue'

export default {
  name: 'HomeView',
  components: {
    TopNav,
    SideNav,
    LayoutFooter
  },
  mounted() {
    setInterval(()=>{
      this.$store.state.n++;
    },4000);
  }  
}
</script>

<style lang="scss">
@import './assets/styles/styles.css';

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.5s ease;
}

.fade-enter-from,
.fade-leave-to {
  opacity: 0;
}
</style>
