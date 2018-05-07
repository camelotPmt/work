<template>
   <div class="version-container">
        <Form :model="formItem" :label-width="80" inline>
            <FormItem label="版本名称">
                <Input v-model="formItem.id" placeholder=""></Input>
            </FormItem>
            <FormItem label="版本编号">
                <Input v-model="formItem.name" placeholder=""></Input>
            </FormItem>
            <FormItem label="版本类型">
                <Select v-model="formItem.role" placeholder="请选择版本类型">
                    <Option value="beijing">正式</Option>
                    <Option value="shanghai">测试</Option>
                </Select>
            </FormItem>
            <FormItem>
                <Button type="primary">查询</Button>
                <Button type="ghost" class="ml-10">重置</Button>
                <Button type="primary" @click="showAddpModel" class="ml-10">添加</Button>
            </FormItem>
        </Form>
        <Table :columns="columns1" :data="source" height="340"></Table>
        <div class="page-break">
            <Page :total="Math.floor(size)" :current="Math.floor(index)" :page-size="Math.floor(rows)" @on-change="change"></Page>
        </div>
        <!-- 添加版本弹出框 -->
        <Modal
            v-model="addVersionModel"
            title="添加版本"
            class-name="vertical-center-modal"
            :mask-closable="false">
            <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="100">
                <FormItem label="版本编号" prop="name">
                    <Row>
                        <Col span="12">
                            <Input placeholder="请输入版本编号"></Input>
                        </Col>
                    </Row>
                </FormItem>
                <FormItem label="版本类型">
                    <Row>
                        <Col span="12">
                            <Select v-model="formItem.role" placeholder="请选择版本类型">
                                <Option value="beijing">正式</Option>
                                <Option value="shanghai">测试</Option>
                            </Select>
                        </Col>
                    </Row>
                </FormItem>
                <FormItem label="版本名称" prop="versionName">
                    <Input v-model="formValidate.versionName" placeholder="请输入版本名称"></Input>
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
        <!-- 删除版本 -->
        <Modal
            v-model="delItem"
            title="删除版本"
            class-name="vertical-center-modal"
            :mask-closable="false"
            width="400">
            <div>
                <p>版本一经删除，不能恢复，是否删除？</p>
            </div>
            <div slot="footer">
                <Button type="ghost" @click="cancelDelBtn">取消</Button>
                <Button type="primary" @click="delBtn">删除</Button>
            </div>
        </Modal>
    </div>
</template>
<script>
export default {
  data() {
    return {
      index: "1",
      rows: "10",
      size: "",
      formItem: {
        id: "",
        name: "",
        role: "",
        activate: ""
      },
      columns1: [
        {
            title: "版本编号",
            key: "id"
        },
        {
            title: "版本名称",
            key: "username"
        },
        {
            title: "版本类型",
            key: "loginCode"
        },
        {
            title: "开始时间",
            key: "section1"
        },
        {
            title: "结束时间",
            key: "section2"
        },
        {
            title: "操作",
            key: "section4",
            render: (h, params) => {
                return h('div', [
                    h('button', {
                        props: { 
                        },
                        'class':{
                            iconfont :true,
                            'icon-jinyong':true,
                        },
                        style: {
                        },
                        on: {
                            click: () => {
                                
                            }
                        }
                    }, ''),
                    h('button', {
                        props: { 
                        },
                        'class':{
                            iconfont :true,
                            'icon-msnui-active':true,
                        },
                        style: {
                        },
                        on: {
                            click: () => {
                                
                            }
                        }
                    }, ''),
                    h('button', {
                        props: {   
                        },
                        'class':{
                            iconfont :true,
                            'icon-icon7' :true,
                        },
                        style: {
                        },
                        on: {
                            click: () => {
                                this.delItem = true;
                            }
                        }
                    }, ''),
                ]);
            }
        }
      ],
      source: [],
      addVersionModel: false,
      delItem: false,
      formValidate: {
                date: '',
                versionName: ''
            },
            ruleValidate: {
                versionName: [
                    { required: true, message: '版本名称不能为空', trigger: 'blur' }
                ],
                date: [
                    { required: true, type: 'date', message: 'Please select the date', trigger: 'change' }
                ],
            }
    };
  },
  mounted() {},
  created() {
    this.getMuduleAList();
  },
  methods: {
    getMuduleAList(index, rows) {
      //获取版本列表
      var data = new FormData();
      // data.append()
      this.$http
        .post("/user/queryAllUsers", data)
        .then(res => {
          var data = response.data(res, this);
          if (data) {
            this.size = data.total;
            this.source = data;
          }
        })
        .catch(res => {
          // this.$Message.error('获取版本列表失败')
        });
    },
    change(params) {
      this.index = params;
      // this.getMuduleAList(params);
    },
    //添加版本弹出框
    showAddpModel() {
      this.addVersionModel = true;
    },
    // 添加版本弹出层确认按钮
    affirmBtn() {
      this.addVersionModel = false;
    },
    // 添加版本弹出层取消按钮
    cancelBtn() {
      this.addVersionModel = false;
    },
    // 确认删除项目
    delBtn(){
        this.delItem = false;
    },
    // 取消删除
    cancelDelBtn(){
        this.delItem = false;
    },
  }
};
</script>
<style scoped lang="less">

</style>