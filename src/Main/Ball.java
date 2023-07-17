package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ball extends JPanel implements ActionListener {

    private int ballX;
    private int ballY;

    private int ballXDirection;
    private int ballYDirection;

    public static final int BALL_WIDTH = 20;
    public static final int BALL_HEIGHT = 20;

    private Timer timer;    
    
    private Player player;

    public Ball(Player player) {
        this.player = player;
        this.setBackground(Color.red);
        this.ballX = 240;
        this.ballY = 300;
        this.ballXDirection = (int) (Math.random() * 5) - 2;
        this.ballYDirection = -2;
        this.setBounds(ballX, ballY, BALL_WIDTH, BALL_HEIGHT);
        timer = new Timer(10, this);
        timer.start();
    }
    
    

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(0, 0, BALL_WIDTH, BALL_HEIGHT);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.ballX <= 0 || this.ballX >= 480) {
            this.ballXDirection *= -1;
        }
        if (this.ballY <= 0 || this.ballY >= 380) {
            this.ballYDirection *= -1;
        }

           
        
        if (this.ballY < 380 || (this.ballX >=  (this.player.getPlayerX() - 20) && this.ballX <= (this.player.getPlayerX() + 100))) {
            this.ballX += this.ballXDirection;
            this.ballY += this.ballYDirection;

            this.setBounds(ballX, ballY, BALL_WIDTH, BALL_HEIGHT);
        }

    }

}
