package lambda;

import java.util.function.Supplier;

@FunctionalInterface
interface Worker {

    int CONST = 1;
    String STR = "str";

    double rework(String value);

    default int getValue() {
        return 10;
    }

    default int setValue(int value) {
        return value + getValue();
    }

    private int getInt() {
        return 100;
    }

    static double getDouble() {
        return 50.;
    }

    Supplier<Integer> supplied = () -> 299;

    class Nested implements Worker {

        interface nestedInterface {
            Nested getNested();
        }

        nestedInterface nestedInterface = Nested::new;

        @Override
        public double rework(String value) {
            return 0;
        }
    }
}
