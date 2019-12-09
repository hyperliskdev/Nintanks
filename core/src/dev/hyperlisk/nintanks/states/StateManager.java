package dev.hyperlisk.nintanks.states;

import java.util.Stack;

public class StateManager {

    private Stack<State> states;

    public StateManager() {
        states = new Stack<State>();

    }

    // Puts the state inside the stack
    public void push(State state) {

        states.push(state);

    }



    // Retrieving the state from the stack
    public void pop(State state) {

        states.pop();

    }


}
