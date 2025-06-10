package com.snake.strategies;

import com.snake.models.Direction;
import com.snake.models.Snake;

import java.util.Scanner;

public class UserMoveStrategy implements MoveStrategy {
    private final Scanner scanner;

    public UserMoveStrategy(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void computeNextDirection(Snake snake, Direction currentDirection) {
        System.out.print("Direction (WASD): ");
        String input = scanner.nextLine().trim().toUpperCase();
        Direction newDirection = switch (input) {
            case "W" -> Direction.UP;
            case "S" -> Direction.DOWN;
            case "A" -> Direction.LEFT;
            case "D" -> Direction.RIGHT;
            default -> currentDirection;
        };
        snake.setDirection(newDirection);
    }
}
