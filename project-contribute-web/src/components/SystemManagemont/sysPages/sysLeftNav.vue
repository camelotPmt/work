<template>
    <div class="sys-nav-cont">
        <Menu active-name="1">
            <MenuItem name="1">
                <i class="iconfont icon-yonghu"></i>
                <router-link to="/systemManager">用户管理</router-link>
            </MenuItem>
            <MenuItem name="2">
                <i class="iconfont icon-navicon-jsgl"></i>
                <router-link to="/roleManagement">角色管理</router-link>
            </MenuItem>
            <MenuItem name="3">
                <i class="iconfont icon-caidan"></i>
                <router-link to="/authManagement">菜单管理</router-link>
            </MenuItem>
            <MenuItem name="4">
                <i class="iconfont icon-quanxianguanli"></i>
                <router-link to="/authManagement">权限管理</router-link>
            </MenuItem>
            <MenuItem name="5">
                <i class="iconfont icon-zuzhijiagou"></i>
                <router-link to="">组织架构</router-link>
            </MenuItem>
            <MenuItem name="6">
                <i class="iconfont icon-zhaoshengshujuzidian"></i>
                <router-link to="">数据库字典</router-link>
            </MenuItem>
            <MenuItem name="7">
                <i class="iconfont icon-xitongceshiyongli"></i>
                <router-link to="">用例库</router-link>
            </MenuItem>
            <MenuItem name="8">
                <i class="iconfont icon-caozuorizhi"></i>
                <router-link to="">操作日志</router-link>
            </MenuItem>
        </Menu>
    </div>
</template>
<style scoped lang="less">
    .sys-nav-cont{
        height:100%;
        .ivu-menu{ 
            width:100% !important;
            height:100%;
        }
        .ivu-menu-vertical .ivu-menu-item, .ivu-menu-vertical .ivu-menu-submenu-title{
            padding:0;
            height:50px;
            line-height:50px;
        }
        .iconfont{position: absolute; top:0; font-size:16px; left:20px;}
        a{ display:block; padding-left:50px;}
    }
</style>