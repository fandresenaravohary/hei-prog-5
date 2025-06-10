package com.snake.states;

import com.snake.engine.Game;

public record GameOverState(Game game) implements GameState {

    @Override
    public void handleInput() {
    }

    @Override
    public void update() {
    }

    @Override
    public void render() {
        System.out.println("Game Over !");
    }
}
