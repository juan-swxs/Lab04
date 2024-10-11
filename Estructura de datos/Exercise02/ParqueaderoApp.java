package Exercise02;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
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
import Exercise01.ProgramAesthetics.CustomCellRenderer;
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
    private int park = 0;

    public ParqueaderoApp() {
        setSize(400, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
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
        panel3.setBounds(0, 0, 260, 173);

        panelTabla = new JPanel();
        panelTabla.setLayout(null);

        JTextArea area = new JTextArea();
        area.setBackground(new Color(0, 9, 16));
        area.setBounds(0, 150, 25, 23);

        JTextArea area2 = new JTextArea();
        area2.setBackground(new Color(0, 9, 16));
        area2.setBounds(240, 150, 25, 23);

        JLabel title = new JLabel("Welcome");
        title.setFont(new Font("Roboto", Font.LAYOUT_NO_START_CONTEXT, 25));
        title.setForeground(Color.WHITE);
        title.setBounds(102,15,110,60);

        JLabel subTitle = new JLabel("Lorem insump dolor sit amet consectetuer adipiscing elit.");
        subTitle.setFont(new Font("Roboto", Font.ITALIC, 6));
        subTitle.setForeground(Color.WHITE);
        subTitle.setBounds(80, 49, 300, 30);

        placeLabels();

        subpanel.add(area);
        subpanel.add(area2);
        subpanel.add(panel3);
        panel.add(subpanel);
        panelSettings.add(panel, "ingresoDatos");
        panelSettings.add(panelTabla, "mostrarTabla");
        this.getContentPane().add(panelSettings);
    }

    private void placeLabels() {
        JLabel title = new JLabel("Welcome");
        title.setFont(new Font("Roboto", Font.LAYOUT_NO_START_CONTEXT, 25));
        title.setForeground(Color.WHITE);
        title.setBounds(102,8,110,60);

        JLabel subTitle = new JLabel("Lorem insump dolor sit amet consectetuer adipiscing elit.");
        subTitle.setFont(new Font("Roboto", Font.ITALIC, 6));
        subTitle.setForeground(Color.WHITE);
        subTitle.setBounds(80, 43, 300, 30);

        JLabel subTitle2 = new JLabel("sed diam nonummy nibh incidunt ut dolare.");
        subTitle2.setFont(new Font("Roboto", Font.ITALIC, 6));
        subTitle2.setForeground(Color.WHITE);
        subTitle2.setBounds(100, 51, 300, 30);

        subpanel.add(title);
        subpanel.add(subTitle);
        subpanel.add(subTitle2);

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

        tipoVehiculo = new JComboBox<>(new String[] { "Bicicleta", "Ciclomotor", "Motocicleta", "Carro" });
        tipoVehiculo.setEditable(true);
        tipoVehiculo.setFont(new Font("arial", Font.TRUETYPE_FONT, 10));
        tipoVehiculo.setSelectedItem("Eliga el tipo de vehiculo");
        tipoVehiculo.setBounds(30, 270, 200, 30);

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

        JMenuItem ingresar = new JMenuItem("✒ Ingresar");
        ingresar.addActionListener(e -> {
            cardLayout.show(panelSettings, "ingresoDatos");
        });

        JMenuItem tabla = new JMenuItem("⛯ Mostrar tabla");
        tabla.addActionListener(e -> {
            cardLayout.show(panelSettings, "mostrarTabla");
        });

        JMenuItem vehiculos2 = new JMenuItem("⚬ Vehiculos 2 ruedas");
        vehiculos2.addActionListener(e -> {
            TwoWheelsVehicles();
        });

        JMenuItem vehiculos4 = new JMenuItem("⚬ Vehiculos 4 ruedas");
        vehiculos4.addActionListener(e -> {
            FourWheelsVehicles();
        });

        JMenuItem parqueadero = new JMenuItem("⚬ Parqueadero");
        parqueadero.addActionListener(e -> {
            parking();
        });

        JMenuItem eliminar = new JMenuItem("⌦ Eliminar");
        eliminar.addActionListener(e -> {
            eliminateVehiculo();
        });

        JMenuItem salir = new JMenuItem("⛒ Salir");
        salir.addActionListener(e -> {
            System.exit(0);
        });

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
        String[] columns = { "Placa", "Tipo", "Hora", "N° Vehiculo", "Valor" };
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 0, 365, 400);
        panelTabla.add(scrollPane);
        for (int i = 0; i < columns.length; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new CustomCellRenderer(0, 140, 114, 80, 40, 44, 52));
        }
    }

    private void parkingEntrance() {
        String placa = ingresar.getText();
        String tipoVh = (String) tipoVehiculo.getSelectedItem();
        String horaEntrada = hora.getText().trim();
        String[] validar = horaEntrada.split(":"); 
        int minutes;
        int segundos;

        if (placa.equals("Ingresar la placa") || tipoVehiculo.getSelectedIndex() == -1
                || horaEntrada.equals("Ingrese la hora 00:00")) {

            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (validar.length != 2) {
            JOptionPane.showMessageDialog(this, "Entrada de hora invalida.",
            "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            minutes = Integer.parseInt(validar[0]);
            segundos = Integer.parseInt(validar[1]);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Hora no valida. Por favor, ingresar numeros.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;  
        }

        String horaComplet = String.format("%02d:%02d", minutes, segundos);

        VehicleEntry vehicle = new VehicleEntry(placa, tipoVh, horaComplet);
        vehiculos.add(vehicle);

        if (!vehiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Datos ingresados con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }

        tableModel.addRow(new Object[] { vehicle.getPlaca(), vehicle.getTipo(), vehicle.getHora(), turno,
                "$" + valueMinute(tipoVh) });

        ingresar.setText("Ingresar la placa");
        tipoVehiculo.setSelectedItem("Eliga el tipo de vehiculo");
        hora.setText("Ingrese la hora 00:00");
    }

    private void TwoWheelsVehicles() {
        Stack<VehicleEntry> pilaVehiculos2Ruedas = new Stack<>();
        DefaultListModel<String> modeloLista = new DefaultListModel<>();

        for (VehicleEntry vehiculo : vehiculos) {
            if (vehiculo.getTipo().equals("Bicicleta") || vehiculo.getTipo().equals("Motocicletas")
                    || vehiculo.getTipo().equals("Ciclomotores")) {
                pilaVehiculos2Ruedas.push(vehiculo);
            }
        }

        if (pilaVehiculos2Ruedas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay vehículos de 2 ruedas.");
            return;
        }

        while (!pilaVehiculos2Ruedas.isEmpty()) {
            VehicleEntry vehiculo = pilaVehiculos2Ruedas.pop();
            int valor = valueMinute(vehiculo.getTipo());
            modeloLista.addElement(
                    "Placa: " + vehiculo.getPlaca() + " | Tipo: " + vehiculo.getTipo() + " | Hora: " + vehiculo.getHora() + " | Valor: $" + valor);
        }
        mostrarListaVehiculos(modeloLista, "Vehículos de 2 Ruedas");
    }

    private void FourWheelsVehicles() {
        Stack<VehicleEntry> pilaVehiculos4Ruedas = new Stack<>();
        DefaultListModel<String> modeloLista = new DefaultListModel<>();

        for (VehicleEntry vehiculo : vehiculos) {
            if (vehiculo.getTipo().equals("Carros")) {
                pilaVehiculos4Ruedas.push(vehiculo);
            }
        }

        if (pilaVehiculos4Ruedas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay vehículos de 4 ruedas.");
            return;
        }

        while (!pilaVehiculos4Ruedas.isEmpty()) {
            VehicleEntry vehiculo = pilaVehiculos4Ruedas.pop();
            int valor = valueMinute(vehiculo.getTipo());
            modeloLista.addElement(
                    "Placa: " + vehiculo.getPlaca() + " | Tipo: " + vehiculo.getTipo() + " | Hora: " + vehiculo.getHora() + " | Valor: $" + valor);
        }

        mostrarListaVehiculos(modeloLista, "Vehículos de 4 Ruedas");
    }

    private void mostrarListaVehiculos(DefaultListModel<String> modeloLista, String titulo) {
        JList<String> listaVehiculos = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(listaVehiculos);
        scrollPane.setPreferredSize(new Dimension(335, 80));

        JOptionPane.showMessageDialog(this, scrollPane, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    private void parking() {
        int totalParking = vehiculos.size();
        park = 0;

        if (!vehiculos.isEmpty()) {
            for (VehicleEntry vehiculo : vehiculos) {
                park += valueMinute(vehiculo.getTipo());
            }
            JOptionPane.showMessageDialog(this, "Total a pagar: $" + park + "\nTotal vehículos: " + totalParking);
        } else {
            JOptionPane.showMessageDialog(this, "No hay vehiculos en el parqueadero",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void eliminateVehiculo() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(200, 80));

        JLabel label = new JLabel("Ingrese la placa del vehículo:");
        label.setFont(new Font("Roboto", Font.PLAIN, 11));
        label.setBounds(18, 20, 180, 20);
        panel.add(label);

        JTextField textField = new JTextField();
        textField.setBackground(new Color(188, 189, 188,50));
        textField.setBounds(10, 45, 220, 25);
        panel.add(textField);

        int option = JOptionPane.showConfirmDialog(null, panel, "Eliminar vehículo", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            String placa = textField.getText();

            if (placa == null || placa.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Placa no válida.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            VehicleEntry vehiculoAEliminar = null;
            for (VehicleEntry vehiculo : vehiculos) {
                if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                    int caution = JOptionPane.showConfirmDialog(null, "¿Esta seguro de querer eliminar este vehiculo?",
                            "Warning", JOptionPane.WARNING_MESSAGE);

                    if (caution == JOptionPane.OK_OPTION) {
                        vehiculoAEliminar = vehiculo;
                    } else {
                        return;
                    }
                }
            }

            if (vehiculoAEliminar != null) {
                vehiculos.remove(vehiculoAEliminar);

                actualizarTabla();
                park -= valueMinute(vehiculoAEliminar.getTipo());

                JOptionPane.showMessageDialog(null, "Vehículo eliminado exitosamente.", "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún vehículo con la placa ingresada.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void actualizarTabla() {
        tableModel.setRowCount(0);
        for (VehicleEntry vehiculo : vehiculos) {
            tableModel.addRow(new Object[] { vehiculo.getPlaca(), vehiculo.getTipo(), vehiculo.getHora(), turno,
                    "$" + valueMinute(vehiculo.getTipo()) });
        }
    }

    private int valueMinute(String tipo) {
        switch (tipo) {
            case "Bicicleta":
                return 20;
            case "Ciclomotores":
                return 20;
            case "Motocicletas":
                return 30;
            case "Carros":
                return 60;
            default:
                return 0;
        }
    }
}
