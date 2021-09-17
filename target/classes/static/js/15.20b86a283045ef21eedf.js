webpackJsonp([15],{

/***/ "/mog":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function($) {/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_regenerator__ = __webpack_require__("Xxa5");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_regenerator___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_babel_runtime_regenerator__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_asyncToGenerator__ = __webpack_require__("exGp");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_asyncToGenerator___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_asyncToGenerator__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__api_data__ = __webpack_require__("Foau");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__minxin_uploadImg__ = __webpack_require__("Lt+z");



var DepCheck = function () {
  var _ref = __WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_asyncToGenerator___default()( /*#__PURE__*/__WEBPACK_IMPORTED_MODULE_0_babel_runtime_regenerator___default.a.mark(function _callee3(ruleForm, image) {
    var result;
    return __WEBPACK_IMPORTED_MODULE_0_babel_runtime_regenerator___default.a.wrap(function _callee3$(_context3) {
      while (1) {
        switch (_context3.prev = _context3.next) {
          case 0:
            _context3.next = 2;
            return Object(__WEBPACK_IMPORTED_MODULE_2__api_data__["c" /* AddDepCheck */])({
              departmentId: ruleForm.departmentId,
              realName: ruleForm.name,
              grade: ruleForm.grade,
              imagePath: image
            });

          case 2:
            result = _context3.sent;
            return _context3.abrupt("return", result);

          case 4:
          case "end":
            return _context3.stop();
        }
      }
    }, _callee3, this);
  }));

  return function DepCheck(_x, _x2) {
    return _ref.apply(this, arguments);
  };
}();

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

var num = 4;


/* harmony default export */ __webpack_exports__["a"] = ({
  mixins: [__WEBPACK_IMPORTED_MODULE_3__minxin_uploadImg__["a" /* default */]],
  data: function data() {
    return {

      //上传照片类型
      filetype: "head",
      //父级部门
      departmentGrade: [],
      //子级部门
      departmentChild: [],
      //认证表单
      ruleForm: {
        name: '',
        grade: ''
      },
      //校验表单
      rules: {
        name: [{ required: true, message: '请输入姓名', trigger: 'blur' }],
        grade: [{ required: true, message: '请输入年级', trigger: 'blur' }]
      },
      activeName: ["1"],
      centerDialogVisible: false,
      activeNames: ["1"],
      //学生会主要职位
      post: ["学生会主席", "学生会副主席"],
      //子部门
      charge: ["第一负责人", "第二负责人", "干事"]
    };
  },

  methods: {
    //请求子部门
    handleChange: function handleChange(val) {
      var _this = this;

      return __WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_asyncToGenerator___default()( /*#__PURE__*/__WEBPACK_IMPORTED_MODULE_0_babel_runtime_regenerator___default.a.mark(function _callee() {
        var parentId, result;
        return __WEBPACK_IMPORTED_MODULE_0_babel_runtime_regenerator___default.a.wrap(function _callee$(_context) {
          while (1) {
            switch (_context.prev = _context.next) {
              case 0:
                if (!(typeof val != "string")) {
                  _context.next = 8;
                  break;
                }

                if (!(num != val)) {
                  _context.next = 8;
                  break;
                }

                num = val;
                parentId = _this.departmentGrade[val].departmentId;
                _context.next = 6;
                return Object(__WEBPACK_IMPORTED_MODULE_2__api_data__["B" /* GetDepList */])({ parentId: _this.departmentGrade[val].departmentId });

              case 6:
                result = _context.sent;

                _this.departmentChild = result["data"].result;

              case 8:
              case "end":
                return _context.stop();
            }
          }
        }, _callee, _this);
      }))();
    },

    //校验表单
    submitForm: function submitForm(formName) {
      var _this2 = this;

      this.$refs[formName].validate(function (valid) {
        if (valid && _this2.image != "") {
          DepCheck(_this2.ruleForm, _this2.image).then(function (res) {
            console.log(res);
            if (res["data"].code == "200") {
              _this2.message("success", "提交成功,请等待审核");
            } else {
              _this2.message("warning", "提交失败");
            }
          });
        } else {
          return false;
        }
      });
    },
    resetForm: function resetForm(formName) {
      this.$refs[formName].resetFields();
    },

    //核心职位
    handMainIdent: function handMainIdent(value) {
      $(".el-dialog__title").text(value + "\u8BA4\u8BC1");
      this.centerDialogVisible = true;
    },

    //显示认证职位
    Identifacationling: function Identifacationling(item, value) {
      Object.defineProperty(this.ruleForm, "departmentId", {
        value: item.departmentId
      });
      $(".el-dialog__title").text("" + item.departmentName + value + "\u8BA4\u8BC1");
      this.centerDialogVisible = true;
    }
  },
  mounted: function mounted() {
    $(".first .el-collapse-item__header").eq(0).css("font-size", "18px");
    $(".second .el-collapse-item__header").eq(0).css("font-size", "18px");
    $(".thead .el-collapse-item__header").eq(0).css("font-size", "18px");
  },
  created: function created() {
    var _this3 = this;

    return __WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_asyncToGenerator___default()( /*#__PURE__*/__WEBPACK_IMPORTED_MODULE_0_babel_runtime_regenerator___default.a.mark(function _callee2() {
      var result;
      return __WEBPACK_IMPORTED_MODULE_0_babel_runtime_regenerator___default.a.wrap(function _callee2$(_context2) {
        while (1) {
          switch (_context2.prev = _context2.next) {
            case 0:
              if (_this3.$store.state.identity != '') {
                _this3.message("warning", "已认证完成");
                setTimeout(function () {
                  _this3.$router.push({
                    name: "部门/我的部门"
                  });
                }, 1000);
              }
              //获取部门列表
              _context2.next = 3;
              return Object(__WEBPACK_IMPORTED_MODULE_2__api_data__["B" /* GetDepList */])({ departmentGrade: "一级部门" });

            case 3:
              result = _context2.sent;

              _this3.departmentGrade = result["data"].result;

            case 5:
            case "end":
              return _context2.stop();
          }
        }
      }, _callee2, _this3);
    }))();
  }
});
/* WEBPACK VAR INJECTION */}.call(__webpack_exports__, __webpack_require__("7t+N")))

/***/ }),

