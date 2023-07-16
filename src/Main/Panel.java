package Main;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Panel extends JPanel{

    private Player player;
    private Ball ball;
    private ArrayList<Block> blocks;

    public Panel() {
        initializer();

    }
    
    private void initializer(){
        this.player = new Player();
        this.ball = new Ball();
        this.blocks = blockDispenser();
        
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(Color.BLACK);
    }
    
    private ArrayList<Block> blockDispenser(){
        ArrayList<Block> blocksArray = new ArrayList<>();
        for(int i = 0; i < this.getWidth(); i = i + Block.WIDTH){
            for(int j = 0; j < (5 * Block.HEIGHT); j = j + Block.HEIGHT){
                blocksArray.add(new Block(i, j));
            }
        }
        return blocksArray;
    }



}
