import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
//        JFrame addPlaceholderImageFrame = new ImageFrame();


        ArrayList<PlaceHolder> placeholderCoordinateList = new ArrayList<>();
        placeholderCoordinateList.add(new PlaceHolder(new Point(100,100)));
        placeholderCoordinateList.add(new PlaceHolder(new Point(200,200)));
        placeholderCoordinateList.add(new PlaceHolder(new Point(300,300)));
        placeholderCoordinateList.add(new PlaceHolder(new Point(400,400)));
        JFrame selectPlaceholderImageFrame = new SelectPlaceholderImageFrame(placeholderCoordinateList);



    }
}