/***/ "Lt+z":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";

/* harmony default export */ __webpack_exports__["a"] = ({
  data: function data() {
    return {
      imageUrl: "",
      image: []
    };
  },

  methods: {
    //上传事件
    CoverImgUpload: function CoverImgUpload(e) {
      var _this = this;

      var Formdata = new FormData();
      Formdata.append("file", e.file);
      console.log(e);
      this.$axios({
        url: e.action,
        params: {
          type: this.filetype
        },
        data: Formdata,
        method: "POST",
        headers: {
          "Content-Type": "multipart/form-data"
        }
      }).then(function (res) {
        _this.image.push(res.data.result);
      }).catch(function (err) {
        console.log(err);
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

/***/ }),

/***/ "T3w6":
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ "t2Bb":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });

// EXTERNAL MODULE: ./node_modules/babel-loader/lib!./node_modules/vue-loader/lib/selector.js?type=script&index=0!./src/components/Department/Identification.vue
var Identification = __webpack_require__("/mog");

// CONCATENATED MODULE: ./node_modules/vue-loader/lib/template-compiler?{"id":"data-v-58dff01a","hasScoped":true,"transformToRequire":{"video":["src","poster"],"source":"src","img":"src","image":"xlink:href"},"buble":{"transforms":{}}}!./node_modules/vue-loader/lib/selector.js?type=template&index=0!./src/components/Department/Identification.vue
var render = function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',[_c('div',{staticClass:"Identification_header"},[_vm._v("认证")]),_vm._v(" "),_c('div',{staticClass:"Identification_container"},[_c('el-collapse',{attrs:{"accordion":""},on:{"change":_vm.handleChange},model:{value:(_vm.activeNames),callback:function ($$v) {_vm.activeNames=$$v},expression:"activeNames"}},_vm._l((_vm.departmentGrade),function(value,index){return _c('el-collapse-item',{key:value.departmentId,attrs:{"title":value.departmentName,"name":index}},[_c('el-collapse',{attrs:{"accordion":""},model:{value:(_vm.activeName),callback:function ($$v) {_vm.activeName=$$v},expression:"activeName"}},_vm._l((_vm.departmentChild),function(item,index){return _c('el-collapse-item',{key:index,attrs:{"title":item.departmentName,"name":index+1}},_vm._l((_vm.charge),function(value,key){return _c('div',{key:key,staticClass:"Department_post"},[_vm._v("\n              "+_vm._s(value)+"\n              "),_c('div',{staticClass:"Identification_btn"},[_c('el-button',{attrs:{"type":"danger","size":"mini"},on:{"click":function($event){return _vm.Identifacationling(item,value)}}},[_vm._v("去认证")])],1)])}),0)}),1)],1)}),1)],1),_vm._v(" "),_c('el-dialog',{attrs:{"title":"认证","visible":_vm.centerDialogVisible,"width":"800px","center":""},on:{"update:visible":function($event){_vm.centerDialogVisible=$event}}},[_c('div',{staticClass:"Identification_form"},[_c('div',{staticStyle:{"width":"80%"}},[_c('el-form',{ref:"ruleForm",staticClass:"demo-ruleForm",attrs:{"model":_vm.ruleForm,"rules":_vm.rules,"label-width":"100px"}},[_c('el-form-item',{attrs:{"label":"姓名:","prop":"name"}},[_c('el-input',{model:{value:(_vm.ruleForm.name),callback:function ($$v) {_vm.$set(_vm.ruleForm, "name", $$v)},expression:"ruleForm.name"}})],1),_vm._v(" "),_c('el-form-item',{attrs:{"label":"年级:","prop":"grade"}},[_c('el-input',{model:{value:(_vm.ruleForm.grade),callback:function ($$v) {_vm.$set(_vm.ruleForm, "grade", $$v)},expression:"ruleForm.grade"}})],1),_vm._v(" "),_c('div',{staticClass:"Identification_img"},[_c('span',{staticStyle:{"color":"#606266"}},[_vm._v("工作证照:")]),_vm._v(" "),_c('div',{staticClass:"upload_container"},[_c('el-upload',{staticClass:"avatar-uploader",attrs:{"limit":2,"list-type":"picture-card","multiple":"","action":"/image/uploadImageSingle","show-file-list":true,"before-upload":_vm.beforeAvatarUpload,"http-request":_vm.CoverImgUpload}},[(_vm.imageUrl)?_c('img',{staticClass:"avatar",attrs:{"src":_vm.imageUrl}}):_c('i',{staticClass:"el-icon-plus avatar-uploader-icon",staticStyle:{"margin":"-20px"}})])],1)]),_vm._v(" "),_c('span',{staticStyle:{"text-indent":"100px","display":"block","margin-top":"10px","color":"red"}},[_vm._v("注:上传照片需要工作证正反面")])],1)],1)]),_vm._v(" "),_c('span',{staticClass:"dialog-footer",attrs:{"slot":"footer"},slot:"footer"},[_c('el-button',{on:{"click":function($event){_vm.centerDialogVisible = false}}},[_vm._v("取 消")]),_vm._v(" "),_c('el-button',{attrs:{"type":"primary"},on:{"click":function($event){return _vm.submitForm('ruleForm')}}},[_vm._v("确 定")])],1)])],1)}
var staticRenderFns = []
var esExports = { render: render, staticRenderFns: staticRenderFns }
/* harmony default export */ var Department_Identification = (esExports);
// CONCATENATED MODULE: ./src/components/Department/Identification.vue
function injectStyle (ssrContext) {
  __webpack_require__("T3w6")
}
var normalizeComponent = __webpack_require__("VU/8")
/* script */


/* template */

/* template functional */
var __vue_template_functional__ = false
/* styles */
var __vue_styles__ = injectStyle
/* scopeId */
var __vue_scopeId__ = "data-v-58dff01a"
/* moduleIdentifier (server only) */
var __vue_module_identifier__ = null
var Component = normalizeComponent(
  Identification["a" /* default */],
  Department_Identification,
  __vue_template_functional__,
  __vue_styles__,
  __vue_scopeId__,
  __vue_module_identifier__
)

/* harmony default export */ var components_Department_Identification = __webpack_exports__["default"] = (Component.exports);


/***/ })

});
//# sourceMappingURL=15.20b86a283045ef21eedf.js.map