<template>
        <div class="sys-right-wrap">
            <div class="sys-title">角色管理</div>
            <Form :model="formItem" :label-width="80" inline>
                <FormItem label="员工姓名">
                    <Input v-model="formItem.name" placeholder=""></Input>
                </FormItem>
                <FormItem>
                    <Select v-model="formItem.type" placeholder="请选择类型">
                        <Option value="beijing">New York</Option>
                        <Option value="shanghai">London</Option>
                        <Option value="shenzhen">Sydney</Option>
                    </Select>
                </FormItem>
                <FormItem>
                    <Button type="primary">查询</Button>
                    <Button type="ghost" class="ml-10">重置</Button>
                    <Button type="ghost" class="ml-10">添加</Button>
                </FormItem>
            </Form>
            <Table :columns="columns1" :data="source"></Table>
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
                    name:'',
                    type:'',
    
                },
                columns1: [
                    {
                        title: '工号',
                        key: 'userId'
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
                source: []
            }
        },
        created() {
            this.getPageList(); 
        },
        methods: {
            getPageList(index, rows) { //获取用户列表
                var data = {
                    roleId:123,
                }
                // console.log(data)
                this.$http.get('/platform/roleToUser/queryUserByRole', { params: data })
                .then(res => {
                    var data = response.data(res, this);
                    if (data) {
                    // this.size = data.total;
                    this.source = data;
                    // console.log(data)
                    
                    }
                })
                .catch(res => {
                    // this.$Message.error('获取用户列表失败！')
                })
            },
            change(params) {
                this.index = params;
                // this.getPageList(params);
            }
        }
    }
    </script>
        