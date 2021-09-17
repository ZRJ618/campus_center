webpackJsonp([43],{

/***/ "H5fL":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });

// EXTERNAL MODULE: ./node_modules/babel-runtime/regenerator/index.js
var regenerator = __webpack_require__("Xxa5");
var regenerator_default = /*#__PURE__*/__webpack_require__.n(regenerator);

// EXTERNAL MODULE: ./node_modules/babel-runtime/helpers/asyncToGenerator.js
var asyncToGenerator = __webpack_require__("exGp");
var asyncToGenerator_default = /*#__PURE__*/__webpack_require__.n(asyncToGenerator);

// EXTERNAL MODULE: ./src/api/data.js + 2 modules
var data = __webpack_require__("Foau");

// CONCATENATED MODULE: ./node_modules/babel-loader/lib!./node_modules/vue-loader/lib/selector.js?type=script&index=0!./src/components/Bbs/CollectionArticle.vue


//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//


/* harmony default export */ var CollectionArticle = ({
  data: function data() {
    return {
      //当前页码
      currentPage1: 5,
      //数据
      tableData: [],
      //条数
      total: 0
    };
  },

  methods: {
    comeBack: function comeBack() {
      this.$router.push({
        name: "collection"
      });
    },
    handleEdit: function handleEdit(index, row) {
      console.log(index, row);
    },
    handleDelete: function handleDelete(index, row) {
      console.log(index, row);
    },
    handleSizeChange: function handleSizeChange(val) {
      console.log("\u6BCF\u9875 " + val + " \u6761");
    },
    handleCurrentChange: function handleCurrentChange(val) {
      var _this = this;

      return asyncToGenerator_default()( /*#__PURE__*/regenerator_default.a.mark(function _callee() {
        var result;
        return regenerator_default.a.wrap(function _callee$(_context) {
          while (1) {
            switch (_context.prev = _context.next) {
              case 0:
                _context.next = 2;
                return Object(data["h" /* CollectionArticle */])(_this.$GetUserId() + "/" + val);

              case 2:
                result = _context.sent;

                _this.tableData = result["data"].result.data;

              case 4:
              case "end":
                return _context.stop();
            }
          }
        }, _callee, _this);
      }))();
    }
  },
  created: function created() {
    var _this2 = this;

    return asyncToGenerator_default()( /*#__PURE__*/regenerator_default.a.mark(function _callee2() {
      var result;
      return regenerator_default.a.wrap(function _callee2$(_context2) {
        while (1) {
          switch (_context2.prev = _context2.next) {
            case 0:
              _context2.next = 2;
              return Object(data["h" /* CollectionArticle */])(_this2.$GetUserId() + "/1");

            case 2:
              result = _context2.sent;

              if (result["data"].result.allDataNum != 0) {
                _this2.total = result["data"].result.allDataNum;
                _this2.tableData = result["data"].result.data;
              }

            case 4:
            case "end":
              return _context2.stop();
          }
        }
      }, _callee2, _this2);
    }))();
  }
});
// CONCATENATED MODULE: ./node_modules/vue-loader/lib/template-compiler?{"id":"data-v-11aefe37","hasScoped":true,"transformToRequire":{"video":["src","poster"],"source":"src","img":"src","image":"xlink:href"},"buble":{"transforms":{}}}!./node_modules/vue-loader/lib/selector.js?type=template&index=0!./src/components/Bbs/CollectionArticle.vue
var render = function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',{staticClass:"CollectionArticle_container"},[_c('div',{staticClass:"CollectionArticle_header"},[_c('span',{on:{"click":_vm.comeBack}},[_vm._v("返回")]),_vm._v(" "),_c('span',[_vm._v("我收藏的文章")])]),_vm._v(" "),(_vm.total!=0)?_c('div',{staticClass:"CollectionArticle_mainer"},[_c('el-table',{staticStyle:{"width":"100%"},attrs:{"data":_vm.tableData}},[_c('el-table-column',{attrs:{"align":"center","label":"文章名","width":"180"},scopedSlots:_vm._u([{key:"default",fn:function(scope){return [_c('i',{staticClass:"el-icon-time"}),_vm._v(" "),_c('span',{staticStyle:{"margin-left":"10px"}},[_vm._v(_vm._s(scope.row.date))])]}}],null,false,1846363197)}),_vm._v(" "),_c('el-table-column',{attrs:{"align":"center","label":"作者","width":"180"},scopedSlots:_vm._u([{key:"default",fn:function(scope){return [_c('div',{staticClass:"name-wrapper",attrs:{"slot":"reference"},slot:"reference"},[_c('el-tag',{attrs:{"size":"medium"}},[_vm._v(_vm._s(scope.row.name))])],1)]}}],null,false,3547087485)}),_vm._v(" "),_c('el-table-column',{attrs:{"label":"操作","align":"center"},scopedSlots:_vm._u([{key:"default",fn:function(scope){return [_c('el-tooltip',{attrs:{"content":"查看详情","placement":"top","effect":"light"}},[_c('el-button',{attrs:{"icon":"el-icon-search","circle":"","size":"medium"},on:{"click":function($event){return _vm.handleEdit(scope.$index, scope.row)}}})],1),_vm._v(" "),_c('el-tooltip',{attrs:{"content":"取消收藏","placement":"top","effect":"light"}},[_c('el-button',{attrs:{"icon":"el-icon-delete","circle":"","size":"medium","type":"danger"},on:{"click":function($event){return _vm.handleDelete(scope.$index, scope.row)}}})],1)]}}],null,false,3596625405)})],1),_vm._v(" "),_c('el-pagination',{staticStyle:{"text-align":"center"},attrs:{"current-page":_vm.currentPage1,"page-size":6,"layout":"total, prev, pager, next","total":_vm.total},on:{"size-change":_vm.handleSizeChange,"current-change":_vm.handleCurrentChange,"update:currentPage":function($event){_vm.currentPage1=$event},"update:current-page":function($event){_vm.currentPage1=$event}}})],1):_c('div',{staticClass:"CollectionArticle_null"},[_c('span',[_vm._v("还未收藏任何文章呢")]),_vm._v(" "),_c('router-link',{attrs:{"to":"/campus/square"}},[_vm._v("去逛逛")])],1)])}
var staticRenderFns = []
var esExports = { render: render, staticRenderFns: staticRenderFns }
/* harmony default export */ var Bbs_CollectionArticle = (esExports);
// CONCATENATED MODULE: ./src/components/Bbs/CollectionArticle.vue
function injectStyle (ssrContext) {
  __webpack_require__("TH/b")
}
var normalizeComponent = __webpack_require__("VU/8")
/* script */


/* template */

/* template functional */
var __vue_template_functional__ = false
/* styles */
var __vue_styles__ = injectStyle
/* scopeId */
var __vue_scopeId__ = "data-v-11aefe37"
/* moduleIdentifier (server only) */
var __vue_module_identifier__ = null
var Component = normalizeComponent(
  CollectionArticle,
  Bbs_CollectionArticle,
  __vue_template_functional__,
  __vue_styles__,
  __vue_scopeId__,
  __vue_module_identifier__
)

/* harmony default export */ var components_Bbs_CollectionArticle = __webpack_exports__["default"] = (Component.exports);


/***/ }),

/***/ "TH/b":
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ })

});
//# sourceMappingURL=43.57588b67b95b2953c75a.js.map