calculator.factory('calculatorService', function($http) {

	return {
		doAddition : function(operandA, operandB, callback) {
			var parameters = JSON.stringify({
				operandA : operandA,
				operandB : operandB
			});
		    $http.post('/api/addition', parameters).
		    	success(function(data, status, headers, config) {
		    		callback(data, status);
		    	}).
		    	error(function(data, status, headers, config) {
		    		callback(data, status);
		    	});
		},
		getAdditionLog : function(callback) {
		    $http.get('/api/log/addition').
		    	success(function(data, status, headers, config) {
		    		callback(data, status);
		    	}).
		    	error(function(data, status, headers, config) {
		    		callback(data, status);
		    	});
		},
		
	}
})