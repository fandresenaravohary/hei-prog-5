package com.snake.states;

import com.snake.engine.Game;
import com.snake.models.Point;
import com.snake.models.Snake;
import com.snake.strategies.MoveStrategy;

import java.util.List;
import java.util.Scanner;

public class RunningState implements GameState {
    private final Game game;
    private final MoveStrategy moveStrategy;

    public RunningState(Game game, Scanner scanner) {
        this.game = game;
        this.moveStrategy = game.getMoveStrategy();
        com.snake.strategies.UserMoveStrategy userMoveStrategy = (com.snake.strategies.UserMoveStrategy) this.moveStrategy;// Already linked with scanner in constructor
    }

    @Override
    public void handleInput() {
        moveStrategy.computeNextDirection(game.getSnake(), game.getSnake().getDirection());
    }

    @Override
    public void update() {
        Snake snake = game.getSnake();
        snake.move();

        Point head = snake.getHead();

        if (!head.isInsideGrid(game.getGridSize()) || snake.collidesWithSelf()) {
            game.setState(new GameOverState(game));
            return;
        }

        if (head.equals(game.getFood())) {
            snake.grow();
            game.generateFood();
        }
    }

    @Override
    public void render() {
        char[][] grid = new char[game.getGridSize()][game.getGridSize()];

        for (int y = 0; y < game.getGridSize(); y++) {
            for (int x = 0; x < game.getGridSize(); x++) {
                grid[y][x] = '.';
            }
        }

        List<Point> body = game.getSnake().getBody();
        for (Point p : body) {
            if (p.isInsideGrid(game.getGridSize())) {
                grid[p.y()][p.x()] = '*';
            }
        }

        Point food = game.getFood();
        if (food.isInsideGrid(game.getGridSize())) {
            grid[food.y()][food.x()] = '@';
        }

        for (char[] row : grid) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println("-----");
    }
}
