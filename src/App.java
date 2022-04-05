//Main Application File CSCE 3513 Team 6 Project
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

//Main method
public class App{
    View view;
    Database DB;

    //Constructor 
    public App() throws ClassNotFoundException{
        this.DB = new Database();
        this.view = new View(this.DB);
    }

    //Launch Method
    public void launch(){
        view.launch();
    }
    public static void main(String args[]) throws ClassNotFoundException, IOException{
        App app = new App();
        app.launch();
        		// Step 1 : Create a socket to listen at port 1234
		DatagramSocket ds = new DatagramSocket(1234);
		byte[] receive = new byte[65535];

		DatagramPacket DpReceive = null;
		while (true)
		{

			// Step 2 : create a DatgramPacket to receive the data.
			DpReceive = new DatagramPacket(receive, receive.length);

			// Step 3 : revieve the data in byte buffer.
			ds.receive(DpReceive);
            StringBuilder message = data(receive);
			System.out.println("Client:-" + message);
            app.view.actionScreen.killTest.setText(message.toString());

			// Exit the server if the client sends "bye"
			if (data(receive).toString().equals("bye"))
			{
				System.out.println("Client sent bye.....EXITING");
				break;
			}

			// Clear the buffer after every message.
			receive = new byte[65535];
		}
    }
	// A utility method to convert the byte array
	// data into a string representation.
	public static StringBuilder data(byte[] a){
		if (a == null)
			return null;
		StringBuilder ret = new StringBuilder();
		int i = 0;
		while (a[i] != 0)
		{
			ret.append((char) a[i]);
			i++;
		}
		return ret;
	}
}
