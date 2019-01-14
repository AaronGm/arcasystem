/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import helpers.Colors;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import views.components.FlatLabel;

/**
 *
 * @author aarongmx
 */
public class SplashScreen extends JFrame {

    private JPanel pnlCenter;
    private JPanel pnlProgress;
    
    private JProgressBar bar;
    
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
        pnlCenter = new JPanel();
        pnlProgress = new JPanel();
        
        lbProgress = new FlatLabel();
        
        bar = new JProgressBar(SwingConstants.HORIZONTAL);
        
        helpers.Helpers.setWhite(pnlCenter, pnlProgress);
        initCenter();
        initBar();
    }
    
    
    
    SocketAddress address = new InetSocketAddress("localhost", 5432);

    private void initCenter() {
        pnlCenter.setBorder(helpers.Helpers.padding(72, 16));
        pnlCenter.add(new FlatLabel("Instituto Tecnológico de Iztapalapa", "Raleway", "h1"));
        pnlCenter.add(helpers.Helpers.logoItiz(200));
        pnlCenter.add(new FlatLabel("\"Por la ciencia, tecnológia y educación en beneficio de la juventud.\"", "Raleway", "h3"));
    }
    
    private void initBar() {
        pnlProgress.setLayout(new BorderLayout());
        
        bar.setBorderPainted(false);
        bar.setValue(20);
        bar.setMaximum(100);
        bar.setBackground(Color.lightGray);
        bar.setForeground(Colors.BLUE_MEDIUM);
        bar.setPreferredSize(new Dimension(getWidth(), 5));
        
        lbProgress.setFont(helpers.Typography.addFont("Roboto", 28f));
        
        lbProgress.setText("20%");
        
        pnlProgress.add(BorderLayout.CENTER, new JPanel(new FlowLayout(SwingConstants.CENTER)).add(lbProgress));
        pnlProgress.add(BorderLayout.SOUTH, bar);
    }
    
}
