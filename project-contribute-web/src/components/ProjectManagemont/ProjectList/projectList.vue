<template>
    <div class="project-list">
        <Form :model="formItem" inline>
            <FormItem>
                <Select v-model="formItem.select" placeholder="请选择项目">
                    <Option value="beijing">所有项目</Option>
                    <Option value="shanghai">个人项目</Option>
                </Select>
            </FormItem>
            <FormItem>
                <Input v-model="formItem.name" placeholder="请输入项目名称"></Input>
            </FormItem>
            <FormItem>
                <Button type="primary" @click="queryBtn">查询项目</Button>
                <Button type="primary" class="ml-10" @click="showAddpModel">添加项目</Button>
            </FormItem>
        </Form>
        <Tabs type="card" :animated="false">
            <Dropdown class="select-change">
                <Button type="primary">
                    请选择排序方式
                    <Icon type="arrow-down-b"></Icon>
                </Button>
                <DropdownMenu slot="list">
                    <DropdownItem>按进度排序</DropdownItem>
                    <DropdownItem>按截至日期</DropdownItem>
                    <DropdownItem>延时</DropdownItem>
                    <DropdownItem>延期</DropdownItem>
                </DropdownMenu>
            </Dropdown>
            <TabPane label="全部">
                <Table border :columns="pjList" :data="pjSource"></Table>
            </TabPane>
            <TabPane label="未开始">2</TabPane>
            <TabPane label="进行中">3</TabPane>
            <TabPane label="挂起">4</TabPane>
            <TabPane label="关闭">5</TabPane>
        </Tabs>
        <!-- 添加项目弹出框 -->
        <Modal
            v-model="addItem"
            title="创建项目"
            class-name="vertical-center-modal"
            :mask-closable="false"
            :width="400">
            <Form :model="addItemForm" :label-width="80">
                <FormItem label="项目名称">
                    <Input v-model="addItemForm.name" placeholder="请输入项目名称"></Input>
                </FormItem>
                <FormItem label="项目描述">
                    <Input v-model="addItemForm.textarea" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="请输入项目描述"></Input>
                </FormItem>
            </Form>
            <div slot="footer">
                <Button type="ghost" @click="proCancel">取消</Button>
                <Button type="primary" @click="proAdd">完成并创建</Button>
            </div>
        </Modal>
        <!-- 添加项目成员-->
        <Modal
            v-model="addItemMember"
            title="添加成员"
            class-name="vertical-center-modal"
            :mask-closable="false"
            :width="400">
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
                <Button type="ghost" @click="cancelAddBtn">取消</Button>
                <Button type="primary" @click="addBtn">添加</Button>
            </div>
        </Modal>
        <!-- 删除项目 -->
        <Modal
            v-model="delItem"
            title="删除项目"
            class-name="vertical-center-modal"
            :mask-closable="false"
            :width="400">
            <div>
                <p class="tishi-p">
                    <i class="iconfont icon-tishi tishi-icon"></i>
                    项目一经删除，不能恢复是否删除？
                </p>
            </div>
            <div slot="footer">
                <Button type="ghost" @click="cancelDelBtn">取消</Button>
                <Button type="primary" @click="delBtn">删除</Button>
            </div>
        </Modal>
        <!-- 关闭项目 -->
        <Modal
            v-model="closeItem"
            title="关闭项目"
            class-name="vertical-center-modal"
            :mask-closable="false"
            :width="400">
            <Form :model="closeItemForm">
                <FormItem>
                    <Input v-model="closeItemForm.textarea" type="textarea" :autosize="{minRows: 5,maxRows: 8}" placeholder="请输入关闭项目原因"></Input>
                </FormItem>
            </Form>
            <div slot="footer">
                <Button type="ghost" @click="cancelCloseBtn">取消</Button>
                <Button type="primary" @click="closeBtn">确认</Button>
            </div>
        </Modal>
    </div>
