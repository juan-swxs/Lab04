package Exercise01;

import Exercise01.ProgramAesthetics.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.PriorityQueue;
import javax.swing.Timer;

public class Eps extends JFrame {

    private JPanel panel;
    private JTextField screenNombre;
    private JTextField screenEdad;
    private JTextField attend;
    private ImageIcon conteinImage;
    private JLabel animationJLabel;
    private JLabel time;
    private JComboBox<String> afiliaciones;
    private JComboBox<String> condiciones;
    private JButton button;
    private JButton button2;
    private JTable table;
    private Timer timer;
    private JDialog turnoDialog;
    private DefaultTableModel model;
    private PriorityQueue<Paciente> colaShift;
    private Paciente paciente;
    private int segundos = 10;
    private int turno = 1;

    public Eps() {
        setSize(280, 420);
        setLocationRelativeTo(null);
        setTitle("Turnos - EPS");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        colaShift = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.calcularPrioridad(), p1.calcularPrioridad()));
        mainPanel();
        placeText();
        placeInformation();
        placeButtons();
        placeTable();
    }

    private void mainPanel() {
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }

    private void placeText() {
        conteinImage = new ImageIcon("Images/Timer.png");
        Image imagen = conteinImage.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);

        animationJLabel = new JLabel(new ImageIcon(imagen));
        animationJLabel.setBounds(19, 20, 32, 32);

        JLabel title = new JLabel("Pedidos");
        title.setFont(new Font("serif", Font.ITALIC, 20));
        title.setBounds(60, 26, 100, 20);

        JLabel subTitle = new JLabel("Complete el siguiente formulario para asignar un turno");
        subTitle.setFont(new Font("serif", Font.ROMAN_BASELINE, 10));
        subTitle.setForeground(Color.LIGHT_GRAY);
        subTitle.setBounds(18, 59, 300, 30);

        JLabel decoration = new JLabel("_______________________________________________");
        decoration.setForeground(Color.LIGHT_GRAY);
        decoration.setBounds(18, 70, 300, 20);

        JLabel nombreLabel = new JLabel("Nombre y apellido");
        nombreLabel.setFont(new Font("serif", Font.ROMAN_BASELINE, 12));
        nombreLabel.setBounds(20, 100, 120, 30);

        JLabel apellidoLabel = new JLabel("Edad");
        apellidoLabel.setFont(new Font("serif", Font.ROMAN_BASELINE, 12));
        apellidoLabel.setBounds(177, 100, 60, 30);

        JLabel afiliacioniJLabel = new JLabel("Afiliacion");
        afiliacioniJLabel.setFont(new Font("serif", Font.ROMAN_BASELINE, 12));
        afiliacioniJLabel.setBounds(20, 160, 60, 30);

        JLabel condicionJLabel = new JLabel("Condicion especial");
        condicionJLabel.setFont(new Font("serif", Font.ROMAN_BASELINE, 12));
        condicionJLabel.setBounds(130, 160, 130, 30);

        panel.add(animationJLabel);
        panel.add(title);
        panel.add(decoration);
        panel.add(subTitle);
        panel.add(nombreLabel);
        panel.add(apellidoLabel);
        panel.add(afiliacioniJLabel);
        panel.add(condicionJLabel);
    }

    private void placeInformation() {
        screenNombre = new JTextField();
        screenNombre.setFont(new Font("serif", Font.ROMAN_BASELINE, 12));
        screenNombre.setBounds(17, 130, 140, 24);

        screenEdad = new JTextField();
        screenEdad.setFont(new Font("serif", Font.ROMAN_BASELINE, 12));
        screenEdad.setBounds(170, 130, 80, 24);

        afiliaciones = new JComboBox<>(new String[] { "POS", "PC" });
        afiliaciones.setFont(new Font("serif", Font.ROMAN_BASELINE, 12));
        afiliaciones.setBounds(17, 190, 100, 27);
        afiliaciones.setSelectedIndex(-1);

        condiciones = new JComboBox<>(new String[] { "Ninguna", "Embarazo", "Limitacion motriz" });
        condiciones.setFont(new Font("serif", Font.ROMAN_BASELINE, 12));
        condiciones.setBounds(130, 190, 120, 27);
        condiciones.setSelectedIndex(-1);

        panel.add(screenNombre);
        panel.add(screenEdad);
        panel.add(afiliaciones);
        panel.add(condiciones);
    }

    private void placeButtons() {
        button = new JButton("Agregar paciente");
        button.setBounds(9, 234, 124, 30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addShift();
            }

        });

        button2 = new JButton("Extender tiempo");
        button2.setBounds(135, 234, 121, 30);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                extendTime();
            }
        });

        panel.add(button);
        panel.add(button2);
    }

    private void placeTable() {
        String[] columns = { "Nombre", "Edad", "Afiliacion", "Condicion" };
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(5, 280, 255, 80);
        panel.add(scroll);
        for (int i = 0; i < columns.length; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new CustomCellRenderer());
        }
    }

    private void addShift() {
        String nombre = screenNombre.getText();
        String afiliacion = (String) afiliaciones.getSelectedItem();
        String condicionEspecial = (String) condiciones.getSelectedItem();
        int edad;

        if (nombre.isEmpty() || afiliacion == null || condicionEspecial == null) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            edad = Integer.parseInt(screenEdad.getText());
            if (edad < 1 || edad > 110) {
                JOptionPane.showMessageDialog(this, "Por favor ingresa una edad válida (1-110).",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Edad no válida. Por favor, ingresa un número.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Paciente patients = new Paciente(nombre, edad, afiliacion, condicionEspecial);
        colaShift.offer(patients);

        updateTable();

        screenNombre.setText("");
        screenEdad.setText("");
        afiliaciones.setSelectedIndex(-1);
        condiciones.setSelectedIndex(-1);

        if (turnoDialog == null || !turnoDialog.isVisible()) {
            patientAttended();
        }
    }

    private void updateTable() {
        model.setRowCount(0);

        Paciente[] pacientesArray = colaShift.toArray(new Paciente[0]);

        Arrays.sort(pacientesArray, (p1, p2) -> Integer.compare(p2.calcularPrioridad(), p1.calcularPrioridad()));

        for (Paciente paciente : pacientesArray) {
            model.addRow(new Object[] { paciente.getNombre(), paciente.getEdad(), paciente.getAfiliacion(),
                    paciente.getCondicion() });
        }
    }

    private void patientAttended() {
        if (colaShift.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay pacientes en espera.",
                    "Cola Completa", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (!colaShift.isEmpty()) {
            model.removeRow(0);
        }

        paciente = colaShift.poll();

        if (turnoDialog != null) {
            turnoDialog.dispose();
        }

        turnoDialog = new JDialog(this, "Atención al paciente", false);
        turnoDialog.setResizable(false);
        turnoDialog.setBounds(770, 230, 237, 257);

        BackgroundPanel backgroundPanel = new BackgroundPanel("Images/DialogFondo.png");
        backgroundPanel.setBackground(Color.WHITE);
        backgroundPanel.setLayout(null);

        RoundedPanel subPanel = new RoundedPanel();
        subPanel.setBackground(new Color(0,0,0,30));
        subPanel.setRounded(40, 40);
        subPanel.setBounds(16, 10, 190,130); 
        subPanel.setLayout(null);

        JLabel labelAttended = new JLabel("Nombre: " + paciente.getNombre().toLowerCase());
        labelAttended.setFont(new Font("serif", Font.ROMAN_BASELINE, 12));
        labelAttended.setBounds(9, 10, 200, 20);

        JLabel labelEdad = new JLabel("Edad: " + paciente.getEdad());
        labelEdad.setFont(new Font("serif", Font.ROMAN_BASELINE, 12));
        labelEdad.setBounds(9, 40, 200, 20);

        JLabel labelAfiliacion = new JLabel("Afiliación: " + paciente.getAfiliacion());
        labelAfiliacion.setFont(new Font("serif", Font.ROMAN_BASELINE, 12));
        labelAfiliacion.setBounds(9, 70, 200, 20);

        JLabel labelCondicion = new JLabel("Condición: " + paciente.getCondicion());
        labelCondicion.setFont(new Font("serif", Font.ROMAN_BASELINE, 12));
        labelCondicion.setBounds(9, 100, 200, 20);

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setBounds(15, 146, 190, 120);

        JLabel Turno = new JLabel("Turno: " + turno);
        Turno.setFont(new Font("serif", Font.ROMAN_BASELINE, 12));
        Turno.setBounds(39, 147, 180, 30);

        attend = new JTextField();
        attend.setEditable(false);
        attend.setFont(new Font("serif", Font.ROMAN_BASELINE, 12));
        attend.setBounds(20, 179, 190, 24);

        time = new JLabel("00:00:10");
        time.setFont(new Font("Serif", Font.PLAIN, 15));
        time.setBounds(120, 138, 170, 50);
       
        subPanel.add(labelAttended);
        subPanel.add(labelEdad);
        subPanel.add(labelAfiliacion);
        subPanel.add(labelCondicion);
        backgroundPanel.add(separator);
        backgroundPanel.add(Turno);
        backgroundPanel.add(time);
        backgroundPanel.add(attend);
        backgroundPanel.add(subPanel);

        turnoDialog.add(backgroundPanel);
        turnoDialog.setVisible(true);

        if (timer != null) {
            timer.stop();
        }

        if (segundos == 0) {
            segundos = 10;
        }

        Timer timeUpdateTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (segundos > 0) {
                    segundos--;
                    actualizeTime();
                } else {
                    timer.stop();
                }
            }
        });
        timeUpdateTimer.start();

        timer = new Timer(segundos * 1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attend.setText("Turno atendido: " + paciente.getNombre());

                Timer closeTimer = new Timer(800, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        turnoDialog.dispose();
                        if (timeUpdateTimer != null) {
                            timeUpdateTimer.stop();
                        }
                        segundos = 10;
                        actualizeTime();

                        if (!colaShift.isEmpty()) {
                            turno++;
                        } else {
                            turno = 1;
                        }
                        patientAttended();
                    }
                });
                closeTimer.setRepeats(false);
                closeTimer.start();
            }
        });

        timer.setRepeats(false);
        timer.start();
    }

    private void actualizeTime() {
        int horas = segundos / 3600;
        int minutes = (segundos % 3600) / 60;
        int remainingSeconds = segundos % 60;

        String timeFormatted = String.format("%02d:%02d:%02d", horas, minutes, remainingSeconds);
        time.setText(timeFormatted);
    }

    private void extendTime() {
        if (timer != null && timer.isRunning()) {
            segundos += 5;
            actualizeTime();

            timer.setInitialDelay(segundos * 1000);
            timer.restart();

        } else {
            JOptionPane.showMessageDialog(null,
                    "El tiempo de atencion aún no ha comenzado. Por favor, ingresa un paciente para extender el tiempo.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

}