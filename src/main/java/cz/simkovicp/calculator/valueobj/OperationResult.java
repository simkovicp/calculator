package cz.simkovicp.calculator.valueobj;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OperationResult {

    /**
     * Operation result.
     */
    private BigDecimal result;
    /**
     * Error messages
     */
    private List<String> errors;

    public OperationResult() {
    }

    /**
     * @return the result
     */
    public BigDecimal getResult() {
        return result;
    }

    /**
     * @param result
     *            the result to set
     */
    public void setResult(BigDecimal result) {
        this.result = result;
    }

    /**
     * @return the errors
     */
    public List<String> getErrors() {
        return errors;
    }

    /**
     * @param errors
     *            the errors to set
     */
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    /**
     * Add the error message.
     * 
     * @param error
     *            the error message
     */
    public void addError(String error) {
        if (errors == null) {
            errors = new ArrayList<>();
        }
        errors.add(error);
    }

}
