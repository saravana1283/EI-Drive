import java.util.UUID;

public class Student {
    private String id;
    private String name;

    public Student(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
