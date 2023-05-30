package fourpeople.socute.outfitpal;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.net.URISyntaxException;
import java.net.URI;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ShowImage {
    private String imageUrl;

    public ShowImage(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    void ShowClothesImage() {
        try {
            URI uri = new URI(imageUrl);
            URL url = uri.toURL();
            BufferedImage image = ImageIO.read(url);

            ImageIcon icon = new ImageIcon(image);
            JLabel label = new JLabel(icon);

            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(label);
            frame.pack();
            frame.setVisible(true);
        } 
        catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}