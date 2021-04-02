package optional;

import java.util.Arrays;
import java.util.Optional;

public class MyOptional {

    static Optional<Double> getAverage(int... scores) {

        if (scores.length == 0) return Optional.empty();

        int result = 0;
        for (int score : scores) {
            result += score;
        }
        return Optional.of((double) result / scores.length);
    }

    static Optional<String> getString(String... str) {

        return Optional.ofNullable(Arrays.toString(str));

    }

}
