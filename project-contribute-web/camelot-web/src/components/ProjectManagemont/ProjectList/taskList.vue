<template>
    <div class="task-list-container">
        <div>
            <task-head></task-head>
        </div>
        <div>
            <router-view></router-view>
        </div>
    </div>
</template>
<script>
import TaskHead from '@/components/ProjectManagemont/ProjectList/TaskListPages/taskHead'    
export default {
    data() {
    return {

    }
    },
    components: {
        TaskHead,
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
.task-list-container{
    margin:20px 20px 0 20px;
    background:#fff;
    padding:15px;
}
</style>