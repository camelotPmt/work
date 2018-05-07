<template>
    <div class="left-nav-cont">
        <div class="user-name">
            <span>用户名称</span>
        </div>
        <ul>
            <router-link tag="li" :to="`${item.path}`"
            v-for="(item,index) in leftNaveList"
            exact-active-class="active"
            :key="`${item.id}`"
             >
                <a>{{item.text}}</a>
            </router-link>
        </ul>
    </div>
</template>
<script>
export default {
    data() {
        return {
            leftNaveList:[
                {
                    id: 1,
                    path: "/PersonalCenter",
                    text: "个人中心"
                },
                {
                    id: 2,
                    path: "/PersonalCenter/editPassword",
                    text: "修改密码"
                },
                {
                    id: 3,
                    path: "/PersonalCenter/taskManager",
                    text: "任务提醒"
                },
            ],
            num:1,
        }
    },
    components: {
    },
    mounted() {

    },
    created(){

    },
    methods: {

    } 
}
</script>
<style scoped lang="less">
    .user-name{ 
        width:100%; 
        height:85px; 
        line-height:85px; 
        text-align:center; 
        color:#fff; 
        font-size:24px;
        background:orange; 
        border-radius:10px;
    }
    .left-nav-cont ul{ 
        width:100%; 
        border:1px solid #eee; 
        margin-top:20px;
        border-radius:10px;
        li{ 
            height:50px; 
            line-height:50px; 
            border-bottom:1px solid #eee;
            font-size:16px;
            text-align: center;
            position: relative;
            a{ width:100%;}
        }
        li.active::before{
            content: '';
            width:3px;
            height:100%;
            background:#0459ab;
            position: absolute;
            left:0;
            top:0;
        }
        li:last-child{
            border:none;
        }
    }  
</style>