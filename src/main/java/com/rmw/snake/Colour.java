package com.rmw.snake;

import java.util.Objects;

/**
 * Represents RGB colour that is used by Processing
 */
class Colour {

    int v1;
    int v2;
    int v3;

    Colour(final int v1, final int v2, final int v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    void changeColour(final int v1, final int v2, final int v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    void changeColour(final Colour colour) {
        v1 = colour.v1;
        v2 = colour.v2;
        v3 = colour.v3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colour colour = (Colour) o;
        return v1 == colour.v1 &&
                v2 == colour.v2 &&
                v3 == colour.v3;
    }

    @Override
    public int hashCode() {
        return Objects.hash(v1, v2, v3);
    }
}
