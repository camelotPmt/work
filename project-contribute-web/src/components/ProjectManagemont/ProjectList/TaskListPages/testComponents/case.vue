<template>
   <div class="case-container">
        <Form :model="formItem" :label-width="80" inline>
            <FormItem label="用例名称">
                <Input v-model="formItem.id" placeholder=""></Input>
            </FormItem>
            <FormItem label="用例类型">
                <Select v-model="formItem.role" placeholder="请选择用例类型">
                    <Option value="beijing">性能测试</Option>
                    <Option value="shanghai">功能测试</Option>
                </Select>
            </FormItem>
            <FormItem>
                <Button type="primary">查询</Button>
                <Button type="ghost" class="ml-10">重置</Button>
                <Button type="primary" @click="showAddpModel" class="ml-10">添加</Button>
                <Button type="primary" class="ml-10">导入</Button>
                <Button type="primary" class="ml-10">导出</Button>
            </FormItem>
        </Form>
        <Table :columns="columns1" :data="source" height="340"></Table>
        <div class="page-break">
            <Page :total="Math.floor(size)" :current="Math.floor(index)" :page-size="Math.floor(rows)" @on-change="change"></Page>
        </div>
        <!-- 添加用例弹出框 -->
        <Modal
            v-model="addCaseModel"
            title="添加用例"
            class-name="vertical-center-modal"
            width="800"
            class="h-480"
            :mask-closable="false">
            <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="100">
                <FormItem label="用例编号" prop="name">
                    <Row>
                        <Col span="12">
                            <Input placeholder="请输入用例编号"></Input>
                        </Col>
                    </Row>
                </FormItem>
                <FormItem label="用例名称" prop="versionName">
                    <Row>
                        <Col span="12">
                            <Input v-model="formValidate.versionName" placeholder="请输入用例名称"></Input>
                        </Col>
                    </Row>
                </FormItem>
                <FormItem label="优先级">
                    <Row>
                        <Col span="12">
                            <Select placeholder="请选择优先级">
                                <Option value="beijing">P1</Option>
                                <Option value="shanghai">P2</Option>
                                <Option value="shanghai">P3</Option>
                                <Option value="shanghai">P4</Option>
                            </Select>
                        </Col>
                    </Row>
                </FormItem>
                <FormItem label="类型">
                    <Row>
                        <Col span="12">
                            <Select placeholder="请选择类型">
                                <Option value="beijing">性能测试</Option>
                                <Option value="shanghai">功能测试</Option>
                            </Select>
                        </Col>
                    </Row>
                </FormItem>
                <FormItem label="测试阶段">
                    <Row>
                        <Col span="12">
                            <Select placeholder="请选择测试阶段">
                                <Option value="beijing">阶段1</Option>
                                <Option value="shanghai">阶段2</Option>
                            </Select>
                        </Col>
                    </Row>
                </FormItem>
                <FormItem label="关联需求">
                    <Row :gutter="10">
                        <Col span="10">
                            <Select placeholder="请选择一级需求模块">
                                <Option value="beijing">阶段1</Option>
                                <Option value="shanghai">阶段2</Option>
                            </Select>
                        </Col>
                        <Col span="10">
                            <Select placeholder="输入编号、名称进行管理需求">
                                <Option value="beijing">阶段1</Option>
                                <Option value="shanghai">阶段2</Option>
                            </Select>
                        </Col>
                    </Row>
                </FormItem>
                <FormItem label="前置条件">
                    <Input
                      v-model="formValidate.condition"
                      type="textarea"
                      :autosize="{minRows: 4,maxRows: 5}"
                      placeholder="请输入前置条件"
                    >
                    </Input>
                </FormItem>
                <FormItem label="用例描述" prop="mail">
                    <Input
                      v-model="formValidate.brief"
                      type="textarea"
                      :autosize="{minRows: 4,maxRows: 5}"
                      placeholder="请输入用例描述"
                    >
                    </Input>
                </FormItem>
            </Form>
            <h2 class="mb-20">用例步骤</h2>
            <Table :columns="addColumns" :data="addSource" height="340"></Table>
            <div slot="footer">
                <Button type="ghost" @click="cancelBtn">取消</Button>
                <Button type="primary" @click="affirmBtn">确认</Button>
            </div>
        </Modal>
        <!-- 删除用例 -->
        <Modal
            v-model="delItem"
            title="删除用例"
            class-name="vertical-center-modal"
            :mask-closable="false"
            width="400">
            <div>
                <p>用例一经删除，不能恢复，是否删除？</p>
            </div>
            <div slot="footer">
                <Button type="ghost" @click="cancelDelBtn">取消</Button>
                <Button type="primary" @click="delBtn">删除</Button>
            </div>
        </Modal>
        <!-- 用例执行 -->
        <Modal
            v-model="performModal"
            title="用例执行"
            class-name="vertical-center-modal"
            :mask-closable="false"
            width="800"
            class="h-480 perform-modal">
            <h2 class="mb-20">前置条件</h2>
            <p class="mb-20">{{performInf.condition}}</p>
            <h2 class="mb-20">测试步骤</h2>
            <Row class="mb-20">
              <Col span="12">
                <Select v-model="stepVersion" placeholder="请选择版本">
                    <Option v-for="item in stepList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                </Select>
              </Col>
            </Row>
            <Table :columns="stepColumns" :data="performInf.step" height="340" class="mb-20"></Table>
            <div class="font-cen mb-20">
              <Button type="primary">完成</Button>
            </div>
            <hr class="mb-20" />
            <h2 class="mb-20">
              测试结果 ——
              <span>
                共执行<i>{{performInf.result.total}}</i>次
                <b class="red">未通过</b><i>{{performInf.result.error}}</i>次
              </span>
            </h2>
            <ul>
              <li v-for="(item, index) in performInf.result.resultData" :key="`${item.id}`">
                <h2 class="mb-20 cl">
                  <span class="correct">{{item.id}}</span>
                  <span class="time">{{item.time}}</span>
                  <span class="operator"><i>{{item.name}}</i>执行</span>
                  <span class="green">{{item.res}}</span>
                  <span
                    :class="[item.isShowTable ? 'icon-arrowup' : 'icon-arrowdown','fr iconfont cur-p']"
                    @click="unfoldTable(index)">
                  </span>
                </h2>
                <Table v-show="item.isShowTable" :columns="resultColumns" :data="item.tableData" height="340" class="mb-20"></Table>
              </li>
            </ul>
            <div slot="footer">
                <Button type="ghost" @click="cancelPerform">取消</Button>
                <!-- <Button type="primary" @click="delBtn">确认</Button> -->
            </div>
        </Modal>
        <!-- 新建bug -->
        <addBug ref="addBug" />
    </div>
