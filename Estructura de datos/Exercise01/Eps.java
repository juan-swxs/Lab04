package Exercise01;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class Eps extends JFrame {

    private JPanel panel;
    private JTextField screenNombre;
    private JTextField screenApellido;
    private ImageIcon conteinImage;
    private JLabel animationJLabel;

    public Eps() {
        setBounds(500, 180, 280, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        paneles();
        placeText();
        placeInformation();
    }

    private void paneles() {
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }

    private void placeText() {
        conteinImage = new ImageIcon("Estructura de datos/Images/Timer.jpg");
        Image imagen  = conteinImage.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);

        animationJLabel = new JLabel(new ImageIcon(imagen));
        animationJLabel.setBounds(17, 10, 60, 60); 

        JLabel title = new JLabel("Pedidos");
        title.setFont(new Font("serif", Font.ITALIC, 20));
        title.setBounds(76, 27, 100, 20);

        JLabel subTitle = new JLabel("Complete el siguiente formulario para asignar un turno");
        subTitle.setFont(new Font("serif", Font.ROMAN_BASELINE, 10));
        subTitle.setForeground(Color.LIGHT_GRAY);
        subTitle.setBounds(18, 59, 300, 30);

        JLabel decoration = new JLabel("__________________________________");
        decoration.setForeground(Color.LIGHT_GRAY);
        decoration.setBounds(18, 70, 300, 20);

        JLabel nombreLabel = new JLabel("Nombre");
        nombreLabel.setBounds(17,100, 120, 30);

        JLabel apellidoLabel = new JLabel("Cédula");
        apellidoLabel.setBounds(150, 100, 60, 30);
        
        panel.add(animationJLabel);
        panel.add(title);
        panel.add(decoration);
        panel.add(subTitle);
        panel.add(nombreLabel);
        panel.add(apellidoLabel);
    }

    private void placeInformation(){
        screenNombre = new JTextField();
        screenApellido = new JTextField();
        screenNombre.setBounds(17, 130, 100, 24);
        screenApellido.setBounds(150, 130, 100, 24);
        panel.add(screenNombre);
        panel.add(screenApellido);
    }
}
