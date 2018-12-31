/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import config.Configuration;
import helpers.Colors;
import helpers.Helpers;
import helpers.Typography;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import jiconfont.swing.IconFontSwing;
import jiconfont.icons.font_awesome.FontAwesome;


/**
 *
 * @author aarongmx
 */
public class LoginView extends JFrame {
    
    private JPanel headerPanel;
    private JPanel formPanel;
    private JLabel headerTitle;
    private JLabel userLabel;
    private JLabel passwdLabel;
    private JTextField userField;

    public JTextField getUserField() {
        return userField;
    }

    public void setUserField( JTextField userField ) {
        this.userField = userField;
    }

    public JPasswordField getPasswdField() {
        return passwdField;
    }

    public void setPasswdField( JPasswordField passwdField ) {
        this.passwdField = passwdField;
    }

    public JButton getBtnSend() {
        return btnSend;
    }

    public void setBtnSend( JButton btnSend ) {
        this.btnSend = btnSend;
    }
    private JPasswordField passwdField;
    private JButton btnSend;
        
    private final Dimension screen;
    
    public LoginView() {
        super(config.Configuration.APP_NAME);
        screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.initView();
    }
    
    private void initView() {
        setSize(screen.width / 3 - 100, screen.height - 150);
        setResizable(false);
        getContentPane().setBackground(Color.white);
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    private void initComponents() {
        formPanel = new JPanel(new GridBagLayout());
        headerPanel = new JPanel();
        
        headerTitle = new JLabel(Configuration.APP_NAME);
        userLabel = new JLabel("Usuario");
        passwdLabel = new JLabel("Contraseña");

        userField = new JTextField();
        passwdField = new JPasswordField();

        btnSend = new JButton("Iniciar Sesión".toUpperCase());
        
        initHeader();
        initForm();
        getContentPane().add(BorderLayout.NORTH, headerPanel);
        getContentPane().add(BorderLayout.SOUTH, formPanel);
    }
    
    private void initHeader() {
        headerTitle.setFont(Typography.addFont("Raleway", "h3"));
        headerTitle.setForeground(Colors.BLACK_MEDIUM);
        
        headerPanel.setBackground(Color.white);
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBorder(Helpers.padding(16, 8));
        
        
        headerPanel.add(headerTitle);
        headerPanel.add(helpers.Helpers.logoItiz(150));
    }
        
    private void initForm() {
        IconFontSwing.register(FontAwesome.getIconFont());
        JLabel iconUser = new JLabel(IconFontSwing.buildIcon(FontAwesome.USER, 24, Colors.BLACK_LIGHT));
        JLabel iconPass = new JLabel(IconFontSwing.buildIcon(FontAwesome.LOCK, 24, Colors.BLACK_LIGHT));
        GridBagConstraints gbConstraint = new GridBagConstraints();

        
        formPanel.setPreferredSize(new Dimension(325, 550));
        formPanel.setBackground(Color.white);

        userLabel.setFont(Typography.componentsFont());
        userLabel.setForeground(Colors.BLUE);
        passwdLabel.setFont(userLabel.getFont());
        passwdLabel.setForeground(userLabel.getForeground());
        
        userField.setPreferredSize(new Dimension(210, 30));
        userField.setFont(Typography.addFont("Open Sans", "pr"));
        userField.setBorder(new CompoundBorder(new MatteBorder(0, 0, 2, 0, Colors.BLUE), new EmptyBorder(0, 4, 0, 4)));
        
        passwdField.setPreferredSize(userField.getPreferredSize());
        passwdField.setFont(userField.getFont());
        passwdField.setBorder(userField.getBorder());
        
        btnSend.setBackground(Colors.BLUE);
        btnSend.setForeground(Color.white);
        btnSend.setFocusPainted(false);
        btnSend.setFont(Typography.componentsFont());
        btnSend.setBorder(new EmptyBorder(8, 16, 8, 16));
        btnSend.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnSend.setBackground(Colors.BLUE.brighter());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSend.setBackground(Colors.BLUE);
            }
        });
        

        formPanel.setBorder(Helpers.padding(8, 16));
        
        /* Acomodando etiqueta, icono e input para usuario  */
        gbConstraint.gridy = 0;
        gbConstraint.gridx = 1;
        gbConstraint.anchor = GridBagConstraints.WEST;
        formPanel.add(userLabel, gbConstraint);
        
        gbConstraint.gridy = 1;
        gbConstraint.gridx = 0;
        formPanel.add(iconUser, gbConstraint);
        
        gbConstraint.gridx = 1;
        formPanel.add(userField, gbConstraint);
        
        /* Acomodando etiqueta, icono e input para contraseña  */
        gbConstraint.gridy = 2;
        gbConstraint.gridx = 1;
        formPanel.add(passwdLabel, gbConstraint);
        
        gbConstraint.gridy = 3;
        gbConstraint.gridx = 0;
        formPanel.add(iconPass, gbConstraint);
        
        gbConstraint.gridx = 1;
        formPanel.add(passwdField, gbConstraint);
        
        gbConstraint.gridy = 4;
        gbConstraint.gridwidth = 2;
        gbConstraint.anchor = GridBagConstraints.CENTER;
        formPanel.add(btnSend, gbConstraint);
    }  
}
