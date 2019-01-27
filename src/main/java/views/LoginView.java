package views;

import config.Configuration;
import enums.FontAwesome5;
import enums.FontSize;
import enums.SpacingPoints;
import helpers.Colors;
import helpers.Helpers;
import helpers.Typography;
import jiconfont.swing.IconFontSwing;
import views.components.FlatButton;
import views.components.FlatLabel;
import views.components.FlatPanel;
import views.components.FlatTextField;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;


/**
 *
 * @author aarongmx
 */
public class LoginView extends JFrame {

    private FlatPanel headerPanel;
    private FlatPanel formPanel;
    private JLabel headerTitle;

    private FlatTextField userField;
    private JPasswordField passwdField;

    private FlatButton btnSend;
        
    private final Dimension screen;
    
    public LoginView() {
        super(config.Configuration.APP_NAME);
        screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.initView();
    }
    
    private void initView() {
        setIconImage(new ImageIcon(Helpers.IMAGES_PATH + "logo-itiz64.png").getImage());
        setSize(screen.width / 3 - 100, screen.height - 150);
        setResizable(false);
        getContentPane().setBackground(Color.white);
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    private void initComponents() {
        formPanel = new FlatPanel(new GridBagLayout());
        headerPanel = new FlatPanel();
        
        headerTitle = new JLabel(Configuration.APP_NAME);

        userField = new FlatTextField();
        passwdField = new JPasswordField();

        btnSend = new FlatButton("Iniciar Sesión");

        initHeader();
        initForm();
        getContentPane().add(BorderLayout.NORTH, headerPanel);
        getContentPane().add(BorderLayout.CENTER, formPanel);
    }
    
    private void initHeader() {
        headerTitle.setFont(Typography.titleFont(FontSize.H3));
        headerPanel.setPreferredSize(new Dimension(getWidth(), getHeight() / 3 + 60));
        headerPanel.setBorder(Helpers.padding(SpacingPoints.SP24, SpacingPoints.SP16));

        headerPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = Helpers.paddingInset(SpacingPoints.SP64, SpacingPoints.SP_NONE, SpacingPoints.SP_NONE, SpacingPoints.SP_NONE);
        headerPanel.add(headerTitle, c);
        c.gridy = 1;
        c.insets = Helpers.paddingInset(SpacingPoints.SP16, SpacingPoints.SP_NONE);
        headerPanel.add(Helpers.logoItiz(160), c);

    }
        
    private void initForm() {
        IconFontSwing.register(FontAwesome5.getIconFont("solid"));
        JLabel iconUser = new JLabel(IconFontSwing.buildIcon(FontAwesome5.FA_USER, 24, Colors.BLACK_LIGHT));
        JLabel iconPass = new JLabel(IconFontSwing.buildIcon(FontAwesome5.FA_LOCK, 24, Colors.BLACK_LIGHT));
        GridBagConstraints gbConstraint = new GridBagConstraints();


        FlatTextField.styleMaterial(userField);
        FlatTextField.styleMaterial(passwdField);
        
        userField.setPreferredSize(new Dimension(280, 30));
        passwdField.setPreferredSize(userField.getPreferredSize());

        userField.setText("aarongm");
        passwdField.setText("aagmx");


        gbConstraint.gridy = 0;
        gbConstraint.gridx = 1;
        gbConstraint.anchor = GridBagConstraints.WEST;
        formPanel.add(new FlatLabel("Usuario"), gbConstraint);
        
        gbConstraint.gridy = 1;
        gbConstraint.gridx = 0;
        formPanel.add(iconUser, gbConstraint);
        
        gbConstraint.gridx = 1;
        formPanel.add(userField, gbConstraint);

        gbConstraint.gridy = 2;
        formPanel.add(Box.createVerticalStrut(24), gbConstraint);
        
        gbConstraint.gridy = 3;
        gbConstraint.gridx = 1;
        formPanel.add(new FlatLabel("Contraseña"), gbConstraint);

        gbConstraint.gridy = 4;
        gbConstraint.gridx = 0;
        formPanel.add(iconPass, gbConstraint);

        gbConstraint.gridx = 1;
        formPanel.add(passwdField, gbConstraint);

        gbConstraint.gridy = GridBagConstraints.RELATIVE;
        formPanel.add(Box.createVerticalStrut(24), gbConstraint);
        gbConstraint.gridwidth = 1;
        gbConstraint.anchor = GridBagConstraints.CENTER;
        formPanel.add(btnSend, gbConstraint);


    }

    public FlatTextField getUserField() {
        return userField;
    }

    public void setUserField( FlatTextField userField ) {
        this.userField = userField;
    }

    public JPasswordField getPasswdField() {
        return passwdField;
    }

    public void setPasswdField( JPasswordField passwdField ) {
        this.passwdField = passwdField;
    }

    public void setBtnSend( FlatButton btnSend ) {
        this.btnSend = btnSend;
    }

    public JButton getBtnSend() {
        return btnSend;
    }
}
