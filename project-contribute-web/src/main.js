// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
// import Routers from './router.js';
// iview
import iView from 'iview'
import 'iview/dist/styles/iview.css'
import './my-theme/index.less'
import './my-theme/index.css'
import './fonts/iconfont.css'
import { API, HTTP } from './util/axios'
import ZkTable from 'vue-table-with-tree-grid'
import Moment from 'moment'
Vue.prototype.$http = HTTP
Vue.prototype.$api = API
Vue.prototype.$moment = Moment
Vue.use(iView)
Vue.config.productionTip = false
Vue.use(ZkTable)

// Vue.use(VueRouter);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
