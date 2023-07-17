package Main;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Player extends JPanel {

    private int playerX = 200;
    public static final int PLAYER_Y = 400;
    public static final int PLAYER_WIDTH = 100;
    public static final int PLAYER_HEIGHT = 20;

    public Player() {
        this.setBackground(Color.WHITE);
        this.setBounds(playerX, PLAYER_Y, PLAYER_WIDTH, PLAYER_HEIGHT);

    }
    
    public int getPlayerX(){
        return this.playerX;
    }

    public void movePlayer(KeyEvent e) {
        System.out.println("movimiento");

        if (e.getKeyCode() == KeyEvent.VK_LEFT && playerX >= 10) {

            playerX -= 10;
            this.setBounds(playerX, PLAYER_Y, PLAYER_WIDTH, PLAYER_HEIGHT);
            repaint();
        } else {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT && playerX <= 390) {

                playerX += 10;
                this.setBounds(playerX, PLAYER_Y, PLAYER_WIDTH, PLAYER_HEIGHT);
                repaint();
            }
        }

    }

}
