package gamecode.gui;

import gamecode.Direction;
import gamecode.domain.Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
    private Snake snake;

    public KeyboardListener(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_UP && snake.getDirection() != Direction.DOWN) {
            snake.setDirection(Direction.UP);
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN && snake.getDirection() != Direction.UP) {
            snake.setDirection(Direction.DOWN);
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT && snake.getDirection() != Direction.RIGHT) {
            snake.setDirection(Direction.LEFT);
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT && snake.getDirection() != Direction.LEFT) {
            snake.setDirection(Direction.RIGHT);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
