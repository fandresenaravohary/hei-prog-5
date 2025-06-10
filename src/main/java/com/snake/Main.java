package com.snake;

import com.snake.engine.Game;
import com.snake.states.MenuState;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.setState(new MenuState(game));

        while (!game.isGameOver()) {
            game.update();
        }
    }
}
