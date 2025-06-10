package com.snake.models;

public record Point(int x, int y) {
    public Point move(Direction direction) {
        return switch (direction) {
            case UP -> new Point(x, y - 1);
            case DOWN -> new Point(x, y + 1);
            case LEFT -> new Point(x - 1, y);
            case RIGHT -> new Point(x + 1, y);
        };
    }
    public boolean isInsideGrid(int size) {
        return x >= 0 && y >= 0 && x < size && y < size;
    }
}
