package model;

public abstract class Token {
    protected String source;


    public String source() {
        return source;
    }

    @Override
    public String toString() {
        return source;
    }
}
