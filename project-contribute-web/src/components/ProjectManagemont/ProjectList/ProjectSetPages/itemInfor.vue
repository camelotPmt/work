<template>
    <div class="item-infor-cont">
        <Form :model="formValidate" :label-width="100">
            <FormItem label="项目名称">
                <Row>
                    <Col span="12">
                        <Input v-model="formValidate.name" placeholder="请输入项目名称"></Input>
                    </Col>
                </Row>
            </FormItem>
            <FormItem label="项目简介">
                <Input v-model="formValidate.brief" type="textarea" :autosize="{minRows: 4,maxRows: 5}" placeholder="请输入项目简介"></Input>
            </FormItem>
            <FormItem label="项目起止时间">
                <Row>
                    <Col span="12">
                        <DatePicker type="daterange" confirm placement="bottom-end" placeholder="请选择开始和结束时间" style="width: 200px"></DatePicker>
                    </Col>
                </Row>
            </FormItem>
            <FormItem label="预计工时">
                <Input v-model="formValidate.hour" placeholder="" class="min-input"></Input>&nbsp;&nbsp;小时
            </FormItem>
            <FormItem label="项目公开性">
                <Select v-model="formValidate.openness" placeholder="Select your city">
                    <Option value="1">私有项目（仅项目参与者可见）</Option>
                    <Option value="2">公开项目（所有人可见）</Option>
                </Select>
                <div class="tips-text">
                    <p>公开项目，所有登录平台的人员局可以查看到该项目，但是不具备对项目的操作权限</p>
                    <p>私有项目，仅项目成员可以查看到该项目，只有指定权限的人才可以操作该项目</p>
                </div>
            </FormItem>
            <FormItem label="项目负责人">
                <Button type="text" disabled>张三</Button>
                <Button type="ghost" class="ml-10" @click="showhandOver">移交</Button>
            </FormItem>
            <FormItem>
                <Button type="primary">保存</Button>
                <Button type="ghost" class="ml-10">返回</Button>
            </FormItem>
        </Form>
        <!-- 移交 -->
        <Modal
            v-model="handOver"
            title="移交负责人"
            class-name="vertical-center-modal"
            >
            <Form :model="handOverForm" :label-width="100">
                <FormItem label="项目负责人">
                    <Select v-model="handOverForm.principal" placeholder="Select your city">
                        <Option value="1">张三</Option>
                        <Option value="2">李四</Option>
                    </Select>
                </FormItem>
            </Form>
            <div slot="footer">
                <Button type="primary" @click="handOverBtn">移交项目</Button>
            </div>
        </Modal>
    </div>
</template>
<script>
export default {
    data () {
        return {
            formValidate: {
                name: '',
                brief: '',
                hour: '',
                openness:'',
            },
            handOverForm:{
                principal:'',
            },
            handOver:false,
        }
    },
    methods: {
        //移交
        showhandOver(){
            this.handOver = true;
        },
        //确认移交
        handOverBtn(){
            this.handOver = false;
        }
    }
}
</script>