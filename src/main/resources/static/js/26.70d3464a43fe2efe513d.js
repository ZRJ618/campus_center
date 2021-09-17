webpackJsonp([26],{

/***/ "AcnQ":
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ "HKBd":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });

// EXTERNAL MODULE: ./node_modules/babel-loader/lib!./node_modules/vue-loader/lib/selector.js?type=script&index=0!./src/components/Bbs/Questiondetail.vue
var Questiondetail = __webpack_require__("r6H7");

// CONCATENATED MODULE: ./node_modules/vue-loader/lib/template-compiler?{"id":"data-v-6e4be14c","hasScoped":true,"transformToRequire":{"video":["src","poster"],"source":"src","img":"src","image":"xlink:href"},"buble":{"transforms":{}}}!./node_modules/vue-loader/lib/selector.js?type=template&index=0!./src/components/Bbs/Questiondetail.vue
var render = function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',{staticClass:"questdetail_contain"},[_c('div',{staticClass:"questdetail_content"},[_c('h2',{staticClass:"question_title",attrs:{"align":"left"}},[_vm._v(_vm._s(_vm.questionData.title))]),_vm._v(" "),_c('div',{staticClass:"question_info"},[_c('span',[_vm._v("回答数:")]),_vm._v(" "),_c('span',{},[_vm._v(_vm._s(_vm.questionData.answer))]),_vm._v(" "),_c('span',[_vm._v("浏览数:")]),_vm._v(" "),_c('span',{},[_vm._v(_vm._s(_vm.questionData.browse))])]),_vm._v(" "),_c('span',{staticClass:"question_content",domProps:{"innerHTML":_vm._s(_vm.questionData.content)}}),_vm._v(" "),_c('div',{staticClass:"question_operation"},[_c('ul',[_c('li',[_c('el-button',{attrs:{"type":"primary","plain":"","icon":"el-icon-edit"},on:{"click":_vm.editorInput}},[_vm._v("写答案")])],1),_vm._v(" "),_c('li',{on:{"click":function($event){return _vm.handSupport(_vm.value)}}}),_vm._v(" "),_c('li',{on:{"click":function($event){return _vm.handCollection(_vm.questionData.questionId)}}},[_vm._v("收藏")]),_vm._v(" "),_c('li',{on:{"click":function($event){_vm.dialogVisible = true}}},[_vm._v("举报")]),_vm._v(" "),_c('li'),_vm._v(" "),_c('li',[_c('span',{staticClass:"question_user"},[_vm._v("提问人:"),_c('router-link',{attrs:{"to":"#"}},[_vm._v(_vm._s(_vm.questionData.authorName))])],1)])])])]),_vm._v(" "),(_vm.editorState)?_c('div',{staticClass:"answer_contain"},[_c('quillEditor',{attrs:{"url":'answer/uploadAnswerImage',"height":'300px',"num":_vm.num,"text":_vm.text},on:{"imgSrc":_vm.handleImgUpload,"editor":_vm.input,"update:text":function($event){_vm.text=$event}}}),_vm._v(" "),_c('div',{staticClass:"reply_contain"},[_vm._m(0)],1)],1):_vm._e(),_vm._v(" "),_c('div',{staticClass:"answerdata_contain"},[_c('div',{staticClass:"contain_content"},[_c('div',{staticClass:"contain_title"},[_c('span',[_vm._v(_vm._s(_vm.answerFlay(_vm.answerNum)))])]),_vm._v(" "),_vm._l((_vm.answerData),function(value,key){return _c('div',{key:key,staticClass:"reply_data"},[_c('div',{staticClass:"reply_user"},[_c('el-popover',{attrs:{"placement":"top-start","width":"300","trigger":"hover"},on:{"show":function($event){return _vm.getUSerInfo(value)}}},[_c('div',{staticClass:"portrait_hover"},[_c('div',{staticClass:"author_container"},[_c('img',{attrs:{"src":_vm.UserInfo.userImage,"alt":"请检查网络"}}),_vm._v(" "),_c('div',{staticClass:"author_message"},[_c('span',[_vm._v(_vm._s(_vm.UserInfo.userName))])])]),_vm._v(" "),_c('div',{staticClass:"author_otherinfo"},[_c('ul',[_c('li',[_c('span',[_vm._v("专业")]),_vm._v(" "),_c('span',{staticClass:"mojor"},[_vm._v(_vm._s(_vm.UserInfo.major))])]),_vm._v(" "),_c('li',[_c('span',[_vm._v("性别")]),_vm._v(" "),_c('span',[_vm._v(_vm._s(_vm.UserInfo.sex))])]),_vm._v(" "),_c('li',[_c('span',[_vm._v("关注者")]),_vm._v(" "),_c('span',[_vm._v(_vm._s(_vm.UserInfo.fansSum))])])])]),_vm._v(" "),_c('div',{staticClass:"author_operation"},[_c('el-button',{attrs:{"type":"primary","icon":"el-icon-plus"},on:{"click":function($event){return _vm.handleCore(value)}}},[_vm._v("关注")]),_vm._v(" "),_c('el-button',{attrs:{"icon":"el-icon-s-promotion"},on:{"click":function($event){return _vm.handleVisit(value.userId)}}},[_vm._v("访问")])],1)]),_vm._v(" "),_c('span',{attrs:{"slot":"reference"},slot:"reference"},[_c('img',{attrs:{"src":value.authorImage}})])]),_vm._v(" "),_c('span',{staticClass:"user_name"},[_vm._v(_vm._s(value.createTime))]),_vm._v(" "),_c('span',{staticClass:"user_time"},[_vm._v(_vm._s(value.authorName))])],1),_vm._v(" "),_c('div',{staticClass:"reply_content"},[_c('span',{domProps:{"innerHTML":_vm._s(value.content)}})]),_vm._v(" "),_c('div',{staticClass:"reply_operation"},[_c('ul',[_c('li',{class:{ activer: value.hasLike },on:{"click":function($event){return _vm.handAnswerSupport(value, key)}}},[_vm._v("\n              赞同\n            ")]),_vm._v(" "),_c('li',{on:{"click":function($event){return _vm.handAnswerStamp(value, key)}}},[_vm._v("踩")]),_vm._v(" "),_c('li',{style:({'color':value.hasCollection?'#F56C6C':''}),on:{"click":function($event){return _vm.handCollectionAnwer(value)}}},[_vm._v(_vm._s(value.hasCollection?'取消收藏':'收藏'))]),_vm._v(" "),_c('li',{on:{"click":function($event){_vm.dialogVisible = true}}},[_vm._v("举报")]),_vm._v(" "),(value.hasSelf)?_c('li',[_c('el-popconfirm',{attrs:{"title":"要删除此条回复嘛","offset":"100"},on:{"confirm":function($event){return _vm.deleteReply(value, key)}}},[_c('span',{attrs:{"slot":"reference"},slot:"reference"},[_vm._v("删除")])])],1):_vm._e()])])])}),_vm._v(" "),_c('div',{staticClass:"block",attrs:{"align":"center"}},[_c('el-pagination',{attrs:{"current-page":_vm.currentPage1,"page-size":10,"layout":"total, prev, pager, next","total":_vm.answerNum},on:{"size-change":_vm.handleSizeChange,"current-change":_vm.handleCurrentChange,"update:currentPage":function($event){_vm.currentPage1=$event},"update:current-page":function($event){_vm.currentPage1=$event}}})],1)],2)]),_vm._v(" "),_c('el-dialog',{attrs:{"center":"","visible":_vm.dialogVisible,"width":"20%"},on:{"update:visible":function($event){_vm.dialogVisible=$event}}},[_c('div',{attrs:{"slot":"title"},slot:"title"},[_c('h2',[_vm._v("举报")]),_vm._v(" "),_c('p',{staticStyle:{"color":"#c0c4cc"}},[_vm._v("(请选择理由)")])]),_vm._v(" "),_c('div',{staticStyle:{"width":"106%"}},[_c('el-checkbox-group',{attrs:{"max":3},model:{value:(_vm.checkList),callback:function ($$v) {_vm.checkList=$$v},expression:"checkList"}},[_c('el-checkbox',{attrs:{"label":"垃圾广告"}}),_vm._v(" "),_c('el-checkbox',{attrs:{"label":"不实信息"}}),_vm._v(" "),_c('el-checkbox',{attrs:{"label":"有害信息"}}),_vm._v(" "),_c('el-checkbox',{attrs:{"label":"涉嫌侵权"}}),_vm._v(" "),_c('el-checkbox',{attrs:{"label":"诱导赞同、关注等行为"}}),_vm._v(" "),_c('el-checkbox',{attrs:{"label":"辱骂、人身攻击等不友善行为"}})],1),_vm._v(" "),_c('textarea',{directives:[{name:"model",rawName:"v-model",value:(_vm.reportContent),expression:"reportContent"}],staticClass:"report_input",attrs:{"cols":"30","rows":"10","placeholder":"请输入详细理由(选填)"},domProps:{"value":(_vm.reportContent)},on:{"input":function($event){if($event.target.composing){ return; }_vm.reportContent=$event.target.value}}})],1),_vm._v(" "),_c('span',{staticClass:"dialog-footer",attrs:{"slot":"footer"},slot:"footer"},[_c('el-button',{on:{"click":function($event){_vm.dialogVisible = false}}},[_vm._v("取 消")]),_vm._v(" "),_c('el-button',{attrs:{"type":"primary"},on:{"click":function($event){_vm.dialogVisible = false}}},[_vm._v("举报")])],1)])],1)}
var staticRenderFns = [function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('el-button',{staticClass:"reply_btn",attrs:{"type":"primary"},on:{"click":_vm.replySubmit}},[_vm._v("提交答案")])}]
var esExports = { render: render, staticRenderFns: staticRenderFns }
/* harmony default export */ var Bbs_Questiondetail = (esExports);
// CONCATENATED MODULE: ./src/components/Bbs/Questiondetail.vue
function injectStyle (ssrContext) {
  __webpack_require__("AcnQ")
}
var normalizeComponent = __webpack_require__("VU/8")
/* script */


