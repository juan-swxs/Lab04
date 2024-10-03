package Exercise01;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Eps extends JFrame {

    private JPanel panel;

    public Eps() {
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        paneles();
    }

    private void paneles() {
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
}
