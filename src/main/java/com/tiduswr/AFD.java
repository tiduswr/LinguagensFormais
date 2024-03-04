package com.tiduswr;

import java.util.Set;

public class AFD implements FiniteAutomata{
    
    private TransitionTable table;
    private State initialState;
    private Set<State> finalStates;

    public AFD(TransitionTable table, State initialState, State... finalStates){
        this.table = table;
        this.initialState = initialState;
        this.finalStates = Set.of(finalStates);
    }

    private void log(int i, String input, State currState){
        System.out.print("Symbol: ");
        Util.printCharSublinhado(input, i);
        System.out.println("   State: " + currState.state());
    }

    private void log(String s){
        System.out.println(">> " + s);
    }

    public boolean process(String input){
        State currState = initialState;

        for(int i = 0; i < input.length(); i++){
            Symbol symbol = new Symbol(input.charAt(i));
            Set<State> destinations = table.delta(currState, symbol);

            if(destinations.isEmpty()){
                log(i, input, currState);
                log("Transição não definida!");
                return false;
            }

            currState = destinations.iterator().next();

            log(i, input, currState);
        }

        if(finalStates.contains(currState)){
            log("Palavra aceita pelo Automato!");
            return true;
        }

        log("Palavra rejeitada pelo Automato!");
        return false;
    }
    
}
