import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        task1();
        System.out.println();
        task2();
    }

    public static void task1() {
        Stream<Integer> stream = new ArrayList<>(Arrays.asList(10, 3, 5, 6, 2, 13, 17)).stream();

        findMinMax(stream, Integer::compareTo, (x, y) -> System.out.printf("min: " + x + ", max: " + y));

        stream.close();
    }

    public static void task2() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 0, 9, 4);
        int count = (int) numbers.stream()
                .filter(i -> i % 2 == 0)
                .count();
        System.out.println("Количество чётных чисел: " + count);
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list;
        T min = null;
        T max = null;
        list = stream
                .sorted(order)
                .collect(Collectors.toList());
        if (list.size() != 0) {
            min = list.get(0);
            max = list.get(list.size() - 1);
        }
        minMaxConsumer.accept(min, max);
    }
}