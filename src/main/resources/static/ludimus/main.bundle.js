webpackJsonp([0],{

/***/ "../../../../../src async recursive":
/***/ (function(module, exports) {

function webpackEmptyContext(req) {
	throw new Error("Cannot find module '" + req + "'.");
}
webpackEmptyContext.keys = function() { return []; };
webpackEmptyContext.resolve = webpackEmptyContext;
module.exports = webpackEmptyContext;
webpackEmptyContext.id = "../../../../../src async recursive";

/***/ }),

/***/ "../../../../../src/app/app-routing.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__ludimus_tax_home_home_component__ = __webpack_require__("../../../../../src/app/ludimus-tax/home/home.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__auth_login_login_form_component__ = __webpack_require__("../../../../../src/app/auth/login/login-form.component.ts");
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppRoutingModule; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var appRoutes = [
    { path: '', redirectTo: 'home', pathMatch: 'full' },
    { path: 'home', component: __WEBPACK_IMPORTED_MODULE_2__ludimus_tax_home_home_component__["a" /* HomeComponent */] },
    { path: 'login', component: __WEBPACK_IMPORTED_MODULE_3__auth_login_login_form_component__["a" /* LoginFormComponent */] }
];
var AppRoutingModule = (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
            imports: [
                __WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* RouterModule */].forRoot(appRoutes)
            ],
            exports: [
                __WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* RouterModule */]
            ]
        }), 
        __metadata('design:paramtypes', [])
    ], AppRoutingModule);
    return AppRoutingModule;
}());
//# sourceMappingURL=/Volumes/java/ludimus-gui/src/app-routing.module.js.map

/***/ }),

/***/ "../../../../../src/app/app.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".ng-valid[required], .ng-valid.required  {\n    border-left: 5px solid #42A948; /* green */\n}\n\n.ng-invalid:not(form)  {\n    border-left: 5px solid #a94442; /* red */\n}", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "<app-notification></app-notification>\n<h3>\n    Ludimus.\n</h3>\n<nav class=\"navbar navbar-default\">\n    <div class=\"container-fluid\">\n        <!-- Collect the nav links, forms, and other content for toggling -->\n        <!--<div class=\"collapse navbar-collapse\">-->\n            <ul class=\"nav navbar-nav\">\n                <li><a class=\"glyphicon glyphicon-home\" [routerLink]=\"['home']\"></a></li>\n                <li class=\"dropdown\">\n                    <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Modulen <span class=\"caret\"></span></a>\n                    <ul class=\"dropdown-menu\">\n                        <li><a [routerLink]=\"['tax']\">Belasting</a></li>\n                    </ul>\n                </li>\n            </ul>\n        <!--</div>&lt;!&ndash; /.navbar-collapse &ndash;&gt;-->\n    </div><!-- /.container-fluid -->\n</nav>\n<router-outlet></router-outlet>\n"

/***/ }),

/***/ "../../../../../src/app/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/index.js");
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var AppComponent = (function () {
    function AppComponent() {
    }
    AppComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-root',
            template: __webpack_require__("../../../../../src/app/app.component.html"),
            styles: [__webpack_require__("../../../../../src/app/app.component.css")]
        }), 
        __metadata('design:paramtypes', [])
    ], AppComponent);
    return AppComponent;
}());
//# sourceMappingURL=/Volumes/java/ludimus-gui/src/app.component.js.map

/***/ }),

/***/ "../../../../../src/app/app.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser__ = __webpack_require__("../../../platform-browser/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_component__ = __webpack_require__("../../../../../src/app/app.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_forms__ = __webpack_require__("../../../forms/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_http__ = __webpack_require__("../../../http/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__ludimus_tax_tax_routing_module__ = __webpack_require__("../../../../../src/app/ludimus-tax/tax-routing.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__app_routing_module__ = __webpack_require__("../../../../../src/app/app-routing.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__angular_common__ = __webpack_require__("../../../common/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__ludimus_tax_home_home_component__ = __webpack_require__("../../../../../src/app/ludimus-tax/home/home.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__auth_auth_guard_service__ = __webpack_require__("../../../../../src/app/auth/auth-guard.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__auth_login_login_form_component__ = __webpack_require__("../../../../../src/app/auth/login/login-form.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__notification_notification_component__ = __webpack_require__("../../../../../src/app/notification/notification.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__notification_notification_service__ = __webpack_require__("../../../../../src/app/notification/notification.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13_angular2_jwt__ = __webpack_require__("../../../../angular2-jwt/angular2-jwt.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13_angular2_jwt___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_13_angular2_jwt__);
/* unused harmony export authHttpServiceFactory */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};














function authHttpServiceFactory(http, options) {
    return new __WEBPACK_IMPORTED_MODULE_13_angular2_jwt__["AuthHttp"](new __WEBPACK_IMPORTED_MODULE_13_angular2_jwt__["AuthConfig"]({
        headerName: 'Authorization',
        headerPrefix: 'Bearer',
        tokenName: 'id_token',
        tokenGetter: (function () { return localStorage.getItem('id_token'); }),
        noJwtError: true
    }), http, options);
}
var AppModule = (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
            imports: [
                __WEBPACK_IMPORTED_MODULE_3__angular_forms__["a" /* FormsModule */],
                __WEBPACK_IMPORTED_MODULE_7__angular_common__["a" /* CommonModule */],
                __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser__["a" /* BrowserModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_http__["HttpModule"],
                __WEBPACK_IMPORTED_MODULE_5__ludimus_tax_tax_routing_module__["a" /* TaxRoutingModule */],
                __WEBPACK_IMPORTED_MODULE_6__app_routing_module__["a" /* AppRoutingModule */]
            ],
            declarations: [__WEBPACK_IMPORTED_MODULE_2__app_component__["a" /* AppComponent */], __WEBPACK_IMPORTED_MODULE_10__auth_login_login_form_component__["a" /* LoginFormComponent */], __WEBPACK_IMPORTED_MODULE_8__ludimus_tax_home_home_component__["a" /* HomeComponent */], __WEBPACK_IMPORTED_MODULE_11__notification_notification_component__["a" /* NotificationComponent */]],
            providers: [__WEBPACK_IMPORTED_MODULE_9__auth_auth_guard_service__["a" /* AuthGuard */],
                __WEBPACK_IMPORTED_MODULE_12__notification_notification_service__["a" /* NotificationService */],
                {
                    provide: __WEBPACK_IMPORTED_MODULE_13_angular2_jwt__["AuthHttp"],
                    useFactory: authHttpServiceFactory,
                    deps: [__WEBPACK_IMPORTED_MODULE_4__angular_http__["Http"], __WEBPACK_IMPORTED_MODULE_4__angular_http__["RequestOptions"]]
                }
            ],
            bootstrap: [__WEBPACK_IMPORTED_MODULE_2__app_component__["a" /* AppComponent */]]
        }), 
        __metadata('design:paramtypes', [])
    ], AppModule);
    return AppModule;
}());
//# sourceMappingURL=/Volumes/java/ludimus-gui/src/app.module.js.map

