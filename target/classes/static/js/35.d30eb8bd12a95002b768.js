webpackJsonp([35],{

/***/ "9ly0":
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ "qcU5":
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

// CONCATENATED MODULE: ./node_modules/babel-loader/lib!./node_modules/vue-loader/lib/selector.js?type=script&index=0!./src/components/Bbs/Square.vue


//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//


/* harmony default export */ var Square = ({
  data: function data() {
    return {
      reportContent: '',
      dialogVisible: false,
      checkList: [],
      imgPath: "../../static/images/department_propaganda.jpg",
      list: []
    };
  },
  methods: {
    //跳转到问题详情事件
    toQuestDetail: function toQuestDetail(value) {
      localStorage.setItem("articleId", value.articleId);
      this.$router.push({
        name: 'articledetails',
        params: {
          articleId: value.articleId
        }
      });
    },

    //不感兴趣
    Uninterested: function Uninterested(index) {
      var _this = this;

      this.$nextTick(function () {
        _this.list.splice(index, 1);
      });
      this.$message('以后会减少此类文章的推荐');
    }
  },
  computed: {
    imgFlag: function imgFlag() {
      return function (doc) {
        if (doc) {
          return { "width": "68%" };
        } else {
          return { "width": "96%" };
        }
      };
    }
  },
  created: function created() {
    var _this2 = this;

    return asyncToGenerator_default()( /*#__PURE__*/regenerator_default.a.mark(function _callee() {
      var result;
      return regenerator_default.a.wrap(function _callee$(_context) {
        while (1) {
          switch (_context.prev = _context.next) {
            case 0:
              _context.next = 2;
              return Object(data["T" /* ShowRandomArticle */])();

            case 2:
              result = _context.sent;

              console.log(result);
              result ? _this2.list = result["data"].result : '';

            case 5:
            case "end":
              return _context.stop();
          }
        }
      }, _callee, _this2);
    }))();
  }
});
// CONCATENATED MODULE: ./node_modules/vue-loader/lib/template-compiler?{"id":"data-v-8265142c","hasScoped":true,"transformToRequire":{"video":["src","poster"],"source":"src","img":"src","image":"xlink:href"},"buble":{"transforms":{}}}!./node_modules/vue-loader/lib/selector.js?type=template&index=0!./src/components/Bbs/Square.vue
var render = function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',[_vm._l((_vm.list),function(value,index){return _c('div',{key:index,staticClass:"square",on:{"click":function($event){return _vm.toQuestDetail(value)}}},[_c('div',{staticClass:"square_title"},[_vm._v("\n         "+_vm._s(value.title)+"\n        ")]),_vm._v(" "),_c('div',{staticClass:"square_container"},[_c('router-link',{attrs:{"to":{name:'articledetails',parmas:{id:value.id}}}},[(value.articleImage)?_c('img',{attrs:{"src":value.articleImage}}):_vm._e()]),_vm._v(" "),_c('div',{staticClass:"square_content",style:(_vm.imgFlag(value.articleImage))},[_c('span',[_vm._v("\n                "+_vm._s(value.content)+"\n              ")]),_vm._v(" "),_c('button',{staticClass:"more_btn",attrs:{"type":"button"}},[_vm._v("阅读全文")]),_vm._v(" "),_c('el-dropdown',{attrs:{"placement":"bottom"}},[_c('button',{attrs:{"type":"button"}},[_c('span',{staticClass:"el-icon-more"})]),_vm._v(" "),_c('el-dropdown-menu',{attrs:{"slot":"dropdown"},slot:"dropdown"},[_c('el-dropdown-item',{nativeOn:{"click":function($event){return _vm.Uninterested(index)}}},[_vm._v("不感兴趣")]),_vm._v(" "),_c('el-dropdown-item',{nativeOn:{"click":function($event){_vm.dialogVisible = true}}},[_vm._v("举报")])],1)],1)],1)],1)])}),_vm._v(" "),_c('el-dialog',{attrs:{"center":"","visible":_vm.dialogVisible,"width":"20%"},on:{"update:visible":function($event){_vm.dialogVisible=$event}}},[_c('div',{attrs:{"slot":"title"},slot:"title"},[_c('h2',[_vm._v("举报")]),_vm._v(" "),_c('p',{staticStyle:{"color":"#C0C4CC"}},[_vm._v("(请选择理由)")])]),_vm._v(" "),_c('div',{staticStyle:{"width":"106%"}},[_c('el-checkbox-group',{attrs:{"max":3},model:{value:(_vm.checkList),callback:function ($$v) {_vm.checkList=$$v},expression:"checkList"}},[_c('el-checkbox',{attrs:{"label":"垃圾广告"}}),_vm._v(" "),_c('el-checkbox',{attrs:{"label":"不实信息"}}),_vm._v(" "),_c('el-checkbox',{attrs:{"label":"有害信息"}}),_vm._v(" "),_c('el-checkbox',{attrs:{"label":"涉嫌侵权"}}),_vm._v(" "),_c('el-checkbox',{attrs:{"label":"诱导赞同、关注等行为"}}),_vm._v(" "),_c('el-checkbox',{attrs:{"label":"辱骂、人身攻击等不友善行为"}})],1),_vm._v(" "),_c('textarea',{directives:[{name:"model",rawName:"v-model",value:(_vm.reportContent),expression:"reportContent"}],staticClass:"report_input",attrs:{"cols":"30","rows":"10","placeholder":"请输入详细理由(选填)"},domProps:{"value":(_vm.reportContent)},on:{"input":function($event){if($event.target.composing){ return; }_vm.reportContent=$event.target.value}}})],1),_vm._v(" "),_c('span',{staticClass:"dialog-footer",attrs:{"slot":"footer"},slot:"footer"},[_c('el-button',{on:{"click":function($event){_vm.dialogVisible = false}}},[_vm._v("取 消")]),_vm._v(" "),_c('el-button',{attrs:{"type":"primary"},on:{"click":function($event){_vm.dialogVisible = false}}},[_vm._v("举报")])],1)])],2)}
var staticRenderFns = []
var esExports = { render: render, staticRenderFns: staticRenderFns }
/* harmony default export */ var Bbs_Square = (esExports);
// CONCATENATED MODULE: ./src/components/Bbs/Square.vue
function injectStyle (ssrContext) {
  __webpack_require__("9ly0")
}
var normalizeComponent = __webpack_require__("VU/8")
/* script */


/* template */

/* template functional */
var __vue_template_functional__ = false
/* styles */
var __vue_styles__ = injectStyle
/* scopeId */
var __vue_scopeId__ = "data-v-8265142c"
/* moduleIdentifier (server only) */
var __vue_module_identifier__ = null
var Component = normalizeComponent(
  Square,
  Bbs_Square,
  __vue_template_functional__,
  __vue_styles__,
  __vue_scopeId__,
  __vue_module_identifier__
)

/* harmony default export */ var components_Bbs_Square = __webpack_exports__["default"] = (Component.exports);


/***/ })

});
//# sourceMappingURL=35.d30eb8bd12a95002b768.js.map