package com.snake.models;

import java.util.LinkedList;
import java.util.List;

public class Snake {
    private final LinkedList<Point> body = new LinkedList<>();
    private Direction direction;

    public Snake(Point start, Direction initialDirection) {
        body.add(start);
        this.direction = initialDirection;
    }

    public void move() {
        Point head = body.getFirst();
        Point next = head.move(direction);
        body.addFirst(next);
        body.removeLast();
    }

    public void grow() {
        Point tail = body.getLast();
        body.addLast(tail);
    }

    public boolean collidesWithSelf() {
        Point head = body.getFirst();
        return body.stream().skip(1).anyMatch(segment -> segment.equals(head));
    }

    public List<Point> getBody() {
        return List.copyOf(body);
    }

    public Point getHead() {
        return body.getFirst();
    }

    public void setDirection(Direction newDirection) {
        if (!isOppositeDirection(newDirection)) {
            this.direction = newDirection;
        }
    }

    private boolean isOppositeDirection(Direction newDirection) {
        return switch (direction) {
            case UP -> newDirection == Direction.DOWN;
            case DOWN -> newDirection == Direction.UP;
            case LEFT -> newDirection == Direction.RIGHT;
            case RIGHT -> newDirection == Direction.LEFT;
        };
    }

    public Direction getDirection() {
        return direction;
    }
}
