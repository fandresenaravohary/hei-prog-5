package com.snake.states;

import com.snake.engine.Game;

import java.util.Scanner;

public class MenuState implements GameState {
    private final Game game;
    private final Scanner scanner;

    public MenuState(Game game) {
        this.game = game;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void handleInput() {
        System.out.println("Bienvenue au Snake Game");
        System.out.println("Appuyez sur ENTER pour commencer...");
        scanner.nextLine();
        game.setState(new RunningState(game, scanner));
    }

    @Override
    public void update() { }

    @Override
    public void render() { }
}
