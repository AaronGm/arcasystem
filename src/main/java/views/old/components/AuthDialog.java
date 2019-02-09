package views.old.components;

import controllers.LoginController;
import dao.postgres.UsuarioDB;
import enums.FontAwesome5;
import enums.FontSize;
import enums.SpacingPoints;
import helpers.Colors;
import helpers.Helpers;
import jiconfont.swing.IconFontSwing;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Window;

public class AuthDialog extends JDialog {

    private JPasswordField passwd;
    private FlatButton btnAuth;
    private Color colorDialog;

    private UsuarioDB usuarioDB;

    public AuthDialog() {

        initComponent();
    }

    public AuthDialog(Frame owner) {
        super(owner);
        initComponent();
        setLocationRelativeTo(owner);
    }

    public AuthDialog(Frame owner, boolean modal) {
        super(owner, modal);
        initComponent();
        setLocationRelativeTo(owner);
    }

    public AuthDialog(Frame owner, String title) {
        super(owner, title);
        initComponent();
        setLocationRelativeTo(owner);
    }

    public AuthDialog(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        initComponent();
        setLocationRelativeTo(owner);
    }

    public AuthDialog(Frame owner, String title, boolean modal, GraphicsConfiguration gc) {
        super(owner, title, modal, gc);
        initComponent();
        setLocationRelativeTo(owner);
    }

    public AuthDialog(Dialog owner) {
        super(owner);
        initComponent();
        setLocationRelativeTo(owner);
    }

    public AuthDialog(Dialog owner, boolean modal) {
        super(owner, modal);
        initComponent();
        setLocationRelativeTo(owner);
    }

    public AuthDialog(Dialog owner, String title) {
        super(owner, title);
        initComponent();
        setLocationRelativeTo(owner);
    }

    public AuthDialog(Dialog owner, String title, boolean modal) {
        super(owner, title, modal);
        initComponent();
        setLocationRelativeTo(owner);
    }

    public AuthDialog(Dialog owner, String title, boolean modal, GraphicsConfiguration gc) {
        super(owner, title, modal, gc);
        initComponent();
        setLocationRelativeTo(owner);
    }

    public AuthDialog(Window owner) {
        super(owner);
        initComponent();
        setLocationRelativeTo(owner);
    }

    public AuthDialog(Window owner, ModalityType modalityType) {
        super(owner, modalityType);
        initComponent();
        setLocationRelativeTo(owner);
    }

    public AuthDialog(Window owner, String title) {
        super(owner, title);
        initComponent();
        setLocationRelativeTo(owner);
    }

    public AuthDialog(Window owner, String title, ModalityType modalityType) {
        super(owner, title, modalityType);
        initComponent();
        setLocationRelativeTo(owner);
    }

    public AuthDialog(Window owner, String title, ModalityType modalityType, GraphicsConfiguration gc) {
        super(owner, title, modalityType, gc);
        initComponent();
        setLocationRelativeTo(owner);
    }

    private void initComponent() {
        IconFontSwing.register(FontAwesome5.getIconFont());
        usuarioDB = new UsuarioDB();
        setUndecorated(true);
        setMinimumSize(new Dimension(360, 260));
        colorDialog = Colors.BLUE_MEDIUM;
        initSubComponents();
    }

    private void initSubComponents() {
        passwd = new JPasswordField();
        btnAuth = new FlatButton("Autorizar");

        initHeader();
        initInput();
    }

    private void initHeader() {
        FlatPanel panel = new FlatPanel(new BorderLayout());
        panel.setPadding(SpacingPoints.SP24);
        panel.setBackground(getColorDialog());

        FlatButton btnClose = new FlatButton(IconFontSwing.buildIcon(FontAwesome5.FA_TIMES, 14, Color.white));
        btnClose.setBackground(getColorDialog());
        btnClose.setFocusable(false);

        panel.add(BorderLayout.WEST, new FlatLabel("Autorización", FontSize.H2, Color.white));
        panel.add(BorderLayout.EAST, btnClose);

        btnClose.addActionListener(l -> this.dispose());

        getContentPane().add(BorderLayout.NORTH, panel);
    }

    private void initInput() {
        FlatPanel panel = new FlatPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setPadding(SpacingPoints.SP24);
        panel.setBackground(getColorDialog());
        panel.setLayout(layout);

        passwd.setBackground(panel.getBackground());
        passwd.setForeground(Color.white);
        passwd.setCaretColor(Color.white);
        FlatTextField.styleMaterial(passwd, Color.white);
        passwd.setPreferredSize(new Dimension(240, 30));

        FlatLabel lbPasswd = new FlatLabel("Contraseña", Color.white);

        JPanel pInput = Helpers.groupElementsHorizontal(
            Helpers.labelIcon(IconFontSwing.buildIcon(FontAwesome5.FA_LOCK, 18, Color.white), new Dimension(20, 20)),
            passwd
        );
        pInput.setBackground(getColorDialog());

        btnAuth.styleGhost();

        GridBagConstraints c = new GridBagConstraints();

        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        panel.add(lbPasswd, c);

        c.gridy = 1;
        panel.add(pInput, c);

        c.gridy = 2;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = Helpers.paddingInset(SpacingPoints.SP16, SpacingPoints.SP_NONE);
        panel.add(btnAuth, c);

        getContentPane().add(BorderLayout.CENTER, panel);
    }

    public boolean isAuth(char[] password) {
        String strPasswd = String.valueOf(password);
        return usuarioDB.auth(LoginController.CURRENT_USER, strPasswd);
    }

    public JPasswordField getPasswd() {
        return passwd;
    }

    public void setPasswd(JPasswordField passwd) {
        this.passwd = passwd;
    }

    public FlatButton getBtnAuth() {
        return btnAuth;
    }

    public void setBtnAuth(FlatButton btnAuth) {
        this.btnAuth = btnAuth;
    }

    public Color getColorDialog() {
        return colorDialog;
    }

    public void setColorDialog(Color colorDialog) {
        this.colorDialog = colorDialog;
    }
}
