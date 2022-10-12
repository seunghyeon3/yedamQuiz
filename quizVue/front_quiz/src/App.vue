<template>
  <div id="app">
    <TopNav/>
    <div id="layoutSidenav">
      <SideNav/>
      <div id="layoutSidenav_content">
        <router-view/>
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
</style>
