/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import enums.FontAwesome5;
import helpers.Helpers;
import jiconfont.swing.IconFontSwing;
import models.Alumno;
import views.components.AuthDialog;
import views.components.FlatButton;
import views.components.FlatCheckbox;
import views.components.FlatLabel;
import views.components.FlatPanel;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.util.Arrays;

/**
 *
 * @author aarongmx
 */
public class RegistrarExpediente extends View {
    
    private FlatPanel pnlForm;
    private FlatPanel pnlHistorialAlumno;

    private FlatCheckbox cartaInicio;
    private FlatCheckbox asesorias;
    private FlatCheckbox cronograma;
    private FlatCheckbox formato008;
    private FlatCheckbox formato009;
    private FlatCheckbox cartaTermino;
    private FlatCheckbox discos;
    private FlatCheckbox cartaLiberacion;

    private JTextArea estatus;

    private FlatButton btnGuardar;

    private Alumno alumno;

    public RegistrarExpediente() throws HeadlessException {
        super("Registrar Expediente");
    }

    @Override
    protected void initComponents() {
        IconFontSwing.register(FontAwesome5.getIconFont("solid"));
        pnlForm = new FlatPanel();
        pnlHistorialAlumno = new FlatPanel();

        cartaInicio = new FlatCheckbox("Carta de Inicio");
        asesorias = new FlatCheckbox("Asesorias");
        cronograma = new FlatCheckbox("Cronograma");
        formato008 = new FlatCheckbox("Formato 008");
        formato009 = new FlatCheckbox("Formato 009");
        cartaTermino = new FlatCheckbox("Carta de término");
        discos = new FlatCheckbox("Discos");
        cartaLiberacion = new FlatCheckbox("Carta de liberación");
        estatus = new JTextArea();


        btnGuardar = new FlatButton("Guardar expediente");

        Helpers.setWhite(pnlForm, pnlHistorialAlumno);

        initForm();
        initDataAlumno();
    }

    @Override
    protected void setComponents() {
        JPanel pnlCenter = new JPanel(new BorderLayout());
        pnlCenter.add(BorderLayout.EAST, pnlForm);
        pnlCenter.add(BorderLayout.CENTER, pnlHistorialAlumno);
        add(BorderLayout.CENTER, pnlCenter);
    }

    private void initForm() {
        pnlForm.setPreferredSize(new Dimension(Helpers.PANTALLA.width/3 - 180, this.getHeight()));
        pnlForm.setLayout(new BoxLayout(pnlForm, BoxLayout.Y_AXIS));

        alumno = new Alumno("Aarón", "Gómez", "Méndez", "151080126", 9, "Enero - Junio 2019", "ISC");

        pnlForm.add(new FlatLabel("Documentos", "Raleway", "h2"));
        pnlForm.add(Box.createVerticalStrut(24));

        Arrays.asList(new FlatCheckbox[]{
                cartaInicio,
                cronograma,
                asesorias,
                formato008,
                formato009,
                discos,
                cartaTermino,
                cartaLiberacion
        }).forEach(item -> pnlForm.add(item));

        JScrollPane scrollPane = new JScrollPane(estatus);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        pnlForm.add(Box.createVerticalStrut(16));
        pnlForm.add(new FlatLabel("Estatus de las residencias profesionales"));
        pnlForm.add(scrollPane);

        pnlForm.add(btnGuardar);

        btnGuardar.addActionListener(l -> {
            AuthDialog authDialog = new AuthDialog(this, "Hola");
            authDialog.setVisible(true);
        });
    }

    private void initDataAlumno() {
        pnlHistorialAlumno.setLayout(new BorderLayout());

        pnlHistorialAlumno.add(BorderLayout.NORTH ,new FlatLabel("Datos del alumno", "Raleway", "h2"));

        FlatPanel pnlDatosAlumno = new FlatPanel(16, 8);
        pnlDatosAlumno.setLayout(new GridBagLayout());
        pnlDatosAlumno.setBackground(Color.white);

        Alumno alumno = new Alumno("Aarón", "Gómez", "Méndez", "151080126", 9, "Enero - Junio 2020", "ISC");

        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        pnlDatosAlumno.add(
            Helpers.verticalElements(
                new FlatLabel("Número de Control"),
                new FlatLabel(alumno.getNoControl(), "pr")
            ),
            c
        );
        pnlDatosAlumno.add(Box.createHorizontalStrut(16), c);
        pnlDatosAlumno.add(
            Helpers.verticalElements(
                new FlatLabel("Nombre Completo"),
                new FlatLabel(alumno.getNombreCompleto(), "pr")
            ),
            c
        );
        pnlDatosAlumno.add(Box.createHorizontalStrut(16));
        pnlDatosAlumno.add(
            Helpers.verticalElements(
                new FlatLabel("Carrera"),
                new FlatLabel(alumno.getClaveCarrera(), "pr")
            ),
            c
        );
        pnlDatosAlumno.add(Box.createHorizontalStrut(16), c);
        pnlDatosAlumno.add(
            Helpers.verticalElements(
                new FlatLabel("Periodo"),
                new FlatLabel(alumno.getPeriodo(), "pr")
            ),
            c
        );

        c.gridy = 3;
        c.gridwidth = 10;
        pnlDatosAlumno.add(Box.createRigidArea(new Dimension(120, 168)));

        c.gridy = 2;
        c.gridx = 0;
        pnlDatosAlumno.add(
            Helpers.verticalElements(
                new FlatLabel("Proyecto"),
                new FlatLabel("IA clasificadora de imagénes", "pr")
            ),
            c
        );

        pnlHistorialAlumno.add(BorderLayout.CENTER, pnlDatosAlumno);

    }
    
    
}
