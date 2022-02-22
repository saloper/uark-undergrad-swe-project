import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;

//Class to hold the Splat Screen
public class SplatScreen extends JPanel{

    public SplatScreen(){
        //Set the Layout
        this.setLayout(new BorderLayout());
        //Add Image
        try {
            BufferedImage logo = ImageIO.read(new File("splat.jpg"));
            JLabel logoLabel = new JLabel(new ImageIcon(logo));
            this.add(logoLabel, BorderLayout.CENTER);
        } catch (IOException e) {
            System.out.println("Splat logo failed to load");
            e.printStackTrace();
        }

    }
}
