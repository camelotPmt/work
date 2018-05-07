<template>
  <div id="main">
        <div class="top-header">
            <top-header></top-header>
        </div><!--头部 end-->
        <div class="main-container" id="main-container">
            <router-view></router-view>
        </div>
        <!--内容部分 end-->
  </div>
</template>

<script>
import TopHeader from '@/components/common/HeaderTop'
export default {
    data() {
        return {

        }
    },
    components: {
        TopHeader,
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
<style scoped>
  
</style>
