<template>
    <div class="sys-nav-cont">
        <Menu :active-name="$route.name">
            <MenuItem name="systemManager">
                <i class="iconfont icon-yonghu"></i>
                <router-link to="/systemManager">用户管理</router-link>
            </MenuItem>
            <MenuItem name="roleManagement">
                <i class="iconfont icon-navicon-jsgl"></i>
                <router-link to="/roleManagement">角色管理</router-link>
            </MenuItem>
            <MenuItem name="menuManagement">
                <i class="iconfont icon-caidan"></i>
                <router-link to="/menuManagement">菜单管理</router-link>
            </MenuItem>
            <MenuItem name="authManagement">
                <i class="iconfont icon-quanxianguanli"></i>
                <router-link to="/authManagement">权限管理</router-link>
            </MenuItem>
            <MenuItem name="organizationChart">
                <i class="iconfont icon-zuzhijiagou"></i>
                <router-link to="/organizationChart">组织架构</router-link>
            </MenuItem>
            <MenuItem name="dataBase">
                <i class="iconfont icon-zhaoshengshujuzidian"></i>
                <router-link to="/dataBase">数据库字典</router-link>
            </MenuItem>
            <MenuItem name="userCase">
                <i class="iconfont icon-xitongceshiyongli"></i>
                <router-link to="/userCase">用例库</router-link>
            </MenuItem>
            <MenuItem name="operationLog">
                <i class="iconfont icon-caozuorizhi"></i>
                <router-link to="/operationLog">操作日志</router-link>
            </MenuItem>
        </Menu>
    </div>
</template>
<script>
import * as response from "../../../util/response";
export default {
  data() {
    return {
      
    };
  },
  created() {
    
  },
  mounted() {
      
  },
  methods: {
    
  }
};
</script>
<style scoped lang="less">
.sys-nav-cont {
  height: 100%;
  .ivu-menu {
    width: 100% !important;
    height: 100%;
  }
  .ivu-menu-vertical .ivu-menu-item,
  .ivu-menu-vertical .ivu-menu-submenu-title {
    padding: 0;
    height: 50px;
    line-height: 50px;
  }
  .iconfont {
    position: absolute;
    top: 0;
    font-size: 16px;
    left: 20px;
  }
  a {
    display: block;
    padding-left: 50px;
  }
}
</style>