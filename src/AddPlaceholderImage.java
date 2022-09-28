import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AddPlaceholderImage extends JPanel {
    AddPlaceholderImage() throws IOException {
        BufferedImage countryMap = ImageIO.read(new File("country_map.gif"));
//        BufferedImage placeholder = ImageIO.read(new File("placeholder.png"));
        BufferedImage selectedPlaceholder = ImageIO.read(new File("placeholder_selected.png"));
        AddPlaceholderImagePanel imgPane = new AddPlaceholderImagePanel(countryMap, selectedPlaceholder);
        imgPane.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Point panelPoint = e.getPoint();
                Point imgContext = imgPane.toImageContext(panelPoint);

                System.out.println("You clicked at " + panelPoint + " which is relative to the image " + imgContext);
                imgPane.setSelectedXComponent((int) panelPoint.getX());
                imgPane.setSelectedYComponent((int) panelPoint.getY());
                imgPane.repaint();
            }
        });
        this.add(imgPane);
    }

}