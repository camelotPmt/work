<template>
    <div class="top-header cl">
        <div class="logo">
            <router-link to="/Home">柯莱特项目管理系统</router-link>
        </div>
        <ul class="header-nav">
            <li><router-link to="/ProjectManager">项目中心</router-link></li>
            <li><router-link to="/systemManager">系统管理</router-link></li>
        </ul>
        <Dropdown slot='header-right' placement="bottom-end" class="login-main">
            <span class="uesr-sp"><i>HI:&nbsp;</i>admin&nbsp;<Icon type="ios-arrow-down"></Icon></span>
            <Dropdown-menu slot="list">
                <Dropdown-item><router-link to="/PersonalCenter">个人中心</router-link></Dropdown-item>
                <Dropdown-item><router-link to="">考勤</router-link></Dropdown-item>
                <Dropdown-item name='logout' ><a @click="loginOut">退出登录</a></Dropdown-item>
            </Dropdown-menu>
        </Dropdown>
        <ul class="fr right-ul">
            <li class="fl">
                <router-link to="">我的</router-link>
            </li>
            <li class="fl">
                <router-link to="/Message"><span>消息<i>99+</i></span></router-link>
            </li>
        </ul>
    </div>
</template>
<script>
import * as response from '../../util/response'
export default {
    data () {
        return {
            
        }
    },
    methods: {
        // 退出
        loginOut() {
            
            this.$router.push({ 'path': '/Login' });
        }
    }
}
</script>
<style scoped lang="less">
    .top-header{ 
        height:70px;
        line-height:70px;
        background:#0459ab;
        color:#fff;
        a{color:#fff;}
    }
    .logo{ 
        font-size:22px;
        float:left;
        margin:0 0 0 30px;
        a{color:#fff;}
    }
    .header-nav{
        float:left;
        margin-left:25px;
        font-size:14px;
        a{
            color:#fff
        }
        li{
            float:left;
            padding:0 25px;
        }
    }
    .login-main{ 
        float:right;
        color:#fff;
        font-size:16px;
        margin-right:20px;
    }
    .login-main a{ color:#333;}
    .right-ul{ 
        li{
            margin-right:30px;
        }
        span{
            position: relative;
            display:block;
        }
        i{ 
            display:block;
            width:15px;
            height:15px;
            line-height:15px;
            text-align:center;
            color:hsl(0, 100%, 51%);
            border-radius:50px;
            position: absolute;
            top:15px;
            right:-10px;
        }
    }
</style>