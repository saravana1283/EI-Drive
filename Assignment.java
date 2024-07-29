import java.util.Date;
import java.util.UUID;

public class Assignment {
    private String id;
    private String title;
    private Date dueDate;

    public Assignment(String title, Date dueDate) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.dueDate = dueDate;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getDueDate() {
        return dueDate;
    }
}
