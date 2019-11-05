package wsi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class User {
    String name;
    String rank;
}


public class A {
    public static void main(String[] args) {
        User u = new User("Abra", "B12");


        System.out.println(u);
    }
}
