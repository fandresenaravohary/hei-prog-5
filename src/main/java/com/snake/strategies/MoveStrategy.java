package com.snake.strategies;

import com.snake.models.Direction;
import com.snake.models.Snake;

public interface MoveStrategy {
    void computeNextDirection(Snake snake, Direction currentDirection);
}
