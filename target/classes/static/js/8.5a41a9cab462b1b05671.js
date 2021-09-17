webpackJsonp([8],{

/***/ "Fb5s":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony default export */ __webpack_exports__["a"] = ({
    data: function data() {
        return {
            //滑动校验提示
            accuracy: 1,
            text: '向右滑',
            msg: ''
        };
    },

    methods: {
        onFail: function onFail() {
            this.message("error", "校验失败");
            this.msg = '';
        },
        onRefresh: function onRefresh() {

            this.msg = '';
        },
        onFulfilled: function onFulfilled() {},
        onAgain: function onAgain() {
            this.msg = 'try again';
            // 刷新
            this.$refs.slideblock.reset();
        },
        handleClick: function handleClick() {
            // 父组件直接可以调用刷新方法
            this.$refs.slideblock.reset();
        }
    }
});

/***/ }),

/***/ "Mead":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function($) {/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__minxin_slide_verify_js__ = __webpack_require__("Fb5s");
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
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
    mixins: [__WEBPACK_IMPORTED_MODULE_0__minxin_slide_verify_js__["a" /* default */]],
    data: function data() {
        return {
            //滑动校验
            checkFlay: false,
            //按钮loading
            loadingFlay: false,
            //步骤
            step: 0,
            //弹出框
            dialogVisible: false,
            //邮箱
            email: ''
        };
    },

    methods: {
        onSuccess: function onSuccess(times) {
            this.dialogVisible = false;
            this.step = 1;
            this.message("success", "\u6821\u9A8C\u6210\u529F,\u8017\u65F6" + (times / 1000).toFixed(1) + "s");
            this.msg = "\u6821\u9A8C\u6210\u529F, \u8017\u65F6" + (times / 1000).toFixed(1) + "s";
        },

        //校验邮箱
        checkEmail: function checkEmail() {
            if (this.email == "") {
                this.message("warning", "邮箱不能为空");
                return false;
            } else {
                var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/g;
                if (reg.test(this.email)) {
                    return true;
                } else {
                    this.message("warning", "邮箱格式错误");
                    return false;
                }
            }
        },
        handleNext: function handleNext() {
            if (this.step == 0) {
                //  if(this.checkEmail()){
                this.dialogVisible = true;
                if (this.checkFlay) {}
                //  }
            } else if (this.step == 1) {
                this.step++;
            }
        }
    },
    watch: {
        step: function step(newV, orderV) {
            console.log(newV);
            console.log(orderV);
        }
    },
    components: {
        Footer: function Footer() {
            return __webpack_require__.e/* import() */(47/* duplicate */).then(__webpack_require__.bind(null, "7Xp9"));
        }
    },
    mounted: function mounted() {
        $(".help>span").hover(function () {
            $(".tips").slideDown();
        }, function () {
            $(".tips").slideUp();
        });
    }
});
/* WEBPACK VAR INJECTION */}.call(__webpack_exports__, __webpack_require__("7t+N")))

/***/ }),

/***/ "S6Z3":
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__.p + "static/img/bridge.ec47bc5.jpg";

/***/ }),

/***/ "vv/M":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });

// EXTERNAL MODULE: ./node_modules/babel-loader/lib!./node_modules/vue-loader/lib/selector.js?type=script&index=0!./src/components/public/ForgetpassWord.vue
var ForgetpassWord = __webpack_require__("Mead");