/***/ }),

/***/ "../../../../../src/app/auth/auth-guard.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_add_observable_throw__ = __webpack_require__("../../../../rxjs/add/observable/throw.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_add_observable_throw___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_rxjs_add_observable_throw__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map__ = __webpack_require__("../../../../rxjs/add/operator/map.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_rxjs_add_operator_catch__ = __webpack_require__("../../../../rxjs/add/operator/catch.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_rxjs_add_operator_catch___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_4_rxjs_add_operator_catch__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_angular2_jwt__ = __webpack_require__("../../../../angular2-jwt/angular2-jwt.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_angular2_jwt___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_5_angular2_jwt__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__environments_environment__ = __webpack_require__("../../../../../src/environments/environment.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__angular_http__ = __webpack_require__("../../../http/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__notification_notification_service__ = __webpack_require__("../../../../../src/app/notification/notification.service.ts");
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AuthGuard; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};









var AuthGuard = (function () {
    function AuthGuard(http, router, notificationService) {
        this.http = http;
        this.router = router;
        this.notificationService = notificationService;
        this.url = __WEBPACK_IMPORTED_MODULE_6__environments_environment__["a" /* environment */].baseUrl + 'ludimus/'; // URL to web API
    }
    AuthGuard.prototype.canActivate = function (route, state) {
        var url = state.url;
        return this.checkLogin(url);
    };
    AuthGuard.prototype.canActivateChild = function (childRoute, state) {
        return this.canActivate(childRoute, state);
    };
    AuthGuard.prototype.resolve = function (res) {
        return res.json() || {};
    };
    AuthGuard.prototype.reject = function (error) {
        return error.json() || {};
    };
    AuthGuard.prototype.login = function (login) {
        var headers = new __WEBPACK_IMPORTED_MODULE_7__angular_http__["Headers"]({ 'Content-Type': 'application/json' });
        var options = new __WEBPACK_IMPORTED_MODULE_7__angular_http__["RequestOptions"]({ headers: headers });
        return this.http.post(this.url + 'login', login, options)
            .map(this.resolve)
            .catch(this.reject);
    };
    AuthGuard.prototype.logout = function () {
        localStorage.removeItem('id_token');
    };
    ;
    AuthGuard.prototype.isLoggedIn = function () {
        var notExpired = __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_5_angular2_jwt__["tokenNotExpired"])();
        if (notExpired) {
            return true;
        }
        this.notificationService.info('Your login period has been expired, you have to login!');
        this.logout();
    };
    AuthGuard.prototype.redirect = function () {
        this.router.navigate([this.redirectUrl]);
    };
    AuthGuard.prototype.checkLogin = function (url) {
        if (this.isLoggedIn()) {
            return true;
        }
        // Store the attempted URL for redirecting
        this.redirectUrl = url;
        // Navigate to the login page with extras
        this.router.navigate(['login']);
        return false;
    };
    AuthGuard = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_7__angular_http__["Http"] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_7__angular_http__["Http"]) === 'function' && _a) || Object, (typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_1__angular_router__["a" /* Router */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__angular_router__["a" /* Router */]) === 'function' && _b) || Object, (typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_8__notification_notification_service__["a" /* NotificationService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_8__notification_notification_service__["a" /* NotificationService */]) === 'function' && _c) || Object])
    ], AuthGuard);
    return AuthGuard;
    var _a, _b, _c;
}());
//# sourceMappingURL=/Volumes/java/ludimus-gui/src/auth-guard.service.js.map

/***/ }),

/***/ "../../../../../src/app/auth/login/login-form.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n    <h3>\n        Please login first\n    </h3>\n    <form (ngSubmit)=\"onSubmit($event)\">\n        <div class=\"form-group row\">\n            <label for=\"name\" class=\"col-xs-3 col-form-label\">name</label>\n            <div class=\"col-xs-9\">\n                <input class=\"form-control\" [(ngModel)]=\"model.name\" name=\"name\"  id=\"name\" required>\n            </div>\n        </div>\n        <div class=\"form-group row\">\n            <label for=\"password\" class=\"col-xs-3 col-form-label\">password</label>\n            <div class=\"col-xs-9\">\n                <input class=\"form-control\" [(ngModel)]=\"model.password\" type=\"password\" name=\"password\"  id=\"password\" required>\n            </div>\n        </div>\n        <button type=\"submit\" class=\"btn btn-default\">Ok</button>\n    </form>\n</div>"

/***/ }),

/***/ "../../../../../src/app/auth/login/login-form.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__login_component__ = __webpack_require__("../../../../../src/app/auth/login/login.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__auth_guard_service__ = __webpack_require__("../../../../../src/app/auth/auth-guard.service.ts");
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return LoginFormComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var LoginFormComponent = (function () {
    function LoginFormComponent(auth) {
        this.auth = auth;
        this.model = new __WEBPACK_IMPORTED_MODULE_1__login_component__["a" /* Login */]();
    }
    LoginFormComponent.prototype.onSubmit = function (event) {
        var _this = this;
        event.preventDefault();
        this.auth.login(this.model).
            subscribe(function (object) {
            localStorage.setItem('id_token', object['token']);
            _this.auth.redirect();
        }, function (error) { console.log(error); });
        return true;
    };
    LoginFormComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'login-form',
            template: __webpack_require__("../../../../../src/app/auth/login/login-form.component.html")
        }), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_2__auth_guard_service__["a" /* AuthGuard */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_2__auth_guard_service__["a" /* AuthGuard */]) === 'function' && _a) || Object])
    ], LoginFormComponent);
    return LoginFormComponent;
    var _a;
}());
//# sourceMappingURL=/Volumes/java/ludimus-gui/src/login-form.component.js.map

/***/ }),

/***/ "../../../../../src/app/auth/login/login.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Login; });
var Login = (function () {
    function Login() {
    }
    return Login;
}());
//# sourceMappingURL=/Volumes/java/ludimus-gui/src/login.component.js.map

/***/ }),

/***/ "../../../../../src/app/ludimus-tax/home/home.component.html":
/***/ (function(module, exports) {

module.exports = "<p>\n  Welcome to ludimus\n</p>\n"

/***/ }),

/***/ "../../../../../src/app/ludimus-tax/home/home.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__auth_auth_guard_service__ = __webpack_require__("../../../../../src/app/auth/auth-guard.service.ts");
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return HomeComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var HomeComponent = (function () {
    function HomeComponent(auth) {
        this.auth = auth;
    }
    HomeComponent.prototype.ngOnInit = function () {
        this.auth.logout();
    };
    HomeComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            template: __webpack_require__("../../../../../src/app/ludimus-tax/home/home.component.html")
        }), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__auth_auth_guard_service__["a" /* AuthGuard */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__auth_auth_guard_service__["a" /* AuthGuard */]) === 'function' && _a) || Object])
    ], HomeComponent);
    return HomeComponent;
    var _a;
}());
//# sourceMappingURL=/Volumes/java/ludimus-gui/src/home.component.js.map

