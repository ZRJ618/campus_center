webpackJsonp([28],{

/***/ "6KNY":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function($) {//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
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
  name: "hotlist",
  data: function data() {
    return {
      activeName: 'hoslist'
    };
  },

  methods: {},
  created: function created() {
    var _this = this;

    this.$nextTick(function () {
      _this.activeName = _this.$route.name;
    });
  },
  mounted: function mounted() {
    $(".menu_nav li").on("click", function (e) {
      $(".menu_nav li").css("color", "");
      e.target.style.color = "#409EFF";
    });
  }
});
/* WEBPACK VAR INJECTION */}.call(__webpack_exports__, __webpack_require__("7t+N")))

/***/ }),

/***/ "BgNe":
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ "JJtI":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });

// EXTERNAL MODULE: ./node_modules/babel-loader/lib!./node_modules/vue-loader/lib/selector.js?type=script&index=0!./src/components/Bbs/Campus_Menu.vue
var Campus_Menu = __webpack_require__("6KNY");

// CONCATENATED MODULE: ./node_modules/vue-loader/lib/template-compiler?{"id":"data-v-33c9202f","hasScoped":false,"transformToRequire":{"video":["src","poster"],"source":"src","img":"src","image":"xlink:href"},"buble":{"transforms":{}}}!./node_modules/vue-loader/lib/selector.js?type=template&index=0!./src/components/Bbs/Campus_Menu.vue
var render = function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',{staticClass:"menu_container"},[_c('div',{staticClass:"menu_nav"},[_c('ul',[_c('router-link',{attrs:{"to":"/campus/follow"}},[_c('li',{class:{actives:this.$route.name==='follow'}},[_vm._v("关注")])]),_vm._v(" "),_c('router-link',{attrs:{"to":"/campus/hotlist"}},[_c('li',{class:{actives:this.$route.name==='hotlist'}},[_vm._v("热榜")])]),_vm._v(" "),_c('router-link',{attrs:{"to":"/campus/square"}},[_c('li',{class:{actives:this.$route.name==='square'}},[_vm._v("广场")])]),_vm._v(" "),_c('router-link',{attrs:{"to":"/campus/blodlist"}},[_c('li',{class:{actives:this.$route.name==='blodlist'}},[_vm._v("博客园")])]),_vm._v(" "),_c('router-link',{attrs:{"to":"/campus/list"}},[_c('li',{class:{actives:this.$route.name==='blodli'}},[_vm._v("资料库")])])],1)]),_vm._v(" "),_c('keep-alive',[_c('router-view')],1)],1)}
var staticRenderFns = []
var esExports = { render: render, staticRenderFns: staticRenderFns }
/* harmony default export */ var Bbs_Campus_Menu = (esExports);
// CONCATENATED MODULE: ./src/components/Bbs/Campus_Menu.vue
function injectStyle (ssrContext) {
  __webpack_require__("BgNe")
}
var normalizeComponent = __webpack_require__("VU/8")
/* script */


/* template */

/* template functional */
var __vue_template_functional__ = false
/* styles */
var __vue_styles__ = injectStyle
/* scopeId */
var __vue_scopeId__ = null
/* moduleIdentifier (server only) */
var __vue_module_identifier__ = null
var Component = normalizeComponent(
  Campus_Menu["a" /* default */],
  Bbs_Campus_Menu,
  __vue_template_functional__,
  __vue_styles__,
  __vue_scopeId__,
  __vue_module_identifier__
)

/* harmony default export */ var components_Bbs_Campus_Menu = __webpack_exports__["default"] = (Component.exports);


/***/ })

});
//# sourceMappingURL=28.2cbb55bc2be95dcd4abe.js.map