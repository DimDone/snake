import javax.swing.*;

public class Window extends JFrame {
    Window() {
        setVisible(true);
        setBounds(128,128,800,600);
        setTitle("Snake Game");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
