<template>
    <div class="login-container">
        <div class="login-cont">
            <span class="bg"></span>
            <h2>柯莱特项目管理系统</h2>
            <Form ref="formInline" :model="formInline" :rules="ruleInline">
                <FormItem prop="user">
                    <Input type="text" v-model="formInline.user" placeholder="Username">
                        <Icon type="ios-person-outline" slot="prepend"></Icon>
                    </Input>
                </FormItem>
                <FormItem prop="password">
                    <Input type="password" v-model="formInline.password" placeholder="Password">
                        <Icon type="ios-locked-outline" slot="prepend"></Icon>
                    </Input>
                </FormItem>
                <FormItem>
                    <Button type="primary" long @click="handleSubmit('formInline')">立即登录</Button>
                </FormItem>
            </Form>
        </div>
    </div>
</template>

<script>
import * as response from '../util/response.js'
  export default {
        data () {
            return {
                formInline: {
                    user: '',
                    password: ''
                },
                ruleInline: {
                    user: [
                        { required: true, message: '请输入登录名', trigger: 'blur' }
                    ],
                    password: [
                        { required: true, message: '请输入登录密码', trigger: 'blur' },
                        // { type: 'string', min: 2, message: '登录密码格式不正确', trigger: 'blur' }
                    ]
                }
            }
        },
        methods: {
            handleSubmit(name) {
                var data = new FormData();
                data.append('logincode',this.formInline.user);
                data.append('password',this.formInline.password);
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        this.$http.post('/login', data)
                        .then(res => {
                        
                            if (res.data.status.code ==200) {
                                this.$router.push({ 'path': '/' });
                                localStorage.isLogin =true;
                            }else{
                            
                                this.$Message.error(res.data.status.message);
                            }
                        })
                        .catch(res => {
                            // this.$Message.error('')
                        })
                    } else {
                        // this.$Message.error('Fail!');
                    }
                })
            }
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="less">
  .login-container{
      width:100%;
      height:100%;
      background:url(../assets/login-bg.jpg) no-repeat center center;
      /* background:#eee; */
      position:fixed;
      display:flex;
      align-items: center;
      .login-cont{
        padding:20px;
        width:350px;
        margin:0 auto;
        border-radius:10px;
        position:relative;
        h2{ 
            font-size:20px;
            text-align: center;
            margin-bottom:30px;
            color:#fff;
            font-weight:bold;
        }
        .ivu-form-item{ margin-bottom:25px;}
        .bg{
            display:block;
            width:100%;
            height:100%;
            background:#fff;
            opacity:0.1;
            border-radius:10px;
            position:absolute;
            top:0;
            left:0;
        }
          
      }
  }
</style>