// CONCATENATED MODULE: ./node_modules/vue-loader/lib/template-compiler?{"id":"data-v-081dabb2","hasScoped":true,"transformToRequire":{"video":["src","poster"],"source":"src","img":"src","image":"xlink:href"},"buble":{"transforms":{}}}!./node_modules/vue-loader/lib/selector.js?type=template&index=0!./src/components/public/ForgetpassWord.vue
var render = function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',{staticStyle:{"height":"100%","position":"relative"}},[_c('header',[_c('nav',[_c('section',{staticClass:"logo"},[_c('img',{attrs:{"src":__webpack_require__("S6Z3"),"alt":"请检查网络"}}),_vm._v(" "),_c('span',[_c('router-link',{attrs:{"to":"/login"}},[_vm._v("返回登陆")])],1)]),_vm._v(" "),_vm._m(0)])]),_vm._v(" "),_c('main',[_c('section',{staticClass:"Forget_container"},[_vm._m(1),_vm._v(" "),_c('section',{staticClass:"container_main"},[_c('section',{staticClass:"main_form"},[(_vm.step==0)?_c('section',[_c('span',[_vm._v("请输入要重置密码的账号邮箱")]),_vm._v(" "),_c('input',{directives:[{name:"model",rawName:"v-model",value:(_vm.email),expression:"email"}],attrs:{"type":"email","placeholder":"请输入邮箱"},domProps:{"value":(_vm.email)},on:{"input":function($event){if($event.target.composing){ return; }_vm.email=$event.target.value}}})]):(_vm.step==1)?_c('section',[_c('span',[_vm._v("请输入验证码")]),_vm._v(" "),_c('input',{attrs:{"type":"text","placeholder":"请输入验证码"}})]):_c('section',[_c('span',[_vm._v("新密码")]),_vm._v(" "),_c('input',{attrs:{"type":"password","placeholder":"请输入密码"}}),_vm._v(" "),_c('span',[_vm._v("确认密码")]),_vm._v(" "),_c('input',{attrs:{"type":"password","placeholder":"确认密码"}})]),_vm._v(" "),_c('el-button',{attrs:{"type":"primary","loading":_vm.loadingFlay},on:{"click":_vm.handleNext}},[_vm._v("下一步")])],1)])]),_vm._v(" "),_c('aside')]),_vm._v(" "),_c('footer',[_c('Footer')],1),_vm._v(" "),_c('el-dialog',{attrs:{"center":"","title":"请校验","visible":_vm.dialogVisible,"width":"358px"},on:{"update:visible":function($event){_vm.dialogVisible=$event}}},[_c('slide-verify',{ref:"slideblock",attrs:{"accuracy":_vm.accuracy,"slider-text":_vm.text},on:{"again":_vm.onAgain,"fulfilled":_vm.onFulfilled,"success":_vm.onSuccess,"fail":_vm.onFail,"refresh":_vm.onRefresh}}),_vm._v(" "),_c('div',[_vm._v(_vm._s(_vm.msg))]),_vm._v(" "),_c('span',{staticClass:"dialog-footer",attrs:{"slot":"footer"},slot:"footer"})],1)],1)}
var staticRenderFns = [function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('section',{staticClass:"help"},[_c('span',[_vm._v("\n                        出现问题,无法找回?\n                        "),_c('section',{staticClass:"tips"},[_c('span',[_vm._v("请联系管理员")]),_vm._v(" "),_c('span',[_vm._v("QQ:123456")]),_vm._v(" "),_c('span',[_vm._v("微信:2666")])])]),_vm._v(" "),_c('span'),_vm._v(" "),_c('span')])},function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('section',{staticClass:"container_header"},[_c('span',[_vm._v("输入账号")])])}]
var esExports = { render: render, staticRenderFns: staticRenderFns }
/* harmony default export */ var public_ForgetpassWord = (esExports);
// CONCATENATED MODULE: ./src/components/public/ForgetpassWord.vue
function injectStyle (ssrContext) {
  __webpack_require__("xNIp")
}
var normalizeComponent = __webpack_require__("VU/8")
/* script */


/* template */

/* template functional */
var __vue_template_functional__ = false
/* styles */
var __vue_styles__ = injectStyle
/* scopeId */
var __vue_scopeId__ = "data-v-081dabb2"
/* moduleIdentifier (server only) */
var __vue_module_identifier__ = null
var Component = normalizeComponent(
  ForgetpassWord["a" /* default */],
  public_ForgetpassWord,
  __vue_template_functional__,
  __vue_styles__,
  __vue_scopeId__,
  __vue_module_identifier__
)

/* harmony default export */ var components_public_ForgetpassWord = __webpack_exports__["default"] = (Component.exports);


/***/ }),

/***/ "xNIp":
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ })

});
//# sourceMappingURL=8.5a41a9cab462b1b05671.js.map