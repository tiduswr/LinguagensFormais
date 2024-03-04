package com.tiduswr;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        afneTeste2();
    }

    public static void afneTeste2(){
        TransitionTable table = new TransitionTable();

        Symbol a = new Symbol('a');
        Symbol b = new Symbol('b');
        Symbol c = new Symbol('c');

        State q0 = new State(0);
        State q1 = new State(1);
        State q2 = new State(2);
        State q3 = new State(3);

        table.addTransition(a, q0, q0);
        table.addTransition(Symbol.VAZIO, q0, q1);

        table.addTransition(b, q1, q2);
        table.addTransition(Symbol.VAZIO, q1, q3);

        table.addTransition(b, q2, q1);

        table.addTransition(c, q3, q3);

        FiniteAutomata afne = new AFNe(table, q0, q3);

        List<String> testes = List.of("a", "b", "c", "abbc", "aabbcc", "abc");

        for(int i = 0; i < testes.size(); i++){
            System.out.printf("\nTeste %d\n", i);
            if(afne.process(testes.get(i))){
                System.out.println(">> Palavra aceita!");
            }else{
                System.out.println(">> Palavra rejeitada!");
            }
        }
    }

    public static void afneTeste(){
        TransitionTable table = new TransitionTable();

        Symbol a = new Symbol('a');
        Symbol b = new Symbol('b');

        State q0 = new State(0);
        State q1 = new State(1);

        table.addTransition(a, q0, q0);
        table.addTransition(Symbol.VAZIO, q0, q1);
        table.addTransition(b, q1, q1);

        FiniteAutomata afne = new AFNe(table, q0, q1);

        List<String> testes = List.of("aaabbb", "abbbb", "bba");

        for(int i = 0; i < testes.size(); i++){
            System.out.printf("\nTeste %d\n", i);
            if(afne.process(testes.get(i))){
                System.out.println(">> Palavra aceita!");
            }else{
                System.out.println(">> Palavra rejeitada!");
            }
        }
    }

    public static void afnTeste(){
        TransitionTable table = new TransitionTable();

        Symbol a = new Symbol('a');
        Symbol b = new Symbol('b');

        State q0 = new State(0);
        State q1 = new State(1);
        State q2 = new State(2);
        State q3 = new State(3);

        table.addTransition(a, q0, q0);
        table.addTransition(a, q0, q1);
        table.addTransition(b, q0, q0);
        table.addTransition(b, q0, q2);

        table.addTransition(a, q1, q3);
        table.addTransition(b, q2, q3);

        table.addTransition(a, q3, q3);
        table.addTransition(b, q3, q3);

        FiniteAutomata afn = new AFN(table, q0, q3);

        List<String> testes = List.of("abababa", "ababaa", "abaa", "abb");

        for(int i = 0; i < testes.size(); i++){
            System.out.printf("\nTeste %d\n", i);
            if(afn.process(testes.get(i))){
                System.out.println(">> Palavra aceita!");
            }else{
                System.out.println(">> Palavra rejeitada!");
            }
        }

    }

    public static void afdTeste(){
        TransitionTable table = new TransitionTable();

        State q0 = new State(0);
        State q1 = new State(1);
        State q2 = new State(2);
        State q3 = new State(3);
        Symbol a = new Symbol('a');
        Symbol b = new Symbol('b');

        table.addTransition(a, q0, q1);
        table.addTransition(b, q0, q2);
        table.addTransition(a, q1, q3);
        table.addTransition(b, q1, q2);
        table.addTransition(a, q2, q1);
        table.addTransition(b, q2, q3);
        table.addTransition(a, q3, q3);
        table.addTransition(b, q3, q3);

        FiniteAutomata afd = new AFD(table, q0, q3);

        List<String> testes = List.of("abababa", "ababaa", "abaa", "abb");

        for(int i = 0; i < testes.size(); i++){
            System.out.printf("\nTeste %d\n", i);
            if(afd.process(testes.get(i))){
                System.out.println(">> Palavra aceita!");
            }else{
                System.out.println(">> Palavra rejeitada!");
            }
        }

    }
}