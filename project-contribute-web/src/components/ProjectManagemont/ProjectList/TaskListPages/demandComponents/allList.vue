<template>
    <div class="demand-tree po-re">
        <Button type="primary" class="add-btn" @click.stop="addModelShow1">添加需求</Button>
        <Collapse accordion :model="oneStair">
            <Panel name="1" class="mb-10">
                <span class="num">01</span>
                <span class="name">登录功能实现</span>
                <span class="class"><Tag color="#ff0000">P1</Tag></span>
                <div class="brief-text">
                    <p>登录功能主要让使用该平台的人员能够登录到该平台中，需要对登录的人员做登录前的验证，判断用户是否在系统中存在，密码是否输入正确，如果正确，允许用户进入系统，如果错误，提示用户名或密码有误，请重新输入.</p>
                </div>
                <dl class="bottom-operations cl">
                    <dd class="fl"><i class="iconfont icon-time"></i>2018.04.05</dd>
                    <dd class="fl"><Tag color="#33ccff">蔡长庆</Tag></dd>
                    <dd class="fr amount-dd"><a><i class="iconfont icon-caidan" title="子需求数量"></i><small>1</small></a></dd>
                    <dd class="fr"><a @click.stop="showChangeModel"><i class="iconfont icon-alter" title="变更需求"></i></a></dd>
                    <dd class="fr"><a @click.stop="showReviewModel"><i class="iconfont icon-hetongpingshen" title="需求评审"></i></a></dd>
                    <dd class="fr"><a><i class="iconfont icon-icon7" title="删除需求"></i></a></dd>
                    <dd class="fr"><a><i class="iconfont icon-jiedianlianjie" title="细分子任务"></i></a></dd>
                    <dd class="fr"><a><i class="iconfont icon-guanbi" title="关闭需求"></i></a></dd>
                    <dd class="fr"><a @click.stop="addModelShowDetail"><i class="iconfont icon-xiangqing" title="需求详情"></i></a></dd>
                </dl>
                <div slot="content">
                    <Collapse accordion :model="twoStair">
                        <Panel name="1-1">
                            <span>01.01</span>
                            <span>用户名判断是否存在</span>
                            <span><Tag color="#ff0000">P1</Tag></span>
                            <div class="brief-text">
                                <p>登录功能主要让使用该平台的人员能够登录到该平台中，需要对登录的人员做登录前的验证，判断用户是否在系统中存在，密码是否输入正确，如果正确，允许用户进入系统，如果错误，提示用户名或密码有误，请重新输入.</p>
                            </div>
                            <dl class="bottom-operations cl">
                                <dd class="fl"><i class="iconfont icon-time"></i>2018.04.05</dd>
                                <dd class="fl"><Tag color="#33ccff">蔡长庆</Tag></dd>
                                <dd class="fr amount-dd"><i class="iconfont icon-caidan" title="子需求数量"></i><small>1</small></dd>
                                <dd class="fr"><i class="iconfont icon-hetongpingshen" title="需求评审"></i></dd>
                                <dd class="fr"><i class="iconfont icon-icon7" title="删除需求"></i></dd>
                                <dd class="fr"><i class="iconfont icon-jiedianlianjie" title="细分子任务"></i></dd>
                                <dd class="fr"><i class="iconfont icon-guanbi" title="关闭需求"></i></dd>
                            </dl>
                            <div slot="content" class="three-stair">
                                <span>01.01.01</span>
                                <span>用户名判断是否存在</span>
                                <span><Tag color="#ff0000">P1</Tag></span>
                                <div class="brief-text">
                                    <p>登录功能主要让使用该平台的人员能够登录到该平台中，需要对登录的人员做登录前的验证，判断用户是否在系统中存在，密码是否输入正确，如果正确，允许用户进入系统，如果错误，提示用户名或密码有误，请重新输入.</p>
                                </div>
                                <dl class="bottom-operations cl">
                                    <dd class="fl"><i class="iconfont icon-time"></i>2018.04.05</dd>
                                    <dd class="fl"><Tag color="#33ccff">蔡长庆</Tag></dd>
                                    <dd class="fr"><i class="iconfont icon-hetongpingshen" title="需求评审"></i></dd>
                                    <dd class="fr"><i class="iconfont icon-icon7" title="删除需求"></i></dd>
                                    <dd class="fr"><i class="iconfont icon-jiedianlianjie" title="细分子任务"></i></dd>
                                    <dd class="fr"><i class="iconfont icon-guanbi" title="关闭需求"></i></dd>
                                </dl>
                            </div>
                        </Panel>
                    </Collapse>
                </div>
            </Panel>
        </Collapse>
        <!-- 需求变更弹出框 -->
        <Modal
            v-model="changeModel"
            title="需求变更"
            class-name="vertical-center-modal"
            :width="800"
            class="h-480"
            >
            <Form :model="chageForm" :label-width="80">
                <Row>
                    <Col span="12">
                        <FormItem label="需求名称">
                            <Input v-model="chageForm.name"></Input>
                        </FormItem>
                        <FormItem label="需求描述">
                            <Input v-model="chageForm.des" type="textarea"></Input>
                        </FormItem>
                        <FormItem label="优先级">
                            <Select v-model="chageForm.select1">
                                <Option value="beijing">New York</Option>
                                <Option value="shanghai">London</Option>
                                <Option value="shenzhen">Sydney</Option>
                            </Select>
                        </FormItem>
                        <FormItem label="需求来源">
                            <Select v-model="chageForm.select2">
                                <Option value="beijing">New York</Option>
                                <Option value="shanghai">London</Option>
                                <Option value="shenzhen">Sydney</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
            </Form>
            <p class="title">检查影响</p>
            <Tabs type="card" :animated="false" class="mb-20">
                <TabPane label="任务">
                    <Table :columns="Rw" :data="Rwdata"></Table>
                </TabPane>
                <TabPane label="用例">
                    <Table :columns="Yl" :data="Yldata"></Table>
                </TabPane>
                <TabPane label="BUG">
                    <Table :columns="Bg" :data="Bgdata"></Table>
                </TabPane>
            </Tabs>
            <p class="title">历史记录</p>
            <div>
                <p class="cl mb-10">
                    <span class="fl mr-10">某某创建了需求</span>
                    <span class="fl">PMT测试项目</span>
                    <span class="fr">2018-04-04</span>
                </p>
                <p class="cl mb-10">
                    <span class="fl mr-10">某某创建了需求</span>
                    <span class="fl">PMT测试项目</span>
                    <span class="fr">2018-04-04</span>
                </p>
            </div>
            <p class="title">需求一生</p>
            <div>
                <p class="cl mb-10">
                    <span class="fl mr-10">某某创建了需求</span>
                    <span class="fr">2018-04-04</span>
                </p>
                <p class="cl mb-10">
                    <span class="fl mr-10">某某创建了需求</span>
                    <span class="fr">2018-04-04</span>
                </p>
            </div>
            <div slot="footer">
                <Button type="ghost" @click="cancelBtn">取消</Button>
                <Button type="primary" @click="affirmBtn">确认</Button>
            </div>
        </Modal>
        <!-- 需求评审弹出框 -->
        <Modal
            v-model="reviewModel"
            title="需求评审"
            class-name="vertical-center-modal"
            :width="400"
            >
            <Form :model="reviewForm" :label-width="80">
                <Row>
                    <Col span="20">
                        <FormItem label="需求名称">
                            <Input v-model="reviewForm.name"></Input>
                        </FormItem>
                        <FormItem label="需求描述">
                            <Input v-model="reviewForm.des" type="textarea"></Input>
                        </FormItem>
                        <FormItem label="优先级">
                            <Select v-model="reviewForm.select1">
                                <Option value="beijing">New York</Option>
                                <Option value="shanghai">London</Option>
                                <Option value="shenzhen">Sydney</Option>
                            </Select>
                        </FormItem>
                        <FormItem label="需求来源">
                            <Select v-model="reviewForm.select2">
                                <Option value="beijing">New York</Option>
                                <Option value="shanghai">London</Option>
                                <Option value="shenzhen">Sydney</Option>
                            </Select>
                        </FormItem>
                        <FormItem label="评审结果">
                            <Select v-model="reviewForm.select3">
                                <Option value="beijing">New York</Option>
                                <Option value="shanghai">London</Option>
                                <Option value="shenzhen">Sydney</Option>
                            </Select>
                        </FormItem>
                        <FormItem label="评审人">
                            <Select v-model="reviewForm.select4">
                                <Option value="beijing">New York</Option>
                                <Option value="shanghai">London</Option>
                                <Option value="shenzhen">Sydney</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
            </Form>
            <div slot="footer">
                <Button type="ghost" @click="cancelSub">取消</Button>
                <Button type="primary" @click="affirmSub">提交</Button>
            </div>
        </Modal>
        <!-- 1需求新增 -->
        <Modal
            v-model="AddModel1"
            title="需求新增一级"
            class-name="vertical-center-modal"
            class="h-480"
            >
            <Form :model="addForm1" :label-width="80">
                <Row>
                    <Col span="20">
                        <FormItem label="需求名称">
                            <Input v-model="addForm1.name"></Input>
                        </FormItem>
                        <FormItem label="优先级">
                            <Select v-model="addForm1.select1">
                                <Option value="beijing">New York</Option>
                                <Option value="shanghai">London</Option>
                                <Option value="shenzhen">Sydney</Option>
                            </Select>
                        </FormItem>
                        <FormItem label="需求来源">
                            <Select v-model="addForm1.select2">
                                <Option value="beijing">New York</Option>
                                <Option value="shanghai">London</Option>
                                <Option value="shenzhen">Sydney</Option>
                            </Select>
                        </FormItem>
                        <FormItem label="评审人选择">
                            <Select v-model="addForm1.select3">
                                <Option value="beijing">New York</Option>
                                <Option value="shanghai">London</Option>
                                <Option value="shenzhen">Sydney</Option>
                            </Select>
                        </FormItem>
                        <FormItem label="需求描述">
                            <Input v-model="addForm1.des" type="textarea"></Input>
                        </FormItem>
                        <FormItem label="附件名称">
                            <Input v-model="addForm1.adjunct"></Input>
                        </FormItem>
                        <FormItem label="附件地址">
                            <Input v-model="addForm1.address"></Input>
                        </FormItem>
                    </Col>
                </Row>
            </Form>
            <p class="title">需求列表</p>
            <ul class="demand-list">
                <li title="点击可添加子需求">
                    <a @click="addModelShow2">
                        <span class="name">子需求的子需求的名称子需求的名称子需求的名称名称</span>
                        <span class="date">2018-04-04 12:00</span>
                        <span class="people">张三</span>
                        <span class="iconfont icon-youcecaidanshouqi icon-right"></span>
                    </a>
                </li>
            </ul>
            <Form :model="demandForm1" :label-width="80">
                <Row>
                    <Col span="20">
                        <FormItem label="子需求名称">
                            <Input v-model="demandForm1.name"></Input>
                        </FormItem>
                        <FormItem label="需求描述">
                            <Input v-model="demandForm1.des" type="textarea"></Input>
                        </FormItem>
                        <FormItem label="">
                            <Button type="dashed" long icon="plus-round">添加</Button>
                        </FormItem>
                        <FormItem label="">
                            <Button type="dashed" long icon="plus-round">添加子需求</Button>
                        </FormItem>
                        <FormItem label="创建人">
                            <Select :model="nameSelect">
                                <Option v-for="item in nameList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
            </Form>
            <div slot="footer">
                <Button type="ghost" @click="cancelAdd1">取消</Button>
                <Button type="primary" @click="affirmAdd1">创建</Button>
            </div>
        </Modal>
        <!-- 2需求新增 -->
        <Modal
            v-model="AddModel2"
            title="需求新增二级"
            class-name="vertical-center-modal"
            class="h-480"
            >
            <Form :model="addForm2" :label-width="80">
                <Row>
                    <Col span="20">
                        <FormItem label="需求名称">
                            <Input v-model="addForm2.name"></Input>
                        </FormItem>
                        <FormItem label="优先级">
                            <Select v-model="addForm2.select1">
                                <Option value="beijing">New York</Option>
                                <Option value="shanghai">London</Option>
                                <Option value="shenzhen">Sydney</Option>
                            </Select>
                        </FormItem>
                        <FormItem label="需求来源">
                            <Select v-model="addForm2.select2">
                                <Option value="beijing">New York</Option>
                                <Option value="shanghai">London</Option>
                                <Option value="shenzhen">Sydney</Option>
                            </Select>
                        </FormItem>
                        <FormItem label="评审人选择">
                            <Select v-model="addForm2.select3">
                                <Option value="beijing">New York</Option>
                                <Option value="shanghai">London</Option>
                                <Option value="shenzhen">Sydney</Option>
                            </Select>
                        </FormItem>
                        <FormItem label="需求描述">
                            <Input v-model="addForm2.des" type="textarea"></Input>
                        </FormItem>
                        <FormItem label="附件名称">
                            <Input v-model="addForm2.adjunct"></Input>
                        </FormItem>
                        <FormItem label="附件地址">
                            <Input v-model="addForm2.address"></Input>
                        </FormItem>
                    </Col>
                </Row>
            </Form>
            <p class="title">需求列表</p>
            <ul class="demand-list">
                <li title="点击可添加子需求">
                    <a @click="addModelShow3">
                        <span class="name">子需求的子需求的名称子需求的名称子需求的名称名称</span>
                        <span class="date">2018-04-04 12:00</span>
                        <span class="people">张三</span>
                        <span class="iconfont icon-youcecaidanshouqi icon-right"></span>
                    </a>
                </li>
            </ul>
            <Form :model="demandForm2" :label-width="80">
                <Row>
                    <Col span="20">
                        <FormItem label="子需求名称">
                            <Input v-model="demandForm2.name"></Input>
                        </FormItem>
                        <FormItem label="需求描述">
                            <Input v-model="demandForm2.des" type="textarea"></Input>
                        </FormItem>
                        <FormItem label="">
                            <Button type="dashed" long icon="plus-round">添加</Button>
                        </FormItem>
                        <FormItem label="">
                            <Button type="dashed" long icon="plus-round">添加子需求</Button>
                        </FormItem>
                        <FormItem label="创建人">
                            <Select :model="nameSelect">
                                <Option v-for="item in nameList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
            </Form>
            <div slot="footer">
                <Button type="ghost" @click="cancelAdd2">取消</Button>
                <Button type="primary" @click="affirmAdd2">创建</Button>
            </div>
        </Modal>
        <!-- 3需求新增 -->
        <Modal
            v-model="AddModel3"
            title="需求新增三级"
            class-name="vertical-center-modal"
            class="h-480"
            >
            <Form :model="addForm3" :label-width="80">
                <Row>
                    <Col span="20">
                        <FormItem label="需求名称">
                            <Input v-model="addForm3.name"></Input>
                        </FormItem>
                        <FormItem label="优先级">
                            <Select v-model="addForm3.select1">
                                <Option value="beijing">New York</Option>
                                <Option value="shanghai">London</Option>
                                <Option value="shenzhen">Sydney</Option>
                            </Select>
                        </FormItem>
                        <FormItem label="需求来源">
                            <Select v-model="addForm3.select2">
                                <Option value="beijing">New York</Option>
                                <Option value="shanghai">London</Option>
                                <Option value="shenzhen">Sydney</Option>
                            </Select>
                        </FormItem>
                        <FormItem label="评审人选择">
                            <Select v-model="addForm3.select3">
                                <Option value="beijing">New York</Option>
                                <Option value="shanghai">London</Option>
                                <Option value="shenzhen">Sydney</Option>
                            </Select>
                        </FormItem>
                        <FormItem label="需求描述">
                            <Input v-model="addForm3.des" type="textarea"></Input>
                        </FormItem>
                        <FormItem label="附件名称">
                            <Input v-model="addForm3.adjunct"></Input>
                        </FormItem>
                        <FormItem label="附件地址">
                            <Input v-model="addForm3.address"></Input>
                        </FormItem>
                    </Col>
                </Row>
            </Form>
            <p class="title">需求列表</p>
            <ul class="demand-list">
                <li title="点击可添加子需求">
                    <a>
                        <span class="name">子需求的子需求的名称子需求的名称子需求的名称名称</span>
                        <span class="date">2018-04-04 12:00</span>
                        <span class="people">张三</span>
                        <span class="iconfont icon-youcecaidanshouqi icon-right"></span>
                    </a>
                </li>
            </ul>
            <Form :model="demandForm3" :label-width="80">
                <Row>
                    <Col span="20">
                        <FormItem label="子需求名称">
                            <Input v-model="demandForm3.name"></Input>
                        </FormItem>
                        <FormItem label="需求描述">
                            <Input v-model="demandForm3.des" type="textarea"></Input>
                        </FormItem>
                        <FormItem label="">
                            <Button type="dashed" long icon="plus-round">添加</Button>
                        </FormItem>
                        <FormItem label="">
                            <Button type="dashed" long icon="plus-round">添加子需求</Button>
                        </FormItem>
                        <FormItem label="创建人">
                            <Select :model="nameSelect">
                                <Option v-for="item in nameList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
            </Form>
            <div slot="footer">
                <Button type="ghost" @click="cancelAdd3">取消</Button>
                <Button type="primary" @click="affirmAdd3">创建</Button>
            </div>
        </Modal>
        <!-- 需求详情 -->
        <Modal
            v-model="AddModelDetail"
            title="需求详情"
            class-name="vertical-center-modal"
            class="h-480"
            >
            <Form :model="addFormDetail" :label-width="80">
                <Row>
                    <Col span="20">
                        <FormItem label="需求名称">
                            <Input v-model="addFormDetail.name"></Input>
                        </FormItem>
                        <FormItem label="优先级">
                            <Select v-model="addFormDetail.select1">
                                <Option value="beijing">New York</Option>
                                <Option value="shanghai">London</Option>
                                <Option value="shenzhen">Sydney</Option>
                            </Select>
                        </FormItem>
                        <FormItem label="需求来源">
                            <Select v-model="addFormDetail.select2">
                                <Option value="beijing">New York</Option>
                                <Option value="shanghai">London</Option>
                                <Option value="shenzhen">Sydney</Option>
                            </Select>
                        </FormItem>
                        <FormItem label="评审人选择">
                            <Select v-model="addFormDetail.select3">
                                <Option value="beijing">New York</Option>
                                <Option value="shanghai">London</Option>
                                <Option value="shenzhen">Sydney</Option>
                            </Select>
                        </FormItem>
                        <FormItem label="需求描述">
                            <Input v-model="addFormDetail.des" type="textarea"></Input>
                        </FormItem>
                        <FormItem label="附件名称">
                            <Input v-model="addFormDetail.adjunct"></Input>
                        </FormItem>
                        <FormItem label="附件地址">
                            <Input v-model="addFormDetail.address"></Input>
                        </FormItem>
                    </Col>
                </Row>
            </Form>
            <p class="title">需求列表</p>
            <ul class="demand-list">
                <li title="点击可添加子需求">
                    <a>
                        <span class="name">子需求的子需求的名称子需求的名称子需求的名称名称</span>
                        <span class="date">2018-04-04 12:00</span>
                        <span class="people">张三</span>
                        <span class="iconfont icon-youcecaidanshouqi icon-right"></span>
                    </a>
                </li>
            </ul>
            <Form :model="demandFormDetail" :label-width="80">
                <Row>
                    <Col span="20">
                        <FormItem label="子需求名称">
                            <Input v-model="demandFormDetail.name"></Input>
                        </FormItem>
                        <FormItem label="需求描述">
                            <Input v-model="demandFormDetail.des" type="textarea"></Input>
                        </FormItem>
                        <FormItem label="">
                            <Button type="dashed" long icon="plus-round">添加</Button>
                        </FormItem>
                        <FormItem label="">
                            <Button type="dashed" long icon="plus-round">添加子需求</Button>
                        </FormItem>
                        <FormItem label="创建人">
                            <Select :model="nameSelect">
                                <Option v-for="item in nameList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
            </Form>
            <p class="title">历史记录</p>
            <div>
                <p class="cl mb-10">
                    <span class="fl mr-10">某某创建了需求</span>
                    <span class="fl">PMT测试项目</span>
                    <span class="fr">2018-04-04</span>
                </p>
                <p class="cl mb-10">
                    <span class="fl mr-10">某某创建了需求</span>
                    <span class="fl">PMT测试项目</span>
                    <span class="fr">2018-04-04</span>
                </p>
            </div>
            <p class="title">需求一生</p>
            <div>
                <p class="cl mb-10">
                    <span class="fl mr-10">某某创建了需求</span>
                    <span class="fr">2018-04-04</span>
                </p>
                <p class="cl mb-10">
                    <span class="fl mr-10">某某创建了需求</span>
                    <span class="fr">2018-04-04</span>
                </p>
            </div>
            <div slot="footer">
                <Button type="ghost" @click="cancelAddD">取消</Button>
                <Button type="primary" @click="affirmAddD">创建</Button>
            </div>
        </Modal>
    </div>
