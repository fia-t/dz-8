import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        String student1FirstName= "Elon";
        String student1lastName= "Mask";
        String student2FirstName= "Ivan";
        String student2lastName= "Ivanenko";
        String student3FirstName= "Olena";
        String student3lastName= "Ostapenko";

        String student3NewFirstName= "Bred";
        String student3NewlastName= "Pit";
        String taskName= "вивчити інкапсуляцію";
        // Створюємо 3 студента і додаємо їх у список

        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        UUID id3 = UUID.randomUUID();
        //System.out.println(id1);
        //Список студентів
        List<Student> students = new ArrayList<>();

        Student student1 = new Student(id1, student1FirstName, student1lastName);
        students.add(student1);
        Student student2 = new Student(id2, student2FirstName, student2lastName);
        students.add(student2);
        Student student3 = new Student(id3, student3FirstName, student3lastName);
        students.add(student3);
        Student groupLeader = student1;

        // Створення групи
        Group group = new Group(groupLeader, new ArrayList<>(), new ArrayList<>());
        // Додавання студента до групи і завдання групі
        for(Student student : students) {
            group.addStudent(student);
            group.addTask(taskName);
        }
        // Виводимо інформацію про лідера
        System.out.println("Лідер: "+group.getGroupLeader().getFullName());
        //Виводимо список групи
        System.out.println(group.toString());

        //Змінити лідера
        group.changeLeader(student3);
        // Виводимо інформацію про нового лідера
        System.out.println("Новий Лідер: "+group.getGroupLeader().getFullName());

        //Позначимо завдання, як виконане для студента1
        group.markTaskAsDone(id1, taskName);

        //Змінемо ім'я у студента3
        group.renameStudent(id3, student3NewFirstName, student3NewlastName);
        //Виводимо новий список групи
        System.out.println(group.toString());

    }
}
