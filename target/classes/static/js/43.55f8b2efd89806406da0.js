webpackJsonp([43],{

/***/ "CWXC":
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

// CONCATENATED MODULE: ./node_modules/babel-loader/lib!./node_modules/vue-loader/lib/selector.js?type=script&index=0!./src/components/Bbs/CollectionQuest.vue


//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//


/* harmony default export */ var CollectionQuest = ({
  data: function data() {
    return {
      //当前页码
      currentPage1: 1,
      //数据
      tableData: [],
      //总条数
      total: 0
    };
  },

  methods: {
    //返回
    comeBack: function comeBack() {
      this.$router.push({
        name: "collection"
      });
    },

    //跳转详情事件
    handleWatch: function handleWatch(index, row) {
      localStorage.setItem("questionId", row.questionId);
      this.$router.push({
        name: "questdetail", params: { title: row.questionId }
      });
    },

    //取消收藏事件
    handleDelete: function handleDelete(index, row) {
      var _this = this;

      this.$axios({
        url: "/collectionQuestion/delete",
        method: "POST",
        params: {
          questionId: row.questionId
        }
      }).then(function (res) {
        if (res.data.code == "200") {
          _this.$message({
            type: "success",
            message: "取消收藏成功",
            offset: 100
          });
          _this.tableData.splice(index, 1);
        }
      });
    },

    //
    handleSizeChange: function handleSizeChange(val) {},

    //切换页码事件
    handleCurrentChange: function handleCurrentChange(val) {
      var _this2 = this;

      return asyncToGenerator_default()( /*#__PURE__*/regenerator_default.a.mark(function _callee() {
        var result;
        return regenerator_default.a.wrap(function _callee$(_context) {
          while (1) {
            switch (_context.prev = _context.next) {
              case 0:
                _context.next = 2;
                return Object(data["m" /* CollectionQuestion */])(_this2.$GetUserId() + "/" + val + "/6");

              case 2:
                result = _context.sent;

                _this2.tableData = result["data"].result.data;

              case 4:
              case "end":
                return _context.stop();
            }
          }
        }, _callee, _this2);
      }))();
    }
  },
  created: function created() {
    var _this3 = this;

    return asyncToGenerator_default()( /*#__PURE__*/regenerator_default.a.mark(function _callee2() {
      var result;
      return regenerator_default.a.wrap(function _callee2$(_context2) {
        while (1) {
          switch (_context2.prev = _context2.next) {
            case 0:
              _context2.next = 2;
              return Object(data["m" /* CollectionQuestion */])(_this3.$GetUserId() + "/1/6");

            case 2:
              result = _context2.sent;

              if (result["data"].result.allDataNum != 0) {
                _this3.tableData = result["data"].result.data;
                _this3.total = result["data"].result.allDataNUm;
              }

            case 4:
            case "end":
              return _context2.stop();
          }
        }
      }, _callee2, _this3);
    }))();
  }
});
// CONCATENATED MODULE: ./node_modules/vue-loader/lib/template-compiler?{"id":"data-v-35d6cc88","hasScoped":true,"transformToRequire":{"video":["src","poster"],"source":"src","img":"src","image":"xlink:href"},"buble":{"transforms":{}}}!./node_modules/vue-loader/lib/selector.js?type=template&index=0!./src/components/Bbs/CollectionQuest.vue
var render = function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',{staticClass:"CollectionQuest_container"},[_c('div',{staticClass:"CollectionQuest_header"},[_c('span',{on:{"click":_vm.comeBack}},[_vm._v("返回")]),_vm._v(" "),_c('span',[_vm._v("我收藏的问题")])]),_vm._v(" "),(_vm.total!=0)?_c('div',{staticClass:"CollectionQuest_mainer"},[_c('el-table',{staticStyle:{"width":"100%"},attrs:{"data":_vm.tableData}},[_c('el-table-column',{attrs:{"align":"center","label":"问题名","width":"180"},scopedSlots:_vm._u([{key:"default",fn:function(scope){return [_c('span',{staticStyle:{"margin-left":"10px"}},[_vm._v(_vm._s(scope.row.title))])]}}],null,false,1398263620)}),_vm._v(" "),_c('el-table-column',{attrs:{"align":"center","label":"提问时间","width":"180"},scopedSlots:_vm._u([{key:"default",fn:function(scope){return [_vm._v("\n            "+_vm._s(scope.row.createTime)+"\n        ")]}}],null,false,2046066604)}),_vm._v(" "),_c('el-table-column',{attrs:{"label":"操作","align":"center"},scopedSlots:_vm._u([{key:"default",fn:function(scope){return [_c('el-tooltip',{attrs:{"content":"查看详情","placement":"top","effect":"light"}},[_c('el-button',{attrs:{"icon":"el-icon-search","circle":"","size":"medium"},on:{"click":function($event){return _vm.handleWatch(scope.$index, scope.row)}}})],1),_vm._v(" "),_c('el-tooltip',{attrs:{"content":"取消收藏","placement":"top","effect":"light"}},[_c('el-button',{attrs:{"icon":"el-icon-delete","circle":"","size":"medium","type":"danger"},on:{"click":function($event){return _vm.handleDelete(scope.$index, scope.row)}}})],1)]}}],null,false,2872326504)})],1),_vm._v(" "),_c('el-pagination',{staticStyle:{"text-align":"center"},attrs:{"current-page":_vm.currentPage1,"page-size":6,"layout":"total, prev, pager, next","total":_vm.total},on:{"size-change":_vm.handleSizeChange,"current-change":_vm.handleCurrentChange,"update:currentPage":function($event){_vm.currentPage1=$event},"update:current-page":function($event){_vm.currentPage1=$event}}})],1):_c('div',{staticClass:"CollectionQuest_null"},[_c('span',[_vm._v("还未收藏任何问题呢")]),_vm._v(" "),_c('router-link',{attrs:{"to":"/campus/square"}},[_vm._v("去逛逛")])],1)])}
var staticRenderFns = []
var esExports = { render: render, staticRenderFns: staticRenderFns }
/* harmony default export */ var Bbs_CollectionQuest = (esExports);
// CONCATENATED MODULE: ./src/components/Bbs/CollectionQuest.vue
function injectStyle (ssrContext) {
  __webpack_require__("KJtC")
}
var normalizeComponent = __webpack_require__("VU/8")
/* script */


/* template */

/* template functional */
var __vue_template_functional__ = false
/* styles */
var __vue_styles__ = injectStyle
/* scopeId */
var __vue_scopeId__ = "data-v-35d6cc88"
/* moduleIdentifier (server only) */
var __vue_module_identifier__ = null
var Component = normalizeComponent(
  CollectionQuest,
  Bbs_CollectionQuest,
  __vue_template_functional__,
  __vue_styles__,
  __vue_scopeId__,
  __vue_module_identifier__
)

/* harmony default export */ var components_Bbs_CollectionQuest = __webpack_exports__["default"] = (Component.exports);


/***/ }),

/***/ "KJtC":
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ })

});
//# sourceMappingURL=43.55f8b2efd89806406da0.js.map