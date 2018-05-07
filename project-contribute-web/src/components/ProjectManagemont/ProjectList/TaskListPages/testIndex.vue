<template>
   <div class="version-container">
       <Tabs type="card" :animated="false">
            <TabPane label="用例">
                <case />
            </TabPane>
            <TabPane label="BUG">
                <bug />
            </TabPane>
        </Tabs>
    </div>
</template>
<script>
import Case from './testComponents/case'
import Bug from './testComponents/bug'
export default {
    components:{Case, Bug},
  data() {
    return {
      
    };
  },
  mounted() {},
  created() {
    
  },
  methods: {
    
  }
};
</script>
<style scoped lang="less">

</style>