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

    public List<Point> getBody() {
        return List.copyOf(body);
    }

    public void setDirection(Direction newDirection) {
        this.direction = newDirection;
    }

    public Point getHead() {
        return body.getFirst();
    }
}
