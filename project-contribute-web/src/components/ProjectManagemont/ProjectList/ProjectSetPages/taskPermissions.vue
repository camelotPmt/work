<template>
    <div class="task-permissions">
        <Form :model="formItem">
            <FormItem label="可分别定义配置任务的创建者/执行者权限">
                <i-switch v-model="formItem.switch" size="large">
                    <span slot="open">是</span>
                    <span slot="close">否</span>
                </i-switch>
            </FormItem>
        </Form> 
        <ul class="task-per-ul">
            <Row>
                <Col span="8">
                    <li>任务权限</li>
                </Col>
                <Col span="8">
                    <li>创建者</li>
                </Col>
                <Col span="8">
                    <li>操作者</li>
                </Col>
            </Row>
            <Row>
                <Col span="8">
                    <li>删除任务</li>
                </Col>
                <Col span="8">
                    <li>
                        <Checkbox :model="checkbox1" large></Checkbox>
                    </li>
                </Col>
                <Col span="8">
                    <li>
                        <Checkbox :model="checkbox2" large></Checkbox>
                    </li>
                </Col>
            </Row>
            <Row>
                <Col span="8">
                    <li>编辑</li>
                </Col>
                <Col span="8">
                    <li>
                        <Checkbox :model="checkbox3" large></Checkbox>
                    </li>
                </Col>
                <Col span="8">
                    <li>
                        <Checkbox :model="checkbox4" large></Checkbox>
                    </li>
                </Col>
            </Row>
            <Row>
                <Col span="8">
                    <li>完成/重做</li>
                </Col>
                <Col span="8">
                    <li>
                        <Checkbox :model="checkbox5" large></Checkbox>
                    </li>
                </Col>
                <Col span="8">
                    <li>
                        <Checkbox :model="checkbox6" large></Checkbox>
                    </li>
                </Col>
            </Row>
            <Row>
                <Col span="8">
                    <li>指派</li>
                </Col>
                <Col span="8">
                    <li>
                        <Checkbox :model="checkbox7" large></Checkbox>
                    </li>
                </Col>
                <Col span="8">
                    <li>
                        <Checkbox :model="checkbox8" large></Checkbox>
                    </li>
                </Col>
            </Row>
            <Row>
                <Col span="8">
                    <li>关闭</li>
                </Col>
                <Col span="8">
                    <li>
                        <Checkbox :model="checkbox9" large></Checkbox>
                    </li>
                </Col>
                <Col span="8">
                    <li>
                        <Checkbox :model="checkbox10" large></Checkbox>
                    </li>
                </Col>
            </Row>
        </ul> 
        <div class="btn-bottom">
            <Button type="primary">保存</Button>
            <Button type="ghost" class="ml-10">返回</Button>
        </div>  
    </div>
</template>
<script>
export default {
    data () {
        return { 
            formItem:{
                switch:'',
            },
            checkbox1:false,
            checkbox2:false,
            checkbox3:false,
            checkbox4:false,
            checkbox5:false,
            checkbox6:false,
            checkbox7:false,
            checkbox8:false,
            checkbox9:false,
            checkbox10:false,
        }
    },
    methods: {
    }
}
</script>
<style scoped lang="less">
    .task-permissions{
        min-height:400px;
    }
    .task-per-ul{
        li{
            height:45px;
            line-height:45px;
        }
    }
    .btn-bottom{
        text-align: center;
        margin-top:30px;
    }
</style>