package zerock5.client.sub;

public class Ex2 implements Runnable{

    private String name;

    public void execute(){
        this.name = Thread.currentThread().getName();
        for (int i = 0; i < 100; i++) {
            System.out.println(i +": " +name);
        }
    }

    @Override
    public void run() {
        execute();
    }

    public static void main(String[] args)throws Exception {

        Ex2 obj = new Ex2();

        new Thread(obj).start();
        new Thread(obj).start();
        new Thread(obj).start();
        new Thread(obj).start();

    }
}
