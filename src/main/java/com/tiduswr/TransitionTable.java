package com.tiduswr;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TransitionTable {

    private final Map<Symbol, Transition> transitions;

    public TransitionTable(){
        transitions = new HashMap<>();
    }

    public void addTransition(Symbol q, State from, State to){
        transitions.computeIfAbsent(q, k -> new Transition(new HashMap<>()))
            .transition()
            .computeIfAbsent(from, j -> new HashSet<>())
            .add(to);
    }

    public Set<State> delta(State q, Symbol s){
        return transitions.getOrDefault(s, new Transition(new HashMap<>()))
            .transition()
            .getOrDefault(q, new HashSet<>());
    }
    
}
