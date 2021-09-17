webpackJsonp([24],{

/***/ "PZM5":
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ "PgDl":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });

// EXTERNAL MODULE: ./node_modules/babel-loader/lib!./node_modules/vue-loader/lib/selector.js?type=script&index=0!./src/components/Department/ActivityDetail.vue
var ActivityDetail = __webpack_require__("quLo");

// CONCATENATED MODULE: ./node_modules/vue-loader/lib/template-compiler?{"id":"data-v-ac46a30a","hasScoped":true,"transformToRequire":{"video":["src","poster"],"source":"src","img":"src","image":"xlink:href"},"buble":{"transforms":{}}}!./node_modules/vue-loader/lib/selector.js?type=template&index=0!./src/components/Department/ActivityDetail.vue
var render = function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',[_vm._m(0),_vm._v(" "),_c('div',{staticClass:"ActivityDetail_container"},[_c('div',{staticClass:"ActivityDetail_img"},[_c('div',{staticClass:"img_container"},[_c('el-carousel',{attrs:{"height":"400px","direction":"vertical","autoplay":false}},_vm._l((3),function(item){return _c('el-carousel-item',{key:item},[_c('h3',{staticClass:"medium"},[_vm._v(_vm._s(item))])])}),1)],1)]),_vm._v(" "),_c('div',{staticClass:"ActivityDetail_info"},[_vm._m(1),_vm._v(" "),_c('div',{staticClass:"ActivityDetail_data"},[_c('span',[_vm._v(_vm._s(_vm.data.activityTitle))]),_vm._v(" "),_c('span',[_vm._v(_vm._s(_vm.data.userRealName))]),_vm._v(" "),_c('span',[_vm._v(_vm._s(_vm.data.recruitStartTime)+"~"+_vm._s(_vm.data.recruitEndTime))]),_vm._v(" "),_c('span',[_vm._v(_vm._s(_vm.data.activityPlace))]),_vm._v(" "),_c('span',[_vm._v(_vm._s(_vm.data.totalNum))]),_vm._v(" "),_c('span',[_vm._v(_vm._s(_vm.data.joinNum)+"/"+_vm._s(_vm.data.totalNum))]),_vm._v(" "),_c('span'),_vm._v(" "),_c('span',[_vm._v(_vm._s(_vm.data.activityContent))]),_vm._v(" "),_c('div',{staticClass:"ActivityDetail_btn"},[_c('el-button',{attrs:{"type":"primary","disabled":_vm.DisabledFlay()},on:{"click":function($event){return _vm.handleSingUp(_vm.data)}}},[_vm._v(_vm._s(_vm.JoinFlay()))]),_vm._v(" "),_c('el-button',{on:{"click":_vm.backActivityList}},[_vm._v("返回")])],1)])])])])}
var staticRenderFns = [function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',{staticClass:"ActivityDetail_header"},[_c('span',[_vm._v("活动详情")])])},function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',{staticClass:"ActivityDetail_tis"},[_c('span',[_vm._v("活动名称:")]),_vm._v(" "),_c('span',[_vm._v("发起人:")]),_vm._v(" "),_c('span',[_vm._v("活动时间:")]),_vm._v(" "),_c('span',[_vm._v("活动地址:")]),_vm._v(" "),_c('span',[_vm._v("限制人数:")]),_vm._v(" "),_c('span',[_vm._v("活动人数:")]),_vm._v(" "),_c('span',[_vm._v("活动状态:")]),_vm._v(" "),_c('span',[_vm._v("活动描述:")])])}]
var esExports = { render: render, staticRenderFns: staticRenderFns }
/* harmony default export */ var Department_ActivityDetail = (esExports);
// CONCATENATED MODULE: ./src/components/Department/ActivityDetail.vue
function injectStyle (ssrContext) {
  __webpack_require__("PZM5")
}
var normalizeComponent = __webpack_require__("VU/8")
/* script */


/* template */

