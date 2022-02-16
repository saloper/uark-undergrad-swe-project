import javax.swing.*;
import java.awt.*;

//Class to hold the Splat Screen
//This class is a Jpanel the consists of two seperate Panels
//The top Panel holds the title
//The table panel holds the text fields to add players
public class PlayerScreen extends JPanel{
    //Class Variables
    JPanel table;
    JPanel top;
    public PlayerScreen(){
        //Set The Layout
        this.setLayout(new BorderLayout(0, 20));

        //Create the Top Titles
        this.top = new JPanel(new BorderLayout(0,10)); //Layout as BorderLayout
        //Title
        JLabel title = new JLabel("Enter Player Names");
        title.setPreferredSize(new Dimension(1280, 50));
        title.setFont(new Font("Serif", Font.BOLD, 36));
        title.setHorizontalAlignment(JLabel.CENTER);
        this.top.add(title, BorderLayout.PAGE_START);

        //RedTeam
        JLabel redTeam = new JLabel("Red Team");
        redTeam.setPreferredSize(new Dimension(640, 20));
        redTeam.setFont(new Font("Serif", Font.BOLD, 24));
        redTeam.setForeground(Color.RED);
        redTeam.setHorizontalAlignment(JLabel.CENTER);
        this.top.add(redTeam, BorderLayout.LINE_START);

        //BlueTeam
        JLabel blueTeam = new JLabel("Blue Team");
        blueTeam.setPreferredSize(new Dimension(640, 20));
        blueTeam.setFont(new Font("Serif", Font.BOLD, 24));
        blueTeam.setForeground(Color.BLUE);
        blueTeam.setHorizontalAlignment(JLabel.CENTER);
        this.top.add(blueTeam, BorderLayout.LINE_END);

        //Create Table of textboxes
        this.table = new JPanel(new GridLayout(0,2));
        for(int i = 0; i < 20; i++){
            JTextField tmp = new JTextField();
            tmp.setHorizontalAlignment(JTextField.CENTER);
            tmp.setFont(new Font("Serif", Font.BOLD, 16));
            this.table.add(tmp);
        }

        //Add Components to JPanel
        this.add(this.top, BorderLayout.PAGE_START);
        this.add(this.table, BorderLayout.CENTER);

    }
}
