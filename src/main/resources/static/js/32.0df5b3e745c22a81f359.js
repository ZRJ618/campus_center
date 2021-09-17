webpackJsonp([32],{

/***/ "DXd9":
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ "Fxan":
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

// CONCATENATED MODULE: ./node_modules/babel-loader/lib!./node_modules/vue-loader/lib/selector.js?type=script&index=0!./src/components/Department/MyDepartment.vue



//获取部门信息
var GetMyDeps = function () {
  var _ref = asyncToGenerator_default()( /*#__PURE__*/regenerator_default.a.mark(function _callee(userId) {
    var result;
    return regenerator_default.a.wrap(function _callee$(_context) {
      while (1) {
        switch (_context.prev = _context.next) {
          case 0:
            _context.next = 2;
            return Object(data["A" /* GetMyDep */])({ userId: userId });

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

  return function GetMyDeps(_x) {
    return _ref.apply(this, arguments);
  };
}();

//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//


/* harmony default export */ var MyDepartment = ({
  data: function data() {
    return {
      Department: {}
    };
  },

  methods: {
    handleClick: function handleClick() {
      this.$router.push({
        path: "/department/admin-department"
      });
    }
  },
  mounted: function mounted() {},
  created: function created() {
    var _this = this;

    GetMyDeps(this.$GetUserId()).then(function (res) {
      console.log(_this.$GetUserId());
      console.log(res);
      _this.Department = res["data"].result;
      if (res["data"].result != null) {
        if (res["data"].result.position == "干事") {
          _this.$store.commit("JurisdictionUser");
        } else {
          _this.$store.commit("JurisdictionAdmin");
        }
      }
    });
  }
});
// CONCATENATED MODULE: ./node_modules/vue-loader/lib/template-compiler?{"id":"data-v-657d383e","hasScoped":true,"transformToRequire":{"video":["src","poster"],"source":"src","img":"src","image":"xlink:href"},"buble":{"transforms":{}}}!./node_modules/vue-loader/lib/selector.js?type=template&index=0!./src/components/Department/MyDepartment.vue
var render = function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',[_vm._m(0),_vm._v(" "),(_vm.Department!=null)?_c('div',{staticClass:"Department_container"},[_c('div',{staticClass:"Department_img"},[_c('el-carousel',{attrs:{"interval":5000,"indicator-position":"outside","height":"450px"}},_vm._l((_vm.Department.depImageList),function(item){return _c('el-carousel-item',{key:item},[_c('img',{staticClass:"Department_img",attrs:{"src":__webpack_require__("HdUg")}})])}),1)],1),_vm._v(" "),_c('div',{staticClass:"Department_info"},[_vm._m(1),_vm._v(" "),_c('div',{staticClass:"Department_data"},[_c('span',[_vm._v(_vm._s(_vm.Department.departmentName))]),_vm._v(" "),_c('span',[_vm._v(_vm._s(_vm.Department.peopleNum))]),_vm._v(" "),_c('span',[_vm._v("52")]),_vm._v(" "),_c('span',[_vm._v(_vm._s(_vm.Department.position))]),_vm._v(" "),_c('span',[_vm._v(_vm._s(_vm.Department.parentName))]),_vm._v(" "),_c('span',{staticClass:"Department_introduction"},[_vm._v(_vm._s(_vm.Department.briefIntroduce))]),_vm._v(" "),_c('div',{staticClass:"Department_operation"},[_c('el-button',[_vm._v("点我")]),_vm._v(" "),_c('el-button',{attrs:{"type":"primary"}},[_vm._v("查看近期活动 ")]),_vm._v(" "),(_vm.Department.position!='干事')?_c('el-button',{attrs:{"type":"primary"},on:{"click":_vm.handleClick}},[_vm._v("管理部门")]):_vm._e()],1)])])]):_vm._e()])}
var staticRenderFns = [function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',{staticClass:"Departemnt_header"},[_c('span',[_vm._v("我的部门")])])},function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',{staticClass:"Dapartment_tis"},[_c('span',[_vm._v("部门名称:")]),_vm._v(" "),_c('span',[_vm._v("部门人数:")]),_vm._v(" "),_c('span',[_vm._v("活跃程度:")]),_vm._v(" "),_c('span',[_vm._v("我的职位:")]),_vm._v(" "),_c('span',[_vm._v("部门所属")]),_vm._v(" "),_c('span',{staticClass:"Department_introduction"},[_vm._v("部门简介:")])])}]
var esExports = { render: render, staticRenderFns: staticRenderFns }
/* harmony default export */ var Department_MyDepartment = (esExports);
// CONCATENATED MODULE: ./src/components/Department/MyDepartment.vue
function injectStyle (ssrContext) {
  __webpack_require__("DXd9")
}
var normalizeComponent = __webpack_require__("VU/8")
/* script */


/* template */

/* template functional */
var __vue_template_functional__ = false
/* styles */
var __vue_styles__ = injectStyle
/* scopeId */
var __vue_scopeId__ = "data-v-657d383e"
/* moduleIdentifier (server only) */
var __vue_module_identifier__ = null
var Component = normalizeComponent(
  MyDepartment,
  Department_MyDepartment,
  __vue_template_functional__,
  __vue_styles__,
  __vue_scopeId__,
  __vue_module_identifier__
)

/* harmony default export */ var components_Department_MyDepartment = __webpack_exports__["default"] = (Component.exports);


/***/ })

});
//# sourceMappingURL=32.0df5b3e745c22a81f359.js.map