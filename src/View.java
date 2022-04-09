//View File CSCE 3513 Team 6 Project
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class View implements KeyEventDispatcher{
    //Class Variables
    JFrame frame; //Main Frame
    CardLayout root; //Holds the Jpanels
    JPanel container; //Holds the root
    SplatScreen splatScreen;
    PlayerScreen playerScreen;
    ActionScreen actionScreen;
    Database DB;
    UDPListener UDP;
    Boolean gameStarted;
    static Boolean gameOver = false;


    //Constructor
    public View(Database DB) throws ClassNotFoundException, IOException{
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
        actionScreen = new ActionScreen(this.DB, this.UDP);

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
        this.playerScreen.redIDField[1].requestFocusInWindow();
    }

    public void showActionScreen() throws IOException{
        this.playerScreen.readFields();
        this.actionScreen.onLoad();
        //for(int i=0;i<10;i++) this.actionScreen.sendKillMessage(new Player("person",6,true), new Player("people",7,false));
        root.show(container, "ActionScreen");
        this.frame.setVisible(true);
    }

    public void showStartGame() throws IOException{
        this.showActionScreen();
        this.actionScreen.setTimer();
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_F5 && e.getID() == KeyEvent.KEY_PRESSED) {
            if (!this.gameStarted) {
                this.gameStarted = true;
                try {
                    this.showStartGame();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_F1 && e.getID() == KeyEvent.KEY_PRESSED) {
            System.out.println("gameStarted: " + this.gameStarted);
            System.out.println("actionScreen.isVisible(): " + this.actionScreen.isVisible());
            System.out.println("gameOver: " + gameOver);
            if (this.gameStarted && this.actionScreen.isVisible() && gameOver) {
                this.showPlayer();
                this.playerScreen.clearFields();
                this.DB.players.clear();
                this.actionScreen.clearActionUI();
                gameOver = false;
                gameStarted = false;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_F4) {
            this.actionScreen.sendKillMessage(this.DB.players.get(0), this.DB.players.get(1));
        }
        return false;
    }

}
