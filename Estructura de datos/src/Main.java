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
        UIManager.put("TextComponent.arc", 100);
        UIManager.put("Button.arc", 100);
        UIManager.put("TextField.background", Color.WHITE);
        UIManager.put("TextField.foreground", Color.BLACK);
        UIManager.put("Label.foreground", Color.BLACK);
        UIManager.put("ComboBox.background", Color.WHITE);
        UIManager.put("ComboBox.foreground", Color.BLACK);
        UIManager.put("Component.arrowType", "chevron");
        UIManager.put("ScrollBar.showButtons", true );
        UIManager.put("OptionPane.background", Color.WHITE);
        
        SwingUtilities.updateComponentTreeUI(aplication);
        aplication.setVisible(true);
    }
}
