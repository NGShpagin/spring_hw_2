package hw_2.java_spring_hw2;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

@Component
public class StudentRepository {
    private final List<Student> students;
    Random random = new Random();

    public StudentRepository() {
        this.students = new ArrayList<>();
        students.add(new Student("student #1", random.nextLong(1, 4)));
        students.add(new Student("student #2", random.nextLong(1, 4)));
        students.add(new Student("student #3", random.nextLong(1, 4)));
        students.add(new Student("student #4", random.nextLong(1, 4)));
        students.add(new Student("student #5", random.nextLong(1, 4)));
        students.add(new Student("student #6", random.nextLong(1, 4)));
        students.add(new Student("student #7", random.nextLong(1, 4)));
        students.add(new Student("student #8", random.nextLong(1, 4)));
        students.add(new Student("student #9", random.nextLong(1, 4)));
        students.add(new Student("student #10", random.nextLong(1, 4)));
    }

    public Student getById(long id) {
        return students.stream()
                .filter(student -> Objects.equals(student.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public List<Student> getAll() {
        return List.copyOf(students);
    }

    public List<Student> getStudentsByGroupId(long groupId) {
        return students.stream()
                .filter(student -> Objects.equals(student.getGroupId(), groupId))
                .collect(Collectors.toList());
    }

    public Student getByName(String name) {
        return students.stream()
                .filter(student -> Objects.equals(student.getName(), name))
                .findFirst()
                .orElse(null);
    }

    public long createStudent(String name, long groupId) {
        Student newStudent = new Student(name, groupId);
        students.add(newStudent);
        return newStudent.getId();
    }

    public void deleteStudent(long id) {
        students.remove(this.getById(id));
    }
}
