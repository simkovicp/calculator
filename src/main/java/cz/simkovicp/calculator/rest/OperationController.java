package cz.simkovicp.calculator.rest;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cz.simkovicp.calculator.Operation;
import cz.simkovicp.calculator.OperationLog;
import cz.simkovicp.calculator.valueobj.OperationInput;
import cz.simkovicp.calculator.valueobj.OperationResult;

@RequestMapping("/api")
@RestController
public class OperationController {
    
    @Autowired
    private OperationLog additionLog;
    
    private Operation addition = new Operation() {
        
        @Override
        protected BigDecimal operationImpl(BigDecimal operandA, BigDecimal operandB) {
            if(operandA == null || operandB == null) {
                return null;
            }
            return new BigDecimal(0).add(operandA).add(operandB);
        }
    };  

	@RequestMapping(value = "addition", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OperationResult> addition(@RequestBody OperationInput input, HttpServletRequest request) {
	    // execute operation
	    OperationResult operationResult = addition.execute(input.getOperandA(), input.getOperandB());
	    // log request and operation result
        additionLog.putMessage(String.format("%s a = %s, b = %s, result = %s, errors = %s", request.getRemoteAddr(), 
                input.getOperandA(), input.getOperandB(),
                operationResult.getResult(), operationResult.getErrors()));
        // return the operation result
        return new ResponseEntity<>(operationResult,
                operationResult.getResult() == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
	}
	
}
