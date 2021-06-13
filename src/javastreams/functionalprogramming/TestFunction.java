package javastreams.functionalprogramming;

import java.util.function.BiFunction;
import java.util.function.Function;

public class TestFunction {
    public static void main(String [] args){
        TestFunction testFunction=new TestFunction();
        testFunction.testBiFunction();
        testFunction.testFunction();

    }
    void testFunction(){
        Function<Integer,Integer> function=v->v*10;
        System.out.println(function.apply(12));

    }
    void testBiFunction(){
        BiFunction<String,String,String> testBiFunction=(t,u)->t.concat(u);
        System.out.println(testBiFunction.apply("Ri","ri"));
    }
}
