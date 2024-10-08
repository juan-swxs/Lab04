package Exercise01.ProgramAesthetics;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;

public class CustomCellRenderer extends JLabel implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value != null ? value.toString() : "");
        setHorizontalAlignment(CENTER);
        setBorder(new LineBorder(null));
    
        if (row % 2 == 0) { 
            setBackground(Color.WHITE); 
        } else {
            setBackground(new Color(176, 190, 217)); 
        }

        setOpaque(true);
        return this; 
    }
}
