package hw_2.java_spring_hw2;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private static long idCounter = 1L;
    private Long id;
    private String name;
    private Long groupId;

    public Student(String name, Long groupId) {
        this.id = idCounter++;
        this.name = name;
        this.groupId = groupId;
    }
}
