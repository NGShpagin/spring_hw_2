package hw_2.java_spring_hw2;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @GetMapping(path = "/all")
    public List<Student> getStudents() {
        return studentRepository.getAll();
    }

    @GetMapping(path = "/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentRepository.getById(id);
    }

    @GetMapping
    public Student getStudentByName(@RequestParam String name) {
        return studentRepository.getByName(name);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        if (groupRepository.checkGroupId(student.getGroupId())) {
            long newUserId = studentRepository.createStudent(student.getName(), student.getGroupId());
            return studentRepository.getById(newUserId);
        } else throw new RuntimeException("Группы с таким id нет");
    }

    @DeleteMapping
    public Student deleteStudent(@RequestBody Student student) {
        Student deletedStudent = studentRepository.getById(student.getId());
        studentRepository.deleteStudent(student.getId());
        return deletedStudent;
    }
}
