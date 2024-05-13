import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CookieMain{

    JLabel counterLabel, perSecLabel, curB, oneClick;

    JButton cursorButton;
    Font font1,font2;
    int cookieCounter;
    int step = 1;
    int price1 = 15;
    int price2 = 15;


    CookieHandler cHandler = new CookieHandler();

    ClickButton cButton = new ClickButton();


    public static void main(String[] args){
    new CookieMain();
    }
    public CookieMain(){
        cookieCounter = 0;

        createFont();

        createUI();
    }

    public void createFont(){
        font1 = new Font("DAMN",Font.PLAIN, 32);
        font2= new Font("DAMN",Font.PLAIN, 15);
    }

    public void createUI(){
        JFrame window = new JFrame();
        window.setSize(800,800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.WHITE);
        window.setLayout(null);

        JPanel cookiePanel = new JPanel();
        cookiePanel.setBounds(0,170,360,359);
        cookiePanel.setBackground(Color.WHITE);
        window.add(cookiePanel);

        ImageIcon cookie = new ImageIcon(getClass().getClassLoader().getResource("cookie360.png"));
        JButton cookieButton = new JButton();
        cookieButton.setBackground(Color.WHITE);
        cookieButton.setFocusPainted(false);
        cookiePanel.setBorder(null);
        cookieButton.setIcon(cookie);
        cookieButton.addActionListener(cHandler);
        cookiePanel.add(cookieButton);

        JPanel counterPanel = new JPanel();
        counterPanel.setBounds(100,100,200,100);
        counterPanel.setBackground(Color.WHITE);
        window.add(counterPanel);



        counterLabel = new JLabel(cookieCounter + " cookies");
        counterLabel.setForeground(Color.BLACK);
        counterLabel.setFont(font1);
        counterPanel.add(counterLabel);

        perSecLabel =  new JLabel();
        perSecLabel.setForeground(Color.BLACK);
        perSecLabel.setFont(font2);
        counterPanel.add(perSecLabel);

        oneClick = new JLabel("One click = " + step);
        oneClick.setForeground(Color.BLACK);
        oneClick.setFont(font2);
        counterPanel.add(oneClick);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(480,170,300,400);
        buttonPanel.setBackground(Color.black);
        window.add(buttonPanel);



        JButton cursorButton = new JButton();
        cursorButton.setBackground(Color.WHITE);
        cursorButton.setPreferredSize(new Dimension(270,50));
        cursorButton.addActionListener(cButton);
        //cursorButton.setText("Cursor " + price1);

        buttonPanel.add(cursorButton);

        curB =  new JLabel("Click " + price1);
        curB.setForeground(Color.BLACK);
        curB.setFont(font2);
        cursorButton.add(curB);

        JButton anyButton = new JButton("1");
        anyButton.setBackground(Color.WHITE);
        anyButton.setPreferredSize(new Dimension(270,50));
        anyButton.addActionListener(cButton);
        buttonPanel.add(anyButton);

        window.setVisible(true);
    }

    public  class CookieHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cookieCounter += step;
            counterLabel.setText(cookieCounter + " cookie");
        }

    }

    public class ClickButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(step < 10) {
                if (cookieCounter - price1 >= 0) {
                    cookieCounter -= price1;
                    step++;
                    price1 *= 2;
                    counterLabel.setText(cookieCounter + " cookie");
                    curB.setText("Click " + price1);
                    oneClick.setText("One click= " + step);
                }
            }
            if (step == 10){
                curB.setText("Click MAX");
            }
        }
    }


}