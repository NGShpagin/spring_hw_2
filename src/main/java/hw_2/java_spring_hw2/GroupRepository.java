package hw_2.java_spring_hw2;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class GroupRepository {
    private final List<Group> groups;

    public GroupRepository() {
        this.groups = new ArrayList<>();
        groups.add(new Group("Group #1"));
        groups.add(new Group("Group #2"));
        groups.add(new Group("Group #3"));
    }

    public List<Group> getAll() {
        return List.copyOf(groups);
    }

    public Group getById(long id) {
        return groups.stream()
                .filter(group -> Objects.equals(group.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public Group getByName(String name) {
        return groups.stream()
                .filter(group -> Objects.equals(group.getName(), name))
                .findFirst()
                .orElse(null);
    }

    public long createGroup(String name) {
        Group newGroup = new Group(name);
        groups.add(newGroup);
        return newGroup.getId();
    }

    public boolean checkGroupId(long groupId) {
        return groups.contains(this.getById(groupId));
    }

    public void deleteGroup(long id) {
        groups.remove(this.getById(id));
    }
}
