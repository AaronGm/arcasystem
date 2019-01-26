package views.components.controlpanel;

import com.toedter.calendar.JCalendar;
import enums.FontSize;
import enums.SpacingPoints;
import helpers.Helpers;
import helpers.Typography;
import views.components.Component;
import views.components.FlatLabel;
import views.components.FlatMinCard;
import views.components.FlatPanel;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;


public class AlertTicketInspector extends FlatPanel implements Component {

    public static final String NAME = "Card Alert Inspector";
    private JCalendar calendar;

    private FlatPanel pnlCalendar;
    private FlatPanel pnlEvents;
    private FlatPanel pnlCards;

    private JScrollPane scrollPane;

    public AlertTicketInspector() {
        super();
        initComponent();
    }

    @Override
    public void initComponent() {
        setName(NAME);
        setLayout(new BorderLayout());
        setBackground(Color.white);
        initSubComponents();
        setSubComponents();
    }

    @Override
    public void initSubComponents() {
        calendar = new JCalendar();
        calendar.setFont(Typography.paragraphFont());
        calendar.setDecorationBackgroundVisible(false);
        calendar.setTodayButtonVisible(true);
        calendar.getDayChooser().getDayPanel().setBackground(Color.white);

        pnlCalendar = new FlatPanel();

        pnlEvents = new FlatPanel();
        pnlEvents.setPreferredSize(new Dimension(340, 0));

        pnlCards = new FlatPanel(SpacingPoints.SP8, SpacingPoints.SP16);
        pnlCards.setLayout(new GridLayout(0, 1));
        pnlCards.setBackground(Color.white);

        scrollPane = new JScrollPane(pnlCards);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setWheelScrollingEnabled(true);
        scrollPane.setBorder(null);

        initEvents();
        initCalendar();
    }

    private void initCalendar() {
        pnlCalendar.setLayout(new BorderLayout());
        pnlCalendar.add(BorderLayout.NORTH, new FlatLabel("Calendario", FontSize.H3));
        pnlCalendar.add(BorderLayout.CENTER, calendar);
    }

    private void initEvents() {
        pnlEvents.setLayout(new BorderLayout());
        pnlEvents.add(BorderLayout.NORTH, new FlatLabel("Próximas Revisiones", FontSize.H3));
        pnlEvents.add(BorderLayout.CENTER, scrollPane);
        pnlCards.add(new FlatMinCard("Fecha de revisor", "10/10/2019", "Ing. Francisco Iván Pedraza Cruz"));
    }

    @Override
    public void setSubComponents() {
        add(BorderLayout.NORTH, new FlatLabel("Fechas Revisores", FontSize.H2));
        add(BorderLayout.CENTER, pnlCalendar);
        add(BorderLayout.EAST, pnlEvents);
    }

    public FlatPanel getPnlCards() {
        return pnlCards;
    }
}
