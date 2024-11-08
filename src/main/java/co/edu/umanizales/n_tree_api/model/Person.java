package co.edu.umanizales.n_tree_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private String identification;
    private String name;
    private String lastName;
    private char gender;
    private byte age;
}
