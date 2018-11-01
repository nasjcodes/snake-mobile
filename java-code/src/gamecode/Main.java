package gamecode;

import gamecode.game.SnakeGame;
import gamecode.gui.UserInterface;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // write test code here
        SnakeGame game = new SnakeGame(20, 20);

        UserInterface ui = new UserInterface(game, 20);
        SwingUtilities.invokeLater(ui);

        while (ui.getUpdatable() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("The drawing board hasn't been created yet.");
            }
        }

        game.setUpdatable(ui.getUpdatable());
        game.start();

    }
}
