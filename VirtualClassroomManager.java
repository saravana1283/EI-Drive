import java.util.*;

public class VirtualClassroomManager {
    private List<Classroom> classrooms;

    public VirtualClassroomManager() {
        this.classrooms = new ArrayList<>();
    }

    public void createClassroom(String name, String instructor) {
        Classroom classroom = new Classroom(name, instructor);
        classrooms.add(classroom);
    }

    public void addStudentToClassroom(String classroomId, String studentName) {
        Classroom classroom = findClassroomById(classroomId);
        if (classroom != null) {
            Student student = new Student(studentName);
            classroom.addStudent(student);
        }
    }

    public void addAssignmentToClassroom(String classroomId, String title, Date dueDate) {
        Classroom classroom = findClassroomById(classroomId);
        if (classroom != null) {
            Assignment assignment = new Assignment(title, dueDate);
            classroom.addAssignment(assignment);
        }
    }

    public void recordAttendance(String classroomId, String studentId, Date date, boolean present) {
        Classroom classroom = findClassroomById(classroomId);
        if (classroom != null) {
            Student student = findStudentById(classroom, studentId);
            if (student != null) {
                Attendance attendance = new Attendance(student, date, present);
                classroom.addAttendanceRecord(attendance);
                System.out.println("Attendance recorded successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } else {
            System.out.println("Classroom not found.");
        }
    }

    private Classroom findClassroomById(String id) {
        for (Classroom classroom : classrooms) {
            if (classroom.getId().equals(id)) {
                return classroom;
            }
        }
        return null;
    }

    private Student findStudentById(Classroom classroom, String id) {
        for (Student student : classroom.getStudents()) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    
}
