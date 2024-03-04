package com.tiduswr;

import java.util.Map;
import java.util.Set;

public record Transition(
    Map<State, Set<State>> transition
){}
