package Exercise01;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;


public class Eps extends JFrame {

    private JPanel panel;
    private JTextField screenNombre;
    private JTextField screenEdad;
    private ImageIcon conteinImage;
    private JLabel animationJLabel;
    private JComboBox <String> afiliaciones; 
    private JComboBox <String> condiciones;
    private JButton button;
    private JTable table;
    private DefaultTableModel model;
    private Queue <Paciente> colaShift;

    public Eps() {
        setSize(280, 500);
        setLocationRelativeTo(null);
        setTitle("Turnos - EPS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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

        JLabel decoration = new JLabel("_______________________________________________");
        decoration.setForeground(Color.LIGHT_GRAY);
        decoration.setBounds(18, 70, 300, 20);

        JLabel nombreLabel = new JLabel("Nombre y apellido");
        nombreLabel.setFont(new Font("serif", Font.ROMAN_BASELINE, 12));
        nombreLabel.setBounds(20,100, 120, 30);

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

    private void placeInformation(){
        screenNombre = new JTextField();
        screenNombre.setFont(new Font("serif", Font.ROMAN_BASELINE, 12));
        screenNombre.setBounds(17, 130, 140, 24);

        screenEdad = new JTextField();
        screenEdad.setFont(new Font("serif", Font.ROMAN_BASELINE, 12));
        screenEdad.setBounds(170, 130, 80, 24);

        afiliaciones = new JComboBox<>(new String[]{"POS", "PC"});
        afiliaciones.setFont(new Font("serif", Font.ROMAN_BASELINE, 12));
        afiliaciones.setBounds(17, 190, 100, 24);
        afiliaciones.setSelectedIndex(-1);

        condiciones = new JComboBox<>(new String[]{"Embarazo", "Limitacion motriz"});
        condiciones.setFont(new Font("serif", Font.ROMAN_BASELINE, 12));
        condiciones.setBounds(130, 190, 120,24);
        condiciones.setSelectedIndex(-1);
        
        panel.add(screenNombre);
        panel.add(screenEdad);
        panel.add(afiliaciones);
        panel.add(condiciones);
    }

    private void placeButtons(){
        button = new JButton("Agregar paciente");
        button.setBackground(new Color(23, 32, 48));
        button.setBounds(20, 230, 128, 30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addShift();
            }
            
        });
        panel.add(button);
    }

    private void placeTable(){
        String[] columns = {"Nombre", "Edad", "Afiliacion", "Condicion"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(5,280 , 255, 80);
        panel.add(scroll);
    }

    private void addShift(){
        colaShift = new LinkedList<>();
        String nombre = screenNombre.getText();
        String afiliacion = (String) afiliaciones.getSelectedItem();
        String condicionEspecial = (String) condiciones.getSelectedItem();
        int edad;

        if(nombre.isEmpty() || afiliacion == null || condicionEspecial == null ){
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

        model.addRow(new Object[]{nombre, edad, afiliacion, condicionEspecial});
        screenNombre.setText("");
        screenEdad.setText("");
        afiliaciones.setSelectedIndex(-1);
        condiciones.setSelectedIndex(-1);
    }
}
