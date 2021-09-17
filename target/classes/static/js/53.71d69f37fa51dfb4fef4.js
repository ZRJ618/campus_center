webpackJsonp([53],{

/***/ "7ZTI":
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__.p + "static/img/clouds.0febc59.jpg";

/***/ }),

/***/ "Aq4j":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });

// EXTERNAL MODULE: ./src/minxin/upload.js
var upload = __webpack_require__("lQEl");

// CONCATENATED MODULE: ./node_modules/babel-loader/lib!./node_modules/vue-loader/lib/selector.js?type=script&index=0!./src/components/Department/AdminDepartment.vue
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//


/* harmony default export */ var AdminDepartment = ({
  mixins: [upload["a" /* default */]],
  data: function data() {
    return {

      innerVisible: false,

      modifyDialogVisible: false,
      currentPage1: 5,
      //查看人数显示框
      centerDialogVisible: false,

      tableData: [{
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, {
        date: '2016-05-04',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1517 弄'
      }, {
        date: '2016-05-01',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1519 弄'
      }, {
        date: '2016-05-03',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1516 弄'
      }],
      ruleForm: {
        name: '宣传部',
        belong: '学生会',
        desc: '来'
      },
      rules: {
        name: [{ required: true, message: '请输入活动名称', trigger: 'blur' }, { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }],
        region: [{ required: true, message: '请选择活动区域', trigger: 'change' }],
        date1: [{ type: 'date', required: true, message: '请选择日期', trigger: 'change' }],
        date2: [{ type: 'date', required: true, message: '请选择时间', trigger: 'change' }],
        type: [{ type: 'array', required: true, message: '请至少选择一个活动性质', trigger: 'change' }],
        resource: [{ required: true, message: '请选择活动资源', trigger: 'change' }],
        desc: [{ required: true, message: '请填写活动形式', trigger: 'blur' }]
      }

    };
  },

  methods: {
    submitForm: function submitForm(formName) {
      this.$refs[formName].validate(function (valid) {
        if (valid) {
          alert('submit!');
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm: function resetForm(formName) {
      this.$refs[formName].resetFields();
    },

    //
    handleChange: function handleChange(index, row) {
      this.innerVisible = true;
      console.log(row);
    },

    //查看部门人员事件
    handleEdit: function handleEdit(index, row) {
      console.log(index, row);
    },
    handleDelete: function handleDelete(index, row) {
      console.log(index, row);
    },
    handleSizeChange: function handleSizeChange(val) {
      console.log('\u6BCF\u9875 ' + val + ' \u6761');
    },
    handleCurrentChange: function handleCurrentChange(val) {
      console.log('\u5F53\u524D\u9875: ' + val);
    }
  },
  mounted: function mounted() {},
  created: function created() {
    //   this.$router.beforeEach((to, from, next) => {
    //         console.log(to.name);
    //         next();          
    //   })
    //判断认证信息

  }
});
// CONCATENATED MODULE: ./node_modules/vue-loader/lib/template-compiler?{"id":"data-v-2f2dfc08","hasScoped":true,"transformToRequire":{"video":["src","poster"],"source":"src","img":"src","image":"xlink:href"},"buble":{"transforms":{}}}!./node_modules/vue-loader/lib/selector.js?type=template&index=0!./src/components/Department/AdminDepartment.vue
var render = function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',{staticStyle:{"height":"100%"}},[_vm._m(0),_vm._v(" "),_c('main',[_vm._m(1),_vm._v(" "),_c('div',{staticClass:"AdminDepartment_container"},[_c('span',[_vm._v("宣传部")]),_vm._v(" "),_c('span',{on:{"click":function($event){_vm.modifyDialogVisible = true}}},[_vm._v("修改部门信息")]),_vm._v(" "),_c('span',{on:{"click":function($event){_vm.centerDialogVisible = true}}},[_vm._v("查看部门人数")]),_vm._v(" "),_c('span',[_vm._v("发起部门活动")]),_vm._v(" "),_c('span',[_vm._v("查看近期活动")])])]),_vm._v(" "),_c('el-dialog',{attrs:{"title":"修改信息","visible":_vm.modifyDialogVisible,"width":"30%","center":""},on:{"update:visible":function($event){_vm.modifyDialogVisible=$event}}},[_c('el-form',{ref:"ruleForm",staticClass:"demo-ruleForm",attrs:{"model":_vm.ruleForm,"rules":_vm.rules,"label-width":"100px"}},[_c('el-form-item',{attrs:{"label":"部门名称"}},[_c('el-input',{attrs:{"readonly":""},model:{value:(_vm.ruleForm.name),callback:function ($$v) {_vm.$set(_vm.ruleForm, "name", $$v)},expression:"ruleForm.name"}})],1),_vm._v(" "),_c('el-form-item',{attrs:{"label":"部门所属"}},[_c('el-input',{attrs:{"readonly":""},model:{value:(_vm.ruleForm.belong),callback:function ($$v) {_vm.$set(_vm.ruleForm, "belong", $$v)},expression:"ruleForm.belong"}})],1),_vm._v(" "),_c('el-form-item',{attrs:{"label":"部门图片"}},[_c('div',{staticClass:"department_imgcontainer"},[_c('span',{staticClass:"el-icon-delete"}),_vm._v(" "),_c('img',{staticClass:"department_img",attrs:{"src":__webpack_require__("7ZTI"),"alt":""}})]),_vm._v(" "),_c('div',{staticClass:"department_imgcontainer"},[_c('span',{staticClass:"el-icon-delete"}),_vm._v(" "),_c('img',{staticClass:"department_img",attrs:{"src":__webpack_require__("7ZTI"),"alt":""}})]),_vm._v(" "),_c('div',{staticClass:"department_imgcontainer"},[_c('span',{staticClass:"el-icon-delete"}),_vm._v(" "),_c('img',{staticClass:"department_img",attrs:{"src":__webpack_require__("7ZTI"),"alt":""}})])]),_vm._v(" "),_c('el-form-item',{attrs:{"label":"上传图片"}},[_c('div',{staticClass:"article_coverimg"},[_c('el-upload',{staticClass:"avatar-uploader",attrs:{"limit":2,"list-type":"picture-card","multiple":"","action":"/article/uploadArticleImage","show-file-list":true,"before-upload":_vm.beforeAvatarUpload,"http-request":_vm.CoverImgUpload}},[(_vm.imageUrl)?_c('img',{staticClass:"avatar",attrs:{"src":_vm.imageUrl}}):_c('i',{staticClass:"el-icon-plus avatar-uploader-icon",staticStyle:{"margin":"-20px"}})])],1)]),_vm._v(" "),_c('el-form-item',{attrs:{"label":"部门描述","prop":"desc"}},[_c('el-input',{attrs:{"type":"textarea"},model:{value:(_vm.ruleForm.desc),callback:function ($$v) {_vm.$set(_vm.ruleForm, "desc", $$v)},expression:"ruleForm.desc"}})],1)],1),_vm._v(" "),_c('span',{staticClass:"dialog-footer",attrs:{"slot":"footer"},slot:"footer"},[_c('el-button',{on:{"click":function($event){_vm.modifyDialogVisible = false}}},[_vm._v("取 消")]),_vm._v(" "),_c('el-button',{attrs:{"type":"primary"},on:{"click":function($event){_vm.modifyDialogVisible = false}}},[_vm._v("确 定")])],1)],1),_vm._v(" "),_c('el-dialog',{attrs:{"title":"部门人数","visible":_vm.centerDialogVisible,"width":"40%","center":""},on:{"update:visible":function($event){_vm.centerDialogVisible=$event}}},[_c('el-table',{staticStyle:{"width":"100%"},attrs:{"data":_vm.tableData}},[_c('el-table-column',{attrs:{"align":"center","label":"姓名","width":"180"},scopedSlots:_vm._u([{key:"default",fn:function(scope){return [_c('span',{staticStyle:{"margin-left":"10px"}},[_vm._v(_vm._s(scope.row.date))])]}}])}),_vm._v(" "),_c('el-table-column',{attrs:{"align":"center","label":"职位","width":"180"},scopedSlots:_vm._u([{key:"default",fn:function(scope){return [_c('div',{staticClass:"name-wrapper",attrs:{"slot":"reference"},slot:"reference"},[_vm._v("\n            "+_vm._s(scope.row.name)+"\n          ")])]}}])}),_vm._v(" "),_c('el-table-column',{attrs:{"label":"操作","align":"center"},scopedSlots:_vm._u([{key:"default",fn:function(scope){return [_c('el-tooltip',{attrs:{"content":"查看","placement":"top","effect":"light"}},[_c('el-button',{attrs:{"circle":"","icon":"el-icon-search","size":"mini"},on:{"click":function($event){return _vm.handleEdit(scope.$index, scope.row)}}})],1),_vm._v(" "),_c('el-tooltip',{attrs:{"content":"设置","placement":"top","effect":"light"}},[_c('el-button',{attrs:{"type":"primary","icon":"el-icon-edit","circle":"","size":"mini"},on:{"click":function($event){return _vm.handleChange(scope.$index, scope.row)}}})],1),_vm._v(" "),_c('el-tooltip',{attrs:{"content":"移除","placement":"top","effect":"light"}},[_c('el-button',{attrs:{"icon":"el-icon-delete","circle":"","size":"mini","type":"danger"},on:{"click":function($event){return _vm.handleDelete(scope.$index, scope.row)}}})],1)]}}])})],1),_vm._v(" "),_c('el-dialog',{attrs:{"width":"30%","title":"设置权限","visible":_vm.innerVisible,"center":"","append-to-body":""},on:{"update:visible":function($event){_vm.innerVisible=$event}}},[_c('section',{staticClass:"change_container"},[_c('span',[_vm._v("部员阿勇:")]),_vm._v(" "),_c('select',[_c('option',{attrs:{"value":"干事"}},[_vm._v("干事")]),_vm._v(" "),_c('option',{attrs:{"value":"老干事"}},[_vm._v("老干事")]),_vm._v(" "),_c('option',{attrs:{"value":"第一负责人"}},[_vm._v("第一负责人")]),_vm._v(" "),_c('option',{attrs:{"value":"第二负责人"}},[_vm._v("第二负责人")])]),_vm._v(" "),_c('p',[_vm._v("注:设置干事为第一负责人或第二负责人默认换届")])]),_vm._v(" "),_c('span',{staticClass:"dialog-footer",attrs:{"slot":"footer"},slot:"footer"},[_c('el-button',{on:{"click":function($event){_vm.innerVisible = false}}},[_vm._v("取 消")]),_vm._v(" "),_c('el-button',{attrs:{"type":"primary"},on:{"click":function($event){_vm.innerVisible = false}}},[_vm._v("确 定")])],1)]),_vm._v(" "),_c('el-pagination',{staticStyle:{"text-align":"center"},attrs:{"current-page":_vm.currentPage1,"page-size":100,"layout":"total, prev, pager, next","total":1000},on:{"size-change":_vm.handleSizeChange,"current-change":_vm.handleCurrentChange,"update:currentPage":function($event){_vm.currentPage1=$event},"update:current-page":function($event){_vm.currentPage1=$event}}}),_vm._v(" "),_c('span',{staticClass:"dialog-footer",attrs:{"slot":"footer"},slot:"footer"},[_c('el-button',{on:{"click":function($event){_vm.centerDialogVisible = false}}},[_vm._v("取 消")]),_vm._v(" "),_c('el-button',{attrs:{"type":"primary"},on:{"click":function($event){_vm.centerDialogVisible = false}}},[_vm._v("确 定")])],1)],1)],1)}
var staticRenderFns = [function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('header',[_c('section',{staticClass:"AdminDapartment_header"},[_vm._v("部门管理")])])},function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('aside',[_c('h1',[_vm._v("我是侧边栏")])])}]
var esExports = { render: render, staticRenderFns: staticRenderFns }
/* harmony default export */ var Department_AdminDepartment = (esExports);
// CONCATENATED MODULE: ./src/components/Department/AdminDepartment.vue
function injectStyle (ssrContext) {
  __webpack_require__("HIFX")
}
var normalizeComponent = __webpack_require__("VU/8")
/* script */


/* template */

/* template functional */
var __vue_template_functional__ = false
/* styles */
var __vue_styles__ = injectStyle
/* scopeId */
var __vue_scopeId__ = "data-v-2f2dfc08"
/* moduleIdentifier (server only) */
var __vue_module_identifier__ = null
var Component = normalizeComponent(
  AdminDepartment,
  Department_AdminDepartment,
  __vue_template_functional__,
  __vue_styles__,
  __vue_scopeId__,
  __vue_module_identifier__
)

/* harmony default export */ var components_Department_AdminDepartment = __webpack_exports__["default"] = (Component.exports);


/***/ }),

/***/ "HIFX":
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ "lQEl":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony default export */ __webpack_exports__["a"] = ({
  data: function data() {
    return {
      image: "",
      imageUrl: ''
    };
  },

  methods: {
    //上传事件
    CoverImgUpload: function CoverImgUpload(e) {
      var _this = this;

      var Formdata = new FormData();
      Formdata.append("multipartFile", e.file);
      this.$axios({
        url: e.action,
        data: Formdata,
        method: "POST",
        headers: {
          "Content-Type": "multipart/form-data"
        }
      }).then(function (res) {
        _this.image = res.data.result;
        _this.message("success", "上传成功");
        _this.UploadSuccess && _this.UploadSuccess();
      }).catch(function (err) {
        _this.message('warning', "上传失败");
      });
    },
    beforeAvatarUpload: function beforeAvatarUpload(file) {
      var isLt2M = file.size / 1024 / 1024 < 2;
      if (!isLt2M) {
        this.$message.error("上传头像图片大小不能超过 2MB!");
      }
      return isLt2M;
    }
  }
});

/***/ })

});
//# sourceMappingURL=53.71d69f37fa51dfb4fef4.js.map