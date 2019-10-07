import java.util.*; 

public class Course {

    private int courseId;
    private String courseName;
    private int maxCapacity;
    private int professorId;
    private int credits;
    private int[] studentIds;

    public Course(int courseId) {
        if(courseId <= 0)
            throw new IllegalArgumentException("courseId must be positive");

        this.courseId = courseId;
    }

    public Course(int courseId, int professorId) {
        if (courseId <= 0 || professorId > 999999 || professorId < 1000000)
            throw new IllegalArgumentException("wrong constructor arguments");

        this.courseId = courseId;
        this.professorId = professorId;
    }

    public Course(int courseId, int professorId, int credits) {
        if (courseId <= 0 || professorId > 999999 || professorId < 100000 || credits <= 0 || credits >= 10)
        this.courseId = courseId;
        this.professorId = professorId;
        this.credits = credits;
    }

    public Course() {

    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        if(courseId <= 0)
            throw new IllegalArgumentException("courseId must be positive");

        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        if(courseName.length() < 10 || courseName.length() > 60)
            throw new IllegalArgumentException("CourseName's length is out of correct range");

        this.courseName = courseName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        if(maxCapacity < 10 || maxCapacity > 100)
            throw new IllegalArgumentException("MaxCapacity does not meet requirement");

        this.maxCapacity = maxCapacity;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        if(professorId > 999999 || professorId < 100000)
            throw new IllegalArgumentException("ProfessorId is not correct");

        this.professorId = professorId;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        if (credits > 0 && credits < 10)
            this.credits = credits;
        else
            throw new IllegalArgumentException("credit is not valid");
    }

    public int[] getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(int[] studentIds) {
        this.studentIds = studentIds;
    }

    /*
    * registerStudent method should store all ids in studentIds array.
    * */
    public void registerStudent(int studentId){
        if(studentIds == null){
            studentIds = new int[1];
            studentIds[0] = studentId;
        }else{
            int size = studentIds.length;
            int[] newStudentIds = new int[size + 1];

            for(int i = 0; i < size; i++)
                newStudentIds[i] = studentIds[i];

            newStudentIds[size + 1] = studentId;
            studentIds = newStudentIds;
        }
    }

    /*
    * This function should be called if course has reached the maximum capacity and remove all duplicate student Ids and return the new ids
    *  */
    public int[] removeDuplicates(int[] studentIds) {
        Set<Integer> idSet = new HashSet<>();

        int ind = 0;
        int[] newStudentIds = new int[studentIds.length];

        for (int studentId : studentIds){
            if(idSet.contains(studentId))
                continue;
            else{
                idSet.add(studentId);
                newStudentIds[ind++] = studentId;
            }
        }

        return Arrays.copyOfRange(newStudentIds, 0, ind);
    }

    /*
    * The method takes an array of studentIds as an argument. Find number of pairs of studentsIds whose sum is even
    * */
    public int groupsOfStudents(int[] studentIds) {
        int groupCount = 0;

        for (int i = 0; i < studentIds.length; i++){
            for(int j = i + 1; j < studentIds.length; j++){
                if((studentIds[i] + studentIds[j]) % 2 == 0)
                    groupCount++;
            }
        }

        return groupCount;
    }
}
