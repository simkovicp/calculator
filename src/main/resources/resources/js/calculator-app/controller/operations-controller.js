'use strict';

calculator.config(function($stateProvider) {
	$stateProvider.state('operations', {
		parent : 'site',
		url : 'operations',
		views : {
			'content@' : {
				templateUrl : 'js/calculator-app/view/operations.html',
				controller : 'operations-controller',
			}
		}
	});
});

calculator.controller('operations-controller', function($scope, calculatorService) {
	$scope.operandA = null;
	$scope.operandB = null;
	$scope.operationResult = createOperationResult();
	
	function createOperationResult() {
		return {result: null, errors: [] };
	}
	
	$scope.doAddition = function() {
		// create empty result
		$scope.operationResult = createOperationResult();
		// call REST service
		calculatorService.doAddition($scope.operandA, $scope.operandB, function(responseData, status) {
			console.log(responseData);
			if('result' in responseData && responseData.result != null) {
				$scope.operationResult.result = responseData.result; 
			} else {
				if ('errors' in responseData) {
					for(var i=0; i < responseData.errors.length; i++){
						$scope.operationResult.errors.push(responseData.errors[i]);
					}
				} else {
					if ('error' in responseData) {
						$scope.operationResult.errors.push(responseData.error);
					}
					if ('message' in responseData) {
						$scope.operationResult.errors.push(responseData.message);
					}
				}
			}
		});
	}
	
});