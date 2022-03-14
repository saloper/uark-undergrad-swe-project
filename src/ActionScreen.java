import javax.swing.*;
import java.awt.*;

public class ActionScreen extends JPanel {

    JPanel teamsAndScores;
    JPanel killFeed;
    // teamsAndScores displays the team color along with the top 3 players and their scores for each team.
    // killFeed is the panel which will hold the scrolling text kill feed and will display a message when one player tags another.

    JLabel redTeamScore, greenTeamScore;
<<<<<<< Updated upstream
    // Variables for the top 3 players and their scores for each team. I couldn't find a simpler way to do this than to have a variable for each placement and score
    // so that they can be modified individually when updating scores. Perhaps a more streamlined solution will come later.

    public ActionScreen(){
        this.setLayout(new BorderLayout(0, 20));
=======
    JLabel remainingTime1, remainingTime2;

    JLabel redPlayers[];
    JLabel redPlayerScores[];
    JLabel greenPlayers[];
    JLabel greenPlayerScores[];
    // Arrays for the players of each team and their scores.

    public ActionScreen(Database DB){
        this.DB = DB;
        redPlayers = new JLabel[15];
        redPlayerScores = new JLabel[15];
        greenPlayers = new JLabel[15];
        greenPlayerScores = new JLabel[15];
        
        this.setLayout(new BorderLayout(0, 0));
>>>>>>> Stashed changes
        this.setBackground(Color.BLACK);
        teamsAndScores = new JPanel(new GridLayout(0, 5, 10, 0));
        teamsAndScores.setBackground(Color.BLACK);
        // The teamsAndScores panel will be a grid which will contain the team names and the top scoring players. The grid has 6 columns, some of which will be blank.
        
        JLabel redTeamName = new JLabel("Red Team");
        setLabelValues(redTeamName, 1);
        
        this.teamsAndScores.add(new JLabel());
        this.teamsAndScores.add(new JLabel()); // These represent empty spaces in the grid columns.

        JLabel greenTeamName = new JLabel("Green Team");
        setLabelValues(greenTeamName, 1);
        greenTeamName.setForeground(Color.GREEN);

        this.teamsAndScores.add(new JLabel()); // Space

        for (int i = 0; i < 15; i++){
            JLabel redPlayer = new JLabel("--------");
            JLabel redScore = new JLabel("0000");
            setLabelValues(redPlayer, 2);
            setLabelValues(redScore, 2);

            redPlayers[i] = redPlayer;
            redPlayerScores[i] = redScore;
            
            this.teamsAndScores.add(new JLabel()); // Space

            JLabel greenPlayer = new JLabel("--------");
            JLabel greenScore = new JLabel("0000");
            setLabelValues(greenPlayer, 2);
            setLabelValues(greenScore, 2);

            greenPlayers[i] = greenPlayer;
            greenPlayerScores[i] = greenPlayer;
        }
        // Adding players for each team and their scores.

        for (int i = 0; i < 5; i++) { this.teamsAndScores.add(new JLabel()); } // adding a bunch of spaces in a row without copypasting lines.
        this.teamsAndScores.add(new JLabel()); // Space
        redTeamScore = new JLabel("0000");
        setLabelValues(redTeamScore, 2);

        this.teamsAndScores.add(new JLabel()); // Space
        this.teamsAndScores.add(new JLabel()); // Space

        greenTeamScore = new JLabel("0000");
        setLabelValues(greenTeamScore, 2);
        // These are the total scores for each team which are displayed at the bottom of the grid layout.

        killFeed = new JPanel();
        killFeed.setBackground(Color.DARK_GRAY);
        // The kill feed will go in its own border layout section and will house the scrolling text which is displayed when players tag one another.

        this.add(this.teamsAndScores, BorderLayout.PAGE_START);
        this.add(this.killFeed, BorderLayout.CENTER);
    }

    private void setLabelValues(JLabel label, int type){
        switch (type) {
            case 1:
                label.setPreferredSize(new Dimension(480, 25));
                label.setFont(new Font("Serif", Font.BOLD, 30));
                label.setForeground(Color.RED);
                label.setHorizontalAlignment(JLabel.LEFT);
                this.teamsAndScores.add(label);
                break;
            case 2:
                label.setForeground(Color.WHITE);
                label.setHorizontalAlignment(JLabel.LEFT);
                label.setFont(new Font("Serif", Font.BOLD, 16));
                this.teamsAndScores.add(label);
                break;
            default:
                break;
        }
    }
    // This method prevents having to copy and paste the same lines over and over for each JLabel text.

    public void sendKillMessage(Player killer, Player killed){
        // Display a message on the kill feed that says something like "killer tagged killed
    }

    public void updateRedTeamScore(int score){
        redTeamScore.setText(Integer.toString(score));
    }

    public void updateGreenTeamScore(int score){
        greenTeamScore.setText(Integer.toString(score));
    }

<<<<<<< Updated upstream
    public void updateScoreboard(String playerName, int score, int placement, boolean isRed){
        switch (placement) {
            case 1:
                if (isRed){
                    redFirstPlaceName.setText(playerName);
                    redFirstPlaceScore.setText(Integer.toString(score));
                }
                else{
                    greenFirstPlaceName.setText(playerName);
                    greenFirstPlaceScore.setText(Integer.toString(score));
                }
                break;
            case 2:
                if (isRed){
                    redSecondPlaceName.setText(playerName);
                    redSecondPlaceScore.setText(Integer.toString(score));
                }
                else{
                    greenSecondPlaceName.setText(playerName);
                    greenSecondPlaceScore.setText(Integer.toString(score));
                }
                break;
            case 3:
                if (isRed){
                    redThirdPlaceName.setText(playerName);
                    redThirdPlaceScore.setText(Integer.toString(score));
                }
                else{
                    greenThirdPlaceName.setText(playerName);
                    greenThirdPlaceScore.setText(Integer.toString(score));
                }
                break;
        
            default:
                break;
        }
    }
    // For updating top 3 scoring players for each team.
    // Can be changed to accept a Player object instead of typing in individual values if the Player class is designed to include current scores for each game.
}
=======
    public void setTimer() {
        //Utilizes Java's timer and TimerTask classes
        //0 is the delay in beginning the timer, 1000 is the period in which the timer updates (in ms)
        Timer timer = new Timer();
        timer.schedule(new beginTimer(), 0, 1000);
    }

