<template>
    <div class="demand-container">
        <Tabs type="card" :animated="false">
            <TabPane label="全部">
                <all/>
            </TabPane>
            <TabPane label="已变更">
                <change/>
            </TabPane>
            <TabPane label="已关闭">
                <close/>
            </TabPane>
            <TabPane label="由我评审">
                <review/>
            </TabPane>
        </Tabs>
    </div>
</template>
<script>
    import All from './demandComponents/allList'
    import Change from './demandComponents/changeList'
    import Close from './demandComponents/closeList'
    import Review from './demandComponents/reviewList'
    export default {
        data(){
            return{

            }
        },
        components:{
            All,
            Change,
            Close,
            Review
        },
    }
</script>
<style scoped lang="less">
    .demand-container{
        min-height:500px;
    }
</style>
