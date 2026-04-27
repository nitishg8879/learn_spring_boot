package java_learn.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamTest {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");
        // names.stream().filter(
        // t -> t.startsWith("A")
        // ).collect(Collectors.toList()).stream();

        List<Integer> salaryList = Arrays.asList(50000, 60000, 70000, 80000, 90000);
        int count = 0;

        for (Integer integer : salaryList) {
            if (integer > 60000) {
                count++;
            }
        }
        System.out.println("Count of salaries greater than 60000 using loop: " + count);

        Long countStream = salaryList.stream().filter(salary -> salary > 60000).count();
        System.out.println("Count of salaries greater than 60000 using stream: " + countStream);

        List<String> namesSentences = Arrays.asList("Alice is a developer", "Bob is a designer",
                "Charlie is a manager");
        List<String> upperCaseNamesSentences = namesSentences.stream().map(t -> t.toUpperCase())
                .collect(Collectors.toList());
        System.out.println("Upper case names sentences using  .map(): " + upperCaseNamesSentences);

        List<List<String>> sentenceList = Arrays.asList(
                Arrays.asList("Alice", "is", "a", "developer"),
                Arrays.asList("Bob", "is", "a", "designer"),
                Arrays.asList("Charlie", "is", "a", "manager"));

        List<String> flatList = sentenceList.stream().flatMap(t -> t.stream()).collect(Collectors.toList());
        System.out.println("Flattened list using .flatMap(): " + flatList);

        List<Integer> numbers = Arrays.asList(2, 1, 4, 7, 10);
        Stream<Integer> numberStream = numbers.stream();// it will create a stream of integers from the list
        int sum = numberStream.reduce(0, (a, b) -> a + b); // it will reduce the stream to a single value by applying
                                                           // the provided binary operator
        System.out.println("Sum of numbers using .reduce(): " + sum);

    }
}

class JavaStreamTest2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 1, 4, 7, 10);
        Stream<Integer> numbStream2 = numbers.stream()
                .filter(t -> t >= 3)
                .peek(t -> System.out.println("After Filter:: " + t))
                .map(t -> (t * -1))
                .peek(t -> System.out.println("After negating: " + t))
                .sorted()
                .peek(t -> System.out.println("After sorting: " + t));

        List<Integer> resultList = numbStream2.collect(Collectors.toList());
        System.out.println("Final Result List: " + resultList);
    }
}