/***/ }),

/***/ "../../../../../src/app/ludimus-tax/tax-routing.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__ticket_overview_ticket_overview_component__ = __webpack_require__("../../../../../src/app/ludimus-tax/ticket/overview/ticket-overview.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__ticket_form_ticket_form_component__ = __webpack_require__("../../../../../src/app/ludimus-tax/ticket/form/ticket-form.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__tax_component__ = __webpack_require__("../../../../../src/app/ludimus-tax/tax.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_forms__ = __webpack_require__("../../../forms/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_platform_browser__ = __webpack_require__("../../../platform-browser/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__auth_auth_guard_service__ = __webpack_require__("../../../../../src/app/auth/auth-guard.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__ticket_overview_default_default_overview_component__ = __webpack_require__("../../../../../src/app/ludimus-tax/ticket/overview/default/default-overview.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__ticket_overview_tax_tax_overview_component__ = __webpack_require__("../../../../../src/app/ludimus-tax/ticket/overview/tax/tax-overview.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__ticket_overview_income_tax_income_tax_overview_component__ = __webpack_require__("../../../../../src/app/ludimus-tax/ticket/overview/income-tax/income-tax-overview.component.ts");
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TaxRoutingModule; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};











var taxRoutes = [
    {
        path: 'tax',
        component: __WEBPACK_IMPORTED_MODULE_4__tax_component__["a" /* TaxComponent */],
        canActivate: [__WEBPACK_IMPORTED_MODULE_7__auth_auth_guard_service__["a" /* AuthGuard */]],
        children: [
            {
                path: 'overview',
                component: __WEBPACK_IMPORTED_MODULE_2__ticket_overview_ticket_overview_component__["a" /* TicketOverviewComponent */],
                canActivate: [__WEBPACK_IMPORTED_MODULE_7__auth_auth_guard_service__["a" /* AuthGuard */]]
            },
            {
                path: 'addTicket',
                component: __WEBPACK_IMPORTED_MODULE_3__ticket_form_ticket_form_component__["a" /* TicketFormComponent */],
                canActivate: [__WEBPACK_IMPORTED_MODULE_7__auth_auth_guard_service__["a" /* AuthGuard */]]
            }
        ]
    }
];
var TaxRoutingModule = (function () {
    function TaxRoutingModule() {
    }
    TaxRoutingModule = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
            imports: [
                __WEBPACK_IMPORTED_MODULE_5__angular_forms__["a" /* FormsModule */],
                __WEBPACK_IMPORTED_MODULE_6__angular_platform_browser__["a" /* BrowserModule */],
                __WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* RouterModule */].forChild(taxRoutes)
            ],
            declarations: [__WEBPACK_IMPORTED_MODULE_4__tax_component__["a" /* TaxComponent */], __WEBPACK_IMPORTED_MODULE_2__ticket_overview_ticket_overview_component__["a" /* TicketOverviewComponent */], __WEBPACK_IMPORTED_MODULE_3__ticket_form_ticket_form_component__["a" /* TicketFormComponent */], __WEBPACK_IMPORTED_MODULE_8__ticket_overview_default_default_overview_component__["a" /* DefaultOverviewComponent */], __WEBPACK_IMPORTED_MODULE_9__ticket_overview_tax_tax_overview_component__["a" /* TaxOverviewComponent */], __WEBPACK_IMPORTED_MODULE_10__ticket_overview_income_tax_income_tax_overview_component__["a" /* IncomeTaxOverviewComponent */]],
            exports: [
                __WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* RouterModule */]
            ]
        }), 
        __metadata('design:paramtypes', [])
    ], TaxRoutingModule);
    return TaxRoutingModule;
}());
//# sourceMappingURL=/Volumes/java/ludimus-gui/src/tax-routing.module.js.map

/***/ }),

/***/ "../../../../../src/app/ludimus-tax/tax.component.html":
/***/ (function(module, exports) {

module.exports = "<nav class=\"navbar navbar-default\">\n    <div class=\"container-fluid\">\n        <!-- Collect the nav links, forms, and other content for toggling -->\n        <!--<div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">-->\n            <ul class=\"nav navbar-nav\">\n                <li class=\"dropdown\">\n                    <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Factuur <span class=\"caret\"></span></a>\n                    <ul class=\"dropdown-menu\">\n                        <li><a [routerLink]=\"['addTicket']\">Opvoeren factuur</a></li>\n                    </ul>\n                </li>\n                <li><a [routerLink]=\"['overview']\">Toon overzicht</a></li>\n            </ul>\n        <!--</div>&lt;!&ndash; /.navbar-collapse &ndash;&gt;-->\n    </div><!-- /.container-fluid -->\n</nav>\n<router-outlet></router-outlet>\n"

/***/ }),

/***/ "../../../../../src/app/ludimus-tax/tax.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/index.js");
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TaxComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var TaxComponent = (function () {
    function TaxComponent() {
    }
    TaxComponent.prototype.ngOnInit = function () {
    };
    TaxComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            //no selector needed because this is loaded via routing
            template: __webpack_require__("../../../../../src/app/ludimus-tax/tax.component.html")
        }), 
        __metadata('design:paramtypes', [])
    ], TaxComponent);
    return TaxComponent;
}());
//# sourceMappingURL=/Volumes/java/ludimus-gui/src/tax.component.js.map

/***/ }),

