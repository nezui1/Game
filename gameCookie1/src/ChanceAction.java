import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class ChanceAction {

    private Entity log;

    private CreateForm form;
    Random random;
    int range;

    public  ChanceAction(Entity log, CreateForm form){
        this.log = log;
        this.form = form;
        this.random = new Random();
        this.range = range;
    }



    public void chanceDouble() {
        if (log.getStepChance() < 6 && range < 10) {
            if (log.getCookieCounter() - log.getPrice3() >= 0) {
                log.setCookieCounter(log.getCookieCounter() - log.getPrice3());
                form.counterLabel.setText(log.getCookieCounter() + " cookie");
                log.setStepChance(log.getStepChance() + 1);
                log.setPrice3(log.getPrice3() * 2);
                form.chanceLabel.setText("chance up " + log.getPrice3());
                form.chanceLabelPanel.setText("chanse x2 = " + ((log.getStepChance()* 100/(3 + log.getStepChance())) ) + "%");
            }
        }else {
            JOptionPane.showMessageDialog(null,"Уровень прокачки максимальный");
        }
    }
    public int kefChange(){
        int kef = 0;
        range = 4 + log.getStepChance();
        int[] chance = {1, 1, 1, 2, 2, 2, 2, 2, 2, 2};
        kef = chance[random.nextInt(0,range)];
        return kef;
    }

}
