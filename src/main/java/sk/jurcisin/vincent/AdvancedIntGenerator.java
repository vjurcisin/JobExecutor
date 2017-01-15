package sk.jurcisin.vincent;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Created by vincent on 1/13/17.
 */
public class AdvancedIntGenerator implements Callable<Integer> {

    private final Random seedGen;

    public AdvancedIntGenerator(Random seedGen) {
        this.seedGen = seedGen;
    }

    public Integer call() throws Exception {
        Random rnd = new Random(seedGen.nextInt());
        int countOfNumbers = 1000000;
        ArrayList<Integer> generatedNumbers = new ArrayList<Integer>();
        for (int i = 0; i < countOfNumbers; i++) {
            generatedNumbers.add(rnd.nextInt());
        }
        return generatedNumbers.get(rnd.nextInt(countOfNumbers));
    }
}
