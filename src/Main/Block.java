package Main;

import java.awt.*;
import javax.swing.*;

public class Block extends JPanel{
    //PARÁMETROS
    //--------------------------------------------------------------------------
    //Estáticos
    public static final int BLOCK_WIDTH = 50;
    public static final int BLOCK_HEIGHT = 30;
    
    //De instancia
    
    
    //CONSTRUCTORES
    //--------------------------------------------------------------------------
    //Por parámetros
    public Block(int blockXPosition, int blockYPosition, Color color){        
        this.setBackground(color);
        this.setBounds(blockXPosition, blockYPosition, BLOCK_WIDTH, BLOCK_HEIGHT);
    }
    
    //GETTERS Y SETTERS
    //--------------------------------------------------------------------------
    //Getters
    
    
    //Setters
    
    
    //MÉTODOS
    //--------------------------------------------------------------------------
}