/***/ "../../../../../src/app/ludimus-tax/ticket/form/ticket-form.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".ng-valid[required], .ng-valid.required  {\n    border-left: 5px solid #42A948; /* green */\n}\n\n.ng-invalid:not(form)  {\n    border-left: 5px solid #a94442; /* red */\n}", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/ludimus-tax/ticket/form/ticket-form.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n    <form (ngSubmit)=\"onSubmit($event)\">\n        <div class=\"form-group row\">\n            <label for=\"ticketDate\" class=\"col-xs-3 col-form-label\">Factuurdatum</label>\n            <div class=\"col-xs-9\">\n                <input class=\"form-control\" [(ngModel)]=\"ticketDate\" name=\"ticketDate\" type=\"date\" id=\"ticketDate\" required>\n            </div>\n        </div>\n        <div class=\"form-group row\">\n            <label for=\"incomeType\" class=\"col-xs-3 col-form-label\">Inkomen type</label>\n            <div class=\"col-xs-9\">\n                <div class=\"custom-radio\" id=\"incomeType\">\n                    <label><input type=\"radio\" [(ngModel)]=\"model.income\" name=\"incomeType\" [value]=\"true\"> Inkomen</label>\n                    <label><input type=\"radio\" [(ngModel)]=\"model.income\" name=\"incomeType\" [value]=\"false\"> Uitgaven</label>\n                </div>\n            </div>\n        </div>\n        <div class=\"form-group row\" *ngIf=\"model.income\">\n            <label for=\"forMonth\" class=\"col-xs-3 col-form-label\">Inkomen voor welke maand</label>\n            <div class=\"col-xs-9\">\n                <select id=\"forMonth\" name=\"forMonth\" [(ngModel)]=\"model.forMonth\" class=\"form-control\">\n                    <option *ngFor=\"let month of '0,1,2,3,4,5,6,7,8,9,10,11'.split(',')\" [value]=\"month\" (ngModelChange)=\"forMonthChanged()\">{{monthLabel(month)}}</option>\n                </select>\n            </div>\n        </div>\n        <div class=\"form-group row\">\n            <label for=\"invoiceNumber\" class=\"col-xs-3 col-form-label\">Factuurnummer</label>\n            <div class=\"col-xs-9\">\n                <input class=\"form-control\" type=\"text\" name=\"invoiceNumber\" id=\"invoiceNumber\" [(ngModel)]=\"model.invoiceNumber\" required>\n            </div>\n        </div>\n        <div class=\"form-group row\">\n            <label for=\"description\" class=\"col-xs-3 col-form-label\">Omschrijving</label>\n            <div class=\"col-xs-9\">\n                <textarea class=\"form-control\" rows=\"3\" name=\"description\" id=\"description\" [(ngModel)]=\"model.description\" required></textarea>\n            </div>\n        </div>\n        <div class=\"form-group row\">\n            <label for=\"price\" class=\"col-xs-3 col-form-label\">Bedrag Ex. BTW</label>\n            <div class=\"col-xs-9\">\n                <input class=\"form-control\" type=\"number\" step=\".01\" [(ngModel)]=\"model.price\" name=\"price\" id=\"price\" required>\n            </div>\n        </div>\n        <div class=\"form-group row\">\n            <label for=\"vat\" class=\"col-xs-3 col-form-label\">Inkomen type</label>\n            <div class=\"col-xs-6\">\n                <div class=\"custom-radio\" id=\"vat\">\n                    <label><input type=\"radio\" [(ngModel)]=\"model.vatRate\" name=\"vatRate\" [value]=\"21\"> 21 %</label>\n                    <label><input type=\"radio\" [(ngModel)]=\"model.vatRate\" name=\"vatRate\" [value]=\"6\"> 6 %</label>\n                    <label><input type=\"radio\" [(ngModel)]=\"model.vatRate\" name=\"vatRate\" [value]=\"0\"> 0 %</label>\n                </div>\n            </div>\n            <div class=\"col-xs-3\" *ngIf=\"model.price\">\n                BTW {{model.price * model.vatRate/100}}\n            </div>\n        </div>\n        <div class=\"form-group row\">\n            <label class=\"col-xs-offset-3 btn btn-link\" for=\"my-file-selector\">\n                <input id=\"my-file-selector\" type=\"file\" name=\"ticketImage\" (change)=\"onFileChange($event)\" style=\"display:block;\" required>\n            </label>\n        </div>\n        <button type=\"submit\" class=\"btn btn-default\">Ok</button>\n    </form>\n</div>"

/***/ }),

/***/ "../../../../../src/app/ludimus-tax/ticket/form/ticket-form.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__service_ticket_service__ = __webpack_require__("../../../../../src/app/ludimus-tax/ticket/service/ticket.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__ticket_component__ = __webpack_require__("../../../../../src/app/ludimus-tax/ticket/ticket.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__notification_notification_service__ = __webpack_require__("../../../../../src/app/notification/notification.service.ts");
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TicketFormComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var TicketFormComponent = (function () {
    function TicketFormComponent(ticketService, notificationService) {
        this.ticketService = ticketService;
        this.notificationService = notificationService;
        this.model = new __WEBPACK_IMPORTED_MODULE_2__ticket_component__["a" /* Ticket */]();
    }
    Object.defineProperty(TicketFormComponent.prototype, "ticketDate", {
        get: function () {
            return this.model.ticketDate.toISOString().substring(0, 10);
        },
        set: function (e) {
            var splitted = e.split('-');
            this.model.ticketDate = new Date(Date.UTC(Number(splitted[0]), Number(splitted[1]) - 1, Number(splitted[2])));
        },
        enumerable: true,
        configurable: true
    });
    TicketFormComponent.prototype.forMonthChanged = function () {
        this.model.forMonth = Number(this.model.forMonth);
    };
    TicketFormComponent.prototype.monthLabel = function (month) {
        switch (month) {
            case '0': return 'Januari';
            case '1': return 'Februari';
            case '2': return 'March';
            case '3': return 'April';
            case '4': return 'May';
            case '5': return 'June';
            case '6': return 'July';
            case '7': return 'August';
            case '8': return 'September';
            case '9': return 'October';
            case '10': return 'November';
            default: return 'December';
        }
    };
    TicketFormComponent.prototype.onFileChange = function (fileInput) {
        var files = fileInput.target.files;
        if (files && files.length === 1) {
            this.model.ticketFilename = fileInput.target.files[0].name;
            var myModel_1 = this.model;
            var reader = new FileReader();
            reader.onload = function () {
                delete myModel_1.ticketImage;
                // let object = new Uint8Array(this.result);
                // myModel.ticketImage = Object.keys(object).map((key)=>{ return object[key]});
                myModel_1.ticketImage = this.result;
            };
            reader.readAsDataURL(fileInput.target.files[0]);
        }
    };
    TicketFormComponent.prototype.onSubmit = function (event) {
        var _this = this;
        event.preventDefault();
        this.ticketService.addTicket(this.model).
            subscribe(function (ticket) { _this.notificationService.success("Invoice stored successfull"); _this.model = new __WEBPACK_IMPORTED_MODULE_2__ticket_component__["a" /* Ticket */](); }, function (error) { _this.notificationService.danger(error); });
        return true;
    };
    TicketFormComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'ticket-form',
            template: __webpack_require__("../../../../../src/app/ludimus-tax/ticket/form/ticket-form.component.html"),
            styles: [__webpack_require__("../../../../../src/app/ludimus-tax/ticket/form/ticket-form.component.css")],
            providers: [__WEBPACK_IMPORTED_MODULE_1__service_ticket_service__["a" /* TicketService */]]
        }), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__service_ticket_service__["a" /* TicketService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__service_ticket_service__["a" /* TicketService */]) === 'function' && _a) || Object, (typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3__notification_notification_service__["a" /* NotificationService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_3__notification_notification_service__["a" /* NotificationService */]) === 'function' && _b) || Object])
    ], TicketFormComponent);
    return TicketFormComponent;
    var _a, _b;
}());
//# sourceMappingURL=/Volumes/java/ludimus-gui/src/ticket-form.component.js.map

/***/ }),

