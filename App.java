//Main Application File CSCE 3513 Team 6 Project

//Main method
public class App{
    //Constructor 
    public App(){
        Model model = new Model();
        Controller controller = new Controller(model);
        View view = new View(model, controller);
    }
    public static void main(String args[]){
        App app = new App();
    }

}