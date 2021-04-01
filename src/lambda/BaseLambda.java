package lambda;
// TODO: 01.04.2021 14.2
import java.util.function.*;

public class BaseLambda {

    public static void main(String[] args) {

        //поставщик
        Supplier<Integer> supplier = () -> 10;

               
        //получатель
        Consumer<String> consumer = (string) -> System.out.println(string);
        Consumer<String> consumerRef = System.out::println;

        //Двойной получатель
        BiConsumer<Integer, Integer> biConsumer = (value1, value2) -> System.out.println(value1 + value2);

        //Специализированная двойная функция
        ToDoubleBiFunction<Double, Double> toDoubleBiFunction = (value1, value2) -> Double.min(value1, value2);
        ToDoubleBiFunction<Double, Double> toDoubleBiFunctionRef = Double::min;

        //Предикат
        Predicate<Integer> predicate = (value1) -> value1 > 10;

        System.out.println(supplier.get());
        consumer.accept("lambda");
        biConsumer.accept(2, 5);
        System.out.println(toDoubleBiFunction.applyAsDouble(10., 50.));
        System.out.println(predicate.test(5));
    }
}
