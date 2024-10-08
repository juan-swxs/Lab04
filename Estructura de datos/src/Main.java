package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;

import Exercise01.*;

public class Main {

    public static JFrame frame;
    public static JButton[] boton;

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        FlatAtomOneDarkIJTheme.setup();
        UIManager.put("Component.focusWidth", 1);
        UIManager.put("Button.arc", 20);

        String titulo = "Lab04: Estructuras de datos";

        String opciones[] = {"Asignacion de turnos EPS", "Parqueadero Publico"};

        final int nump = opciones.length;

        frame = new JFrame(titulo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 200, 400, 110);
        frame.setLayout(new BorderLayout());

        JPanel Panelbuttons = new JPanel();
        Panelbuttons.setLayout(new GridLayout(nump,1));

        boton = new JButton[nump];

        for(int n = 0; n < nump; n++){
            final int index = n;
            boton[n] = new JButton(opciones[n]);
            boton[n].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch (index) {
                        case 0:
                            boton[index].setEnabled(!boton[index].isEnabled());
                            Eps aplication = new Eps();
                            FlatCarbonIJTheme.setup();
                            UIManager.put("TextComponent.arc", 999);
                            UIManager.put("Panel.arc", 999);
                            UIManager.put("Component.arc", 999);
                            UIManager.put("Component.focusWidth", 1 );
                            UIManager.put("Button.arc", 100);
                            UIManager.put("Button.background", new Color(23, 32, 48)); 
                            UIManager.put("Button.pressedBackground", new Color(77,105,159));
                            UIManager.put("TextField.background", Color.WHITE);
                            UIManager.put("TextField.foreground", Color.BLACK);
                            UIManager.put("Label.foreground", Color.BLACK);
                            UIManager.put("ComboBox.background", Color.WHITE);
                            UIManager.put("ComboBox.foreground", Color.BLACK);
                            UIManager.put("Component.arrowType", "chevron");
                            UIManager.put("ScrollBar.showButtons", true );
                            UIManager.put("OptionPane.messageForeground", Color.WHITE);
                            UIManager.put("Table.background", Color.WHITE);
                            UIManager.put("Table.foreground", Color.BLACK);
                            UIManager.put("TextArea.background", new Color(213,213,213));
                            UIManager.put("TextArea.foreground", Color.BLACK);
                
                            SwingUtilities.updateComponentTreeUI(aplication);
                            aplication.setVisible(true);
                            break;

                        case 1:
                            boton[index].setEnabled(!boton[index].isEnabled());
                            
                            break;
                    }
                }
            });

            Panelbuttons.add(boton[n]);
        }

        frame.add(Panelbuttons, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
