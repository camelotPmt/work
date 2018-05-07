<template>
        <div class="sys-right-wrap">
            <div class="sys-title">权限管理</div>
            <Form :model="formItem" :label-width="80" inline>
                <FormItem label="员工姓名">
                    <Input v-model="formItem.name" placeholder=""></Input>
                </FormItem>
                <FormItem>
                    <Button type="primary">查询</Button>
                    <Button type="ghost" class="ml-10">添加</Button>
                </FormItem>
            </Form>
            <zk-table  
            :columns="columns1" 
            :data="source" 
            :stripe="props.stripe" 
            :border="props.border" 
            :show-header="props.showHeader" 
            :show-summary="props.showSummary"
            :show-row-hover="props.showRowHover"
            :show-index="props.showIndex"
            :tree-type="props.treeType" 
            :is-fold="props.isFold" 
            :expand-type="props.expandType"
            :selection-type="props.selectionType"
            ></zk-table >
            <template slot="active" slot-scope="scope">
                <!--  ... ... (图中对应状态栏的绿点儿)-->
            </template>
            
            <template slot="empower" slot-scope="scope">
                <!-- ... ... (为授权的图标，可在这里添加点击事件)-->
                <Button type="ghost">添加</Button>
            </template>
        </div>
    </template>
    <script>
    import * as response from '../../../util/response'
    export default {
        data () {
            return {
                props: {
                    stripe: false,//是否显示间隔斑马纹
                    border: true,//是否显示纵向边框
                    showHeader: true,//是否显示表头
                    showSummary: false,//是否显示表尾合计行
                    showRowHover: true,//鼠标悬停时，是否高亮当前行
                    showIndex: false,//是否显示数据索引
                    treeType: true,//是否为树形表格
                    isFold: true,//树形表格中父级是否默认折叠
                    expandType: false,//是否为展开行类型表格（为 True 时，需要添加作用域插槽, 它可以获取到 row, rowIndex)
                    selectionType: false,//是否多选
                },
                index:'1',
                rows:'10',
                size:'',
                formItem: {
                    name:'',
                },
                
                //表格标题数据
                columns1: [
                    {
                        label: "编号",
                        prop: "number"
                    },
                    {
                        label: "名称",
                        prop: "name",
                        minWidth: "50px"
                    },
                    {
                        label: "菜单链接",
                        prop: "connect",
                    },
                    {
                        label: "是否显示",
                        prop: "change",
                    },
                    {
                        label: "类型",
                        prop: "type",
                    },
                    {
                        label: "创建人",
                        prop: "people",
                    },
                    {
                        label: "创建时间",
                        prop: "date",
                    },
                    {
                        label: "操作",
                        prop: "section",

                    },
                    
                ],
                source: [
                {
                    number:'1',
                    name: '根组织',
                    connect:'/Home',
                    change:'是',
                    type:'菜单',
                    people:'张三',
                    date:'2018-04-04',
                    active: true,
                    children: [
                    {
                        number:'1-1',
                        name: '根组织',
                        connect:'/Home',
                        change:'是',
                        type:'菜单',
                        people:'张三',
                        date:'2018-04-04',
                        active: true,
                        children: [
                        {
                            number:'1-1-1',
                            name: '根组织',
                            connect:'/Home',
                            change:'是',
                            type:'菜单',
                            people:'张三',
                            date:'2018-04-04',
                            active: true,
                            children: [
                            // {
                            //     name: '杭州市',
                            //     description: '',
                            //     owner: '',
                            //     active: true
                            // }
                            ]
                        }
                        ]
                    }
                    ],
                },
                {
                    number:'2',
                    name: '根组织',
                    connect:'/Home',
                    change:'是',
                    type:'菜单',
                    people:'张三',
                    date:'2018-04-04',
                },
                ],
            }
        },
        mounted() {
    
        },
        created() {
            // this.getMuduleAList(); 
        },
        methods: {
            // getMuduleAList(index, rows) { //获取用户列表
            //     var data = new FormData();
            //     // data.append()
            //     this.$http.post('/user/queryAllUsers', data)
            //     .then(res=>{
            //         var data = response.data(res, this);
            //         if(data){
            //             this.size = data.total;
            //             this.source = data;
            //         }
            //     })
            //     .catch(res => {
            //         // this.$Message.error('获取用户列表失败')
            //     })
            // },
            // change(params) {
            //     this.index = params;
            //     // this.getMuduleAList(params);
            // }
        }
    }
    </script>
        