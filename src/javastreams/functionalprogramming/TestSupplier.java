package javastreams.functionalprogramming;

import java.util.function.Supplier;

public class TestSupplier {
    public static void main(String [] args){
        TestSupplier test=new TestSupplier();
        test.testSupplier("Jack");
    }
    void testSupplier(String name){
        String str="name";
        Integer plusNumber=4;
        Supplier<String> s=()->str+":" +name;
        Supplier<Integer> s2=()->100+plusNumber;
        System.out.println(s.get());
        System.out.println(s2.get());

    }


}
