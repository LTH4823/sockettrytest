package zerock5.client.sub;

public class Loop1 extends Thread {

    @Override
    public void run(){
        execute();
    }

    public void execute(){
        for (int i = 0; i < 1000; i++) {

            System.out.println(Thread.currentThread().getName()+": "+i+":::::"+Loop1.this);
        }

    }
}
