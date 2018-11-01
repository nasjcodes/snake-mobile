package gamecode.domain;

import java.util.Objects;

public class Piece {
    private int x;
    private int y;

    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean runsInto(Piece piece) {
        return this.x == piece.getX() && this.y == piece.getY();
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return this.x == piece.getX() && this.y == piece.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
