package Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Ball extends JPanel {

    //ATRIBUTOS
    //--------------------------------------------------------------------------
    //Estáticos
    public static final int BALL_WIDTH = 21;
    public static final int BALL_HEIGHT = 21;

    //De instancia
    private int ballXPosition;
    private int ballYPosition;
    private int ballXDirection;
    private int ballYDirection;

    //CONSTRUCTORES
    //--------------------------------------------------------------------------
    //Por parámetros
    public Ball(int ballXPosition, int ballYPosition) {
        this.ballXPosition = ballXPosition;
        this.ballYPosition = ballYPosition;
        do {
            this.ballXDirection = (int) (Math.random() * 5) - 2;
        } while (this.ballXDirection == 0);
        this.ballYDirection = -2;
        this.setBackground(Color.red);
        this.setBounds(this.ballXPosition, this.ballYPosition, BALL_WIDTH, BALL_HEIGHT);
    }

    //GETTERS Y SETTERS
    //--------------------------------------------------------------------------
    //Getters
    public int getBallXPosition() {
        return this.ballXPosition;
    }

    public int getBallYPosition() {
        return this.ballYPosition;
    }

    public int getBallXDirection() {
        return this.ballXDirection;
    }

    public int getBallYDirection() {
        return this.ballYDirection;
    }
    
    //Getters autocalculados   
    public Vector2d getBallCenterPoint(){
        return new Vector2d(this.ballXPosition + (Ball.BALL_WIDTH / 2), this.ballYPosition + (Ball.BALL_HEIGHT / 2));
    }
    
    public Vector2d getBallTopPoint(){
        return new Vector2d(this.getBallXPosition() + (Ball.BALL_WIDTH / 2), this.ballYPosition);
    }
    
    public Vector2d getBallRightPoint(){
        return new Vector2d(this.getBallXPosition() + (Ball.BALL_WIDTH - 1), this.getBallYPosition() + (Ball.BALL_HEIGHT / 2));
    }
    
    public Vector2d getBallBottomPoint(){
        return new Vector2d(this.ballXPosition + (Ball.BALL_WIDTH /2), this.ballYPosition + (Ball.BALL_HEIGHT - 1));
    }
    
    public Vector2d getBallLeftPoint(){
        return new Vector2d(this.ballXPosition, this.ballYPosition + (Ball.BALL_HEIGHT /2));
    }   

    //Setters
    public void setBallXPosition(int ballXPosition) {
        this.ballXPosition = ballXPosition;
    }

    public void setBallYPosition(int ballYPosition) {
        this.ballYPosition = ballYPosition;
    }

    public void setBallXDirection(int ballXDirection) {
        this.ballXDirection = ballXDirection;
    }

    public void setBallYDirection(int ballYDirection) {
        this.ballYDirection = ballYDirection;
    }

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
        this.ballXDirection *= -1;
    }

    public void changeYBallDirection() {
        this.ballYDirection *= -1;
    }

    public void updateBallPosition() {
        this.ballXPosition += this.ballXDirection;
        this.ballYPosition += this.ballYDirection;
        this.setBounds(this.ballXPosition, this.ballYPosition, Ball.BALL_WIDTH, Ball.BALL_HEIGHT);
    }

}
