package Main;

import java.awt.*;
import javax.swing.*;

public class Panel extends JPanel {
    
    private Player player;
    private Ball ball;    

    public Panel() {
        this.setLayout(null);
        this.setBackground(Color.PINK);
        this.setPreferredSize(new Dimension(500, 500));
        
        this.ball = new Ball();
        this.player = new Player();
        
        this.add(player);
        this.add(ball);
    }
    
    public Player getPlayer(){
        return this.player;
    }
}
