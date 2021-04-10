package run;

public class Main {
    public static void main(String[] args) {

        MyThreadByRunnable myThreadByRunnable = new MyThreadByRunnable("myThread");
        MyThreadByRunnable myThreadByRunnable1 = new MyThreadByRunnable("myThread1");
        myThreadByRunnable.start();
        myThreadByRunnable1.start();
        myThreadByRunnable.join();
        myThreadByRunnable1.join();



    }

}
