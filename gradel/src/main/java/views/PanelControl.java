/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.toedter.calendar.JCalendar;
import controllers.LoginController;
import helpers.Colors;
import helpers.Helpers;
import helpers.Typography;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import org.knowm.xchart.XYChart;
import views.components.FlatButton;
import views.components.FlatLabel;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

/**
 *
 * @author aarongmx
 */
public class PanelControl extends View {

    private JPanel pnlMain;
    private JPanel pnlMenu;
    
    private JPanel pnlCenter;
    
    private JPanel pnlCalendar;
    private JPanel pnlForm;
    private JPanel pnlEstadistics;
    
    private CardLayout cardLayout;
    private JCalendar calendar;
    
    private XYChart grafica;
    
    private final String CALENDAR = "Card Calendar";
    private final String ESTADISTICS = "Card Estadistics";
    
    public PanelControl() throws HeadlessException {
        super("Panel de Control");
    }

    @Override
    protected void initComponents() {
        IconFontSwing.register(FontAwesome.getIconFont());
        pnlMain = new JPanel();
        pnlMenu = new JPanel();
        calendar = new JCalendar();
        
        cardLayout = new CardLayout();
        pnlCenter = new JPanel(cardLayout);
        
        pnlCalendar = new JPanel();
        pnlEstadistics = new JPanel();
        pnlForm = new JPanel();

        initMenu();
        initMain();
    }

    @Override
    protected void setComponents() {
        getContentPane().add(BorderLayout.WEST, pnlMenu);
        getContentPane().add(BorderLayout.CENTER, pnlCenter);
    }

    private void initMain() {
        pnlMain.setBorder(Helpers.padding(16));
        pnlMain.setBackground(Color.white);
        pnlMain.setLayout(new BorderLayout());
        pnlMain.add(BorderLayout.NORTH, new FlatLabel("Panel de Control" ,"h1"));
        
        calendar.setFont(Typography.paragraphFont());
        calendar.setTodayButtonVisible(true);
        calendar.setSundayForeground(Colors.RED);
        
        pnlCalendar.setLayout(new BorderLayout());
        pnlCalendar.setBorder(Helpers.padding(16, 0));
        pnlCalendar.add(BorderLayout.CENTER, calendar);
        
        pnlForm.add(Helpers.makeImage("icon.png", new Dimension(80, 80)));
        
        pnlCenter.add(pnlCalendar, CALENDAR);
        pnlCenter.add(pnlEstadistics, ESTADISTICS);
        pnlCenter.add(pnlForm);
        
        FlatButton lbWord = new FlatButton("Asignación de asesor", IconFontSwing.buildIcon(FontAwesome.FILE_WORD_O, 24, Colors.WORD));
        lbWord.styleGhost();
        
        FlatButton lbExcel = new FlatButton("Publicación de anteproyectos", IconFontSwing.buildIcon(FontAwesome.FILE_EXCEL_O, 24, Colors.EXCEL));
        lbExcel.styleGhost();
        
        pnlEstadistics.add(lbWord);
        pnlEstadistics.add(lbExcel);
        
        pnlMain.add(BorderLayout.CENTER, pnlCenter);
        Helpers.setWhite(pnlCalendar, pnlEstadistics, pnlForm);
    }
    
    private void initMenu() {
        pnlMenu.setBackground(Colors.GHOST_LIGHT);
        pnlMenu.setPreferredSize(new Dimension(220, HEIGHT));
        pnlMenu.setBorder(Helpers.padding(32, 16));
        pnlMenu.setLayout(new FlowLayout());
        
        ButtonGroup group = new ButtonGroup();
        
        JToggleButton tbtnCalendario = styleButtonsMenu("Calendario", IconFontSwing.buildIcon(FontAwesome.CALENDAR_O, 18, Colors.BLACK_MEDIUM));
        JToggleButton tbtnEstadisticas = styleButtonsMenu("Estadisticas", IconFontSwing.buildIcon(FontAwesome.BAR_CHART, 18, Colors.BLACK_MEDIUM));
        
        tbtnCalendario.setSelected(true);
        
        group.add(tbtnCalendario);
        group.add(tbtnEstadisticas);
        
        ActionListener actionListener = (ActionEvent e) -> {
            JToggleButton tbtn = (JToggleButton)e.getSource();
            if (tbtn == tbtnCalendario) {
                cardLayout.show(pnlCenter, CALENDAR);
            } else if(tbtn == tbtnEstadisticas) {
                cardLayout.show(pnlCenter, ESTADISTICS);
            }
        };
        
        tbtnCalendario.addActionListener(actionListener);
        tbtnEstadisticas.addActionListener(actionListener);
        
        FlatLabel lab = new FlatLabel(LoginController.CURRENT_USER);
        
        pnlMenu.add(Helpers.logoItiz(100));
        pnlMenu.add(lab);
        pnlMenu.add(tbtnCalendario);
        pnlMenu.add(tbtnEstadisticas);
    }
    
    private JToggleButton styleButtonsMenu(String text, Icon icon) {
        JToggleButton tbtn = new JToggleButton(text, icon);
        tbtn.setHorizontalAlignment(SwingConstants.LEFT);
        tbtn.setPreferredSize(new Dimension(180, 30));
        tbtn.setBackground(null);
        tbtn.setFont(Typography.componentsFont());
        tbtn.setForeground(Colors.BLACK_MEDIUM);
        Border defaultBorder = new CompoundBorder(null, Helpers.padding(4, 8));
        tbtn.setBorder(defaultBorder);
        tbtn.setFocusPainted(false);

        
        tbtn.addItemListener(((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                tbtn.setBorder(new CompoundBorder(new MatteBorder(0, 3, 0, 0, Colors.BLUE_LIGHT), Helpers.padding(8, 16)));
            } else {
                tbtn.setBorder(defaultBorder);
            }
        }));
        
        return tbtn;
    }
    
    
}
