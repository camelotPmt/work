<template>
    <div class="task-head-nav">
        <ul class="cl">
            <router-link tag="li" :to="`${item.path}`"
            v-for="(item,index) in headerList"
            active-class="active"
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
      headerList: [
        {
            id: 1,
            path: "/TaskList/TaskIndex",
            text: "任务"
        },
        {
            id: 2,
            path: "/TaskList/versionIndex",
            text: "版本"
        },
        {
            id: 3,
            path: "/TaskList/demandIndex",
            text: "需求"
        },
        {
            id: 4,
            path: "/TaskList/testIndex",
            text: "测试"
        },
        {
            id: 5,
            path: "/TaskList/memberIndex",
            text: "成员"
        },
        {
            id: 6,
            path: "/TaskList/productIndex",
            text: "产出物"
        }
      ],
      num: 1,
    };
  },
};
</script>
<style scoped lang="less">
.task-head-nav {
  margin-bottom: 20px;
  li {
    margin-right: 30px;
    float: left;
    position: relative;
    padding-bottom: 5px;
  }
  li.active:before {
    content: "";
    width: 100%;
    height: 3px;
    background: #0459ab;
    position: absolute;
    bottom: 0;
    left: 0;
  }
}
</style>