package views.old.components;

import enums.FontSize;
import enums.SpacingPoints;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

public class FlatMinCard extends FlatPanel {

    private FlatLabel title;
    private FlatLabel subtitle;
    private FlatLabel content;
    private FlatButton btn;


    public FlatMinCard(String strTitle, String strDate, String strProf) {
        initComponent();
        title.setText(strTitle);
        subtitle.setText(strDate);
        content.setText(strProf);
    }

    public FlatMinCard() {
        super(SpacingPoints.SP16, SpacingPoints.SP8);
        initComponent();
    }

    private void initComponent() {
        setMinimumSize(new Dimension(380, 140));
        setBackground(Color.white);
        initComponents();
        setComponets();
    }

    public void styleCard() {
        setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, Color.lightGray), super.getBorder()));
    }

    public void styleList() {
        setBorder(new CompoundBorder(new MatteBorder(0, 0, 1, 0, Color.lightGray), super.getBorder()));
    }

    private void initComponents() {
        title = new FlatLabel(FontSize.H3);
        subtitle = new FlatLabel(FontSize.SM);
        content = new FlatLabel(FontSize.P);
        btn = new FlatButton("detalles");
        btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    private void setComponets() {
        add(title);
        add(subtitle);
        add(Box.createVerticalStrut(SpacingPoints.SP8.getSize()));
        add(content);
        add(Box.createVerticalStrut(SpacingPoints.SP8.getSize()));
        add(btn);
    }

    public FlatLabel getTitle() {
        return title;
    }

    public void setTitle(FlatLabel title) {
        this.title = title;
    }

    public FlatLabel getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(FlatLabel subtitle) {
        this.subtitle = subtitle;
    }

    public FlatLabel getContent() {
        return content;
    }

    public void setContent(FlatLabel content) {
        this.content = content;
    }

    public FlatButton getBtn() {
        return btn;
    }

    public void setBtn(FlatButton btn) {
        this.btn = btn;
    }
}
