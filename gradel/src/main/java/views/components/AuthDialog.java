package views.components;

import enums.FontAwesome5;
import helpers.Colors;
import helpers.Helpers;
import jiconfont.swing.IconFontSwing;

import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;

public class AuthDialog extends JDialog {

    private JPasswordField passwd;
    private FlatButton btnAuth;
    private Color colorDialog;

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
        panel.setBackground(getColorDialog());

        FlatButton btnClose = new FlatButton(IconFontSwing.buildIcon(FontAwesome5.FA_TIMES, 14, Color.white));
        btnClose.setBackground(getColorDialog());
        btnClose.setFocusable(false);

        panel.add(BorderLayout.WEST, new FlatLabel("Autorización", "h2", Color.white));
        panel.add(BorderLayout.EAST, btnClose);

        btnClose.addActionListener(l -> this.dispose());

        getContentPane().add(BorderLayout.NORTH, panel);
    }

    private void initInput() {
        FlatPanel panel1 = new FlatPanel();
        GroupLayout layout = new GroupLayout(panel1);
        panel1.setBackground(getColorDialog());
        panel1.setLayout(layout);

        passwd.setBackground(panel1.getBackground());
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

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lbPasswd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                )

                .addComponent(pInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(btnAuth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)

        );

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)

                .addGroup(layout.createSequentialGroup()
                    .addComponent(lbPasswd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(pInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAuth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                )
        );

        getContentPane().add(BorderLayout.CENTER, panel1);
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
