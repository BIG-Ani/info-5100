package Assignment8;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class StudentModel implements TableModel {

    private StudentsOp studentInfo;

    public StudentModel(StudentsOp studentInfoImp) {
        this.studentInfo = studentInfoImp;
    }

    @Override
    public int getRowCount() {
        return studentInfo.getStudentCount();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case 0:
                return "ID";
            case 1:
                return "NAME";
            case 2:
                return "GENDER";
        }

        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = studentInfo.getAll().get(rowIndex);

        if (columnIndex == 0)
            return student.getId();
        else if (columnIndex == 1)
            return student.getName();
        else
            return student.getGender();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
