import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClickButton implements ActionListener {
    Entity log;
    CreateForm form;

    public AddClickButton(Entity cnst, CreateForm form) {
        this.log = cnst;
        this.form = form;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (log.getStep() < 10) {
            if (log.getCookieCounter() - log.getPrice1() >= 0) {
                log.setCookieCounter(log.getCookieCounter() - log.getPrice1()); ;
                log.setStep(log.getStep() + 1);
                log.setPrice1(log.getPrice1() * 2);
                form.counterLabel.setText(log.getCookieCounter() + " cookie");
                form.curB.setText("Click " + log.getPrice1());
                form.oneClick.setText("One click= " + log.getStep());
            }
            else {
                JOptionPane.showMessageDialog(null,"Не хватает печенья");
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"Уровень прокачки максимальный");
        }

        if (log.getStep() == 10) {
            form.curB.setText("Click MAX");
        }
    }
}
