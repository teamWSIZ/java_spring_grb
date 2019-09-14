package wsi.model;

import java.util.HashSet;
import java.util.Set;

public class A {
    public static void main(String[] args) {
        CarType ct = new CarType();
        ct.setEngines(12);
        ct.setName("super-hybryda");
        ct.setShields(1);
        ct.setWheels(8);

        CarType tt = new CarType("regular", 4, 2, 1);


        System.out.println(tt);

        Set<Integer> ss = new HashSet<>();
        ss.add(12);
        ss.add(11);
        ss.add(12);
        System.out.println(ss);
        System.out.println(ss.contains(12));
        System.out.println(ss.contains(13));


        Set<CarType> types = new HashSet<>();
        types.add(ct);
        types.add(tt);

        System.out.println(types);






    }
}
