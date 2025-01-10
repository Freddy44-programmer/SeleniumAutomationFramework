package TestNGTutorials;

import org.testng.annotations.Test;

public class test1 {

    @Test
    public void demo()
    {
        System.out.println("hello");
    }

    @Test(groups = "smoke")
    public void demo1()
    {
        System.out.println("Good day smoke");
    }
}
