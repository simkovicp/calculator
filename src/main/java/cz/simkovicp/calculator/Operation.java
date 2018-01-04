package cz.simkovicp.calculator;

import java.math.BigDecimal;

import cz.simkovicp.calculator.valueobj.OperationResult;

public abstract class Operation {

    /**
     * Execute the operation.
     * 
     * @param operandA the operand A
     * @param operandB the operand B
     * @return the operation result
     */
    public OperationResult execute(String operandA, String operandB) {
        OperationResult operationResult = new OperationResult();
        // check the operation values
        if (operandA == null && operandB == null) {
            operationResult.addError("No values!");
        } else {
            operationResult.setResult(
                    operationImpl(checkValue(operandA, operationResult), checkValue(operandB, operationResult)));
        }
        return operationResult;
    }

    /**
     * Implement this method to execute operation. 
     * @param operandA the operand A
     * @param operandB the operand B
     * @return the numeric value of the operation
     */
    protected abstract BigDecimal operationImpl(BigDecimal operandA, BigDecimal operandB);

    /**
     * Check the value. If it's not possible to convert the value into number the
     * error message is added into operation result.
     * 
     * @param value the value
     * @param result the operation result
     * @return the value as a BigDecimal
     */
    protected BigDecimal checkValue(String value, final OperationResult result) {
        if (value == null) {
            result.addError("Missing value!");
        } else {
            try {
                return new BigDecimal(value);
            } catch (NumberFormatException nfException) {
                result.addError(String.format("Bad number format for '%s'", value));
            }
        }
        return null;
    }

}
