import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class AddPlaceholderImagePanel extends JPanel {

    private BufferedImage countryMap;
    private BufferedImage selectedPlaceholder;
    int selectedXComponent;
    int selectedYComponent;

    public AddPlaceholderImagePanel(BufferedImage countryMap, BufferedImage selectedPlaceholder) {
        this.countryMap = countryMap;
        this.selectedPlaceholder = selectedPlaceholder;
        selectedXComponent = 0;
        selectedYComponent = 0;
    }

    public int getSelectedXComponent() {
        return selectedXComponent;
    }

    public void setSelectedXComponent(int selectedXComponent) {
        this.selectedXComponent = selectedXComponent;
    }

    public int getSelectedYComponent() {
        return selectedYComponent;
    }

    public void setSelectedYComponent(int selectedYComponent) {
        this.selectedYComponent = selectedYComponent;
    }

    @Override
    public Dimension getPreferredSize() {
        return countryMap == null ? super.getPreferredSize() : new Dimension(countryMap.getWidth(), countryMap.getHeight());
    }

    protected Point getImageLocation() {

        Point p = null;
        if (countryMap != null) {
            int x = (getWidth() - countryMap.getWidth()) / 2;
            int y = (getHeight() - countryMap.getHeight()) / 2;
            p = new Point(x, y);
        }
        return p;

    }

    protected Point getSelectedPoint() {

        Point p = null;
        if (countryMap != null) {
            int x = (getWidth() - countryMap.getWidth()) / 2;
            int y = (getHeight() - countryMap.getHeight()) / 2;
            p = new Point(x, y);
        }
        return p;

    }

    public Point toImageContext(Point p) {
        Point imgLocation = getImageLocation();
        Point relative = new Point(p);
        relative.x -= imgLocation.x;
        relative.y -= imgLocation.y;
        return relative;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (countryMap != null) {
            Point p = getImageLocation();
            Point selectedPoint = getSelectedPoint();
            g.drawImage(countryMap, p.x, p.y, this);
            g.drawImage(selectedPlaceholder, getSelectedXComponent(), getSelectedYComponent(), this);
        }
    }

}
