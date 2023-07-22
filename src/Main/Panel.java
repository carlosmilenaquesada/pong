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

        this.player = new Player();
        this.ball = new Ball();
        this.blocks = this.buildBlocks();

        this.add(this.player);
        this.add(this.ball);

        this.fps = 100;
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

    //--------------------------------------------------------------------------
    private void ballPointAction_TOPLEFT(int xPoint, int yPoint) {//OK
        if (xPoint >= (50 + 1) && xPoint <= (450 + 1)) {//1
            if (xPoint % 50 == 1) {
                if (this.blocks[(yPoint / (20 + 1)) - 0][(xPoint / 50) - 1] != null) {
                    this.blocks[(yPoint / (20 + 1)) - 0][(xPoint / 50) - 1].setVisible(false);
                    this.blocks[(yPoint / 20 + 1) - 0][(xPoint / 50) - 1] = null;
                }
            }
        }

        //offset = 1;
        if (yPoint >= (20 + 1) && yPoint <= (100 + 1)) {//1
            if (yPoint % 20 == 1) {
                if (this.blocks[(yPoint / 20) - 1][(xPoint / 50) - 0] != null) {
                    this.blocks[(yPoint / 20) - 1][(xPoint / 50) - 0].setVisible(false);
                    this.blocks[(yPoint / 20) - 1][(xPoint / 50) - 0] = null;
                }
            }
        }
    }

    //--------------------------------------------------------------------------
    private void ballPointAction_TOPRIGHT(int xPoint, int yPoint) {//OK

        if (xPoint >= (50 + 0) && xPoint <= (450 + 0)) {//0
            if (xPoint % 50 == 0) {
                if (this.blocks[yPoint / 20][(xPoint / 50) - 1] != null) {
                    this.blocks[yPoint / 20][(xPoint / 50) - 1].setVisible(false);
                    this.blocks[yPoint / 20][(xPoint / 50) - 1] = null;
                }
            }
        }

        if (yPoint >= (20 + 1) && yPoint <= (100 + 1)) {//1
            if (yPoint % 20 == 1) {
                if (this.blocks[(yPoint / 20) - 1][(xPoint / 50)] != null) {
                    this.blocks[(yPoint / 20) - 1][(xPoint / 50)].setVisible(false);
                    this.blocks[(yPoint / 20) - 1][(xPoint / 50)] = null;
                }
            }
        }
    }

    //--------------------------------------------------------------------------
    private void ballPointAction_BOTTOMLEFT(int xPoint, int yPoint) {

        if (xPoint >= (50 + 1) && xPoint <= (450 + 1)) {//OK
            if (xPoint % 50 == 1) {
                if (this.blocks[yPoint / 20][(xPoint / 50) - 1] != null) {
                    this.blocks[yPoint / 20][(xPoint / 50) - 1].setVisible(false);
                    this.blocks[yPoint / 20][(xPoint / 50) - 1] = null;
                }
            }
        }

        if (yPoint >= (20 + 0) && yPoint <= (80 + 0)) {//
            if (yPoint % 20 == 0) {
                if (this.blocks[(yPoint / 20) - 0][(xPoint / 50)] != null) {
                    this.blocks[(yPoint / 20) - 0][(xPoint / 50)].setVisible(false);
                    this.blocks[(yPoint / 20) - 0][(xPoint / 50)] = null;
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        boolean ballHitCeiling = this.ball.getYTopSide() <= 1;
        boolean ballHitFrontier = (this.ball.getYBottomSide() >= Player.PLAYER_Y_POSITION - 1);
        boolean ballAlignPlayer = (this.ball.getXRightSide() >= this.player.getX()) && (this.ball.getXLeftSide() <= this.player.getX() + 99);
        boolean ballHitWall = this.ball.getXLeftSide() <= 1 || this.ball.getXRightSide() >= 500;

        if (ballHitCeiling || (ballHitFrontier && ballAlignPlayer)) {
            this.ball.changeYBallDirection();
        }

        if (ballHitWall) {
            this.ball.changeXBallDirection();
        }

        if (ballHitFrontier && !ballAlignPlayer) {
            this.timer.stop();
            this.getGraphics().drawString("Game Over", 200, 200);
        } else {
            this.ball.updateBallPosition();

        }

    }

}
