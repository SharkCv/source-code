package MyPackage;

import junit.framework.Assert;
import junit.framework.TestCase;

public class AppTest
        extends TestCase {
    PwdTool p = new PwdTool();

    public AppTest(String testName) {
        super(testName);
    }

    public void testApp() {
        assertTrue(true);
    }

    public void testStrong() {
        Assert.assertEquals(Weight.STRONG, p.check("WooHooaa22#$"));
    }

    public void testGood() {
        Assert.assertEquals(Weight.GOOD, p.check("WooHoo12#$"));
    }

    public void testWeak() {
        Assert.assertEquals(Weight.WEAK, p.check("WooH12#$"));
    }

    public void testRus() {
        Assert.assertNotNull(p.check("йцукен12№?"));
    }

    public void testNull() {
        Assert.assertNotNull(p.check(null));
    }
}
