//Main Application File CSCE 3513 Team 6 Project
import java.io.IOException;

//Main method
public class App{
    View view;
    Database DB;
	UDPListener udp;

    //Constructor 
    public App() throws ClassNotFoundException, IOException{
        this.DB = new Database();
		this.view = new View(this.DB);
		this.udp = new UDPListener(this.DB, this.view);
    }

    //Launch Method
    public void launch(){
        view.launch();
    }
    public static void main(String args[]) throws ClassNotFoundException, IOException {
        App app = new App();
        app.launch();
        // Step 1 : Create a socket to listen at port 1234
		app.udp.run();
    }

}
