package com.tiduswr;

import java.util.HashSet;
import java.util.Set;

public class AFNe extends FiniteAutomata{

    public AFNe(TransitionTable table, State initialState, State... finalStates){
        super(table, initialState, finalStates);
    }
    
    public boolean process(String input){
        return process(input, 0, initialState, table.fechoEpsilon(initialState));
    }

    private boolean process(String input, int index, State currentState, Set<State> currFechoEpsilon) {
        if (index == input.length()) {
            for (State state : currFechoEpsilon) {
                if (finalStates.contains(state)) {
                    return true;
                }
            }
            return false;
        }

        Symbol symbol = new Symbol(input.charAt(index));
        Set<State> destinations = new HashSet<>();
        for(State state : currFechoEpsilon){
            Set<State> transitions = table.delta(state, symbol);
            if(transitions != null){
                destinations.addAll(transitions);
            }
        }

        if (destinations.isEmpty()) {
            log(index, input, currentState);
            log("Transição não definida!");
            return false;
        }

        var it = destinations.iterator();
        while (it.hasNext()) {
            var nextState = it.next();

            log(index, input, nextState);    
            if (process(input, index + 1, nextState, table.fechoEpsilon(nextState))){
                return true;
            }
            
            if(it.hasNext()) log("Backtracking...");
        }

        return false;
    }
}
