package com.rmw.snake;


class Configuration {


    static final int WIDTH = 1200;
    static final int HEIGHT = 800;

    static final int COLS = 60;
    static final int ROWS = 40;

    /**
     * Sets the correlation between coordinates (pixels) and the array of tiles.
     * For example, if the scale is set to 50 then it means each tile will be a square of 50 "pixels".
     * Meaning that a tile array 10x15 in size will require a screen of 500x750 px
     */
    static final int SCALE = 20;


    static final int START_SNAKE_LENGHT = 20;
    static final int STARTING_SNAKE_POSITION_COL = 30;
    static final int STARTING_SNAKE_POSITION_ROW = 20;
    static final Direction STARTING_DIRECTION = Direction.UP;

    // Colors
    static final Colour BLACK = new Colour(0, 0, 0);
    static final Colour WHITE = new Colour(255, 255, 255);
    static final Colour RED = new Colour(215, 50, 10);
    static final Colour BLUE = new Colour(10, 50, 215);
    static final Colour LIGHT_GREEN = new Colour(157, 229, 84);
    static final Colour MEDIUM_GRAY = new Colour(132, 132, 132);
    static final Colour LIGHT_BLUE = new Colour(155, 215, 245);

    private Configuration() {
    }

}
