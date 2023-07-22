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
    private int blockXPosition;
    private int blockYPosition;
    private Color color;
    
    //CONSTRUCTORES
    //--------------------------------------------------------------------------
    //Por parámetros
    public Block(int blockXPosition, int blockYPosition, Color color){
        this.blockXPosition = blockXPosition;
        this.blockYPosition = blockYPosition;
        this.color = color;
        this.setBackground(color);
        this.setBounds(blockXPosition, blockYPosition, 50, 30);
    }
    
    //GETTERS Y SETTERS
    //--------------------------------------------------------------------------
    //Getters
    public int getBlockXPosition(){
        return this.blockXPosition;
    }
    
    public int getBlockYPosition(){
        return this.blockYPosition;
    }
    
    public Color getColor(){
        return this.color;
    }
    
    //Setters
    public void setBlockXPosition(int blockXPosition){
        this.blockXPosition = blockXPosition;
    }
    
    public void setBlockYPosition(int blockYPosition){
        this.blockYPosition = blockYPosition;
    }
    
    public void setColor(Color color){
        this.color = color;
    }
    
    //MÉTODOS
    //--------------------------------------------------------------------------
}
