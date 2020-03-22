package com.rmw.snake;


import java.util.Objects;

class Tile {

    private final Integer row;
    private final Integer column;
    private RectangularObject rectangularObject;
    private boolean food;

    Tile(final Integer row, final Integer column) {
        this.row = row;
        this.column = column;
    }

    Integer getRow() {
        return row;
    }

    Integer getColumn() {
        return column;
    }

    void setFood() {
        food = true;
    }

    boolean isFood() {
        return food;
    }

    void reset() {
        food = false;
    }

    void setColour(final Colour colour) {
        if (rectangularObject != null) {
            rectangularObject.setColour(colour);
        }
    }

    public RectangularObject getRectangularObject() {
        return rectangularObject;
    }

    public void setRectangularObject(RectangularObject rectangularObject) {
        this.rectangularObject = rectangularObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return Objects.equals(row, tile.row) &&
                Objects.equals(column, tile.column);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
