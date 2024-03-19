package com.tiduswr;

import java.util.Set;

public abstract class FiniteAutomata {

    protected TransitionTable table;
    protected State initialState;
    protected Set<State> finalStates;

    public FiniteAutomata(TransitionTable table, State initialState, State... finalStates){
        this.table = table;
        this.initialState = initialState;
        this.finalStates = Set.of(finalStates);
    }

    public abstract boolean process(String input);
    
}
