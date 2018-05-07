<template>
    <div class="project-setting cont-w cl">
        <div class="title">项目设置</div>
        <div class="setting-left fl">
            <ul>
                <router-link tag="li" :to="`${item.path}`"
                v-for="(item,index) in setLeftList"
                exact-active-class="active"
                :key="`${item.id}`"
                >
                    <a>{{item.text}}</a>
                </router-link>
            </ul>
        </div>
        <div class="setting-cont fl">
            <router-view></router-view>
        </div>
    </div>
</template>
<script>
// import HeadProject from '@/components/ProjectManagemont/common/header'
export default {
    data() {
        return {
            setLeftList:[
                {
                    id:1,
                    path:'/ProjectSetting',
                    text:'项目信息',
                },
                {
                    id:2,
                    path:'/SetRember',
                    text:'提醒设置',
                },
                {
                    id:3,
                    path:'/TaskPermissions',
                    text:'任务权限',
                },
            ],
            num:1,
        }
    },
    components: {
    // HeadProject,
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
    .setting-left{
        width:20%;
        ul{
            width:100%;
            border: 1px solid #eee;
            border-radius:10px;
        }
        li{
            height: 50px;
            line-height: 50px;
            border-bottom: 1px solid #eee;
            font-size: 16px;
            text-align: center;
            position: relative;
            a{
                width:100%;
            }
            
        }
        li.active::before{
            content: '';
            position:absolute;
            left:0;
            top:0;
            width:3px;
            height:100%;
            background:#0459ab;
        }
        li:last-child{
            border:none;
        }
    }
    .setting-cont{
        width:78%;
        margin-left:2%;
    }
</style>