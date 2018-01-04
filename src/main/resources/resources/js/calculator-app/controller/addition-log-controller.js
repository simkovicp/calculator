'use strict';

calculator.config(function($stateProvider) {
	$stateProvider.state('additionLog', {
		parent : 'site',
		url : 'additionLog',
		views : {
			'content@' : {
				templateUrl : 'js/calculator-app/view/addition-log.html',
				controller : 'addition-log-controller',
			}
		}
	});
});

calculator.controller('addition-log-controller', function($scope, $interval, $rootScope, calculatorService) {

	$scope.messages = [];
	// always read log messages when the state is changed to additionLog
	readLogs();
	// run interval service only once
	if(typeof($rootScope.readLogsCancelPremise) === 'undefined') {
		$rootScope.readLogsCancelPremise = $interval(readLogs, 30 * 1000);
	}
	
	function readLogs(){
		$scope.messages = [];
		calculatorService.getAdditionLog(function(responseData, status) {
			console.log(responseData);
			if (status == 200){
				$scope.messages = responseData;
			} else {
				// TODO handle error
			}
		});
	}
	
});