/* template */

/* template functional */
var __vue_template_functional__ = false
/* styles */
var __vue_styles__ = injectStyle
/* scopeId */
var __vue_scopeId__ = "data-v-6e4be14c"
/* moduleIdentifier (server only) */
var __vue_module_identifier__ = null
var Component = normalizeComponent(
  Questiondetail["a" /* default */],
  Bbs_Questiondetail,
  __vue_template_functional__,
  __vue_styles__,
  __vue_scopeId__,
  __vue_module_identifier__
)

/* harmony default export */ var components_Bbs_Questiondetail = __webpack_exports__["default"] = (Component.exports);


/***/ }),

/***/ "r6H7":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function($) {/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_json_stringify__ = __webpack_require__("mvHQ");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_json_stringify___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_json_stringify__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator__ = __webpack_require__("Xxa5");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator__ = __webpack_require__("exGp");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_babel_runtime_helpers_defineProperty__ = __webpack_require__("bOdI");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_babel_runtime_helpers_defineProperty___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_3_babel_runtime_helpers_defineProperty__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__api_data__ = __webpack_require__("Foau");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__eventBus_js__ = __webpack_require__("O6e2");




//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
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
  data: function data() {
    var _ref;

    return _ref = {
      //存储用户信息
      UserInfo: {},

      numFlay: true,
      //是否收标识
      CollectionFlay: false,
      //是否点赞标识
      SupportFlay: false,
      //存储答案数据
      answerData: [],
      //总条数
      answerNum: 0,
      //富文本纯文字
      text: "",
      //回答字数限制S
      num: 200,
      //存储文章信息
      questionData: {
        title: "",
        content: "",
        answer: 0,
        browse: 0,
        questionId: "",
        hasCollection: false,
        hasFocus: false
      },
      url: "answer/uploadAnswerImage",
      //举报内容
      reportContent: "",
      //页码
      currentPage1: 1,
      //
      dialogVisible: false,
      //举报内容
      checkList: [],
      //富文本
      editorState: false
    }, __WEBPACK_IMPORTED_MODULE_3_babel_runtime_helpers_defineProperty___default()(_ref, "url", ""), __WEBPACK_IMPORTED_MODULE_3_babel_runtime_helpers_defineProperty___default()(_ref, "content", ""), __WEBPACK_IMPORTED_MODULE_3_babel_runtime_helpers_defineProperty___default()(_ref, "anonymous", false), __WEBPACK_IMPORTED_MODULE_3_babel_runtime_helpers_defineProperty___default()(_ref, "support", false), __WEBPACK_IMPORTED_MODULE_3_babel_runtime_helpers_defineProperty___default()(_ref, "questionId", ''), _ref;
  },
  methods: {
    //访问别人首页
    handleVisit: function handleVisit(val) {
      if (val == this.$GetUserId()) {
        this.$router.push({
          name: 'my'
        });
      } else {
        localStorage.setItem("userId", val);
        this.$router.push({
          name: 'peopleInfo',
          params: {
            userId: val
          }
        });
      }
    },

    //收藏回答事件
    handCollectionAnwer: function handCollectionAnwer(val) {
      var _this = this;

      return __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator___default()( /*#__PURE__*/__WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.mark(function _callee() {
        var result, _result;

        return __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.wrap(function _callee$(_context) {
          while (1) {
            switch (_context.prev = _context.next) {
              case 0:
                if (!val.hasCollection) {
                  _context.next = 7;
                  break;
                }

                _context.next = 3;
                return Object(__WEBPACK_IMPORTED_MODULE_4__api_data__["s" /* DeleteCollectionAnswer */])(val.answerId);

              case 3:
                result = _context.sent;

                if (result["data"].code == "200") {
                  _this.message("success", "取消成功");
                  val.hasCollection = false;
                } else {
                  _this.message("warning", "取消失败");
                }
                _context.next = 11;
                break;

              case 7:
                _context.next = 9;
                return Object(__WEBPACK_IMPORTED_MODULE_4__api_data__["i" /* CollectionAnswerData */])(val.answerId);

              case 9:
                _result = _context.sent;

                if (_result["data"].code == "200") {
                  _this.message("success", "收藏成功");
                  val.hasCollection = true;
                } else {
                  _this.message("warning", "取消失败");
                }

              case 11:
              case "end":
                return _context.stop();
            }
          }
        }, _callee, _this);
      }))();
    },

    //获取消息
    getUSerInfo: function getUSerInfo(item) {
      var _this2 = this;

      return __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator___default()( /*#__PURE__*/__WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.mark(function _callee2() {
        var result;
        return __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.wrap(function _callee2$(_context2) {
          while (1) {
            switch (_context2.prev = _context2.next) {
              case 0:
                if (!(item.userId != _this2.UserInfo.userId)) {
                  _context2.next = 5;
                  break;
                }

                _context2.next = 3;
                return Object(__WEBPACK_IMPORTED_MODULE_4__api_data__["V" /* ShowUSerInfo */])(item.userId);

              case 3:
                result = _context2.sent;

                _this2.UserInfo = result["data"].result;

              case 5:
                _this2.UserInfo.userId = item.userId;

              case 6:
              case "end":
                return _context2.stop();
            }
          }
        }, _callee2, _this2);
      }))();
    },

    //关注某人
    handleCore: function handleCore(val) {
      var _this3 = this;

      return __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator___default()( /*#__PURE__*/__WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.mark(function _callee3() {
        var result;
        return __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.wrap(function _callee3$(_context3) {
          while (1) {
            switch (_context3.prev = _context3.next) {
              case 0:
                _context3.next = 2;
                return Object(__WEBPACK_IMPORTED_MODULE_4__api_data__["y" /* FocusOther */])({ userId: val.userId });

              case 2:
                result = _context3.sent;

                if (result["data"].code == "200") {
                  _this3.message("success", "关注成功");
                } else if (result.code == "500") {
                  _this3.message("warning", "不能重复关注");
                } else {
                  _this3.message("warninf", "关注失败");
                }

              case 4:
              case "end":
                return _context3.stop();
            }
          }
        }, _callee3, _this3);
      }))();
    },

    //获取图片
    handleImgUpload: function handleImgUpload(val) {
      this.content += val;
    },

    //判断回答数
    answerFlay: function answerFlay(num) {
      if (num == 0) {
        return "暂无回答,马上去回答";
      } else {
        return num + "\u6761\u56DE\u7B54";
      }
    },

    //取消答案点赞事件
    handAnswerStamp: function handAnswerStamp(value, key) {
      $(".reply_operation").eq(key).find("li").css("color", "");
      $(".reply_operation").eq(key).find("li:nth-of-type(2)").css("color", "#F56C6C");
    },

    //点赞答案事件
    handAnswerSupport: function handAnswerSupport(value, key) {
      var _this4 = this;

      return __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator___default()( /*#__PURE__*/__WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.mark(function _callee4() {
        var result, _result2;

        return __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.wrap(function _callee4$(_context4) {
          while (1) {
            switch (_context4.prev = _context4.next) {
              case 0:
                console.log($(".question_operation").eq(key));
                _this4.SupportFlay = value.hasLike;

                if (!value.hasLike) {
                  _context4.next = 9;
                  break;
                }

                _context4.next = 5;
                return Object(__WEBPACK_IMPORTED_MODULE_4__api_data__["_1" /* getCancelLikeAnswer */])({ answerId: value.answerId });

              case 5:
                result = _context4.sent;

                if (result["data"].code == "200") {
                  _this4.$message({
                    type: "success",
                    message: "已取消",
                    offset: 100
                  });
                  value.hasLike = false;
                  //  $(".question_operation").eq(key).find("li:nth-of-type(1)").css("color","#616161");
                }
                _context4.next = 13;
                break;

              case 9:
                _context4.next = 11;
                return Object(__WEBPACK_IMPORTED_MODULE_4__api_data__["_0" /* getAnswerSupport */])({ answerId: value.answerId });

              case 11:
                _result2 = _context4.sent;

                if (_result2["data"].code == "200") {
                  _this4.$message({
                    type: "success",
                    message: "点赞成功",
                    offset: 100
                  });
                  value.hasLike = true;
                }

              case 13:
              case "end":
                return _context4.stop();
            }
          }
        }, _callee4, _this4);
      }))();
    },

    //收藏事件
    handCollection: function handCollection(questionId) {
      var _this5 = this;

      return __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator___default()( /*#__PURE__*/__WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.mark(function _callee5() {
        var result, _result3;

        return __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.wrap(function _callee5$(_context5) {
          while (1) {
            switch (_context5.prev = _context5.next) {
              case 0:
                if (!_this5.CollectionFlay) {
                  _context5.next = 7;
                  break;
                }

                _context5.next = 3;
                return Object(__WEBPACK_IMPORTED_MODULE_4__api_data__["_4" /* getQuestCollectionDelete */])({ questionId: questionId });

              case 3:
                result = _context5.sent;

                if (result["data"].code == "200") {
                  _this5.$message({
                    type: "success",
                    message: "已取消",
                    offset: 100
                  });
                  $(".question_operation li:nth-of-type(3)").css("color", "#909399").text("收藏");
                  _this5.CollectionFlay = false;
                }
                _context5.next = 11;
                break;

              case 7:
                _context5.next = 9;
                return Object(__WEBPACK_IMPORTED_MODULE_4__api_data__["_3" /* getQuestCollection */])({ questionId: questionId });

              case 9:
                _result3 = _context5.sent;

                if (_result3["data"].code == "200") {
                  _this5.$message({
                    type: "success",
                    message: "收藏成功",
                    offset: 100
                  });
                  $(".question_operation li:nth-of-type(3)").css("color", "#F56C6C").text("取消收藏");
                  _this5.CollectionFlay = true;
                }

              case 11:
              case "end":
                return _context5.stop();
            }
          }
        }, _callee5, _this5);
      }))();
    },

    //点赞事件
    handSupport: function handSupport() {
      if (!this.support) {
        $(".question_operation li:nth-of-type(2)").css("color", "#32a4e0");
        $(".question_support").attr("src", "../../../static/images/campus/detail/article_aftersupport.png");
        this.support = true;
      } else {
        $(".question_operation li:nth-of-type(2)").css("color", "#909399");
        $(".question_support").attr("src", "../../../static/images/campus/detail/article_beforesupport.png");
        this.support = false;
      }
    },

    //获取输入框内容
    input: function input(content) {
      this.content = content;
    },

    //显示输入框
    editorInput: function editorInput() {
      this.editorState = true;
      $(document).scrollTop($(".answer_contain").scrollTop() + 170);
    },

    //提交答案
    replySubmit: function replySubmit() {
      var _this6 = this;

      return __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator___default()( /*#__PURE__*/__WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.mark(function _callee6() {
        var result, time;
        return __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.wrap(function _callee6$(_context6) {
          while (1) {
            switch (_context6.prev = _context6.next) {
              case 0:
                if (!(_this6.content.trim() == "")) {
                  _context6.next = 4;
                  break;
                }

                _this6.$message({
                  message: "请输入内容!",
                  type: "warning",
                  offset: "100"
                });
                _context6.next = 12;
                break;

              case 4:
                if (!(_this6.text.trim().length > _this6.num)) {
                  _context6.next = 8;
                  break;
                }

                _this6.$message({
                  message: "超过字数,请检查输入!",
                  type: "warning",
                  offset: "100"
                });
                _context6.next = 12;
                break;

              case 8:
                _context6.next = 10;
                return Object(__WEBPACK_IMPORTED_MODULE_4__api_data__["X" /* UploadAnswer */])({
                  questionId: _this6.questionData.questionId,
                  content: _this6.content
                });

              case 10:
                result = _context6.sent;

                if (result["data"].code == "200") {
                  _this6.$message({
                    type: "success",
                    message: "回答成功",
                    offset: 100
                  });

                  time = new Date().getFullYear().toString() + "-" + new Date().getMonth().toString() + "-" + new Date().getDate().toString() + " " + new Date().getHours() + ":" + new Date().getMinutes() + ":" + new Date().getSeconds();

                  if (_this6.answerData.length < 6) {
                    _this6.answerData.unshift({
                      answerId: result["data"].result,
                      content: _this6.content,
                      createTime: time,
                      hasLike: false,
                      hasCollection: false,
                      authorName: _this6.$store.state.user.userName,
                      authorImage: _this6.$store.state.user.selfImage,
                      hasSelf: true,
                      userId: _this6.$GetUserId()
                    });
                  } else {
                    _this6.answerData.pop();
                    _this6.answerData.unshift({
                      answerId: result["data"].result,
                      content: _this6.content,
                      createTime: time,
                      hasLike: false,
                      hasCollection: false,

                      authorName: _this6.$store.state.user.userName,
                      authorImage: _this6.$store.state.user.selfImage,
                      hasSelf: true,
                      userId: _this6.$GetUserId()

                    });
                  }
                  _this6.answerNum++;
                  _this6.content = "";
                  $(".ql-editor").text("");
                }

              case 12:
              case "end":
                return _context6.stop();
            }
          }
        }, _callee6, _this6);
      }))();
    },

    //数据消失并请求数据
    handAnswerList: function handAnswerList() {
      $(".answer_num").slideUp();
    },

    // 切换页码事件
    handleSizeChange: function handleSizeChange(val) {},
    handleCurrentChange: function handleCurrentChange(val) {
      var _this7 = this;

      return __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator___default()( /*#__PURE__*/__WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.mark(function _callee7() {
        var res;
        return __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.wrap(function _callee7$(_context7) {
          while (1) {
            switch (_context7.prev = _context7.next) {
              case 0:
                _context7.next = 2;
                return ShowQuestionAnswerByPage(_this7.questionId + "/" + val + "/10");

              case 2:
                res = _context7.sent;

                _this7.answerData = res["data"].result.data[1];

              case 4:
              case "end":
                return _context7.stop();
            }
          }
        }, _callee7, _this7);
      }))();
    },

    //删除回答
    deleteReply: function deleteReply(value, key) {
      var _this8 = this;

      return __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator___default()( /*#__PURE__*/__WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.mark(function _callee8() {
        var result;
        return __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.wrap(function _callee8$(_context8) {
          while (1) {
            switch (_context8.prev = _context8.next) {
              case 0:
                _context8.next = 2;
                return Object(__WEBPACK_IMPORTED_MODULE_4__api_data__["q" /* DeleteAnswer */])({ answerId: value.answerId });

              case 2:
                result = _context8.sent;

                if (result["data"].code == "200") {
                  _this8.answerData.splice(key, 1);
                  _this8.$message({
                    type: "success",
                    message: "删除成功",
                    offset: 100
                  });
                  _this8.answerNum--;
                }

              case 4:
              case "end":
                return _context8.stop();
            }
          }
        }, _callee8, _this8);
      }))();
    }
  },
  computed: {},
  components: {
    quillEditor: function quillEditor() {
      return __webpack_require__.e/* import() */(50/* duplicate */).then(__webpack_require__.bind(null, "JI8q"));
    },
    Eyeloading: function Eyeloading() {
      return __webpack_require__.e/* import() */(56).then(__webpack_require__.bind(null, "usp/"));
    }
  },
  created: function created() {
    var _this9 = this;

    return __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator___default()( /*#__PURE__*/__WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.mark(function _callee9() {
      var data, questionId, result;
      return __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.wrap(function _callee9$(_context9) {
        while (1) {
          switch (_context9.prev = _context9.next) {
            case 0:
              if (!(_this9.$route.params.router == "question")) {
                _context9.next = 7;
                break;
              }

              data = JSON.parse(localStorage.getItem("question"));

              _this9.questionData.title = data.questionname;
              _this9.questionData.content = data.desc;
              _this9.questionData.browse++;
              _context9.next = 19;
              break;

            case 7:
              questionId = void 0;
              //防止刷新

              if (__WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_json_stringify___default()(_this9.$route.params) === "{}") {
                questionId = localStorage.getItem("questionId");
              } else {
                questionId = _this9.$route.params.title;
                //正常请求
              }
              _this9.questionId = questionId;
              //请求文章详情
              _context9.next = 12;
              return Object(__WEBPACK_IMPORTED_MODULE_4__api_data__["S" /* ShowQuestionByPage */])("" + questionId, "1");

            case 12:
              result = _context9.sent;

              console.log(result);
              _this9.questionData = result["data"].result.data[0];

              _this9.answerData = result["data"].result.data[1].reverse();
              _this9.answerNum = result["data"].result.allDataNum;

              // this.SupportFlay = result["data"].result[1].hasLike;
              //请求回答
              // let res=await ShowQuestionAnswerByPage(`${questionId}/1/10`);


              // // this.answerNum = result["data"].result[1].length;
              // //判断是否收藏
              if (result["data"].result.data[0].hasCollection) {
                $(".question_operation li:nth-of-type(3)").css("color", "#F56C6C").text("取消收藏");
                _this9.CollectionFlay = true;
              }
              // //判断是否点赞
              if (result["data"].result.data[1].hasFocus) {
                $(".question_operation li:nth-of-type(1)").css("color", "#409EFF");
                $(".question_support").attr("src", "../../../static/images/campus/detail/article_aftersupport.png");
              }

            case 19:
            case "end":
              return _context9.stop();
          }
        }
      }, _callee9, _this9);
    }))();
  },
  mounted: function mounted() {
    var _this10 = this;

    __WEBPACK_IMPORTED_MODULE_5__eventBus_js__["a" /* default */].$on("editor", function (val) {
      _this10.editorState = val;
      $(document).scrollTop($(".answer_contain").scrollTop() + 20);
    });
  }
});
/* WEBPACK VAR INJECTION */}.call(__webpack_exports__, __webpack_require__("7t+N")))

/***/ })

});
//# sourceMappingURL=26.70d3464a43fe2efe513d.js.map