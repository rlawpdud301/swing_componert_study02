package swing_student_management.ui;

import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class NonEditableModel extends DefaultTableModel {
	
    public NonEditableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
