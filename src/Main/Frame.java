package Main;

import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame{

    
    private Panel panel;

    public Frame() {
        initializer();
    }

    private void initializer() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        this.panel = new Panel();       
        
        this.add(this.panel);
        this.addKeyListener(this.panel.getPlayer());
        this.pack();
    }

}
