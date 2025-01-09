package TestNGTutorials;

import org.testng.annotations.*;

public class test3 {


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
        System.out.println("Web login car loan");
    }

    @BeforeSuite
    public void Bfsuite()
    {
        System.out.println("Before suite annotation");
    }
    @Test
    public void MobileloginCarLoan()
    {
        System.out.println("Mobile login car loan");
    }
    @Test
    public void MobileSignInCarLoan()
    {
        System.out.println("Mobile login car loan signin");
    }
    @Test
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
