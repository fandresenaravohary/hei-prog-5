package com.snake;

import com.snake.engine.Game;
import com.snake.models.Direction;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Direction (WASD): ");
            String input = scanner.nextLine().toUpperCase();

            switch (input) {
                case "W" -> game.getSnake().setDirection(Direction.UP);
                case "S" -> game.getSnake().setDirection(Direction.DOWN);
                case "A" -> game.getSnake().setDirection(Direction.LEFT);
                case "D" -> game.getSnake().setDirection(Direction.RIGHT);
                default -> System.out.println("Invalid input.");
            }

            game.update();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
