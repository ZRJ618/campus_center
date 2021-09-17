webpackJsonp([20],{

/***/ "Fxan":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });

// EXTERNAL MODULE: ./node_modules/babel-runtime/helpers/asyncGenerator.js
var asyncGenerator = __webpack_require__("xGmp");
var asyncGenerator_default = /*#__PURE__*/__webpack_require__.n(asyncGenerator);

// EXTERNAL MODULE: ./node_modules/babel-runtime/regenerator/index.js
var regenerator = __webpack_require__("Xxa5");
var regenerator_default = /*#__PURE__*/__webpack_require__.n(regenerator);

// EXTERNAL MODULE: ./node_modules/babel-runtime/helpers/asyncToGenerator.js
var asyncToGenerator = __webpack_require__("exGp");
var asyncToGenerator_default = /*#__PURE__*/__webpack_require__.n(asyncToGenerator);

// CONCATENATED MODULE: ./src/router/addRouter.js
/* harmony default export */ var addRouter = ([{
    path: "/department/admin-department",
    name: "adminDeparteememnt",
    component: function component() {
        return __webpack_require__.e/* import() */(53).then(__webpack_require__.bind(null, "Aq4j"));
    }
}]);
// EXTERNAL MODULE: ./src/api/data.js + 1 modules
var api_data = __webpack_require__("Foau");

// CONCATENATED MODULE: ./node_modules/babel-loader/lib!./node_modules/vue-loader/lib/selector.js?type=script&index=0!./src/components/Department/MyDepartment.vue




//生成器
var GetDepartDetail = function () {
  var _ref2 = asyncGenerator_default.a.wrap( /*#__PURE__*/regenerator_default.a.mark(function _callee2(studentId, userId) {
    return regenerator_default.a.wrap(function _callee2$(_context2) {
      while (1) {
        switch (_context2.prev = _context2.next) {
          case 0:
            _context2.next = 2;
            return asyncGenerator_default.a.await(Object(api_data["A" /* GetDepCheckUserSelf */])(studentId));

          case 2:
            _context2.next = 4;
            return _context2.sent;

          case 4:
            _context2.next = 6;
            return asyncGenerator_default.a.await(Object(api_data["E" /* GetMyDep */])({ userId: userId }));

          case 6:
            _context2.next = 8;
            return _context2.sent;

          case 8:
          case "end":
            return _context2.stop();
        }
      }
    }, _callee2, this);
  }));

  return function GetDepartDetail(_x2, _x3) {
    return _ref2.apply(this, arguments);
  };
}();

//获取自己的认证状态


