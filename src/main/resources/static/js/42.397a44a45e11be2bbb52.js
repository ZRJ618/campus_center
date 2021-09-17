webpackJsonp([42],{

/***/ "DO9/":
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ "KqiU":
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

// CONCATENATED MODULE: ./node_modules/babel-loader/lib!./node_modules/vue-loader/lib/selector.js?type=script&index=0!./src/components/Department/WatchActivity.vue


//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//


/* harmony default export */ var WatchActivity = ({
  data: function data() {
    return {
      status: '',
      //搜索类型
      searchType: 0,
      //输入框内容
      result: '',
      //总条数
      totalnum: 0,
      //页码
      currentPage1: 1,
      //数据
      data: []
    };
  },

  methods: {
    //查找全部活动
    getActivityAll: function getActivityAll() {
      var _this = this;

      return asyncToGenerator_default()( /*#__PURE__*/regenerator_default.a.mark(function _callee() {
        var result;
        return regenerator_default.a.wrap(function _callee$(_context) {
          while (1) {
            switch (_context.prev = _context.next) {
              case 0:
                _context.next = 2;
                return Object(data["w" /* GetActivityList */])({ pageNum: 1 });

              case 2:
                result = _context.sent;

                _this.data = result["data"].result.data;
                _this.totalnum = result["data"].result.total;
                _this.currentPage1 = 1;

              case 6:
              case 'end':
                return _context.stop();
            }
          }
        }, _callee, _this);
      }))();
    },

    //按照活动状态搜索
    getActivityByStatus: function getActivityByStatus() {
      var _this2 = this;

      return asyncToGenerator_default()( /*#__PURE__*/regenerator_default.a.mark(function _callee2() {
        var result;
        return regenerator_default.a.wrap(function _callee2$(_context2) {
          while (1) {
            switch (_context2.prev = _context2.next) {
              case 0:
                _context2.next = 2;
                return Object(data["w" /* GetActivityList */])({ activityStatus: _this2.status, pageNum: 1 });

              case 2:
                result = _context2.sent;

                console.log(result);
                if (result["data"].code == "200") {
                  _this2.data = result["data"].result.data;
                  _this2.totalnum = result["data"].result.total;
                  _this2.searchType = 3;
                  _this2.message("success", '\u5171\u627E\u5230' + _this2.totalnum + '\u6761\u8BB0\u5F55');
                  _this2.currentPage1 = 1;
                } else if (result["data"].code == "500") {
                  _this2.message("warning", '\u6682\u65E0' + _this2.status + '\u7684\u6D3B\u52A8');
                }

              case 5:
              case 'end':
                return _context2.stop();
            }
          }
        }, _callee2, _this2);
      }))();
    },

    //搜索活动
    handleSearch: function handleSearch() {
      var _this3 = this;

      return asyncToGenerator_default()( /*#__PURE__*/regenerator_default.a.mark(function _callee3() {
        var result, res;
        return regenerator_default.a.wrap(function _callee3$(_context3) {
          while (1) {
            switch (_context3.prev = _context3.next) {
              case 0:
                _context3.next = 2;
                return Object(data["w" /* GetActivityList */])({ activityTitle: _this3.result, pageNum: 1 });

              case 2:
                result = _context3.sent;

                if (!(result["data"].code == "200")) {
                  _context3.next = 11;
                  break;
                }

                _this3.data = result["data"].result.data;
                _this3.totalnum = result["data"].result.total;
                _this3.searchType = 1;
                _this3.currentPage1 = 1;
                _this3.message("success", '\u5171\u627E\u5230' + _this3.totalnum + '\u6761\u8BB0\u5F55');
                _context3.next = 16;
                break;

              case 11:
                if (!(result["data"].code == "500")) {
                  _context3.next = 16;
                  break;
                }

                _context3.next = 14;
                return Object(data["w" /* GetActivityList */])({ activityPlace: _this3.result, pageNum: 1 });

              case 14:
                res = _context3.sent;

                if (res["data"].code == "200") {
                  _this3.currentPage1 = 1;
                  _this3.data = res["data"].result.data;
                  _this3.totalnum = res["data"].result.pageNum;
                  _this3.searchType = 2;
                  _this3.message("success", '\u5171\u627E\u5230' + _this3.totalnum + '\u6761\u8BB0\u5F55');
                } else if (res["data"].code == "500") {
                  _this3.message("warning", '\u6682\u65E0\u5173\u4E8E ' + _this3.result + ' \u641C\u7D22\u7ED3\u679C,\u8BF7\u68C0\u67E5\u5173\u952E\u8BCD');
                }

              case 16:
              case 'end':
                return _context3.stop();
            }
          }
        }, _callee3, _this3);
      }))();
    },
    handleSizeChange: function handleSizeChange(val) {},

    //切换页面
    handleCurrentChange: function handleCurrentChange(val) {
      var _this4 = this;

      return asyncToGenerator_default()( /*#__PURE__*/regenerator_default.a.mark(function _callee4() {
        var obj, result;
        return regenerator_default.a.wrap(function _callee4$(_context4) {
          while (1) {
            switch (_context4.prev = _context4.next) {
              case 0:
                obj = { pageNum: val };

                if (_this4.searchType == 1) {
                  Object.defineProperty(obj, 'activityTitle', {
                    value: _this4.result,
                    writable: true,
                    enumerable: true,
                    configurable: true
                  });
                } else if (_this4.searchType == 2) {
                  Object.defineProperty(obj, 'activityPlace', {
                    value: _this4.result,
                    writable: true,
                    enumerable: true,
                    configurable: true
                  });
                } else if (_this4.searchType == 3) {
                  Object.defineProperty(obj, 'activityStatus', {
                    value: _this4.status,
                    writable: true,
                    enumerable: true,
                    configurable: true
                  });
                }
                _context4.next = 4;
                return Object(data["w" /* GetActivityList */])(obj);

              case 4:
                result = _context4.sent;

                _this4.data = result["data"].result.data;

              case 6:
              case 'end':
                return _context4.stop();
            }
          }
        }, _callee4, _this4);
      }))();
    },
    ToActivityDetail: function ToActivityDetail(value) {
      localStorage.setItem("activityId", value.activityId);
      this.$router.push({
        path: "/department/detail-activity", params: { activityId: value.activityId }
      });
    }
  },
  watch: {
    status: function status(orderV, newV) {
      console.log(orderV);
      console.log(newV);
    }
  },
  created: function created() {
    var _this5 = this;

    return asyncToGenerator_default()( /*#__PURE__*/regenerator_default.a.mark(function _callee5() {
      var result;
      return regenerator_default.a.wrap(function _callee5$(_context5) {
        while (1) {
          switch (_context5.prev = _context5.next) {
            case 0:
              _context5.next = 2;
              return Object(data["w" /* GetActivityList */])({
                pageNum: 1
              });

            case 2:
              result = _context5.sent;

              _this5.data = result["data"].result.data;
              _this5.totalnum = result["data"].result.total;
              console.log(result);

            case 6:
            case 'end':
              return _context5.stop();
          }
        }
      }, _callee5, _this5);
    }))();
  }
});
// CONCATENATED MODULE: ./node_modules/vue-loader/lib/template-compiler?{"id":"data-v-14bee815","hasScoped":true,"transformToRequire":{"video":["src","poster"],"source":"src","img":"src","image":"xlink:href"},"buble":{"transforms":{}}}!./node_modules/vue-loader/lib/selector.js?type=template&index=0!./src/components/Department/WatchActivity.vue
var render = function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',{staticClass:"WatchActivity_container"},[_vm._m(0),_vm._v(" "),_c('div',{staticClass:"WatchActivity_mainer"},[_c('div',{staticClass:"WatchActivity_content"},[_c('div',[_c('div',{staticClass:"WatchActivity_nav"},[_c('div',{staticClass:"search_status"},[_c('span',{on:{"click":_vm.getActivityAll}},[_vm._v("全部活动")]),_vm._v(" "),_c('span',[_vm._v("活动状态:")]),_vm._v(" "),_c('select',{directives:[{name:"model",rawName:"v-model",value:(_vm.status),expression:"status"}],on:{"change":[function($event){var $$selectedVal = Array.prototype.filter.call($event.target.options,function(o){return o.selected}).map(function(o){var val = "_value" in o ? o._value : o.value;return val}); _vm.status=$event.target.multiple ? $$selectedVal : $$selectedVal[0]},_vm.getActivityByStatus]}},[_c('option',{attrs:{"value":"未开始"}},[_vm._v("未开始")]),_vm._v(" "),_c('option',{attrs:{"value":"招募中"}},[_vm._v("报名中")]),_vm._v(" "),_c('option',{attrs:{"value":"进行中"}},[_vm._v("进行中")]),_vm._v(" "),_c('option',{attrs:{"value":"招募人数已满"}},[_vm._v("报名人数已满")]),_vm._v(" "),_c('option',{attrs:{"value":"活动结束"}},[_vm._v("活动结束")])])]),_vm._v(" "),_c('div',{staticClass:"Activity_search"},[_c('button',{attrs:{"type":"button"},on:{"click":_vm.handleSearch}},[_vm._v("搜索")]),_vm._v(" "),_c('input',{directives:[{name:"model",rawName:"v-model",value:(_vm.result),expression:"result"}],attrs:{"type":"search","placeholder":"活动主题/活动地点"},domProps:{"value":(_vm.result)},on:{"keyup":function($event){if(!$event.type.indexOf('key')&&_vm._k($event.keyCode,"enter",13,$event.key,"Enter")){ return null; }return _vm.handleSearch($event)},"input":function($event){if($event.target.composing){ return; }_vm.result=$event.target.value}}})])]),_vm._v(" "),_vm._l((_vm.data),function(value,key){return _c('div',{key:key,staticClass:"WatchActivity_data"},[_c('img',{attrs:{"src":value.activityImage}}),_vm._v(" "),_c('div',{staticClass:"activity_info"},[_vm._m(1,true),_vm._v(" "),_c('div',{staticClass:"info_content"},[_c('span',[_vm._v(_vm._s(value.activityTitle))]),_vm._v(" "),_c('span',[_vm._v(_vm._s(value.realName))]),_vm._v(" "),_c('span',[_vm._v(_vm._s(value.createTime))]),_vm._v(" "),_c('span',[_vm._v(_vm._s(value.activityStatus))])]),_vm._v(" "),_c('div',{staticClass:"info_operation"},[_c('span',{on:{"click":function($event){return _vm.ToActivityDetail(value)}}},[_vm._v("查看详情")])])])])})],2),_vm._v(" "),_c('el-pagination',{staticStyle:{"text-align":"center"},attrs:{"current-page":_vm.currentPage1,"page-size":8,"layout":"total, prev, pager, next","total":_vm.totalnum},on:{"size-change":_vm.handleSizeChange,"current-change":_vm.handleCurrentChange,"update:currentPage":function($event){_vm.currentPage1=$event},"update:current-page":function($event){_vm.currentPage1=$event}}})],1)])])}
var staticRenderFns = [function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',{staticClass:"WatchActivity_header"},[_c('span',[_vm._v("全部活动")])])},function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',{staticClass:"info_tips"},[_c('span',[_vm._v("活动主题:")]),_vm._v(" "),_c('span',[_vm._v("发起人:")]),_vm._v(" "),_c('span',[_vm._v("发起时间:")]),_vm._v(" "),_c('span',[_vm._v("活动状态:")])])}]
var esExports = { render: render, staticRenderFns: staticRenderFns }
/* harmony default export */ var Department_WatchActivity = (esExports);
// CONCATENATED MODULE: ./src/components/Department/WatchActivity.vue
function injectStyle (ssrContext) {
  __webpack_require__("DO9/")
}
var normalizeComponent = __webpack_require__("VU/8")
/* script */


/* template */

/* template functional */
var __vue_template_functional__ = false
/* styles */
var __vue_styles__ = injectStyle
/* scopeId */
var __vue_scopeId__ = "data-v-14bee815"
/* moduleIdentifier (server only) */
var __vue_module_identifier__ = null
var Component = normalizeComponent(
  WatchActivity,
  Department_WatchActivity,
  __vue_template_functional__,
  __vue_styles__,
  __vue_scopeId__,
  __vue_module_identifier__
)

/* harmony default export */ var components_Department_WatchActivity = __webpack_exports__["default"] = (Component.exports);


/***/ })

});
//# sourceMappingURL=42.397a44a45e11be2bbb52.js.map