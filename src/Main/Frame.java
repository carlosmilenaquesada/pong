package Main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Frame extends JFrame {

    private Panel panel;

    public Frame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.panel = new Panel();

        this.add(this.panel);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                panel.getPlayer().playerInput(e);
            }
        });
        this.pack();
    }

}
