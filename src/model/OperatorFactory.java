package model;

//Factory method
//AbstractFactory
//State
public class OperatorFactory {
    public static final String SQRT = "√";
    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String DIVIDE = "/";
    public static final String MULTIPLICATE = "*";
    public static final String MOD = "%";
    public static final String LG = "lg";
    public static final String LN = "ln";
    public static final String FACTORIAL = "!";


    public static Operator getOperator(String operator) throws Exception {
        switch (operator) {
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
            case LG: {
                return new UnaryOperator(LG);
            }
            case LN: {
                return new UnaryOperator(LN);
            }
            case FACTORIAL: {
                return new UnaryOperator(FACTORIAL);
            }
        }

        throw new Exception("The token given is not an operator");
    }
}
