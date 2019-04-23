package model;


public class Operand {
    private double doubleSource;


    public Operand(double doubleSource) {
        this.doubleSource = doubleSource;
    }

    @Override
    public String toString() {
        return String.valueOf(doubleSource);
    }

    public double doubleSource() {
        return doubleSource;
    }
}