/***/ "../../../../../src/app/ludimus-tax/ticket/overview/default/default-overview.component.html":
/***/ (function(module, exports) {

module.exports = "<table class=\"table table-striped table-bordered table-hover\" *ngIf=\"tickets\">\n  <thead>\n  <tr>\n    <th>invoiceNumber</th>\n    <th>income</th>\n    <th nowrap=\"true\">last updated</th>\n    <th>decsription</th>\n    <th>price</th>\n    <th>vat</th>\n  </tr>\n  </thead>\n  <tbody>\n  <tr *ngFor=\"let ticket of tickets\" (click)=\"onSelect(ticket)\">\n    <td>{{ticket.invoiceNumber}}</td>\n    <td>{{ticket.income?'+':'-'}}</td>\n    <td>{{ticket.lastUpdated | date}}</td>\n    <td>{{ticket.description}}</td>\n    <td>{{ticket.price}}</td>\n    <td>{{ticket.vatRate}}</td>\n  </tr>\n  </tbody>\n</table>\n"

/***/ }),

/***/ "../../../../../src/app/ludimus-tax/ticket/overview/default/default-overview.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/index.js");
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DefaultOverviewComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var DefaultOverviewComponent = (function () {
    function DefaultOverviewComponent() {
    }
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])(), 
        __metadata('design:type', Object)
    ], DefaultOverviewComponent.prototype, "tickets", void 0);
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])(), 
        __metadata('design:type', Object)
    ], DefaultOverviewComponent.prototype, "onSelect", void 0);
    DefaultOverviewComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'default-overview',
            template: __webpack_require__("../../../../../src/app/ludimus-tax/ticket/overview/default/default-overview.component.html")
        }), 
        __metadata('design:paramtypes', [])
    ], DefaultOverviewComponent);
    return DefaultOverviewComponent;
}());
//# sourceMappingURL=/Volumes/java/ludimus-gui/src/default-overview.component.js.map

/***/ }),

/***/ "../../../../../src/app/ludimus-tax/ticket/overview/income-tax/income-tax-overview.component.html":
/***/ (function(module, exports) {

module.exports = "<div  *ngFor=\"let ticket of tickets\" class=\"panel panel-default\">\n  <div [ngClass]=\"{'bg-success' : ticket.income, 'bg-warning' : !ticket.income}\">{{ticket.income ? 'Bij ' : 'Af ' }}{{ticket.price | currency:'EUR':true:'.0-2'}}</div>\n  <div class=\"panel-body\" *ngIf=\"ticket.ticketImage\">\n    <img src=\"{{getImageBase64(ticket.ticketImage)}}\" style=\"width:90%\"/>\n  </div>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/ludimus-tax/ticket/overview/income-tax/income-tax-overview.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/index.js");
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return IncomeTaxOverviewComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var IncomeTaxOverviewComponent = (function () {
    function IncomeTaxOverviewComponent() {
    }
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])(), 
        __metadata('design:type', Object)
    ], IncomeTaxOverviewComponent.prototype, "tickets", void 0);
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])(), 
        __metadata('design:type', Object)
    ], IncomeTaxOverviewComponent.prototype, "getImageBase64", void 0);
    IncomeTaxOverviewComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'income-tax-overview',
            template: __webpack_require__("../../../../../src/app/ludimus-tax/ticket/overview/income-tax/income-tax-overview.component.html")
        }), 
        __metadata('design:paramtypes', [])
    ], IncomeTaxOverviewComponent);
    return IncomeTaxOverviewComponent;
}());
//# sourceMappingURL=/Volumes/java/ludimus-gui/src/income-tax-overview.component.js.map

/***/ }),

/***/ "../../../../../src/app/ludimus-tax/ticket/overview/tax/tax-overview.component.html":
/***/ (function(module, exports) {

module.exports = "<table class=\"table table-striped table-bordered\" *ngIf=\"tickets\">\n  <thead>\n  <tr>\n    <th class=\"text-primary\">1. Debiteuren</th>\n    <th class=\"text-primary\">2. Crediteuren</th>\n  </tr>\n  </thead>\n  <tr>\n    <td>\n      <table class=\"table table-bordered\">\n        <thead>\n        <tr>\n          <th colspan=\"2\" class=\"text-primary\" style=\"text-align:right;\">Exclusief BTW bedrag</th>\n          <th class=\"text-primary\">BTW</th>\n        </tr>\n        </thead>\n        <tr>\n          <td class=\"text-primary\">BTW 21%</td>\n          <td>{{results.debit21 | currency:'EUR':true:'.0-2'}}</td>\n          <td>{{results.debit21 * .21 | currency:'EUR':true:'.0-2'}}</td>\n        </tr>\n        <tr>\n          <td class=\"text-primary\">BTW 6%</td>\n          <td>{{results.debit6 | currency:'EUR':true:'.0-2'}}</td>\n          <td>{{results.debit6 * .06 | currency:'EUR':true:'.0-2'}}</td>\n        </tr>\n        <tr>\n          <td class=\"text-primary\">BTW 0%</td>\n          <td>{{results.debit0 | currency:'EUR':true:'.0-2'}}</td>\n          <td>€0</td>\n        </tr>\n        <tr>\n          <td class=\"text-primary\">Totaal</td>\n          <td>{{getDebitTotal() | currency:'EUR':true:'.0-2'}}</td>\n          <td>{{results.debit21 * .21 + results.debit6 * .06 | currency:'EUR':true:'.0-2'}}</td>\n        </tr>\n        <tr>\n          <td class=\"text-primary\">Te betalen</td>\n          <td colspan=\"2\" class=\"alert-info\">{{(results.debit21 * .21 + results.debit6 * .06) - (results.credit21 * .21 + results.credit6 * .06) | currency:'EUR':true:'.0-2'}}</td>\n        </tr>\n      </table>\n    </td>\n    <td>\n      <table class=\"table table-bordered\">\n        <thead>\n        <tr>\n          <th colspan=\"2\" class=\"text-primary\" style=\"text-align:right;\">Exclusief BTW bedrag</th>\n          <th class=\"text-primary\">BTW</th>\n        </tr>\n        </thead>\n        <tr>\n          <td class=\"text-primary\">BTW 21%</td>\n          <td>{{results.credit21 | currency:'EUR':true:'.0-2'}}</td>\n          <td>{{results.credit21 * .21 | currency:'EUR':true:'.0-2'}}</td>\n        </tr>\n        <tr>\n          <td class=\"text-primary\">BTW 6%</td>\n          <td>{{results.credit6 | currency:'EUR':true:'.0-2'}}</td>\n          <td>{{results.credit6 * .06 | currency:'EUR':true:'.0-2'}}</td>\n        </tr>\n        <tr>\n          <td class=\"text-primary\">BTW 0%</td>\n          <td>{{results.credit0 | currency:'EUR':true:'.0-2'}}</td>\n          <td>€0</td>\n        </tr>\n        <tr>\n          <td class=\"text-primary\">Totaal</td>\n          <td>{{getCreditTotal() | currency:'EUR':true:'.0-2'}}</td>\n          <td>{{results.credit21 * .21 + results.credit6 * .06 | currency:'EUR':true:'.0-2'}}</td>\n        </tr>\n      </table>\n    </td>\n  </tr>\n</table>\n"

/***/ }),

