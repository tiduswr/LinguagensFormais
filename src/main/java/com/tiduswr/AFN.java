package com.tiduswr;

import java.util.Set;

public class AFN implements FiniteAutomata{
    
    private TransitionTable table;
    private State initialState;
    private Set<State> finalStates;

    public AFN(TransitionTable table, State initialState, State... finalStates){
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
        return process(input, 0, initialState);
    }

    private boolean process(String input, int index, State currentState) {
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

        var it = destinations.iterator();
        while (it.hasNext()) {
            var nextState = it.next();

            log(index, input, nextState);    
            if (process(input, index + 1, nextState)){
                return true;
            }
            
            if(it.hasNext()) log("Backtracking...");
        }
        
        return false;
    }
    
}
