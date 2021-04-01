package lambda;

public class Lambda {

    public static void main(String[] args) {

        String value = "10";

        System.out.println(doubleFromString(value, (str) -> Double.parseDouble(value)));


    }

    static double doubleFromString(String value, Worker worker) {
        return worker.rework(value);
    }


}
