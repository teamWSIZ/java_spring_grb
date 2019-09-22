package wsi.wykop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;


// Check : https://www.tutorialspoint.com/java/java_generics.htm
// Deeper: https://www.baeldung.com/java-generics

class Storage<T> {
    Map<T, Integer> store;
    Map<T, Integer> capacity;

    int add(T t) {
        return 0;
    }

    int remove(T t) {
        return 0;
    }

    int capacity(T t) {
        return 0; //stubs
    }

    private boolean canStore(T t) {
        return capacity.getOrDefault(t, 100) - store.getOrDefault(t, 0) > 0;
    }

}

//todo: add tests to the Storage class; add stored types (Car, Flower)
//todo: functions of 2 generic types
//todo: Function type


public class Generyki {

    // Funkcja która "dopasuje się" do typu danych który jej podamy
    static <T> boolean checkEqual(T a, T b) {
        return a == b;
    }

    static Integer doIt(Integer x, Function<Integer,Integer> theAction) {
        return theAction.apply(x);
    }

    public static void main(String[] args) {
        List<Integer> liczby = new ArrayList<>();
        liczby.addAll(Arrays.asList(4, 5, 6, 6, 7, 7));
        // ^^ to jest lista liczb

        List<String> napisy = new ArrayList<>();
        napisy.addAll(Arrays.asList("aa", "abc", "cc"));

        System.out.println(liczby);
        System.out.println(napisy);

        System.out.println(checkEqual('a', 'b'));
        System.out.println(checkEqual(11, 22));
        System.out.println(checkEqual("jeden", "jeden"));


        Function<Integer, Integer> incrementor = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer + 1;
            }
        };

        System.out.println(doIt(0, incrementor));


    }
}
