webpackJsonp([11],{"phl+":function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var o={data:function(){var t=this;return{index:"1",rows:"10",size:"",formItem:{id:"",name:"",role:"",activate:""},columns1:[{title:"版本编号",key:"id"},{title:"版本名称",key:"username"},{title:"版本类型",key:"loginCode"},{title:"开始时间",key:"section1"},{title:"结束时间",key:"section2"},{title:"操作",key:"section4",render:function(e,a){return e("div",[e("button",{props:{},class:{iconfont:!0,"icon-jinyong":!0},style:{},on:{click:function(){}}},""),e("button",{props:{},class:{iconfont:!0,"icon-msnui-active":!0},style:{},on:{click:function(){}}},""),e("button",{props:{},class:{iconfont:!0,"icon-icon7":!0},style:{},on:{click:function(){t.delItem=!0}}},"")])}}],source:[],addVersionModel:!1,delItem:!1,formValidate:{date:"",versionName:""},ruleValidate:{versionName:[{required:!0,message:"版本名称不能为空",trigger:"blur"}],date:[{required:!0,type:"date",message:"Please select the date",trigger:"change"}]}}},mounted:function(){},created:function(){this.getMuduleAList()},methods:{getMuduleAList:function(t,e){var a=this,o=new FormData;this.$http.post("/user/queryAllUsers",o).then(function(t){var e=response.data(t,a);e&&(a.size=e.total,a.source=e)}).catch(function(t){})},change:function(t){this.index=t},showAddpModel:function(){this.addVersionModel=!0},affirmBtn:function(){this.addVersionModel=!1},cancelBtn:function(){this.addVersionModel=!1},delBtn:function(){this.delItem=!1},cancelDelBtn:function(){this.delItem=!1}}},l={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"version-container"},[a("Form",{attrs:{model:t.formItem,"label-width":80,inline:""}},[a("FormItem",{attrs:{label:"版本名称"}},[a("Input",{attrs:{placeholder:""},model:{value:t.formItem.id,callback:function(e){t.$set(t.formItem,"id",e)},expression:"formItem.id"}})],1),t._v(" "),a("FormItem",{attrs:{label:"版本编号"}},[a("Input",{attrs:{placeholder:""},model:{value:t.formItem.name,callback:function(e){t.$set(t.formItem,"name",e)},expression:"formItem.name"}})],1),t._v(" "),a("FormItem",{attrs:{label:"版本类型"}},[a("Select",{attrs:{placeholder:"请选择版本类型"},model:{value:t.formItem.role,callback:function(e){t.$set(t.formItem,"role",e)},expression:"formItem.role"}},[a("Option",{attrs:{value:"beijing"}},[t._v("正式")]),t._v(" "),a("Option",{attrs:{value:"shanghai"}},[t._v("测试")])],1)],1),t._v(" "),a("FormItem",[a("Button",{attrs:{type:"primary"}},[t._v("查询")]),t._v(" "),a("Button",{staticClass:"ml-10",attrs:{type:"ghost"}},[t._v("重置")]),t._v(" "),a("Button",{staticClass:"ml-10",attrs:{type:"primary"},on:{click:t.showAddpModel}},[t._v("添加")])],1)],1),t._v(" "),a("Table",{attrs:{columns:t.columns1,data:t.source,height:"340"}}),t._v(" "),a("div",{staticClass:"page-break"},[a("Page",{attrs:{total:Math.floor(t.size),current:Math.floor(t.index),"page-size":Math.floor(t.rows)},on:{"on-change":t.change}})],1),t._v(" "),a("Modal",{attrs:{title:"添加版本","class-name":"vertical-center-modal","mask-closable":!1},model:{value:t.addVersionModel,callback:function(e){t.addVersionModel=e},expression:"addVersionModel"}},[a("Form",{ref:"formValidate",attrs:{model:t.formValidate,rules:t.ruleValidate,"label-width":100}},[a("FormItem",{attrs:{label:"版本编号",prop:"name"}},[a("Row",[a("Col",{attrs:{span:"12"}},[a("Input",{attrs:{placeholder:"请输入版本编号"}})],1)],1)],1),t._v(" "),a("FormItem",{attrs:{label:"版本类型"}},[a("Row",[a("Col",{attrs:{span:"12"}},[a("Select",{attrs:{placeholder:"请选择版本类型"},model:{value:t.formItem.role,callback:function(e){t.$set(t.formItem,"role",e)},expression:"formItem.role"}},[a("Option",{attrs:{value:"beijing"}},[t._v("正式")]),t._v(" "),a("Option",{attrs:{value:"shanghai"}},[t._v("测试")])],1)],1)],1)],1),t._v(" "),a("FormItem",{attrs:{label:"版本名称",prop:"versionName"}},[a("Input",{attrs:{placeholder:"请输入版本名称"},model:{value:t.formValidate.versionName,callback:function(e){t.$set(t.formValidate,"versionName",e)},expression:"formValidate.versionName"}})],1),t._v(" "),a("FormItem",{attrs:{label:"gethup代码ID",prop:"mail"}},[a("Input",{attrs:{placeholder:"请输入gethup代码ID"}})],1),t._v(" "),a("FormItem",{attrs:{label:"gethup/svnURL",prop:"svnURL"}},[a("Input",{attrs:{placeholder:"请输入gethup/svnURL"}})],1),t._v(" "),a("FormItem",{attrs:{label:"时间"}},[a("Row",[a("Col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"date"}},[a("DatePicker",{attrs:{type:"date",placeholder:"请选择开始时间"},model:{value:t.formValidate.date,callback:function(e){t.$set(t.formValidate,"date",e)},expression:"formValidate.date"}})],1)],1),t._v(" "),a("Col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[t._v("-")]),t._v(" "),a("Col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"date"}},[a("DatePicker",{attrs:{type:"date",placeholder:"请选择结束时间"},model:{value:t.formValidate.date,callback:function(e){t.$set(t.formValidate,"date",e)},expression:"formValidate.date"}})],1)],1)],1)],1)],1),t._v(" "),a("div",{attrs:{slot:"footer"},slot:"footer"},[a("Button",{attrs:{type:"ghost"},on:{click:t.cancelBtn}},[t._v("取消")]),t._v(" "),a("Button",{attrs:{type:"primary"},on:{click:t.affirmBtn}},[t._v("确认")])],1)],1),t._v(" "),a("Modal",{attrs:{title:"删除版本","class-name":"vertical-center-modal","mask-closable":!1,width:"400"},model:{value:t.delItem,callback:function(e){t.delItem=e},expression:"delItem"}},[a("div",[a("p",[t._v("版本一经删除，不能恢复，是否删除？")])]),t._v(" "),a("div",{attrs:{slot:"footer"},slot:"footer"},[a("Button",{attrs:{type:"ghost"},on:{click:t.cancelDelBtn}},[t._v("取消")]),t._v(" "),a("Button",{attrs:{type:"primary"},on:{click:t.delBtn}},[t._v("删除")])],1)])],1)},staticRenderFns:[]};var r=a("Z0/y")(o,l,!1,function(t){a("s3QA")},"data-v-72a87dcd",null);e.default=r.exports},s3QA:function(t,e){}});
//# sourceMappingURL=11.85b9823254bc4b486e26.js.map