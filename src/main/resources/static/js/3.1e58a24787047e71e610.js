webpackJsonp([3],{

/***/ "975E":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });

// EXTERNAL MODULE: ./node_modules/babel-runtime/regenerator/index.js
var regenerator = __webpack_require__("Xxa5");
var regenerator_default = /*#__PURE__*/__webpack_require__.n(regenerator);

// EXTERNAL MODULE: ./node_modules/babel-runtime/helpers/asyncToGenerator.js
var asyncToGenerator = __webpack_require__("exGp");
var asyncToGenerator_default = /*#__PURE__*/__webpack_require__.n(asyncToGenerator);

// EXTERNAL MODULE: ./src/components/public/TitleHeader.vue + 2 modules
var TitleHeader = __webpack_require__("IrT/");

// EXTERNAL MODULE: ./src/api/data.js + 1 modules
var data = __webpack_require__("Foau");

// CONCATENATED MODULE: ./node_modules/babel-loader/lib!./node_modules/vue-loader/lib/selector.js?type=script&index=0!./src/components/public/MyQuestion.vue



var ShowAllQuestion = function () {
    var _ref = asyncToGenerator_default()( /*#__PURE__*/regenerator_default.a.mark(function _callee(userId) {
        var result;
        return regenerator_default.a.wrap(function _callee$(_context) {
            while (1) {
                switch (_context.prev = _context.next) {
                    case 0:
                        _context.next = 2;
                        return Object(data["O" /* ShowAllQuestionByPage */])(userId + '/1/10');

                    case 2:
                        result = _context.sent;
                        return _context.abrupt('return', result);

                    case 4:
                    case 'end':
                        return _context.stop();
                }
            }
        }, _callee, this);
    }));

    return function ShowAllQuestion(_x) {
        return _ref.apply(this, arguments);
    };
}();



/* harmony default export */ var MyQuestion = ({
    data: function data() {
        return {
            QuestionData: [],
            title: ""
        };
    },

    methods: {
        //跳转到问题详情页
        ToQuestiondetail: function ToQuestiondetail(val) {
            this.$router.push({
                name: 'questdetail',
                params: {
                    title: val.questionId
                }
            });
            localStorage.setItem("questionId", val.questionId);
        }
    },
    components: {
        TitleHeader: TitleHeader["default"]
    },
    render: function render(createElement) {
        var _this = this;

        var h = arguments[0];

        return h('section', [h('header', [h(
            TitleHeader["default"],
            {
                attrs: { title: this.title }
            },
            [h(
                'span',
                { slot: 'right' },
                ['\u53EA\u663E\u793A\u6700\u8FD1\u768410\u6761\u95EE\u9898']
            )]
        )]), h('main', [h(
            'section',
            { 'class': 'info_container', directives: [{
                    name: 'show',
                    value: this.QuestionData.length != 0
                }]
            },
            [this.QuestionData.map(function (item) {
                return h(
                    'section',
                    { 'class': 'question_info' },
                    [h(
                        'span',
                        {
                            on: {
                                'click': function click() {
                                    return _this.ToQuestiondetail(item);
                                }
                            }
                        },
                        [h(
                            'a',
                            {
                                attrs: { href: 'javcscript:;' }
                            },
                            [item.title]
                        )]
                    ), h('span', [item.createTime, ' ', item.allAnswerLikeNum, '\u4EBA\u6536\u85CF'])]
                );
            })]
        ), h(
            'section',
            { 'class': 'question_null', directives: [{
                    name: 'show',
                    value: this.QuestionData.length == 0
                }]
            },
            [h('span', ['\u6682\u65E0\u63D0\u95EE'])]
        )])]);
    },
    created: function created() {
        var _this2 = this;

        var userId = void 0;
        if (this.$route.path == "/people/index/question") {
            this.title = "我的提问";
            userId = this.$GetUserId();
        } else {
            this.title = "ta的提问";
            userId = this.$route.params.userId ? this.$route.params.userId : localStorage.getItem("userId");
        }
        ShowAllQuestion(userId).then(function (res) {
            _this2.QuestionData = res["data"].result.data;
        });
    }
});
// CONCATENATED MODULE: ./src/components/public/MyQuestion.vue
function injectStyle (ssrContext) {
  __webpack_require__("OtjG")
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
var __vue_scopeId__ = "data-v-e0acb440"
/* moduleIdentifier (server only) */
var __vue_module_identifier__ = null
var Component = normalizeComponent(
  MyQuestion,
  __vue_template__,
  __vue_template_functional__,
  __vue_styles__,
  __vue_scopeId__,
  __vue_module_identifier__
)

/* harmony default export */ var public_MyQuestion = __webpack_exports__["default"] = (Component.exports);


/***/ }),

/***/ "OtjG":
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ })

});
//# sourceMappingURL=3.1e58a24787047e71e610.js.map