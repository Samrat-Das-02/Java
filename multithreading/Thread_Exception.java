class Thread1 extends Thread{
    @Override
    public void run() {
        try {
            for(int i = 0; i <5  ; i++) {
                System.out.println("child Thread"+i);
                Thread.sleep(500);
            }
        }
        catch(InterruptedException e) {
            System.out.println("The child thread is interrupted");

        }
       System.out.println("End of child Thread"); 
    }
}
public class Thread_Exception {
    public static void main(String[] args)
    {
       try {
        System.out.println("Main Thread : ");
        Thread.sleep(1000);
        Thread1 t1 = new Thread1();
        t1.start();
        t1.join();
       }
       catch (InterruptedException e) {
        System.out.println(" the main threa is interrupted ");
       }
       System.out.println("End of main Thread");
    }
}
