package com.tiduswr;

public class Main {
    public static void main(String[] args) {
        ExpressaoRegular ER = new ExpressaoRegular();

        //Teste 1, expressão regular: DIGITOS
        ER.confere(ER.getDIGITO(), "000511200021");
        
        //Teste 2, expressão regular: DIGITOS
        ER.confere(ER.getDIGITOS(), "000511200021ADAF");
        
        //Teste 3, expressão regular: LETRAS
        ER.confere(ER.getLETRAS(), "ASDFEAFdafsafdsf");

        //Teste 4, expressão regular: LETRAS
        ER.confere(ER.getLETRAS(), "ASDFEAFdafsafdsf4565");
                
        //Teste 5, expressão regular: IDENT (nome de variável, função e classes)
        ER.confere(ER.getIDENT(), "Altura1");

        //Teste 6, expressão regular: IDENT (nome de variável, função e classes)
        ER.confere(ER.getIDENT(), "1Altura");
        
        //Teste 7, expressão regular: REAL
        ER.confere(ER.getREAL(), "123.908777E+30");
        
        //Teste 8, expressão regular: REAL
        ER.confere(ER.getREAL(), "0.17E-5");
        
        ER.confere(ER.getINTEIRO(), "10");
    }
}