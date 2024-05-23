import javax.swing.*;
import java.awt.*;

public class TransparentPanel extends JFrame {

    public TransparentPanel() {
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel transparentPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f)); // Прозрачность 0.5
                g2d.setColor(Color.BLACK);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();

                super.paintComponent(g);
            }

            @Override
            public Dimension getPreferredSize() {
                return getPreferredSize(); // Используем размер переданной панели
            }
        };

        add(transparentPanel);

        setVisible(true);
    }
}
