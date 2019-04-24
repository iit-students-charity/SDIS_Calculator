package model;


public class UnaryOperator extends Token implements Operator {
    private Operand operand;


    public UnaryOperator(String source) {
        super.source = source;
    }

    public UnaryOperator(String source, Operand operand) {
        this(source);
        this.operand = operand;
    }

    @Override
    public double result() {
        switch (source) {
            case OperatorFactory.SQRT: {
                return Math.sqrt(operand.value());
            }
            case OperatorFactory.LOG: {
                return Math.log10(operand.value());
            }
            case OperatorFactory.LN: {
                return Math.log(operand.value());
            }
            case OperatorFactory.FACTORIAL: {
                int factorial = 1;

                for (int positiveInt = 2; positiveInt <= (int) operand.value(); positiveInt++) {
                    factorial *= positiveInt;
                }

                return factorial;
            }
        }

        return 0;
    }

    public void setOperand(Operand operand) {
        this.operand = operand;
    }
}
