package com.tiduswr;

public class Util {

    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final boolean TEXTO_DECLARATIVO = true;
    private static boolean lastWasError = false;

    private static String formatGreen(String s){
        return ANSI_GREEN + s + ANSI_RESET;
    }

    private static String formatBlue(String s){
        return ANSI_BLUE + s + ANSI_RESET;
    }

    private static String formatRed(String s){
        return ANSI_RED + s + ANSI_RESET;
    }

    private static String formatYellow(String s){
        return ANSI_YELLOW + s + ANSI_RESET;
    }

    public static void printState(String input, int index, int state){
        printState(input, index, (
                TEXTO_DECLARATIVO ? 
                    " '" + formatYellow(String.valueOf(state)) + "' 🏃\n" 
                :   String.format(" %d\n", state)
            )
        );
    }

    public static void printState(String input, int index){
        printState(input, index, (
                TEXTO_DECLARATIVO ? 
                    "... pra onde mesmo 🤔? \n"
                :   formatRed(" ??\n")
            )
        );
    }

    public static void printState(String input, int index, String append){
        var symbol = String.valueOf(input.charAt(index));
        var w = String.format("%s" + formatGreen("<<%s>>") + "%s", input.substring(0, index), 
            symbol, input.substring(index + 1));
        
        if(TEXTO_DECLARATIVO){
            System.out.printf(formatBlue("Desc: ") + "Li o simbolo " + w   
                + " vou tentar ir para o estado" + append);
        }else{
            System.out.printf(formatBlue("Symbol: ") + w + "   " + formatBlue("State:") + append);
        } 
    }

    public static void printPalavraAceita(){
        System.out.println(!TEXTO_DECLARATIVO ? ">> Palavra " + formatGreen("aceita") + "!" 
            : ">> " + formatGreen("Consegui 😁") + ", essa palavra é aceita pela Linguagem");

        lastWasError = false;
    }

    public static void printPalavraRejeitada(){
        System.out.println(!TEXTO_DECLARATIVO ? ">> Palavra " + formatRed("rejeitada") + "!" 
            : ">> " + formatRed("Não consegui") + ", essa palavra não é aceita pela Linguagem 😞");
        
        lastWasError = false;
    }

    public static void printErro(String err){
        lastWasError = true;
        System.out.println(">> " + (TEXTO_DECLARATIVO ? 
            formatRed("Não consegui realizar a transição anterior 😭") +
            "\n>> " + formatRed("Fiquei preso no mesmo estado 😞🔓")
            : formatRed("Erro: " + err + "!")));
    }

    public static void printBacktracking(){
        if(lastWasError && TEXTO_DECLARATIVO){
            lastWasError = false;
            System.out.println(">> " + formatYellow("Vou tentar outra estratégia... 🔎🗺️"));
        }else{
            System.out.println(">> " + (
                TEXTO_DECLARATIVO ? 
                    formatYellow("Acabou a palavra? 🤨") + "\n>> " + 
                        formatYellow("Mas eu não cheguei no final 😫") 
                        + "\n>> " + formatYellow("Vou tentar outra estratégia... 🔎🗺️")
                : 
                    formatYellow("Backtracking...")
                )
            );
        }
    }

}
