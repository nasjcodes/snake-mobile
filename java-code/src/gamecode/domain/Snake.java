package gamecode.domain;

import gamecode.Direction;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<Piece> pieces;
    private Direction direction;
    private boolean moveCall;
    private boolean growCall;

    public Snake(int originalX, int originalY, Direction originalDirection) {
        pieces = new ArrayList<Piece>();
        pieces.add(new Piece(originalX, originalY));
        direction = originalDirection;
        moveCall = false;
        growCall = false;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction dir) {
        this.direction = dir;
    }

    public int getLength() {
        return pieces.size();
    }

    public List<Piece> getPieces() {
        return this.pieces;
    }

    public void move() {
        int headX = getHeadPiece().getX();
        int headY = getHeadPiece().getY();

        if (direction == Direction.UP) {
            pieces.add(new Piece(headX, headY - 1));
        }

        if (direction == Direction.DOWN) {
            pieces.add(new Piece(headX, headY + 1));
        }

        if (direction == Direction.LEFT) {
            pieces.add(new Piece(headX - 1, headY));
        }

        if (direction == Direction.RIGHT) {
            pieces.add(new Piece(headX + 1, headY));
        }

        if (pieces.size() > 3 && !growCall) {
            pieces.remove(0);
        }

        growCall = false;
    }

    public void grow() {
        growCall = true;
    }


    public boolean runsInto(Piece piece) {
        for (Piece curPiece : pieces) {
            if (curPiece.runsInto(piece)) {
                return true;
            }
        }

        return false;
    }

    public boolean runsIntoItself() {
        List<Piece> minusHead = new ArrayList<Piece>(pieces);
        minusHead.remove(minusHead.size() - 1);

        return minusHead.contains(getHeadPiece());
    }

    public Piece getHeadPiece() {
        return pieces.get(pieces.size() - 1);
    }

}
