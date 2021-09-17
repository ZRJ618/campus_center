webpackJsonp([37],{

/***/ "E9DQ":
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ "NADT":
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

// EXTERNAL MODULE: ./src/components/public/TitleHeader.vue + 2 modules
var TitleHeader = __webpack_require__("IrT/");

// CONCATENATED MODULE: ./node_modules/babel-loader/lib!./node_modules/vue-loader/lib/selector.js?type=script&index=0!./src/components/public/MyFans.vue





/* harmony default export */ var MyFans = ({
  data: function data() {
    return {
      //记录数据
      list: [],
      //条数
      total: 0
    };
  },

  components: {
    TitleHeader: TitleHeader["default"]
  },
  render: function render(createElement) {
    var _this = this;

    var h = arguments[0];

    return (
      //用v-show代替v-if
      //用map代替v-for
      //事件:用原生事件绑定on(事件类型) ()=>--传递参数

      h(
        "section",
        { "class": "core_contianer" },
        [h("header", [h(TitleHeader["default"], {
          attrs: { title: "\u6211\u7684\u7C89\u4E1D" }
        })]), h("main", [h(
          "section",
          {
            directives: [{
              name: "show",
              value: this.total != 0
            }]
          },
          [this.list.map(function (item, index) {
            return h(
              "section",
              { "class": "core_mainer" },
              [h(
                "section",
                { "class": "core_data" },
                [h(
                  "img",
                  {
                    attrs: { src: item.selfImage }
                  },
                  [" "]
                ), h("span", [item.userName])]
              ), h(
                "section",
                { "class": "core_btn" },
                [h(
                  "el-button",
                  {
                    attrs: {
                      icon: "el-icon-position",
                      size: "mini"
                    },
                    on: {
                      "click": function click() {
                        return _this.handleSearch(item.userId, index);
                      }
                    }
                  },
                  ["\u8BBF\u95EE"]
                ), h(
                  "el-button",
                  {
                    attrs: {
                      type: "primary",
                      icon: "el-icon-star-on",
                      size: "mini"
                    },
                    on: {
                      "click": function click() {
                        return _this.handleFollow(item, index);
                      }
                    }
                  },
                  ["\u5173\u6CE8ta"]
                )]
              )]
            );
          }), h(
            "section",
            { "class": "page_container" },
            [h(
              "section",
              { "class": "page_mainer" },
              [h("el-pagination", {
                attrs: {
                  background: true,

                  layout: "prev, pager, next",
                  total: this.total
                },
                on: {
                  "current-change": this.handleCurrentChange
                }
              })]
            )]
          )]
        ), h(
          "section",
          { "class": "core_null", directives: [{
              name: "show",
              value: this.total == 0
            }]
          },
          [h("span", ["\u6682\u65F6\u8FD8\u6CA1\u6709\u7C89\u4E1D"])]
        )])]
      )
    );
  },

  methods: {
    //查看详情
    handleSearch: function handleSearch(val) {
      if (val == this.$GetUserId()) {
        this.$router.push({
          name: "my"
        });
      } else {
        localStorage.setItem("userId", val);
        this.$router.push({
          name: "peopleInfo",
          params: {
            userId: val
          }
        });
      }
    },

    //关注某人
    handleFollow: function handleFollow(val, index) {
      var _this2 = this;

      return asyncToGenerator_default()( /*#__PURE__*/regenerator_default.a.mark(function _callee() {
        var result;
        return regenerator_default.a.wrap(function _callee$(_context) {
          while (1) {
            switch (_context.prev = _context.next) {
              case 0:
                _context.next = 2;
                return Object(data["y" /* FocusOther */])({
                  userId: val.userId
                });

              case 2:
                result = _context.sent;

                if (result["data"].code == "200") {
                  _this2.message("success", "关注成功");
                } else if (result["data"].code == "500") {
                  _this2.message("warning", "不能重复关注");
                }

              case 4:
              case "end":
                return _context.stop();
            }
          }
        }, _callee, _this2);
      }))();
    },

    //分页
    handleCurrentChange: function handleCurrentChange(val) {
      var _this3 = this;

      return asyncToGenerator_default()( /*#__PURE__*/regenerator_default.a.mark(function _callee2() {
        var result;
        return regenerator_default.a.wrap(function _callee2$(_context2) {
          while (1) {
            switch (_context2.prev = _context2.next) {
              case 0:
                _context2.next = 2;
                return Object(data["Q" /* ShowFansByPage */])("/" + val + "/10");

              case 2:
                result = _context2.sent;

                _this3.list = result["data"].result.data;

              case 4:
              case "end":
                return _context2.stop();
            }
          }
        }, _callee2, _this3);
      }))();
    }
  },
  created: function created() {
    var _this4 = this;

    return asyncToGenerator_default()( /*#__PURE__*/regenerator_default.a.mark(function _callee3() {
      var result;
      return regenerator_default.a.wrap(function _callee3$(_context3) {
        while (1) {
          switch (_context3.prev = _context3.next) {
            case 0:
              _context3.next = 2;
              return Object(data["Q" /* ShowFansByPage */])("/1/10");

            case 2:
              result = _context3.sent;

              _this4.list = result["data"].result.data;
              _this4.total = result["data"].result.allDataNum;

            case 5:
            case "end":
              return _context3.stop();
          }
        }
      }, _callee3, _this4);
    }))();
  }
});
// CONCATENATED MODULE: ./src/components/public/MyFans.vue
function injectStyle (ssrContext) {
  __webpack_require__("E9DQ")
}
var normalizeComponent = __webpack_require__("VU/8")
/* script */


/* template */
var __vue_template__ = null
/* template functional */
var __vue_template_functional__ = false
/* styles */
var __vue_styles__ = injectStyle
/* scopeId */
var __vue_scopeId__ = "data-v-55185109"
/* moduleIdentifier (server only) */
var __vue_module_identifier__ = null
var Component = normalizeComponent(
  MyFans,
  __vue_template__,
  __vue_template_functional__,
  __vue_styles__,
  __vue_scopeId__,
  __vue_module_identifier__
)

/* harmony default export */ var public_MyFans = __webpack_exports__["default"] = (Component.exports);


/***/ })

});
//# sourceMappingURL=37.7411a1b00f0c0fe52fb0.js.map