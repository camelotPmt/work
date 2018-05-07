<template>
    <div class="personal-main">
        <div class="title-public">任务提醒</div>
        <Form :model="formItem" :label-width="100">
            <FormItem label="是否开启任务提醒功能" class="label-switch">
                <i-switch v-model="formItem.switch" size="large">
                    <span slot="open">是</span>
                    <span slot="close">否</span>
                </i-switch>
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
                    <div>
                        <Checkbox v-model="formItem.delayed">任务延时提醒</Checkbox>
                        <div class="delayed-inp mt-5">
                            <span class="mr-20">提前<input type="text" class="text-input"/>天</span>
                            <span>延后<input type="text" class="text-input"/>天</span>
                        </div>
                    </div>
                    <div class="mt-10">
                        <Checkbox v-model="formItem.postpone">任务延期提醒</Checkbox>
                        <div class="postpone-inp mt-5">
                            <span class="mr-20">提前<input type="text" class="text-input"/>天</span>
                            <span>延后<input type="text" class="text-input"/>天</span>
                        </div>
                    </div>
                </div>
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
            formItem: {
                switch: true,
                remind: [],
                frequency:[],
                delayed:false,
                postpone:false,
                
                
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
    .text-input{ 
        width:60px;
        height:32px;
        line-height: 32px;
        border-radius:4px;
        outline: none;
        border: 1px solid #dddee1;
        padding:4px 7px;
        margin:0 5px;
    }
</style>