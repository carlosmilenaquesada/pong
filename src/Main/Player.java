package Main;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Player extends JPanel {
    //ATRIBUTOS
    //--------------------------------------------------------------------------
    //Estáticos
    public static final int PLAYER_Y_POSITION = 400;
    public static final int PLAYER_WIDTH = 100;
    public static final int PLAYER_HEIGHT = 20;
    public static final int PLAYER_STEP = 10;
    //De instancia
    private int playerXPosition;
    private int playerXMaxBound;
    
    //CONSTRUCTORES
    //---------------------------------------------------------------------------
    //Por defecto
    public Player(int playerXPosition, int playerXMaxBound) {
        this.playerXPosition = playerXPosition;
        this.playerXMaxBound = playerXMaxBound;
        this.setBackground(Color.WHITE);
        this.setBounds(this.playerXPosition, PLAYER_Y_POSITION, PLAYER_WIDTH, PLAYER_HEIGHT);
    }
    
    //GETTERS Y SETTERS
    //--------------------------------------------------------------------------
    //Getters
    public int getPlayerXPosition(){
        return this.playerXPosition;
    }
    
    //Setters
    public void setPlayerXPosition(int playerXPosition){
        this.playerXPosition = playerXPosition;
    }

    //MÉTODOS
    //--------------------------------------------------------------------------
    //De instancia
    public void playerInput(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT && this.playerXPosition >= Player.PLAYER_STEP) {
            this.playerXPosition -= Player.PLAYER_STEP;
            this.setBounds(this.playerXPosition, Player.PLAYER_Y_POSITION, Player.PLAYER_WIDTH, Player.PLAYER_HEIGHT);
            repaint();
        } else {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT && this.playerXPosition <= this.playerXMaxBound - (Player.PLAYER_WIDTH + Player.PLAYER_STEP)) {
                this.playerXPosition += Player.PLAYER_STEP;
                this.setBounds(this.playerXPosition, Player.PLAYER_Y_POSITION, Player.PLAYER_WIDTH, Player.PLAYER_HEIGHT);
                repaint();
            }
        }
    }
}
