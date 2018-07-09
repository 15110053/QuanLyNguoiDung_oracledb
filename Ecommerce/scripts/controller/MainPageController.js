angular.module("EcommerceModule").controller("MainPageController", function ($mdMenu){
	this.openmenu = function($mdMenu, ev){
		$mdMenu.open(ev);
	}
});