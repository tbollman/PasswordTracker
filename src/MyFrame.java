import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    int frameWidth = 600;
    int frameHeight = 600;
    public MyFrame() {
        this.setTitle("PasswordVault");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(frameWidth, frameHeight);

        ImageIcon logo = new ImageIcon("logo.png");
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(new Color(135, 134, 129));
        this.setVisible(true);
    }
}
