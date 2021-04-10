package run;

public class MyThreadByRunnable implements Runnable {

    private String name;
    private Thread thread;


    MyThreadByRunnable(String name) {
        System.out.println("Creat thread");
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("run->" + name + "-" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Stop thread");
    }

    //QUESTION: 10.04.2021 wtf????
    public void start() {
        System.out.println("Start thread");
        thread = new Thread(this, name);
        thread.start();
    }

    public void join() {

        try {
            if (thread != null && thread.isAlive()) thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
