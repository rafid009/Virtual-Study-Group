package Server;

/**
 * Created by MdRafid on 11/28/2015.
 */
public class QsyncServer {
    boolean value = false;

    synchronized boolean get()
    {
        while(!value)
        {
            try{
                wait();

            }catch(InterruptedException e)
            {
                System.out.println("InterruptedException caught!!");
            }
        }
        value = false;
        notifyAll();
        return true;
    }

    synchronized void put(int i)
    {
        while(value)
        {
            try{
                wait();

            }catch(InterruptedException e)
            {
                System.out.println("InterruptedException caught!!");
            }
        }
        value = true;
        notifyAll();

    }
}
