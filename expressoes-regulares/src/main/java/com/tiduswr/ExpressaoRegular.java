package com.tiduswr;

import lombok.Getter;

@Getter
public class ExpressaoRegular {

    private final String BRANCO, BRANCOS;
    private final String DIGITO, DIGITOS;
    private final String LETRA, LETRAS;
    private final String IDENT;
    private final String REAL;
    private final String INTEIRO;
    private final String NUMEROS;    
    
    public ExpressaoRegular() {
        BRANCO = "(\\s)";
        BRANCOS = BRANCO + "*";
        DIGITO = "([0-9])";
        DIGITOS = DIGITO + "*";
        LETRA = "([A-Za-z])";
        LETRAS = LETRA + "*";
        IDENT = "(" + LETRA + "(" + LETRA + "|" + DIGITO + ")*)";
        REAL = "\\-?" + DIGITOS + "\\.?" + DIGITOS;
        INTEIRO = "\\-?" + DIGITOS ;
        NUMEROS = "(" + INTEIRO + "|" + REAL + ")";         
    }

    public void confere(String exp, String sentenca) {
        if ((sentenca != null) && !sentenca.isEmpty()) {
            if (sentenca.matches(exp)) {
                System.out.println("W:'" + sentenca + "'........ ACEITA!");
            } else {
                System.err.println("W:'" + sentenca + "'........ rejeitada.");
            }
        } else {
            System.err.println("Sentença vazia.");
        }
    }
    
}
