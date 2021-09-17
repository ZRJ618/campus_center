webpackJsonp([22],{

/***/ "FFjP":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function($) {/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_regenerator__ = __webpack_require__("Xxa5");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_regenerator___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_babel_runtime_regenerator__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_asyncToGenerator__ = __webpack_require__("exGp");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_asyncToGenerator___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_asyncToGenerator__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__api_data__ = __webpack_require__("Foau");


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


/* harmony default export */ __webpack_exports__["a"] = ({
  name: 'login',
  data: function data() {
    return {
      //表单数据
      formData: {
        studentId: '',
        password: '',
        code: ''
      },

      // show:true,
      // content: "解惑|求真|娱乐|做实事我们是认真的|",
      width: 1500,
      height: 1000,
      fontSize: 180,
      time: 2000
    };
  },

  computed: {
    checkForm: function checkForm() {
      if (this.formData.studentId.trim() == "") {
        this.message('warning', '账号不能为空');
        return false;
      } else {
        if (this.formData.password.trim() == "") {
          this.message('warning', '密码不能为空');
          return false;
        } else {
          if (this.formData.code.trim() == "") {
            this.message("warning", "验证码不能为空");
            return false;
          } else {
            return true;
          }
        }
      }
    }
  },
  methods: {
    //查看密码
    handleText: function handleText() {
      $(".icon").removeClass("icon-zhengyan").addClass("icon-biyan");
      $(".login_psd input").attr("type", "text");
    },

    //屏蔽密码
    handlePsd: function handlePsd() {
      $(".icon").removeClass("icon-biyan").addClass("icon-zhengyan");
      $(".login_psd input").attr("type", "password");
    },

    //提交表单事件
    handleSumbit: function handleSumbit() {
      var _this = this;

      return __WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_asyncToGenerator___default()( /*#__PURE__*/__WEBPACK_IMPORTED_MODULE_0_babel_runtime_regenerator___default.a.mark(function _callee() {
        var result;
        return __WEBPACK_IMPORTED_MODULE_0_babel_runtime_regenerator___default.a.wrap(function _callee$(_context) {
          while (1) {
            switch (_context.prev = _context.next) {
              case 0:
                if (!_this.checkForm) {
                  _context.next = 6;
                  break;
                }

                _context.next = 3;
                return Object(__WEBPACK_IMPORTED_MODULE_2__api_data__["E" /* Login */])({
                  studentId: _this.formData.studentId,
                  password: _this.formData.password,
                  check: _this.formData.code,
                  confirmCheck: _this.formData.code
                });

              case 3:
                result = _context.sent;

                console.log(result["data"].result);
                if (result["data"].code == "200") {
                  _this.message('success', '登录成功');
                  console.log(result["data"]);
                  localStorage.setItem("token", result["data"].result.token);
                  _this.$store.commit("handleLogin");
                  console.log(result["data"].result);
                  _this.$store.commit("handleUser", {
                    user: result["data"].result });
                  _this.$router.push({
                    name: "index"
                  });
                } else {
                  _this.message("error", '\u767B\u5F55\u5931\u8D25,' + result["data"].result);
                }

              case 6:
              case 'end':
                return _context.stop();
            }
          }
        }, _callee, _this);
      }))();
    }
  },
  components: {
    Footer: function Footer() {
      return __webpack_require__.e/* import() */(47/* duplicate */).then(__webpack_require__.bind(null, "7Xp9"));
    }
  }
});
/* WEBPACK VAR INJECTION */}.call(__webpack_exports__, __webpack_require__("7t+N")))

/***/ }),

/***/ "fiWk":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });

// EXTERNAL MODULE: ./node_modules/babel-loader/lib!./node_modules/vue-loader/lib/selector.js?type=script&index=0!./src/components/public/Login.vue
var Login = __webpack_require__("FFjP");

