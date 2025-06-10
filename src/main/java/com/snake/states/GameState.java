package com.snake.states;

public interface GameState {
    void handleInput();
    void update();
    void render();
}
