package TestSuites;

import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;

public class MultiBrowser {

    @Test
    public void runAllTests() {
        Class<?>[] classes = { ChromeTest.class, FireFoxTest.class };

        // ParallelComputer(true,true) will run all classes and methods
        // in parallel.  (First arg for classes, second arg for methods)
        JUnitCore.runClasses(new ParallelComputer(true, true), classes);
    }
}

