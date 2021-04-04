package streamapi;

import java.util.*;
import java.util.stream.Stream;

// TODO: 04.04.2021 14.5
public class Main {

    public static void main(String[] args) {

        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(array));

        Stream<String> stringStream = Stream.empty();
        Stream<Integer> stringStream1 = Stream.of(5, 5, 5, 5, 5, 5, 6);
        Stream<Integer> stringStream2 = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> stringStream3 = Arrays.stream(array);

        Stream<Integer> stringStream5 = Stream.generate(() -> new Random().nextInt(10));
        Stream<Integer> stringStream6 = Stream.iterate(1, x -> x + 1);


        boolean value = stringStream2.allMatch(x -> x <= 5);
        System.out.println(value);

        value = stringStream5.anyMatch(x -> x == 5);
        System.out.println(value);

        value = stringStream1.noneMatch(x -> x != 5);
        System.out.println(value);

        System.out.println(stringStream3.count());

        stringStream3 = Arrays.stream(array);
        System.out.println(stringStream3.findAny());

        stringStream3 = Arrays.stream(array);
        System.out.println(stringStream3.findFirst());


        Stream<Integer> stringStream4 = arrayList.stream();

        ArrayList<Integer> strings = stringStream4.collect(() -> new ArrayList<Integer>(), (i, val) -> i.add(val), (i, val) -> i.addAll(val));
        System.out.println(strings);

        stringStream4 = Arrays.stream(array);
        Optional<Integer> max = stringStream4.max(Comparator.comparingInt(val -> val));
        System.out.println(max);

        System.out.println(Arrays.stream(array).min(Comparator.comparingInt(val -> val)).get());

        Stream<String> collectStream = Stream.of("w", "o", "l", "f");
        StringBuilder wolfBuilder = collectStream.collect(StringBuilder::new,StringBuilder::append, StringBuilder::append);
        System.out.println(wolfBuilder.toString());

    }


}
