package javastreams.functionalprogramming;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class TestConsumer {
    public static void main(String[] args) {
        TestConsumer cons = new TestConsumer();
        cons.testConsumer();
        cons.testBiConsumer();
    }

    void testConsumer() {
        Consumer<Integer> cons1 = s -> System.out.println(s * 9);
        Consumer<String> cons2 = s -> System.out.println("Hello " + s);
        cons1.accept(32);
        cons2.accept("Jane");
    }

    void testBiConsumer() {
        Map<String,Integer> map=new HashMap<String,Integer>();
        BiConsumer<Integer, String> cons = (k, v) -> {
            System.out.println("Age:" + k);
            System.out.println("Name: " + v);
            map.put(v,k);
        };
        cons.accept(29,"Eriksen");
        System.out.println(map);
    }
}
