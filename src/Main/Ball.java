package Main;

import javax.swing.*;
import java.awt.*;

public class Ball extends JPanel{
    public static final int BALL_X = 240;
    public static final int BALL_Y = 300;
    public static final int BALL_WIDTH = 20;
    public static final int BALL_HEIGHT = 20;

    public Ball() {
        this.setBackground(Color.red);
        this.setBounds(BALL_X, BALL_Y, BALL_WIDTH, BALL_HEIGHT);
    }
    
    
    

}
