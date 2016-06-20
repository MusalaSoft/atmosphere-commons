package com.musala.atmosphere.commons;

/**
 * A class that validates a routing action argument.
 * 
 * @author delyan.dimitrov
 * 
 */
public class RoutingActionArgumentValidator {
    private static final String INVALID_CLASS_MESSAGE_FORMATTER = "Argument was not an instance of %s. It was an instance of %s instead.";

    private Class<?> expectedClass;

    private boolean allowNull;

    /**
     * Creates a validator for a routing action argument of a given class, which allows null values, if shouldAllowNull
     * is set to <code>true</code>.
     * 
     * @param expectedClass
     *        - the expected type of the argument
     * @param shouldAllowNull
     *        - indicates whether null is an allowed value for this argument
     */
    public RoutingActionArgumentValidator(Class<?> expectedClass, boolean shouldAllowNull) {
        this.expectedClass = expectedClass;
        allowNull = shouldAllowNull;
    }

    /**
     * Creates a validator for a routing action argument of a given class, which does not allow null values.
     * 
     * @param expectedType
     *        - the expected type of the argument
     */
    public RoutingActionArgumentValidator(Class<?> expectedType) {
        this(expectedType, false);
    }

    /**
     * Validates a routing action argument.
     * 
     * @param anArgument
     *        - the argument to be validated
     */
    public void validateArgument(Object anArgument) {
        if (anArgument == null && !allowNull) {
            throw new IllegalArgumentException("Argument was null, when null is not an allowed value.");
        }

        if (!expectedClass.isInstance(anArgument) && anArgument != null) {
            Class<?> argumentActualClass = anArgument.getClass();
            String validationErrorMessage = String.format(INVALID_CLASS_MESSAGE_FORMATTER,
                                                          expectedClass.getName(),
                                                          argumentActualClass.getName());
            throw new IllegalArgumentException(validationErrorMessage);
        }
    }
}
