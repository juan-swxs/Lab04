package Exercise01.ProgramAesthetics;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class CustomCellRenderer extends JLabel implements TableCellRenderer {

    private int r, R;
    private int g, G;
    private int b, B ,trans;

    public CustomCellRenderer(int r , int g, int b,int trans, int R, int G, int B) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.trans = trans;
        this.R = R;
        this.G = G;
        this.B = B;
        
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value != null ? value.toString() : "");
        setHorizontalAlignment(CENTER);

    
        if (row % 2 == 0) { 
            setBackground(new Color(R, G, B)); 
        } else {
            setBackground(new Color(r, g, b , trans)); 
        }

        setOpaque(true);
        return this; 
    }
}
