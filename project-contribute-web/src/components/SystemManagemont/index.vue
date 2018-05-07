<template>
    <div class="system-container">
        <div class="sys-left-nav">
            <sys-nav></sys-nav>
        </div>
        <div class="sys-right-cont">
            <router-view></router-view>
        </div>
    </div>
</template>
<script>
import sysNav from '@/components/SystemManagemont/sysPages/sysLeftNav'
export default {
    data() {
        return {

        }
    },
    components: {
        sysNav,
    },
    mounted() {

    },
    created(){

    },
    methods: {

    } 
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="less">
    .system-container{
        .sys-left-nav{
            position:fixed;
            height:100%;
            background:#fff;
            width:15%;
            min-width:180px;
        }
        .sys-right-cont{
            position:fixed;
            left:16%;
            width:84%;
            background:#fff;
            padding:20px;
            min-height:500px;
            .ivu-select{ width:149px !important;}
        }
    }
</style>