    class beginTimer extends TimerTask {
        //Initialize warning timer to 0 minutes, 30 seconds
        int seconds = 30;
        int minutes = 0;
        boolean gameStarted = false;
        public void run() {

            //Reduce "minutes" by 1 if the game has started and there's more than 60 seconds left
            if (seconds == 0 && gameStarted && minutes != 0) {
                seconds = 59;
                minutes--;
            }

            //End the game if it has started and both minutes and seconds are 0
            if (seconds == 0 && gameStarted && minutes == 0) {
                cancel();
            }

            //If the game has not started and both minutes and seconds are zero, start the game
            if (seconds == 0 && !gameStarted) {
                remainingTime1.setText("Time Remaining: ");
                seconds = 0;
                minutes = 6;
                gameStarted = true;
            }

            //"%02d" converts (for example) "5" to "05" for formatting purposes
            String s = String.format("%02d", seconds);
            String m = Integer.toString(minutes);
            remainingTime2.setText(m + ":" + s);
            if (seconds > 0)
                seconds--;
        }
    }

    public void onLoad(){
        
        int redIndex = 0;
        int greenIndex = 0;
        for(int i = 0; i < this.DB.players.size(); i++){
            
            var player = this.DB.players.get(i);
            if (player.isRedTeam){
                redPlayers[redIndex].setText(player.getName());
                redIndex++;
            }
            else{
                greenPlayers[greenIndex].setText(player.getName());
                greenIndex++;
            }
            // This takes players from the player arraylist from the database and adds them to each team's playerlist.

            System.out.println("Getting player from DB: " + player);
            // Printing to show that names are gathered correctly.
        }
    }
}
>>>>>>> Stashed changes
