import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CookieHandler implements ActionListener {

    private int originalWidth;
    private int originalHeight;
    Entity log;
    CreateForm form;

    ChanceAction chance;

    public CookieHandler(Entity log, CreateForm form) {
        this.form = form;
        this.log = log;
        this.chance = new ChanceAction(log, form);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (originalWidth == 0 || originalHeight == 0) {
            originalWidth = form.cookie.getIconWidth();
            originalHeight = form.cookie.getIconHeight();
        }

        int newWidth = form.cookie.getIconWidth() - 70;
        int newHeight = form.cookie.getIconHeight() - 70;

        if (form.cookie.getIconWidth() != originalWidth || form.cookie.getIconHeight() != originalHeight) {
            form.cookie.setImage(form.cookie.getImage().getScaledInstance(originalWidth, originalHeight, Image.SCALE_DEFAULT));
            form.cookieButton.setIcon(form.cookie);
        } else {
            form.cookie.setImage(form.cookie.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT));
            form.cookieButton.setIcon(form.cookie);
        }

        if (log.getStepChance() > 0) {
            log.setCookieCounter(log.getCookieCounter() + (log.getStep() * chance.kefChange()));
            form.counterLabel.setText(log.getCookieCounter() + " cookie");
        } else {
            log.setCookieCounter(log.getCookieCounter() + log.getStep());
            form.counterLabel.setText(log.getCookieCounter() + " cookie");
        }
    }
}
