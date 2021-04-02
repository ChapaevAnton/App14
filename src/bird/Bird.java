package bird;

public class Bird implements Flaying {

    private void flay() {
        System.out.println("bird flay");
    }

    public static void main(String[] args) {

        // FIXME: 02.04.2021
        //Flaying bird = new Bird();
        Bird bird = new Bird();
        bird.flay();

    }
}
