package Main;

import javax.swing.*;
import java.awt.*;

public class Ball extends JPanel {

    //ATRIBUTOS
    //--------------------------------------------------------------------------
    //Estáticos
    public static final int BALL_WIDTH = 20;
    public static final int BALL_HEIGHT = 20;

    //De instancia
    private int xDirection;
    private int yDirection;

    //CONSTRUCTORES
    //--------------------------------------------------------------------------
    //Por parámetros
    public Ball() {
        this.setBounds(241, 350, BALL_WIDTH, BALL_HEIGHT);
        this.xDirection = 1;
        this.yDirection = 1;
        this.setBackground(Color.red);
    }

    //GETTERS Y SETTERS
    //--------------------------------------------------------------------------
    //Getters
    public int getXLeftSide() {
        return this.getX();
        
    }

    public int getYTopSide() {
        return this.getY();
    }

    public int getXRightSide() {
        return this.getX() + 19;
    }

    public int getYBottomSide() {
        return this.getY() + 19;
    }

    //Setters
    //MÉTODOS
    //--------------------------------------------------------------------------
    //Sobrecargas
    /*@Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(0, 0, BALL_WIDTH, BALL_HEIGHT);
    }*/
    //De instancia
    public void changeXBallDirection() {
        this.xDirection *= -1;
    }

    public void changeYBallDirection() {
        this.yDirection *= -1;
    }

    public void updateBallPosition() {
        this.setBounds(this.getX() + this.xDirection, this.getY() + this.yDirection, Ball.BALL_WIDTH, Ball.BALL_HEIGHT);
    }

}
