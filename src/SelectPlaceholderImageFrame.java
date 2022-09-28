import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class SelectPlaceholderImageFrame extends JFrame {
    JPanel imagePanel;
    SelectPlaceholderImageFrame(ArrayList<PlaceHolder> placeholderCoordinateList) throws IOException {
        imagePanel = new SelectPlaceholderImage(placeholderCoordinateList);
        this.add(imagePanel);
        this.setSize(1000,1000);
        this.setVisible(true);
    }
}
