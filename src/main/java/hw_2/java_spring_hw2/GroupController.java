package hw_2.java_spring_hw2;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/groups")
public class GroupController {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @GetMapping(path = "/all")
    public List<Group> getGroups() {
        return groupRepository.getAll();
    }

    @GetMapping(path = "/{id}/students")
    public List<Student> getGroupStudents(@PathVariable long id) {
        return studentRepository.getStudentsByGroupId(id);
    }

    @GetMapping(path = "/{id}")
    public Group getGroup(@PathVariable long id) {
        return groupRepository.getById(id);
    }

    @GetMapping
    public Group getGroupByName(@RequestParam String name) {
        return groupRepository.getByName(name);
    }

    @PostMapping
    public Group createGroup(@RequestBody Group group) {
        long newGroupId = groupRepository.createGroup(group.getName());
        return groupRepository.getById(newGroupId);
    }

    @DeleteMapping
    public Group deleteGroup(@RequestBody Group group) {
        Group deletedGroup = groupRepository.getById(group.getId());
        groupRepository.deleteGroup(group.getId());
        return deletedGroup;
    }
}
