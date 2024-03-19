package com.tiduswr;

import java.util.Set;
import static com.tiduswr.Util.*;

public class AFN extends FiniteAutomata{

    public AFN(TransitionTable table, State initialState, State... finalStates){
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
            printState(input, index);
            printErro("Transição não definida!");
            return false;
        }

        var it = destinations.iterator();
        while (it.hasNext()) {
            var nextState = it.next();

            printState(input, index, nextState.state());
            if (processRecursive(input, index + 1, nextState)){
                return true;
            }
            
            if(it.hasNext()) printBacktracking();
        }

        return false;
    }
    
}
