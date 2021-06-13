package javastreams.functionalprogramming;

import java.util.function.BinaryOperator;

public class TestBinaryOperator {
    public static void main(String[] args) {
        TestBinaryOperator b=new TestBinaryOperator();
        b.testBinaryOperator();
    }
    void testBinaryOperator(){
        BinaryOperator<Integer> binaryOperator=(t,v)->t*v;
       System.out.println(binaryOperator.apply(42,52));
    }
}
