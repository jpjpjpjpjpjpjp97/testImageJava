import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SelectPlaceholderImage extends JPanel {
    SelectPlaceholderImage(ArrayList<PlaceHolder> placeholderList) throws IOException {
        BufferedImage countryMap = ImageIO.read(new File("country_map.gif"));
        BufferedImage placeholderImage = ImageIO.read(new File("placeholder.png"));
        BufferedImage selectedPlaceholderImage = ImageIO.read(new File("placeholder_selected.png"));
        SelectPlaceholderImagePanel imgPane = new SelectPlaceholderImagePanel(countryMap, placeholderImage, selectedPlaceholderImage);
        imgPane.setPlaceholderList(placeholderList);

        imgPane.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Point panelPoint = e.getPoint();
                Point imgContext = imgPane.toImageContext(panelPoint);
                for (PlaceHolder placeholder : placeholderList) {
                    if (panelPoint.getX() > placeholder.getCoordinates().getX() &&
                            panelPoint.getX() <= placeholder.getCoordinates().getX()+24 &&
                            panelPoint.getY() > placeholder.getCoordinates().getY() &&
                            panelPoint.getY() <= placeholder.getCoordinates().getY()+24){
                        placeholder.setHovered(true);
                    }
                    else {
                        placeholder.setHovered(false);
                    }
                }
                imgPane.repaint();
            }
        });

        imgPane.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Point panelPoint = e.getPoint();
                Point imgContext = imgPane.toImageContext(panelPoint);
                for (PlaceHolder placeholder : placeholderList) {
                    if (panelPoint.getX() > placeholder.getCoordinates().getX() &&
                            panelPoint.getX() <= placeholder.getCoordinates().getX()+24 &&
                            panelPoint.getY() > placeholder.getCoordinates().getY() &&
                            panelPoint.getY() <= placeholder.getCoordinates().getY()+24){
                        System.out.println("Clicked a placeholder.");
                        placeholder.setSelected(true);
                    }
                    else {
                        placeholder.setSelected(false);
                    }
                }
                imgPane.repaint();
            }
        });
        this.add(imgPane);
    }
}
