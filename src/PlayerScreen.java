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
    JTextField [] redIDField;
    JTextField [] redNameField;
    JTextField [] greenIDField;
    JTextField [] greenNameField;


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
        redIDField = new JTextField[16];
        redNameField = new JTextField[16];
        greenIDField = new JTextField[16];
        greenNameField = new JTextField[16];
        for(int i = 1; i <= 15; i++){
            //Add Label
            JLabel Labels = new JLabel("PLAYER " + i);
            Labels.setHorizontalAlignment(JTextField.CENTER);
            Labels.setFont(new Font("Serif", Font.BOLD, 16));
            this.table.add(Labels);
            //Add RedID Input 
            redIDField[i] = new JTextField();
            redIDField[i].setHorizontalAlignment(JTextField.CENTER);
            redIDField[i].setFont(new Font("Serif", Font.BOLD, 16));
            redIDField[i].setName("redID-" + i);
            redIDField[i].addActionListener(inputAction);
            this.table.add(redIDField[i]);
            //Add RedName Input
            redNameField[i] = new JTextField();
            redNameField[i].setHorizontalAlignment(JTextField.CENTER);
            redNameField[i].setFont(new Font("Serif", Font.BOLD, 16));
            redNameField[i].setName("redName" + i);
            redNameField[i].putClientProperty("redName-", i);
            redNameField[i].addActionListener(inputAction);
            this.table.add(redNameField[i]);

            JLabel space = new JLabel();
            this.table.add(space);
            //Add GreenID Input
            greenIDField[i] = new JTextField();
            greenIDField[i].setHorizontalAlignment(JTextField.CENTER);
            greenIDField[i].setFont(new Font("Serif", Font.BOLD, 16));
            greenIDField[i].setName("greenID-" + i);
            greenIDField[i].addActionListener(inputAction);
            this.table.add(greenIDField[i]);
            //Add GreenName Input
            greenNameField[i] = new JTextField();
            greenNameField[i].setHorizontalAlignment(JTextField.CENTER);
            greenNameField[i].setFont(new Font("Serif", Font.BOLD, 16));
            greenNameField[i].setName("greenName-" + i);
            greenNameField[i].addActionListener(inputAction);
            this.table.add(greenNameField[i]);
        }

        //Add Components to JPanel
        this.add(this.top, BorderLayout.PAGE_START);
        this.add(this.table, BorderLayout.CENTER);
        
    }

    ActionListener inputAction = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            var textBox = (JTextField)e.getSource();
            //Parse Name
            String [] identity = textBox.getName().split("-");
            int ID = Integer.valueOf(textBox.getText());
            int index = Integer.valueOf(identity[1]);
            //Check if it is a redID box
            if (identity[0].equals("redID")){
                //Query the Database
                String result = DB.getCodename(ID);
                if(result != null){
                    redNameField[index].setText(result);
                }
            } else if (identity[0].equals("greenID")){ //Check if greenID box
                //Query the Database
                String result = DB.getCodename(ID);
                if(result != null){
                    greenNameField[index].setText(result);
                }
            }
        }
    };

    //Method to Read all of the fields into data array
    public void readFields(){
        for (int i = 1; i <= 15; i++){
            if(!redIDField[i].getText().isBlank() && !redNameField[i].getText().isBlank()){
                int ID = Integer.valueOf(redIDField[i].getText());
                String codeName = redNameField[i].getText();
                this.DB.players.add(new Player(codeName,ID, true));
            }
            if(!greenIDField[i].getText().isBlank() && !greenNameField[i].getText().isBlank()){
                int ID = Integer.valueOf(greenIDField[i].getText());
                String codeName = greenNameField[i].getText();
                this.DB.players.add(new Player(codeName,ID, false));
            }
        }
    }
}
