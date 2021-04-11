package task;

@FunctionalInterface
public interface ShareDozen {
    boolean isSharedDozen(int value);

    static boolean isDozen(int value) {
        return value % 13 == 0;
    }
}
