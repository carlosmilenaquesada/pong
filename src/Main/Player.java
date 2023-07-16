package Main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Player extends JPanel implements KeyListener {

    private int playerX = 400;
    public static final int PLAYER_Y = 400;
    public static final int PLAYER_WIDTH = 100;
    public static final int PLAYER_HEIGHT = 20;

    public Player() {
        this.setBackground(Color.WHITE);
        this.setBounds(playerX, PLAYER_Y, PLAYER_WIDTH, PLAYER_HEIGHT);

    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if (e.getKeyCode() == KeyEvent.VK_LEFT && playerX >= 10) {
            System.out.println("left");
            playerX -= 10;
            this.setBounds(playerX, PLAYER_Y, PLAYER_WIDTH, PLAYER_HEIGHT);
            repaint();
        } else {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT && playerX <= 390) {
                System.out.println("right");
                playerX += 10;
                this.setBounds(playerX, PLAYER_Y, PLAYER_WIDTH, PLAYER_HEIGHT);
                repaint();
            }
        }
        System.out.println(playerX);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
