package Exercise01.ProgramAesthetics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;

public class BackgroundPanel extends RoundedPanel {

    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
        super();
        backgroundImage = new ImageIcon(imagePath).getImage();
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
   
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Double(0, 0, width, height, getArcWidth(), getArcHeight());
        g2.setClip(roundedRectangle);
        
        if (backgroundImage != null) {
            g2.drawImage(backgroundImage, 0, 0, width, height, this);
        }

        g2.dispose();
    }
 
}
