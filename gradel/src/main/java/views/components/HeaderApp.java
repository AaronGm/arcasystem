/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author aarongmx
 */
public class HeaderApp extends JPanel {
    
    private JLabel tituloVentana;
    private JLabel subtituloVentana;
    
    public HeaderApp(String titulo) {
        tituloVentana = new JLabel(titulo);
        initComponent();
    }
    
    private void initComponent() {
        tituloVentana.setFont(helpers.Typography.addFont("Raleway", "h1"));
        setBackground(Color.white);
        setLayout(new BorderLayout());
        setBorder(helpers.Helpers.padding(16, 32));
        add(tituloVentana, BorderLayout.WEST);
        add(helpers.Helpers.logoItiz(60), BorderLayout.EAST);
    }

    public JLabel getTituloVentana() {
        return tituloVentana;
    }

    public void setTituloVentana(JLabel tituloVentana) {
        this.tituloVentana = tituloVentana;
    }

    public JLabel getSubtituloVentana() {
        return subtituloVentana;
    }

    public void setSubtituloVentana(JLabel subtituloVentana) {
        this.subtituloVentana = subtituloVentana;
    }    
}
