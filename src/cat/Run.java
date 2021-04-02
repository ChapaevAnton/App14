package cat;

public interface Run {

    default int getSpeed() {
        return 50;
    }

    static int setSpeed(int speed) {
        return speed;
    }
}
