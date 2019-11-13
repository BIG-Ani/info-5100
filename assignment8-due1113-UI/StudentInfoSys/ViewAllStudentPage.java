package Assignment8;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ViewAllStudentPage extends BaseGuiFrame {
    private JPanel contentPanel;

    private JPanel titlePanel;
    private JLabel titleLab;

    private JPanel displayPanel;
    private JTable displayTable;
    private StudentModel studentModel;

    private JPanel buttonPanel;
    private JButton back;
    private JButton close;

    @Override
    public void create() {
        setBounds(500, 100, 600, 800);

        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        setContentPane(contentPanel);

        titlePanel = new JPanel();
        titlePanel.setBorder(new EmptyBorder(30, 20, 50, 20));

        titleLab = new JLabel("All Students");

        displayPanel = new JPanel();
        studentModel = new StudentModel(new StudentInfoFileImp());
        displayTable = new JTable(studentModel);

        buttonPanel = new JPanel();
        buttonPanel.setBorder(new EmptyBorder(30, 20, 30, 20));
        back = new JButton("Back");
        close = new JButton("Close");
    }

    @Override
    public void add(Container container) {
        addTitlePart(titlePanel);

        addTablePart(displayPanel);

        addButtonPart(buttonPanel);

        addAllPanel(contentPanel);
    }

    private void addAllPanel(JPanel contentPanel) {
        contentPanel.add(titlePanel, BorderLayout.NORTH);
        contentPanel.add(displayPanel, BorderLayout.CENTER);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addButtonPart(JPanel buttonPanel) {
        buttonPanel.add(back);
        buttonPanel.add(close);
    }

    private void addTablePart(JPanel displayPanel) {
        displayPanel.add(new JScrollPane(displayTable));
    }

    private void addTitlePart(JPanel titlePanel) {
        titlePanel.add(titleLab);
    }

    @Override
    public void addListeners() {
        back.addActionListener(e -> backOperation());
        close.addActionListener(e -> closeDisplayPage());
    }

    private void closeDisplayPage() {
        this.dispose();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void backOperation() {
        setVisible(false);
        new StudentAddPage();
    }

    // main test
    public static void main(String[] args) {
        new ViewAllStudentPage();
    }
}