// CONCATENATED MODULE: ./node_modules/vue-loader/lib/template-compiler?{"id":"data-v-2f03cf15","hasScoped":true,"transformToRequire":{"video":["src","poster"],"source":"src","img":"src","image":"xlink:href"},"buble":{"transforms":{}}}!./node_modules/vue-loader/lib/selector.js?type=template&index=0!./src/components/public/Login.vue
var render = function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',{staticStyle:{"height":"100%"}},[_c('div',{attrs:{"id":"shape-shifter"}},[_c('div',{staticClass:"loginform"},[_c('h2',[_vm._v("登录界面")]),_vm._v(" "),_c('div',{staticClass:"myform"},[_c('form',[_c('div',{staticClass:"login_number"},[_c('span',{staticClass:"iconfont icon-shenfenzhenghaoma",staticStyle:{"font-size":"24px","color":"#409EFF"}}),_vm._v(" "),_c('input',{directives:[{name:"model",rawName:"v-model",value:(_vm.formData.studentId),expression:"formData.studentId"}],attrs:{"type":"text","autocomplete":"off","placeholder":"学号/手机号/账号","required":""},domProps:{"value":(_vm.formData.studentId)},on:{"input":function($event){if($event.target.composing){ return; }_vm.$set(_vm.formData, "studentId", $event.target.value)}}})]),_vm._v(" "),_c('div',{staticClass:"login_psd"},[_c('span',{staticClass:"iconfont icon-mimasuo",staticStyle:{"color":"#909399"}}),_vm._v(" "),_c('input',{directives:[{name:"model",rawName:"v-model",value:(_vm.formData.password),expression:"formData.password"}],attrs:{"type":"password","autocomplete":"off","placeholder":"密码","required":""},domProps:{"value":(_vm.formData.password)},on:{"input":function($event){if($event.target.composing){ return; }_vm.$set(_vm.formData, "password", $event.target.value)}}}),_vm._v(" "),_c('span',{staticClass:"iconfont icon-zhengyan icon",on:{"mousedown":_vm.handleText,"mouseup":_vm.handlePsd}})]),_vm._v(" "),_c('div',{staticClass:"login_code"},[_c('span',{staticClass:"iconfont icon-yanzhengma",staticStyle:{"color":"#67C23A"}}),_vm._v(" "),_c('input',{directives:[{name:"model",rawName:"v-model",value:(_vm.formData.code),expression:"formData.code"}],attrs:{"type":"password","autocomplete":"off","placeholder":"验证码","required":""},domProps:{"value":(_vm.formData.code)},on:{"input":function($event){if($event.target.composing){ return; }_vm.$set(_vm.formData, "code", $event.target.value)}}})]),_vm._v(" "),_c('div',{staticClass:"submit_btn"},[_c('el-button',{attrs:{"type":"primary"},on:{"click":_vm.handleSumbit,"keyup":function($event){if(!$event.type.indexOf('key')&&_vm._k($event.keyCode,"enter",13,$event.key,"Enter")){ return null; }return _vm.handleSumbit($event)}}},[_vm._v("登录")])],1)]),_vm._v(" "),_c('div',{staticClass:"register"},[_c('span',[_c('router-link',{attrs:{"to":"/ForgetpassWord"}},[_vm._v("忘记密码?")])],1),_vm._v(" "),_c('span',[_vm._v("暂无账号?")]),_c('router-link',{attrs:{"to":"/register"}},[_vm._v("去注册")])],1)])])]),_vm._v(" "),_c('footer',[_c('Footer',{attrs:{"Backcolor":"#69b4ca","color":"#303133"}})],1)])}
var staticRenderFns = []
var esExports = { render: render, staticRenderFns: staticRenderFns }
/* harmony default export */ var public_Login = (esExports);
// CONCATENATED MODULE: ./src/components/public/Login.vue
function injectStyle (ssrContext) {
  __webpack_require__("gDTF")
}
var normalizeComponent = __webpack_require__("VU/8")
/* script */


/* template */

/* template functional */
var __vue_template_functional__ = false
/* styles */
var __vue_styles__ = injectStyle
/* scopeId */
var __vue_scopeId__ = "data-v-2f03cf15"
/* moduleIdentifier (server only) */
var __vue_module_identifier__ = null
var Component = normalizeComponent(
  Login["a" /* default */],
  public_Login,
  __vue_template_functional__,
  __vue_styles__,
  __vue_scopeId__,
  __vue_module_identifier__
)

/* harmony default export */ var components_public_Login = __webpack_exports__["default"] = (Component.exports);


/***/ }),

/***/ "gDTF":
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ })

});
//# sourceMappingURL=22.03e1c3a86f5aa7ac7527.js.map