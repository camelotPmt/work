<template>
    <div class="sys-nav-cont">
        <Menu active-name="1">
            <MenuItem name="1">
                <Icon type="document-text"></Icon>
                <router-link to="/systemManager">用户管理</router-link>
            </MenuItem>
            <MenuItem name="2">
                <Icon type="document-text"></Icon>
                <router-link to="/roleManagement">角色管理</router-link>
            </MenuItem>
            <MenuItem name="3">
                <Icon type="document-text"></Icon>
                <router-link to="/authManagement">权限管理</router-link>
            </MenuItem>
            <MenuItem name="4">
                <Icon type="document-text"></Icon>
                <router-link to="">组织架构</router-link>
            </MenuItem>
            <MenuItem name="5">
                <Icon type="document-text"></Icon>
                <router-link to="">数据库字典</router-link>
            </MenuItem>
            <MenuItem name="6">
                <Icon type="document-text"></Icon>
                <router-link to="">用例库</router-link>
            </MenuItem>
            <MenuItem name="7">
                <Icon type="document-text"></Icon>
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
        .ivu-icon{position: absolute; top:15px; font-size:20px; left:20px;}
        a{ display:block; padding-left:50px;}
    }
</style>