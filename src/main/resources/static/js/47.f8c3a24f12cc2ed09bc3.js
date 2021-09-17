webpackJsonp([47],{

/***/ "7Xp9":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });

// EXTERNAL MODULE: ./node_modules/babel-loader/lib!./node_modules/vue-loader/lib/selector.js?type=script&index=0!./src/components/public/Footer.vue
var Footer = __webpack_require__("gvn6");

// CONCATENATED MODULE: ./node_modules/vue-loader/lib/template-compiler?{"id":"data-v-474f0484","hasScoped":true,"transformToRequire":{"video":["src","poster"],"source":"src","img":"src","image":"xlink:href"},"buble":{"transforms":{}}}!./node_modules/vue-loader/lib/selector.js?type=template&index=0!./src/components/public/Footer.vue
var render = function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',{staticClass:"Footer_container",style:({background:_vm.Backcolor})},[_c('section',{staticClass:"about"},[_c('ul',[_c('li',[_vm._v("关于我们")]),_vm._v(" "),_c('li',[_vm._v("招贤纳士")]),_vm._v(" "),_c('li',[_vm._v("联系我们")]),_vm._v(" "),_c('li',[_c('span',{staticClass:"iconfont icon-icon-mail"}),_vm._v(" "),_c('a',{attrs:{"href":"mailto:2663118046@qq.com","target":"_blank"}},[_vm._v("\n                    "+_vm._s(_vm.email)+"\n                ")])]),_vm._v(" "),_vm._m(0),_vm._v(" "),_c('li')])]),_vm._v(" "),_vm._m(1)])}
var staticRenderFns = [function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('li',[_vm._v("友情链接:\n                "),_c('a',[_vm._v("jQuery")]),_vm._v(" "),_c('a',[_vm._v("Vue.js")]),_vm._v(" "),_c('a',[_vm._v("ElementUI")])])},function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('section',{staticClass:"copyright"},[_c('span',[_vm._v("权归所有:国之重才团队©")])])}]
var esExports = { render: render, staticRenderFns: staticRenderFns }
/* harmony default export */ var public_Footer = (esExports);
// CONCATENATED MODULE: ./src/components/public/Footer.vue
function injectStyle (ssrContext) {
  __webpack_require__("s8Ks")
}
var normalizeComponent = __webpack_require__("VU/8")
/* script */


/* template */

/* template functional */
var __vue_template_functional__ = false
/* styles */
var __vue_styles__ = injectStyle
/* scopeId */
var __vue_scopeId__ = "data-v-474f0484"
/* moduleIdentifier (server only) */
var __vue_module_identifier__ = null
var Component = normalizeComponent(
  Footer["a" /* default */],
  public_Footer,
  __vue_template_functional__,
  __vue_styles__,
  __vue_scopeId__,
  __vue_module_identifier__
)

/* harmony default export */ var components_public_Footer = __webpack_exports__["default"] = (Component.exports);


/***/ }),

/***/ "gvn6":
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
//
//
//
//
//
//

/* harmony default export */ __webpack_exports__["a"] = ({
    props: {
        email: {
            type: String,
            default: "222"
        },
        Backcolor: {
            type: String,
            default: 'white'
        },
        color: {
            type: String,
            default: '#606266'
        }
    },
    mounted: function mounted() {
        $(".about li,.about a,.about span").css("color", this.color);
    }
});
/* WEBPACK VAR INJECTION */}.call(__webpack_exports__, __webpack_require__("7t+N")))

/***/ }),

/***/ "s8Ks":
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ })

});
//# sourceMappingURL=47.f8c3a24f12cc2ed09bc3.js.map