</template>
<script>
import AddBug from './common/addBug'

export default {
  components: {AddBug},
  data() {
    return {
      index: "1",
      rows: "10",
      size: "",
      formItem: {
        id: "",
        name: "",
        role: "",
        activate: ""
      },
      columns1: [
        {
          type: "selection",
          width: 60,
          align: "center"
        },
        {
          title: "编号",
          key: "id"
        },
        {
          title: "优先级",
          key: "username",
          render: (h, params) => {
            return h("div", [
              h(
                "Tag",
                {
                  props: {
                    color: "#ff0000"
                  }
                },
                "P1"
              ),
              h(
                "Tag",
                {
                  props: {
                    color: "#ff9933"
                  }
                },
                "P2"
              ),
              h(
                "Tag",
                {
                  props: {
                    color: "#33cc00"
                  }
                },
                "P3"
              ),
              h(
                "Tag",
                {
                  props: {
                    color: "#bfbfbf"
                  }
                },
                "P4"
              )
            ]);
          }
        },
        {
          title: "名称",
          key: "loginCode"
        },
        {
          title: "类型",
          key: "section1"
        },
        {
          title: "执行人",
          key: "section2",
          render: (h, params) => {
            return h("div", [
              h(
                "Tag",
                {
                  props: {
                    color: "#33ccff"
                  }
                },
                "蔡长庆"
              )
            ]);
          }
        },
        {
          title: "结果",
          key: "result"
        },
        {
          title: "操作",
          key: "section4",
          render: (h, params) => {
            return h("div", [
              h(
                "button",
                {
                  props: {},
                  class: {
                    iconfont: true,
                    "icon-kaishi": true
                  },
                  style: {},
                  attrs: {
                    title: "用例执行"
                  },
                  on: {
                    click: () => {
                      this.showPerformModal(params.row.id);
                    }
                  }
                },
                ""
              ),
              h(
                "button",
                {
                  props: {},
                  class: {
                    iconfont: true,
                    "icon-zhixingzhong": true
                  },
                  style: {},
                  attrs: {
                    title: "执行结果"
                  },
                  on: {
                    click: () => {}
                  }
                },
                ""
              ),
              h(
                "button",
                {
                  props: {},
                  class: {
                    iconfont: true,
                    "icon-bug": true
                  },
                  style: {},
                  attrs: {
                    title: "转成BUG"
                  },
                  on: {
                    click: () => {
                      this.$refs.addBug.showAddpModel();
                    }
                  }
                },
                ""
              ),
              h(
                "button",
                {
                  props: {},
                  class: {
                    iconfont: true,
                    "icon-icon7": true
                  },
                  attrs: {
                    title: "删除"
                  },
                  style: {},
                  on: {
                    click: () => {
                      this.delItem = true;
                    }
                  }
                },
                ""
              ),
              h(
                "button",
                {
                  props: {},
                  class: {
                    iconfont: true,
                    "icon-copy": true
                  },
                  attrs: {
                    title: "复制用例"
                  },
                  style: {},
                  on: {
                    click: () => {}
                  }
                },
                ""
              )
            ]);
          }
        }
      ],
      source: [{ id: 1 }], // 测试数据
      tableInpIndexArr: [],
      tableDataArr: [],
      addColumns: [
        {
          title: "编号",
          key: "id",
          type: 'index',
          width: 60,
        },
        {
          title: "步骤",
          key: "step",
          render: (h, params) => {
            return h("div", [
              h(
                "i-input",
                {
                  props: {
                    placeholder: "请输入步骤",
                    value: params.row.step,
                    elementId: `stepInp${params.index+1}`,
                  }
                },
                ""
              )
            ]);
          }
        },
        {
          title: "预期目标",
          key: "goal",
          render: (h, params) => {
            return h("div", [
              h(
                "i-input",
                {
                  props: {
                    placeholder: "请输入预期目标",
                    value: params.row.goal,
                    elementId: `goalInp${params.index+1}`,
                  }
                },
                ""
              )
            ]);
          }
        },
        {
          title: "操作",
          key: "operation",
          width: 150,
          render: (h, params) => {
            return h("div", [
              h(
                "button",
                {
                  props: {},
                  class: {
                    iconfont: true,
                    "icon-xinjian": true
                  },
                  style: {},
                  attrs: {
                    title: "添加"
                  },
                  on: {
                    click: () => {
                      this.addRow(params.index+1)
                    }
                  }
                },
                ""
              ),
              h(
                "button",
                {
                  props: {},
                  class: {
                    iconfont: true,
                    "icon-arrowup": true
                  },
                  style: {},
                  attrs: {
                    title: "上移"
                  },
                  on: {
                    click: () => {}
                  }
                },
                ""
              ),
              h(
                "button",
                {
                  props: {},
                  class: {
                    iconfont: true,
                    "icon-arrowdown": true
                  },
                  style: {},
                  attrs: {
                    title: "下移"
                  },
                  on: {
                    click: () => {}
                  }
                },
                ""
              ),
              h(
                "button",
                {
                  props: {},
                  class: {
                    iconfont: true,
                    "icon-icon7": true
                  },
                  attrs: {
                    title: "删除"
                  },
                  style: {},
                  on: {
                    click: () => {
                      this.delItem = true;
                    }
                  }
                },
                ""
              ),
            ]);
          }
        },
      ],
      addSource: [{id:1},{id:2},{id:3}], // 测试数据
      addCaseModel: false,
      delItem: false,
      formValidate: {
        date: "",
        versionName: "",
        condition:'',
        brief:''
      },
      ruleValidate: {
        versionName: [
          { required: true, message: "用例名称不能为空", trigger: "blur" }
        ],
        name: [
          { required: true, message: "用例编号不能为空", trigger: "blur" }
        ],
      },
      performModal: false,
      performSelList:[
        {
          id: 0,
          txt: '不通过'
        },
        {
          id: 1,
          txt: '通过'
        },
      ],
      stepVersion: '',
      stepList:[
        {label: '测试版V0.0.1',value: 0},
        {label: '测试版V0.0.2',value: 1},
        {label: '测试版V0.0.3',value: 2},
      ],
      stepColumns: [
        {
          title: "编号",
          key: "id",
          width: 60
        },
        {
          title: "步骤",
          key: "step",
        },
        {
          title: "预期",
          key: "expect",
        },
        {
          title: "测试结果",
          key: "result",
          render: (h, params) => {
            return h("i-select",{
                props: {
                  placeholder: "请选择测试结果",
                },
                // attrs:{
                //   id: `stepSel${params.row.id}`,
                // },
                on: {
                  'on-change': (value) =>{
                    // console.log(value);
                  }
                }
              }, [
              this.performSelList.map(item => {
                return h(
                  "i-option",
                  {
                    props: {
                      value: item.id
                    },
                  },
                  item.txt
                )
              })
            ]);
          }
        },
        {
          title: "实际情况",
          key: "fact",
          render: (h, params) => {
            return h("div", [
              h(
                "i-input",
                {
                  props: {
                    placeholder: "请输入实际情况",
                    elementId: `factInp${params.index+1}`,
                  }
                },
                ""
              )
            ]);
          }
        },
      ],
      resultColumns: [
        {
          title: "编号",
          key: "id",
          width: 60
        },
        {
          title: "步骤",
          key: "step",
        },
        {
          title: "预期",
          key: "expect",
        },
        {
          title: "测试结果",
          key: "result",
        },
        {
          title: "实际情况",
          key: "fact",
        }
      ],
      performInf: {
        condition: '测试',
        step: [
          {
            id:1
          },
          {
            id:2
          }
        ],
        result:{
          total: 2,
          error: 1,
          resultData: [
            {
              id: 1,
              time: '2018-04-08 12：00：00',
              name: '蔡长庆',
              res: '通过',
              isShowTable: false,
              tableData:[
                {id:1},
              ]
            },
            // {
            //   id: 2,
            //   time: '2018-04-08 12：00：00',
            //   name: '蔡长庆',
            //   res: '通过',
            //   isShowTable: false,
            //   tableData:[
            //     {id:1},
            //   ]
            // },
            // {
            //   id: 3,
            //   time: '2018-04-08 12：00：00',
            //   name: '蔡长庆',
            //   res: '通过',
            //   isShowTable: false,
            //   tableData:[
            //     {id:1},
            //   ]
            // },
          ]
        },
      },
    };
  },
  mounted() {},
  created() {
    this.getMuduleAList();
  },
  methods: {
    getMuduleAList(index, rows) {
      //获取用例列表
      var data = new FormData();
      // data.append()
      this.$http
        .post("/user/queryAllUsers", data)
        .then(res => {
          var data = response.data(res, this);
          if (data) {
            this.size = data.total;
            this.source = data;
          }
        })
        .catch(res => {
          // this.$Message.error('获取用例列表失败')
        });
    },
    change(params) {
      this.index = params;
      // this.getMuduleAList(params);
    },
    //添加用例弹出框
    showAddpModel() {
      this.addCaseModel = true;
    },
    // 添加用例弹出层确认按钮
    affirmBtn() {
      this.addCaseModel = false;
      this.getInpValue();
    },
    // 获取添加里table的input的值
    getInpValue(){
      let stepValue = document.getElementById("stepInp1").value;
      let goalValue = document.getElementById("goalInp1").value;
    },
    // 添加一行
    addRow(index) {
      let insertIndex = index + 1;
      var insertItem = {
        id: insertIndex
      }
      this.addSource.splice(index,0,insertItem)
    },
    // 添加用例弹出层取消按钮
    cancelBtn() {
      this.addCaseModel = false;
    },
    // 确认删除项目
    delBtn() {
      this.delItem = false;
    },
    // 取消删除
    cancelDelBtn() {
      this.delItem = false;
    },
    // 打开用例执行弹出层
    showPerformModal(id) {
      this.performModal = true;
    },
    // 用例执行弹出层的取消操作
    cancelPerform() {
      this.performModal = false;
    },
    // 折叠显示table
    unfoldTable(index) {
      this.performInf.result.resultData[index].isShowTable = !this.performInf.result.resultData[index].isShowTable;
    }
  }
};
</script>
<style scoped lang="less">
  .perform-modal{
    .red{
      color: #ff0000;
    }
    .green{
      color: #33cc00;
    }
    .correct{
      display: inline-block;
      width: 20px;
      height: 20px;
      text-align: center;
      line-height: 20px;
      color: #fff;
      border-radius: 50%;
      background: #33cc00;
    }
    .error{
      background: red;
    }
    .time{
      margin: 0 40px 0 10px;
    }
    .operator{
      margin-right: 60px;
      i{
        display: inline-block;
        background: #33ccff;
        border-radius: 10px;
        padding: 4px 8px;
        color: #fff;
        margin-right: 10px;
      }
    }
  }
</style>