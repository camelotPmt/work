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
        <!-- 添加产出物弹出框 -->
        <Modal
            v-model="addProductModel"
            title="添加产出物"
            class-name="vertical-center-modal"
            :mask-closable="false">
            <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="100">
                <FormItem label="产出物名称" prop="versionName">
                    <Input v-model="formValidate.versionName" placeholder="请输入产出物名称"></Input>
                </FormItem>
                <FormItem label="svn地址" prop="svnURL">
                    <Input placeholder="请输入svn地址"></Input>
                </FormItem>
            </Form>
            <div slot="footer">
                <Button type="ghost" @click="cancelBtn">取消</Button>
                <Button type="primary" @click="affirmBtn">确认</Button>
            </div>
        </Modal>
        <!-- 删除产出物 -->
        <Modal
            v-model="delItem"
            title="删除产出物"
            class-name="vertical-center-modal"
            :mask-closable="false"
            width="400">
            <div>
                <p> 产出物一经删除，不能恢复，是否删除？</p>
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
      columns1: [
        {
            title: "编号",
            key: "id"
        },
        {
            title: "名称",
            key: "username"
        },
        {
            title: "路径",
            key: "loginCode"
        },
        {
            title: "创建人",
            key: "section1"
        },
        {
            title: "创建时间",
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
      addProductModel: false,
      delItem: false,
      formValidate: {
            date: '',
            versionName: ''
        },
        ruleValidate: {
            versionName: [
                { required: true, message: '产出物名称不能为空', trigger: 'blur' }
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
      //获取产出物列表
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
          // this.$Message.error('获取产出物列表失败')
        });
    },
    change(params) {
      this.index = params;
      // this.getMuduleAList(params);
    },
    //添加产出物弹出框
    showAddpModel() {
      this.addProductModel = true;
    },
    // 添加产出物弹出层确认按钮
    affirmBtn() {
      this.addProductModel = false;
    },
    // 添加产出物弹出层取消按钮
    cancelBtn() {
      this.addProductModel = false;
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