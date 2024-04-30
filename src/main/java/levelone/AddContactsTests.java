package levelone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;


public class AddContactsTests extends BaseTest {
    @BeforeClass
    public void preconditions() {
        // TODO login
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
    }

    @Test
    public void positiveAddContact() throws InterruptedException {

        // click on //a[@href='/add'] - open add contact page
        driver.findElement(By.xpath("//a[@href='/add']")).click();
        // fill name in //input[@placeholder='Name']
        WebElement name = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        name.click();
        name.clear();
        name.sendKeys("lksdjfno");
        // fill last name //input[@placeholder='Last Name']
        WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        lastName.click();
        lastName.clear();
        lastName.sendKeys("dfjkgn");
        // fill phone
        WebElement phone = driver.findElement(By.xpath("//input[@placeholder='Phone']"));
        phone.click();
        phone.clear();
        String phoneNumber = "5554567890";
        phone.sendKeys(phoneNumber);
        // fill e-mail
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='email']"));
        email.clear();
        email.click();
        email.sendKeys("jnvw@lnkeg.com");
        // fill address
        WebElement address = driver.findElement(By.xpath("//input[@placeholder='Address']"));
        address.click();
        address.clear();
        address.sendKeys("jkfnw");
        // fill description
        WebElement description = driver.findElement(By.xpath("//input[@placeholder='description']"));
        description.click();
        description.clear();
        description.sendKeys("kdfjngekr");
        // click save /div[contains(@class, 'add_form')//button]
        driver.findElement(By.xpath("//div[contains(@class,'add_form')]//button")).click();

        Thread.sleep(7000);
//TODO
        List<WebElement> allPhones = driver.findElements(By.xpath("//div[contains(@class,'contact-item_card')]//h3"));

        boolean res = false;
        for(WebElement el:allPhones) {
          if(el.getText().trim().equals(phoneNumber)) {
              res = true;
              break;
          }
        }
        Assert.assertTrue(res);
    }

}
