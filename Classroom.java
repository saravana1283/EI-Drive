import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Classroom {
    private String id;
    private String name;
    private String instructor;
    private List<Student> students;
    private List<Assignment> assignments;
    private List<Attendance> attendanceRecords;

    public Classroom(String name, String instructor) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.instructor = instructor;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
        this.attendanceRecords = new ArrayList<>();
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInstructor() {
        return instructor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public List<Attendance> getAttendanceRecords() {
        return attendanceRecords;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    public void addAttendanceRecord(Attendance attendance) {
        attendanceRecords.add(attendance);
    }
}
