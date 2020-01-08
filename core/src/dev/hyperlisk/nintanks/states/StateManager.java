package dev.hyperlisk.nintanks.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class StateManager {

    private Stack<State> states;

    public StateManager() {
        states = new Stack<State>();

    }

    public State currentState() {

        return states.get(0);

    }

    // Puts the state inside the stack
    public void push(State state) {

        states.push(state);

    }



    // Retrieving the state from the stack
    public void pop(State state) {

        states.pop();

    }

    public void set(State state) {
        states.pop();
        states.push(state);


    }

    public void update(float dt) {
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb) {

        states.peek().render(sb);

    }


}
