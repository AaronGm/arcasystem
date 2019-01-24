package views.components.historial;

import enums.FontSize;
import helpers.Helpers;
import views.components.Component;
import views.components.FlatLabel;
import views.components.FlatPanel;

import java.awt.BorderLayout;

public class DatosEmpresa extends FlatPanel implements Component {

    private FlatPanel pnlMain;

    private FlatLabel lbRfc;
    private FlatLabel lbNombre;
    private FlatLabel lbEncargado;
    private FlatLabel lbDomicilio;
    private FlatLabel lbColonia;
    private FlatLabel lbCodigoPostal;
    private FlatLabel lbAlcaldiaMunicipio;
    private FlatLabel lbPaginaWeb;

    public DatosEmpresa() {
        initComponent();
    }

    @Override
    public void initComponent() {
        setLayout(new BorderLayout());
        initSubComponents();
        setSubComponents();
    }

    @Override
    public void initSubComponents() {
        pnlMain = new FlatPanel();
        lbRfc = new FlatLabel(FontSize.P);
        lbNombre = new FlatLabel(FontSize.P);
        lbEncargado = new FlatLabel(FontSize.P);
        lbDomicilio = new FlatLabel(FontSize.P);
        lbColonia = new FlatLabel(FontSize.P);
        lbCodigoPostal = new FlatLabel(FontSize.P);
        lbAlcaldiaMunicipio = new FlatLabel(FontSize.P);
        lbPaginaWeb = new FlatLabel(FontSize.P);

        initMain();
    }

    private void initMain() {
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("RFC"), lbRfc));
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Nombre"), lbNombre));
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Encargado"), lbEncargado));
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Domicilio"), lbDomicilio));
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Colonia"), lbColonia));
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Código Postal"), lbCodigoPostal));
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Alcaldía/Municipio"), lbAlcaldiaMunicipio));
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Página Web"), lbPaginaWeb));

    }

    @Override
    public void setSubComponents() {
        add(BorderLayout.NORTH, new FlatLabel("Datos de la empresa", FontSize.H2));
        add(BorderLayout.CENTER, pnlMain);
    }

    public FlatLabel getLbRfc() {
        return lbRfc;
    }

    public void setLbRfc(FlatLabel lbRfc) {
        this.lbRfc = lbRfc;
    }

    public FlatLabel getLbNombre() {
        return lbNombre;
    }

    public void setLbNombre(FlatLabel lbNombre) {
        this.lbNombre = lbNombre;
    }

    public FlatLabel getLbEncargado() {
        return lbEncargado;
    }

    public void setLbEncargado(FlatLabel lbEncargado) {
        this.lbEncargado = lbEncargado;
    }

    public FlatLabel getLbDomicilio() {
        return lbDomicilio;
    }

    public void setLbDomicilio(FlatLabel lbDomicilio) {
        this.lbDomicilio = lbDomicilio;
    }

    public FlatLabel getLbColonia() {
        return lbColonia;
    }

    public void setLbColonia(FlatLabel lbColonia) {
        this.lbColonia = lbColonia;
    }

    public FlatLabel getLbCodigoPostal() {
        return lbCodigoPostal;
    }

    public void setLbCodigoPostal(FlatLabel lbCodigoPostal) {
        this.lbCodigoPostal = lbCodigoPostal;
    }

    public FlatLabel getLbAlcaldiaMunicipio() {
        return lbAlcaldiaMunicipio;
    }

    public void setLbAlcaldiaMunicipio(FlatLabel lbAlcaldiaMunicipio) {
        this.lbAlcaldiaMunicipio = lbAlcaldiaMunicipio;
    }

    public FlatLabel getLbPaginaWeb() {
        return lbPaginaWeb;
    }

    public void setLbPaginaWeb(FlatLabel lbPaginaWeb) {
        this.lbPaginaWeb = lbPaginaWeb;
    }
}
