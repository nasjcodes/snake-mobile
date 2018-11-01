package nasjcodes.snakemobile.gamecode.game;

import nasjcodes.snakemobile.gamecode.Direction;
import nasjcodes.snakemobile.gamecode.domain.Apple;
import nasjcodes.snakemobile.gamecode.domain.Piece;
import nasjcodes.snakemobile.gamecode.domain.Snake;

import java.util.Random;

public class SnakeGame {

    private int width;
    private int height;
    private boolean continues;
    private Snake snake;
    private Apple apple;

    public SnakeGame(int width, int height) {

        this.width = width;
        this.height = height;
        this.continues = true;
        snake = new Snake(width / 2, height / 2, Direction.DOWN);
        apple = randomApple();


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

    public void setContinues(boolean setting) {
        this.continues = setting;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void performAction() {
        if (!continues) {
            return;
        }

        snake.move();

        if (snake.runsInto((Piece) apple)) {
            this.apple = randomApple();
            snake.grow();
        }

        if (snake.runsIntoItself() || hitsBorder()) {
            continues = false;
        }

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
