//View File CSCE 3513 Team 6 Project
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.channels.spi.SelectorProvider;

public class View{
    //Class Variables
    Model model;
    Controller controller;
    JFrame frame;
    CardLayout root;
    JPanel container;
    JPanel SplatScreen;
    JPanel PlayerSceen;


    //Constructor
    public View(Model m, Controller controller){
        this.model = m;
        this.controller = controller;
        //Create Card Layouts and Jpanels
        this.frame = new JFrame();
        this.root = new CardLayout();
        this.SplatScreen = new JPanel();
        this.PlayerSceen = new JPanel();
        this.container = new JPanel();

        //Change Backgrounds
        this.SplatScreen.setBackground(Color.blue);
        this.PlayerSceen.setBackground(Color.green);

        //Add Panels to Card Layout
        this.container.setLayout(this.root);
        this.container.add(SplatScreen, "Splat");
        this.container.add(PlayerSceen, "Player");

        //Show a Panel
        root.show(container, "Splat");

        //Add to frame
        this.frame.add(this.container);
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setSize(1280,720);
        this.frame.setVisible(true);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        root.show(container, "Player");
    }
}
