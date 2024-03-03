package com.tiduswr;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



public class TransitionTable {

    public record Symbol(
        char symbol
    ){}

    public record State(
        int state
    ){}

    public record Transition(
        State origin,
        Set<State> destination
    ){}

    private Transition newEmptyTransition(State from){
        return new Transition(from, new HashSet<>());
    }

    private final Map<Symbol, Transition> transitions;

    public TransitionTable(){
        transitions = new HashMap<>();
    }

    public void addTransition(Symbol q, State from, State to){
        transitions.computeIfAbsent(q, k -> newEmptyTransition(from))
            .destination()
            .add(to);
    }

    public Set<State> delta(State q, Symbol s){
        return transitions.getOrDefault(s, newEmptyTransition(q))
            .destination();
    }
    
}
