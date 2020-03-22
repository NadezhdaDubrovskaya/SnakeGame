package com.rmw.snake;

import processing.core.PApplet;
import processing.core.PVector;

import static com.rmw.snake.Configuration.BLACK;

abstract class ScreenObject {

    private final PApplet pApplet;
    private final PVector vectorPosition = new PVector();
    private final Colour colour;
    private Tile tile;

    ScreenObject(final PApplet pApplet) {
        this.pApplet = pApplet;
        colour = new Colour(BLACK.v1, BLACK.v2, BLACK.v3);
    }

    Tile getTile() {
        return tile;
    }

    void setTile(final Tile tile) {
        this.tile = tile;
        updateVectorPosition();
    }

    PApplet getPApplet() {
        return pApplet;
    }

    PVector getVectorPosition() {
        return vectorPosition;
    }

    void setVectorPosition(final float x, final float y) {
        vectorPosition.x = x;
        vectorPosition.y = y;
    }

    Colour getColour() {
        return colour;
    }

    void setColour(final Colour colour) {
        this.colour.v1 = colour.v1;
        this.colour.v2 = colour.v2;
        this.colour.v3 = colour.v3;
    }

    void reset() {
        //do nothing by default
    }

    void update() {
        show();
    }

    abstract void show();

    abstract void updateVectorPosition();

}
