import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPListener {
    DatagramSocket ds = new DatagramSocket(1234);
    byte[] receive = new byte[65535];
    DatagramPacket DpReceive = null;
    Database DB;
    View view;

    public UDPListener(Database db, View view) throws ClassNotFoundException, IOException {
        this.DB = db;
        this.view = view;
    }

    public void run() throws IOException {
        while (true)
        {
            // Step 2 : create a DatgramPacket to receive the data.
            this.DpReceive = new DatagramPacket(receive, receive.length);
    
            // Exit the server if the client sends "bye"
            if (data(receive).toString().equals("bye"))
            {
                System.out.println("Client sent bye.....EXITING");
                break;
            }

            // Step 3 : revieve the data in byte buffer.
            this.ds.receive(DpReceive);
            StringBuilder message = data(receive);
            int[] parsed = messageParser(message);
            Player shootPlayer = this.DB.getPlayerById(parsed[0]);
            Player hitPlayer = this.DB.getPlayerById(parsed[1]);
            this.view.actionScreen.sendKillMessage(shootPlayer, hitPlayer);
            
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

    // parses string data into an integer array
    public int[] messageParser(StringBuilder sb) {
        String message = sb.toString();
        String[] parts = message.split(":");
        int[] ret = {Integer.parseInt(parts[0]), Integer.parseInt(parts[1])};
        return ret;
    }

    public Player[] idToPlayer(int[] temp) {
        Player a = this.DB.getPlayerById(temp[0]);
        Player b = this.DB.getPlayerById(temp[1]);
        Player[] ret = {a,b};
        return ret;
    }
}
