package ru.example.democlient.service;

import java.util.Objects;

public class Cell {
    private int x;
    private int y;

    public void setCoordinates(int pointX, int pointY) {
        x = pointX;
        y = pointY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x == cell.x &&
                y == cell.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
