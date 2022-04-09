import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class Database {
        // jdbc:postgresql://<host>:<port>/<dbname>?sslmode=require&user=<username>&password=<password>
    // private static String URL = "jdbc:postgresql://ec2-3-227-195-74.compute-1.amazonaws.com:5432/dd18okmuin3qv3?sslmode=require&user=rnjqwllkcxoxck&password=8542a67352bf54d8d04c068448e7e19628adaa56d96eb04c89d4718c60b79738";
    static Connection connection;
    ArrayList<Player> players;


    public Database() throws ClassNotFoundException{
        Class.forName("org.postgresql.Driver");
        final String URL = "jdbc:postgresql://ec2-3-209-61-239.compute-1.amazonaws.com:5432/d89f0meqop9uuh";
        Properties props = new Properties();
        props.setProperty("user", "fvsijkxxrevzgi");
        props.setProperty("password", "3fde3041a3662e090f8706bb853ef2fb2bfb1e8f8bc03f870c3d06493b89a44e");
        try {
            connection = DriverManager.getConnection(URL, props);
            System.out.println("Connected to Database!");
        } catch (SQLException e) {
            System.out.println("Error in Connecting to DB!");
            e.printStackTrace();
        }
        players = new ArrayList<Player>();
    }

    // looks through players array list and finds the one with correct id, otherwise return a -1 id'd player
    public Player getPlayerById(int id) {
        if (players.size() > 0) {
            for (int i = 0; i < players.size(); i++) { 		      
                if(players.get(i).id == id) {
                    return players.get(i);
                }
           }
        }
        return new Player("unknown player", -1, false);
    }

    public String getCodename(int id){
        try {
            Statement query = connection.createStatement();
            ResultSet results = query.executeQuery("SELECT Codename FROM player WHERE Id = " + id + ";");
            if(results.next()){
                return results.getString("Codename");
            } else{
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Query failed to execute!");
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean addPlayer(int id, String Codename){
        try {
            PreparedStatement add = connection.prepareStatement("INSERT INTO player(Id, Codename) VALUES(?,?);");
            add.setInt(1, id);
            add.setString(2, Codename);
            add.executeUpdate();
            add.close();
            System.out.println("Added Player " + Codename);
            return true;
        } catch (SQLException e) {
            System.out.println("Could not add Player");
            e.printStackTrace();
            return false;
        }
    }

    public void deleteId(int id){
        try {
            PreparedStatement delete = connection.prepareStatement("DELETE FROM player WHERE Id = ?;");
            delete.setInt(1, id);
            delete.executeUpdate();
            delete.close();
            System.out.println("Deleted Player");
        } catch (SQLException e) {
            System.out.println("Could not add Player");
            e.printStackTrace();
        }
    }
}
