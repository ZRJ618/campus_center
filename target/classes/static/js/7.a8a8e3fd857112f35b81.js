webpackJsonp([7],{

/***/ "39gl":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });

// EXTERNAL MODULE: ./node_modules/babel-loader/lib!./node_modules/vue-loader/lib/selector.js?type=script&index=0!./src/components/public/Myindex.vue
var Myindex = __webpack_require__("HXlw");

// CONCATENATED MODULE: ./node_modules/vue-loader/lib/template-compiler?{"id":"data-v-2c1ac0f3","hasScoped":true,"transformToRequire":{"video":["src","poster"],"source":"src","img":"src","image":"xlink:href"},"buble":{"transforms":{}}}!./node_modules/vue-loader/lib/selector.js?type=template&index=0!./src/components/public/Myindex.vue
var render = function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',{staticClass:"myindex_container"},[_c('section',{staticClass:"person_container"},[_c('img',{attrs:{"src":!_vm.user.selfImage?'../../../static/images/user.png':_vm.user.selfImage,"alt":"请检查网络"}}),_vm._v(" "),_c('section',{staticClass:"person_data"},[_c('section',{staticClass:"info_person"},[_c('section',{staticClass:"info_user"},[_c('span',[_vm._v(_vm._s(_vm.user.userName))]),_vm._v(" "),_c('span',{staticClass:"person_autograph"})]),_vm._v(" "),_c('a',{attrs:{"href":"javascript:;"},on:{"click":_vm.handleWatch}},[_vm._v("点击查看详细信息")]),_vm._v(" "),_c('el-button',{style:({'right':_vm.modify? '100px' : ''}),attrs:{"icon":_vm.modify?'': 'el-icon-edit',"type":"primary"},on:{"click":_vm.handleModify}},[_vm._v(_vm._s(_vm.modify?'保存':'编辑个人信息'))]),_vm._v(" "),(_vm.modify)?_c('el-button',{staticStyle:{"right":"20px"},on:{"click":_vm.handleCanle}},[_vm._v("取消")]):_vm._e(),_vm._v(" "),_c('section',{staticClass:"total_info"},_vm._l((_vm.Userinfo),function(value,index){return _c('section',{key:value.icon,staticClass:"info_data"},[_c('span',{class:value.icon}),_vm._v(" "),(index!=7)?_c('input',{directives:[{name:"model",rawName:"v-model",value:(value.value),expression:"value.value"}],attrs:{"type":"text","readonly":""},domProps:{"value":(value.value)},on:{"input":function($event){if($event.target.composing){ return; }_vm.$set(value, "value", $event.target.value)}}}):_c('select',{directives:[{name:"model",rawName:"v-model",value:(value.value),expression:"value.value"}],attrs:{"disabled":""},on:{"change":function($event){var $$selectedVal = Array.prototype.filter.call($event.target.options,function(o){return o.selected}).map(function(o){var val = "_value" in o ? o._value : o.value;return val}); _vm.$set(value, "value", $event.target.multiple ? $$selectedVal : $$selectedVal[0])}}},[_c('option',{attrs:{"value":"女"}},[_vm._v("女")]),_vm._v(" "),_c('option',{attrs:{"value":"男"}},[_vm._v("男")])])])}),0)],1)])]),_vm._v(" "),_c('section',{staticClass:"info_container"},[_c('section',{staticClass:"info_header"},[_c('ul',_vm._l((_vm.nav),function(value,index){return _c('router-link',{key:index,class:{activer:_vm.router==value.path},attrs:{"tag":"li","to":{path:value.path}}},[_vm._v(" "+_vm._s(value.title))])}),1)]),_vm._v(" "),_c('section',{staticClass:"info_mainer"},[_c('router-view')],1)]),_vm._v(" "),_c('el-dialog',{attrs:{"title":"校验","visible":_vm.visible,"width":"360px","center":""},on:{"update:visible":function($event){_vm.visible=$event}}},[_c('slide-verify',{ref:"slideblock",attrs:{"accuracy":_vm.accuracy,"slider-text":_vm.text},on:{"again":_vm.onAgain,"fulfilled":_vm.onFulfilled,"success":_vm.onSuccess,"fail":_vm.onFail,"refresh":_vm.onRefresh}}),_vm._v(" "),_c('div',[_vm._v(_vm._s(_vm.msg))])],1)],1)}
var staticRenderFns = []
var esExports = { render: render, staticRenderFns: staticRenderFns }
/* harmony default export */ var public_Myindex = (esExports);
// CONCATENATED MODULE: ./src/components/public/Myindex.vue
function injectStyle (ssrContext) {
  __webpack_require__("iS57")
}
var normalizeComponent = __webpack_require__("VU/8")
/* script */


