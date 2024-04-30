package levelone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @AfterMethod
    public void methodPostCondition() {
        driver.findElement(
                By.xpath("//div[contains(@class,'navbar-logged')]//button"))
                        .click();
        driver.navigate().to("https://telranedu.web.app/home");
    }
    @Test
    public void positiveLoginTest() {
        // click on login button by //a[@href='/login']
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        // input name by: //input[@name='email']
        WebElement inputEmail = driver.findElement(By.xpath(
                "//input[@name='email']"));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys("jbgjg@lkngb.com");

        // //input[@name='password']
        WebElement inputPassword = driver.findElement(By.xpath(
                "//input[@name='password']"));
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys("Qwerty123!");

        // click on login button by:  //button[@name='login']
        driver.findElement(By.xpath("//button[@name='login']")).click();

        // validation-verification by sigh out: //div[contains(@class,'navbar-logged')]//button
        // text: Sigh Out
        WebElement signOutBtn = driver.findElement(
                By.xpath("//div[contains(@class,'navbar-logged')]//button")
        );
        String actualRes = signOutBtn.getText().trim();
        System.out.println(actualRes);
//        Assert.assertEquals(
//                driver.findElement(
//                        By.xpath("/div[contains(@class,'navbar-logged')]//button"))
//                        .getText().trim(), "Sigh Out");
       Assert.assertEquals(actualRes, "Sign Out");

    }
}
