package TestNGTutorials;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test2 {

    @AfterTest
    public void lastExecution()
    {
        System.out.println("After Test annotation");
    }

    @Test(groups = "smoke")
    public void demo3()
    {
        System.out.println("Good day day smoke smoke");
    }


    @BeforeTest
    public void prerequiste()
    {
        System.out.println("Before Test annotation");
    }

}
