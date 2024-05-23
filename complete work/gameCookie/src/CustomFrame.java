import java.awt.*;
import javax.swing.*;

public class CustomFrame extends JFrame {

    private Image backgroundImage;

    CustomFrame() {
        // Загрузка изображения для фона
        backgroundImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("fon.jpg"));
        prepareWindow();
        setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        });
    }

    private void prepareWindow() {
        setSize(800, 800);
        setTitle("Custom Frame with Background");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
