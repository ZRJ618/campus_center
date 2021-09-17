webpackJsonp([22],{

/***/ "/cBF":
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ "Ek68":
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

/* harmony default export */ __webpack_exports__["a"] = ({
    data: function data() {
        return {
            header: 'NavHeader'
        };
    },

    methods: {},
    components: {
        NavHeader: function NavHeader() {
            return __webpack_require__.e/* import() */(52).then(__webpack_require__.bind(null, "EGO1"));
        },
        MyHeader: function MyHeader() {
            return __webpack_require__.e/* import() */(55).then(__webpack_require__.bind(null, "fRSs"));
        }

    },
    mounted: function mounted() {
        var _this = this;

        var start = 0;

        $(document).on("scroll", function () {
            //防抖
            var end = new Date().getTime();
            if (end - start >= 1000) {
                start = end;
                if ($(document).scrollTop() >= 200) {
                    _this.header = "MyHeader";
                } else {
                    _this.header = "NavHeader";
                }
            }
        });
    },
    created: function created() {}
});
/* WEBPACK VAR INJECTION */}.call(__webpack_exports__, __webpack_require__("7t+N")))

/***/ }),

/***/ "rHCo":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });

// EXTERNAL MODULE: ./node_modules/babel-loader/lib!./node_modules/vue-loader/lib/selector.js?type=script&index=0!./src/components/public/My.vue
var My = __webpack_require__("Ek68");

// CONCATENATED MODULE: ./node_modules/vue-loader/lib/template-compiler?{"id":"data-v-0b8424be","hasScoped":true,"transformToRequire":{"video":["src","poster"],"source":"src","img":"src","image":"xlink:href"},"buble":{"transforms":{}}}!./node_modules/vue-loader/lib/selector.js?type=template&index=0!./src/components/public/My.vue
var render = function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',{staticStyle:{}},[_c('header',[_c('transition',{attrs:{"enter-active-class":"animated fadeInDown","duration":{enter:1000,leadve:1000}}},[_c(_vm.header,{tag:"component"})],1)],1),_vm._v(" "),_c('main',[_c('router-view')],1)])}
var staticRenderFns = []
var esExports = { render: render, staticRenderFns: staticRenderFns }
/* harmony default export */ var public_My = (esExports);
// CONCATENATED MODULE: ./src/components/public/My.vue
function injectStyle (ssrContext) {
  __webpack_require__("/cBF")
}
var normalizeComponent = __webpack_require__("VU/8")
/* script */


/* template */

/* template functional */
var __vue_template_functional__ = false
/* styles */
var __vue_styles__ = injectStyle
/* scopeId */
var __vue_scopeId__ = "data-v-0b8424be"
/* moduleIdentifier (server only) */
var __vue_module_identifier__ = null
var Component = normalizeComponent(
  My["a" /* default */],
  public_My,
  __vue_template_functional__,
  __vue_styles__,
  __vue_scopeId__,
  __vue_module_identifier__
)

/* harmony default export */ var components_public_My = __webpack_exports__["default"] = (Component.exports);


/***/ })

});
//# sourceMappingURL=22.19634f7ca63f07fcf3bc.js.map