package model;

public class Bracket extends Token {
    public static final String OPEN = "(";
    public static final String CLOSE = ")";

    public Bracket(String bracket) {
        super.source = bracket;
    }
}
