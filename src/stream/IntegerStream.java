package stream;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntegerStream {
    public static void IntegerStreamTesting(){
        int numbers[] = {4, 1, 13, 90, 16, 12, 0, 1};

        /**
         * Stream API working process
         * Create -> Process -> Consume
         */

        // Getting Minimum
        System.out.println("Getting Minimum");
        int min = IntStream.of(numbers)
                            .min()
                            .getAsInt();
        System.out.println(min);
        IntStream.of(numbers)
                        .min()
                        .ifPresent(m -> System.out.println(m));
        IntStream.of(numbers)
                        .min()
                        .ifPresent(System.out::println);

        // Getting Maximum
        System.out.println("Getting Maximum");
        IntStream.of(numbers)
                        .max()
                        .ifPresent(System.out::println);

        // Getting Average
        System.out.println("Getting Average");
        IntStream.of(numbers)
                        .average()
                        .ifPresent(System.out::println);

        // Getting Count
        System.out.println("Getting Count");
        System.out.println(IntStream.of(numbers).count());

        // Getting Sum
        System.out.println("Getting Sum");
        System.out.println(IntStream.of(numbers).sum());

        // Getting Statistics
        IntSummaryStatistics summaryStatistics = IntStream.of(numbers).summaryStatistics();
        summaryStatistics.getAverage();
        summaryStatistics.getCount();
        summaryStatistics.getMax();
        summaryStatistics.getMin();
        summaryStatistics.getSum();

        // Complex Operations
        System.out.println("Complex Operation");

        System.out.println("lowest 3 distinct number from array");
        IntStream.of(numbers)
                .distinct()
                .sorted()
                .limit(3)
                .forEach(System.out::println);

        System.out.println("lowest 3 distinct numbers sum");
        System.out.println(
            IntStream.of(numbers)
                .distinct()
                .sorted()
                .limit(3)
                .sum()
        );

        // Creating Stream
        System.out.println("Creating Stream");
        IntStream.of(numbers);
        IntStream.range(1, 101);
        IntStream.rangeClosed(1, 100);
//        IntStream.generate(someFunction());

        // Processing Stream
        IntStream.range(1, 101)
            .distinct();
        IntStream.range(1, 101)
            .sorted();
        IntStream.range(1, 101)
            .limit(3);
        IntStream.range(1, 101)
            .skip(3);
        IntStream.range(1, 101)
            .filter(num -> num % 2 == 0); // Only even numbers
        IntStream.range(1, 101)
            .map(num -> num * 2); // double each number
        IntStream.range(1, 101)
                .boxed(); // Convert each number to Integer

        // Consume
        IntStream.of(numbers)
                .average();
        IntStream.of(numbers)
                .min();
        IntStream.of(numbers)
                .max();
        IntStream.of(numbers)
                .sum();
        IntStream.of(numbers)
                .count();
        IntStream.of(numbers)
                .forEach(System.out::println);;
        IntStream.range(1, 101)
                .toArray();
        IntStream.range(1, 101)
                .boxed()
                .collect(Collectors.toList());
        IntStream.range(1, 101)
                .anyMatch(num -> num % 2 == 1); // is any number odd? true / false
        IntStream.range(1, 101)
                .allMatch(num -> num % 2 == 1); // are all number odd? true / false
    }
}
