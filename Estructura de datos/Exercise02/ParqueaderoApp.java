package Exercise02;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import Exercise01.ProgramAesthetics.BackgroundPanel;
import Exercise01.ProgramAesthetics.RoundedPanel;

public class ParqueaderoApp extends JFrame {

    private BackgroundPanel panel;
    private RoundedPanel subpanel;
    private BackgroundPanel panel3;
    private JTextField ingresar;
    private JTextField tipoVehiculo;
    private JTextField hora;
    private JButton login;
    private JMenuBar menu;
    private JMenu menuLeading;

    public ParqueaderoApp() {
        setSize(400, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        intoComponents();
    }

    private void intoComponents() {
        panelMain();
        placeInformation();
        placeButton();
        placeMenu();
    }

    private void panelMain() {
        panel = new BackgroundPanel("Images/FondoMenu.jfif");
        panel.setLayout(null);

        subpanel = new RoundedPanel();
        subpanel.setLayout(null);
        subpanel.setBackground(new Color(3, 72, 79, 200));
        subpanel.setRounded(50, 50);
        subpanel.setBounds(64, 57, 260, 410);

        panel3 = new BackgroundPanel("Images/FondoMenu (2).jfif");
        panel3.setLayout(null);
        panel3.setRounded(50, 50);
        panel3.setBounds(0, 0, 260, 190);

        JTextArea area = new JTextArea();
        area.setBackground(new Color(0, 9, 16));
        area.setBounds(0, 167, 25, 23);

        JTextArea area2 = new JTextArea();
        area2.setBackground(new Color(0, 9, 16));
        area2.setBounds(240, 167, 25, 23);

        subpanel.add(area);
        subpanel.add(area2);
        subpanel.add(panel3);
        panel.add(subpanel);
        this.getContentPane().add(panel);
    }

    private void placeInformation() {
        ingresar = new JTextField("Ingresar la placa");
        ingresar.setFont(new Font("arial", Font.TRUETYPE_FONT, 10));
        ingresar.setBounds(30, 220, 200, 30);
        ingresar.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (ingresar.getText().equals("Ingresar la placa")) {
                    ingresar.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

                if (ingresar.getText().isEmpty()) {
                    ingresar.setText("Ingresar la placa");
                }

            }

        });

        tipoVehiculo = new JTextField("Ingrese el tipo de vehiculo");
        tipoVehiculo.setFont(new Font("arial", Font.TRUETYPE_FONT, 10));
        tipoVehiculo.setBounds(30, 270, 200, 30);

        tipoVehiculo.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tipoVehiculo.getText().equals("Ingrese el tipo de vehiculo")) {
                    tipoVehiculo.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

                if (tipoVehiculo.getText().isEmpty()) {
                    tipoVehiculo.setText("Ingrese el tipo de vehiculo");
                }
            }

        });

        hora = new JTextField("Ingrese la hora 00:00");
        hora.setFont(new Font("arial", Font.TRUETYPE_FONT, 10));
        hora.setBounds(30, 320, 200, 30);
        hora.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (hora.getText().equals("Ingrese la hora 00:00")) {
                    hora.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

                if (hora.getText().isEmpty()) {
                    hora.setText("Ingrese la hora 00:00");
                }
            }

        });

        SwingUtilities.invokeLater(() -> subpanel.requestFocusInWindow());
        subpanel.add(ingresar);
        subpanel.add(tipoVehiculo);
        subpanel.add(hora);
    }

    private void placeButton() {
        login = new JButton("Login");
        login.setFont(new Font("arial", Font.TRUETYPE_FONT, 12));
        login.setBackground(new Color(0, 18, 54));
        login.setForeground(new Color(236, 236, 236, 190));
        login.setBounds(80, 365, 100, 32);
        subpanel.add(login);
    }

    private void placeMenu() {
        menu = new JMenuBar();
        menuLeading = new JMenu("≡ Menu");
        JMenuItem ingresar = new JMenuItem(" ✒ Ingresar");
        JMenuItem tabla = new JMenuItem("⛯ Mostrar tabla");
        JMenuItem vehiculos2 = new JMenuItem("⚬ Vehiculos 2 ruedas");
        JMenuItem vehiculos4 = new JMenuItem("⚬ Vehiculos 4 ruedas");
        JMenuItem parqueadero = new JMenuItem("⚬ Parqueadero");
        JMenuItem eliminar = new JMenuItem("⌫ Eliminar");
        JMenuItem salir = new JMenuItem("⛒ Salir");

        menuLeading.add(ingresar);
        menuLeading.add(tabla);
        menuLeading.add(vehiculos2);
        menuLeading.add(vehiculos4);
        menuLeading.add(parqueadero);
        menuLeading.add(eliminar);
        menuLeading.add(salir);

        menu.add(menuLeading);
        setJMenuBar(menu);
    }
}