</template>
<script>
    export default {
        data () {
            return {
                oneStair:'',
                twoStair:'',
                accordion:true,
                changeModel:false,
                reviewModel:false,
                AddModel1:false,
                AddModel2:false,
                AddModel3:false,
                AddModelDetail:false,
                chageForm:{
                    name:'111',
                    des:'',
                    select1:'',
                    select2:'',
                },
                reviewForm:{
                    name:'111',
                    des:'',
                    select1:'',
                    select2:'',
                    select3:'',
                    select4:'',
                },
                addForm1:{
                    name:'111',
                    des:'',
                    select1:'',
                    select2:'',
                    select3:'',
                    adjunct:'',
                    address:'',
                },
                demandForm1:{
                    name:'111',
                    des:'',
                },
                addForm2:{
                    name:'222',
                    des:'',
                    select1:'',
                    select2:'',
                    select3:'',
                    adjunct:'',
                    address:'',
                },
                demandForm2:{
                    name:'222',
                    des:'',
                },
                addForm3:{
                    name:'333',
                    des:'',
                    select1:'',
                    select2:'',
                    select3:'',
                    adjunct:'',
                    address:'',
                },
                demandForm3:{
                    name:'333',
                    des:'',
                },
                addFormDetail:{
                    name:'详情',
                    des:'',
                    select1:'',
                    select2:'',
                    select3:'',
                    adjunct:'',
                    address:'',
                },
                demandFormDetail:{
                    name:'详情',
                    des:'',
                },
                Rw: [
                    {
                        title: '编号',
                        key: 'number'
                    },
                    {
                        title: '优先级',
                        key: 'age'
                    },
                    {
                        title: '任务名称',
                        key: 'name'
                    },
                    {
                        title: '起止日期',
                        key: 'name'
                    },
                    {
                        title: '负责人',
                        key: 'name'
                    },
                    {
                        title: '任务状态',
                        key: 'name'
                    }
                ],
                Rwdata: [],
                Yl: [
                    {
                        title: '编号',
                        key: 'number'
                    },
                    {
                        title: '优先级',
                        key: 'age'
                    },
                    {
                        title: '任务名称',
                        key: 'name'
                    },
                    {
                        title: '起止日期',
                        key: 'name'
                    },
                    {
                        title: '负责人',
                        key: 'name'
                    },
                    {
                        title: '任务状态',
                        key: 'name'
                    }
                ],
                Yldata: [],
                Bg: [
                    {
                        title: '编号',
                        key: 'number'
                    },
                    {
                        title: '优先级',
                        key: 'age'
                    },
                    {
                        title: '任务名称',
                        key: 'name'
                    },
                    {
                        title: '起止日期',
                        key: 'name'
                    },
                    {
                        title: '负责人',
                        key: 'name'
                    },
                    {
                        title: '任务状态',
                        key: 'name'
                    }
                ],
                Bgdata: [],
                nameList: [
                    {
                        value: '张三',
                        label: '张三'
                    },
                    {
                        value: '李四',
                        label: '李四'
                    }
                ],
                nameSelect: ''
            }
        },
        methods:{
            //需求详情
            addModelShowDetail(){
                this.AddModelDetail = true;
            },
            //新增需求
            addModelShow1(){
                this.AddModel1 = true;
            },
            addModelShow2(){
                this.AddModel2 = true;
            },
            addModelShow3(){
                this.AddModel3 = true;
            },
            //创建
            affirmAdd1(){
                this.AddModel1 = false;
            },
            affirmAdd2(){
                this.AddModel2 = false;
            },
            affirmAdd3(){
                this.AddModel3 = false;
            },
            affirmAddD(){
                this.AddModelDetail = false;
            },
            //取消
            cancelAdd1(){
                this.AddModel1 = false;
            },
            cancelAdd2(){
                this.AddModel2 = false;
            },
            cancelAdd3(){
                this.AddModel3 = false;
            },
            cancelAddD(){
                this.AddModelDetail = false;
            },
            //需求变更
            showChangeModel(){
                this.changeModel = true;
            },
            //确认
            affirmBtn(){
                this.changeModel = false;
            },
            //取消
            cancelBtn(){
                this.changeModel = false;
            },
            //需求变更
            showReviewModel(){
                this.reviewModel = true;
            },
            //确认
            affirmSub(){
                this.reviewModel = false;
            },
            //取消
            cancelSub(){
                this.reviewModel = false;
            },
        }
    }
</script>
<style scoped lang="less">
    .add-btn{
        position:absolute;
        top:0;
        right:0;
    }
    .demand-list{
        margin-bottom:20px;
        li{
            line-height:25px;
            a{display:block;}
            span{
                display:inline-block;
                margin-right:10px;
                white-space:nowrap;
                overflow:hidden;
                text-overflow:ellipsis;
            }
            .name{width:50%; }
            .date{width:25%;}
            .people{width:10%;color:#0459ab;}
            .icon-right{ font-size:14px;}

        }
    }
</style>