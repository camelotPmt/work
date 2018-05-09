import axios from 'axios'
import Cookie from 'js-cookie'
import * as response from './response'

const envConfig = {
  production: '/',
  stage: 'http://[stage]/',
  development: 'http://localhost:8080/'
}

export const baseURL = envConfig[process.env.NODE_ENV || 'development']
export const HTTP = axios.create({
  baseURL,
  timeout: 50000,
  headers: {
    common: {
      'X-Requested-With': 'XMLHttpRequest',
      'csrfToken': Cookie.get('ecm_cs_token'),
      'Content-Disposition': 'attachment',
      'filename': 'filename.xlsx'
    },
    post: {
      'Content-Type': 'application/x-www-form-urlencoded'
    }
  }
})
HTTP.interceptors.request.use(function (config) {
  // console.log('调用axios')
  config.headers.csrfToken = Cookie.get('ecm_cs_token');
  return config
}, function (error) {
  return Promise.reject(error);
})

// 处理post请求参数的方法
const postParam = (param) => {
  var data = new FormData();
  for (var i in param) {
    if (param[i] != null) {
      data.append(i, param[i])
    }
  }
  return data
}

// 全局提示方法
export const message = (obj) => {
  console.log(obj.catch)
  obj.object.$Message[obj.type]({
    content: obj.content,
    duration: obj.time || 2,
    onClose: () => {
      if (obj.callBack) obj.callBack()
    }
  })
}

// 请求部分
export const API = {
  // get请求方式
  get: params => HTTP({
    method: 'get',
    url: params.url,
    params: params.data,
  }).then((res) => {
    var data = response.data(res, params.object);
    params.then(data)
  }).catch((res) => {
    message({
      catch: res,
      content: params.errorIfo,
      object: params.object,
      type: 'info',
    })
  }),
  post: params => HTTP({
    method: 'post',
    url: params.url,
    data: postParam(params.data),
  }).then((res) => {
    var data = response.data(res, params.object)
    params.then(data)
  }).catch((res) => { // res, params.errorIfo, 'info'
    message({
      catch: res,
      content: params.errorIfo,
      object: params.object,
      type: 'info',
    })
  }),
}
