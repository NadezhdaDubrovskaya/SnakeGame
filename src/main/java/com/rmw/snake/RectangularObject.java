package com.rmw.snake;

import processing.core.PApplet;

import static com.rmw.snake.Configuration.*;

class RectangularObject extends ScreenObject {

    private int width = SCALE;
    private int height = SCALE;

    RectangularObject(final PApplet pApplet) {
        super(pApplet);
    }

    RectangularObject(final PApplet pApplet, final Colour colour) {
        super(pApplet);
        setColour(colour);
    }

    @Override
    void show() {
        // black colour means the snake is at that tile so even if it is a food tile
        // it should not be coloured as such
        if (!getColour().equals(BLACK) && getTile().isFood()) {
            setColour(RED);
        }
        getPApplet().fill(getColour().v1, getColour().v2, getColour().v3);
        getPApplet().stroke(0, 0, 0);
        getPApplet().rect(getVectorPosition().x, getVectorPosition().y, width, height);
    }

    @Override
    void updateVectorPosition() {
        if (getTile() != null) {
            final int xCoordinate = getTile().getColumn() * SCALE;
            final int yCoordinate = getTile().getRow() * SCALE;
            setVectorPosition(xCoordinate, yCoordinate);
        }
    }

    int getWidth() {
        return width;
    }

    void setWidth(final int width) {
        this.width = width;
    }

    int getHeight() {
        return height;
    }

    void setHeight(final int height) {
        this.height = height;
    }
}
