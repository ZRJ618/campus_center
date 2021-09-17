webpackJsonp([29],{

/***/ "6cCh":
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ "F6P+":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });

// EXTERNAL MODULE: ./node_modules/babel-loader/lib!./node_modules/vue-loader/lib/selector.js?type=script&index=0!./src/components/Bbs/Blod.vue
var Blod = __webpack_require__("Y7wL");

// CONCATENATED MODULE: ./node_modules/vue-loader/lib/template-compiler?{"id":"data-v-e9cffc04","hasScoped":true,"transformToRequire":{"video":["src","poster"],"source":"src","img":"src","image":"xlink:href"},"buble":{"transforms":{}}}!./node_modules/vue-loader/lib/selector.js?type=template&index=0!./src/components/Bbs/Blod.vue
var render = function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',{staticClass:"blod_container"},[_vm._m(0),_vm._v(" "),_c('main',[_c('mavon-editor',{staticClass:"md_editor",attrs:{"toolbars":_vm.toolbars,"ishljs":true},on:{"save":_vm.saveDoc,"change":_vm.updateDoc},model:{value:(_vm.content),callback:function ($$v) {_vm.content=$$v},expression:"content"}}),_vm._v(" "),_c('section',{staticClass:"push_btn"},[_c('el-button',{on:{"click":_vm.handleClick}},[_vm._v("上传md文件"),_c('i',{staticClass:"el-icon-upload el-icon--right"})]),_vm._v(" "),_c('el-button',{attrs:{"type":"primary"},on:{"click":_vm.handleTitleInput}},[_vm._v("确定")])],1)],1),_vm._v(" "),_c('input',{staticClass:"Upload",attrs:{"type":"file","accept":".md"},on:{"change":_vm.handleUpload}}),_vm._v(" "),_c('el-dialog',{attrs:{"center":"","title":"快给你的博客起个响亮的名号","visible":_vm.DialogVisible,"width":"500px"},on:{"update:visible":function($event){_vm.DialogVisible=$event}}},[_c('section',{staticClass:"input_container"},[_c('span',[_vm._v("标题:")]),_vm._v(" "),_c('input',{directives:[{name:"model",rawName:"v-model",value:(_vm.title),expression:"title"}],attrs:{"type":"text"},domProps:{"value":(_vm.title)},on:{"input":function($event){if($event.target.composing){ return; }_vm.title=$event.target.value}}})]),_vm._v(" "),_c('span',{staticClass:"dialog-footer",attrs:{"slot":"footer"},slot:"footer"},[_c('el-button',{on:{"click":function($event){_vm.DialogVisible = false}}},[_vm._v("稍等")]),_vm._v(" "),_c('el-button',{attrs:{"type":"primary","loading":_vm.loadingFlay},on:{"click":_vm.hanlePush}},[_vm._v("发布")])],1)])],1)}
var staticRenderFns = [function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('header',[_c('section',{staticClass:"Blod_header"},[_c('span',[_vm._v("博客")])])])}]
var esExports = { render: render, staticRenderFns: staticRenderFns }
/* harmony default export */ var Bbs_Blod = (esExports);
// CONCATENATED MODULE: ./src/components/Bbs/Blod.vue
function injectStyle (ssrContext) {
  __webpack_require__("6cCh")
}
var normalizeComponent = __webpack_require__("VU/8")
/* script */


/* template */

/* template functional */
var __vue_template_functional__ = false
/* styles */
var __vue_styles__ = injectStyle
/* scopeId */
var __vue_scopeId__ = "data-v-e9cffc04"
/* moduleIdentifier (server only) */
var __vue_module_identifier__ = null
var Component = normalizeComponent(
  Blod["a" /* default */],
  Bbs_Blod,
  __vue_template_functional__,
  __vue_styles__,
  __vue_scopeId__,
  __vue_module_identifier__
)

/* harmony default export */ var components_Bbs_Blod = __webpack_exports__["default"] = (Component.exports);


