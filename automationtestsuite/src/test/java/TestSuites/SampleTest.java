/*
package TestSuites;


import org.junit.Assert;
import org.junit.Test;
import org.testng.SkipException;

public class SampleTest extends BaseTest {

    @Test
    public void test1() {
        System.out.println("I am test1 test method and am expecting it to pass");
    }
    @Test(expectedExceptions=RuntimeException.class)
    public void test2() {
        System.out.println("I am in test2 test method and it will fail.");
    }

    @Test
    public void test3() {
        throw new SkipException("Skipping the test3 test method!");
    }

    private int i=0;
    @Test(successPercentage=60, invocationCount=5)
    public void test4() {
        i++;
        System.out.println("test4 test method, invocation count: " + i);
        if (i == 1 || i == 2) {
            System.out.println("test4 failed!");
            Assert.assertEquals(i, 8);
        }
    }











}
*/
