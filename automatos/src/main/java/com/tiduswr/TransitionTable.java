package com.tiduswr;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TransitionTable {

    protected final Map<Symbol, Map<State, Set<State>>> transitions;

    public TransitionTable(){
        transitions = new HashMap<>();
    }

    public void addTransition(Symbol s, State from, State to){
        transitions.computeIfAbsent(s, k -> new HashMap<>())
            .computeIfAbsent(from, j -> new HashSet<>())
            .add(to);
    }

    public Set<State> delta(State q, Symbol s){
        return transitions.getOrDefault(s, new HashMap<>())
            .getOrDefault(q, new HashSet<>());
    }

    public Set<State> fechoEpsilon(State s){
        Set<State> fechoEpsilon = new HashSet<>();
        fechoEpsilon(s, fechoEpsilon, new HashSet<>());
        return fechoEpsilon;
    }

    private void fechoEpsilon(State state, Set<State> result, Set<State> visited){
        visited.add(state);
        result.add(state);

        if(transitions.containsKey(Symbol.VAZIO)){
            var epsilonTransitions = transitions.get(Symbol.VAZIO);

            if(epsilonTransitions.containsKey(state)){
                for(State nextState : epsilonTransitions.get(state)){
                    if(!visited.contains(nextState)){
                        fechoEpsilon(nextState, result, visited);
                    }
                }
            }
        }
    }

}
