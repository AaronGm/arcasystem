/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import helpers.Helpers;
import models.Alumno;
import views.components.FlatCheckbox;
import views.components.FlatLabel;
import views.components.HeaderApp;
import views.components.MenuApp;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.util.Arrays;

/**
 *
 * @author aarongmx
 */
public class RegistrarExpediente extends JFrame {
    
    private JPanel pnlForm;
    private JPanel pnlHistorialAlumno;

    private FlatCheckbox cartaInicio;
    private FlatCheckbox asesorias;
    private FlatCheckbox cronograma;
    private FlatCheckbox formato008;
    private FlatCheckbox formato009;
    private FlatCheckbox cartaTermino;
    private FlatCheckbox discos;
    private FlatCheckbox cartaLiberacion;
    private FlatLabel estatus;

    private Alumno alumno;

    public RegistrarExpediente() throws HeadlessException {
        initView();
    }

    private void initView() {
        helpers.Helpers.minScreenSize(this);
        initComponents();
        setJMenuBar(new MenuApp());
        add(BorderLayout.NORTH, new HeaderApp("Registrar Expediente"));

        JPanel pnlCenter = new JPanel(new BorderLayout());
        pnlCenter.add(BorderLayout.EAST, pnlForm);
        pnlCenter.add(BorderLayout.CENTER, pnlHistorialAlumno);
        add(BorderLayout.CENTER, pnlCenter);
        helpers.Helpers.centerCloseScreen(this);
    }
    
    private void initComponents() {
        pnlForm = new JPanel();
        pnlHistorialAlumno = new JPanel();

        cartaInicio = new FlatCheckbox("Carta de Inicio");
        asesorias = new FlatCheckbox("Asesorias");
        cronograma = new FlatCheckbox("Cronograma");
        formato008 = new FlatCheckbox("Formato 008");
        formato009 = new FlatCheckbox("Formato 009");
        cartaTermino = new FlatCheckbox("Carta de término");
        discos = new FlatCheckbox("Discos");
        cartaLiberacion = new FlatCheckbox("Carta de liberación");
        estatus = new FlatLabel("Estado de la residencia:");

        Helpers.setWhite(pnlForm, pnlHistorialAlumno);

        initForm();
        initDataAlumno();
    }
    
    private void initForm() {
        pnlForm.setPreferredSize(new Dimension(Helpers.PANTALLA.width/3 - 180, this.getHeight()));
        pnlForm.setLayout(new BoxLayout(pnlForm, BoxLayout.Y_AXIS));
        pnlForm.setBorder(Helpers.padding(32, 16));

        alumno = new Alumno("151080126", 8, "Enero - Junio 2019", "ISC", 1, 1, 1, 1, "Aarón", "Gómez", "Méndez");

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
        }).forEach(item -> {
            pnlForm.add(item);
        });
    }

    private void initDataAlumno() {
        pnlHistorialAlumno.setBorder(Helpers.padding(32, 16));
        pnlHistorialAlumno.setLayout(new BorderLayout());

        pnlHistorialAlumno.add(BorderLayout.NORTH ,new FlatLabel("Datos del alumno", "Raleway", "h2"));

        JPanel pnlDatosAlumno = new JPanel();
        GroupLayout layout = new GroupLayout(pnlDatosAlumno);
        pnlDatosAlumno.setBackground(Color.white);

        /*layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addComponent(new FlatLabel("No. Control"))
                        .addComponent(new FlatLabel(alumno.getNoControl(), "Open Sans", "pr")).addGroup(layout.createSequentialGroup(
                )
        );*/

//        pnlDatosAlumno.add(new FlatLabel("No. Control"));
//        pnlDatosAlumno.add(new FlatLabel(alumno.getNoControl(), "Open Sans", "pr"));

//        pnlDatosAlumno.add(new FlatLabel("Nombre"));
//        pnlDatosAlumno.add(new FlatLabel(alumno.getNombreCompleto(), "Open Sans", "pr"));


        pnlHistorialAlumno.add(BorderLayout.CENTER, pnlDatosAlumno);

    }
    
    
}
