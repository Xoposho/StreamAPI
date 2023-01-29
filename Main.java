
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
import java.util.Comparator;
import java.util.function.BiConsumer;


public class Main {

    //TASK 1
    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {
        T min, max;
        List<T> tList;

        tList = stream
                .sorted(order)
                .collect(Collectors.toList());

        if (tList.size() != 0) {
            min = tList.get(0);
            max = tList.get(tList.size() - 1);
            minMaxConsumer.accept(min, max);
        } else {
            minMaxConsumer.accept(null, null);
        }

    }

    //TASK 2

    public static void countEvenNumbers(Stream<Integer> stream){
        System.out.println("Чётные числа: ");
        stream
              .filter(i -> i % 2 == 0)
              .forEach(System.out::println);
    }

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 6, 8, 0, 5, 34, 3, 6, 8, 3);

        findMinMax(integers.stream(), Integer::compareTo, (x, y) -> System.out.println("Минимальное число - " + x +
                 "\n" + "Максимальное число - " + y));

        countEvenNumbers(integers.stream());


    }
}
