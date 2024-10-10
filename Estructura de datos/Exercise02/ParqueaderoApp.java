package Exercise02;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingUtilities;
import Exercise01.ProgramAesthetics.BackgroundPanel;
import Exercise01.ProgramAesthetics.RoundedPanel;

public class ParqueaderoApp extends JFrame {

    private BackgroundPanel panel;
    private RoundedPanel subpanel;
    private JPanel panelSettings;
    private JPanel panelTabla;
    private CardLayout cardLayout;
    private BackgroundPanel panel3;
    private JTextField ingresar;
    private JComboBox<String> tipoVehiculo;
    private JTextField hora;
    private JButton login;
    private JMenuBar menu;
    private JMenu menuLeading;
    private JTable table;
    private DefaultTableModel tableModel;
    private ArrayList<VehicleEntry> vehiculos;
    private int turno = 0;

    public ParqueaderoApp() {
        setSize(400, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        vehiculos = new ArrayList<>();
        intoComponents();
    }

    private void intoComponents() {
        panelMain();
        placeInformation();
        placeButton();
        placeMenu();
        placeTabla();
    }

    private void panelMain() {
        panelSettings = new JPanel();
        cardLayout = new CardLayout();
        panelSettings.setLayout(cardLayout);

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

        panelTabla = new JPanel();
        panelTabla.setLayout(null);

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
        panelSettings.add(panel, "ingresoDatos");
        panelSettings.add(panelTabla, "mostrarTabla");
        this.getContentPane().add(panelSettings);
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

        tipoVehiculo = new JComboBox<>(new String[] {"Bicicleta", "Ciclomotores","Motocicletas","Carros"});
        tipoVehiculo.setEditable(true);
        tipoVehiculo.setFont(new Font("arial", Font.TRUETYPE_FONT, 10));
        tipoVehiculo.getEditor().setItem("Eliga el tipo de vehiculo");
        tipoVehiculo.setBounds(30, 270, 200, 30);

        tipoVehiculo.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tipoVehiculo.getEditor().getItem().equals("Ingrese el tipo de vehiculo")) {
                    tipoVehiculo.getEditor().setItem("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

                if (tipoVehiculo.getEditor().getItem().equals("")) {
                    tipoVehiculo.getEditor().setItem("Ingrese el tipo de vehiculo");
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
        login.addActionListener(e -> {
            turno++;
            parkingEntrance();
        });
        subpanel.add(login);
    }

    private void placeMenu() {
        menu = new JMenuBar();
        menuLeading = new JMenu("≡ Menu");
        JMenuItem ingresar = new JMenuItem(" ✒ Ingresar");
        ingresar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelSettings, "ingresoDatos");
            }

        });
        JMenuItem tabla = new JMenuItem("⛯ Mostrar tabla");
        tabla.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelSettings, "mostrarTabla");
            }

        });
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

    private void placeTabla() {
        String[] columns = {"Placa", "Tipo", "Hora", "N° Vehiculo", "Valor"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 0, 365, 400);
        panelTabla.add(scrollPane);
    }

    private void parkingEntrance() {
        String placa = ingresar.getText();
        String tipoVh = (String) tipoVehiculo.getSelectedItem();
        String horaEntrada = hora.getText();

        if (placa.equals("Ingresar la placa") || tipoVh.equals("Ingrese el tipo de vehiculo")
                || horaEntrada.equals("Ingrese la hora 00:00")) {

            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        VehicleEntry vehicle = new VehicleEntry(placa, tipoVh, horaEntrada);
        vehiculos.add(vehicle);

        if (!vehiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Datos ingresados con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }

        tableModel.addRow(new Object[] {vehicle.getPlaca() ,vehicle.getTipo(), vehicle.getHora(), turno});
    }
}
