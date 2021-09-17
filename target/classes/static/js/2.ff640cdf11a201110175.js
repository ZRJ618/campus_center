webpackJsonp([2,56],{

/***/ "N8VQ":
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ "QMZZ":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__babel_loader_node_modules_vue_loader_lib_selector_type_script_index_0_MyCollection_vue__ = __webpack_require__("kR0F");
/* empty harmony namespace reexport */
function injectStyle (ssrContext) {
  __webpack_require__("N8VQ")
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
var __vue_scopeId__ = "data-v-67abb586"
/* moduleIdentifier (server only) */
var __vue_module_identifier__ = null
var Component = normalizeComponent(
  __WEBPACK_IMPORTED_MODULE_0__babel_loader_node_modules_vue_loader_lib_selector_type_script_index_0_MyCollection_vue__["a" /* default */],
  __vue_template__,
  __vue_template_functional__,
  __vue_styles__,
  __vue_scopeId__,
  __vue_module_identifier__
)

/* harmony default export */ __webpack_exports__["default"] = (Component.exports);


/***/ }),

/***/ "kR0F":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function($) {/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_helpers_defineProperty__ = __webpack_require__("bOdI");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_helpers_defineProperty___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_babel_runtime_helpers_defineProperty__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator__ = __webpack_require__("Xxa5");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator__ = __webpack_require__("exGp");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__api_data__ = __webpack_require__("Foau");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__Bbs_Eyeloading__ = __webpack_require__("usp/");




var DataNull = {
    template: "\n    <section class='data_null' v-if=\"ShowFlay\">\n        <span>\u6682\u65E0\u6570\u636E\u54E6</span>\n    </section>\n   ",
    computed: {
        ShowFlay: function ShowFlay() {
            if (this.length == 0) {
                return true;
            } else {
                return false;
            }
        }
    },
    props: {
        length: {
            type: Number
        }
    }
};


/* harmony default export */ __webpack_exports__["a"] = ({
    data: function data() {
        return {
            //loading加载
            isLoading: true,
            //记录当前页面
            index: 1,
            //页码
            page: 1,
            //条数
            total: 0,
            //收藏问题数据
            collectionQuestion: [],
            QuestionTotal: 0,
            //收藏文章数据
            collectionArticle: [],
            ArticleTotal: 0,
            //收藏答案数据
            collectionAnswer: [],
            AnswerTotal: 0
        };
    },

    methods: {
        //跳转到问题详情
        handleWatch: function handleWatch(item) {
            if (this.index == 1) {
                this.$router.push({
                    name: 'questdetail',
                    params: {
                        title: item.questionId
                    }
                });
                localStorage.setItem("questionId", item.questionId);
            } else if (this.index == 2) {
                this.$router.push({
                    name: 'articledetails',
                    params: {
                        articleId: item.articleId
                    }
                });
                localStorage.setItem("articleId", item.articleId);
            }
        },

        //取消关注问题
        handleDelete: function handleDelete(item, index) {
            var _this = this;

            return __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator___default()( /*#__PURE__*/__WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.mark(function _callee() {
                var result;
                return __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.wrap(function _callee$(_context) {
                    while (1) {
                        switch (_context.prev = _context.next) {
                            case 0:
                                result = '';

                                if (!(_this.index == 1)) {
                                    _context.next = 8;
                                    break;
                                }

                                _context.next = 4;
                                return Object(__WEBPACK_IMPORTED_MODULE_3__api_data__["_4" /* getQuestCollectionDelete */])({
                                    questionId: item.questionId
                                });

                            case 4:
                                result = _context.sent;

                                if (result["data"].code == "200") {
                                    _this.message("success", "取消成功");
                                    _this.collectionQuestion.splice(index, 1);
                                    _this.QuestionTotal--;
                                    _this.total--;
                                } else {
                                    _this.message("warning", "取消失败");
                                }
                                _context.next = 13;
                                break;

                            case 8:
                                if (!(_this.index == 2)) {
                                    _context.next = 13;
                                    break;
                                }

                                _context.next = 11;
                                return Object(__WEBPACK_IMPORTED_MODULE_3__api_data__["k" /* CollectionArticledelete */])({
                                    articleId: item.articleId
                                });

                            case 11:
                                result = _context.sent;

                                if (result["data"].code == "200") {
                                    _this.message("success", "取消成功");
                                    _this.collectionArticle.splice(index, 1);
                                    _this.ArticleTotal--;
                                    _this.total--;
                                } else {
                                    _this.message("warning", "取消失败");
                                }

                            case 13:
                            case "end":
                                return _context.stop();
                        }
                    }
                }, _callee, _this);
            }))();
        },

        //事件委托
        handleClick: function handleClick(e) {
            var _this2 = this;

            return __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator___default()( /*#__PURE__*/__WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.mark(function _callee2() {
                var data, index;
                return __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.wrap(function _callee2$(_context2) {
                    while (1) {
                        switch (_context2.prev = _context2.next) {
                            case 0:
                                if (!(e.target.nodeName == "LI")) {
                                    _context2.next = 31;
                                    break;
                                }

                                data = "";
                                index = e.target.attributes["index"].value;

                                _this2.index = index;
                                $(".CollectionQuesition_container,.CollectionArticle_container,.CollectionAnswer_container").hide();

                                if (!(index == 1)) {
                                    _context2.next = 10;
                                    break;
                                }

                                _this2.total = _this2.QuestionTotal;
                                $(".CollectionQuesition_container").show();
                                _context2.next = 29;
                                break;

                            case 10:
                                if (!(index == 2)) {
                                    _context2.next = 21;
                                    break;
                                }

                                if (!(_this2.collectionArticle.length == 0)) {
                                    _context2.next = 17;
                                    break;
                                }

                                _context2.next = 14;
                                return Object(__WEBPACK_IMPORTED_MODULE_3__api_data__["j" /* CollectionArticle */])(_this2.$GetUserId() + "/1/8");

                            case 14:
                                data = _context2.sent;

                                _this2.ArticleTotal = data["data"].result.allDataNum;
                                _this2.collectionArticle = data["data"].result.data;

                            case 17:
                                _this2.total = _this2.ArticleTotal;
                                $(".CollectionArticle_container").show();
                                _context2.next = 29;
                                break;

                            case 21:
                                if (!(_this2.collectionAnswer.length == 0)) {
                                    _context2.next = 27;
                                    break;
                                }

                                _context2.next = 24;
                                return Object(__WEBPACK_IMPORTED_MODULE_3__api_data__["h" /* CollectionAnswer */])(_this2.$GetUserId() + "/1/8");

                            case 24:
                                data = _context2.sent;

                                _this2.AnswerTotal = data["data"].result.allDataNum;
                                _this2.collectionAnswer = data["data"].result.data;

                            case 27:
                                _this2.total = _this2.AnswerTotal;
                                $(".CollectionAnswer_container").show();

                            case 29:
                                $(".nav_menu li").removeClass("activer");
                                e.target.classList.add("activer");

                            case 31:
                            case "end":
                                return _context2.stop();
                        }
                    }
                }, _callee2, _this2);
            }))();
        },

        //切换页码
        handleCurrentChange: function handleCurrentChange(val) {
            var _this3 = this;

            return __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator___default()( /*#__PURE__*/__WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.mark(function _callee3() {
                var result;
                return __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.wrap(function _callee3$(_context3) {
                    while (1) {
                        switch (_context3.prev = _context3.next) {
                            case 0:
                                result = "";

                                if (!(_this3.index == 1)) {
                                    _context3.next = 8;
                                    break;
                                }

                                _context3.next = 4;
                                return Object(__WEBPACK_IMPORTED_MODULE_3__api_data__["m" /* CollectionQuestion */])(_this3.$GetUserId() + "/" + val + "/8");

                            case 4:
                                result = _context3.sent;

                                _this3.collectionQuestion = result["data"].result.data;
                                _context3.next = 19;
                                break;

                            case 8:
                                if (!(_this3.index == 2)) {
                                    _context3.next = 15;
                                    break;
                                }

                                _context3.next = 11;
                                return Object(__WEBPACK_IMPORTED_MODULE_3__api_data__["j" /* CollectionArticle */])(_this3.$GetUserId() + "/" + val + "/8");

                            case 11:
                                result = _context3.sent;

                                _this3.collectionArticle = result["data"].result.data;
                                _context3.next = 19;
                                break;

                            case 15:
                                _context3.next = 17;
                                return Object(__WEBPACK_IMPORTED_MODULE_3__api_data__["h" /* CollectionAnswer */])(_this3.$GetUserId() + "/" + val + "/8");

                            case 17:
                                result = _context3.sent;

                                _this3.collectionAnswer = result["data"].result.data;

                            case 19:
                            case "end":
                                return _context3.stop();
                        }
                    }
                }, _callee3, _this3);
            }))();
        }
    },
    created: function created() {
        var _this4 = this;

        return __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator___default()( /*#__PURE__*/__WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.mark(function _callee4() {
            var result;
            return __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.wrap(function _callee4$(_context4) {
                while (1) {
                    switch (_context4.prev = _context4.next) {
                        case 0:
                            _context4.next = 2;
                            return Object(__WEBPACK_IMPORTED_MODULE_3__api_data__["m" /* CollectionQuestion */])(_this4.$GetUserId() + "/1/8");

                        case 2:
                            result = _context4.sent;

                            _this4.collectionQuestion = result["data"].result.data;
                            _this4.QuestionTotal = result["data"].result.allDataNum;
                            _this4.total = result["data"].result.allDataNum;
                            _this4.isLoading = false;

                        case 7:
                        case "end":
                            return _context4.stop();
                    }
                }
            }, _callee4, _this4);
        }))();
    },
    render: function render(createElement) {
        var _this5 = this;

        var h = arguments[0];

        return h("section", [h("header", [h("nav", [h(
            "ul",
            {
                on: {
                    "click": this.handleClick
                },
                "class": "nav_menu " },
            [h(
                "li",
                {
                    attrs: { index: "1" },
                    "class": "activer" },
                ["\u6536\u85CF\u7684\u95EE\u9898"]
            ), h(
                "li",
                {
                    attrs: { index: "2" }
                },
                ["\u6536\u85CF\u7684\u6587\u7AE0"]
            ), h(
                "li",
                {
                    attrs: { index: "3" }
                },
                ["\u6536\u85CF\u7684\u7B54\u6848"]
            )]
        )])]), h(__WEBPACK_IMPORTED_MODULE_4__Bbs_Eyeloading__["default"], {
            directives: [{
                name: "show",
                value: this.isLoading
            }]
        }), h("main", [h(DataNull, {
            attrs: { length: this.total }
        }), h(
            "section",
            { "class": "CollectionQuesition_container", directives: [{
                    name: "show",
                    value: this.QuestionTotal != 0
                }]
            },
            [this.collectionQuestion.map(function (item, index) {
                return h(
                    "section",
                    { "class": "item_contain" },
                    [h(
                        "section",
                        { "class": "item_data" },
                        [h(
                            "span",
                            { "class": "item_title" },
                            [item.title]
                        ), h(
                            "span",
                            { "class": "item_time" },
                            ["\u53D1\u5E03\u65F6\u95F4:", item.createTime]
                        )]
                    ), h(
                        "section",
                        { "class": "item_operation" },
                        [h("el-button", {
                            attrs: { circle: true, icon: "el-icon-search", size: "mini" },
                            on: {
                                "click": function click() {
                                    return _this5.handleWatch(item);
                                }
                            }
                        }), h("el-button", {
                            attrs: { circle: true, icon: "el-icon-delete", type: "danger", size: "mini" },
                            on: {
                                "click": function click() {
                                    return _this5.handleDelete(item, index);
                                }
                            }
                        })]
                    )]
                );
            })]
        ), h(
            "section",
            { "class": "CollectionArticle_container", directives: [{
                    name: "show",
                    value: this.AnswerTotal != 0
                }]
            },
            [this.collectionArticle.map(function (item, index) {
                return h(
                    "section",
                    { "class": "item_contain" },
                    [h(
                        "section",
                        { "class": "item_data" },
                        [h(
                            "span",
                            { "class": "item_title" },
                            [item.title]
                        ), h(
                            "span",
                            { "class": "item_time" },
                            ["\u53D1\u5E03\u65F6\u95F4:", item.createTime]
                        ), h("span", ["\u70B9\u8D5E\u6570:", item.likeNum]), h("span", ["\u8BC4\u8BBA\u6570:", item.commentNum])]
                    ), h(
                        "section",
                        { "class": "item_operation" },
                        [h("el-button", {
                            attrs: { circle: true, icon: "el-icon-search", size: "mini" },
                            on: {
                                "click": function click() {
                                    return _this5.handleWatch(item);
                                }
                            }
                        }), h("el-button", {
                            attrs: { circle: true, icon: "el-icon-delete", type: "danger", size: "mini" },
                            on: {
                                "click": function click() {
                                    return _this5.handleDelete(item, index);
                                }
                            }
                        })]
                    )]
                );
            })]
        ), h(
            "section",
            { "class": "CollectionAnswer_container" },
            [this.collectionAnswer.map(function (item) {
                return h("el-collapse", [h("el-collapse-item", [h(
                    "template",
                    { slot: "title" },
                    [h(
                        "section",
                        { "class": "Answer_data" },
                        [h(
                            "span",
                            { "class": "item_title" },
                            [item.questionTitle]
                        ), h(
                            "span",
                            { "class": "item_time" },
                            ["\u56DE\u7B54\u65F6\u95F4:", item.createTime]
                        ), h("span", ["\u70B9\u8D5E\u6570:", item.likeNum]), h("span", ["\u8BC4\u8BBA\u6570:", item.commentNum])]
                    )]
                ), h(
                    "section",
                    { "class": "content_contain" },
                    [h("span", ["\u56DE\u7B54\u5185\u5BB9:"]), h("section", {
                        domProps: {
                            "innerHTML": item.content
                        },
                        "class": "content_mainer" })]
                )])]);
            })]
        ), h(
            "section",
            { "class": "block" },
            [h("el-pagination", {
                style: "text-align:center",
                on: {
                    "current-change": this.handleCurrentChange
                },
                attrs: {
                    on: __WEBPACK_IMPORTED_MODULE_0_babel_runtime_helpers_defineProperty___default()({}, 'update:current-page', this.page),
                    "page-size": 8,
                    layout: "total, prev, pager, next",
                    total: this.total }
            })]
        )])]);
    },

    components: {
        EyeLoading: __WEBPACK_IMPORTED_MODULE_4__Bbs_Eyeloading__["default"],
        DataNull: DataNull
    }
});
/* WEBPACK VAR INJECTION */}.call(__webpack_exports__, __webpack_require__("7t+N")))

