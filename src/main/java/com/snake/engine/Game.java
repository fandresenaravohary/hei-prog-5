package com.snake.engine;

import com.snake.models.Direction;
import com.snake.models.Point;
import com.snake.models.Snake;

public class Game {
    private static final int SIZE = 10;
    private final Snake snake;

    public Game() {
        this.snake = new Snake(new Point(SIZE / 2, SIZE / 2), Direction.RIGHT);
    }

    public void update() {
        snake.move();
        render();
    }

    private void render() {
        char[][] grid = new char[SIZE][SIZE];

        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                grid[y][x] = '.';
            }
        }

        for (Point p : snake.getBody()) {
            if (isInside(p)) {
                grid[p.y()][p.x()] = '*';
            }
        }

        for (char[] row : grid) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

        System.out.println("-----");
    }

    private boolean isInside(Point p) {
        return p.x() >= 0 && p.x() < SIZE && p.y() >= 0 && p.y() < SIZE;
    }

    public Snake getSnake() {
        return snake;
    }
}