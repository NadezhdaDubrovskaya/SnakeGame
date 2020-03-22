package com.rmw.snake;

import java.util.ArrayList;
import java.util.List;

import static com.rmw.snake.Configuration.*;

class GameScreen {
    private final List<List<Tile>> tiles = new ArrayList<>(ROWS);

    private boolean foodPresent;

    GameScreen() {
        init();
    }

    private void init() {
        for (int i = 0; i < ROWS; i++) {
            final List<Tile> row = new ArrayList<>();
            for (int j = 0; j < COLS; j++) {
                final Tile tile = new Tile(i, j);
                row.add(tile);
            }
            tiles.add(row);
        }
    }

    /**
     * Generated food for a snake at a random position if there is no food left
     */
    void generateFood() {
        if (!foodPresent) {
            final int i = Utils.getRandomNumberInRange(0, ROWS - 1);
            final int j = Utils.getRandomNumberInRange(0, COLS - 1);
            getTileAtPosition(i, j).setFood();
            foodPresent = true;
        }
    }

    void reset() {
        foodPresent = false;
    }

    Tile getTileAtPosition(final int i, final int j) {
        if (isOutOfBounds(i, j)) {
            return null;
        }
        return tiles.get(i).get(j);
    }

    private boolean isOutOfBounds(final int i, final int j) {
        return i < 0 || i >= ROWS || j < 0 || j >= COLS;
    }

}
