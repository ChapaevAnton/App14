package guessing;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

public class Guessing {

    final static int MIN = 1;
    final static int MAX = 5;


    static Optional<String> guessValue(int guess) throws IllegalStateException, NoSuchElementException {

        if (guess < 1 || guess > 5) {
            throw new IllegalStateException("Некорректное значение...");
        }
        int random = new Random().nextInt((MAX - MIN) + 1) + MIN;

        if (random == guess) return Optional.of("Поздравляем! Вы угадали значение!");
        else {
            System.err.println("Вы не угадали!");
            return Optional.empty();
        }
    }

}
