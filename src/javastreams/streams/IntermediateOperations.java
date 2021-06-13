package javastreams.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperations {
    public static void main(String[] args) {
        IntermediateOperations testIntermediateOperation = new IntermediateOperations();
        testIntermediateOperation.testInterMediateOperationFilter();
        testIntermediateOperation.testInterMediateOperationDistinct();
        testIntermediateOperation.testInterMediateOperationLimitSkip();
        testIntermediateOperation.testInterMediateOperationMap();
        testIntermediateOperation.testInterMediateOperationFlatMap();
        testIntermediateOperation.testInterMediateOperationSorted();
        testIntermediateOperation.testInterMediateOperationPeek();

    }

    void testInterMediateOperationFilter() {
        System.out.println("---FILTER-----");
        Stream<Integer> filterStream = Stream.of(1, 2, 3, 5, 92, 32);
        filterStream.filter(x -> x % 4 == 0).forEach(System.out::println);
    }

    void testInterMediateOperationDistinct() {
        System.out.println("---DISTINCT-----");
        Stream<Integer> distinctStream = Stream.of(1, 2, 3, 5, 92, 5, 3);
        distinctStream.distinct().forEach(System.out::println);

    }

    void testInterMediateOperationLimitSkip() {
        System.out.println("---LIMIT-----");
        Stream<Integer> limitStream = Stream.of(1, 2, 3, 5, 92, 5, 3);
        limitStream.limit(4).forEach(System.out::println);
        System.out.println("---SKIP-----");
        Stream<Integer> skipStream = Stream.of(1, 2, 3, 5, 92, 5, 3);
        skipStream.skip(2).forEach(System.out::println);
    }

    void testInterMediateOperationMap() {
        System.out.println("---MAP-----");
        Stream<Integer> mapStream = Stream.of(1, 2, 3, 5, 92, 5, 3);
        mapStream.map(x -> x * 2).forEach(System.out::println);
    }

    void testInterMediateOperationFlatMap() {
        System.out.println("---FLATMAP-----");
        List<Integer> firstList = Arrays.asList(1, 2, 3);
        List<Integer> secondList = Arrays.asList(32, 22, 12);
        Stream<List<Integer>> s = Stream.of(firstList, secondList);
        s.flatMap(a -> a.stream()).forEach(System.out::println);
    }

    void testInterMediateOperationSorted() {
        System.out.println("---SORTED-----");
         Stream<Integer> numberStream=Stream.of(342,42,52,12,53,84);
         numberStream.sorted((x,y)->x-y).forEach(System.out::println);
    }

    void testInterMediateOperationPeek() {
        System.out.println("---PEEK-----");
        Stream<Integer> peekStream=Stream.of(342,42,52,12,53,84);
        peekStream.peek(x-> System.out.println(x+2)).count();
    }
}
