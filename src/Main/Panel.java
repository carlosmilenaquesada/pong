package Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Panel extends JPanel implements ActionListener {

    private Player player;
    private Ball ball;
    private ArrayList<Block> blocks;
    private ArrayList<Block> frontBlocks;

    private Timer timer;

    boolean gameOver = false;

    public Panel() {
        this.setLayout(null);
        this.setBackground(Color.PINK);
        this.setPreferredSize(new Dimension(500, 500));

        this.player = new Player((this.getPreferredSize().width - Player.PLAYER_WIDTH) / 2, this.getPreferredSize().width);
        this.ball = new Ball((this.getPreferredSize().width - Ball.BALL_WIDTH) / 2, Player.PLAYER_HEIGHT + 20);
        this.blocks = this.buildBlocks();
        this.frontBlocks = new ArrayList<>(blocks.subList(blocks.size() - 10, blocks.size()));

        this.add(this.player);
        this.add(this.ball);
        this.addBlocks(this.blocks);

        this.timer = new Timer(10, this);
        this.timer.start();
    }

    public Player getPlayer() {
        return this.player;
    }

    //MÉTODOS
    //--------------------------------------------------------------------------
    //Auxiliares
    private ArrayList<Block> buildBlocks() {
        ArrayList<Block> blocksArray = new ArrayList<>();
        for (int yPos = 0; yPos < (Block.BLOCK_HEIGHT * 5); yPos = yPos + Block.BLOCK_HEIGHT) {
            for (int xPos = 0; xPos < this.getPreferredSize().width; xPos = xPos + Block.BLOCK_WIDTH) {
                blocksArray.add(new Block(xPos, yPos, new Color((int) (Math.random() * 16777215) + 1)));
            }
        }
        return blocksArray;
    }

    private void addBlocks(ArrayList<Block> blocks) {
        for (Block block : blocks) {
            this.add(block);
        }
    }

    
    //DADO EL PUNTO X DE LA  BOLA, LOCALIZAMOS EL BLOQUE DEL GRUPO DEL FRENTE EN ESE PUNTO X.
        //SI DICHO BLOQUE TIENE un valor de Y MAYOR O IGUAL AL DE LA BOLA, SE DESTRUYE.
    

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