/***/ }),

/***/ "mkdc":
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ "usp/":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });

// CONCATENATED MODULE: ./node_modules/babel-loader/lib!./node_modules/vue-loader/lib/selector.js?type=script&index=0!./src/components/Bbs/Eyeloading.vue
//
//
//
//
//
//

/* harmony default export */ var Eyeloading = ({});
// CONCATENATED MODULE: ./node_modules/vue-loader/lib/template-compiler?{"id":"data-v-3372d717","hasScoped":false,"transformToRequire":{"video":["src","poster"],"source":"src","img":"src","image":"xlink:href"},"buble":{"transforms":{}}}!./node_modules/vue-loader/lib/selector.js?type=template&index=0!./src/components/Bbs/Eyeloading.vue
var render = function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _vm._m(0)}
var staticRenderFns = [function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',{staticClass:"loading_contain"},[_c('div',{staticClass:"eye"})])}]
var esExports = { render: render, staticRenderFns: staticRenderFns }
/* harmony default export */ var Bbs_Eyeloading = (esExports);
// CONCATENATED MODULE: ./src/components/Bbs/Eyeloading.vue
function injectStyle (ssrContext) {
  __webpack_require__("mkdc")
}
var normalizeComponent = __webpack_require__("VU/8")
/* script */


/* template */

/* template functional */
var __vue_template_functional__ = false
/* styles */
var __vue_styles__ = injectStyle
/* scopeId */
var __vue_scopeId__ = null
/* moduleIdentifier (server only) */
var __vue_module_identifier__ = null
var Component = normalizeComponent(
  Eyeloading,
  Bbs_Eyeloading,
  __vue_template_functional__,
  __vue_styles__,
  __vue_scopeId__,
  __vue_module_identifier__
)

/* harmony default export */ var components_Bbs_Eyeloading = __webpack_exports__["default"] = (Component.exports);


/***/ })

});
//# sourceMappingURL=2.ff640cdf11a201110175.js.map