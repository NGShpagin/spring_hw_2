package hw_2.java_spring_hw2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    private static long idCounter = 1L;
    private Long id;
    private String name;

    public Group(String name) {
        this.id = idCounter++;
        this.name = name;
    }
}
