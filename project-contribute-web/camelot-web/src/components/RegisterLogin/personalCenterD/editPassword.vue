<template>
    <div class="personal-main">
        <div class="title-public">密码修改</div>
        <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80">
            <FormItem label="原始密码" prop="originalPassword">
                <Input v-model="formValidate.originalPassword" placeholder="请输入原始密码"></Input>
            </FormItem>
            <FormItem label="新密码" prop="newPassword">
                <Input v-model="formValidate.newPassword" placeholder="请输入新密码"></Input>
            </FormItem>
            <FormItem label="确认密码" prop="affirmPassword">
                <Input v-model="formValidate.affirmPassword" placeholder="请再次输入密码"></Input>
            </FormItem>
            <FormItem>
                <Button type="primary" @click="handleSubmit('formValidate')">保存</Button>
            </FormItem>
        </Form>
    </div>
</template>
<script>
export default {
    data () {
        return {
            formValidate: {
                originalPassword:'',
                newPassword:'',
                affirmPassword:''
            },
            ruleValidate: {
                originalPassword: [
                    { required: true, message: '请输入原始密码', trigger: 'change' }
                ],
                newPassword: [
                    { required: true, message: '请输入新密码', trigger: 'change' }
                ],
                affirmPassword: [
                    { required: true, message: '请再次输入密码', trigger: 'change' }
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