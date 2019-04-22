package model;

public class OperatorFactory {
    public enum Type { REVERSE, SQRT, PLUS, MINUS, DIVIDE, MULTIPLICATE, MOD }

    public static final String REVERSE = "1/x";
    public static final String SQRT = "√";
    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String DIVIDE = "/";
    public static final String MULTIPLICATE = "*";
    public static final String MOD = "%";


    public static Operator getOperator(Type type) throws Exception {
        switch (type) {
            case REVERSE: {
                return new UnaryOperator(REVERSE);
            }
            case SQRT: {
                return new UnaryOperator(SQRT);
            }
            case PLUS: {
                return new BinaryOperator(PLUS);
            }
            case MINUS: {
                return new BinaryOperator(MINUS);
            }
            case DIVIDE: {
                return new BinaryOperator(DIVIDE);
            }
            case MULTIPLICATE: {
                return new BinaryOperator(MULTIPLICATE);
            }
            case MOD: {
                return new BinaryOperator(MOD);
            }
        }

        throw new Exception("No operation matches the type given");
    }
}
