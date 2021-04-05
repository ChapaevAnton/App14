package streamapi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
        StringBuilder wolfBuilder = collectStream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(wolfBuilder.toString());

        List<String> list = Arrays.asList("Toby", "Anna", "Leroy", "Alex");
        List<String> filtered = new ArrayList<>();

        for (String name : list) {
            if (name.length() == 4) {
                filtered.add(name);
            }
        }

        Collections.sort(filtered);
        Iterator<String> iterator = filtered.iterator();

        int count = 0;
        while (count < 2) {
            String val = iterator.next();
            System.out.println(val);
            count++;
        }

        list.stream().filter(val -> val.length() == 4).sorted().limit(2).forEach(System.out::println);

        String[] strArray = {"1", "2", "3", "4", "5"};
        Stream<String> streamStr = Arrays.stream(strArray);

        int result = streamStr.map(Integer::parseInt).reduce(1, (valPref, valNext) -> valPref * valNext);
        System.out.println(result);

        IntStream intStream = Arrays.stream(array).mapToInt(value1 -> value1);
        int result2 = intStream.sum();
        System.out.println(result2);
        intStream = IntStream.builder().add(2).add(5).add(6).build();
        intStream.forEach(System.out::print);

        System.out.println();
        collectStream = Arrays.stream(strArray);
        String str1 = collectStream.collect(Collectors.joining(","));
        System.out.println(str1);

        streamStr = Arrays.stream(strArray);
        double result3 = streamStr.map(Integer::parseInt).collect(Collectors.averagingInt(val1 -> val1));
        System.out.println(result3);

        streamStr = Arrays.stream(strArray);
        List<String> listCollection = streamStr.collect(Collectors.toCollection(ArrayList::new));
        System.out.println(listCollection);


        Map<String, Integer> mapCollection = list.stream().collect(Collectors.toMap(keyMap -> keyMap, String::length));
        System.out.println(mapCollection);

        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> map = ohMy.collect(Collectors.groupingBy(String::length));
        System.out.println(map); // {5=[lions, bears], 6=[tigers]}

        Stream<String> ohMy1 = Stream.of("lions", "tigers", "bears");
        Map<Integer, String> map1 = ohMy1.collect(Collectors.toMap(
                String::length, // ключ - длина массива
                k -> k, // значение - сами строки
                (s1, s2) -> s1 + "," + s2, // таким образом объединяем строки по одинаковому ключу
                TreeMap::new // указали Java дать конкретную требуемую имплементацию
        )); // {5 = lions,bears, 6 = tigers}
        System.out.println(map1);
        System.out.println(map1.getClass()); // class java.util.TreeMap

    }


}
