package javastreams.functionalprogramming;

import java.util.function.UnaryOperator;

public class TestUnaryOperator {
    public static void main(String[] args) {
    TestUnaryOperator u=new TestUnaryOperator();
    u.testUnaryOperator();
    }
    void testUnaryOperator(){
        UnaryOperator<String>  u=c-> c+" is a city on Turkey's Black Sea coast";
        System.out.println(u.apply("Rize"));
    }
}
