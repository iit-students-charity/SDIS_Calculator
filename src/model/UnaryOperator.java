package model;


public class UnaryOperator implements Operator, Sourcable {
    private Operand operand;
    private Token token;


    public UnaryOperator(String source) {
        token = new Token(source);
    }

    @Override
    public Operand result() {
        switch (token.source()) {
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

    public Token getToken() {
        return token;
    }

    @Override
    public String getSource() {
        return token.source();
    }
}
