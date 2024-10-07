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
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.Timer;

public class Eps extends JFrame {

    private JPanel panel;
    private JTextField screenNombre;
    private JTextField screenEdad;
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
    private Queue<Paciente> colaShift;
    private int segundos = 10;
    private int turno = 1;

    public Eps() {
        setSize(280, 420);
        setLocationRelativeTo(null);
        setTitle("Turnos - EPS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        colaShift = new LinkedList<>();
        paneles();
        placeText();
        placeInformation();
        placeButtons();
        placeTable();
    }

    private void paneles() {
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }

    private void placeText() {
        conteinImage = new ImageIcon("Images/Timer.jpg");
        Image imagen = conteinImage.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);

        animationJLabel = new JLabel(new ImageIcon(imagen));
        animationJLabel.setBounds(17, 10, 60, 60);

        JLabel title = new JLabel("Pedidos");
        title.setFont(new Font("serif", Font.ITALIC, 20));
        title.setBounds(76, 27, 100, 20);

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

        condiciones = new JComboBox<>(new String[] { "Embarazo", "Limitacion motriz" });
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
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Edad no válida. Por favor, ingresa un número.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Paciente patients = new Paciente(nombre, edad, afiliacion, condicionEspecial);
        colaShift.offer(patients);

        model.addRow(new Object[] { nombre, edad, afiliacion, condicionEspecial });
        screenNombre.setText("");
        screenEdad.setText("");
        afiliaciones.setSelectedIndex(-1);
        condiciones.setSelectedIndex(-1);

        if (turnoDialog == null || !turnoDialog.isVisible()) {
            patientAttended();
        }
    }

    private void patientAttended() {
        if (colaShift.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay pacientes en espera.",
                    "Cola Completa", JOptionPane.OK_OPTION);
            return;
        }
        Paciente paciente = colaShift.poll();

        if (turnoDialog != null) {
            turnoDialog.dispose();
        }

        turnoDialog = new JDialog(this, "Atención al paciente", false);
        turnoDialog.setBounds(770, 120, 237, 240);

        BackgroundPanel backgroundPanel = new BackgroundPanel("Images/DialogFondo.png");
        backgroundPanel.setBackground(Color.WHITE);
        backgroundPanel.setLayout(null);

        JLabel labelAttended = new JLabel("Nombre: " + paciente.getNombre());
        labelAttended.setFont(new Font("serif", Font.ROMAN_BASELINE, 12));
        labelAttended.setBounds(30, 10, 200, 20);

        JLabel labelEdad = new JLabel("Edad: " + paciente.getEdad());
        labelEdad.setFont(new Font("serif", Font.ROMAN_BASELINE, 12));
        labelEdad.setBounds(30, 40, 200, 20);

        JLabel labelAfiliacion = new JLabel("Afiliación: " + paciente.getAfiliacion());
        labelAfiliacion.setFont(new Font("serif", Font.ROMAN_BASELINE, 12));
        labelAfiliacion.setBounds(30, 70, 200, 20);

        JLabel labelCondicion = new JLabel("Condición: " + paciente.getCondicion());
        labelCondicion.setFont(new Font("serif", Font.ROMAN_BASELINE, 12));
        labelCondicion.setBounds(30, 100, 200, 20);

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setBounds(15, 127, 190, 120);
        
        JLabel Turno = new JLabel("Turno: " + turno);
        Turno.setFont(new Font("serif", Font.ROMAN_BASELINE, 12));
        Turno.setBounds(37, 130, 180, 30);

        JTextField attend = new JTextField();
        attend.setEditable(false); 
        attend.setBounds(20, 160, 190, 24);

        time = new JLabel("00:00:10");
        time.setFont(new Font("Serif", Font.PLAIN, 15));
        time.setBounds(128, 121, 170, 50);

        backgroundPanel.add(labelAttended);
        backgroundPanel.add(labelEdad);
        backgroundPanel.add(labelAfiliacion);
        backgroundPanel.add(labelCondicion);
        backgroundPanel.add(separator);
        backgroundPanel.add(Turno);
        backgroundPanel.add(time);
        backgroundPanel.add(attend);
        turnoDialog.add(backgroundPanel);
        turnoDialog.setVisible(true);

        Timer timeUpdateTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                segundos--;
                actualizeTime();
            }
        });
        timeUpdateTimer.start();

        timer = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attend.setText("Turno atendido: " + paciente.getNombre());

                Timer closeTimer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        turnoDialog.dispose();
                        if(timeUpdateTimer != null){
                            timeUpdateTimer.stop();
                        }
                        segundos = 10;
                        actualizeTime();
                        
                        if(!colaShift.isEmpty()){
                            turno++;
                        }else{
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

    private void actualizeTime(){
        int horas = segundos / 3600;
        int minutos = (segundos % 3600) / 60;
        int seg = segundos % 60;

        String tiempoFormat = String.format("%02d:%02d:%02d", horas, minutos, seg);
        time.setText(tiempoFormat);
    }
}