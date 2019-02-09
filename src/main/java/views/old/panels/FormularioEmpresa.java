package views.old.panels;

import enums.FontSize;
import enums.SpacingPoints;
import helpers.Helpers;
import views.old.components.Component;
import views.old.components.FlatLabel;
import views.old.components.FlatPanel;
import views.old.components.FlatScrollBar;
import views.old.components.FlatTextField;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class FormularioEmpresa extends FlatPanel implements Component {

    private FlatPanel pnlMain;
    private JScrollPane scrollPane;

    private FlatTextField txfRfc;
    private FlatTextField txfNombre;
    private FlatTextField txfEncargado;
    private FlatTextField txfDireccion;
    private FlatTextField txfColonia;
    private FlatTextField txfAlcaldiaMunicipio;
    private FlatTextField txfCodigoPostal;
    private FlatTextField txfCiudad;
    private FlatTextField txfTelefonos;
    private FlatTextField txfCorreo;
    private FlatTextField txfPaginaWeb;


    public FormularioEmpresa() {
        super(new BorderLayout());
        initComponent();
    }

    @Override
    public void initComponent() {
        setPadding(SpacingPoints.SP24, SpacingPoints.SP_NONE);
        initSubComponents();
        setSubComponents();
    }

    @Override
    public void initSubComponents() {
        pnlMain = new FlatPanel(new GridBagLayout());
        scrollPane = new JScrollPane(pnlMain);
        scrollPane.setVerticalScrollBar(new FlatScrollBar());
        scrollPane.setWheelScrollingEnabled(true);
        scrollPane.setBorder(null);

        txfRfc = new FlatTextField();
        txfNombre = new FlatTextField();
        txfEncargado = new FlatTextField();
        txfDireccion = new FlatTextField();
        txfColonia = new FlatTextField();
        txfAlcaldiaMunicipio = new FlatTextField();
        txfCodigoPostal = new FlatTextField();
        txfTelefonos = new FlatTextField();
        txfCorreo = new FlatTextField();
        txfPaginaWeb = new FlatTextField();
        txfCiudad = new FlatTextField();

        initMain();

    }

    private void initMain() {
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 0;
        c.insets = Helpers.paddingInset(SpacingPoints.SP_NONE, SpacingPoints.SP16, SpacingPoints.SP16, SpacingPoints.SP_NONE);
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("RFC"), txfRfc), c);

        c.gridy = 1;
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Nombre de la empresa"), txfNombre), c);

        c.gridy = 2;
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Encargado"), txfEncargado), c);

        c.gridy = 3;
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Dirección"), txfDireccion), c);
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Colonia"), txfColonia), c);

        c.gridy = 4;
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Alcaldía/Municipio"), txfAlcaldiaMunicipio), c);
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Código Postal"), txfCodigoPostal), c);

        c.gridy = 5;
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Ciudad"), txfCiudad), c);

        c.gridy = 6;
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Teléfono Oficina"), txfTelefonos), c);
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Correo"), txfCorreo), c);

        c.gridy = 7;
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Página web"), txfPaginaWeb), c);

    }

    @Override
    public void setSubComponents() {
        add(BorderLayout.NORTH, new FlatLabel("Registrar Empresa", FontSize.H3));
        add(BorderLayout.CENTER, scrollPane);
    }

    public FlatTextField getTxfRfc() {
        return txfRfc;
    }

    public FlatTextField getTxfNombre() {
        return txfNombre;
    }

    public FlatTextField getTxfEncargado() {
        return txfEncargado;
    }

    public FlatTextField getTxfDireccion() {
        return txfDireccion;
    }

    public FlatTextField getTxfColonia() {
        return txfColonia;
    }

    public FlatTextField getTxfAlcaldiaMunicipio() {
        return txfAlcaldiaMunicipio;
    }

    public FlatTextField getTxfCodigoPostal() {
        return txfCodigoPostal;
    }

    public FlatTextField getTxfCiudad() {
        return txfCiudad;
    }

    public FlatTextField getTxfTelefonos() {
        return txfTelefonos;
    }

    public FlatTextField getTxfCorreo() {
        return txfCorreo;
    }

    public FlatTextField getTxfPaginaWeb() {
        return txfPaginaWeb;
    }
}
