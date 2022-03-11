import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class ActionScreen extends JPanel {
    Database DB;
    JPanel teamsAndScores;
    JPanel killFeed;
    JPanel countdownTimer;
    // teamsAndScores displays the team color along with the top 3 players and their scores for each team.
    // killFeed is the panel which will hold the scrolling text kill feed and will display a message when one player tags another.

    JLabel redThirdPlaceName, redSecondPlaceName, redFirstPlaceName, greenThirdPlaceName, greenSecondPlaceName, greenFirstPlaceName;
    JLabel redThirdPlaceScore, redSecondPlaceScore, redFirstPlaceScore, greenThirdPlaceScore, greenSecondPlaceScore, greenFirstPlaceScore;
    JLabel redTeamScore, greenTeamScore;
    JLabel remainingTime1, remainingTime2;
    // Variables for the top 3 players and their scores for each team. I couldn't find a simpler way to do this than to have a variable for each placement and score
    // so that they can be modified individually when updating scores. Perhaps a more streamlined solution will come later.

    public ActionScreen(Database DB){
        this.DB = DB;

        
        this.setLayout(new BorderLayout(0, 20));
        this.setBackground(Color.BLACK);
        teamsAndScores = new JPanel(new GridLayout(0, 5, 10, 10));
        teamsAndScores.setBackground(Color.BLACK);
        // The teamsAndScores panel will be a grid which will contain the team names and the top scoring players. The grid has 6 columns, some of which will be blank.
        
        JLabel redTeamName = new JLabel("Red Team");
        setLabelValues(redTeamName, 1);
        
        this.teamsAndScores.add(new JLabel());
        this.teamsAndScores.add(new JLabel()); // These represent empty spaces in the grid columns.

        JLabel greenTeamName = new JLabel("Green Team");
        setLabelValues(greenTeamName, 1);
        greenTeamName.setForeground(Color.GREEN);

        this.teamsAndScores.add(new JLabel());

        // ======================
        // Team high scores below
        // ======================

        redFirstPlaceName = new JLabel("RED FIRST PLACE");
        setLabelValues(redFirstPlaceName, 2);
        redFirstPlaceScore = new JLabel("0000");
        setLabelValues(redFirstPlaceScore, 2);

        this.teamsAndScores.add(new JLabel());

        greenFirstPlaceName = new JLabel("GREEN FIRST PLACE");
        setLabelValues(greenFirstPlaceName, 2);
        greenFirstPlaceScore = new JLabel("0000");
        setLabelValues(greenFirstPlaceScore, 2);

        redSecondPlaceName = new JLabel("RED SECOND PLACE");
        setLabelValues(redSecondPlaceName, 2);
        redSecondPlaceScore = new JLabel("0000");
        setLabelValues(redSecondPlaceScore, 2);

        this.teamsAndScores.add(new JLabel());

        greenSecondPlaceName = new JLabel("GREEN SECOND PLACE");
        setLabelValues(greenSecondPlaceName, 2);
        greenSecondPlaceScore = new JLabel("0000");
        setLabelValues(greenSecondPlaceScore, 2);

        redThirdPlaceName = new JLabel("RED THIRD PLACE");
        setLabelValues(redThirdPlaceName, 2);
        redThirdPlaceScore = new JLabel("0000");
        setLabelValues(redThirdPlaceScore, 2);

        this.teamsAndScores.add(new JLabel());

        greenThirdPlaceName = new JLabel("GREEN THIRD PLACE");
        setLabelValues(greenThirdPlaceName, 2);
        greenThirdPlaceScore = new JLabel("0000");
        setLabelValues(greenThirdPlaceScore, 2);

        // ======================
        // Team High Scores Above
        // ======================

        for (int i = 0; i < 5; i++) { this.teamsAndScores.add(new JLabel()); } // adding a bunch of spaces in a row without copypasting lines.
        this.teamsAndScores.add(new JLabel());
        redTeamScore = new JLabel("0000");
        setLabelValues(redTeamScore, 2);

        this.teamsAndScores.add(new JLabel());
        this.teamsAndScores.add(new JLabel());

        greenTeamScore = new JLabel("0000");
        setLabelValues(greenTeamScore, 2);
        // These are the total scores for each team which are displayed at the bottom of the grid layout.

        killFeed = new JPanel();
        killFeed.setBackground(Color.DARK_GRAY);
        // The kill feed will go in its own border layout section and will house the scrolling text which is displayed when players tag one another.

        //Create bottom-aligned panel for the timer
        countdownTimer = new JPanel();
        countdownTimer.setBackground(Color.BLACK);
        countdownTimer.setPreferredSize(new Dimension(1280,70));

        //Initial text will be "Game begins in," indicating it is the warning timer.
        remainingTime1 = new JLabel("Game Begins In: ");
        remainingTime1.setFont(new Font("Serif", Font.BOLD, 35));
        remainingTime1.setHorizontalAlignment(JLabel.RIGHT);
        remainingTime1.setForeground(Color.WHITE);

        //Numerical time value
        remainingTime2 = new JLabel("0:00");
        remainingTime2.setFont(new Font("Serif", Font.BOLD, 35));
        remainingTime2.setHorizontalAlignment(JLabel.RIGHT);
        remainingTime2.setForeground(Color.WHITE);

        countdownTimer.add(remainingTime1);
        countdownTimer.add(remainingTime2);

        this.add(this.teamsAndScores, BorderLayout.PAGE_START);
        this.add(this.killFeed, BorderLayout.CENTER);
        this.add(this.countdownTimer, BorderLayout.SOUTH);
    }

    private void setLabelValues(JLabel label, int type){
        switch (type) {
            case 1:
                label.setPreferredSize(new Dimension(480, 50));
                label.setFont(new Font("Serif", Font.BOLD, 40));
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

    // For updating top 3 scoring players for each team.
    // Can be changed to accept a Player object instead of typing in individual values if the Player class is designed to include current scores for each game.
    public void onLoad(){
        //print to show you the data input
        for(int i = 0; i < this.DB.players.size(); i++){
            System.out.println(this.DB.players.get(i));
        }
    }
}