/***/ "../../../../../src/app/ludimus-tax/ticket/overview/tax/tax-overview.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/index.js");
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TaxOverviewComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var TaxOverviewComponent = (function () {
    function TaxOverviewComponent() {
    }
    TaxOverviewComponent.prototype.ngOnInit = function () {
        this.setResults();
    };
    TaxOverviewComponent.prototype.ngOnChanges = function (changes) {
        if (changes.tickets) {
            this.setResults();
        }
    };
    TaxOverviewComponent.prototype.setResults = function () {
        this.results = { debit21: this.getDebit(21), credit21: this.getCredit(21),
            debit6: this.getDebit(6), credit6: this.getCredit(6),
            debit0: this.getDebit(0), credit0: this.getCredit(0) };
    };
    TaxOverviewComponent.prototype.getDebit = function (value) {
        var total = 0;
        this.tickets.filter(function (ticket) { return ticket.vatRate === value && ticket.income; }).forEach((function (item) { return total += item.price; }));
        return total;
    };
    TaxOverviewComponent.prototype.getCredit = function (value) {
        var total = 0;
        this.tickets.filter(function (ticket) { return ticket.vatRate === value && !ticket.income; }).forEach((function (item) { return total += item.price; }));
        return total;
    };
    TaxOverviewComponent.prototype.getDebitTotal = function () {
        return this.results.debit21 + this.results.debit6 + this.results.debit0;
    };
    TaxOverviewComponent.prototype.getCreditTotal = function () {
        return this.results.credit21 + this.results.credit6 + this.results.credit0;
    };
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])(), 
        __metadata('design:type', Object)
    ], TaxOverviewComponent.prototype, "tickets", void 0);
    TaxOverviewComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'tax-overview',
            template: __webpack_require__("../../../../../src/app/ludimus-tax/ticket/overview/tax/tax-overview.component.html")
        }), 
        __metadata('design:paramtypes', [])
    ], TaxOverviewComponent);
    return TaxOverviewComponent;
}());
//# sourceMappingURL=/Volumes/java/ludimus-gui/src/tax-overview.component.js.map

/***/ }),

/***/ "../../../../../src/app/ludimus-tax/ticket/overview/ticket-overview.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n  <form>\n    <div class=\"form-group row\">\n      <label for=\"period\" class=\"col-xs-3 col-form-label\">Period</label>\n      <div class=\"col-xs-9\">\n        <select id=\"period\" class=\"form-control\" name=\"period\" [(ngModel)]=\"period.choice\"\n                (ngModelChange)=\"onChange($event)\">\n          <option *ngFor=\"let p of period.values\" [value]=\"p\">{{p}}</option>\n        </select>\n      </div>\n    </div>\n    <div class=\"form-group row\">\n      <label for=\"from\" class=\"col-xs-3 col-form-label\">From</label>\n      <div class=\"col-xs-9\">\n        <input class=\"form-control\" [(ngModel)]=\"fromDate\" name=\"fromDate\" type=\"date\" id=\"from\" required\n               (ngModelChange)=\"onChange($event)\">\n      </div>\n    </div>\n    <div class=\"form-group row\">\n      <label for=\"to\" class=\"col-xs-3 col-form-label\">To</label>\n      <div class=\"col-xs-9\">\n        <input class=\"form-control\" [(ngModel)]=\"toDate\" name=\"toDate\" type=\"date\" id=\"to\" required\n               (ngModelChange)=\"onChange($event)\">\n      </div>\n    </div>\n    <div class=\"form-group row\">\n      <label for=\"period\" class=\"col-xs-3 col-form-label\">Rapporten</label>\n      <label class=\"radio-inline\">\n        <input type=\"radio\" [(ngModel)]=\"which.value\" name=\"which\" value=\"tax\"> aangifte omzetbelasting\n      </label>\n      <label class=\"radio-inline\">\n        <input type=\"radio\" [(ngModel)]=\"which.value\" name=\"which\" value=\"tax-overview\"> inkomste belasting\n      </label>\n      <label class=\"radio-inline\">\n        <input type=\"radio\" [(ngModel)]=\"which.value\" name=\"which\" value=\"default\"> overzicht\n      </label>\n    </div>\n  </form>\n  <hr/>\n  <default-overview [tickets]=\"tickets\" [onSelect]=\"onSelect.bind(this)\"\n                    *ngIf=\"which.value === 'default'\"></default-overview>\n  <tax-overview [tickets]=\"tickets\" *ngIf=\"which.value === 'tax'\"></tax-overview>\n  <income-tax-overview [tickets]=\"tickets\" [getImageBase64]=\"getImageBase64.bind(this)\"\n                       *ngIf=\"which.value === 'tax-overview'\"></income-tax-overview>\n  <div id=\"myModal\" class=\"modal\" role=\"dialog\">\n    <div class=\"modal-dialog\">\n\n      <!-- Modal content-->\n      <div class=\"modal-content\">\n        <div class=\"modal-header\">\n          <button type=\"button\" class=\"close\" data-dismiss=\"modal\" (click)=\"doClose()\">&times;</button>\n        </div>\n        <div class=\"modal-body\" *ngIf=\"selectedTicket && selectedTicket.ticketImage\">\n          <img src=\"{{getImageBase64(selectedTicket.ticketImage)}}\" style=\"width:500px;\"/>\n        </div>\n      </div>\n    </div>\n  </div>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/ludimus-tax/ticket/overview/ticket-overview.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__service_ticket_service__ = __webpack_require__("../../../../../src/app/ludimus-tax/ticket/service/ticket.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__period_component__ = __webpack_require__("../../../../../src/app/ludimus-tax/ticket/period.component.ts");
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TicketOverviewComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var TicketOverviewComponent = (function () {
    function TicketOverviewComponent(ticketService) {
        this.ticketService = ticketService;
        this.period = new __WEBPACK_IMPORTED_MODULE_2__period_component__["a" /* Period */]();
    }
    TicketOverviewComponent.prototype.ngOnInit = function () {
        this.requestTickets();
        this.which = { value: 'default' };
    };
    TicketOverviewComponent.prototype.onChange = function (newValue) {
        this.requestTickets();
    };
    TicketOverviewComponent.prototype.requestTickets = function () {
        var _this = this;
        this.ticketService.getTickets(this.period.range.from, this.period.range.to).subscribe(function (tickets) { _this.tickets = tickets; }, function (error) {
            console.log(error);
        });
    };
    Object.defineProperty(TicketOverviewComponent.prototype, "fromDate", {
        get: function () {
            return this.period.range.from.toISOString().substring(0, 10);
        },
        set: function (e) {
            if (e) {
                var splitted = e.split('-');
                this.period.from = new Date(Date.UTC(Number(splitted[0]), Number(splitted[1]) - 1, Number(splitted[2])));
            }
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(TicketOverviewComponent.prototype, "toDate", {
        get: function () {
            return this.period.range.to.toISOString().substring(0, 10);
        },
        set: function (e) {
            if (e) {
                var splitted = e.split('-');
                this.period.to = new Date(Date.UTC(Number(splitted[0]), Number(splitted[1]) - 1, Number(splitted[2])));
            }
        },
        enumerable: true,
        configurable: true
    });
    TicketOverviewComponent.prototype.onSelect = function (ticket) {
        this.selectedTicket = ticket;
        if (this.selectedTicket.ticketImage) {
            document.querySelector('#myModal').setAttribute('style', 'display:block');
        }
    };
    TicketOverviewComponent.prototype.doClose = function () {
        document.querySelector('#myModal').setAttribute('style', 'display:none');
    };
    TicketOverviewComponent.prototype.getImageBase64 = function (data) {
        return 'data:image/jpg;base64,' + data;
    };
    TicketOverviewComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'ticket-overview',
            template: __webpack_require__("../../../../../src/app/ludimus-tax/ticket/overview/ticket-overview.component.html"),
            providers: [__WEBPACK_IMPORTED_MODULE_1__service_ticket_service__["a" /* TicketService */]]
        }), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__service_ticket_service__["a" /* TicketService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__service_ticket_service__["a" /* TicketService */]) === 'function' && _a) || Object])
    ], TicketOverviewComponent);
    return TicketOverviewComponent;
    var _a;
}());
//# sourceMappingURL=/Volumes/java/ludimus-gui/src/ticket-overview.component.js.map

