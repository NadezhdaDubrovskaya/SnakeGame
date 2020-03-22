package com.rmw.snake;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

import static com.rmw.snake.Configuration.*;

public class Main extends PApplet {

    private final List<ScreenObject> mapTiles = new ArrayList<>(); //used for rendering
    private final GameScreen gameScreen = new GameScreen();
    private final Snake snake = new Snake(gameScreen);

    /**
     * Is used to slow down the speed.
     */
    private int updatesPassed = 0;
    /**
     * Will decrease as the game proceeds
     */
    private int updateHoldup = 10;

    public static void main(final String[] args) {
        PApplet.main("com.rmw.snake.Main", args);
    }

    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        drawGameScreen();
        snake.init();
    }

    private void drawGameScreen() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                final Tile requiredTire = gameScreen.getTileAtPosition(i, j);
                final Colour colour = new Colour(MEDIUM_GRAY.v1, MEDIUM_GRAY.v2, MEDIUM_GRAY.v3);
                // generate screenObject to represent the tile on the screen and linked it to the tile
                final RectangularObject rectangle = new RectangularObject(this, colour);
                rectangle.setTile(requiredTire);
                requiredTire.setRectangularObject(rectangle);
                mapTiles.add(rectangle);
            }
        }
    }

    @Override
    public void draw() {
        updatesPassed++;
        gameScreen.generateFood();
        mapTiles.forEach(ScreenObject::update);
        if (updatesPassed >= updateHoldup) {
            snake.update();
            updatesPassed = 0;
        }
    }

    @Override
    public void keyPressed() {
        switch (keyCode) {
            case LEFT:
                if (snake.getDirection() != Direction.RIGHT) {
                    snake.changeDirection(Direction.LEFT);
                }
                break;
            case RIGHT:
                if (snake.getDirection() != Direction.LEFT) {
                    snake.changeDirection(Direction.RIGHT);
                }
                break;
            case UP:
                if (snake.getDirection() != Direction.DOWN) {
                    snake.changeDirection(Direction.UP);
                }
                break;
            case DOWN:
                if (snake.getDirection() != Direction.UP) {
                    snake.changeDirection(Direction.DOWN);
                }
                break;
            default:
        }

    }

    @Override
    public void mousePressed() {
    }

}

