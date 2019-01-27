package views.panels;

import enums.FontSize;
import views.components.Component;
import views.components.FlatButton;
import views.components.FlatLabel;
import views.components.FlatPanel;

import java.awt.BorderLayout;

public class RegistrarProyecto extends FlatPanel implements Component {

    public static final String PANEL_NAME = "Registrar Proyecto";

    private FlatButton btnNext;
    private FlatButton btnLast;



    public RegistrarProyecto() {
        super();
        initComponent();
    }

    @Override
    public void initComponent() {
        initSubComponents();
        setSubComponents();
    }

    @Override
    public void initSubComponents() {
        btnNext = new FlatButton("Siguiente");
        btnLast = new FlatButton("Atrás");
    }

    @Override
    public void setSubComponents() {
        add(BorderLayout.CENTER, new FlatLabel("Registrar Proyecto", FontSize.H1));
        add(BorderLayout.WEST, btnLast);
        add(BorderLayout.EAST, btnNext);
    }

    public FlatButton getBtnNext() {
        return btnNext;
    }

    public FlatButton getBtnLast() {
        return btnLast;
    }
}
