package javastreams.streams;

import jdk.nashorn.internal.ir.Terminal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperations {
    public static void main(String[] args) {
        TerminalOperations s = new TerminalOperations();
        s.testTerminalOperationMatch();
        s.testTerminalOperationCount();
        s.testTerminalOperationFind();
        s.testTerminalOperationForeach();
        s.testTerminalOperationMinMax();
        s.testTerminalOperationReduce();
        s.testTerminaOperationCollect();
    }

    void testTerminalOperationMatch() {
        Stream<Integer> all = Stream.of(1, 2, 3, 62, 14, 34);
        Stream<Integer> any = Arrays.asList(1, 2, 3, 62, 14, 34).stream();
        Stream<Integer> none = Arrays.asList(1, 2, 3, 62, 14, 34).stream();
        Predicate<Integer> p = x -> x % 2 == 0;
        System.out.println("-----ALL/ANY/NONE MATCH---");
        System.out.println("All Match:" + all.allMatch(p));
        System.out.println("Any Match:" + any.anyMatch(p));
        System.out.println("None Match:" + none.noneMatch(p));

    }

    void testTerminalOperationFind() {
        Stream<Integer> first = Stream.of(1, 2, 3, 62, 14, 34);
        Stream<Integer> any = Arrays.asList(4, 2, 5, 6).stream();
        System.out.println("-----FIND ANY/FIRST---");
        first.findFirst().ifPresent(x -> System.out.println("FindFirst" + x));
        any.findAny().ifPresent(x -> System.out.println("FindAny:" + x));
    }

    void testTerminalOperationMinMax() {
        Stream<Integer> min = Stream.of(1, 2, 3, 62, 14, 34);
        Stream<Integer> max = Stream.of(1, 2, 3, 62, 14, 34);
        System.out.println("-----MIN/MAX---");
        System.out.println("MIN" + min.min((x, y) -> x - y));
        System.out.println("MAX" + max.max((x, y) -> x - y));
    }

    void testTerminalOperationCount() {
        Stream<Integer> s = Stream.of(1, 2, 3, 62, 14, 34);
        System.out.println("-----COUNT---");
        System.out.print("Stream Count:" + s.count());
    }

    void testTerminalOperationForeach() {
        Stream<Integer> s = Stream.of(1, 2, 3, 62, 14, 34);
        System.out.println("-----FOREACH---");
        s.forEach(x -> System.out.print(x + ","));
        System.out.println();
    }

    void testTerminalOperationReduce() {
        Stream<Integer> s = Stream.of(1, 2, 3, 62, 14, 34);
        Integer sum = s.reduce(0, (x, y) -> x + y);
        System.out.println("-----REDUCE---");
        System.out.println("Sum:" + sum);

        System.out.println("----- OPTIONAL REDUCE---");
        Stream<Integer> opReduce = Stream.of(2, 4, 7);
        BinaryOperator<Integer> binaryOperator = (x, y) -> x * y;
        opReduce.reduce(binaryOperator).ifPresent(x -> System.out.println("Optional Sum:" + x));

        System.out.println("----- PARALLEL  STREAM REDUCE---");
        Stream<Integer> combinerReduce = Stream.of(2, 4, 7);
        BinaryOperator<Integer> accumulatorOperator = (x, y) -> x * y;
        System.out.println(combinerReduce.reduce(1, accumulatorOperator, accumulatorOperator));


    }

    void testTerminaOperationCollect() {
        Stream<String> s = Stream.of("a", "b", "c", "d");
        System.out.println("----- COLLECT---");
        //<R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator,BiConsumer<R, R> combiner)
        StringBuilder word = s.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(word);
        //<R,A> R collect(Collector<? super T, A,R> collector)
        Stream<String> w=Stream.of("x","y","z","d");
        List<String> list=w.collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Collectors:"+list);

        Stream<String> listStream=Stream.of("x","y","z","d");
        List<String> listDetail=listStream.collect(ArrayList::new,List::add,List::addAll);
        System.out.println("Collect Detail:"+listDetail);

    }
}
