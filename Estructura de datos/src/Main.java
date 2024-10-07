package src;
import java.awt.Color;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import Exercise01.*;

public class Main {
    
    public static void main(String[] args) throws UnsupportedLookAndFeelException  {
        Eps aplication = new Eps();
        FlatCarbonIJTheme.setup();
        UIManager.put("TextComponent.arc", 999);
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
    }
}
