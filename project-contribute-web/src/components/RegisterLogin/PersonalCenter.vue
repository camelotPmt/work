<template>
    <div class="personal-center cont-w">
        <div class="left-nav">
            <left-nav></left-nav>
        </div>
        <div class="right-cont">
            <router-view></router-view>
        </div>
    </div>
</template>
<script>
import LeftNav from '@/components/RegisterLogin/personalCenterD/LeftNav'
export default {
    data() {
        return {

        }
    },
    components: {
        LeftNav,
    },
    mounted() {

    },
    created(){

    },
    methods: {

    } 
}
</script>
<style scoped>
    .personal-center{ overflow:hidden;}
    .left-nav,.right-cont{ float:left;}
    .left-nav{ width:20%;}
    .right-cont{ width:78%; margin-left:2%;}
</style>