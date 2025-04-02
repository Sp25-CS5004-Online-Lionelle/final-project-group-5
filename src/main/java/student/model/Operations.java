package student.model;

/**
 * Enum representing valid filter operations for movie attributes.
 */
public enum Operations {

    EQUALS("=="),
    NOT_EQUALS("!="),
    GREATER_THAN(">"),
    LESS_THAN("<"),
    GREATER_THAN_EQUAL(">="),
    LESS_THAN_EQUAL("<="),
    CONTAINS("~=");  // for partial text

 
    private final String operator;

    /**
     * Constructor for the operation enum constants
     * 
     * @param operator The operator symbol.
     */
    Operations(String operator) {
        this.operator = operator;
    }


    /**
     * getter method to get the symbol for the operation.
     * 
     * @return The operator as a string. 
     */
    public String getOperator() {
        return operator;
    }

     /**
     * Returns the Operation corresponding to a given operator string.
     * @param the operator (e.g., "==", ">=")
     * @return the matching Operation enum
     * @throws IllegalArgumentException if no match is found
     */
    public static Operations fromOperator(String operator) {
        for (Operations op : Operations.values()) {
            if (op.operator.equals(operator)) {
                return op;
            }
        }
        throw new IllegalArgumentException("No operator with this symbol:" + operator);
    }


}