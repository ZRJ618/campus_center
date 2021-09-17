webpackJsonp([27],{

/***/ "WxtU":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });

// EXTERNAL MODULE: ./node_modules/babel-runtime/regenerator/index.js
var regenerator = __webpack_require__("Xxa5");
var regenerator_default = /*#__PURE__*/__webpack_require__.n(regenerator);

// EXTERNAL MODULE: ./node_modules/babel-runtime/helpers/asyncToGenerator.js
var asyncToGenerator = __webpack_require__("exGp");
var asyncToGenerator_default = /*#__PURE__*/__webpack_require__.n(asyncToGenerator);

// EXTERNAL MODULE: ./src/minxin/upload.js
var upload = __webpack_require__("lQEl");

// EXTERNAL MODULE: ./src/api/data.js + 2 modules
var api_data = __webpack_require__("Foau");

// CONCATENATED MODULE: ./node_modules/babel-loader/lib!./node_modules/vue-loader/lib/selector.js?type=script&index=0!./src/components/Bbs/ReviseActicle.vue


//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//



/* harmony default export */ var ReviseActicle = ({
  name: "FuncFormsEdit",
  mixins: [upload["a" /* default */]],
  components: {
    quillEditor: function quillEditor() {
      return __webpack_require__.e/* import() */(46/* duplicate */).then(__webpack_require__.bind(null, "JI8q"));
    }
  },
  data: function data() {
    return {
      //富文本纯文字
      text: "",
      //文章字数限制
      num: 400,
      dialogImageUrl: "",
      dialogVisible: false,
      //存储表单数据
      formdata: {
        title: "",
        subtitle: "",
        content: "",
        type: []
      },
      //上传地址
      url: '/article/uploadArticleImage',
      //文章封面
      //控制副标题提示信息显示
      warnSTitleFlag: false,
      //控制主标题提示信息显示
      warnTitleFlag: false,
      //控制类型提示信息显示
      NatureFlag: false,
      //主标题提示信息
      titleWarn: {
        msg: "",
        color: "red",
        result: 200,
        icon: ""
      },
      //副标题提示信息
      subtitleWarn: {
        msg: "",
        color: "",
        result: 200,
        icon: ""
      },
      //文章性质提示消息
      natureWarn: {
        msg: "",
        color: "",
        icon: ""
      },
      //主标题
      mainTitle: "",
      //副标题
      subTitle: "",
      //文章性质
      nature: [],
      percentage: 20,
      preview: false,
      Promptinput: false,
      //文章内容
      content: null
    };
  },

  methods: {
    //封面图片上传
    input: function input(content) {
      this.formdata.content = content;
    },

    //获取文章纯文本
    handText: function handText(text) {
      this.text = text;
    },

    //校验主标题
    TitleCheck: function TitleCheck() {
      if (this.formdata.title.trim().length >= 5 && this.formdata.title.length < 20) {
        this.$store.commit("nocanQuit");
        this.titleWarn.msg = "正确";
        this.titleWarn.color = "#67C23A";
        this.titleWarn.icon = "el-icon-success";
        return true;
      } else if (this.formdata.title.trim() == "") {
        this.$store.commit("canQuit");
        this.warnTitleFlag = true;
        this.titleWarn.color = "#F56C6C";
        this.titleWarn.msg = "标题不能为空";
        this.titleWarn.icon = "el-icon-error";
        return false;
      } else {
        this.$store.commit("nocanQuit");
        this.titleWarn.msg = "标题长度在5~20之间!";
        this.warnTitleFlag = true;
        this.titleWarn.color = "#F56C6C";
        this.titleWarn.icon = "el-icon-error";
        return false;
      }
    },

    //校验类型选择
    NatureCheck: function NatureCheck() {
      if (this.formdata.type.length == 0) {
        this.NatureFlag = true;
        this.natureWarn.msg = "至少选择一个类型";
        this.natureWarn.icon = "el-icon-error";
        this.natureWarn.color = "#F56C6C";
        return false;
      } else if (this.formdata.type.length >= 5) {
        this.NatureFlag = true;
        this.natureWarn.msg = "至多选择四个类型";
        this.natureWarn.icon = "el-icon-error";
        this.natureWarn.color = "#F56C6C";
        return false;
      } else {
        this.natureWarn.msg = "正确";
        this.natureWarn.icon = "el-icon-success";
        this.natureWarn.color = "#67C23A";
        return true;
      }
    },

    //发布文章
    publishing: function publishing() {
      var _this = this;

      return asyncToGenerator_default()( /*#__PURE__*/regenerator_default.a.mark(function _callee() {
        var result;
        return regenerator_default.a.wrap(function _callee$(_context) {
          while (1) {
            switch (_context.prev = _context.next) {
              case 0:
                if (_this.TitleCheck() && _this.formdata.content != null && _this.NatureCheck()) {
                  _context.next = 5;
                  break;
                }

                _this.$message({
                  type: "error",
                  message: "请检查输入的内容",
                  offset: 100
                });
                if (_this.content != "") {
                  _this.$store.commit("nocanQuit");
                }
                _context.next = 9;
                break;

              case 5:
                _context.next = 7;
                return Object(api_data["R" /* UploadArticle */])({
                  title: _this.formdata.title,
                  content: _this.formdata.content,
                  article_image: _this.image,
                  label1: _this.formdata.type[0],
                  label2: _this.formdata.type[1],
                  label3: _this.formdata.type[2],
                  label4: _this.formdata.type[3] });

              case 7:
                result = _context.sent;

                if (result["data"].code == "200") {
                  _this.$message({
                    message: "发表成功",
                    type: "success",
                    offset: 100
                  });
                  _this.$store.commit("canQuit");
                  localStorage.setItem("articleId", result["data"].result);
                  _this.$router.push({
                    name: "articledetails"
                  });
                }

              case 9:
              case "end":
                return _context.stop();
            }
          }
        }, _callee, _this);
      }))();
    }
  },
  mounted: function mounted() {},
  created: function created() {
    var _this2 = this;

    return asyncToGenerator_default()( /*#__PURE__*/regenerator_default.a.mark(function _callee2() {
      var id, result, data;
      return regenerator_default.a.wrap(function _callee2$(_context2) {
        while (1) {
          switch (_context2.prev = _context2.next) {
            case 0:
              id = "";

              if (!_this2.$route.params.articleId) {
                id = localStorage.getItem("articleId");
              } else {
                id = _this2.$route.params.articleId;
              }
              _context2.next = 4;
              return Object(api_data["K" /* ShowArticle */])(id);

            case 4:
              result = _context2.sent;
              data = result["data"].result;

              _this2.formdata.title = data.title;
              _this2.image = data.articleImage;
              _this2.formdata.type = data.label;
              _this2.$refs.editor.content = data.content;
              _this2.Promptinput = true;

            case 11:
            case "end":
              return _context2.stop();
          }
        }
      }, _callee2, _this2);
    }))();
  }
});
// CONCATENATED MODULE: ./node_modules/vue-loader/lib/template-compiler?{"id":"data-v-d7f2faea","hasScoped":true,"transformToRequire":{"video":["src","poster"],"source":"src","img":"src","image":"xlink:href"},"buble":{"transforms":{}}}!./node_modules/vue-loader/lib/selector.js?type=template&index=0!./src/components/Bbs/ReviseActicle.vue
var render = function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',[_vm._m(0),_vm._v(" "),_c('div',{staticClass:"article_main"},[_c('div',{staticClass:"article_title",staticStyle:{"padding-left":"20px"}},[_c('label',{attrs:{"for":"articleTitle"}},[_c('span',{staticStyle:{"color":"#606266"}},[_c('font',{attrs:{"color":"red"}},[_vm._v("*")]),_vm._v("文章标题:")],1),_c('input',{directives:[{name:"model",rawName:"v-model",value:(_vm.formdata.title),expression:"formdata.title"}],staticClass:"title_input",attrs:{"type":"search","name":"articleTitle","autocomplete":"off","placeholder":"请输入标题","required":"required"},domProps:{"value":(_vm.formdata.title)},on:{"keyup":function($event){return _vm.TitleCheck()},"input":function($event){if($event.target.composing){ return; }_vm.$set(_vm.formdata, "title", $event.target.value)}}})]),_vm._v(" "),_c('transition',{attrs:{"enter-active-class":"animated fadeInDown"}},[_c('p',{directives:[{name:"show",rawName:"v-show",value:(_vm.warnTitleFlag),expression:"warnTitleFlag"}],staticClass:"title_warn",style:({ color: _vm.titleWarn.color })},[_c('span',{class:_vm.titleWarn.icon}),_vm._v(_vm._s(_vm.titleWarn.msg)+"\n      ")])])],1),_vm._v(" "),_c('div',{staticClass:"article_coverimg"},[_c('span',{staticStyle:{"color":"#606266"}},[_vm._v("文章封面:")]),_vm._v(" "),_c('el-upload',{staticClass:"avatar-uploader",attrs:{"limit":2,"list-type":"picture-card","multiple":"","action":"/article/uploadArticleImage","show-file-list":true,"before-upload":_vm.beforeAvatarUpload,"http-request":_vm.CoverImgUpload}},[(_vm.imageUrl)?_c('img',{staticClass:"avatar",attrs:{"src":_vm.imageUrl}}):_c('i',{staticClass:"el-icon-plus avatar-uploader-icon",staticStyle:{"margin":"-20px"}})])],1),_vm._v(" "),_c('div',{staticClass:"article_nature"},[_c('span',{staticStyle:{"color":"#606266"}},[_c('font',{attrs:{"color":"red"}},[_vm._v("*")]),_vm._v("文章类型:")],1),_vm._v(" "),_c('div',{staticClass:"check_container"},[_c('el-checkbox-group',{attrs:{"max":4,"min":1},model:{value:(_vm.formdata.type),callback:function ($$v) {_vm.$set(_vm.formdata, "type", $$v)},expression:"formdata.type"}},[_c('el-checkbox',{attrs:{"label":"学习"}}),_vm._v(" "),_c('el-checkbox',{attrs:{"label":"感情"}}),_vm._v(" "),_c('el-checkbox',{attrs:{"label":"考试"}}),_vm._v(" "),_c('el-checkbox',{attrs:{"label":"生活"}}),_vm._v(" "),_c('el-checkbox',{attrs:{"label":"自然"}})],1)],1),_vm._v(" "),_c('p',{directives:[{name:"show",rawName:"v-show",value:(_vm.NatureFlag),expression:"NatureFlag"}],staticClass:"nature_wran",style:({color:_vm.natureWarn.color})},[_c('span',{class:_vm.natureWarn.icon}),_vm._v(_vm._s(_vm.natureWarn.msg))])]),_vm._v(" "),_c('div',{staticClass:"article_content"},[_c('span',{staticStyle:{"color":"#606266","margin-left":"-25px"}},[_vm._v("文章内容:")]),_vm._v(" "),_c('div',{staticStyle:{"margin-left":"70px","margin-top":"-24px"}},[_c('quillEditor',{ref:"editor",staticStyle:{"margin":"-20px"},attrs:{"num":_vm.num,"text":_vm.text,"url":_vm.url,"height":'450px'},on:{"update:text":function($event){_vm.text=$event},"editor":_vm.input}})],1)])]),_vm._v(" "),_c('div',{staticClass:"fun_btn"},[_c('el-button',{attrs:{"type":"primary"},on:{"click":function($event){_vm.preview = true}}},[_vm._v("预览")]),_vm._v(" "),_c('el-button',{attrs:{"type":"success"},on:{"click":_vm.publishing}},[_vm._v("确定修改")])],1)])}
var staticRenderFns = [function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',{staticClass:"ReviseActicle_header"},[_c('span',[_vm._v("修改文章")])])}]
var esExports = { render: render, staticRenderFns: staticRenderFns }
/* harmony default export */ var Bbs_ReviseActicle = (esExports);
// CONCATENATED MODULE: ./src/components/Bbs/ReviseActicle.vue
function injectStyle (ssrContext) {
  __webpack_require__("yOAL")
}
var normalizeComponent = __webpack_require__("VU/8")
/* script */


/* template */

/* template functional */
var __vue_template_functional__ = false
/* styles */
var __vue_styles__ = injectStyle
/* scopeId */
var __vue_scopeId__ = "data-v-d7f2faea"
/* moduleIdentifier (server only) */
var __vue_module_identifier__ = null
var Component = normalizeComponent(
  ReviseActicle,
  Bbs_ReviseActicle,
  __vue_template_functional__,
  __vue_styles__,
  __vue_scopeId__,
  __vue_module_identifier__
)

/* harmony default export */ var components_Bbs_ReviseActicle = __webpack_exports__["default"] = (Component.exports);


/***/ }),

/***/ "yOAL":
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ })

});
//# sourceMappingURL=27.b985008633d9ae80aa48.js.map