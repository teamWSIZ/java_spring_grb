package wsi;

import java.util.HashMap;

public class A {
    public static void main(String[] args) {
        var m = new HashMap<String,String>();
        m.put("mnbvmar", "x1x1");
        m.put("mnbvmar", "yyy1");
        var u = m.getOrDefault("mnbvmar", "---"); // "yyy1"
        var w = m.getOrDefault("aaaaaaa", "---"); // "---"
        m.put("a","a");
        //trawers przez wszystkie elementy mapy
        for(var k : m.keySet()) {
            System.out.println(m.get(k));  //"yyy1", "a"
        }

    }
}
