//Main Application File CSCE 3513 Team 6 Project

//Main method
public class App{
    View view;
    Database DB;
    Boolean gameStarted;
    
    //Constructor 
    public App() throws ClassNotFoundException{
        this.DB = new Database();
        this.view = new View(this.DB);
        this.gameStarted = false;
    }

    //Launch Method
    public void launch(){
        view.launch();
    }
    public static void main(String args[]) throws ClassNotFoundException{
        App app = new App();
        app.launch();
        app.DB.deleteId(3);
        app.DB.deleteId(4);
        app.DB.addPlayer(3, "Spencer");
        app.DB.addPlayer(4, "Justin");
        System.out.println("Getting Player 3: " + app.DB.getCodename(3));
        System.out.println("Getting Player 3: " + app.DB.getCodename(4));
    }

}