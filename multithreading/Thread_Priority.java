class thread1 extends Thread{
    
    thread1(String name)
    {
        super(name);
    }
    @Override
    public void run()
    {
        System.out.println("Thread " + getName()); 
    }
}
public class Thread_Priority {
    public  static void main(String[] args)
    {
        thread1 t1 = new thread1("Thread1");
        thread1 t2 = new thread1("Thread2");
        thread1 t3 = new thread1("Thread3");
        thread1 t4 = new thread1("Thread4");
        thread1 t5 = new thread1("Thread5");
        t1.setPriority(Thread.MAX_PRIORITY);   //Setting the priority at max priority
        t5.setPriority(Thread.MIN_PRIORITY); //Setting the priority at min priority
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}