//获取部门信息
var GetMyDeps = function () {
  var _ref3 = asyncToGenerator_default()( /*#__PURE__*/regenerator_default.a.mark(function _callee3(userId) {
    var result;
    return regenerator_default.a.wrap(function _callee3$(_context3) {
      while (1) {
        switch (_context3.prev = _context3.next) {
          case 0:
            _context3.next = 2;
            return Object(api_data["E" /* GetMyDep */])({ userId: userId });

          case 2:
            result = _context3.sent;
            return _context3.abrupt("return", result);

          case 4:
          case "end":
            return _context3.stop();
        }
      }
    }, _callee3, this);
  }));

  return function GetMyDeps(_x4) {
    return _ref3.apply(this, arguments);
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
      //认证状态 0--已提交还未通过 1--通过 -1--未提交也未通过
      checkStatus: 0,
      //部门信息
      Department: {},
      //职位
      position: false
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

    if (!this.position) {
      console.log("1111");
      console.log(addRouter);
      this.$router.addRoutes(addRouter);
    }
    var studentId = this.$store.state.user.studentId;
    var itertor = GetDepartDetail(studentId, this.$GetUserId());
    var result = itertor.next();
    result.then(function () {
      var _ref = asyncToGenerator_default()( /*#__PURE__*/regenerator_default.a.mark(function _callee(res) {
        var data;
        return regenerator_default.a.wrap(function _callee$(_context) {
          while (1) {
            switch (_context.prev = _context.next) {
              case 0:
                if (!(res.value.data.msg == "未查询到数据")) {
                  _context.next = 20;
                  break;
                }

                _context.next = 3;
                return itertor.next();

              case 3:
                data = _context.sent;

                if (!data.value.data.result) {
                  _context.next = 17;
                  break;
                }

                _this.checkStatus = 1;
                _this.Department = data.value.data.result;
                _context.t0 = res["data"].result.position;
                _context.next = _context.t0 === "干事" ? 10 : _context.t0 === "管理员" ? 12 : 15;
                break;

              case 10:
                _this.position = false;return _context.abrupt("break", 15);

              case 12:
                _this.position = true;_this.$store.commit("handlePosition");return _context.abrupt("break", 15);

              case 15:
                _context.next = 18;
                break;

              case 17:
                _this.checkStatus = -1;

              case 18:
                _context.next = 21;
                break;

              case 20:

                _this.checkStatus = res.value.data.result.data.checkStatus;

              case 21:
              case "end":
                return _context.stop();
            }
          }
        }, _callee, _this);
      }));

      return function (_x) {
        return _ref.apply(this, arguments);
      };
    }());
  }
});function GetDepCheckUser(studentId) {
  var result = Object(api_data["A" /* GetDepCheckUserSelf */])(userId);
  return result;
}
// CONCATENATED MODULE: ./node_modules/vue-loader/lib/template-compiler?{"id":"data-v-2f3fe406","hasScoped":true,"transformToRequire":{"video":["src","poster"],"source":"src","img":"src","image":"xlink:href"},"buble":{"transforms":{}}}!./node_modules/vue-loader/lib/selector.js?type=template&index=0!./src/components/Department/MyDepartment.vue
var render = function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',[_vm._m(0),_vm._v(" "),(_vm.checkStatus==1)?_c('div',{staticClass:"Department_container"},[_c('div',{staticClass:"Department_img"},[_c('el-carousel',{attrs:{"interval":5000,"indicator-position":"outside","height":"450px"}},_vm._l((_vm.Department.depImageList),function(item){return _c('el-carousel-item',{key:item},[_c('img',{staticClass:"Department_img",attrs:{"src":__webpack_require__("HdUg")}})])}),1)],1),_vm._v(" "),_c('div',{staticClass:"Department_info"},[_vm._m(1),_vm._v(" "),_c('div',{staticClass:"Department_data"},[_c('span',[_vm._v(_vm._s(_vm.Department.departmentName))]),_vm._v(" "),_c('span',[_vm._v(_vm._s(_vm.Department.peopleNum))]),_vm._v(" "),_c('span',[_vm._v("52")]),_vm._v(" "),_c('span',[_vm._v(_vm._s(_vm.Department.position))]),_vm._v(" "),_c('span',[_vm._v(_vm._s(_vm.Department.parentName))]),_vm._v(" "),_c('span',{staticClass:"Department_introduction"},[_vm._v(_vm._s(_vm.Department.briefIntroduce))]),_vm._v(" "),_c('div',{staticClass:"Department_operation"},[_c('el-button',[_vm._v("点我")]),_vm._v(" "),_c('el-button',{attrs:{"type":"primary"}},[_vm._v("查看近期活动 ")]),_vm._v(" "),(_vm.position)?_c('el-button',{attrs:{"type":"primary"},on:{"click":_vm.handleClick}},[_vm._v("管理部门")]):_vm._e()],1)])])]):(_vm.checkStatus==0)?_c('div',{staticClass:"verify"},[_vm._v("\r\n       认证还在审核中哦\r\n     ")]):_c('div',{staticClass:"identification"},[_c('span',[_vm._v("\r\n          还未认证部门信息,你可以"),_c('router-link',{attrs:{"to":"/department/identification"}},[_vm._v("去认证")])],1)]),_vm._v(" "),(!_vm.position)?_c('el-button',{attrs:{"type":"primary"},on:{"click":_vm.handleClick}},[_vm._v("管理部门")]):_vm._e()],1)}
var staticRenderFns = [function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',{staticClass:"Departemnt_header"},[_c('span',[_vm._v("我的部门")])])},function () {var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;return _c('div',{staticClass:"Dapartment_tis"},[_c('span',[_vm._v("部门名称:")]),_vm._v(" "),_c('span',[_vm._v("部门人数:")]),_vm._v(" "),_c('span',[_vm._v("活跃程度:")]),_vm._v(" "),_c('span',[_vm._v("我的职位:")]),_vm._v(" "),_c('span',[_vm._v("部门所属")]),_vm._v(" "),_c('span',{staticClass:"Department_introduction"},[_vm._v("部门简介:")])])}]
var esExports = { render: render, staticRenderFns: staticRenderFns }
/* harmony default export */ var Department_MyDepartment = (esExports);
// CONCATENATED MODULE: ./src/components/Department/MyDepartment.vue
function injectStyle (ssrContext) {
  __webpack_require__("HG11")
}
var normalizeComponent = __webpack_require__("VU/8")
/* script */


/* template */

/* template functional */
var __vue_template_functional__ = false
/* styles */
var __vue_styles__ = injectStyle
/* scopeId */
var __vue_scopeId__ = "data-v-2f3fe406"
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


/***/ }),

