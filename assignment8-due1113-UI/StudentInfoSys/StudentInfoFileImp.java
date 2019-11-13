package Assignment8;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class StudentInfoFileImp implements StudentsOp {
    private StudentInfoImp studentInfoImp = new StudentInfoImp();
    private String filePath = "/Users/leichenzhou/Documents/Fall2019Semester/info-5100/info-5100-assignments/assignment8-due1113-UI/students.txt";

    public StudentInfoFileImp() {
        readDataFromFile();
    }

    private void readDataFromFile() {
        File file = new File(filePath);

        try {
            FileInputStream fis = new FileInputStream(file);
            Scanner sc = new Scanner(fis);

            while (sc.hasNext()){
                String line = sc.nextLine();
                String[] tokens = line.split("\\|");

                Student s = new Student(tokens[1], tokens[2], tokens[3]);
                studentInfoImp.addStudent(s);

            }

            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getStudentCount() {
        return studentInfoImp.getStudentCount();
    }

    @Override
    public void addStudent(Student student) {
        studentInfoImp.addStudent(student);
        writeIntoFile(studentInfoImp.getStudentCount(), student);
    }

    private void writeIntoFile(int num, Student student) {
        try {
            FileOutputStream fos = new FileOutputStream(filePath, true);
            PrintStream ps = new PrintStream(fos);

            String quote = num + "|" +
                           student.getId() + "|" +
                           student.getName() + "|" +
                           student.getGender();

            ps.println(quote);
            ps.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> getAll() {
        return studentInfoImp.getAll();
    }
}
