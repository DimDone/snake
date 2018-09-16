import javax.swing.*;
import java.awt.*;

public class Graphic extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
            // TODO: - draw sprites
        g.fillRect(0,0,800,600);
    }
}

