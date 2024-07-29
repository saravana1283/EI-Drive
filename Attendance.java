import java.util.Date;
import java.util.UUID;

public class Attendance {
    private String id;
    private Student student;
    private Date date;
    private boolean present;

    public Attendance(Student student, Date date, boolean present) {
        this.id = UUID.randomUUID().toString();
        this.student = student;
        this.date = date;
        this.present = present;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Date getDate() {
        return date;
    }

    public boolean isPresent() {
        return present;
    }
}
