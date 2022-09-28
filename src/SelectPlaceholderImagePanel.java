import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SelectPlaceholderImagePanel extends JPanel {

    private BufferedImage countryMap;
    private BufferedImage placeholderImage;
    private BufferedImage selectedPlaceholderImage;
    ArrayList<PlaceHolder> placeholderList;

    public SelectPlaceholderImagePanel(BufferedImage countryMap, BufferedImage placeholderImage, BufferedImage selectedPlaceholderImage) {
        this.countryMap = countryMap;
        this.placeholderImage = placeholderImage;
        this.selectedPlaceholderImage = selectedPlaceholderImage;
    }

    public ArrayList<PlaceHolder> getPlaceholderList() {
        return placeholderList;
    }

    public void setPlaceholderList(ArrayList<PlaceHolder> placeholderList) {
        this.placeholderList = placeholderList;
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
            JToolTip toolTip = this.createToolTip();
            g.drawImage(countryMap, p.x, p.y, this);
            for (PlaceHolder placeholder : placeholderList) {
                if (placeholder.isSelected()){
                    g.drawImage(this.selectedPlaceholderImage, (int) placeholder.getCoordinates().getX(), (int) placeholder.getCoordinates().getY(), this);
                }
                else {
                    g.drawImage(this.placeholderImage, (int) placeholder.getCoordinates().getX(), (int) placeholder.getCoordinates().getY(), this);
                }

                if (placeholder.isHovered()){
                    this.setToolTipText(String.format("Branch location: %s, %s\n", placeholder.getCoordinates().getX(), placeholder.getCoordinates().getY()));
                    toolTip.setLocation((int) placeholder.getCoordinates().getX()+24, (int) placeholder.getCoordinates().getY()+24);
                    this.add(toolTip);
                }
                else{
                    toolTip.setVisible(false);
                }
            }
        }
    }
}
