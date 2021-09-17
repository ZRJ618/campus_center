webpackJsonp([12],{

/***/ "/9hu":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function($) {/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_promise__ = __webpack_require__("//Fk");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_promise___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_promise__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator__ = __webpack_require__("Xxa5");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator__ = __webpack_require__("exGp");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__api_data__ = __webpack_require__("Foau");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__IndexHeader__ = __webpack_require__("EGO1");




//获取用户信息
var GetShowUSerInfo = function () {
    var _ref = __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator___default()( /*#__PURE__*/__WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.mark(function _callee3(userId) {
        var result;
        return __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.wrap(function _callee3$(_context3) {
            while (1) {
                switch (_context3.prev = _context3.next) {
                    case 0:
                        _context3.next = 2;
                        return Object(__WEBPACK_IMPORTED_MODULE_3__api_data__["V" /* ShowUSerInfo */])(userId);

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

    return function GetShowUSerInfo(_x) {
        return _ref.apply(this, arguments);
    };
}();
//是否关注


var getIsFocus = function () {
    var _ref2 = __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator___default()( /*#__PURE__*/__WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.mark(function _callee4(userId) {
        var result;
        return __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.wrap(function _callee4$(_context4) {
            while (1) {
                switch (_context4.prev = _context4.next) {
                    case 0:
                        _context4.next = 2;
                        return Object(__WEBPACK_IMPORTED_MODULE_3__api_data__["G" /* IsFocus */])({ userId: userId });

                    case 2:
                        result = _context4.sent;
                        return _context4.abrupt("return", result);

                    case 4:
                    case "end":
                        return _context4.stop();
                }
            }
        }, _callee4, this);
    }));

    return function getIsFocus(_x2) {
        return _ref2.apply(this, arguments);
    };
}();



/* harmony default export */ __webpack_exports__["a"] = ({
    data: function data() {
        return {
            isLoading: false,
            //记录用户Id
            userId: "",
            //是否关注
            isFans: false,
            //记录路由信息
            router: '',
            //存储用户信息
            user: {},
            //查看信息标识
            watchDetail: false,
            //图标还有数据
            Userinfo: [{
                icon: 'iconfont icon-guanzhu',
                value: ''
            }, {
                icon: 'iconfont icon-fensipa',
                value: ''
            }, {
                icon: 'iconfont icon-canjiagongzuoshijian',
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
            //导航菜单
            nav: [{
                title: '动态',
                path: '/people/other/trends',
                value: ''
            }, {
                title: '文章',
                path: '/people/other/article',
                value: ''
            }, {
                title: '提问',
                path: '/people/other/question',
                value: ''
            }, {
                title: '发布',
                path: '/people/other/release',
                value: ''
            }]

        };
    },

    methods: {
        //查看详细信息
        handleWatch: function handleWatch() {
            if (!this.watchDetail) {
                $(".info_container").animate({ "height": "+=240" });
                this.watchDetail = true;
            } else {
                $(".info_container").animate({ "height": "-=240" });
                this.watchDetail = false;
            }
        },

        //取消关注某人
        handleCancelFocus: function handleCancelFocus() {
            var _this = this;

            return __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator___default()( /*#__PURE__*/__WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.mark(function _callee() {
                var result;
                return __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.wrap(function _callee$(_context) {
                    while (1) {
                        switch (_context.prev = _context.next) {
                            case 0:
                                _context.next = 2;
                                return Object(__WEBPACK_IMPORTED_MODULE_3__api_data__["e" /* CancelFocus */])({ userId: _this.userId });

                            case 2:
                                result = _context.sent;

                                console.log(result);
                                if (result["data"].code == "200") {
                                    _this.message("success", "取消关注成功");
                                    _this.isFans = false;
                                } else {
                                    _this.message("warning", "取消失败");
                                }

                            case 5:
                            case "end":
                                return _context.stop();
                        }
                    }
                }, _callee, _this);
            }))();
        },

        //关注某人
        hanleFocusOther: function hanleFocusOther() {
            var _this2 = this;

            return __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator___default()( /*#__PURE__*/__WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.mark(function _callee2() {
                var result;
                return __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.wrap(function _callee2$(_context2) {
                    while (1) {
                        switch (_context2.prev = _context2.next) {
                            case 0:
                                _this2.isLoading = true;
                                _context2.next = 3;
                                return Object(__WEBPACK_IMPORTED_MODULE_3__api_data__["y" /* FocusOther */])({ userId: _this2.userId });

                            case 3:
                                result = _context2.sent;

                                if (result["data"].code == "200") {
                                    _this2.isLoading = false;

                                    _this2.message("success", "关注成功");
                                    _this2.isFans = true;
                                }

                            case 5:
                            case "end":
                                return _context2.stop();
                        }
                    }
                }, _callee2, _this2);
            }))();
        }
    },
    components: {
        NavHeader: __WEBPACK_IMPORTED_MODULE_4__IndexHeader__["default"]
    },
    mounted: function mounted() {
        $(".moreInfo_header li").on("click", function (e) {
            $(".moreInfo_header li").css({
                "border-bottom": "none",
                "font-weight": "100"
            });
            e.target.style.borderBottom = "2px solid #409EFF";
            e.target.style.fontWeight = "bold ";
        });
    },
    created: function created() {
        var _this3 = this;

        this.router = this.$route.path;

        this.$router.params.userId ? localStorage.setItem("userId", this.$router.params.userId) : '';
        var id = this.$route.params.userId ? this.$route.params.userId : localStorage.getItem("userId");
        this.userId = id;
        var p1 = GetShowUSerInfo(id);
        var p2 = getIsFocus(id);
        __WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_promise___default.a.all([p1, p2]).then(function (res) {
            _this3.user = res[0]["data"].result;
            if (res[1]["data"].msg == "关注过了") {
                _this3.isFans = true;
            }
            _this3.Userinfo.forEach(function (item, index) {
                switch (index) {
                    case 0:
                        item.value = _this3.user.idolSum;break;
                    case 1:
                        item.value = _this3.user.fansSum;break;
                    case 2:
                        item.value = _this3.user.createTime;break;
                    case 3:
                        item.value = _this3.user.birthday;break;
                    case 4:
                        item.value = _this3.user.major;break;
                    case 5:
                        item.value = _this3.user.sex;break;
                }
            });
        }).catch(function (err) {
            _this3.message("warning", "请求失败");
        });
    },
    render: function render(createElement) {
        var _this4 = this;

        var h = arguments[0];

        return h("section", [h("header", [h(__WEBPACK_IMPORTED_MODULE_4__IndexHeader__["default"])]), h("main", [h(
            "section",
            { "class": "person_container" },
            [h("img", {
                attrs: { src: this.user.selfImage },
                "class": "person_img" }), h(
                "section",
                { "class": "info_user" },
                [h(
                    "section",
                    { "class": "info_container" },
                    [h(
                        "section",
                        { "class": "info_data" },
                        [h(
                            "span",
                            { "class": "info_nickName" },
                            ["\u7528\u6237\u540D:", this.user.userName]
                        ), h(
                            "span",
                            { "class": "info_autograph" },
                            ["\u4E2A\u6027\u7B7E\u540D:\u968F\u98CE\u800C\u884C"]
                        ), h(
                            "a",
                            {
                                attrs: { href: "javascript:;" },
                                on: {
                                    "click": this.handleWatch
                                }
                            },
                            ["\u70B9\u51FB\u67E5\u770B\u8BE6\u7EC6\u4FE1\u606F"]
                        ), h(
                            "el-popconfirm",
                            {
                                on: {
                                    "confirm": this.handleCancelFocus
                                },
                                directives: [{
                                    name: "show",
                                    value: this.isFans
                                }],

                                style: "margin-top:-20px",
                                attrs: { title: "\u662F\u5426\u53D6\u6D88\u5173\u6CE8"
                                }
                            },
                            [h(
                                "el-button",
                                { slot: "reference", attrs: { type: "default" },
                                    style: "float:right;margin-right:40px" },
                                ["\u5DF2\u5173\u6CE8"]
                            )]
                        ), h(
                            "el-button",
                            {
                                directives: [{
                                    name: "show",
                                    value: !this.isFans
                                }],
                                attrs: { type: "primary", loading: this.isLoading },
                                style: "float:right;margin-right:40px", on: {
                                    "click": this.hanleFocusOther
                                }
                            },
                            ["\u5173\u6CE8ta"]
                        )]
                    ), h(
                        "section",
                        { "class": "info_detail" },
                        [this.Userinfo.map(function (item) {
                            return h(
                                "section",
                                { "class": "detail_item" },
                                [h("span", { "class": item.icon }), h(
                                    "span",
                                    { "class": "item_value" },
                                    [item.value ? item.value : '该用户太懒了,暂无信息']
                                )]
                            );
                        }), h(
                            "span",
                            { "class": "info_sildeUp", on: {
                                    "click": this.handleWatch
                                }
                            },
                            [" \u6536\u8D77"]
                        )]
                    )]
                )]
            )]
        ), h(
            "section",
            { "class": "moreInfo_container" },
            [h(
                "section",
                { "class": "moreInfo_header" },
                [h("ul", [this.nav.map(function (item) {
                    return h(
                        "router-link",
                        {
                            attrs: { tag: "li", to: item.path },
                            "class": _this4.router === item.path ? 'activer' : '' },
                        [item.title]
                    );
                })])]
            ), h(
                "section",
                { "class": "moreInfo_mainer" },
                [h("router-view")]
            )]
        )])]);
    }
});
/* WEBPACK VAR INJECTION */}.call(__webpack_exports__, __webpack_require__("7t+N")))

/***/ }),

/***/ "8aJz":
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ "EGO1":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });

// CONCATENATED MODULE: ./node_modules/babel-loader/lib!./node_modules/vue-loader/lib/selector.js?type=script&index=0!./src/components/public/IndexHeader.vue
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//

/* harmony default export */ var IndexHeader = ({
  data: function data() {
    return {
      //用户信息
      user: {}
    };
  },
  created: function created() {
    this.user = this.$store.state.user;
  }
});
// CONCATENATED MODULE: ./node_modules/vue-loader/lib/template-compiler?{"id":"data-v-1f8657ca","hasScoped":true,"transformToRequire":{"video":["src","poster"],"source":"src","img":"src","image":"xlink:href"},"buble":{"transforms":{}}}!./node_modules/vue-loader/lib/selector.js?type=template&index=0!./src/components/public/IndexHeader.vue
var render = function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',[_c('el-row',{staticClass:"row-bg",attrs:{"type":"flex","justify":"center"}},[_c('el-col',{attrs:{"span":2,"xs":6,"sm":4,"md":2,"lg":3,"xl":2}},[_c('div',{staticClass:"logo-content"},[_c('h3',[_c('router-link',{attrs:{"to":"/index"}},[_c('img',{staticClass:"logo",attrs:{"src":__webpack_require__("Z2Ou")}}),_vm._v(" "),_c('span',[_vm._v("1楼2楼")])])],1)])]),_vm._v(" "),_c('el-col',{attrs:{"span":7,"xs":6,"sm":8,"md":10,"lg":9,"xl":9}},[_c('div',{staticClass:"grid-content"},[_c('ul',{staticClass:"nav"},[_c('li',[_c('router-link',{attrs:{"to":"/index"}},[_vm._v(" 首页 ")])],1),_vm._v(" "),_c('li',[_c('router-link',{attrs:{"to":"/department"}},[_vm._v(" 部门 ")])],1),_vm._v(" "),_c('li',[_c('router-link',{attrs:{"to":"/"}},[_vm._v(" 跳蚤市场 ")])],1),_vm._v(" "),_c('li',[_c('router-link',{attrs:{"to":"/campus/hotlist"}},[_vm._v(" 微论坛 ")])],1),_vm._v(" "),_c('li',[_c('router-link',{attrs:{"to":"/"}},[_vm._v(" 下载app ")]),_vm._v(" "),_c('div',{staticClass:"extension"},[_c('p',[_vm._v("请大大扫码下载吧")]),_vm._v(" "),_c('img',{attrs:{"src":__webpack_require__("PFgU"),"alt":"请检查网络"}})])],1)])])]),_vm._v(" "),_c('el-col',{attrs:{"span":8,"xs":8,"sm":8,"md":8,"lg":9,"xl":8}},[_c('div',{staticClass:"grid-content"},[_c('div',{staticClass:"nav_search"},[_c('el-row',[_c('el-col',{attrs:{"span":12}},[_c('div',{staticClass:"grid-content hidden-md-and-down"},[_c('el-input',{staticStyle:{"width":"100%"},attrs:{"placeholder":"请输入内容"}},[_c('el-button',{staticStyle:{"background-color":"#00c758","color":"white"},attrs:{"slot":"append","icon":"el-icon-search"},slot:"append"})],1)],1)]),_vm._v(" "),_c('el-col',{attrs:{"span":12}},[_c('div',{staticClass:"grid-content nav_msg hidden-sm-and-down"},[_c('ul',[_c('li'),_vm._v(" "),_c('li',[_c('router-link',{attrs:{"to":"#"}},[_vm._v("关于我们")])],1)])])])],1)],1)])])],1)],1)}
var staticRenderFns = []
var esExports = { render: render, staticRenderFns: staticRenderFns }
/* harmony default export */ var public_IndexHeader = (esExports);
// CONCATENATED MODULE: ./src/components/public/IndexHeader.vue
function injectStyle (ssrContext) {
  __webpack_require__("8aJz")
}
var normalizeComponent = __webpack_require__("VU/8")
/* script */


/* template */

/* template functional */
var __vue_template_functional__ = false
/* styles */
var __vue_styles__ = injectStyle
/* scopeId */
var __vue_scopeId__ = "data-v-1f8657ca"
/* moduleIdentifier (server only) */
var __vue_module_identifier__ = null
var Component = normalizeComponent(
  IndexHeader,
  public_IndexHeader,
  __vue_template_functional__,
  __vue_styles__,
  __vue_scopeId__,
  __vue_module_identifier__
)

/* harmony default export */ var components_public_IndexHeader = __webpack_exports__["default"] = (Component.exports);


/***/ }),

/***/ "GCxK":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__babel_loader_node_modules_vue_loader_lib_selector_type_script_index_0_OtherPeople_vue__ = __webpack_require__("/9hu");
/* empty harmony namespace reexport */
function injectStyle (ssrContext) {
  __webpack_require__("WYln")
}
var normalizeComponent = __webpack_require__("VU/8")
/* script */


/* template */
var __vue_template__ = null
/* template functional */
var __vue_template_functional__ = false
/* styles */
var __vue_styles__ = injectStyle
/* scopeId */
var __vue_scopeId__ = "data-v-6476b242"
/* moduleIdentifier (server only) */
var __vue_module_identifier__ = null
var Component = normalizeComponent(
  __WEBPACK_IMPORTED_MODULE_0__babel_loader_node_modules_vue_loader_lib_selector_type_script_index_0_OtherPeople_vue__["a" /* default */],
  __vue_template__,
  __vue_template_functional__,
  __vue_styles__,
  __vue_scopeId__,
  __vue_module_identifier__
)

/* harmony default export */ __webpack_exports__["default"] = (Component.exports);


/***/ }),

/***/ "WYln":
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ })

});
//# sourceMappingURL=12.d5840b39593cb61beb91.js.map