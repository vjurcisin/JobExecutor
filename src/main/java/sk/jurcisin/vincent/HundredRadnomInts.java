package sk.jurcisin.vincent;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by vincent on 1/13/17.
 */
public class HundredRadnomInts implements Runnable {

    private final ExecutorService pool;
    private final int howManyInts = 100;
    private final LinkedList<Integer> generatedNumbers = new LinkedList<Integer>();

    public HundredRadnomInts(int poolSize) {
        this.pool = Executors.newFixedThreadPool(poolSize);
    }

    public void run() {
        Random seedGen = new Random(Long.MAX_VALUE);
        for (int i = 0; i< howManyInts; i++) {
            try {
                generatedNumbers.add(i, this.pool.submit(new AdvancedIntGenerator(seedGen)).get());
            } catch (Exception e) {
                generatedNumbers.add(i, null);
                e.printStackTrace();
            }
        }
        pool.shutdown();
    }

    public int getHowManyInts() {
        return howManyInts;
    }

    public LinkedList<Integer> getGeneratedNumbers() {
        return generatedNumbers;
    }
}
