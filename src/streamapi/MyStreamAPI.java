package streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyStreamAPI {


    public static void main(String[] args) {


        List<Double> list = Arrays.asList(117d, 12.2d, 66d, 18.5d);
        List<String> list2 = Arrays.asList("15", "18.5", "117", "22.2");

        // TODO: 05.04.2021 14.5.10
        //to arrayList
        ArrayList<Double> arrayList = Stream.concat(list.stream(), list2.stream().map(Double::parseDouble))
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(arrayList);

        //println
        Stream.concat(list.stream(), list2.stream().map(Double::parseDouble))
                .distinct()
                .sorted(Comparator.reverseOrder()).forEach(System.out::println);

        //to String
        String str = Stream.concat(list.stream(), list2.stream().map(Double::parseDouble))
                .distinct()
                .sorted(Comparator.reverseOrder()).map(String::valueOf).collect(Collectors.joining("-"));

        System.out.println(str);


        // TODO: 05.04.2021 14.5.11
        IntStream intStream = IntStream.rangeClosed(1,100);
        int result = intStream.skip(50).limit(100).filter(value -> value%2==0||value%5==0).sum();
        System.out.println(result);
    }

}
