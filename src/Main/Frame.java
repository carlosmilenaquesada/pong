package Main;

import javax.swing.*;

public class Frame extends JFrame{
    
    private Panel panel;
    
    public Frame(Panel panelClass){
        initializer();
    }
    
    private void initializer(){
        this.panel = new Panel();
        this.add(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    
    }
    
}
