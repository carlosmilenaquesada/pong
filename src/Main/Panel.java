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
                blockMatrix[row][column] = new Block((column * Block.BLOCK_WIDTH) + 1, (row * Block.BLOCK_HEIGHT) + 1, new Color((int) (Math.random() * 16777215) + 1));
                this.add(blockMatrix[row][column]);
            }
        }
        return blockMatrix;
    }

    private boolean destroyBlock(int row, int column) {
        boolean destroyed = false;
        if (this.blocks[row][column] != null) {
            this.blocks[row][column].setVisible(false);
            this.blocks[row][column] = null;
            destroyed = true;
        }
        return destroyed;
    }

    //--------------------------------------------------------------------------
    private boolean ballPointActionTop(int xPointLeftCorner, int xPointRightCorner) {
        boolean destroyLeft = false;
        boolean destroyRight = false;
        int yPoint = ball.getYTopSide();

        if (yPoint >= 31 && yPoint <= 151) {
            if (yPoint % 30 == 1) {
                int rowIndex = (yPoint / 30) - 1;
                destroyLeft = this.destroyBlock(rowIndex, (xPointLeftCorner - 1) / 50);
                destroyRight = this.destroyBlock(rowIndex, (xPointRightCorner - 1) / 50);
            }
        }
        return destroyLeft || destroyRight;
    }

    private boolean ballPointActionBottom(int xPointLeftCorner, int xPointRightCorner) {
        boolean destroyLeft = false;
        boolean destroyRight = false;
        int yPoint = ball.getYBottomSide();

        if (yPoint >= 30 && yPoint <= 120) {
            if (yPoint % 30 == 0) {
                int rowIndex = yPoint / 30;
                destroyLeft = this.destroyBlock(rowIndex, (xPointLeftCorner - 1) / 50);
                destroyRight = this.destroyBlock(rowIndex, (xPointRightCorner - 1) / 50);
            }
        }
        return destroyLeft || destroyRight;
    }

    private boolean ballPointActionLeft(int yPointTopCorner, int yPointBottomCorner) {
        boolean destroyTop = false;
        boolean destroyBottom = false;
        int xPoint = ball.getXLeftSide();

        if (xPoint >= 51) {
            if (xPoint % 50 == 1) {
                int columIndex = (xPoint / 50) - 1;
                if (yPointTopCorner <= 150) {
                    destroyTop = this.destroyBlock((yPointTopCorner - 1) / 30, columIndex);
                }
                if (yPointBottomCorner <= 150) {
                    destroyBottom = this.destroyBlock((yPointBottomCorner - 1) / 30, columIndex);
                }
            }
        }

        return destroyTop || destroyBottom;
    }

    private boolean ballPointActionRight(int yPointTopCorner, int yPointBottomCorner) {
        boolean destroyTop = false;
        boolean destroyBottom = false;
        int xPoint = ball.getXRightSide();

        if (xPoint <= 450) {
            if (xPoint % 50 == 0) {
                if (yPointTopCorner <= 150) {
                    destroyTop = this.destroyBlock((yPointTopCorner - 1) / 30, xPoint / 50);
                }
                if (yPointBottomCorner <= 150) {
                    destroyBottom = this.destroyBlock((yPointBottomCorner - 1) / 30, xPoint / 50);
                }
            }
        }

        return destroyTop || destroyBottom;
    }

    //--------------------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {

        boolean ballHitCeiling = this.ball.getYTopSide() <= 1;
        boolean ballHitFrontier = (this.ball.getYBottomSide() >= Player.PLAYER_Y_POSITION - 1);
        boolean ballAlignPlayer = (this.ball.getXRightSide() >= this.player.getX()) && (this.ball.getXLeftSide() <= this.player.getX() + 99);
        boolean ballHitWall = this.ball.getXLeftSide() <= 1 || this.ball.getXRightSide() >= 500;

        if (ballHitCeiling || (ballHitFrontier && ballAlignPlayer) || this.ballPointActionTop(ball.getXLeftSide(), ball.getXRightSide()) || this.ballPointActionBottom(ball.getXLeftSide(), ball.getXRightSide())) {
            this.ball.changeYBallDirection();
        }

        if (ballHitWall || this.ballPointActionLeft(ball.getYTopSide(), ball.getYBottomSide()) || this.ballPointActionRight(ball.getYTopSide(), ball.getYBottomSide())) {
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
