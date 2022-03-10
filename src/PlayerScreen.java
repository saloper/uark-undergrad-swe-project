import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//Class to hold the Splat Screen
//This class is a Jpanel the consists of two seperate Panels
//The top Panel holds the title
//The table panel holds the text fields to add players
public class PlayerScreen extends JPanel{
    //Class Variables
    JPanel table;
    JPanel top;
    Database DB;
    

    //Array of Ids and names

    public PlayerScreen(Database DB){
        this.DB = DB;
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
        

        //GreenTeam
        JLabel greenTeamText = new JLabel("Green Team");
        greenTeamText.setPreferredSize(new Dimension(270, 20));
        greenTeamText.setFont(new Font("Serif", Font.BOLD, 24));
        greenTeamText.setForeground(Color.GREEN);
        greenTeamText.setHorizontalAlignment(JLabel.LEFT);
        this.top.add(greenTeamText, BorderLayout.LINE_END);

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
            redIDInput.setName("redId" + i);
            redIDInput.addActionListener(inputAction);
            this.table.add(redIDInput);

            JTextField redCodeName = new JTextField();
            redCodeName.setHorizontalAlignment(JTextField.CENTER);
            redCodeName.setFont(new Font("Serif", Font.BOLD, 16));
            redCodeName.setName("redName" + i);
            redCodeName.putClientProperty("redName", i);
            redCodeName.addActionListener(inputAction);
            this.table.add(redCodeName);

            JLabel space = new JLabel();
            this.table.add(space);

            JTextField greenIDInput = new JTextField();
            greenIDInput.setHorizontalAlignment(JTextField.CENTER);
            greenIDInput.setFont(new Font("Serif", Font.BOLD, 16));
            greenIDInput.setName("greenID" + i);
            greenIDInput.addActionListener(inputAction);
            this.table.add(greenIDInput);

            JTextField greenCodeName = new JTextField();
            greenCodeName.setHorizontalAlignment(JTextField.CENTER);
            greenCodeName.setFont(new Font("Serif", Font.BOLD, 16));
            greenCodeName.setName("greenName" + i);
            greenCodeName.addActionListener(inputAction);
            this.table.add(greenCodeName);
        }

        //Add Components to JPanel
        this.add(this.top, BorderLayout.PAGE_START);
        this.add(this.table, BorderLayout.CENTER);
        
    }

    ActionListener inputAction = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            var textBox = (JTextField)e.getSource();
        }
    };
    // This is called when you enter text into a player field and press enter. It returns the text inside the field plus an index client property to discern which input box
    // the message came from. getSource returns the object which invoked the inputAction event then casts it into a JTextField and calls its methods in order to get the data needed.
    // The "index" client property represents red players from 1-15, and green players from 16-30. This can be moved to another class later if needed.
}
