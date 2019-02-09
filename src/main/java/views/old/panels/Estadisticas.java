package views.old.panels;

import dao.postgres.ProyectoDB;
import enums.FontFamily;
import enums.FontSize;
import enums.SpacingPoints;
import helpers.Colors;
import helpers.Typography;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieSeries;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.style.CategoryStyler;
import org.knowm.xchart.style.PieStyler;
import org.knowm.xchart.style.Styler;
import views.old.components.Component;
import views.old.components.FlatLabel;
import views.old.components.FlatPanel;
import views.old.components.FlatScrollBar;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;

public class Estadisticas extends FlatPanel implements Component {

    private FlatPanel pnlMain;
    private JScrollPane jScrollPane;

    private XChartPanel<PieChart> xChartPanel;
    private XChartPanel<PieChart> xChartPanel1;
    private XChartPanel<CategoryChart> xChartPanel2;
    private PieChart pieChartSemanas;
    private PieChart pieChartTipoProyectos;
    private CategoryChart categoryChartEficienciaTerminal;
    private PieStyler pieStyler;
    private CategoryStyler categoryStyler;

    public static final String NAME = "Card Estadisticas";

    public Estadisticas() {
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
        pieStyler = new PieStyler();
        categoryStyler = new CategoryStyler();

        pieChartSemanas = new PieChart(500, 500);
        pieChartTipoProyectos = new PieChart(500, 500);
        categoryChartEficienciaTerminal = new CategoryChart(500, 500);


        xChartPanel = new XChartPanel<>(pieChartSemanas);
        xChartPanel1 = new XChartPanel<>(pieChartTipoProyectos);
        xChartPanel2 = new XChartPanel<>(categoryChartEficienciaTerminal);


        pnlMain = new FlatPanel();
        pnlMain.setPadding(SpacingPoints.SP24, SpacingPoints.SP_NONE);

        jScrollPane = new JScrollPane(pnlMain);
        jScrollPane.setVerticalScrollBar(new FlatScrollBar());
        jScrollPane.setBorder(null);


        semanasProyectoGraph();
        categoriasProyectosGraph();
        eficienciaTerminal();
        initMain();
    }

    private void categoriasProyectosGraph() {
        pieStyler = pieChartTipoProyectos.getStyler();
        pieChartTipoProyectos.setTitle("Tipo de proyectos");
        pieChartTipoProyectos.addSeries("Web", porcentajeProyectos(30, 4));
        pieChartTipoProyectos.addSeries("Bases de datos", porcentajeProyectos(30, 10));
        pieChartTipoProyectos.addSeries("Redes", porcentajeProyectos(30, 12));
        pieChartTipoProyectos.addSeries("Aplicaciones móviles", porcentajeProyectos(30, 4));

        customEstadisticsGraphics(pieChartTipoProyectos);
    }

    private void semanasProyectoGraph() {
        pieStyler = pieChartSemanas.getStyler();
        pieChartSemanas.setTitle("Tiempos seleccionados");
        int[] semanas16 = new ProyectoDB().analisisSemanas(16, "Ene - Jun 2019");
        int[] semanas24 = new ProyectoDB().analisisSemanas(24, "Ene - Jun 2019");
        pieChartSemanas.addSeries("16 semanas", 10);
        pieChartSemanas.addSeries("24 semanas", 90);
        pieChartSemanas.updatePieSeries("16 semanas", porcentajeSemanas(semanas16[0], semanas16[1]));
        pieChartSemanas.updatePieSeries("24 semanas", porcentajeSemanas(semanas24[0], semanas24[1]));

        customEstadisticsGraphics(pieChartSemanas);
    }

    private void eficienciaTerminal() {
        categoryStyler = categoryChartEficienciaTerminal.getStyler();
        categoryChartEficienciaTerminal.setTitle("Eficiencia Terminal");
        categoryChartEficienciaTerminal.setXAxisTitle("Periodo de egreso");
        categoryChartEficienciaTerminal.setYAxisTitle("Alumnos Egresados");
        ArrayList<String> list = new ArrayList<>();
        list.add("Enero - Junio");
        list.add("Agosto - Diciembre");
        categoryChartEficienciaTerminal.addSeries("2017", list, Arrays.asList(12, 22));
        categoryChartEficienciaTerminal.addSeries("2018", list, Arrays.asList(18, 20));
        categoryChartEficienciaTerminal.addSeries("2019", list, Arrays.asList(34, 12));
        categoryChartEficienciaTerminal.addSeries("2020", list, Arrays.asList(30, 28));

        categoryStyler.setChartFontColor(Colors.TEXT_COLOR);
        categoryStyler.setPlotBorderVisible(false);
        categoryStyler.setHasAnnotations(true);
        categoryStyler.setPlotContentSize(0.85);
        categoryStyler.setXAxisTickMarkSpacingHint(5);
        categoryStyler.setSeriesColors(Colors.sliceColors);
        categoryStyler.setChartBackgroundColor(Color.white);
        categoryStyler.setAnnotationsFont(Typography.addFont(FontFamily.ROBOTO, FontSize.P));
    }

    private void initMain() {
        pnlMain.setLayout(new GridLayout(0, 2, 8, 36));
        pnlMain.add(xChartPanel);
        pnlMain.add(xChartPanel1);
        pnlMain.add(xChartPanel2);
    }

    private void customEstadisticsGraphics(PieChart pieChart) {
        pieStyler = pieChart.getStyler();
        pieStyler.setDefaultSeriesRenderStyle(PieSeries.PieSeriesRenderStyle.Donut);
        pieStyler.setChartFontColor(Colors.TEXT_COLOR);
        pieStyler.setChartBackgroundColor(Color.white);
        pieStyler.setLegendBorderColor(Color.white);
        pieStyler.setPlotContentSize(0.65);
        pieStyler.setPlotBorderVisible(false);
        pieStyler.setSeriesColors(Colors.sliceColors);
        pieStyler.setDonutThickness(0.2);
        pieStyler.setDrawAllAnnotations(true);
        pieStyler.setAnnotationDistance(1.15);
        pieStyler.setAnnotationsFont(Typography.addFont(FontFamily.OPEN_SANS, FontSize.SM));
        pieStyler.setLegendLayout(Styler.LegendLayout.Vertical);
        pieStyler.setLegendPosition(Styler.LegendPosition.OutsideE);
        pieStyler.setSumVisible(true);
        pieStyler.setSumFont(Typography.titleFont(FontSize.H1));
    }

    @Override
    public void setSubComponents() {
        add(BorderLayout.NORTH, new FlatLabel("Estadísticas", FontSize.H2));
        add(BorderLayout.CENTER, jScrollPane);
    }

    /**
     * @param totalProyectos
     * @param CProyectos
     * @return
     */
    public float porcentajeProyectos(int totalProyectos, int CProyectos) {
        return (float)CProyectos * 100 / totalProyectos;
    }

    public float porcentajeEgresados(int totalAlumnos, int alumnosFin) {
        return (float)alumnosFin * 100 / totalAlumnos;
    }

    public float porcentajeSemanas(int totalAlumnos, int alumnos) {
        return (float)alumnos * 100 / totalAlumnos;
    }

    public PieChart getPieChartSemanas() {
        return pieChartSemanas;
    }

    public PieChart getPieChartTipoProyectos() {
        return pieChartTipoProyectos;
    }

    public CategoryChart getCategoryChartEficienciaTerminal() {
        return categoryChartEficienciaTerminal;
    }
}
