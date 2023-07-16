package Main;

import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {

    private Player player;
    private Ball ball;

    public Frame() {
        initializer();
    }

    private void initializer() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanel.setBackground(Color.PINK);
        jPanel.setPreferredSize(new Dimension(500, 500));
        this.ball = new Ball();
        this.player = new Player();
        jPanel.add(player);
        jPanel.add(ball);
        this.add(jPanel);
        this.addKeyListener(player);
        this.pack();
    }

}
