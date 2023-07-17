package Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Panel extends JPanel implements ActionListener {

    private Player player;
    private Ball ball;

    private Timer timer;

    boolean gameOver = false;

    public Panel() {
        this.setLayout(null);
        this.setBackground(Color.PINK);
        this.setPreferredSize(new Dimension(500, 500));
        this.player = new Player((this.getPreferredSize().width - Player.PLAYER_WIDTH) / 2, this.getPreferredSize().width);
        this.ball = new Ball((this.getPreferredSize().width - Ball.BALL_WIDTH) / 2, Player.PLAYER_HEIGHT + 20);

        this.add(player);
        this.add(ball);

        this.timer = new Timer(10, this);
        this.timer.start();
    }

    public Player getPlayer() {
        return this.player;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //si pega abajo
        if (this.ball.getBallYPosition() >= Player.PLAYER_Y_POSITION - Ball.BALL_HEIGHT) {
            //si pega en el player -> cambia de direccion
            if (this.ball.getBallXPosition() >= (this.player.getPlayerXPosition() - Ball.BALL_WIDTH) && this.ball.getBallXPosition() <= (this.player.getPlayerXPosition() + Player.PLAYER_WIDTH)) {
                this.ball.changeYBallDirection();
            } else {
                //si no -> game over vuelve true
                this.gameOver = true;
            }
        }

        //si game over es false 
        if (this.gameOver == false) {
            //si pega en el techo() -> cambia de direccion;        
            if (this.ball.getBallYPosition() <= 0) {
                this.ball.changeYBallDirection();
            }
            //si pega a la derecha o a la izquierda -> cambia de direccion;
            if (this.ball.getBallXPosition() <= 0 || (this.ball.getBallXPosition() >= this.getPreferredSize().width - Ball.BALL_WIDTH)) {
                this.ball.changeXBallDirection();
            }
            //displace            
            this.ball.updateBallPosition();
        } else {
            //si es game over es true
            Graphics2D g2D = (Graphics2D) this.getGraphics();
            g2D.setFont(new Font("Consolas", Font.BOLD, 30));
            g2D.drawString("GAME OVER!!", 150, 250);

            this.timer.stop();

        }

    }
}
