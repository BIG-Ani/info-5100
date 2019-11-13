package Assignment8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentInfoImp implements StudentsOp {
    private HashMap<String ,Student> studentMap = new HashMap<>();

    @Override
    public int getStudentCount() {
        return studentMap.size();
    }

    @Override
    public void addStudent(Student student) {
        String studentId = student.getId();
        if (studentMap.keySet().contains(studentId)){
            System.out.println("Student id repeats");
            return;
        }

        studentMap.put(studentId, student);
    }

    @Override
    public List<Student> getAll() {
        List<Student> allStudents = new ArrayList<>();

        for(Student s : studentMap.values())
            allStudents.add(s);

        return allStudents;
    }
}