</template>
<script>
import * as response from '../../../util/response'
export default {
    data () {
        return {
            index:'1',
            rows:'10',
            size:'',
            changeSelect:'',
            addItem:false,//项目添加弹框
            addItemMember:false,//项目成员弹框
            delItem:false,//项目删除弹框
            closeItem:false,//项目关闭弹框
            formItem:{
                select:'',
                name:'',
            },
            addItemForm:{
                name:'',
                textarea:'',
            },
            addItemMemberForm:{
                select1:[],
                select2:'',
                number:'',
            },
            closeItemForm:{
                textarea:'',
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
            pjList: [
                {
                    title: '项目名称',
                    key: 'projectName',
                },
                {
                    title: '项目进度',
                    key: 'age'
                },
                {
                    title: '项目状态',
                    key: 'projectDesc'
                },
                {
                    title: '操作',
                    key: 'action',
                    width: 200,
                    align: 'center',
                    render: (h, params) => {
                        return h('div', [
                            h('button', {
                                props: { 
                                },
                                attrs:{
                                    title:'添加'
                                },
                                'class':{
                                    iconfont :true,
                                    'icon-tianjiachengyuan':true,
                                },
                                style: {
                                },
                                on: {
                                    click: () => {
                                        this.addItemMember = true;
                                    }
                                }
                            }, ''),//添加
                            h('button', {
                                props: {   
                                },
                                attrs:{
                                    title:'删除'
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
                            }, ''),//删除
                            h('button', {
                                props: { 
                                },
                                attrs:{
                                    title:'关闭'
                                },
                                'class':{
                                    iconfont :true,
                                    'icon-guanbi':true,
                                },
                                style: {
                                },
                                on: {
                                    click: () => {
                                        this.closeItem = true;
                                    }
                                }
                            }, ''),//关闭
                            h('button', {
                                props: {
                                },
                                attrs:{
                                    title:'设置'
                                },
                                'class':{
                                    iconfont :true,
                                    'icon-shezhi':true,
                                },
                                on: {
                                    click: () => {
                                        window.location.href = '/#/ProjectSetting'
                                    }
                                }
                            }, '')//设置
                        ]);
                    }
                }
            ],
            pjSource: [],
            oldDgs:[],
            
        }
    },
    mounted(){
        //滚动加载
        let _this= this;
        window.addEventListener('scroll',function(){
            if(_this.pjSource.length >= 99){
                var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
                var winH = document.documentElement.clientHeight;
                var t = document.body.scrollHeight;
                // console.log(scrollTop+winH);
                // console.log(t);
                if(scrollTop +winH >= t) {
                    if( _this.oldDgs.length == _this.pjSource.length){}else{
                        alert(1)
                        _this.rows = _this.rows+5;
                        _this.oldDgs = _this.pjSource;
                        _this.fetch();
                    }
                    _this.oldDgs = _this.pjSource;
                }
            }
        });
    },
    created(){
        this.getProjectList();
    },
    methods: {
        // 获取项目列表
        getProjectList(index,rows){
            var data = {
                currentPage:index || this.index,
                pageSize:rows || this.rows,
                projectName:this.formItem.name,
            }
            this.$http.get('/project/queryAllByPage', { params:data})
            .then(res=>{
                var data = response.data(res, this);
                if(data){
                    // this.size = data.total;
                    this.pjSource = data;
                }
            })
            .catch(res => {
                // this.$Message.error('获取用户列表失败')
            })
        },
        show (index) {
            this.$Modal.info({
                title: 'User Info',
                content: `Name：${this.data6[index].name}<br>Age：${this.data6[index].age}<br>Address：${this.data6[index].address}`
            })
        },
        remove (index) {
            this.data6.splice(index, 1);
        },
        //查询
        queryBtn(){
            this.index = 1;
            this.getProjectList();
        },
        //添加项目按钮
        showAddpModel(){
            this.addItem = true;
        },
        // 添加项目确认按钮
        proAdd(){
            this.addItem = false;
        },
        // 添加项目取消按钮
        proCancel(){
            this.addItem = false;
        },
        //添加成员取消按钮
        cancelAddBtn(){
            this.addItemMember = false;
        },
        //添加成员按钮
        addBtn(){
            this.addItemMember = false;
        },
        //确认删除项目
        delBtn(){
            this.delItem = false;
        },
        //  取消删除
        cancelDelBtn(){
            this.delItem = false;
        },
        //取消关闭
        cancelCloseBtn(){
            this.closeItem = false;
        },
        //确认关闭
        closeBtn(){
            this.closeItem = false;
        },
    }
}
</script>
<style scoped lang="less">
    .select-change{ 
        position:absolute;
        top:0;
        right:0;
    }
</style>