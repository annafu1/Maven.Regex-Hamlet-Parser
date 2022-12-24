import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        hamletParser.findHamletReplaceLeon();
        Assert.assertFalse(hamletParser.getHamletData().contains("hamlet"));
    }

    @Test
    public void testChangeHoratioToTariq() {
        hamletParser.findHoratioReplaceTariq();
        Assert.assertFalse(hamletParser.getHamletData().contains("horatio"));
    }

    @Test
    public void testFindHoratio() {
        int expected = 0;
        int actual = hamletParser.findHoratio();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testFindHamlet() {
        int expected = 0;
        int actual = hamletParser.findHamlet();
        Assert.assertEquals(expected,actual);
    }
}
