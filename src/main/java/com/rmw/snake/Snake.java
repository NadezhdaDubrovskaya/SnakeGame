package com.rmw.snake;

import java.util.HashSet;
import java.util.LinkedList;

import static com.rmw.snake.Configuration.*;

public class Snake {

    private final GameScreen gameScreen;
    private Tile headTile;
    private Tile tailTile;
    private Direction direction = STARTING_DIRECTION;
    private boolean dead;

    /**
     * Represents occupied tiles of the body
     */
    private HashSet<Tile> occupiedTiles = new HashSet<>();
    /**
     * Is used to help keep track of the last tile.
     */
    private LinkedList<Tile> body = new LinkedList<>();

    /**
     * Is used to count how many bodies are still left to be added
     * Happens after snake eats the food
     */
    private int bodiesToAdd = 0;

    Snake(final GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    void init() {
        headTile = gameScreen.getTileAtPosition(STARTING_SNAKE_POSITION_ROW, STARTING_SNAKE_POSITION_COL);
        occupiedTiles.add(headTile);
        body.add(headTile);
        headTile.setColour(BLACK);
        tailTile = headTile;

        for (int i = 1; i < START_SNAKE_LENGHT; i++) {
            final Tile newTile = gameScreen.getTileAtPosition(tailTile.getRow() + 1, tailTile.getColumn());
            newTile.setColour(BLACK);
            occupiedTiles.add(newTile);
            body.add(newTile);
            tailTile = newTile;
        }
    }

    void changeDirection(final Direction newDirection) {
        direction = newDirection;
    }

    Direction getDirection() {
        return direction;
    }

    void update() {
        if (dead) {
            return;
        }

        final Tile newHead;
        switch (direction) {
            case UP:
                newHead = gameScreen.getTileAtPosition(headTile.getRow() - 1, headTile.getColumn());
                break;
            case DOWN:
                newHead = gameScreen.getTileAtPosition(headTile.getRow() + 1, headTile.getColumn());
                break;
            case LEFT:
                newHead = gameScreen.getTileAtPosition(headTile.getRow(), headTile.getColumn() - 1);
                break;
            case RIGHT:
                newHead = gameScreen.getTileAtPosition(headTile.getRow(), headTile.getColumn() + 1);
                break;
            default:
                newHead = null;
        }

        handleTail();

        // check that newHead isn't a wall nor part of the body
        if (newHead != null && !occupiedTiles.contains(newHead)) {

            newHead.setColour(BLACK);
            headTile = newHead;
            occupiedTiles.add(headTile);
            body.addFirst(headTile);

            if (newHead.isFood()) {
                bodiesToAdd += LENGTH_INCREASE_RATE;
                // It is important to reset food after the snake "ate" it
                gameScreen.reset();
                newHead.reset();
            }
        } else {
            dead = true;
        }
    }

    /**
     * Depending on whether there the snake ate a food recently or not the tail can
     * stay where it is right now or move
     */
    private void handleTail() {
        if (bodiesToAdd > 0) {
            bodiesToAdd--;
        } else {
            tailTile.setColour(MEDIUM_GRAY);
            occupiedTiles.remove(tailTile);
            body.removeLast();
            tailTile = body.getLast(); //assign new tail tile
        }
    }

}
