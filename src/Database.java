import java.sql.*;
import java.util.Properties;

public class Database {
        // jdbc:postgresql://<host>:<port>/<dbname>?sslmode=require&user=<username>&password=<password>
    // private static String URL = "jdbc:postgresql://ec2-3-227-195-74.compute-1.amazonaws.com:5432/dd18okmuin3qv3?sslmode=require&user=rnjqwllkcxoxck&password=8542a67352bf54d8d04c068448e7e19628adaa56d96eb04c89d4718c60b79738";
    static Connection connection;

    public Database() throws ClassNotFoundException{
        Class.forName("org.postgresql.Driver");
        final String URL = "jdbc:postgresql://ec2-3-227-195-74.compute-1.amazonaws.com:5432/dcipgblk6rrdcr";
        Properties props = new Properties();
        props.setProperty("user", "bxtjkbtexkvngp");
        props.setProperty("password", "e706d0d5e3a54649823fc52a43efb8e6e3abf611ce0b979eb4b825f6c12ef16f");
        try {
            connection = DriverManager.getConnection(URL, props);
            System.out.println("Connected to Database!");
        } catch (SQLException e) {
            System.out.println("Error in Connecting to DB!");
            e.printStackTrace();
        }
    }

    public String getCodename(int id){
        try {
            Statement query = connection.createStatement();
            ResultSet results = query.executeQuery("SELECT Codename FROM player WHERE Id = " + id + ";");
            if(results.next()){
                return results.getString("Codename");
            } else{
                return "null";
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
            System.out.println("Added Player");
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
