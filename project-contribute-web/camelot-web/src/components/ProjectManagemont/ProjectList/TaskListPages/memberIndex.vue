<template>
   <div class="product-container">
       <Form :label-width="80" inline class="cl">
            <FormItem class="fr">
                <Button type="primary" @click="showAddpModel">添加</Button>
            </FormItem>
        </Form>
        <Table :columns="columns1" :data="source" height="340"></Table>
        <div class="page-break">
            <Page :total="Math.floor(size)" :current="Math.floor(index)" :page-size="Math.floor(rows)" @on-change="change"></Page>
        </div>
        <!-- 添加成员弹出框 -->
        <Modal
            v-model="addProductModel"
            title="添加成员"
            class-name="vertical-center-modal"
            width="400"
            :mask-closable="false">
            <Form :model="addItemMemberForm" :label-width="80">
                <FormItem label="姓名">
                    <Select v-model="addItemMemberForm.select1" filterable multiple placeholder="请选择成员姓名">
                        <Option v-for="item in memberList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                    </Select>
                </FormItem>
                <FormItem label="职位">
                    <Select v-model="addItemMemberForm.select2" placeholder="请选择成员职位">
                        <Option value="beijing">项目经理</Option>
                        <Option value="shanghai">成员</Option>
                    </Select>
                </FormItem>
                <FormItem label="员工号">
                    <Input v-model="addItemMemberForm.number" placeholder="请输入员工号"></Input>
                </FormItem>
                <FormItem label="成员数量">
                    <Progress :percent="10"></Progress>
                </FormItem>
            </Form>
            <div slot="footer">
                <Button type="ghost" @click="cancelBtn">取消</Button>
                <Button type="primary" @click="affirmBtn">确认</Button>
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
      columns1: [
        {
            title: "项目工号",
            key: "id"
        },
        {
            title: "名称",
            key: "username"
        },
        {
            title: "职业",
            key: "loginCode"
        },
        {
            title: "职位",
            key: "section1"
        },
        {
            title: "操作",
            key: "section4",
            render: (h, params) => {
                return h('div', [
                    h('button', {
                        props: {   
                        },
                        style: {
                            color: '#0459ab',
                        },
                        on: {
                            click: () => {
                                
                            }
                        }
                    }, '进项目'),
                    h('button', {
                        props: {   
                        },
                        style: {
                            color: '#ed3f14'
                        },
                        on: {
                            click: () => {
                                
                            }
                        }
                    }, '出项目'),
                ]);
            }
        }
      ],
      source: [],
      addProductModel: false,
      addItemMemberForm:{
        select1:[],
        select2:'',
        number:'',
    },
    memberList:[
        {
            value: '张三',
            label: '张三'
        },
        {
            value: '李四',
            label: '李四'
        },
        {
            value: '王五',
            label: '王五'
        },
    ],
      formValidate: {
            date: '',
            versionName: ''
        },
        ruleValidate: {
            versionName: [
                { required: true, message: '成员名称不能为空', trigger: 'blur' }
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
      //获取成员列表
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
          // this.$Message.error('获取成员列表失败')
        });
    },
    change(params) {
      this.index = params;
      // this.getMuduleAList(params);
    },
    //添加成员弹出框
    showAddpModel() {
      this.addProductModel = true;
    },
    // 添加成员弹出层确认按钮
    affirmBtn() {
      this.addProductModel = false;
    },
    // 添加成员弹出层取消按钮
    cancelBtn() {
      this.addProductModel = false;
    },
  }
};
</script>
<style scoped lang="less">

</style>