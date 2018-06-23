package example;

import org.junit.Assert;
import org.junit.Test;

public class RePlaceTest {
    @Test
    public void testRePlace() throws Exception {
        RePlace rp = new RePlace();
        Assert.assertEquals("abc%20test",rp.replaceSpace(new StringBuffer("abc test")));
    }
}
