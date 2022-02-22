//Main Application File CSCE 3513 Team 6 Project

//Main method
public class App{
    //Class Variables
    Model model;
    Controller controller;
    View view;

    //Constructor 
    public App(){
        this.model = new Model();
        this.controller = new Controller(model);
        this.view = new View(model, controller);
    }

    //Launch Method
    public void launch(){
        view.launch();
    }
    public static void main(String args[]){
        App app = new App();
        app.launch();
    }

}