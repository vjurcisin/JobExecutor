package sk.jurcisin.vincent;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        HundredRadnomInts hundredRadnomNumbers = new HundredRadnomInts(10);
        Thread t = new Thread(hundredRadnomNumbers);
        t.start();
    }
}
