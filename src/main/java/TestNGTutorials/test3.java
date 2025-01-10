package TestNGTutorials;

import org.testng.annotations.*;

public class test3 {

    @BeforeClass
    public void BeforeClass()
    {
        System.out.println("Before class annotation");
    }

    @AfterClass
    public void AfterClass()
    {
        System.out.println("After class annotation");
    }

    @AfterSuite
    public void Afsuite()
    {
        System.out.println("After suite annotation");
    }

    @BeforeMethod
    public void BeforeMethod()
    {
        System.out.println("Before Method annotation");
    }


    @AfterMethod
    public void AfterMethod()
    {
        System.out.println("After Method annotation");
    }
    @Test
    public void WebloginCarLoan()
    {
        System.out.println("Web login car loan smoke/ depends on method loginCarloan");
    }

    @BeforeSuite
    public void Bfsuite()
    {
        System.out.println("Before suite annotation");
    }
    @Test(dependsOnMethods = {"WebloginCarLoan"})
    public void MobileloginCarLoan()
    {
        System.out.println("Mobile login car loan");
    }
    @Test
    public void MobileSignInCarLoan()
    {
        System.out.println("Mobile login car loan signin");
    }
    @Test(groups = "smoke")
    public void MobileSignOutCarLoan()
    {
        System.out.println("Mobile login car loan signout");
    }


    @Test
    public void loginApiCarLoan()
    {
        System.out.println("Login API car loan");
    }
}