/* template */

/* template functional */
var __vue_template_functional__ = false
/* styles */
var __vue_styles__ = injectStyle
/* scopeId */
var __vue_scopeId__ = "data-v-2c1ac0f3"
/* moduleIdentifier (server only) */
var __vue_module_identifier__ = null
var Component = normalizeComponent(
  Myindex["a" /* default */],
  public_Myindex,
  __vue_template_functional__,
  __vue_styles__,
  __vue_scopeId__,
  __vue_module_identifier__
)

/* harmony default export */ var components_public_Myindex = __webpack_exports__["default"] = (Component.exports);


/***/ }),

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

/***/ "HXlw":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function($) {/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_regenerator__ = __webpack_require__("Xxa5");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_regenerator___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_babel_runtime_regenerator__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_asyncToGenerator__ = __webpack_require__("exGp");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_asyncToGenerator___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_asyncToGenerator__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__minxin_slide_verify__ = __webpack_require__("Fb5s");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__api_data__ = __webpack_require__("Foau");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__api_check__ = __webpack_require__("sQkU");


//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//




var AnimateMove = false;
var user = {};
/* harmony default export */ __webpack_exports__["a"] = ({
    mixins: [__WEBPACK_IMPORTED_MODULE_2__minxin_slide_verify__["a" /* default */]],
    data: function data() {
        return {
            //校验状态
            checkFlay: false,
            //校验跳出框
            visible: false,
            //修改状态
            modify: false,
            //个性签名修改状态
            edit: true,
            //路由path
            router: '',
            //签名
            autograph: "啦啦啦啦啦",
            //个人信息
            Userinfo: [{
                icon: 'iconfont icon-yonghu',
                value: ''
            }, {
                icon: 'iconfont icon-shenfenzhenghaoma',
                value: ''
            }, {
                icon: 'iconfont  icon-xingming',
                value: ''
            }, {
                icon: 'iconfont icon-icon-mail',
                value: ''
            }, {
                icon: 'iconfont icon-shouji',
                value: ''
            }, {
                icon: 'iconfont icon-shengrix',
                value: ''
            }, {
                icon: 'iconfont icon-zhuanye',
                value: '',
                label: 'major'
            }, {
                icon: 'iconfont icon-xingbie',
                value: ''
            }],
            //路由菜单
            nav: [{
                title: '动态',
                path: '/people/index/trends',
                value: ''
            }, {
                title: '文章',
                path: '/people/index/article',
                value: ''
            }, {
                title: '提问',
                path: '/people/index/question',
                value: ''
            }, {
                title: '关注',
                path: '/people/index/core',
                value: ''
            }, {
                title: '粉丝',
                path: '/people/index/fans',
                value: ''
            }, {
                title: '收藏',
                path: '/people/index/collection',
                value: ''
            }, {
                title: '发布',
                path: '/people/index/release',
                value: ''
            }]

        };
    },

    methods: {
        //编辑签名事件
        handleEdit: function handleEdit() {
            this.edit = false;
            console.log("111");
        },

        //校验成功
        onSuccess: function onSuccess(times) {
            var _this = this;

            return __WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_asyncToGenerator___default()( /*#__PURE__*/__WEBPACK_IMPORTED_MODULE_0_babel_runtime_regenerator___default.a.mark(function _callee() {
                var result;
                return __WEBPACK_IMPORTED_MODULE_0_babel_runtime_regenerator___default.a.wrap(function _callee$(_context) {
                    while (1) {
                        switch (_context.prev = _context.next) {
                            case 0:
                                _this.message("success", "\u6821\u9A8C\u6210\u529F,\u8017\u65F6" + (times / 1000).toFixed(1) + "s");
                                _this.msg = "\u6821\u9A8C\u6210\u529F, \u8017\u65F6" + (times / 1000).toFixed(1) + "s";
                                setTimeout(function () {
                                    _this.visible = false;
                                    _this.$refs.slideblock.reset();
                                    _this.msg = "";
                                }, 1000);
                                _this.checkFlay = true;

                                result = Object(__WEBPACK_IMPORTED_MODULE_3__api_data__["u" /* FixSelfInfo */])({
                                    studentId: _this.Userinfo[1].value,
                                    userName: _this.Userinfo[0].value,
                                    realName: _this.Userinfo[2].value,
                                    sex: _this.Userinfo[7].value,
                                    birthday: _this.Userinfo[5].value,
                                    major: _this.Userinfo[6].value,
                                    mobilePhone: _this.Userinfo[4].value,
                                    email: _this.Userinfo[3].value
                                });

                                console.log(result);
                                //发送请求
                                // $(".info_data select").prop("disabled",true);
                                // $(".info_data input").prop("readonly",true);

                            case 6:
                            case "end":
                                return _context.stop();
                        }
                    }
                }, _callee, _this);
            }))();
        },

        //点击取消退出编辑事件
        handleCanle: function handleCanle() {
            this.Userinfo.forEach(function (item, index) {
                switch (index) {
                    case 0:
                        item.value = user.userName;break;
                    case 1:
                        item.value = user.studentId;break;
                    case 2:
                        item.value = user.userName;break;
                    case 3:
                        item.value = user.email;break;
                    case 4:
                        item.value = user.mobilePhone;break;
                    case 5:
                        item.value = user.birthday;break;
                    case 6:
                        item.value = user.major;break;
                    case 7:
                        item.value = user.sex;break;
                }
            });
            this.modify = false;
            $(".info_data select").prop("disabled", true);
            $(".info_data input").prop("readonly", true);
            this.message("info", "退出编辑");
        },

        //点击查看详细信息
        handleWatch: function handleWatch() {
            if (!AnimateMove) {
                $(".person_data").animate({ "height": "+=410px" }, 500);
                AnimateMove = true;
            } else {
                if (this.modify) {
                    this.message("info", "退出编辑");
                }
                this.modify = false;
                AnimateMove = false;
                $(".info_data select").prop("disabled", true);
                $(".info_data input").prop("readonly", true);
                $(".person_data").animate({ "height": "-=410px" }, 500);
            }
        },

        //点击修改按钮
        handleModify: function handleModify() {
            if (!this.modify) {
                if (!AnimateMove) {
                    $(".person_data").animate({ "height": "+=410px" }, 500);
                    AnimateMove = true;
                }
                this.message("success", "开始编辑个人信息");
                $(".info_data select").prop("disabled", false);
                $(".info_data input").prop("readonly", false).eq(0).focus();
                this.modify = true;
            } else {
                if (Object(__WEBPACK_IMPORTED_MODULE_4__api_check__["g" /* checkUsername */])({ username: this.Userinfo[0].value, max: 10, min: 3 }) && Object(__WEBPACK_IMPORTED_MODULE_4__api_check__["d" /* checkPhone */])({ value: this.Userinfo[4].value }) && Object(__WEBPACK_IMPORTED_MODULE_4__api_check__["b" /* checkEmail */])({ value: this.Userinfo[3].value }) && Object(__WEBPACK_IMPORTED_MODULE_4__api_check__["e" /* checkRealname */])({ value: this.Userinfo[2].value }) && Object(__WEBPACK_IMPORTED_MODULE_4__api_check__["a" /* checkBrithday */])({ value: this.Userinfo[5].value }) && Object(__WEBPACK_IMPORTED_MODULE_4__api_check__["c" /* checkMajor */])({ value: this.Userinfo[6].value }) && Object(__WEBPACK_IMPORTED_MODULE_4__api_check__["f" /* checkStudentId */])({ value: this.Userinfo[1] })) {
                    this.visible = true;
                }
                this.Userinfo.forEach(function (item) {
                    console.log(item.value);
                });
            }
        }
    },
    mounted: function mounted() {
        $(".info_header li").on("click", function (e) {
            $(".info_header li").css({ "border-bottom": "none", "font-weight": "100" });
            e.target.style.borderBottom = "2px solid #409EFF";
            e.target.style.fontWeight = "bold ";
        });
    },
    created: function created() {
        this.user = this.$store.state.user;
        console.log(this.user);
        this.router = this.$route.path;
        user = this.$store.state.user;
        this.Userinfo.forEach(function (item, index) {
            switch (index) {
                case 0:
                    item.value = user.userName;break;
                case 1:
                    item.value = user.studentId;break;
                case 2:
                    item.value = user.userName;break;
                case 3:
                    item.value = user.email;break;
                case 4:
                    item.value = user.mobilePhone;break;
                case 5:
                    item.value = user.birthday;break;
                case 6:
                    item.value = user.major;break;
                case 7:
                    item.value = user.sex;break;
            }
        });
    }
});
/* WEBPACK VAR INJECTION */}.call(__webpack_exports__, __webpack_require__("7t+N")))