/***/ }),

/***/ "Y7wL":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function($) {/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_promise__ = __webpack_require__("//Fk");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_promise___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_promise__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator__ = __webpack_require__("Xxa5");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator__ = __webpack_require__("exGp");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator__);



//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
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
    return {
      //是否loading
      loadingFlay: false,
      //博客标题
      title: '',
      //弹出框
      DialogVisible: false,
      //md编辑器内容
      content: "内容过多推荐全屏编辑哦",
      text: "",
      toolbars: {
        bold: true, // 粗体
        italic: true, // 斜体
        header: true, // 标题
        underline: true, // 下划线
        strikethrough: true, // 中划线
        mark: true, // 标记
        superscript: true, // 上角标
        subscript: true, // 下角标
        quote: true, // 引用
        ol: true, // 有序列表
        ul: true, // 无序列表
        link: true, // 链接
        imagelink: true, // 图片链接
        code: true, // code
        table: true, // 表格
        fullscreen: true, // 全屏编辑
        readmodel: true, // 沉浸式阅读
        htmlcode: true, // 展示html源码
        help: true, // 帮助
        undo: true, // 上一步
        redo: true, // 下一步
        trash: true, // 清空
        save: true, // 保存（触发events中的save事件）
        navigation: true, // 导航目录
        alignleft: true, // 左对齐
        aligncenter: true, // 居中
        alignright: true, // 右对齐
        subfield: true, // 单双栏模式
        preview: true // 预览
      }
    };
  },

  methods: {
    //发表事件
    hanlePush: function hanlePush() {
      if (this.title.length > 0 && this.title.length <= 20) {
        this.loadingFlay = true;
      } else if (this.title.length == 0) {
        this.message("warning", "标题不能为空");
      } else if (this.title.length > 20) {
        this.message("warning", "标题字数不能超过20");
      }
    },

    //发表后弹出框提示输入标题
    handleTitleInput: function handleTitleInput() {
      if (this.content == "") {
        this.message("warning", "博客内容不能为空哦");
      } else {
        this.DialogVisible = true;
      }
    },
    handleClick: function handleClick() {
      $(".Upload").click();
    },
    handleUpload: function handleUpload(e) {
      var _this = this;

      return __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator___default()( /*#__PURE__*/__WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.mark(function _callee() {
        var file, content;
        return __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.wrap(function _callee$(_context) {
          while (1) {
            switch (_context.prev = _context.next) {
              case 0:
                file = e.target.files[0];

                if (!(file.name.split(".")[1] != "md")) {
                  _context.next = 5;
                  break;
                }

                _this.message("warning", "不是md文件");
                _context.next = 10;
                break;

              case 5:
                _context.next = 7;
                return HandleReadFile(file);

              case 7:
                content = _context.sent;

                _this.content = content;
                _this.message("success", "上传成功");

              case 10:
              case "end":
                return _context.stop();
            }
          }
        }, _callee, _this);
      }))();
    },
    updateDoc: function updateDoc(markdown, html) {
      // 此时会自动将 markdown 和 html 传递到这个方法中
      console.log("markdown内容: " + markdown);
      this.text = html;
      console.log("html内容:" + html);
    },
    saveDoc: function saveDoc(markdown, html) {
      // 此时会自动将 markdown 和 html 传递到这个方法中
      console.log("markdown内容:" + markdown);
      console.log("html内容:" + html);
    }
  }

});
//读取文件
function HandleReadFile(file) {
  var promise = new __WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_promise___default.a(function (resolve, reject) {
    var FileRead = new FileReader();
    FileRead.readAsText(file);
    FileRead.onload = function (e) {
      resolve(e.currentTarget.result);
    };
  });
  return promise;
}
/* WEBPACK VAR INJECTION */}.call(__webpack_exports__, __webpack_require__("7t+N")))

/***/ })

});
//# sourceMappingURL=29.ae912ce3a52d59160149.js.map