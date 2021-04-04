package guessing;

// TODO: 04.04.2021 14.4.5
public class Main {

    public static void main(String[] args) {

        try {
            Guessing.guessValue(5).ifPresent(System.out::println);
        } catch (IllegalStateException err) {
            System.err.println(err.getMessage());
        }
    }
}