/***/ }),

/***/ "iS57":
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ "sQkU":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "g", function() { return checkUsername; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "d", function() { return checkPhone; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "b", function() { return checkEmail; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "e", function() { return checkRealname; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "c", function() { return checkMajor; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return checkBrithday; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "f", function() { return checkStudentId; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_element_ui__ = __webpack_require__("zL8q");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_element_ui___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_element_ui__);

function message(message) {
    var type = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : "error";

    __WEBPACK_IMPORTED_MODULE_0_element_ui___default.a.Message({
        type: type,
        message: message,
        offset: 100
    });
}

//校验用户名函数
var checkUsername = function checkUsername(_ref) {
    var username = _ref.username,
        max = _ref.max,
        min = _ref.min,
        _ref$require = _ref.require,
        require = _ref$require === undefined ? true : _ref$require;

    if (require || username != '') {
        if (username == "") {
            message("用户名不能为空");
            return false;
        } else if (username.length < min || username.length > max) {
            message('\u7528\u6237\u540D\u5728 ' + min + ' ~ ' + max + '\u4E4B\u95F4');
            return false;
        } else if (username.length > 3 && username.length < 10) {
            var parrern = /[`~!@#$%^&*()_\-+=<>?:"{}|,.\/;'\\[\]·~！@#￥%……&*（）——\-+={}|《》？：“”【】、；‘'，。、]/gim;
            var reg = /^[0-9]*$/g;
            if (parrern.test(username)) {
                message("用户名不能出现特殊符号");
                return false;
            } else if (reg.test(username)) {
                message("用户名不能全为数字");
                return false;
            } else {
                return true;
            }
        }
    } else {
        return true;
    }
};
//校验手机号函数
var checkPhone = function checkPhone(_ref2) {
    var value = _ref2.value,
        _ref2$require = _ref2.require,
        require = _ref2$require === undefined ? true : _ref2$require;

    // if(fn!=null){
    //      message=fn;
    // }
    if (require || value != '') {
        if (value == "") {
            message("手机号不能为空");
            return false;
        } else {
            var reg = /^(13[0-9]|14[5|7]|15[0|1|2|3|4|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9]|17[0|1|2|3|5|6|7|8|9])\d{8}$/g;
            if (!reg.test(value)) {
                message("手机格式错误");
                return false;
            } else {
                return true;
            }
        }
    } else {
        return true;
    }
};
//校验邮箱信息
var checkEmail = function checkEmail(_ref3) {
    var value = _ref3.value,
        _ref3$require = _ref3.require,
        require = _ref3$require === undefined ? true : _ref3$require;

    if (value != '' || require) {
        if (value == "") {
            message("邮箱不能为空");
            return false;
        } else {
            var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/g;
            if (reg.test(value)) {
                return true;
            } else {
                message("邮箱格式错误");
                return false;
            }
        }
    }
};
//校验用户真实姓名
var checkRealname = function checkRealname(_ref4) {
    var value = _ref4.value,
        _ref4$require = _ref4.require,
        require = _ref4$require === undefined ? true : _ref4$require;

    if (value != '' || require) {
        if (value == "") {
            message("真实姓名不能为空");
            return false;
        } else {
            if (value > 10) {
                message("姓名过长,特殊情况请联系管理员");
                return false;
            } else {
                var reg = /^[^0-9]*$/gim;
                if (!reg.test(value)) {
                    message("姓名不能出现数字");
                    return false;
                } else {
                    return true;
                }
            }
        }
    }
};
//校验用户年级
var checkMajor = function checkMajor(_ref5) {
    var value = _ref5.value,
        _ref5$require = _ref5.require,
        require = _ref5$require === undefined ? true : _ref5$require;

    if (value != '' || require) {
        if (value == "") {
            message("专业年级不能为空");
            return false;
        } else {
            return true;
        }
    } else {
        return true;
    }
};
//校验生日
var checkBrithday = function checkBrithday(_ref6) {
    var value = _ref6.value,
        _ref6$require = _ref6.require,
        require = _ref6$require === undefined ? true : _ref6$require;

    if (value != "" || require) {
        if (value == "") {
            message("生日不能为空");
            return false;
        } else {
            return true;
        }
    }
};
//校验学号
var checkStudentId = function checkStudentId(_ref7) {
    var value = _ref7.value,
        _ref7$require = _ref7.require,
        require = _ref7$require === undefined ? true : _ref7$require;

    console.log(value.value);
    if (value != "" || require) {
        if (value == " ") {
            message("学号不能为空");
            return false;
        } else {
            var reg = /^[0-9]{10}$/;
            if (reg.test(value)) {
                message("学号格式错误");
                return false;
            } else {
                return true;
            }
        }
    }
};

/***/ })

});
//# sourceMappingURL=7.a8a8e3fd857112f35b81.js.map