/***/ }),

/***/ "../../../../../src/app/ludimus-tax/ticket/period.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Period; });
var Period = (function () {
    function Period() {
        this.values = ['quarter1',
            'quarter2',
            'quarter3',
            'quarter4',
            'untilNow'];
        this.range = { from: new Date(), to: new Date() };
        this.selectedIndex = 4;
        this.setFromTo();
    }
    Object.defineProperty(Period.prototype, "from", {
        set: function (value) {
            this.range.from = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Period.prototype, "to", {
        set: function (value) {
            this.range.to = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Period.prototype, "choice", {
        get: function () {
            return this.values[this.selectedIndex];
        },
        set: function (value) {
            this.selectedIndex = this.values.indexOf(value);
            this.setFromTo();
        },
        enumerable: true,
        configurable: true
    });
    Period.prototype.setFromTo = function () {
        var date = new Date();
        switch (this.selectedIndex) {
            case 0: {
                this.from = new Date(date.getFullYear(), 0, 1);
                this.to = new Date(date.getFullYear(), 3, 0);
                break;
            }
            case 1: {
                this.from = new Date(date.getFullYear(), 3, 1);
                this.to = new Date(date.getFullYear(), 6, 0);
                break;
            }
            case 2: {
                this.from = new Date(date.getFullYear(), 6, 1);
                this.to = new Date(date.getFullYear(), 9, 0);
                break;
            }
            case 3: {
                this.from = new Date(date.getFullYear(), 9, 1);
                this.to = new Date(date.getFullYear(), 12, 0);
                break;
            }
            default: {
                this.from = new Date(date.getFullYear(), 0, 1);
                this.to = date;
                break;
            }
        }
    };
    return Period;
}());
//# sourceMappingURL=/Volumes/java/ludimus-gui/src/period.component.js.map

/***/ }),

/***/ "../../../../../src/app/ludimus-tax/ticket/service/ticket.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__("../../../http/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_add_observable_throw__ = __webpack_require__("../../../../rxjs/add/observable/throw.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_add_observable_throw___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_rxjs_add_observable_throw__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map__ = __webpack_require__("../../../../rxjs/add/operator/map.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_rxjs_add_operator_catch__ = __webpack_require__("../../../../rxjs/add/operator/catch.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_rxjs_add_operator_catch___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_4_rxjs_add_operator_catch__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_angular2_jwt__ = __webpack_require__("../../../../angular2-jwt/angular2-jwt.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_angular2_jwt___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_5_angular2_jwt__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__environments_environment__ = __webpack_require__("../../../../../src/environments/environment.ts");
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TicketService; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var TicketService = (function () {
    function TicketService(authHttp) {
        this.authHttp = authHttp;
        this.url = __WEBPACK_IMPORTED_MODULE_6__environments_environment__["a" /* environment */].baseUrl + 'ludimus/'; // URL to web API
        window.console.log('url from environment is ', this.url);
    }
    TicketService.prototype.resolve = function (res) {
        return res.json() || {};
    };
    TicketService.prototype.reject = function (error) {
        return error.json() || {};
    };
    TicketService.prototype.getTickets = function (from, to) {
        var params = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["URLSearchParams"]();
        params.set('from', from.toISOString());
        params.set('to', to.toISOString());
        return this.authHttp.get(this.url + 'overview', { search: params })
            .map(this.resolve)
            .catch(this.reject);
    };
    ;
    TicketService.prototype.addTicket = function (ticket) {
        var headers = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["Headers"]({ 'Content-Type': 'application/json' });
        var options = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["RequestOptions"]({ headers: headers });
        return this.authHttp.post(this.url + 'addTicket', ticket, options)
            .map(this.resolve)
            .catch(this.reject);
    };
    TicketService = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_5_angular2_jwt__["AuthHttp"] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_5_angular2_jwt__["AuthHttp"]) === 'function' && _a) || Object])
    ], TicketService);
    return TicketService;
    var _a;
}());
//# sourceMappingURL=/Volumes/java/ludimus-gui/src/ticket.service.js.map

/***/ }),

/***/ "../../../../../src/app/ludimus-tax/ticket/ticket.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Ticket; });
var Ticket = (function () {
    function Ticket() {
        this.ticketDate = new Date();
        this.income = true;
        this.vatRate = 21;
        this.forMonth = this.ticketDate.getMonth() > 0 ? this.ticketDate.getMonth() - 1 : 11;
    }
    return Ticket;
}());
//# sourceMappingURL=/Volumes/java/ludimus-gui/src/ticket.component.js.map

/***/ }),

/***/ "../../../../../src/app/notification/notification.component.html":
/***/ (function(module, exports) {

module.exports = "<div *ngIf=\"isSuccess() || isInfo() || isWarning() || isDanger()\">\n  <div class=\"alert alert-success\" role=\"alert\" *ngIf=\"isSuccess()\">{{getSuccessText()}}</div>\n  <div class=\"alert alert-info\" role=\"alert\" *ngIf=\"isInfo()\">{{getInfoText()}}</div>\n  <div class=\"alert alert-warning\" role=\"alert\" *ngIf=\"isWarning()\">{{getWarningText()}}</div>\n  <div class=\"alert alert-danger\" role=\"alert\" *ngIf=\"isDanger()\">{{getDangerText()}}</div>\n</div>"

/***/ }),

