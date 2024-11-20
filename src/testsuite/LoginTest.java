package testsuite;

import browserfactory.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    /*
    2. Create the package ‘testsuite’ and create the
following class inside the ‘testsuite’ package.

1. LoginTest

3. Write down the following test in the ‘LoginTest’ class

1. userSholdLoginSuccessfullyWithValid

Credentials()
* Enter “standard_user” for the username
* Enter “secret_sauce” for the password
* Click on the ‘Login’ button
* Verify the text “Products”

2. verifyThatSixProductsAreDisplayedOnPage()
* Enter “standard_user” for the username
* Enter “secret_sauce” for the password
* Click on the ‘Login’ button
* Verify that six products are displayed
on page
     */

    String baseUrl = "https://www.saucedemo.com/";
   @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

@Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Verify the text 'Products'
        String expectedText = "Products";
        String actualText = driver.findElement(By.xpath("//span[@class = 'title']")).getText();
        Assert.assertEquals("Products", expectedText, actualText);

    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Verify that six products are displayed
        int totalProduct = driver.findElements(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item']")).size();

        Assert.assertEquals("Total product is not match", 6, totalProduct);

    }
    @After
    public void Close(){
       closeBrowser();
    }

    }
