//View File CSCE 3513 Team 6 Project
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class View implements KeyEventDispatcher{
    //Class Variables
    JFrame frame; //Main Frame
    CardLayout root; //Holds the Jpanels
    JPanel container; //Holds the root
    SplatScreen splatScreen;
    PlayerScreen playerScreen;
    ActionScreen actionScreen;
    Database DB;
    Boolean gameStarted;


    //Constructor
    public View(Database DB){
        this.DB = DB;
        //Create Card Layouts and Jpanels
        this.frame = new JFrame();
        this.root = new CardLayout();
        this.container = new JPanel();

        //Add Key Manage
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(this);

        //Add Panels to Card Layout
        this.container.setLayout(this.root);
        this.container.setPreferredSize(new Dimension(1280,720));
        splatScreen = new SplatScreen();
        playerScreen = new PlayerScreen(this.DB);
        actionScreen = new ActionScreen(this.DB);

        this.container.add(splatScreen, "Splat"); //Add a Splat Screen
        this.container.add(playerScreen, "Player"); //Add a player Screen
        this.container.add(actionScreen, "ActionScreen"); //Add a action screen

        //Add to  Everything to a frame
        this.frame.add(this.container);
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.pack();
        this.frame.setResizable(false);
        this.frame.setVisible(false); //Show a Frame

        this.gameStarted = false; // game does not start by default

    }

    //Method to Lauch Application with splat screen pause
    public void launch(){
        this.showSplat();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Could not Sleep!");
            e.printStackTrace();
        }
        this.showPlayer();
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
        this.playerScreen.readFields();
        this.actionScreen.onLoad();
        root.show(container, "ActionScreen");
        this.frame.setVisible(true);
    }

    public void showStartGame(){
        this.showActionScreen();
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_F5) {
            if (!this.gameStarted) {
                this.gameStarted = true;
                this.showStartGame();
            }
        }
        return false;
    }

}
