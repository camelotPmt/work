<template>
    <div class="personal-main">
        <div class="title-public">个人信息</div>
        <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80">
            <Row>
                <Col span="12">
                    <FormItem label="员工号" prop="number">
                        <Input v-model="formValidate.number" placeholder="员工号"></Input>
                    </FormItem>
                    <FormItem label="员工姓名" prop="name">
                        <Input v-model="formValidate.name" placeholder="员工姓名"></Input>
                    </FormItem>
                    <FormItem label="部门" prop="department">
                        <Select v-model="formValidate.department" placeholder="所在部门">
                            <Option value="beijing">New York</Option>
                            <Option value="shanghai">London</Option>
                            <Option value="shenzhen">Sydney</Option>
                        </Select>
                    </FormItem>
                    <FormItem label="职业" prop="profession">
                        <Select v-model="formValidate.profession" placeholder="选择职业">
                            <Option value="beijing">New York</Option>
                            <Option value="shanghai">London</Option>
                            <Option value="shenzhen">Sydney</Option>
                        </Select>
                    </FormItem>
                    <FormItem label="登录名" prop="loginName">
                        <Input v-model="formValidate.loginName" placeholder="登录名"></Input>
                    </FormItem>
                    <FormItem label="登录密码" prop="loginPassword">
                        <Input v-model="formValidate.loginPassword" placeholder="登录密码"></Input>
                    </FormItem>
                    <FormItem label="电话" prop="phone">
                        <Input v-model="formValidate.phone" placeholder="电话"></Input>
                    </FormItem>
                    <FormItem label="邮箱" prop="email">
                        <Input v-model="formValidate.email" placeholder="邮箱"></Input>
                    </FormItem>
                    <FormItem>
                        <Button type="primary" @click="handleSubmit('formValidate')">保存</Button>
                    </FormItem>
                </Col>
            </Row>
        </Form>
    </div>
</template>
<script>
export default {
    data () {
        return {
            formValidate: {
                number:'',
                name: '',
                department:'',
                profession: '',
                loginName: '',
                loginPassword:'',
                phone:'',
                email: '',
            },
            ruleValidate: {
                number: [
                    { required: true, message: '请输入员工号', trigger: 'blur' }
                ],
                name: [
                    { required: true, message: '请输入员工姓名', trigger: 'blur' }
                ],
                department: [
                    { required: true, message: '请输部门名称', trigger: 'blur' }
                ],
                profession: [
                    { required: true, message: '请选择职业', trigger: 'change' }
                ],
                loginName: [
                    { required: true, message: '请输入登录名', trigger: 'change' }
                ],
                loginPassword: [
                    { required: true, message: '请输入登录密码', trigger: 'change' }
                ],
                phone: [
                    { required: true, message: '请输入手机号', trigger: 'blur' }
                ],
                email: [
                    { required: true, message: '请输入邮箱', trigger: 'blur' },
                    { type: 'email', message: '邮箱格式不正确', trigger: 'blur' }
                ],
                
            }
        }
    },
    methods: {
        // 点击保存
        handleSubmit (name) {
            this.$refs[name].validate((valid) => {
                if (valid) {
                    this.$Message.success('Success!');
                } else {
                    this.$Message.error('Fail!');
                }
            })
        },
        
    }
}
</script>
<style scoped>
    .title-public{
        font-size:30px;
        margin-bottom:20px;
    }
</style>