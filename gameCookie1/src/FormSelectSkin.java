import javax.swing.*;
import java.awt.*;

public class FormSelectSkin {

    public void newCreateUI(){
        JFrame newWindow = new JFrame("Skin");
        newWindow.setSize(500,500);
        newWindow.setResizable(false);
        newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newWindow.getContentPane().setBackground(Color.WHITE);
        newWindow.setLayout(null);


        JButton skin1 = new JButton("1");
        ImageIcon cookie = new ImageIcon(getClass().getClassLoader().getResource("cookie.png"));
        skin1.setIcon(cookie);

        newWindow.add(skin1);

        newWindow.setVisible(true);
    }

}
