package model;


public class Operand extends Token {
    private double value;


    public Operand(String source) throws NumberFormatException {
        super.source = source;

        value = Double.parseDouble(source);
    }

    public Operand(double value) {
        this.value = value;
        super.source = String.valueOf(this.value);
    }

    public double value() {
        return value;
    }
}
