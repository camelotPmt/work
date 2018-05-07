<template>
    <!-- 添加BUG弹出框 -->
    <Modal
        v-model="addBugModel"
        title="添加BUG"
        class-name="vertical-center-modal"
        :mask-closable="false">
        <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="100">
            <FormItem label="BUG编号" prop="name">
                <Row>
                    <Col span="12">
                        <Input placeholder="请输入BUG编号"></Input>
                    </Col>
                </Row>
            </FormItem>
            <FormItem label="BUG类型">
                <Row>
                    <Col span="12">
                        <Select placeholder="请选择BUG类型">
                            <Option value="beijing">正式</Option>
                            <Option value="shanghai">测试</Option>
                        </Select>
                    </Col>
                </Row>
            </FormItem>
            <FormItem label="BUG名称" prop="versionName">
                <Input v-model="formValidate.versionName" placeholder="请输入BUG名称"></Input>
            </FormItem>
            <FormItem label="gethup代码ID" prop="mail">
                <Input placeholder="请输入gethup代码ID"></Input>
            </FormItem>
            <FormItem label="gethup/svnURL" prop="svnURL">
                <Input placeholder="请输入gethup/svnURL"></Input>
            </FormItem>
            <FormItem label="时间">
                <Row>
                    <Col span="11">
                        <FormItem prop="date">
                            <DatePicker type="date" placeholder="请选择开始时间" v-model="formValidate.date"></DatePicker>
                        </FormItem>
                    </Col>
                    <Col span="2" style="text-align: center">-</Col>
                    <Col span="11">
                        <FormItem prop="date">
                            <DatePicker type="date" placeholder="请选择结束时间" v-model="formValidate.date"></DatePicker>
                        </FormItem>
                    </Col>
                </Row>
            </FormItem>
        </Form>
        <div slot="footer">
            <Button type="ghost" @click="cancelBtn">取消</Button>
            <Button type="primary" @click="affirmBtn">确认</Button>
        </div>
    </Modal>
</template>
<script>
export default {
  data() {
    return {
      addBugModel: false,
      formValidate: {
                date: '',
                versionName: ''
            },
            ruleValidate: {
                versionName: [
                    { required: true, message: 'BUG名称不能为空', trigger: 'blur' }
                ],
                date: [
                    { required: true, type: 'date', message: 'Please select the date', trigger: 'change' }
                ],
            }
    };
  },
  mounted() {
  },
  created() {
  },
  methods: {
    //添加BUG弹出框
    showAddpModel() {
      this.addBugModel = true;
    },
    // 添加BUG弹出层确认按钮
    affirmBtn() {
      this.addBugModel = false;
    },
    // 添加BUG弹出层取消按钮
    cancelBtn() {
      this.addBugModel = false;
    },
  }
};
</script>
<style scoped lang="less">

</style>