var calculator = angular.module('calculator', [ 'ui.router']);

calculator.config(function($stateProvider, $urlRouterProvider, $httpProvider) {
	$stateProvider.state('site', {
		'abstract' : true,
		cache : false,
		url : '/',
		views : {
			'header@' : {
				templateUrl : 'js/calculator-app/view/header.html'
			}
		}
	});
});

calculator.run(function($rootScope, $state) {
	$state.go('operations');
});