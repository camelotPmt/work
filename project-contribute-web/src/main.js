// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
//import Routers from './router.js';
//iview
import iView from 'iview';
import 'iview/dist/styles/iview.css';
import './my-theme/index.less';
import './my-theme/index.css';
import './fonts/iconfont.css';
import { HTTP } from './util/axios'
import { API } from './util/axios'
import qs from 'qs'
Vue.prototype.$http = HTTP;
Vue.prototype.$api = API;
Vue.prototype.qs = qs;
Vue.use(iView);
Vue.config.productionTip = false
//Vue.use(VueRouter);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
