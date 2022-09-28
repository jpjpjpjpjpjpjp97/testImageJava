import javax.swing.*;
import java.io.IOException;

public class AddPlaceholderImageFrame extends JFrame {
    JPanel imagePanel;
    AddPlaceholderImageFrame() throws IOException {
        imagePanel = new AddPlaceholderImage();
        this.setSize(500,500);
        this.setVisible(true);
        this.add(imagePanel);
    }
}
