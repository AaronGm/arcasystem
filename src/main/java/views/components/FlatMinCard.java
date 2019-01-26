package views.components;

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
    private FlatLabel date;
    private FlatLabel prof;
    private FlatButton btn;


    public FlatMinCard(String strTitle, String strDate, String strProf) {
        initComponent();
        title.setText(strTitle);
        date.setText(strDate);
        prof.setText(strProf);
    }

    public FlatMinCard() {
        super(SpacingPoints.SP16, SpacingPoints.SP8);
        initComponent();
    }

    private void initComponent() {
        setMinimumSize(new Dimension(380, 160));
        setBackground(Color.white);
        setBorder(new CompoundBorder(new MatteBorder(0, 0, 1, 0, Color.lightGray), super.getBorder()));
        initComponents();
        setComponets();
    }

    private void initComponents() {
        title = new FlatLabel(FontSize.H3);
        date = new FlatLabel(FontSize.SM);
        prof = new FlatLabel(FontSize.P);
        btn = new FlatButton("detalles");
        btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    private void setComponets() {
        add(title);
        add(date);
        add(Box.createVerticalStrut(SpacingPoints.SP8.getSize()));
        add(prof);
        add(Box.createVerticalStrut(SpacingPoints.SP8.getSize()));
        add(btn);
    }

    public FlatLabel getTitle() {
        return title;
    }

    public void setTitle(FlatLabel title) {
        this.title = title;
    }

    public FlatLabel getDate() {
        return date;
    }

    public void setDate(FlatLabel date) {
        this.date = date;
    }

    public FlatLabel getProf() {
        return prof;
    }

    public void setProf(FlatLabel prof) {
        this.prof = prof;
    }

    public FlatButton getBtn() {
        return btn;
    }

    public void setBtn(FlatButton btn) {
        this.btn = btn;
    }
}
