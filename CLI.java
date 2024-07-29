import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CLI {
    private static VirtualClassroomManager manager = new VirtualClassroomManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Create Classroom");
            System.out.println("2. Add Student to Classroom");
            System.out.println("3. Add Assignment to Classroom");
            System.out.println("4. Record Attendance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    createClassroom();
                    break;
                case 2:
                    addStudentToClassroom();
                    break;
                case 3:
                    addAssignmentToClassroom();
                    break;
                case 4:
                    recordAttendance();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void createClassroom() {
        System.out.print("Enter classroom name: ");
        String name = scanner.nextLine();
        System.out.print("Enter instructor name: ");
        String instructor = scanner.nextLine();
        manager.createClassroom(name, instructor);
        System.out.println("Classroom created successfully.");
    }

    private static void addStudentToClassroom() {
        System.out.print("Enter classroom ID: ");
        String classroomId = scanner.nextLine();
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        manager.addStudentToClassroom(classroomId, studentName);
        System.out.println("Student added successfully.");
    }

    private static void addAssignmentToClassroom() {
        System.out.print("Enter classroom ID: ");
        String classroomId = scanner.nextLine();
        System.out.print("Enter assignment title: ");
        String title = scanner.nextLine();
        System.out.print("Enter due date (YYYY-MM-DD): ");
        String dueDateStr = scanner.nextLine();
        Date dueDate = parseDate(dueDateStr);
        manager.addAssignmentToClassroom(classroomId, title, dueDate);
        System.out.println("Assignment added successfully.");
    }

    private static void recordAttendance() {
        System.out.print("Enter classroom ID: ");
        String classroomId = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter attendance date (YYYY-MM-DD): ");
        String dateStr = scanner.nextLine();
        Date date = parseDate(dateStr);
        System.out.print("Is the student present? (true/false): ");
        boolean present = scanner.nextBoolean();
        manager.recordAttendance(classroomId, studentId, date, present);
    }

    private static Date parseDate(String dateStr) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format, using current date instead.");
            return new Date();
        }
    }
}
