webpackJsonp([6],{

/***/ "OwOd":
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ "cklV":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });

// EXTERNAL MODULE: ./node_modules/babel-runtime/regenerator/index.js
var regenerator = __webpack_require__("Xxa5");
var regenerator_default = /*#__PURE__*/__webpack_require__.n(regenerator);

// EXTERNAL MODULE: ./node_modules/babel-runtime/helpers/asyncToGenerator.js
var asyncToGenerator = __webpack_require__("exGp");
var asyncToGenerator_default = /*#__PURE__*/__webpack_require__.n(asyncToGenerator);

// EXTERNAL MODULE: ./src/api/data.js + 1 modules
var data = __webpack_require__("Foau");

// EXTERNAL MODULE: ./src/components/public/TitleHeader.vue + 2 modules
var TitleHeader = __webpack_require__("IrT/");

// CONCATENATED MODULE: ./node_modules/babel-loader/lib!./node_modules/vue-loader/lib/selector.js?type=script&index=0!./src/components/public/MyArticle.vue



//获取所有提问
var ShowAllArticle = function () {
    var _ref = asyncToGenerator_default()( /*#__PURE__*/regenerator_default.a.mark(function _callee(userId) {
        var result;
        return regenerator_default.a.wrap(function _callee$(_context) {
            while (1) {
                switch (_context.prev = _context.next) {
                    case 0:
                        _context.next = 2;
                        return Object(data["L" /* ShowAllArticleByPage */])(userId + "/1/10");

                    case 2:
                        result = _context.sent;
                        return _context.abrupt("return", result);

                    case 4:
                    case "end":
                        return _context.stop();
                }
            }
        }, _callee, this);
    }));

    return function ShowAllArticle(_x) {
        return _ref.apply(this, arguments);
    };
}();



/* harmony default export */ var MyArticle = ({
    data: function data() {
        return {
            //文章信息
            ArticleData: [],
            title: ''
        };
    },

    methods: {
        //跳转文章详情页
        ToArticledetail: function ToArticledetail(val) {
            this.$router.push({
                name: 'articledetails',
                parmas: { articleId: val.articleId }
            });
            localStorage.setItem("articleId", val.articleId);
        }
    },
    created: function created() {
        var _this = this;

        var userId = void 0;
        if (this.$route.path == "/people/index/article") {
            this.title = "我的文章";

            userId = this.$GetUserId();
        } else {
            this.title = "ta的文章";

            userId = this.$route.params.userId ? this.$route.params.userId : localStorage.getItem("userId");
        }
        ShowAllArticle(userId).then(function (res) {
            _this.ArticleData = res["data"].result.data;
        });
    },

    components: {
        // TitleHeader:()=>import("../public/TitleHeader")
        TitleHeader: TitleHeader["default"]
    },
    render: function render(createElement) {
        var _this2 = this;

        var h = arguments[0];

        return h("section", [h("header", [h(
            TitleHeader["default"],
            {
                attrs: { title: this.title }
            },
            [h(
                "span",
                { slot: "right" },
                ["\u663E\u793A\u6700\u8FD110\u7BC7\u6587\u7AE0"]
            )]
        )]), h("main", [h(
            "section",
            { "class": "info_container", directives: [{
                    name: "show",
                    value: this.ArticleData.length != 0
                }]
            },
            [this.ArticleData.map(function (item) {
                return h(
                    "section",
                    { "class": "article_info" },
                    [h(
                        "span",
                        {
                            on: {
                                "click": function click() {
                                    return _this2.ToArticledetail(item);
                                }
                            }
                        },
                        [h(
                            "a",
                            {
                                attrs: { href: "javascript:;" }
                            },
                            [item.title]
                        )]
                    ), h("span", [item.createTime, " ", item.commentNum, "\u6761\u8BC4\u8BBA ", item.likeNum, "\u6761\u70B9\u8D5E"])]
                );
            })]
        ), h(
            "section",
            { "class": "article_null", directives: [{
                    name: "show",
                    value: this.ArticleData.length == 0
                }]
            },
            [h("span", ["\u6682\u65E0\u6587\u7AE0"])]
        )])]);
    }
});
// CONCATENATED MODULE: ./src/components/public/MyArticle.vue
function injectStyle (ssrContext) {
  __webpack_require__("OwOd")
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
var __vue_scopeId__ = "data-v-083e5313"
/* moduleIdentifier (server only) */
var __vue_module_identifier__ = null
var Component = normalizeComponent(
  MyArticle,
  __vue_template__,
  __vue_template_functional__,
  __vue_styles__,
  __vue_scopeId__,
  __vue_module_identifier__
)

/* harmony default export */ var public_MyArticle = __webpack_exports__["default"] = (Component.exports);


/***/ })

});
//# sourceMappingURL=6.ee65ccd9ed16ac3c7572.js.map