package gamecode.gui;

import gamecode.domain.Piece;
import gamecode.game.SnakeGame;

import javax.swing.*;
import java.awt.*;

public class DrawingBoard extends JPanel implements Updatable {
    private SnakeGame snakeGame;
    private int pieceLength;
    private int padding;
    private int pieceSize;


    public DrawingBoard(SnakeGame snakeGame, int pieceLength) {
        this.snakeGame = snakeGame;
        this.pieceLength = pieceLength;
        this.padding = 2;
        this.pieceSize = pieceLength - 2 * this.padding;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        for (Piece piece : snakeGame.getSnake().getPieces()) {
            g.fill3DRect(piece.getX() * pieceLength + padding, piece.getY() * pieceLength + padding, pieceSize, pieceSize, true);
        }

        g.setColor(Color.RED);
        g.fillOval(snakeGame.getApple().getX() * pieceLength + padding, snakeGame.getApple().getY() * pieceLength + padding, pieceSize, pieceSize);
    }

    @Override
    public void update() {
        super.repaint();
    }
}
