package sk.jurcisin.vincent;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by vincent on 1/14/17.
 */
public class GeneratorTests {

    @Test
    public void hundredGeneratedIntsTest() throws Exception {
        HundredRadnomInts hundredRadnomInts = new HundredRadnomInts(10);
        Thread t = new Thread(hundredRadnomInts);
        t.start();
        t.join();

        assertEquals(hundredRadnomInts.getHowManyInts(), hundredRadnomInts.getGeneratedNumbers().size());
        for (Integer i : hundredRadnomInts.getGeneratedNumbers()) {
            if (i == null)
                throw new Exception("Some numbers were not generated.");
        }
    }
}
