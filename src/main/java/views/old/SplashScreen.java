
package views.old;

import enums.FontFamily;
import enums.FontSize;
import enums.SpacingPoints;
import helpers.Colors;
import helpers.Typography;
import views.old.components.FlatLabel;
import views.old.components.FlatPanel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 *
 * @author aarongmx
 */
public class SplashScreen extends JFrame {

    private FlatPanel pnlCenter;
    private FlatPanel pnlProgress;
    
    private JProgressBar progressBar;
    
    private FlatLabel lbProgress;
    
    public SplashScreen() throws HeadlessException {
        initView();
    }
    
    private void initView() {
        setSize(new Dimension(660, 460));
        setUndecorated(true);
        initComponents();
        getContentPane().add(BorderLayout.CENTER, pnlCenter);
        getContentPane().add(BorderLayout.SOUTH, pnlProgress);
        setResizable(false);
        helpers.Helpers.centerCloseScreen(this);
    }
    
    private void initComponents() {
        pnlCenter = new FlatPanel();
        pnlProgress = new FlatPanel();
        
        lbProgress = new FlatLabel();
        
        progressBar = new JProgressBar(SwingConstants.HORIZONTAL);
        
        initCenter();
        initBar();
    }
    
    
    
    SocketAddress address = new InetSocketAddress("localhost", 5432);

    private void initCenter() {
        pnlCenter.setBorder(helpers.Helpers.padding(SpacingPoints.SP64, SpacingPoints.SP16));
        pnlCenter.add(new FlatLabel("Instituto Tecnológico de Iztapalapa", FontSize.H1));
        pnlCenter.add(helpers.Helpers.logoItiz(200));
        pnlCenter.add(new FlatLabel("\"Por la ciencia, tecnológia y educación en beneficio de la juventud.\"", FontSize.H3));
    }
    
    private void initBar() {
        pnlProgress.setLayout(new BorderLayout());
        
        progressBar.setBorderPainted(false);
        progressBar.setValue(20);
        progressBar.setMaximum(100);
        progressBar.setBackground(Color.lightGray);
        progressBar.setForeground(Colors.BLUE_MEDIUM);
        progressBar.setPreferredSize(new Dimension(getWidth(), 5));
        
        lbProgress.setFont(Typography.addFont(FontFamily.ROBOTO, FontSize.H3));
        
        lbProgress.setText("20%");
        
        pnlProgress.add(BorderLayout.CENTER, new JPanel(new FlowLayout(SwingConstants.CENTER)).add(lbProgress));
        pnlProgress.add(BorderLayout.SOUTH, progressBar);
    }
    
}
