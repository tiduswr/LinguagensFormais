package com.tiduswr;

public record Symbol(
    char symbol
){
    public static final Symbol VAZIO = new Symbol('ε');
}
