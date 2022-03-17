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
    JPanel bottom;
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

        JLabel LabelA = new JLabel("");
        LabelA.setHorizontalAlignment(JTextField.CENTER);
        LabelA.setFont(new Font("Serif", Font.BOLD, 20));
        this.table.add(LabelA);
        JLabel LabelB = new JLabel("ID");
        LabelB.setHorizontalAlignment(JTextField.CENTER);
        LabelB.setFont(new Font("Serif", Font.BOLD, 20));
        this.table.add(LabelB);
        JLabel LabelC = new JLabel("Codename");
        LabelC.setHorizontalAlignment(JTextField.CENTER);
        LabelC.setFont(new Font("Serif", Font.BOLD, 20));
        this.table.add(LabelC);
        JLabel LabelD = new JLabel("");
        LabelD.setHorizontalAlignment(JTextField.CENTER);
        LabelD.setFont(new Font("Serif", Font.BOLD, 20));
        this.table.add(LabelD);
        JLabel LabelE = new JLabel("ID");
        LabelE.setHorizontalAlignment(JTextField.CENTER);
        LabelE.setFont(new Font("Serif", Font.BOLD, 20));
        this.table.add(LabelE);
        JLabel LabelF = new JLabel("Codename");
        LabelF.setHorizontalAlignment(JTextField.CENTER);
        LabelF.setFont(new Font("Serif", Font.BOLD, 20));
        this.table.add(LabelF);

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

        //Bottom box shows controls
        this.bottom = new JPanel(new GridLayout(2,3, 1, 0)); //Layout as BorderLayout
        this.bottom.setPreferredSize(new Dimension(1280, 65));
        JLabel Label1 = new JLabel("Esc:");
        Label1.setHorizontalAlignment(JTextField.CENTER);
        Label1.setFont(new Font("Serif", Font.BOLD, 20));
        JLabel Label2 = new JLabel("F5:");
        Label2.setHorizontalAlignment(JTextField.CENTER);
        Label2.setFont(new Font("Serif", Font.BOLD, 20));
        JLabel Label3 = new JLabel("Enter:");
        Label3.setHorizontalAlignment(JTextField.CENTER);
        Label3.setFont(new Font("Serif", Font.BOLD, 20));
        JLabel Label4 = new JLabel("Exit the program");
        Label4.setHorizontalAlignment(JTextField.CENTER);
        Label4.setFont(new Font("Serif", Font.BOLD, 20));
        JLabel Label5 = new JLabel("Move to Action Screen");
        Label5.setHorizontalAlignment(JTextField.CENTER);
        Label5.setFont(new Font("Serif", Font.BOLD, 20));
        JLabel Label6 = new JLabel("Search Database");
        Label6.setHorizontalAlignment(JTextField.CENTER);
        Label6.setFont(new Font("Serif", Font.BOLD, 20));

        Label1.setVerticalAlignment(JTextField.CENTER);
        Label2.setVerticalAlignment(JTextField.CENTER);
        Label3.setVerticalAlignment(JTextField.CENTER);
        Label4.setVerticalAlignment(JTextField.CENTER);
        Label5.setVerticalAlignment(JTextField.CENTER);
        Label6.setVerticalAlignment(JTextField.CENTER);
        this.bottom.add(Label1);
        this.bottom.add(Label2);
        this.bottom.add(Label3);
        this.bottom.add(Label4);
        this.bottom.add(Label5);
        this.bottom.add(Label6);

        //Add Components to JPanel
        this.add(this.top, BorderLayout.PAGE_START);
        this.add(this.table, BorderLayout.CENTER);
        this.add(this.bottom, BorderLayout.SOUTH);
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
                //If not in the DB add it to the DB
                if(this.DB.getCodename(ID) == null){
                    this.DB.addPlayer(ID, codeName);
                }
            }
            if(!greenIDField[i].getText().isBlank() && !greenNameField[i].getText().isBlank()){
                int ID = Integer.valueOf(greenIDField[i].getText());
                String codeName = greenNameField[i].getText();
                this.DB.players.add(new Player(codeName,ID, false));
                //If not in the DB add it to the DB
                if(this.DB.getCodename(ID) == null){
                    this.DB.addPlayer(ID, codeName);
                }
            }
        }
    }
}
