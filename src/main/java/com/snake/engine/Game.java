package com.snake.engine;

import com.snake.models.FoodFactory;
import com.snake.models.Point;
import com.snake.models.Snake;
import com.snake.models.SnakeBuilder;
import com.snake.states.GameState;
import com.snake.strategies.MoveStrategy;
import com.snake.strategies.UserMoveStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class Game {
    private static final int GRID_SIZE = 10;

    private Snake snake;
    private Point food;
    private final FoodFactory foodFactory;
    private GameState state;
    private final MoveStrategy moveStrategy;
    private boolean gameOver;

    public Game() {
        foodFactory = new FoodFactory(GRID_SIZE);
        snake = new SnakeBuilder()
                .setStart(new Point(GRID_SIZE / 2, GRID_SIZE / 2))
                .setDirection(com.snake.models.Direction.RIGHT)
                .setInitialLength(3)
                .build();
        moveStrategy = new UserMoveStrategy(new Scanner(System.in));
        generateFood();
        gameOver = false;
    }

    public int getGridSize() {
        return GRID_SIZE;
    }

    public void generateFood() {
        food = foodFactory.generateFood(snake.getBody());
    }

    public void update() {
        if (state == null) return;

        state.handleInput();
        state.update();
        state.render();

        if (state instanceof com.snake.states.GameOverState) {
            gameOver = true;
        }
    }

}
