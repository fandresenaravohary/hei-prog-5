package com.snake.models;

public class SnakeBuilder {
    private Point start = new Point(5, 5);
    private Direction direction = Direction.RIGHT;
    private int initialLength = 3;

    public SnakeBuilder setStart(Point start) {
        this.start = start;
        return this;
    }

    public SnakeBuilder setDirection(Direction direction) {
        this.direction = direction;
        return this;
    }

    public SnakeBuilder setInitialLength(int length) {
        this.initialLength = length;
        return this;
    }

    public Snake build() {
        Snake snake = new Snake(start, direction);
        for (int i = 1; i < initialLength; i++) {
            snake.grow();
        }
        return snake;
    }
}
