package optional;

// TODO: 02.04.2021 14.4
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static String getString(String str) {
        if (str.length() >= 5) {
            return null;
        } else {
            return str + " refactored";
        }
    }

    public static void main(String[] args) {


        // FIXME: 02.04.2021
        //Optional<String> optional = Optional.of(getString("Hello"));
        Optional<String> optional = Optional.ofNullable(getString("Hello"));
        System.out.println(optional.orElseThrow(IllegalStateException::new));


        System.out.println(MyOptional.getAverage().isEmpty());
        System.out.println(MyOptional.getAverage(10).isEmpty());
        System.out.println(MyOptional.getAverage(10).get());

        System.out.println(MyOptional.getString(null));

        Optional<String> str = MyOptional.getString("str");

        Consumer<String> consumer = (str1) -> {
            str1 = str1.toUpperCase();
            System.out.println("consumer=" + str1);
        };

        Function<String, Double> function = (valueStr) -> {
            double value = Double.parseDouble(valueStr.replaceAll("\\D", ""));
            System.out.println("function=" + value);
            return value;
        };

        Supplier<Integer> supplier = () -> 30;

        str.ifPresent(consumer);

        str = MyOptional.getString("123");
        str.map(function);


        str.ifPresent(s -> {
            s += "test";
            System.out.println(s);
        });


        String str1 = MyOptional.getString("1", "2", "3").get();
        System.out.println(str1);

    }
}
