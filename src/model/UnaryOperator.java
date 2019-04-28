package model;


public class UnaryOperator extends Token implements Operator {
    private Operand operand;


    public UnaryOperator(String source) {
        super.source = source;
    }

    @Override
    public Operand result() {
        switch (source) {
            case OperatorFactory.SQRT: {
                return new Operand(Math.sqrt(operand.value()));
            }
            case OperatorFactory.LG: {
                return new Operand(Math.log10(operand.value()));
            }
            case OperatorFactory.LN: {
                return new Operand(Math.log(operand.value()));
            }
            case OperatorFactory.FACTORIAL: {
                int factorial = 1;

                for (int positiveInt = 2; positiveInt <= (int) operand.value(); positiveInt++) {
                    factorial *= positiveInt;
                }

                return new Operand(factorial);
            }
        }

        return null;
    }

    public void setOperand(Operand operand) {
        this.operand = operand;
    }
}
