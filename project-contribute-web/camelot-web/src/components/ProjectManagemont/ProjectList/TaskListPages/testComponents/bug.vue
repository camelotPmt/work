<template>
   <div class="version-container">
        <Form :model="formItem" :label-width="80" inline>
            <FormItem label="BUG名称">
                <Input v-model="formItem.id" placeholder=""></Input>
            </FormItem>
            <FormItem label="BUG编号">
                <Input v-model="formItem.name" placeholder=""></Input>
            </FormItem>
            <FormItem label="BUG类型">
                <Select v-model="formItem.role" placeholder="请选择BUG类型">
                    <Option value="beijing">全部</Option>
                    <Option value="shanghai">未确认</Option>
                    <Option value="shanghai">已确认</Option>
                    <Option value="shanghai">已撤销</Option>
                    <Option value="shanghai">已解决</Option>
                    <Option value="shanghai">未解决</Option>
                    <Option value="shanghai">已关闭</Option>
                    <Option value="shanghai">未关闭</Option>
                    <Option value="shanghai">指派给我</Option>
                </Select>
            </FormItem>
            <FormItem>
                <Button type="primary">查询</Button>
                <Button type="ghost" class="ml-10">重置</Button>
                <Button type="primary" @click="showAddpModel" class="ml-10">提BUG</Button>
            </FormItem>
        </Form>
        <Table :columns="columns1" :data="source" height="340"></Table>
        <div class="page-break">
            <Page :total="Math.floor(size)" :current="Math.floor(index)" :page-size="Math.floor(rows)" @on-change="change"></Page>
        </div>
        <!-- 添加BUG弹出框 -->
        <addBug ref="addBug" />
        <!-- 删除BUG -->
        <Modal
            v-model="delItem"
            title="删除BUG"
            class-name="vertical-center-modal"
            :mask-closable="false"
            width="400">
            <div>
                <p>BUG一经删除，不能恢复，是否删除？</p>
            </div>
            <div slot="footer">
                <Button type="ghost" @click="cancelDelBtn">取消</Button>
                <Button type="primary" @click="delBtn">删除</Button>
            </div>
        </Modal>
    </div>
</template>
<script>
import AddBug from './common/addBug'

export default {
    components: {AddBug},
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
            type: 'selection',
            width: 60,
            align: 'center'
        },
        {
            title: "编号",
            key: "id"
        },
        {
            title: "严重程度",
            key: "degree",
            render: (h, params) => {
                return h('div', [
                    h('Tag', {
                        props: { 
                            color: "#ff0000"
                        },
                    }, '严重'),
                    h('Tag', {
                        props: { 
                            color: "#33cc00"
                        },
                    }, '一般'),
                    h('Tag', {
                        props: { 
                            color: "#bfbfbf"
                        },
                    }, '优化'),
                ]);
            }
        },
        {
            title: "优先级",
            key: "username",
            render: (h, params) => {
                return h('div', [
                    h('Tag', {
                        props: { 
                            color: "#ff0000"
                        },
                    }, 'P1'),
                    h('Tag', {
                        props: { 
                            color: "#ff9933"
                        },
                    }, 'P2'),
                    h('Tag', {
                        props: { 
                            color: "#33cc00"
                        },
                    }, 'P3'),
                    h('Tag', {
                        props: { 
                            color: "#bfbfbf"
                        },
                    }, 'P4'),
                ]);
            }
        },
        {
            title: "状态",
            key: "status",
            render: (h, params) => {
                return h('div', [
                    h('span', {
                        style: { 
                            color: "#bfbfbf"
                        },
                    }, '【已关闭】'),
                    h('span', {
                        style: { 
                            color: "#33cc00"
                        },
                    }, '【已确认】'),
                    h('span', {
                        style: { 
                            color: "pink"
                        },
                    }, '【待复测】'),
                    h('span', {
                        style: { 
                            color: "#ff9933"
                        },
                    }, '【待确认】'),
                    h('span', {
                        style: { 
                            color: "#495060"
                        },
                    }, '【已撤销】'),
                ]);
            }
        },
        {
            title: "名称",
            key: "loginCode"
        },
        {
            title: "创建人",
            key: "section1",
            render: (h, params) => {
                return h('div', [
                    h('Tag', {
                        props: { 
                            color: "#33ccff"
                        },
                    }, '蔡长庆'),
                ]);
            }
        },
        {
            title: "指派给",
            key: "section2",
            render: (h, params) => {
                return h('div', [
                    h('Tag', {
                        props: { 
                            color: "#33cc00"
                        },
                    }, '蔡长庆'),
                ]);
            }

        },
        {
            title: "解决人",
            key: "section6",
            render: (h, params) => {
                return h('div', [
                    h('Tag', {
                        props: { 
                            color: "#33cc00"
                        },
                    }, '蔡长庆'),
                ]);
            }

        },
        {
            title: "解决方案",
            key: "result"
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
                            'icon-msnui-active':true,
                        },
                        style: {
                        },
                        attrs:{
                            title:'激活BUG'
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
                            'icon-zhipaisiji':true,
                        },
                        style: {
                        },
                        attrs:{
                            title:'指派'
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
                            'icon-chehui':true,
                        },
                        style: {
                        },
                        attrs:{
                            title:'撤回'
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
                            'icon-queren' :true,
                        },
                        attrs:{
                            title:'确认BUG'
                        },
                        style: {
                        },
                        on: {
                            click: () => {
                                this.delItem = true;
                            }
                        }
                    }, ''),
                    h('button', {
                        props: {   
                        },
                        'class':{
                            iconfont :true,
                            'icon-guanbi' :true,
                        },
                        attrs:{
                            title:'关闭BUG'
                        },
                        style: {
                        },
                        on: {
                            click: () => {
                                this.delItem = true;
                            }
                        }
                    }, ''),
                    h('button', {
                        props: {   
                        },
                        'class':{
                            iconfont :true,
                            'icon-hetongpingshen' :true,
                        },
                        attrs:{
                            title:'解决BUG'
                        },
                        style: {
                        },
                        on: {
                            click: () => {
                                this.delItem = true;
                            }
                        }
                    }, ''),
                    h('button', {
                        props: { 
                        },
                        'class':{
                            iconfont :true,
                            'icon-copy':true,
                        },
                        style: {
                        },
                        attrs:{
                            title:'复制BUG'
                        },
                        on: {
                            click: () => {
                                
                            }
                        }
                    }, ''),
                ]);
            }
        }
      ],
      source: [{id:1}],
      addVersionModel: false,
      delItem: false,
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
  mounted() {},
  created() {
    this.getMuduleAList();
  },
  methods: {
    getMuduleAList(index, rows) {
      //获取BUG列表
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
          // this.$Message.error('获取BUG列表失败')
        });
    },
    change(params) {
      this.index = params;
      // this.getMuduleAList(params);
    },
    //添加BUG弹出框
    showAddpModel() {
      this.$refs.addBug.showAddpModel();
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