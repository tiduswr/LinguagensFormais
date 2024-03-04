package com.tiduswr;

import java.util.Set;

public class AFD extends FiniteAutomata{

    public AFD(TransitionTable table, State initialState, State... finalStates){
        super(table, initialState, finalStates);
    }

    public boolean process(String input){
        return processRecursive(input, 0, initialState);
    }

    private boolean processRecursive(String input, int index, State currentState) {
        if (index == input.length()) {
            return finalStates.contains(currentState);
        }

        Symbol symbol = new Symbol(input.charAt(index));
        Set<State> destinations = table.delta(currentState, symbol);

        if (destinations.isEmpty()) {
            log(index, input, currentState);
            log("Transição não definida!");
            return false;
        }

        State nextState = destinations.iterator().next();
        log(index, input, nextState);
        
        return processRecursive(input, index + 1, nextState);
    }
    
}
