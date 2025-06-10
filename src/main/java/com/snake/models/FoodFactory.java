package com.snake.models;

import java.util.List;
import java.util.Random;

public class FoodFactory {
    private final int gridSize;
    private final Random random = new Random();

    public FoodFactory(int gridSize) {
        this.gridSize = gridSize;
    }

    public Point generateFood(List<Point> snakeBody) {
        Point food;
        do {
            food = new Point(random.nextInt(gridSize), random.nextInt(gridSize));
        } while (snakeBody.contains(food));
        return food;
    }
}
