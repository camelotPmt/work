// 配置路由文件
import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'

// import * as response from '@/util/response'
// 引入组件
export const tuodong = require('../components/tuodong.vue').default
export const Login = require('../components/Login.vue').default
export const HomeIndex = require('../components/RegisterLogin/Home.vue').default
export const Message = require('../components/RegisterLogin/MessageMail.vue').default
export const PersonalCenter = require('../components/RegisterLogin/PersonalCenter.vue').default
export const PersonalForm = require('../components/RegisterLogin/personalCenterD/personalForm.vue').default
export const EditPassword = require('../components/RegisterLogin/personalCenterD/editPassword.vue').default
export const TaskManager = require('../components/RegisterLogin/personalCenterD/taskManager.vue').default
export const systemManager = require('../components/SystemManagemont/index.vue').default
export const userManagement = require('../components/SystemManagemont/sysPages/userManagement.vue').default
export const roleManagement = require('../components/SystemManagemont/sysPages/roleManagement.vue').default
export const menuManagement = require('../components/SystemManagemont/sysPages/menuManagement.vue').default
export const organizationChart = require('../components/SystemManagemont/sysPages/organizationChart.vue').default
export const dataBase = require('../components/SystemManagemont/sysPages/dataBase.vue').default
export const userCase = require('../components/SystemManagemont/sysPages/UseCaseLibrary.vue').default
export const operationLog = require('../components/SystemManagemont/sysPages/operationLog.vue').default
export const authManagement = require('../components/SystemManagemont/sysPages/authorityManagement.vue').default
export const ProjectManager = require('../components/ProjectManagemont/index.vue').default
export const ProjectList = require('../components/ProjectManagemont/ProjectList/projectList.vue').default
export const ProjectSetting = require('../components/ProjectManagemont/ProjectList/projectSetting.vue').default
export const ItemInfor = require('../components/ProjectManagemont/ProjectList/ProjectSetPages/itemInfor.vue').default
export const TaskList = require('../components/ProjectManagemont/ProjectList/taskList.vue').default
export const TaskIndex = require('../components/ProjectManagemont/ProjectList/TaskListPages/taskIndex.vue').default
export const versionIndex = require('../components/ProjectManagemont/ProjectList/TaskListPages/versionIndex.vue').default
export const productIndex = require('../components/ProjectManagemont/ProjectList/TaskListPages/productIndex.vue').default
export const memberIndex = require('../components/ProjectManagemont/ProjectList/TaskListPages/memberIndex.vue').default
export const testIndex = require('../components/ProjectManagemont/ProjectList/TaskListPages/testIndex.vue').default
export const SetRember = require('../components/ProjectManagemont/ProjectList/ProjectSetPages/setRember.vue').default
export const TaskPermissions = require('../components/ProjectManagemont/ProjectList/ProjectSetPages/taskPermissions.vue').default
export const DemandIndex = require('../components/ProjectManagemont/ProjectList/TaskListPages/demandList.vue').default

// 注册路由
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: { path: '/Home' }
    },
    {
      path: '/Home',
      name: 'Home',
      component: Home,
      children: [
        {
          path: '/Home', // 首页
          name: 'HomeIndex',
          component: HomeIndex,
        },
        {
          path: '/Home1', // 案例拖动
          name: 'tuodong',
          component: tuodong,
        },
        {
          path: '/PersonalCenter', // 个人中心
          name: 'PersonalCenter',
          component: PersonalCenter,
          children: [
            {
              path: '/PersonalCenter',
              name: 'PersonalForm',
              component: PersonalForm,
            },
            {
              path: '/PersonalCenter/EditPassword', // 修改密码
              name: 'EditPassword',
              component: EditPassword,
            },
            {
              path: '/PersonalCenter/TaskManager', // 任务提醒
              name: 'TaskManager',
              component: TaskManager,
            }
          ]
        },
        {
          path: '/Message', // 站内信
          name: 'Message',
          component: Message,
        },
        {
          path: '/systemManager', // 系统管理
          name: 'systemManager',
          component: systemManager,
          children: [
            {
              path: '/systemManager', // 用户管理
              name: 'systemManager', // 为解决刷新，active状态回到第一个，默认name和path值保持一致
              component: userManagement,
            },
            {
              path: '/roleManagement', // 角色管理
              name: 'roleManagement',
              component: roleManagement,
            },
            {
              path: '/menuManagement', // 菜单管理
              name: 'menuManagement',
              component: menuManagement,
            },
            {
              path: '/authManagement', // 权限管理
              name: 'authManagement',
              component: authManagement,
            },
            {
              path: '/organizationChart', // 组织架构
              name: 'organizationChart',
              component: organizationChart,
            },
            {
              path: '/dataBase', // 数据库字典
              name: 'dataBase',
              component: dataBase,
            },
            {
              path: '/userCase', // 用例库
              name: 'userCase',
              component: userCase,
            },
            {
              path: '/operationLog', // 操作日志
              name: 'operationLog',
              component: operationLog,
            },
          ]
        },
        {
          path: '/ProjectManager', // 项目中心
          name: 'ProjectManager',
          component: ProjectManager,
          children: [
            {
              path: '/ProjectManager', // 项目列表
              name: 'ProjectList',
              component: ProjectList,
            }
          ]
        },
        {
          path: '/TaskList', // 任务列表
          name: 'TaskList',
          component: TaskList,
          children: [
            {
              path: 'TaskIndex', // 任务页面
              name: 'TaskIndex',
              component: TaskIndex,
            },
            {
              path: 'versionIndex', // 版本页面
              name: 'versionIndex',
              component: versionIndex,
            },
            {
              path: 'memberIndex', // 成员页面
              name: 'memberIndex',
              component: memberIndex,
            },
            {
              path: 'productIndex', // 产出物页面
              name: 'productIndex',
              component: productIndex,
            },
            {
              path: 'testIndex', // 测试页面
              name: 'testIndex',
              component: testIndex,
            },
            {
              path: 'demandIndex', // 需求页面
              name: 'DemandIndex',
              component: DemandIndex,
            },
          ]
        },
        {
          path: '/ProjectSetting', // 项目设置
          name: 'ProjectSetting',
          component: ProjectSetting,
          children: [
            {
              path: '/ProjectSetting', // 项目信息
              name: 'ItemInfor',
              component: ItemInfor,
            },
            {
              path: '/SetRember', // 提醒设置
              name: 'SetRember',
              component: SetRember,
            },
            {
              path: '/TaskPermissions', // 任务权限
              name: 'TaskPermissions',
              component: TaskPermissions,
            }
          ]
        },
      ]

    },
    {
      path: '/Login',
      name: 'Login',
      component: Login,
    },

  ]
})
