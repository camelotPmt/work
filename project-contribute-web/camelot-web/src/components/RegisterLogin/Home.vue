<template>
    <div class="home-container">
        <div class="change-item">
            <Form :model="ItemChange" inline>
                <FormItem>
                    <Select v-model="ItemChange.select" placeholder="请选择需要添加的模块">
                        <Option value="项目进度">项目进度</Option>
                        <Option value="我的代办任务">我的代办任务</Option>
                        <Option value="可认领任务">可认领任务</Option>
                    </Select>
                </FormItem>
                <FormItem>
                    <Button type="ghost">添加</Button>
                </FormItem>
            </Form>
        </div>
        <Row class="mb-20">
            <Col span="8">
                <div class="mlr-10">
                    <div class="title-table cl">
                        项目进度
                        <a class="fr">删除</a>
                        <a class="fr mr-10">移动</a>
                    </div>
                    <Table :columns="columns1" :data="data1"></Table>
                </div>
            </Col>
            <Col span="8">
                <div class="mlr-10">
                    <div class="title-table cl">
                        最新动态
                        <a class="fr">删除</a>
                        <a class="fr mr-10">移动</a>
                    </div>
                    <Table :columns="columns1" :data="data1" ></Table>
                </div>
            </Col>
            <Col span="8">
                <div class="mlr-10">
                    <div class="title-table cl">
                        可认领任务
                        <a class="fr">删除</a>
                        <a class="fr mr-10">移动</a>
                    </div>
                    <Table :columns="columns1" :data="data1"></Table>
                </div>
            </Col>
        </Row>
        <Row class="mb-20">
            
            <Col span="8">
                <div class="mlr-10">
                    <div class="title-table cl">
                        长时间未解决BUG
                        <a class="fr">删除</a>
                        <a class="fr mr-10">移动</a>
                    </div>
                    <Table :columns="columns1" :data="data1"></Table>
                </div>
            </Col>
            <Col span="8">
                <div class="mlr-10">
                    <div class="title-table cl">
                        我的代办
                        <a class="fr">删除</a>
                        <a class="fr mr-10">移动</a>
                    </div>
                    <Table :columns="columns1" :data="data1"></Table>
                </div>
            </Col>
            <Col span="8">
                <div class="mlr-10">
                    <div class="title-table cl">
                        未关闭BUG
                        <a class="fr">删除</a>
                        <a class="fr mr-10">移动</a>
                    </div>
                    <Table :columns="columns1" :data="data1"></Table>
                </div>
            </Col>
        </Row>
        <Row class="mb-20">
            <Col span="8">
                <div class="mlr-10">
                    <div class="title-table cl">
                        指派给我的BUG
                        <a class="fr">删除</a>
                        <a class="fr mr-10">移动</a>
                    </div>
                    <Table :columns="columns1" :data="data1"></Table>
                </div>
            </Col>
            <Col span="8">
                <div class="mlr-10">
                    <div class="title-table cl">
                        由我评审的需求
                        <a class="fr">删除</a>
                        <a class="fr mr-10">移动</a>
                    </div>
                    <Table :columns="columns1" :data="data1"></Table>
                </div>
            </Col>
        </Row>
    </div>
</template>
<script>
export default {
    data() {
        return {
            ItemChange: {
                select: '',
            },
            columns1: [
                {
                    title: 'Name',
                    key: 'name'
                },
                {
                    title: 'Age',
                    key: 'age'
                },
                {
                    title: 'Address',
                    key: 'address'
                }
            ],
            data1: [
                {
                    name: 'John Brown',
                    age: 18,
                    address: 'New York No. 1 Lake Park',
                    date: '2016-10-03'
                },
                {
                    name: 'Jim Green',
                    age: 24,
                    address: 'London No. 1 Lake Park',
                    date: '2016-10-01'
                },
                {
                    name: 'Joe Black',
                    age: 30,
                    address: 'Sydney No. 1 Lake Park',
                    date: '2016-10-02'
                },
                {
                    name: 'Jon Snow',
                    age: 26,
                    address: 'Ottawa No. 2 Lake Park',
                    date: '2016-10-04'
                }
            ]
        }
    },
    components: {
        
    },
    mounted() {

    },
    created(){

    },
    methods: {

    } 
}
</script>
<style scoped lang="less">
    .home-container{
       padding:30px;
       background:#fff;
    }
    .change-item{ 
        .ivu-form-item{ margin-bottom:20px;}
    }
    .title-table{
        font-size:14px;
        font-weight:bold;
        padding-left:15px;
        line-height: 40px;
        position:relative;
        a{ color:#999;}
    }
    .title-table:before{
        content: '';
        width:3px;
        height:14px;
        background:#0459ab;
        position:absolute;
        left:0;
        top:50%;
        margin-top:-7px;
    }
</style>