<template>
    <div class="task-container">
        <Form :model="formItem" :label-width="80" inline>
            <FormItem label="类型">
                <Select v-model="formItem.select" placeholder="选择类型">
                    <Option value="beijing">New York</Option>
                    <Option value="shanghai">London</Option>
                    <Option value="shenzhen">Sydney</Option>
                </Select>
            </FormItem>
            <FormItem label="日期">
                <DatePicker type="date" placeholder="Select date" v-model="formItem.date"></DatePicker>
            </FormItem>
            <FormItem label="任务名称">
                <Input v-model="formItem.input" placeholder="Enter something..."></Input>
            </FormItem>
            <FormItem label="负责人">
                <Input v-model="formItem.input" placeholder="Enter something..."></Input>
            </FormItem>
            <FormItem>
                <Button type="ghost">重置</Button>
                <Button type="primary" class="ml-10">添加任务</Button>
            </FormItem>
        </Form>  
        <div class="task-cont">
            <Row :gutter="16">
                <Col span="6">
                    <div class="task-list">
                        <div class="task-title">待处理<i>5</i></div>
                        <ul class="task-ul">
                            <li>
                                <router-link to="">
                                    <div>
                                        <span class="post-txt">
                                            <i class="post-tit">需求</i>
                                            对PMT功能模块进行一次促调研,确定需要做什么功能模块对PMT功能模块进行一次促调研,确定需要做什么功能模块
                                        </span>
                                    </div>
                                    <div>
                                        <span><i class="ivu-icon ivu-icon-calendar"></i>2018.04.05-2018.04.05</span>
                                    </div>
                                    <div>
                                        <span><i class="ivu-icon ivu-icon-waterdrop"></i>8小时</span>
                                    </div>
                                    <div>
                                        <Tag color="#ff0000">P1</Tag>
                                        <Tag color="#ff9933">P2</Tag>
                                        <Tag color="#33cc00">P3</Tag>
                                        <Tag color="#bfbfbf">P4</Tag>
                                        <Tag color="#33ccff">蔡长庆</Tag>
                                        <Tag color="#ff6633">需求变更</Tag>
                                        <Tag color="#ff6633">认领</Tag>
                                        <Tag color="#868686">评估</Tag>
                                        <Tag color="#868686">删除</Tag>
                                        <Tag color="#868686">开始</Tag>
                                        <Tag color="#868686">关闭</Tag>
                                        <Tag color="#868686">已关闭</Tag>
                                        <Tag color="#ff0000">超时</Tag>
                                        <Tag color="#33cc00">正常</Tag>
                                    </div>
                                </router-link>
                            </li>
                        </ul>
                        <div class="add-btn"><a @click="taskModelShow"><i class="ivu-icon ivu-icon-plus-circled"></i>添加任务</a></div>
                    </div>
                </Col>
                <Col span="6">
                    <div class="task-list">
                        <div class="task-title">进行中<i>3</i></div>
                    </div>
                </Col>
                <Col span="6">
                    <div class="task-list">
                        <div class="task-title">已完成<i>1</i></div>
                    </div>
                </Col>
                <Col span="6">
                    <div class="task-list">
                        <div class="task-title">关闭<i>2</i></div>
                    </div>
                </Col>
            </Row>
        </div> 
        <Modal
            v-model="taskModel"
            title="新建任务"
            class-name="vertical-center-modal"
            :width="400"
            >
            <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80">
                <FormItem label="任务名称" prop="name">
                    <Input v-model="formValidate.name" placeholder="请输入项目名称"></Input>
                </FormItem>
                <FormItem label="任务描述" prop="mail">
                    <Input v-model="formValidate.mail" placeholder="请输入项目描述"></Input>
                </FormItem>
                <FormItem label="添加人">
                    <Select v-model="formValidate.city" placeholder="Select your city">
                        <Option value="beijing">New York</Option>
                        <Option value="shanghai">London</Option>
                        <Option value="shenzhen">Sydney</Option>
                    </Select>
                </FormItem>
            </Form>
            <div slot="footer">
                <Button type="ghost" @click="cancelBtn">取消</Button>
                <Button type="primary" @click="affrimBtn('formValidate')">确认</Button>
            </div>
        </Modal>     
    </div>
</template>
<script>
    export default {
        data () {
            return {
                formItem: {
                    input: '',
                    select: '',
                    date: '',
                   
                },
                single: false,
                taskModel:false,
                formValidate: {
                    name: '',
                    mail: '',
                    city: '',
                },
                ruleValidate: {
                    name: [
                        { required: true, message: 'The name cannot be empty', trigger: 'blur' }
                    ],
                    mail: [
                        { required: true, message: 'Mailbox cannot be empty', trigger: 'blur' },
                        { type: 'email', message: 'Incorrect email format', trigger: 'blur' }
                    ]
                }
            }
        },
        methods:{
            taskModelShow(){
                this.taskModel = true;
            },
            affrimBtn(name){
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        this.taskModel = false;
                    } else {
                        this.$Message.error('Fail!');
                    }
                })
            },
            cancelBtn(){
                this.taskModel = false;
            }
        }
    }
</script>
<style scoped lang="less">
    .task-list{ 
        border-radius:10px;
        padding:10px;
        border:1px solid #eee;
        background:#f5f5f5;
        padding-bottom:50px;
        position:relative;
        .add-btn{
            position:absolute;
            bottom:10px;
            font-size:16px;
            a{ color:#0459ab;}
            i{ 
                display:block; 
                float:left; 
                font-size:24px; 
                margin:0px 5px 0 0;
            }
        }
        .task-title{
            font-size:14px;
            font-weight:bold;
            margin-bottom:10px;
            i{margin-left:10px;}
        }
        .task-ul{
            li{
                width:100%;
                min-height:200px;
                background:#fff;
                border-radius:10px;
                padding:10px;
                margin-bottom:10px;
                .post-tit{
                    color:#0459ab;
                    font-weight:bold;
                }
                .post-txt{
                    height:50px;
                    line-height:25px;
                    overflow:hidden;
                    display:-webkit-box;
                    -webkit-box-orient:vertical;
                    -webkit-line-clamp:2;
                }
                div{ margin-bottom:10px;}
                .ivu-icon{ margin-right:5px;}
            }
        }
    }
</style>