/***/ "HG11":
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ "xGmp":
/***/ (function(module, exports, __webpack_require__) {

"use strict";


exports.__esModule = true;

var _symbol = __webpack_require__("5QVw");

var _symbol2 = _interopRequireDefault(_symbol);

var _promise = __webpack_require__("//Fk");

var _promise2 = _interopRequireDefault(_promise);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

exports.default = function () {
  function AwaitValue(value) {
    this.value = value;
  }

  function AsyncGenerator(gen) {
    var front, back;

    function send(key, arg) {
      return new _promise2.default(function (resolve, reject) {
        var request = {
          key: key,
          arg: arg,
          resolve: resolve,
          reject: reject,
          next: null
        };

        if (back) {
          back = back.next = request;
        } else {
          front = back = request;
          resume(key, arg);
        }
      });
    }

    function resume(key, arg) {
      try {
        var result = gen[key](arg);
        var value = result.value;

        if (value instanceof AwaitValue) {
          _promise2.default.resolve(value.value).then(function (arg) {
            resume("next", arg);
          }, function (arg) {
            resume("throw", arg);
          });
        } else {
          settle(result.done ? "return" : "normal", result.value);
        }
      } catch (err) {
        settle("throw", err);
      }
    }

    function settle(type, value) {
      switch (type) {
        case "return":
          front.resolve({
            value: value,
            done: true
          });
          break;

        case "throw":
          front.reject(value);
          break;

        default:
          front.resolve({
            value: value,
            done: false
          });
          break;
      }

      front = front.next;

      if (front) {
        resume(front.key, front.arg);
      } else {
        back = null;
      }
    }

    this._invoke = send;

    if (typeof gen.return !== "function") {
      this.return = undefined;
    }
  }

  if (typeof _symbol2.default === "function" && _symbol2.default.asyncIterator) {
    AsyncGenerator.prototype[_symbol2.default.asyncIterator] = function () {
      return this;
    };
  }

  AsyncGenerator.prototype.next = function (arg) {
    return this._invoke("next", arg);
  };

  AsyncGenerator.prototype.throw = function (arg) {
    return this._invoke("throw", arg);
  };

  AsyncGenerator.prototype.return = function (arg) {
    return this._invoke("return", arg);
  };

  return {
    wrap: function wrap(fn) {
      return function () {
        return new AsyncGenerator(fn.apply(this, arguments));
      };
    },
    await: function _await(value) {
      return new AwaitValue(value);
    }
  };
}();

/***/ })

});
//# sourceMappingURL=20.a16d1c44de29bac3fc19.js.map