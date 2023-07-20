package Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Panel extends JPanel implements ActionListener {

    private Player player;
    private Ball ball;
    private Block[][] blocks;
    private Timer timer;
    private int fps;

    boolean gameOver = false;

    public Panel() {
        this.setLayout(null);
        this.setBackground(Color.PINK);
        this.setPreferredSize(new Dimension(500, 500));

        this.player = new Player((this.getPreferredSize().width - Player.PLAYER_WIDTH) / 2, this.getPreferredSize().width);
        this.ball = new Ball((this.getPreferredSize().width - Ball.BALL_WIDTH) / 2, Player.PLAYER_Y_POSITION - 100);
        this.blocks = this.buildBlocks();

        this.add(this.player);
        this.add(this.ball);

        this.fps = 60;
        this.timer = new Timer(1000 / fps, this);
        this.timer.start();
    }

    public Player getPlayer() {
        return this.player;
    }

    //MÉTODOS
    //--------------------------------------------------------------------------
    //Auxiliares
    private Block[][] buildBlocks() {
        Block[][] blockMatrix = new Block[5][10];

        for (int row = 0; row < blockMatrix.length; row++) {
            for (int column = 0; column < blockMatrix[0].length; column++) {
                blockMatrix[row][column] = new Block(column * 50, row * 20, new Color((int) (Math.random() * 16777215) + 1));
                this.add(blockMatrix[row][column]);
            }
        }
        return blockMatrix;
    }

    private boolean blockDestroyerTopBall() {
        boolean bloqueDestruido = false;
        Vector2d ballTop = this.ball.getBallTopPoint();

        int rowAux = 0;
        int columnAux = 0;
        int offset = 0;
        int widthOffsetEffect = Block.BLOCK_WIDTH - (Ball.BALL_WIDTH / 2);

        //TOP
        if (ballTop.getY() % Block.BLOCK_HEIGHT == 0 && this.ball.getBallYDirection() < 0) {
            if (ballTop.getY() >= Block.BLOCK_HEIGHT && ballTop.getY() <= (Block.BLOCK_HEIGHT * 5)) {
                rowAux = (ballTop.getY() / Block.BLOCK_HEIGHT) - 1;
                columnAux = (ballTop.getX() / Block.BLOCK_WIDTH);

                if (ballTop.getX() >= widthOffsetEffect && ballTop.getX() <= this.getPreferredSize().width - widthOffsetEffect) {
                    if (ballTop.getX() % Block.BLOCK_WIDTH <= Block.BLOCK_WIDTH - widthOffsetEffect) {
                        offset = -1;
                    } else {
                        if (ballTop.getX() % Block.BLOCK_WIDTH >= widthOffsetEffect) {
                            offset = 1;
                        }
                    }
                }

                if (this.blocks[rowAux][columnAux] != null) {
                    this.blocks[rowAux][columnAux].setVisible(false);
                    this.blocks[rowAux][columnAux] = null;
                    bloqueDestruido = true;
                }
                if (this.blocks[rowAux][columnAux + offset] != null) {
                    this.blocks[rowAux][columnAux + offset].setVisible(false);
                    this.blocks[rowAux][columnAux + offset] = null;
                    bloqueDestruido = true;
                }

            }
        }
        return bloqueDestruido;
    }

    private boolean blockDestroyerBottomBall() {
        boolean bloqueDestruido = false;
        Vector2d ballBottom = this.ball.getBallBottomPoint();

        int rowAux = 0;
        int columnAux = 0;
        int offset = 0;
        int widthOffsetEffect = Block.BLOCK_WIDTH - (Ball.BALL_WIDTH / 2);

        //TOP
        if (ballBottom.getY() % Block.BLOCK_HEIGHT == 0 && this.ball.getBallYDirection() > 0) {
            if (ballBottom.getY() >= Block.BLOCK_HEIGHT && ballBottom.getY() <= (Block.BLOCK_HEIGHT * 5)) {
                rowAux = (ballBottom.getY() / Block.BLOCK_HEIGHT) - 1;
                columnAux = (ballBottom.getX() / Block.BLOCK_WIDTH);

                if (ballBottom.getX() >= widthOffsetEffect && ballBottom.getX() <= this.getPreferredSize().width - widthOffsetEffect) {
                    if (ballBottom.getX() % Block.BLOCK_WIDTH <= Block.BLOCK_WIDTH - widthOffsetEffect) {
                        offset = -1;
                    } else {
                        if (ballBottom.getX() % Block.BLOCK_WIDTH >= widthOffsetEffect) {
                            offset = 1;
                        }
                    }
                }

                if (this.blocks[rowAux][columnAux] != null) {
                    this.blocks[rowAux][columnAux].setVisible(false);
                    this.blocks[rowAux][columnAux] = null;
                    bloqueDestruido = true;
                }
                if (this.blocks[rowAux][columnAux + offset] != null) {
                    this.blocks[rowAux][columnAux + offset].setVisible(false);
                    this.blocks[rowAux][columnAux + offset] = null;
                    bloqueDestruido = true;
                }

            }
        }
        return bloqueDestruido;

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

            if (this.blockDestroyerTopBall() == true) {
                this.ball.changeYBallDirection();
            } else {
                if (this.blockDestroyerBottomBall() == true) {
                    this.ball.changeYBallDirection();
                }

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
