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

    protected void log(int i, String input, State currState){
        System.out.print("Symbol: ");
        Util.printCharSublinhado(input, i);
        System.out.println("   State: " + currState.state());
    }

    protected void log(String s){
        System.out.println(">> " + s);
    }

    public abstract boolean process(String input);
}
