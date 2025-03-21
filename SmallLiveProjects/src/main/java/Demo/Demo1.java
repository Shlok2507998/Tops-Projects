package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;

public class Demo1 {
    WebDriver driver = null;
    WebElement myAccountHomePage = null;
    WebElement registerHomePage = null;

    @BeforeMethod
public void InitialCodes(){

        driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://tutorialsninja.com/demo/");

    myAccountHomePage = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]"));
    myAccountHomePage.click();

    registerHomePage = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a"));
    registerHomePage.click();
}

@AfterMethod
public void ClosingCodes(){
        driver.quit();
}


    @Test
    public void registerAccountWithMandatoryField(){



        WebElement firstNameText = driver.findElement(By.xpath("//*[@id=\"input-firstname\"]"));
        firstNameText.sendKeys("Shlok");

        WebElement LastNameText = driver.findElement(By.xpath("//*[@id=\"input-lastname\"]"));
        LastNameText.sendKeys("Shukla");

        Date date = new Date();
        String Email = date.toString().replace(" ", "_").replace(":","_") + "@gmail.com";

        WebElement EmailText = driver.findElement(By.xpath("//*[@id=\"input-email\"]"));
        EmailText.sendKeys(Email);

        WebElement telePhoneTextField = driver.findElement(By.xpath("//*[@id=\"input-telephone\"]"));
        telePhoneTextField.sendKeys("7043614219");

        WebElement PasswordTextField = driver.findElement(By.xpath("//*[@id=\"input-password\"]"));
        PasswordTextField.sendKeys("123456");

        WebElement ConfirmPasswodTextField = driver.findElement(By.xpath("//*[@id=\"input-confirm\"]"));
        ConfirmPasswodTextField.sendKeys("123456");

        WebElement PrivacyPolicyRadioButton = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]"));
        PrivacyPolicyRadioButton.click();

        WebElement ContinueButton = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
        ContinueButton.click();


        String ExpectedTitle = "Your Account Has Been Created!";
        String AcctualTitle= driver.getTitle();
        if(AcctualTitle.equals(ExpectedTitle)){
            System.out.println("Registration successful");
            WebElement MyAccount = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]"));
            MyAccount.click();
            WebElement LogoutOption = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a"));
            LogoutOption.click();
            WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a"));
            continueButton.click();



        }else{
            System.out.println("Registration Unsuccessful");


        }













    }

}


