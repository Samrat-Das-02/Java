class Thread_demo implements Runnable {
    public void run()
    {
        for(int i = 0; i <10 ; i++) {
            System.out.println(i);
        }
    
    }
}
class Thread_using_Runnable{
    public static void main(String[] args)
    {
        Thread_demo td =new Thread_demo();
        Thread t=new Thread(td);
        t.start();
    }
}