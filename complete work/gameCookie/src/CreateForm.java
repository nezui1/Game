import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;


public class CreateForm {
    ImageIcon cookie = new ImageIcon(getClass().getClassLoader().getResource("cookie.png"));


    JLabel counterLabel, perSecLabel, curB, oneClick, timerLabel,timerCounterLabel, chanceLabel, chanceLabelPanel;

    public JPanel cookiePanel;
    public JButton cookieButton, chanceButton;
    Font font1,font2;
    Entity log = EntityLoader.loadFromFile("C:/Users/Макс/IdeaProjects/gameCookie/src/data.txt");

    EntityLoader lod = new EntityLoader();
    public void createFont(){
        font1 = new Font("DAMN",Font.PLAIN, 32);
        font2= new Font("DAMN",Font.PLAIN, 15);
    }
    public void createUI(){

        JFrame window = new JFrame();
        window.setSize(800,800);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.WHITE);
        window.setLayout(null);



        cookiePanel = new JPanel();
        cookiePanel.setBounds(30,170,350,350);
        cookiePanel.setBackground(Color.WHITE);
        window.add(cookiePanel);



        cookieButton = new JButton();
        cookieButton.setBackground(Color.WHITE);
        cookieButton.setFocusPainted(false);
        cookieButton.setBorder(BorderFactory.createEmptyBorder());
        cookieButton.setIcon(cookie);
        cookieButton.addActionListener(new CookieHandler(log, this));
        UIManager.put("Button.select", Color.WHITE);
        cookiePanel.add(cookieButton);

        JPanel counterPanel = new JPanel();
        counterPanel.setBounds(80,65,300,50);
        counterPanel.setBackground(Color.WHITE);
        window.add(counterPanel);

        JPanel perSecСounterPanel = new JPanel();
        perSecСounterPanel.setBounds(530,0,200,100);
        perSecСounterPanel.setBackground(Color.white);
        window.add(perSecСounterPanel);



        counterLabel = new JLabel(log.getCookieCounter() + " cookies");
        counterLabel.setForeground(Color.BLACK);
        counterLabel.setFont(font1);
        counterPanel.add(counterLabel);

        perSecLabel =  new JLabel();
        perSecLabel.setForeground(Color.BLACK);
        perSecLabel.setFont(font2);
        counterPanel.add(perSecLabel);

        oneClick = new JLabel("One click = " + log.getStep());
        oneClick.setForeground(Color.BLACK);
        oneClick.setFont(font2);
        perSecСounterPanel.add(oneClick);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(480,170,300,170);
        buttonPanel.setBackground(Color.black);
        window.add(buttonPanel);

        JButton saveButton = new JButton("Save Data");
        saveButton.setBounds(0, 0, 120, 30);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = "C:/Users/Макс/IdeaProjects/gameCookie/src/data.txt";
                saveToFile(filePath);
            }
        });
        window.add(saveButton);

        JButton cursorButton = new JButton();
        cursorButton.setBackground(Color.WHITE);
        cursorButton.setPreferredSize(new Dimension(270,50));
        cursorButton.addActionListener(new AddClickButton(log, this));
        buttonPanel.add(cursorButton);

        curB =  new JLabel("Click " + log.getPrice1());
        curB.setForeground(Color.BLACK);
        curB.setFont(font2);
        cursorButton.add(curB);

        JButton newGameButton = new JButton("New Game");
        newGameButton.setBounds(120, 0, 120, 30);
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.setStep(1);
                log.setPrice3(100);
                log.setPrice2(15);
                log.setPrice1(15);
                log.setPriceImg(10000);
                log.setStepSec(0);
                log.setStepChance(0);
                log.setCookieCounter(0);
                String filePath = "C:/Users/Макс/IdeaProjects/gameCookie/src/data.txt";
                saveToFile(filePath);
                counterLabel.setText(log.getCookieCounter() + " cookies");
                oneClick.setText("One click = " + log.getStep());
                timerLabel.setText("click per second " + log.getPrice2());
                chanceLabel.setText("chance up " + log.getPrice3());
                timerCounterLabel.setText((10000 - log.getStepSec() * 100)/1000 + " second value= " + ((log.getStepSec())) );
                curB.setText("Click " + log.getPrice1());

            }
        });
        window.add(newGameButton);

        JButton anyButton = new JButton();
        anyButton.setBackground(Color.WHITE);
        anyButton.setPreferredSize(new Dimension(270, 50));

        CreateForm thisForm = this;

        anyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TimerCookie timerCookie = new TimerCookie(log, thisForm);
                timerCookie.buttonClick();
            }
        });
        buttonPanel.add(anyButton);

        timerLabel = new JLabel("click per second " + log.getPrice2());
        timerLabel.setForeground(Color.BLACK);
        timerLabel.setFont(font2);
        anyButton.add(timerLabel);

        timerCounterLabel = new JLabel((10000 - log.getStepSec() * 100)/1000 + " second value= " + ((log.getStepSec())) );
        timerCounterLabel.setForeground(Color.BLACK);
        timerCounterLabel.setFont(font2);
        perSecСounterPanel.add(timerCounterLabel);

        chanceButton = new JButton();
        chanceButton.setBackground(Color.WHITE);
        chanceButton.setPreferredSize(new Dimension(270,50));
        chanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChanceAction chance = new ChanceAction(log, thisForm);
                chance.chanceDouble();
            }
        });
        buttonPanel.add(chanceButton);

        chanceLabel = new JLabel("chance up " + log.getPrice3());
        chanceLabel.setForeground(Color.BLACK);
        chanceLabel.setFont(font2);
        chanceButton.add(chanceLabel);


        chanceLabelPanel = new JLabel("chanse x2 = " + ((log.getStepChance()* 100/(3 + log.getStepChance())) ) + "%");
        chanceLabelPanel.setForeground(Color.BLACK);
        chanceLabelPanel.setFont(font2);
        perSecСounterPanel.add(chanceLabelPanel);

//        JButton selectIcon = new JButton("Random skin = 10000");
//        selectIcon.setBackground(Color.WHITE);
//        selectIcon.setPreferredSize(new Dimension(270,50));
//        selectIcon.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//        buttonPanel.add(selectIcon);


        window.setVisible(true);
    }


    public void saveToFile(String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(String.valueOf("step=" + log.getStep()) + "\n");
            writer.write(String.valueOf("stepSec=" + log.getStepSec()) + "\n");
            writer.write(String.valueOf("stepSec=" + log.getStepChance()) + "\n");
            writer.write(String.valueOf("cookieCounter=" + log.getCookieCounter()) + "\n");
            writer.write(String.valueOf("price1=" + log.getPrice1()) + "\n");
            writer.write(String.valueOf("price2=" + log.getPrice2()) + "\n");
            writer.write(String.valueOf("price3=" + log.getPrice3()) + "\n");
            writer.write(String.valueOf("priceImg=" + log.getPriceImg()) + "\n");

            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

}
