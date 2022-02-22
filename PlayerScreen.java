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
        JLabel redTeamText = new JLabel("Red Team");
        redTeamText.setPreferredSize(new Dimension(480, 20));
        redTeamText.setFont(new Font("Serif", Font.BOLD, 24));
        redTeamText.setForeground(Color.RED);
        redTeamText.setHorizontalAlignment(JLabel.RIGHT);
        this.top.add(redTeamText, BorderLayout.LINE_START);
        

        //BlueTeam
        JLabel blueTeamText = new JLabel("Blue Team");
        blueTeamText.setPreferredSize(new Dimension(270, 20));
        blueTeamText.setFont(new Font("Serif", Font.BOLD, 24));
        blueTeamText.setForeground(Color.BLUE);
        blueTeamText.setHorizontalAlignment(JLabel.LEFT);
        this.top.add(blueTeamText, BorderLayout.LINE_END);

        //Create Table of textboxes
        this.table = new JPanel(new GridLayout(0,6, 1, 1));
        for(int i = 0; i < 15; i++){
            JLabel Labels = new JLabel("PLAYER " + (i+1));
            Labels.setHorizontalAlignment(JTextField.CENTER);
            Labels.setFont(new Font("Serif", Font.BOLD, 16));
            this.table.add(Labels);

            JTextField redIDInput = new JTextField();
            redIDInput.setHorizontalAlignment(JTextField.CENTER);
            redIDInput.setFont(new Font("Serif", Font.BOLD, 16));
            this.table.add(redIDInput);

            JTextField redCodeName = new JTextField();
            redCodeName.setHorizontalAlignment(JTextField.CENTER);
            redCodeName.setFont(new Font("Serif", Font.BOLD, 16));
            this.table.add(redCodeName);

            JLabel space = new JLabel();
            this.table.add(space);

            JTextField blueIDInput = new JTextField();
            blueIDInput.setHorizontalAlignment(JTextField.CENTER);
            blueIDInput.setFont(new Font("Serif", Font.BOLD, 16));
            this.table.add(blueIDInput);

            JTextField blueCodeName = new JTextField();
            blueCodeName.setHorizontalAlignment(JTextField.CENTER);
            blueCodeName.setFont(new Font("Serif", Font.BOLD, 16));
            this.table.add(blueCodeName);
        }

        //Add Components to JPanel
        this.add(this.top, BorderLayout.PAGE_START);
        this.add(this.table, BorderLayout.CENTER);
        
    }
}
