<template>
        <div class="sys-right-wrap">
            <div class="sys-title">用户管理</div>
            <Form :model="formItem" :label-width="80" inline>
                <FormItem label="员工号">
                    <Input v-model="formItem.id" placeholder=""></Input>
                </FormItem>
                <FormItem label="员工姓名">
                    <Input v-model="formItem.name" placeholder=""></Input>
                </FormItem>
                <FormItem>
                    <Select v-model="formItem.role" placeholder="请选择角色">
                        <Option value="beijing">New York</Option>
                        <Option value="shanghai">London</Option>
                        <Option value="shenzhen">Sydney</Option>
                    </Select>
                </FormItem>
                <FormItem>
                    <Select v-model="formItem.activate" placeholder="全部">
                        <Option value="beijing">New York</Option>
                        <Option value="shanghai">London</Option>
                        <Option value="shenzhen">Sydney</Option>
                    </Select>
                </FormItem>
                <FormItem>
                    <Button type="primary">查询</Button>
                    <Button type="ghost ml-10">重置</Button>
                    <Button type="ghost ml-10">添加</Button>
                </FormItem>
            </Form>
            <Table :columns="columns1" :data="source" height="340"></Table>
            <div class="page-break">
                <Page :total="Math.floor(size)" :current="Math.floor(index)" :page-size="Math.floor(rows)" @on-change="change"></Page>
            </div>
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
                formItem: {
                    id:'',
                    name:'',
                    role:'',
                    activate:'',
    
                },
                columns1: [
                    {
                        title: '工号',
                        key: 'id'
                    },
                    {
                        title: '用户名',
                        key: 'username'
                    },
                    {
                        title: '登录名',
                        key: 'loginCode'
                    },
                    {
                        title: '部门',
                        key: 'section1'
                    },
                    {
                        title: '角色',
                        key: 'section2'
                    },
                    {
                        title: '电话',
                        key: 'phone'
                    },
                    {
                        title: '状态',
                        key: 'section3'
                    },
                    {
                        title: '操作',
                        key: 'section4'
                    }
                ],
                source: [],
            }
        },
        mounted() {
    
        },
        created() {
            this.getMuduleAList(); 
        },
        methods: {
            getMuduleAList(index, rows) { //获取用户列表
                var data = new FormData();
                // data.append()
                this.$http.post('/user/queryAllUsers', data)
                .then(res=>{
                    var data = response.data(res, this);
                    if(data){
                        this.size = data.total;
                        this.source = data;
                    }
                })
                .catch(res => {
                    // this.$Message.error('获取用户列表失败')
                })
            },
            change(params) {
                this.index = params;
                // this.getMuduleAList(params);
            }
        }
    }
    </script>
        