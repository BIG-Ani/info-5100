package Assignment8;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StudentAddPage extends BaseGuiFrame {
    private JPanel contentPanel;
    private JPanel titlePanel;
    private JPanel editPanel;
    private JPanel buttonPanel;

    private JLabel addTitle;
    private JLabel idLab;
    private JTextField idTxt;
    private JLabel nameLab;
    private JTextField nameTxt;
    private JLabel genderLab;
    private JTextField genderTxt;

    private JButton add;
    private JButton viewAll;

//    private StudentInfoImp studentInfoImp = new StudentInfoImp();
    private StudentInfoFileImp studentInfoFileImp = new StudentInfoFileImp();

    @Override
    public void create() {
        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(50, 50, 50, 40));
        setContentPane(contentPanel);

        titlePanel = new JPanel();
        titlePanel.setBorder(new EmptyBorder(10,10,30,10));

        editPanel = new JPanel();
        editPanel.setBorder(new EmptyBorder(10, 50,50, 50));

        buttonPanel = new JPanel();

        addTitle = new JLabel("Add New Student");
        idLab = new JLabel("ID : ");
        idTxt = new JTextField(15);

        nameLab = new JLabel("Name : ");
        nameTxt = new JTextField(15);

        genderLab = new JLabel("Gender : ");
        genderTxt = new JTextField(15);

        add = new JButton("Add");
        viewAll = new JButton("View All");
    }

    @Override
    public void add(Container container) {
        addTitleDisplay(titlePanel);
        addEditArea(editPanel);
        addContent(contentPanel);
        addButton(buttonPanel);
    }

    private void addButton(JPanel buttonPanel) {
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(add);
        buttonPanel.add(viewAll);
    }

    private void addTitleDisplay(JPanel titlePanel) {
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(addTitle);
    }

    private void addContent(JPanel contentPanel) {
        contentPanel.add(titlePanel);
        contentPanel.add(editPanel);
        contentPanel.add(buttonPanel);
    }

    private void addEditArea(JPanel editPanel) {
//        editPanel.setBounds();
        GridLayout gl = new GridLayout(3, 2, 3, 3);
        editPanel.setLayout(gl);

        editPanel.add(idLab);
        editPanel.add(idTxt);

        editPanel.add(nameLab);
        editPanel.add(nameTxt);

        editPanel.add(genderLab);
        editPanel.add(genderTxt);
    }

    @Override
    public void addListeners() {
        add.addActionListener(e -> addStudentToSystem());
//        viewAll.addActionListener(e -> viewAllPage()); // to do new page for view all student

        viewAll.addActionListener(e -> jumpToViewAllPage());
    }

    private void jumpToViewAllPage() {
        setVisible(false);
        new ViewAllStudentPage();
    }

    private void addStudentToSystem() {
        Student newStudent = new Student(idTxt.getText(),
                                         nameTxt.getText(),
                                         genderTxt.getText());

//        studentInfoImp.addStudent(newStudent);
        studentInfoFileImp.addStudent(newStudent);

        idTxt.setText("");
        nameTxt.setText("");
        genderTxt.setText("");
    }

    // main test
    public static void main(String[] args) {
        new StudentAddPage();
    }
}
