package cat;

public class Cat implements Walk, Run {

    public static void main(String[] args) {

        System.out.println(new Cat().getSpeed());

        System.out.println(Run.setSpeed(10));
    }

    @Override
    public int getSpeed() {
        return 88;
    }
}
