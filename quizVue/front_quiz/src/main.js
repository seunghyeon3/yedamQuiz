import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import VueSession from 'vue-session'

Vue.config.productionTip = false

Vue.filter('yyyyMMdd', function (value) {
  // 들어오든 value 값이 공백이면 그냥 공백으로 리턴
  if (!value) {
    return ''
  }

  if (typeof value === 'string') {
    return value.substring(0, 10)
  } else {
    // date로 변환
    const jsDate = new Date(value)
    // 연도, 월, 일 추출
    const year = jsDate.getFullYear()
    let month = jsDate.getMonth() + 1
    let day = jsDate.getDate()
    // 월, 일의 경우 한자리 수 값이 있기 때문에 '0'처리
    if (month < 10) {
      month = '0' + month
    }
    if (day < 10) {
      day = '0' + day
    }
    // 최종 포맷( ex: 2022-10-31)
    return year + '-' + month + '-' + day
  }
})

const sessoinOPtions = {
  persist: true
}

Vue.use(VueSession, sessoinOPtions)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
