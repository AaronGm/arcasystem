package views.components;

import helpers.Colors;
import helpers.Typography;
import views.components.table.FlatButtonRenderTable;
import views.components.table.HeaderRenderFlatTable;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import java.awt.Color;
import java.awt.Dimension;

/**
 *
 * @author aarongmx
 */
public class FlatTable extends JTable {

    public FlatTable() {
        initView();
    }

    public FlatTable(TableModel dm) {
        super(dm);
        initView();
    }

    public FlatTable(TableModel dm, TableColumnModel cm) {
        super(dm, cm);
        initView();
    }

    public FlatTable(TableModel dm, TableColumnModel cm, ListSelectionModel sm) {
        super(dm, cm, sm);
        initView();
    }

    public FlatTable(int numRows, int numColumns) {
        super(numRows, numColumns);
        initView();
    }

    public FlatTable(Object[][] rowData, Object[] columnNames) {
        super(rowData, columnNames);
        initView();
    }
    
    private void initView() {
        setFont(Typography.paragraphFont());
        setGridColor(Colors.BLACK_LIGHT);
        setRowHeight(24);
        setShowGrid(false);
        setShowHorizontalLines(false);
        setShowVerticalLines(false);
        setIntercellSpacing(new Dimension(0,0));
        setDefaultRenderer(Object.class, new FlatButtonRenderTable());
        getTableHeader().setDefaultRenderer(new HeaderRenderFlatTable());
        setFillsViewportHeight(true);
        setSelectionBackground(Color.lightGray);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void hiddeId() {
        removeColumn(getColumnModel().getColumn(0));
    }
    
    public void hiddeId(int column) {
        removeColumn(getColumnModel().getColumn(column));
    }

}