/* template functional */
var __vue_template_functional__ = false
/* styles */
var __vue_styles__ = injectStyle
/* scopeId */
var __vue_scopeId__ = "data-v-ac46a30a"
/* moduleIdentifier (server only) */
var __vue_module_identifier__ = null
var Component = normalizeComponent(
  ActivityDetail["a" /* default */],
  Department_ActivityDetail,
  __vue_template_functional__,
  __vue_styles__,
  __vue_scopeId__,
  __vue_module_identifier__
)

/* harmony default export */ var components_Department_ActivityDetail = __webpack_exports__["default"] = (Component.exports);


/***/ }),

/***/ "quLo":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function($) {/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_json_stringify__ = __webpack_require__("mvHQ");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_json_stringify___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_json_stringify__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator__ = __webpack_require__("Xxa5");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator__ = __webpack_require__("exGp");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__api_data__ = __webpack_require__("Foau");



//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
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
      data: {}
    };
  },

  methods: {
    //返回
    backActivityList: function backActivityList() {
      this.$router.push({
        name: "活动/全部活动"
      });
    },

    //点击报名
    handleSingUp: function handleSingUp(value) {
      var _this = this;

      return __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator___default()( /*#__PURE__*/__WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.mark(function _callee() {
        var result, _result;

        return __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.wrap(function _callee$(_context) {
          while (1) {
            switch (_context.prev = _context.next) {
              case 0:
                if (!value.join) {
                  _context.next = 8;
                  break;
                }

                _context.next = 3;
                return Object(__WEBPACK_IMPORTED_MODULE_3__api_data__["f" /* CancelJoin */])({ activityId: value.activityId });

              case 3:
                result = _context.sent;

                console.log(result);
                if (result['data'].code == "200") {
                  _this.message("success", "取消成功");
                  value.joinNum--;
                  value.join = false;
                }
                _context.next = 13;
                break;

              case 8:
                _context.next = 10;
                return Object(__WEBPACK_IMPORTED_MODULE_3__api_data__["d" /* AddJoinActivity */])({ activityId: value.activityId });

              case 10:
                _result = _context.sent;

                console.log(_result);
                if (_result["data"].code == "200") {
                  _this.message("success", "报名成功");
                  value.joinNum++;
                  value.join = true;
                }

              case 13:
              case 'end':
                return _context.stop();
            }
          }
        }, _callee, _this);
      }))();
    },

    //按钮状态
    DisabledFlay: function DisabledFlay() {
      if (!$.isEmptyObject(this.data)) {
        if (!this.data.join) {
          if (this.data.joinNum < this.data.totalNum) {
            return false;
          } else {
            return true;
          }
        }
      }
    },

    //按钮文字提醒
    JoinFlay: function JoinFlay() {
      if (!$.isEmptyObject(this.data)) {
        if (!this.data.join) {
          if (this.data.joinNum == this.data.totalNum) {
            return "人数已满";
          } else {
            return "点击报名";
          }
        } else {
          return "取消报名";
        }
      }
    }
  },
  computed: {},
  created: function created() {
    var _this2 = this;

    return __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_asyncToGenerator___default()( /*#__PURE__*/__WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.mark(function _callee2() {
      var activityId, result;
      return __WEBPACK_IMPORTED_MODULE_1_babel_runtime_regenerator___default.a.wrap(function _callee2$(_context2) {
        while (1) {
          switch (_context2.prev = _context2.next) {
            case 0:
              activityId = void 0;

              if (__WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_json_stringify___default()(_this2.$route.params) == "{}") {
                activityId = localStorage.getItem("activityId");
              } else {
                activityId = _this2.$route.params.activityId;
              }
              _context2.next = 4;
              return Object(__WEBPACK_IMPORTED_MODULE_3__api_data__["y" /* GetDetailActivity */])({ activityId: activityId });

            case 4:
              result = _context2.sent;

              console.log(result);
              _this2.data = result["data"].result;

            case 7:
            case 'end':
              return _context2.stop();
          }
        }
      }, _callee2, _this2);
    }))();
  }
});
/* WEBPACK VAR INJECTION */}.call(__webpack_exports__, __webpack_require__("7t+N")))

/***/ })

});
//# sourceMappingURL=24.4d06da2c018240fe470e.js.map