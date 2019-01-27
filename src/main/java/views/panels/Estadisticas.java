package views.panels;

import enums.FontFamily;
import enums.FontSize;
import helpers.Helpers;
import helpers.Typography;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.XYStyler;
import views.components.Component;
import views.components.FlatPanel;

import java.awt.Color;

public class Estadisticas extends FlatPanel implements Component {

    private XChartPanel xChartPanel;
    private XYChart pieChart;

    public static final String PANEL_NAME = "Card Estadisticas";

    public Estadisticas() {
        initComponent();
    }

    @Override
    public void initComponent() {
        initSubComponents();
        setSubComponents();
    }

    @Override
    public void initSubComponents() {
        pieChart = new XYChart(600, 460);
        pieChart.setTitle("Eficiencia Terminal");
        XYStyler styler = pieChart.getStyler();
        styler.setLegendPosition(Styler.LegendPosition.InsideNE);
        styler.setChartBackgroundColor(Color.white);
        styler.setAxisTitlesVisible(true);
        styler.setBaseFont(Typography.addFont(FontFamily.ROBOTO, FontSize.P));
        pieChart.addSeries("on", new double[] {-1, 2, 3, 5}, new double[] {2, 4, 12, 0});
        pieChart.addSeries("on2", new double[] {2, 5, 8, 12}, new double[] {10, 12, 2, -3});
        xChartPanel = new XChartPanel(pieChart);
    }

    @Override
    public void setSubComponents() {
        add(xChartPanel);
    }
}
