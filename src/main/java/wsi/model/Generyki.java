package wsi.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Generyki {
    public static void main(String[] args) {
        List<Integer> liczby = new ArrayList<>();
        liczby.addAll(Arrays.asList(4, 5, 6, 6, 7, 7));
        // ^^ to jest lista liczb

        List<String> napisy = new ArrayList<>();
        napisy.addAll(Arrays.asList("aa", "abc", "cc"));

        System.out.println(liczby);
        System.out.println(napisy);



    }
}
