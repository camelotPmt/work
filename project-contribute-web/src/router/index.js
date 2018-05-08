// 配置路由文件
import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import HomeIndex from '@/components/RegisterLogin/Home'// 首页
import Login from '@/components/Login'// 登录

// import * as response from '@/util/response'
// 引入组件
const tuodong = r => require.ensure([], () => r(require('../components/tuodong.vue')), 'tuodong')

const HomeIn = r => require.ensure([], () => r(require('../components/RegisterLogin/Home.vue')), 'HomeIn')
const Message = r => require.ensure([], () => r(require('../components/RegisterLogin/MessageMail.vue')), 'Message')
const PersonalCenter = r => require.ensure([], () => r(require('../components/RegisterLogin/PersonalCenter.vue')), 'PersonalCenter')
const PersonalForm = r => require.ensure([], () => r(require('../components/RegisterLogin/personalCenterD/personalForm.vue')), 'LeftNav')
const EditPassword = r => require.ensure([], () => r(require('../components/RegisterLogin/personalCenterD/editPassword.vue')), 'EditPassword')
const TaskManager = r => require.ensure([], () => r(require('../components/RegisterLogin/personalCenterD/taskManager.vue')), 'TaskManager')
const systemManager = r => require.ensure([], () => r(require('../components/SystemManagemont/index.vue')), 'TaskManager')
const userManagement = r => require.ensure([], () => r(require('../components/SystemManagemont/sysPages/userManagement.vue')), 'userManagement')
const roleManagement = r => require.ensure([], () => r(require('../components/SystemManagemont/sysPages/roleManagement.vue')), 'roleManagement')
const authManagement = r => require.ensure([], () => r(require('../components/SystemManagemont/sysPages/authorityManagement.vue')), 'authManagement')

const ProjectManager = r => require.ensure([], () => r(require('../components/ProjectManagemont/index.vue')), 'ProjectManager')
const ProjectList = r => require.ensure([], () => r(require('../components/ProjectManagemont/ProjectList/projectList.vue')), 'ProjectList')
const ProjectSetting = r => require.ensure([], () => r(require('../components/ProjectManagemont/ProjectList/projectSetting.vue')), 'ProjectSetting')
const ItemInfor = r => require.ensure([], () => r(require('../components/ProjectManagemont/ProjectList/ProjectSetPages/itemInfor.vue')), 'ItemInfor')
const TaskList = r => require.ensure([], () => r(require('../components/ProjectManagemont/ProjectList/taskList.vue')), 'TaskList')
const TaskIndex = r => require.ensure([], () => r(require('../components/ProjectManagemont/ProjectList/TaskListPages/taskIndex.vue')), 'TaskIndex')
const versionIndex = r => require.ensure([], () => r(require('../components/ProjectManagemont/ProjectList/TaskListPages/versionIndex.vue')), 'versionIndex')
const productIndex = r => require.ensure([], () => r(require('../components/ProjectManagemont/ProjectList/TaskListPages/productIndex.vue')), 'productIndex')
const memberIndex = r => require.ensure([], () => r(require('../components/ProjectManagemont/ProjectList/TaskListPages/memberIndex.vue')), 'memberIndex')
const testIndex = r => require.ensure([], () => r(require('../components/ProjectManagemont/ProjectList/TaskListPages/testIndex.vue')), 'testIndex')
const SetRember = r => require.ensure([], () => r(require('../components/ProjectManagemont/ProjectList/ProjectSetPages/setRember.vue')), 'SetRember')
const TaskPermissions = r => require.ensure([], () => r(require('../components/ProjectManagemont/ProjectList/ProjectSetPages/taskPermissions.vue')), 'TaskPermissions')
const DemandIndex = r => require.ensure([], () => r(require('../components/ProjectManagemont/ProjectList/TaskListPages/demandList.vue')), 'DemandIndex')

// const pJ = r => require.ensure([], () => r(require('../components/ProjectManagemont/ProjectList/ProjectSetPages/pj.vue')), 'pJ')

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
              name: 'userManagement',
              component: userManagement,
            },
            {
              path: '/roleManagement', // 角色管理
              name: 'roleManagement',
              component: roleManagement,
            },
            {
              path: '/authManagement', // 权限管理
              name: 'authManagement',
              component: authManagement,
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
        // {
        //   path: '/pj',//项目信息
        //   name: 'pJ',
        //   component: pJ,
        // }
      ]

    },
    {
      path: '/Login',
      name: 'Login',
      component: Login,
    },

  ]
})
