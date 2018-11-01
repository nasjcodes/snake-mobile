package gamecode.game;

import gamecode.Direction;
import gamecode.domain.Apple;
import gamecode.domain.Piece;
import gamecode.domain.Snake;
import gamecode.gui.Updatable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SnakeGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Snake snake;
    private Apple apple;

    public SnakeGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;
        snake = new Snake(width / 2, height / 2, Direction.DOWN);
        apple = randomApple();

        addActionListener(this);
        setInitialDelay(100);

    }

    public Apple randomApple() {

        Apple randomApple;
        do {
            randomApple = new Apple(new Random().nextInt(width), new Random().nextInt(height));
        } while (snake.runsInto(randomApple));

        return randomApple;
    }

    public Snake getSnake() {
        return this.snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Apple getApple() {
        return this.apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
//        if (!continues) {
//            return;
//        }

        snake.move();

        if (snake.runsInto((Piece) apple)) {
            this.apple = randomApple();
            snake.grow();
        }

        if (snake.runsIntoItself() || hitsBorder()) {
            continues = false;
        }

        if(!continues) {
            return;
        }
        updatable.update();

        setDelay(1000 / snake.getLength());
    }

    public boolean hitsBorder() {
        for (Piece piece : snake.getPieces()) {
            if (piece.getX() < 0 || piece.getY() < 0 || piece.getX() >= this.width || piece.getY() >= this.height) {
                return true;
            }
        }

        return false;
    }

}
