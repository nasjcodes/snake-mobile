package gamecode.gui;

import gamecode.game.SnakeGame;

import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable {

    private JFrame frame;
    private SnakeGame game;
    private int sideLength;
    private DrawingBoard drawingBoard;

    public UserInterface(SnakeGame game, int sideLength) {
        this.game = game;
        this.sideLength = sideLength;
    }

    @Override
    public void run() {
        frame = new JFrame("Snake Game");
        int width = (game.getWidth() + 1) * sideLength;
        int height = (game.getHeight() + 2) * sideLength;

        frame.setPreferredSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void createComponents(Container container) {
        // Create drawing board first which then is added into container-object.
        // After this, create keyboard listener which is added into frame-object
        drawingBoard = new DrawingBoard(game, sideLength);
        container.add(drawingBoard);

        KeyboardListener listener = new KeyboardListener(game.getSnake());
        frame.addKeyListener(listener);
    }

    public Updatable getUpdatable() {
        return this.drawingBoard;
    }

    public JFrame getFrame() {
        return frame;
    }
}
