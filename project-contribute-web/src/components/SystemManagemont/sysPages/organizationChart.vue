<template>
    <div class="sys-right-wrap">
        <div class="sys-title">组织架构管理</div>
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
                <Button type="ghost" class="ml-10">重置</Button>
                <Button type="ghost" class="ml-10" @click="addBtn">添加</Button>
            </FormItem>
        </Form>
        <Table :columns="columns1" :data="source" height="340"></Table>
        <div class="page-break">
            <Page :total="Math.floor(size)" :current="Math.floor(index)" :page-size="Math.floor(rows)" @on-change="change"></Page>
        </div>
        <!-- 添加用户 -->
        <Modal
            v-model="addUser"
            title="用户添加"
            class-name="vertical-center-modal"
            :width="450"
            class="h-480"
            >
            <Form ref="addForm" :model="addForm" :rules="ruleValidate" :label-width="80">
                <FormItem label="员工号" prop="number">
                    <Input v-model="addForm.number"></Input>
                </FormItem>
                <FormItem label="用户名" prop="userName">
                    <Input v-model="addForm.userName"></Input>
                </FormItem>
                <FormItem label="员工邮箱" prop="mail">
                    <Input v-model="addForm.mail"></Input>
                </FormItem>
                <FormItem label="部门" prop="section">
                    <Select v-model="addForm.section">
                        <Option value="1">New York</Option>
                        <Option value="2">London</Option>
                        <Option value="3">Sydney</Option>
                    </Select>
                </FormItem>
                <FormItem label="角色" prop="role">
                    <Select v-model="addForm.role">
                        <Option value="1">New York</Option>
                        <Option value="2">London</Option>
                        <Option value="3">Sydney</Option>
                    </Select>
                </FormItem>
                <FormItem label="登录名" prop="loginName">
                    <Input v-model="addForm.loginName"></Input>
                </FormItem>
                <FormItem label="登录密码" prop="password">
                    <Input v-model="addForm.password"></Input>
                </FormItem>
                <FormItem label="电话" prop="phone">
                    <Input v-model="addForm.phone"></Input>
                </FormItem>
            </Form>
            <div slot="footer">
                <Button type="ghost" @click="cancelBtn('addForm')">取消</Button>
                <Button type="primary" @click="affrimBtn('addForm')">确认</Button>
            </div>
        </Modal>
    </div>
</template>
<script>
import * as response from '../../../util/response'
export default {
    data () {
        //手机号码验证
        const validatePhone = (rule, value, callback) => {
            var reg=11 && /^((13|14|15|17|18)[0-9]{1}\d{8})$/;
            if (value === '') {
                callback(new Error('请输入手机号码'));
            } else if (!reg.test(value)) {
                callback(new Error('手机号码不正确'));
            } else {
                callback();
            }
        };
        return {
            index:'1',
            rows:'10',
            size:'',
            addUser:false,
            formItem: {
                id:'',
                name:'',
                role:'',
                activate:'',

            },
            addForm: {
                number:'',
                userName: '',
                mail: '',
                section: '',
                role: '',
                loginName:'',
                password:'',
                phone:'',
            },
            ruleValidate: {
                number: [
                    { required: true, message: '请输入员工号', trigger: 'blur' }
                ],
                userName: [
                    { required: true, message: '请输入用户名', trigger: 'blur' }
                ],
                mail: [
                    { required: true, message: '请输入邮箱', trigger: 'blur' },
                    { type: 'email', message: '邮箱格式不正确', trigger: 'blur' }
                ],
                section: [
                    { required: true, message: '请选择所在部门', trigger: 'change' }
                ],
                role: [
                    { required: true, message: '请选择角色', trigger: 'change' }
                ],
                loginName: [
                    { required: true, message: '请输入登录名', trigger: 'blur' }
                ],
                password: [
                    { required: true, message: '请输入密码', trigger: 'blur' },
                    { type: 'string', min: 6, message: '密码长度不超过6位', trigger: 'blur' }
                ],
                phone: [
                    { validator: validatePhone, required: true, trigger: 'blur' }
                ],
                
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
        // 添加
        addBtn(){
            this.addUser=true;
        },
        change(params) {
            this.index = params;
            // this.getMuduleAList(params);
        },
        // 确认按钮
        affrimBtn(name){
            this.$refs[name].validate((valid) => {
                if (valid) {
                    this.$Message.success('Success!');
                    this.addUser=false;
                } else {
                    this.$Message.error('Fail!');
                }
            })
            
        },
        // 取消按钮
        cancelBtn(name){
            this.$refs[name].resetFields();
            this.addUser=false;
        },
    }
}
</script>
        