/***/ "../../../../../src/app/notification/notification.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__notification_service__ = __webpack_require__("../../../../../src/app/notification/notification.service.ts");
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return NotificationComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var NotificationComponent = (function () {
    function NotificationComponent(notificationService) {
        this.notificationService = notificationService;
    }
    NotificationComponent.prototype.ngOnInit = function () {
    };
    NotificationComponent.prototype.isSuccess = function () {
        return this.notificationService.isSuccess();
    };
    NotificationComponent.prototype.isInfo = function () {
        return this.notificationService.isInfo();
    };
    NotificationComponent.prototype.isDanger = function () {
        return this.notificationService.isDanger();
    };
    NotificationComponent.prototype.isWarning = function () {
        return this.notificationService.isWarning();
    };
    NotificationComponent.prototype.getSuccessText = function () {
        return this.notificationService.getSuccessText();
    };
    NotificationComponent.prototype.getInfoText = function () {
        return this.notificationService.getInfoText();
    };
    NotificationComponent.prototype.getDangerText = function () {
        return this.notificationService.getDangerText();
    };
    NotificationComponent.prototype.getWarningText = function () {
        return this.notificationService.getWarningText();
    };
    NotificationComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-notification',
            template: __webpack_require__("../../../../../src/app/notification/notification.component.html")
        }), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__notification_service__["a" /* NotificationService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__notification_service__["a" /* NotificationService */]) === 'function' && _a) || Object])
    ], NotificationComponent);
    return NotificationComponent;
    var _a;
}());
//# sourceMappingURL=/Volumes/java/ludimus-gui/src/notification.component.js.map

/***/ }),

/***/ "../../../../../src/app/notification/notification.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/index.js");
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return NotificationService; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var NotificationService = (function () {
    function NotificationService() {
        this.notifications = {};
    }
    NotificationService.prototype.success = function (message) {
        this.notifications['success'] = message;
        this.removeAfterTimeout('success');
    };
    NotificationService.prototype.info = function (message) {
        this.notifications['info'] = message;
        this.removeAfterTimeout('info');
    };
    NotificationService.prototype.danger = function (message) {
        this.notifications['danger'] = message;
        this.removeAfterTimeout('danger');
    };
    NotificationService.prototype.warning = function (message) {
        this.notifications['warning'] = message;
        this.removeAfterTimeout('warning');
    };
    NotificationService.prototype.isSuccess = function () {
        return this.notifications['success'];
    };
    NotificationService.prototype.isInfo = function () {
        return this.notifications['info'];
    };
    NotificationService.prototype.isDanger = function () {
        return this.notifications['danger'];
    };
    NotificationService.prototype.isWarning = function () {
        return this.notifications['warning'];
    };
    NotificationService.prototype.getSuccessText = function () {
        return this.notifications['success'];
    };
    NotificationService.prototype.getInfoText = function () {
        return this.notifications['info'];
    };
    NotificationService.prototype.getDangerText = function () {
        return this.notifications['danger'];
    };
    NotificationService.prototype.getWarningText = function () {
        return this.notifications['warning'];
    };
    NotificationService.prototype.removeAfterTimeout = function (label) {
        var notifications = this.notifications;
        setTimeout(function () {
            notifications[label] = undefined;
        }, 6000);
    };
    NotificationService = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(), 
        __metadata('design:paramtypes', [])
    ], NotificationService);
    return NotificationService;
}());
//# sourceMappingURL=/Volumes/java/ludimus-gui/src/notification.service.js.map

/***/ }),

/***/ "../../../../../src/environments/environment.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
var environment = {
    production: true,
    baseUrl: '/'
};
//# sourceMappingURL=/Volumes/java/ludimus-gui/src/environment.js.map

/***/ }),

/***/ "../../../../../src/main.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__polyfills_ts__ = __webpack_require__("../../../../../src/polyfills.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__("../../../platform-browser-dynamic/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_core__ = __webpack_require__("../../../core/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("../../../../../src/environments/environment.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__app_app_module__ = __webpack_require__("../../../../../src/app/app.module.ts");





if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_2__angular_core__["enableProdMode"])();
}
__webpack_require__.i(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_4__app_app_module__["a" /* AppModule */]);
//# sourceMappingURL=/Volumes/java/ludimus-gui/src/main.js.map

/***/ }),

/***/ "../../../../../src/polyfills.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_core_js_es6_symbol__ = __webpack_require__("../../../../core-js/es6/symbol.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_core_js_es6_symbol___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_core_js_es6_symbol__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_core_js_es6_object__ = __webpack_require__("../../../../core-js/es6/object.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_core_js_es6_object___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_core_js_es6_object__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_core_js_es6_function__ = __webpack_require__("../../../../core-js/es6/function.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_core_js_es6_function___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_core_js_es6_function__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_core_js_es6_parse_int__ = __webpack_require__("../../../../core-js/es6/parse-int.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_core_js_es6_parse_int___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_3_core_js_es6_parse_int__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_core_js_es6_parse_float__ = __webpack_require__("../../../../core-js/es6/parse-float.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_core_js_es6_parse_float___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_4_core_js_es6_parse_float__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_core_js_es6_number__ = __webpack_require__("../../../../core-js/es6/number.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_core_js_es6_number___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_5_core_js_es6_number__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_core_js_es6_math__ = __webpack_require__("../../../../core-js/es6/math.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_core_js_es6_math___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_6_core_js_es6_math__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_core_js_es6_string__ = __webpack_require__("../../../../core-js/es6/string.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_core_js_es6_string___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_7_core_js_es6_string__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8_core_js_es6_date__ = __webpack_require__("../../../../core-js/es6/date.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8_core_js_es6_date___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_8_core_js_es6_date__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9_core_js_es6_array__ = __webpack_require__("../../../../core-js/es6/array.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9_core_js_es6_array___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_9_core_js_es6_array__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10_core_js_es6_regexp__ = __webpack_require__("../../../../core-js/es6/regexp.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10_core_js_es6_regexp___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_10_core_js_es6_regexp__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11_core_js_es6_map__ = __webpack_require__("../../../../core-js/es6/map.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11_core_js_es6_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_11_core_js_es6_map__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12_core_js_es6_set__ = __webpack_require__("../../../../core-js/es6/set.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12_core_js_es6_set___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_12_core_js_es6_set__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13_core_js_es6_reflect__ = __webpack_require__("../../../../core-js/es6/reflect.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13_core_js_es6_reflect___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_13_core_js_es6_reflect__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14_core_js_es7_reflect__ = __webpack_require__("../../../../core-js/es7/reflect.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14_core_js_es7_reflect___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_14_core_js_es7_reflect__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15_zone_js_dist_zone__ = __webpack_require__("../../../../zone.js/dist/zone.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15_zone_js_dist_zone___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_15_zone_js_dist_zone__);
















//# sourceMappingURL=/Volumes/java/ludimus-gui/src/polyfills.js.map

/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("../../../../../src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map