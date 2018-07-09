var app = angular.module("EcommerceModule", ["ngRoute", "ngMaterial"]);
app.config(function($routeProvider){
	$routeProvider
	.when("/", {templateUrl : "views/mainpage.html"})
	.when("product", {templateUrl : "views/productpage.html"})
	.otherwise({templateUrl: "views/404.html"});
});