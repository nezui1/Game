import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerCookie {

    private Timer timer;
    private Entity log;
    private CreateForm form;

    public TimerCookie(Entity log, CreateForm form) {
        this.log = log;
        this.form = form;
    }

    private int calculatingTheMultiplier(int i){
        int[] multiplier = {9,8,7,6,5,4,3,2,1,0, 0};
        return multiplier[i];
    }

    public void buttonClick() {
        if (log.getStepSec() <= 9) {
            if (log.getCookieCounter() - log.getPrice2() >= 0) {

                log.setCookieCounter(log.getCookieCounter() - log.getPrice2());

                int newInterval = 10000 - log.getStepSec() * 1000;

                changeTimerInterval(newInterval);

                log.setCookieCounter(log.getCookieCounter() + (10 - calculatingTheMultiplier(log.getStepSec())));
                form.counterLabel.setText(log.getCookieCounter() + " cookie");



                log.setPrice2(log.getPrice2() * 2);

                form.timerLabel.setText("click per second " + log.getPrice2());

                log.setStepSec(log.getStepSec() + 1);

                form.timerCounterLabel.setText(newInterval/1000 + " second value= " + log.getStepSec());
            }
            else {
                JOptionPane.showMessageDialog(null,"Не хватает печенья");
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"Уровень прокачки максимальный");
        }




    }

    private void changeTimerInterval(int newInterval) {
        if (timer != null && timer.isRunning()) {
            timer.stop();
            timer = null;
        }
        timer = new Timer(newInterval, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                log.setCookieCounter(log.getCookieCounter() + (10 - calculatingTheMultiplier(log.getStepSec())));
                form.counterLabel.setText(log.getCookieCounter() + " cookie");
            }
        });

        timer.start();
    }
}
