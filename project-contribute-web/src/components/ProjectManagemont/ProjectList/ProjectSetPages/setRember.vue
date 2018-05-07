<template>
    <div class="set-rember">
        <Form :model="formItem" :label-width="100">
            <FormItem label="是否开启项目提醒功能" class="label-switch">
                <i-switch v-model="formItem.switch" size="large">
                    <span slot="open">是</span>
                    <span slot="close">否</span>
                </i-switch>
            </FormItem>
            <FormItem label="角色选择">
                <Select v-model="formItem.select">
                    <Option value="1">项目经理</Option>
                    <Option value="2">功能模块组长</Option>
                    <Option value="3">成员</Option>
                </Select>
            </FormItem>
            <FormItem label="提醒方式">
                <CheckboxGroup v-model="formItem.remind">
                    <Checkbox label="邮件"></Checkbox>
                    <Checkbox label="信息"></Checkbox>
                </CheckboxGroup>
            </FormItem>
            <FormItem label="频次">
                <CheckboxGroup v-model="formItem.frequency">
                    <Checkbox label="天/次"></Checkbox>
                    <Checkbox label="周/次"></Checkbox>
                    <Checkbox label="月/次"></Checkbox>
                </CheckboxGroup>
            </FormItem>
            <FormItem label="提醒内容">
                <div>
                    <CheckboxGroup v-model="formItem.checkbox1">
                        <Checkbox label="项目日报发送"></Checkbox>
                        <Checkbox label="项目延期提醒"></Checkbox>
                        <Checkbox label="项目延时提醒"></Checkbox>
                        <Checkbox label="里程任务完成提醒"></Checkbox>
                        <Checkbox label="里程任务延期提醒"></Checkbox>
                        <Checkbox label="里程任务延时提醒"></Checkbox>
                        <Checkbox label="长时间未解决BUG提醒"></Checkbox>
                    </CheckboxGroup>
                </div>
                <div>
                    <CheckboxGroup v-model="formItem.checkbox2">
                        <Checkbox label="功能模块日报发送"></Checkbox>
                        <Checkbox label="模块延期提醒"></Checkbox>
                        <Checkbox label="模块延时提醒"></Checkbox>
                        <Checkbox label="任务延时提醒"></Checkbox>
                        <Checkbox label="任务延期提醒"></Checkbox>
                        <Checkbox label="长时间未解决BUG提醒"></Checkbox>
                    </CheckboxGroup>
                </div>
                <div>
                    <CheckboxGroup v-model="formItem.checkbox3">
                        <Checkbox label="任务延时提醒"></Checkbox>
                        <Checkbox label="任务延期提醒"></Checkbox>
                        <Checkbox label="长时间未解决的BUG提醒"></Checkbox>
                    </CheckboxGroup>
                </div>
            </FormItem>
            <FormItem>
                <Button type="primary" @click="handleSubmit('formItem')">保存</Button>
                <Button type="ghost" class="ml-10">返回</Button>
            </FormItem>
        </Form>
        <!-- 项目日报配置 -->
        <Modal
            v-model="projectDeploy"
            title="项目日报配置"
            class-name="vertical-center-modal"
            :mask-closable="false"
            :width='400'>
            <Form :model="projectDeployForm" :label-width="100">
                <FormItem label="选择日报字段">
                    <CheckboxGroup v-model="projectDeployForm.checkbox">
                        <Checkbox label="项目进度"></Checkbox>
                        <Checkbox label="当日BUG总数"></Checkbox>
                        <Checkbox label="当日BUG解决数"></Checkbox>
                        <Checkbox label="任务完成数"></Checkbox>
                        <Checkbox label="长时间延时任务提示"></Checkbox>
                    </CheckboxGroup>
                </FormItem>
            </Form>
            <div slot="footer">
                <Button type="primary" @click="saveBtn">保存</Button>
            </div>
        </Modal>
        <!-- 项目延期配置 -->
        <Modal
            v-model="postponeDeploy"
            title="项目延期配置"
            class-name="vertical-center-modal"
            :mask-closable="false"
            :width="400">
            <Form :model="postponeDeployForm">
                <FormItem label="延期时间配置">
                    延期&nbsp;&nbsp;<Input :model="postponeDeployForm.data" class="min-input"></Input> &nbsp;&nbsp;天提示
                </FormItem>
            </Form>
            <div slot="footer">
                <Button type="primary" @click="saveDataBtn">保存</Button>
            </div>
        </Modal>
    </div>
</template>
<script>
export default {
    data () {
        return {
            formItem: {
                switch: true,
                select:'',
                remind: [],
                frequency:[], 
                checkbox1:[],
                checkbox2:[],
                checkbox3:[],
            },
            projectDeploy:false,//项目日报配置
            projectDeployForm:{
                checkbox:[],
            },
            postponeDeployForm:{
                data:'',
            },
            postponeDeploy:false,//项目延期配置
        }
    },
    methods: {
        // 点击保存
        handleSubmit (name) {
            
        },
        //项目配置保存按钮
        saveBtn(){

        },
        //项目延期保存按钮
        saveDataBtn(){

        },
        
    }
}
</script>
<style scoped lang="less">
</style>