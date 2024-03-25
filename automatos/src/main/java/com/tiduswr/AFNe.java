package com.tiduswr;

import java.util.HashSet;
import java.util.Set;
import static com.tiduswr.Util.*;

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
            if(!transitions.isEmpty()){
                destinations.addAll(transitions);
            }
        }

        if (destinations.isEmpty()) {
            printState(input, index);
            printBacktracking();
            return false;
        }

        var it = destinations.iterator();
        while (it.hasNext()) {
            var nextState = it.next();

            printState(input, index, nextState.state());
            if (process(input, index + 1, nextState, table.fechoEpsilon(nextState))){
                return true;
            }
            
            if(it.hasNext()) printBacktracking();
        }

        return false;
    }
}
