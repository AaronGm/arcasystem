package views.components.historial;

import enums.FontSize;
import enums.SpacingPoints;
import helpers.Helpers;
import views.components.Component;
import views.components.FlatLabel;
import views.components.FlatPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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
        setPadding(SpacingPoints.SP24, SpacingPoints.SP36);
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
        pnlMain.setLayout(new GridBagLayout());
        pnlMain.setPadding(SpacingPoints.SP24, SpacingPoints.SP36);
        GridBagConstraints c = new GridBagConstraints();

        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        c.insets = Helpers.paddingInset(SpacingPoints.SP_NONE, SpacingPoints.SP24, SpacingPoints.SP16, SpacingPoints.SP_NONE);

        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("RFC", Color.gray), lbRfc), c);

        c.gridy = 1;
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Nombre de la Empresa", Color.gray), lbNombre), c);
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Encargado", Color.gray), lbEncargado), c);

        c.gridy = 2;
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Domicilio", Color.gray), lbDomicilio), c);

        c.gridy = 3;
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Colonia", Color.gray), lbColonia), c);
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Código Postal", Color.gray), lbCodigoPostal), c);
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Alcaldía/Municipio", Color.gray), lbAlcaldiaMunicipio), c);

        c.gridy = 4;
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Página Web", Color.gray), lbPaginaWeb), c);

    }

    @Override
    public void setSubComponents() {
        add(BorderLayout.NORTH, new FlatLabel("Datos de la empresa", FontSize.H2));
        add(BorderLayout.WEST, pnlMain);
    }

    public FlatLabel getLbRfc() {
        return lbRfc;
    }

    public FlatLabel getLbNombre() {
        return lbNombre;
    }

    public FlatLabel getLbEncargado() {
        return lbEncargado;
    }

    public FlatLabel getLbDomicilio() {
        return lbDomicilio;
    }

    public FlatLabel getLbColonia() {
        return lbColonia;
    }

    public FlatLabel getLbCodigoPostal() {
        return lbCodigoPostal;
    }

    public FlatLabel getLbAlcaldiaMunicipio() {
        return lbAlcaldiaMunicipio;
    }

    public FlatLabel getLbPaginaWeb() {
        return lbPaginaWeb;
    }
}
