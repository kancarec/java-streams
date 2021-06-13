package javastreams.optional;

import java.util.Optional;

public class TestOptional {
    public static void main(String [] args){
        TestOptional o=new TestOptional();
        o.testOptional();
    }
    void testOptional(){
        Optional<Integer>o=Optional.of(8);
        Optional<Integer>optional=Optional.empty();
        o.map(x->x*20).ifPresent(x->System.out.println (x));

        System.out.println(optional.orElse(9));
        System.out.println(optional.orElseGet(()->9*4));
        System.out.println(optional.orElseThrow(()-> new IllegalStateException()));

    }
}
