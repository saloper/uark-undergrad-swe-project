//View File CSCE 3513 Team 6 Project
import javax.swing.*;
import java.awt.*;

public class View{
    //Class Variables
    JFrame frame; //Main Frame
    CardLayout root; //Holds the Jpanels
    JPanel container; //Holds the root
    Database DB;
    public static Dimension windowSize;


    //Constructor
    public View(Database DB){
        this.DB = DB;
        //Create Card Layouts and Jpanels
        this.frame = new JFrame();
        this.root = new CardLayout();
        this.container = new JPanel();
        windowSize = new Dimension(1280, 720);
    
        //Add Panels to Card Layout
        this.container.setLayout(this.root);
        this.container.setPreferredSize(windowSize);
        this.container.add(new SplatScreen(), "Splat"); //Add a Splat Screen
        this.container.add(new PlayerScreen(this.DB), "Player"); //Add a player Screen
        this.container.add(new ActionScreen(), "Action"); // Add an action screen

        //Add to  Everything to a frame
        this.frame.add(this.container);
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.pack();
        this.frame.setResizable(false);
        this.frame.setVisible(false); //Show a Frame

    }

    //Method to Lauch Application with splat screen pause
    public void launch(){
        this.showSplat();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Could not Sleep!");
            e.printStackTrace();
        }
        //this.showPlayer();
        this.showActionScreen();
    }

    //Method to show the Splat Panel
    public void showSplat(){
        //Show a the Splat View
        root.show(container, "Splat");
        this.frame.setVisible(true);
    }

    //Method to Show the Player View
    public void showPlayer(){
        root.show(container, "Player");
        this.frame.setVisible(true);
    }

    public void showActionScreen(){
        root.show(container, "Action");
        this.frame.setVisible(true);
    }
}
