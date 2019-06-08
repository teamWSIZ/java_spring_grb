package wsi.wykop;

import java.io.IOException;

public class ExceptionHandling {


    String readFile(String filename) {
        //czytaj zawartosc pliku "filename"
        System.out.println("start readfile");
        String res = "abra kadabra";
        if (filename.equals("a.txt")) {
            throw new RuntimeException("Plik nie istnieje");
        }
        System.out.println("end readfile");

        return res;
    }


    String function2() {
        System.out.println("start function2");
        String res = readFile("a.txt");
        System.out.println("end function2");
        return res;
    }

    String function1() {
        System.out.println("start function1");
        String res = function2();
        System.out.println("end function1");

        return res;
    }


    public static void main(String[] args) {
        ExceptionHandling g = new ExceptionHandling();


        try {
            System.out.println(g.function1());
        } catch (Exception e) {
            System.out.println("wystąpił błąd: " + e);
        }


    }
}
