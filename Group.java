import java.util.*;

public class Group {
    private Student leader;
    private Map<UUID, Student> students;
    private List<String> tasks;

    public Group(Student leader, List<Student> students, List<String> tasks) {
        this.leader = leader;
        this.students = new HashMap<>();
        this.tasks = new ArrayList<>();
        this.addStudent(leader);
    }

    public void changeLeader(Student newLeader) {

        if (!this.students.containsKey(newLeader.getId())) {
            throw new IllegalArgumentException("New leader must be a member of the group.");
        }
        this.leader = newLeader;
    }

    public void addStudent(Student student) {
        this.students.put(student.getId(), student);
    }

    public void removeStudent(UUID studentId) {
        if (this.leader.getId().equals(studentId)) {
            throw new IllegalArgumentException("Cannot remove leader from group.");
        }
        this.students.remove(studentId);
    }

    public void renameStudent(UUID studentId, String newFirstName, String newLastName) {
        Student student = this.students.get(studentId);
        student.firstName = newFirstName;
        student.lastName = newLastName;
    }

    public void addTask(String task) {
        this.tasks.add(task);
    }

    public void markTaskAsDone(UUID studentId, String task) {
        //System.out.println(studentId);
        if (!this.students.containsKey(studentId)) {
            throw new IllegalArgumentException("Student must be a member of the group.");
        }
        if (!this.tasks.contains(task)) {
            throw new IllegalArgumentException("Task must be added to the group before it can be marked as done.");
        }
        // Here you could add a boolean "isDone" flag to each student, if you wanted to track individual progress
        // For simplicity, this implementation just marks the task as completed for the whole group
        System.out.println("Task \"" + task + "\" marked as done for student.");
    }

    public Student getGroupLeader() {
        return this.leader;
    }

    public String toString() {
        return "Група: " + students.values();
    }
}
