import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SampleableListImplTest {

    @Test
    public void testSample() {
        SampleableListImpl sli = new SampleableListImpl();
        for (int i = 1; i < 8; i++) {
            sli.add(i);
        }
        SampleableListImpl sample = sli.sample();
        assertEquals(1, sample.get(0).getReturnValue());
        assertEquals(3, sample.get(1).getReturnValue());
        assertEquals(5, sample.get(2).getReturnValue());
        assertEquals(7, sample.get(3).getReturnValue());
    }
}