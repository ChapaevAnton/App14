package cat;

public interface Walk {

    default int getSpeed() {
        return 10;
    }
}

