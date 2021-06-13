package javastreams.functionalprogramming;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class TestPredicate {
    public static void main(String [] args){
        TestPredicate predicate=new TestPredicate();
        predicate.testPredicate();
        predicate.testBiPredicate();

    }
    void testPredicate(){
        Predicate<Integer> controlOdd= v-> v%2==0;
        if (Boolean.TRUE.equals(controlOdd.test(25))) {
            System.out.println("Number is even");
        } else {
            System.out.println("Number is odd");
        }
    }
    void testBiPredicate(){
        BiPredicate<Integer,Integer> bipredicate=(v,u)-> {System.out.println("Numbers: " +v +"/" + u);
        return v+u<100;};
        String result=bipredicate.test(80,40) ?"Sum is smaller than 100": "Sum is greater than 100";
        System.out.println(result);
    }
}
