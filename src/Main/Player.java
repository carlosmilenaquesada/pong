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
   
    
    //CONSTRUCTORES
    //---------------------------------------------------------------------------
    //Por defecto
    public Player() {        
        this.setBounds(201, PLAYER_Y_POSITION, PLAYER_WIDTH, PLAYER_HEIGHT);
    }
    
    //GETTERS Y SETTERS
    //--------------------------------------------------------------------------
    //Getters
    
    //Setters
    
        

    //MÉTODOS
    //--------------------------------------------------------------------------
    //De instancia
    public void playerInput(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT && this.getX() > Player.PLAYER_STEP) {
            this.setBounds(this.getX() - Player.PLAYER_STEP, Player.PLAYER_Y_POSITION, Player.PLAYER_WIDTH, Player.PLAYER_HEIGHT);
            repaint();
        } else {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT && this.getX() <= 391) {
                this.setBounds(this.getX() + Player.PLAYER_STEP, Player.PLAYER_Y_POSITION, Player.PLAYER_WIDTH, Player.PLAYER_HEIGHT);
                repaint();
            }
        }
        
        
    }
}
