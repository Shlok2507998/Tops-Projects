package Ts_01;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

import static org.openqa.selenium.By.*;

public class RegisterAccountTest {

   //Global commands
    WebDriver driver = null;
    WebElement MyAccountDropMenu = null;
    WebElement RegisterOption = null;

    @BeforeMethod
    public void Setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo");

        MyAccountDropMenu = driver.findElement(xpath("//span[text()='My Account']"));
        MyAccountDropMenu.click();

        RegisterOption = driver.findElement(xpath("//a[text()='Register']"));
        RegisterOption.click();

    }

    @AfterMethod
    public void tearDown(){

        driver.quit();

    }

    @Test
    public void  RegisterAccountWithMandatoryFields(){

        WebElement FirstName = driver.findElement(id("input-firstname"));
    FirstName.sendKeys("Shlok");

    WebElement LastName = driver.findElement(id("input-lastname"));
    LastName.sendKeys("Shukla");


        Date date = new Date();
        String Email = date.toString().replace(" ", "_").replace(":","_")+ "@gmail.com";

    WebElement EmailField = driver.findElement(id("input-email"));
    EmailField.sendKeys(Email);

    WebElement Telephone = driver.findElement(id("input-telephone"));
    Telephone.sendKeys("7043614219");

    WebElement Password = driver.findElement(id("input-password"));
    Password.sendKeys("Jordan@97");

    WebElement ConfirmPassword = driver.findElement(id("input-confirm"));
    ConfirmPassword.sendKeys("Jordan@97");

    WebElement Checkbox = driver.findElement(name("agree"));
    Checkbox.click();

    WebElement ClickOnContinue = driver.findElement(xpath("//input[@value=\"Continue\"]"));
    ClickOnContinue.click();

    MyAccountDropMenu = driver.findElement(xpath("//span[text()='My Account']"));
    MyAccountDropMenu.click();

    WebElement LogoutOption = driver.findElement(linkText("Logout"));
        Assert.assertTrue(LogoutOption.isDisplayed());

        String actualURL=driver.getCurrentUrl();
        String expectedURL= "https://tutorialsninja.com/demo/index.php?route=account/success";
        Assert.assertEquals(actualURL,expectedURL);

        String ExpectedText = "Your Account Has Been Created!";
        WebElement HeadingElement = driver.findElement(xpath("//div[@id='content']/h1"));
        String ActualHeadingText = HeadingElement.getText();
        Assert.assertEquals(ActualHeadingText , ExpectedText);

        WebElement actualCongratulationElement = driver.findElement(xpath("//div[@id='content']/h1/following-sibling::p"));
        String actualCongratulationText= actualCongratulationElement.getText();
        String expectedCongratulationText = "Congratulations! Your new account has been successfully created!";
        Assert.assertTrue(expectedCongratulationText.contains(actualCongratulationText) );

        WebElement ActualMemberPrivilegesElement = driver.findElement(xpath("//div[@id='content']/h1/following-sibling::p[2]"));
        String actualMemberPrivilegeText = ActualMemberPrivilegesElement.getText() ;
        String ExpectedMemberPrivilegeText = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
        Assert.assertTrue(ExpectedMemberPrivilegeText.contains(actualMemberPrivilegeText));

        WebElement ActualAnyQuestionElement = driver.findElement(xpath("//div[@id='content']/h1/following-sibling::p[3]"));
        String ActualAnyQuestionText = ActualAnyQuestionElement.getText();
        String ExpectedAnyQuestionText = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
        Assert.assertTrue(ExpectedAnyQuestionText.contains(ActualAnyQuestionText));

        WebElement ActualConfirmationMailElement = driver.findElement(xpath("//div[@id='content']/h1/following-sibling::p[4]"));
        String ActualConfirmationMailText = ActualConfirmationMailElement.getText();
        String ExpectedConfirmationMailText = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";
        Assert.assertTrue(ExpectedConfirmationMailText.contains(ActualConfirmationMailText));

        WebElement ContactUsLinkElement = driver.findElement(linkText("contact us"));
        ContactUsLinkElement.isDisplayed();
        Assert.assertTrue(ContactUsLinkElement.isDisplayed());



        WebElement ContinueButton =  driver.findElement(xpath("//a[text()= 'Continue']"));
        ContinueButton.click();


}

    @Test
    public  void RegisterAccountWithAllFields(){


    WebElement FirstName = driver.findElement(id("input-firstname"));
    FirstName.sendKeys("Shlok");

    WebElement LastName = driver.findElement(id("input-lastname"));
    LastName.sendKeys("Shukla");


    Date date = new Date();
    String Email = date.toString().replace(" ", "_").replace(":","_")+ "@gmail.com";

    WebElement EmailField = driver.findElement(id("input-email"));
    EmailField.sendKeys(Email);

    WebElement Telephone = driver.findElement(id("input-telephone"));
    Telephone.sendKeys("7043614219");

    WebElement Password = driver.findElement(id("input-password"));
    Password.sendKeys("Jordan@97");

    WebElement ConfirmPassword = driver.findElement(id("input-confirm"));
    ConfirmPassword.sendKeys("Jordan@97");

    WebElement YesField = driver.findElement(xpath("//input[@name='newsletter'][@value=\"1\"]"));
    YesField.click();

    WebElement Checkbox = driver.findElement(name("agree"));
    Checkbox.click();

    WebElement ClickOnContinue = driver.findElement(xpath("//input[@value=\"Continue\"]"));
    ClickOnContinue.click();

    MyAccountDropMenu = driver.findElement(xpath("//span[text()='My Account']"));
    MyAccountDropMenu.click();

    WebElement LogoutOption = driver.findElement(linkText("Logout"));
    Assert.assertTrue(LogoutOption.isDisplayed());

    String actualURL=driver.getCurrentUrl();
    String expectedURL= "https://tutorialsninja.com/demo/index.php?route=account/success";
    Assert.assertEquals(actualURL,expectedURL);

    String ExpectedText = "Your Account Has Been Created!";
    WebElement HeadingElement = driver.findElement(xpath("//div[@id='content']/h1"));
    String ActualHeadingText = HeadingElement.getText();
    Assert.assertEquals(ActualHeadingText , ExpectedText);

    WebElement actualCongratulationElement = driver.findElement(xpath("//div[@id='content']/h1/following-sibling::p"));
    String actualCongratulationText= actualCongratulationElement.getText();
    String expectedCongratulationText = "Congratulations! Your new account has been successfully created!";
    Assert.assertTrue(expectedCongratulationText.contains(actualCongratulationText) );

    WebElement ActualMemberPrivilegesElement = driver.findElement(xpath("//div[@id='content']/h1/following-sibling::p[2]"));
    String actualMemberPrivilegeText = ActualMemberPrivilegesElement.getText() ;
    String ExpectedMemberPrivilegeText = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
    Assert.assertTrue(ExpectedMemberPrivilegeText.contains(actualMemberPrivilegeText));

    WebElement ActualAnyQuestionElement = driver.findElement(xpath("//div[@id='content']/h1/following-sibling::p[3]"));
    String ActualAnyQuestionText = ActualAnyQuestionElement.getText();
    String ExpectedAnyQuestionText = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
    Assert.assertTrue(ExpectedAnyQuestionText.contains(ActualAnyQuestionText));

    WebElement ActualConfirmationMailElement = driver.findElement(xpath("//div[@id='content']/h1/following-sibling::p[4]"));
    String ActualConfirmationMailText = ActualConfirmationMailElement.getText();
    String ExpectedConfirmationMailText = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";
    Assert.assertTrue(ExpectedConfirmationMailText.contains(ActualConfirmationMailText));

    WebElement ContactUsLinkElement = driver.findElement(linkText("contact us"));
    ContactUsLinkElement.isDisplayed();
    Assert.assertTrue(ContactUsLinkElement.isDisplayed());



    WebElement ContinueButton =  driver.findElement(xpath("//a[text()= 'Continue']"));
    ContinueButton.click();

}

    @Test
    public void RegisterAccountWithoutAnyData(){

        WebElement ContinueButton1 = driver.findElement(xpath("//input[@value='Continue']"));
        ContinueButton1.click();

        //Checking first name error message.
WebElement ActualFirstNameErrorMessageElement = driver.findElement(xpath("//div[text()=\"First Name must be between 1 and 32 characters!\"]"));
String ExpectedFirstNameErrorMessage =  "First Name must be between 1 and 32 characters!";
String ActualFirstNameErrorMessage = ActualFirstNameErrorMessageElement.getText();
Assert.assertEquals( ActualFirstNameErrorMessage ,  ExpectedFirstNameErrorMessage );

        //Checking Last name error message.
    WebElement ActualLastNameErrorMessageElement = driver.findElement(xpath("//div[text()=\"Last Name must be between 1 and 32 characters!\"]"));
    String ExpectedLastNameErrorMessage = "Last Name must be between 1 and 32 characters!";
    String ActualLastNameErrorMessage = ActualLastNameErrorMessageElement.getText();
    Assert.assertEquals(ActualLastNameErrorMessage ,  ExpectedLastNameErrorMessage);

    //Checking Main Error message.
    WebElement EmailErrorMessageElement = driver.findElement(xpath("//div[text()=\"E-Mail Address does not appear to be valid!\"]"));
    String ExpectedEmailErrorMessage = "E-Mail Address does not appear to be valid!";
    String ActualEmailErrorMessage = EmailErrorMessageElement.getText();
    Assert.assertEquals(ActualEmailErrorMessage , ExpectedEmailErrorMessage );

    //Checking Telephone Error message.
    WebElement ExpectedTelephoneErrorMessageElement = driver.findElement(xpath("//div[text()=\"Telephone must be between 3 and 32 characters!\"]"));
    String ExpectedTelephoneErrorMessage = "Telephone must be between 3 and 32 characters!";
    String ActualTelephoneErrorMessage = ExpectedTelephoneErrorMessageElement.getText();
    Assert.assertEquals(ActualTelephoneErrorMessage ,ExpectedTelephoneErrorMessage );

    //Checking Password error message.
   WebElement ExpectedPasswordErrorMessageElement = driver.findElement(xpath("//div[text()=\"Password must be between 4 and 20 characters!\"]"));
    String ExpectedPasswordErrorMessage = "Password must be between 4 and 20 characters!";
    String ActualPasswordErrorMessage = ExpectedPasswordErrorMessageElement.getText();
    Assert.assertEquals(ActualPasswordErrorMessage,ExpectedPasswordErrorMessage);

    //Checking Privacy policy error message.
    String ActualPrivacyPolicyErrorMessage = driver.findElement(xpath("//div[@id=\"account-register\"]/div[1]")).getText();
    String ExpectedPrivacyPolicyErrorMessage = "Warning: You must agree to the Privacy Policy!";
    Assert.assertTrue(ActualPrivacyPolicyErrorMessage.contains(ExpectedPrivacyPolicyErrorMessage) );

    WebElement ContinueButton = driver.findElement(xpath("//input[@value='Continue']"));
    ContinueButton.click();





}

    @Test
    public void RegisterAccountWithYesOptionInNewsLetter(){


    WebElement FirstName = driver.findElement(id("input-firstname"));
    FirstName.sendKeys("Shlok");

    WebElement LastName = driver.findElement(id("input-lastname"));
    LastName.sendKeys("Shukla");


    Date date = new Date();
    String Email = date.toString().replace(" ", "_").replace(":","_")+"@gmail.com";

    WebElement EmailTextField = driver.findElement(xpath("//input[@id='input-email']"));
    EmailTextField.sendKeys(Email);

    WebElement Telephone = driver.findElement(id("input-telephone"));
    Telephone.sendKeys("7043614219");

    WebElement Password = driver.findElement(id("input-password"));
    Password.sendKeys("Jordan@97");

    WebElement ConfirmPassword = driver.findElement(id("input-confirm"));
    ConfirmPassword.sendKeys("Jordan@97");

    WebElement NewsLetterYesField = driver.findElement(xpath("//input[@name='newsletter'][@value=\"1\"]"));
    NewsLetterYesField.click();

    WebElement Checkbox = driver.findElement(name("agree"));
    Checkbox.click();

    WebElement ClickOnContinue = driver.findElement(xpath("//input[@value=\"Continue\"]"));
    ClickOnContinue.click();

    MyAccountDropMenu = driver.findElement(xpath("//span[text()='My Account']"));
    MyAccountDropMenu.click();

    WebElement LogoutOption = driver.findElement(linkText("Logout"));
    Assert.assertTrue(LogoutOption.isDisplayed());

    String actualURL=driver.getCurrentUrl();
    String expectedURL= "https://tutorialsninja.com/demo/index.php?route=account/success";
    Assert.assertEquals(actualURL,expectedURL);

    String ExpectedText = "Your Account Has Been Created!";
    WebElement HeadingElement = driver.findElement(xpath("//div[@id='content']/h1"));
    String ActualHeadingText = HeadingElement.getText();
    Assert.assertEquals(ActualHeadingText , ExpectedText);

    WebElement actualCongratulationElement = driver.findElement(xpath("//div[@id='content']/h1/following-sibling::p"));
    String actualCongratulationText= actualCongratulationElement.getText();
    String expectedCongratulationText = "Congratulations! Your new account has been successfully created!";
    Assert.assertTrue(expectedCongratulationText.contains(actualCongratulationText) );

    WebElement ActualMemberPrivilegesElement = driver.findElement(xpath("//div[@id='content']/h1/following-sibling::p[2]"));
    String actualMemberPrivilegeText = ActualMemberPrivilegesElement.getText() ;
    String ExpectedMemberPrivilegeText = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
    Assert.assertTrue(ExpectedMemberPrivilegeText.contains(actualMemberPrivilegeText));

    WebElement ActualAnyQuestionElement = driver.findElement(xpath("//div[@id='content']/h1/following-sibling::p[3]"));
    String ActualAnyQuestionText = ActualAnyQuestionElement.getText();
    String ExpectedAnyQuestionText = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
    Assert.assertTrue(ExpectedAnyQuestionText.contains(ActualAnyQuestionText));

    WebElement ActualConfirmationMailElement = driver.findElement(xpath("//div[@id='content']/h1/following-sibling::p[4]"));
    String ActualConfirmationMailText = ActualConfirmationMailElement.getText();
    String ExpectedConfirmationMailText = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";
    Assert.assertTrue(ExpectedConfirmationMailText.contains(ActualConfirmationMailText));

    WebElement ContactUsLinkElement = driver.findElement(linkText("contact us"));
    ContactUsLinkElement.isDisplayed();
    Assert.assertTrue(ContactUsLinkElement.isDisplayed());



    WebElement ContinueButton =  driver.findElement(xpath("//a[text()= 'Continue']"));
    ContinueButton.click();

    WebElement NewsLetterLink = driver.findElement(linkText("Subscribe / unsubscribe to newsletter"));
    NewsLetterLink.click();

    WebElement NewsLetterYesButton = driver.findElement(xpath("//input[@value=\"1\"]"));
    Assert.assertTrue(NewsLetterYesButton.isSelected());


    }

    @Test
    public void RegisterAccountWithNoOptionInNewsLetter(){


        WebElement FirstName = driver.findElement(id("input-firstname"));
        FirstName.sendKeys("Shlok");

        WebElement LastName = driver.findElement(id("input-lastname"));
        LastName.sendKeys("Shukla");

        Date date = new Date();
        String Email = date.toString().replace(" ", "_").replace(":","_")+"@gmail.com";

        WebElement EmailTextField = driver.findElement(xpath("//input[@id='input-email']"));
        EmailTextField.sendKeys(Email);

        WebElement Telephone = driver.findElement(id("input-telephone"));
        Telephone.sendKeys("7043614219");

        WebElement Password = driver.findElement(id("input-password"));
        Password.sendKeys("Jordan@97");

        WebElement ConfirmPassword = driver.findElement(id("input-confirm"));
        ConfirmPassword.sendKeys("Jordan@97");

        WebElement NewsLetterNoField = driver.findElement(xpath("//input[@value=\"0\"]"));
        NewsLetterNoField.click();

        WebElement Checkbox = driver.findElement(name("agree"));
        Checkbox.click();

        WebElement ClickOnContinue = driver.findElement(xpath("//input[@value=\"Continue\"]"));
        ClickOnContinue.click();

        MyAccountDropMenu = driver.findElement(xpath("//span[text()='My Account']"));
        MyAccountDropMenu.click();

        WebElement LogoutOption = driver.findElement(linkText("Logout"));
        Assert.assertTrue(LogoutOption.isDisplayed());

        String actualURL=driver.getCurrentUrl();
        String expectedURL= "https://tutorialsninja.com/demo/index.php?route=account/success";
        Assert.assertEquals(actualURL,expectedURL);

        String ExpectedText = "Your Account Has Been Created!";
        WebElement HeadingElement = driver.findElement(xpath("//div[@id='content']/h1"));
        String ActualHeadingText = HeadingElement.getText();
        Assert.assertEquals(ActualHeadingText , ExpectedText);

        WebElement actualCongratulationElement = driver.findElement(xpath("//div[@id='content']/h1/following-sibling::p"));
        String actualCongratulationText= actualCongratulationElement.getText();
        String expectedCongratulationText = "Congratulations! Your new account has been successfully created!";
        Assert.assertTrue(expectedCongratulationText.contains(actualCongratulationText) );

        WebElement ActualMemberPrivilegesElement = driver.findElement(xpath("//div[@id='content']/h1/following-sibling::p[2]"));
        String actualMemberPrivilegeText = ActualMemberPrivilegesElement.getText() ;
        String ExpectedMemberPrivilegeText = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
        Assert.assertTrue(ExpectedMemberPrivilegeText.contains(actualMemberPrivilegeText));

        WebElement ActualAnyQuestionElement = driver.findElement(xpath("//div[@id='content']/h1/following-sibling::p[3]"));
        String ActualAnyQuestionText = ActualAnyQuestionElement.getText();
        String ExpectedAnyQuestionText = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
        Assert.assertTrue(ExpectedAnyQuestionText.contains(ActualAnyQuestionText));

        WebElement ActualConfirmationMailElement = driver.findElement(xpath("//div[@id='content']/h1/following-sibling::p[4]"));
        String ActualConfirmationMailText = ActualConfirmationMailElement.getText();
        String ExpectedConfirmationMailText = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";
        Assert.assertTrue(ExpectedConfirmationMailText.contains(ActualConfirmationMailText));

        WebElement ContactUsLinkElement = driver.findElement(linkText("contact us"));
        ContactUsLinkElement.isDisplayed();
        Assert.assertTrue(ContactUsLinkElement.isDisplayed());

        WebElement ContinueButton =  driver.findElement(xpath("//a[text()= 'Continue']"));
        ContinueButton.click();

        WebElement NewsLetterLink = driver.findElement(linkText("Subscribe / unsubscribe to newsletter"));
        NewsLetterLink.click();

        WebElement NewsLetterNoButton = driver.findElement(xpath("//input[@value=\"0\"]"));
        Assert.assertTrue(NewsLetterNoButton.isSelected());



    }

    @Test
    public void VerifyDifferentWayToRegister(){


        MyAccountDropMenu = driver.findElement(xpath("//span[text()='My Account']"));
        MyAccountDropMenu.click();

        WebElement logInButton = driver.findElement(xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
        logInButton.click();

        WebElement NewCustomerContinueButton = driver.findElement(xpath("//a[@Class='btn btn-primary']"));
        NewCustomerContinueButton.click();

        MyAccountDropMenu = driver.findElement(xpath("//span[text()='My Account']"));
        MyAccountDropMenu.click();

        logInButton = driver.findElement(xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
        logInButton.click();

        WebElement RightColumnRegister = driver.findElement(xpath("//*[@id=\"column-right\"]/div/a[2]"));
        RightColumnRegister.click();

    }

    @Test
    public void RegisterWithDifferentPasswordAndConfirmPassword(){


        WebElement FirstName = driver.findElement(id("input-firstname"));
        FirstName.sendKeys("Shlok");

        WebElement LastName = driver.findElement(id("input-lastname"));
        LastName.sendKeys("Shukla");


        Date date = new Date();
        String Email = date.toString().replace(" ", "_").replace(":","_")+ "@gmail.com";

        WebElement EmailField = driver.findElement(id("input-email"));
        EmailField.sendKeys(Email);

        WebElement Telephone = driver.findElement(id("input-telephone"));
        Telephone.sendKeys("7043614219");

        WebElement Password = driver.findElement(id("input-password"));
        Password.sendKeys("12345");

        WebElement ConfirmPassword = driver.findElement(id("input-confirm"));
        ConfirmPassword.sendKeys("Abcde");

        WebElement Checkbox = driver.findElement(name("agree"));
        Checkbox.click();

        WebElement ClickOnContinue = driver.findElement(xpath("//input[@value=\"Continue\"]"));
        ClickOnContinue.click();

        WebElement PassWordNotMatchElement = driver.findElement(xpath("//div[@Class='text-danger']"));
        String ExpectedText = "Password confirmation does not match password!";
        String ActualText = PassWordNotMatchElement.getText();
        Assert.assertEquals(ActualText, ExpectedText);



    }

    @Test
    public void RegisterAccountWithExistingEmailId(){

        WebElement FirstName = driver.findElement(id("input-firstname"));
        FirstName.sendKeys("Shlok");

        WebElement LastName = driver.findElement(id("input-lastname"));
        LastName.sendKeys("Shukla");

        WebElement EmailField = driver.findElement(id("input-email"));
        EmailField.sendKeys("shlok.7776@gmail.com");

        WebElement Telephone = driver.findElement(id("input-telephone"));
        Telephone.sendKeys("7043614219");

        WebElement Password = driver.findElement(id("input-password"));
        Password.sendKeys("Jordan@97");

        WebElement ConfirmPassword = driver.findElement(id("input-confirm"));
        ConfirmPassword.sendKeys("Jordan@97");

        WebElement Checkbox = driver.findElement(name("agree"));
        Checkbox.click();

        WebElement ClickOnContinue = driver.findElement(xpath("//input[@value=\"Continue\"]"));
        ClickOnContinue.click();

        WebElement ExistingEmailWarningElement = driver.findElement(xpath("//div[@Class='alert alert-danger alert-dismissible']"));
        String actualExistingWarningText = ExistingEmailWarningElement.getText();
        String ExpectedExistingWarningTExt ="Warning: E-Mail Address is already registered!";
        Assert.assertEquals(actualExistingWarningText,ExpectedExistingWarningTExt);





    }

    @Test(dataProvider = "InvalidEmailSupplier")
    public void RegisterAccountWithInvalidEmailAddress(String invalidEmail) {

        WebElement FirstName = driver.findElement(id("input-firstname"));
        FirstName.sendKeys("Shlok");

        WebElement LastName = driver.findElement(id("input-lastname"));
        LastName.sendKeys("Shukla");

        WebElement EmailField = driver.findElement(id("input-email"));
        EmailField.sendKeys(invalidEmail);

        WebElement Telephone = driver.findElement(id("input-telephone"));
        Telephone.sendKeys("7043614219");

        WebElement Password = driver.findElement(id("input-password"));
        Password.sendKeys("Jordan@97");

        WebElement ConfirmPassword = driver.findElement(id("input-confirm"));
        ConfirmPassword.sendKeys("Jordan@97");

        WebElement Checkbox = driver.findElement(name("agree"));
        Checkbox.click();

        WebElement ClickOnContinue = driver.findElement(xpath("//input[@value=\"Continue\"]"));
        ClickOnContinue.click();

        String ExpectedURL =  "https://tutorialsninja.com/demo/index.php?route=account/register";
        String ActualUrl = driver.getCurrentUrl();
        Assert.assertEquals(ActualUrl,ExpectedURL);




    }
    @DataProvider( name ="InvalidEmailSupplier")
    public String [] supplyInvalidEmailData(){
        String [] invalidEmail = {"shlokshukla","shlokshukla@","Shlokshukla@gmail","shlokshukla@gmail."};
        return invalidEmail;


    }


    @Test (dataProvider = "Invalid TelePhone number Supplier"  )
    public void RegisterAccountWithInvalidPhoneNumber(String TelephoneNumber) throws InterruptedException {

        WebElement FirstName = driver.findElement(id("input-firstname"));
        FirstName.sendKeys("Shlok");

        WebElement LastName = driver.findElement(id("input-lastname"));
        LastName.sendKeys("Shukla");

        Date date = new Date();
        String Email = date.toString().replace(" ", "_").replace(":","_")+ "@gmail.com";

        WebElement EmailField = driver.findElement(id("input-email"));
        EmailField.sendKeys(Email);

        WebElement Telephone = driver.findElement(id("input-telephone"));
        Telephone.sendKeys(TelephoneNumber);

        WebElement Password = driver.findElement(id("input-password"));
        Password.sendKeys("Jordan@97");

        WebElement ConfirmPassword = driver.findElement(id("input-confirm"));
        ConfirmPassword.sendKeys("Jordan@97");

        WebElement NewsLetterYesField = driver.findElement(xpath("//input[@name='newsletter'][@value=\"1\"]"));
        NewsLetterYesField.click();

        WebElement Checkbox = driver.findElement(name("agree"));
        Checkbox.click();

        WebElement ClickOnContinue = driver.findElement(xpath("//input[@value=\"Continue\"]"));
        ClickOnContinue.click();

        String ActualWarningMessage = driver.findElement(By.xpath("//*[@id=\"account\"]/div[5]/div/div")).getText();
        String ExpectedWarningMessage = "Invalid Telephone Number ";
        Assert.assertEquals(ExpectedWarningMessage, ActualWarningMessage );

        String ExpectedURL = "https://tutorialsninja.com/demo/index.php?route=account/register";
        String actualUR = driver.getCurrentUrl();
        Assert.assertEquals(ExpectedURL , actualUR);


    }
    @DataProvider(name = "Invalid TelePhone number Supplier")
    public String[] issueInvalidTelePhoneNumber(){
        String[]  invalidTelePhone = {"123","abcde"};
        return invalidTelePhone;

    }

@Test
    public void RegisterUsingKeyboardKeys(){
        Actions actions = new Actions(driver);
        for (int i=0 ; i<23 ;i++) {
            actions.sendKeys(Keys.TAB).perform();
        }

        Date  date = new Date();
        String timeStamp = date.toString().replace(" ","_").replace(":","-");

       actions.sendKeys("Shlok")
               .pause(Duration.ofSeconds(2))
               .sendKeys(Keys.TAB)
               .pause(Duration.ofSeconds(2));
    actions.sendKeys("Shukla")
            .pause(Duration.ofSeconds(2))
            .sendKeys(Keys.TAB)
            .pause(Duration.ofSeconds(2));
    actions.sendKeys(timeStamp+"@gmail.com")
            .pause(Duration.ofSeconds(2))
            .sendKeys(Keys.TAB)
            .pause(Duration.ofSeconds(2));
    actions.sendKeys("7043614219")
            .pause(Duration.ofSeconds(2))
            .sendKeys(Keys.TAB)
            .pause(Duration.ofSeconds(2));
    actions.sendKeys("12345")
            .pause(Duration.ofSeconds(2))
            .sendKeys(Keys.TAB)
            .pause(Duration.ofSeconds(2));
    actions.sendKeys("12345")
            .pause(Duration.ofSeconds(2));
    actions.sendKeys(Keys.TAB)
            .pause(Duration.ofSeconds(2))
            .sendKeys(Keys.ARROW_LEFT)
            .pause(Duration.ofSeconds(2))
            .sendKeys(Keys.TAB)
            .pause(Duration.ofSeconds(2))
            .sendKeys(Keys.TAB)
            .pause(Duration.ofSeconds(2))
            .sendKeys(Keys.SPACE)
            .pause(Duration.ofSeconds(2))
            .sendKeys(Keys.TAB)
            .pause(Duration.ofSeconds(2))
            .sendKeys(Keys.ENTER).build().perform();
    String Actualurl = "https://tutorialsninja.com/demo/index.php?route=account/success";
    String ExpectedUrl = driver.getCurrentUrl();
    Assert.assertEquals(Actualurl,ExpectedUrl);








}

@Test
    public void CheckForPlaceHolderInAllFields(){
        WebElement FirstNameElement = driver.findElement(By.xpath("//*[@id=\"input-firstname\"]"));
        String ActualFirstName = FirstNameElement.getAttribute("placeholder");
        String  ExpectedFirstName ="First Name";
        Assert.assertEquals(ActualFirstName,ExpectedFirstName);

        WebElement LastNameElement = driver.findElement(By.xpath("//*[@id=\"input-lastname\"]"));
        String ActualLastName = LastNameElement.getAttribute("placeholder");
        String  ExpectedLastName ="Last Name";
        Assert.assertEquals(ActualLastName,ExpectedLastName);

        WebElement EmailElement = driver.findElement(By.xpath("//*[@id=\"input-email\"]"));
        String ActualEmail= EmailElement.getAttribute("placeholder");
        String ExpectedEmail = "E-Mail";
        Assert.assertEquals(ActualEmail,ExpectedEmail);

        WebElement TelephoneElement = driver.findElement(By.xpath("//*[@id=\"input-telephone\"]"));
        String ActualTelephone = TelephoneElement.getAttribute("placeholder");
        String ExpectedTelephone = "Telephone";
        Assert.assertEquals(ActualTelephone,ExpectedTelephone);

        WebElement PasswordElement = driver.findElement(By.xpath("//*[@id=\"input-password\"]"));
        String ActualPassword = PasswordElement.getAttribute("placeholder");
        String ExpectedPassword = "Password";
        Assert.assertEquals(ActualPassword,ExpectedPassword);

        WebElement ConfirmPasswordElement = driver.findElement(By.xpath("//*[@id=\"input-confirm\"]"));
        String ActualConfirmPassword = ConfirmPasswordElement.getAttribute("placeholder");
        String ExpectedConfirmPassword = "Password Confirm";
        Assert.assertEquals(ActualConfirmPassword, ExpectedConfirmPassword);












}

@Test
    public void CheckAstridInRedColour(){

    WebElement FirstNameElement = driver.findElement(By.xpath("//*[@id=\"account\"]/div[2]/label"));
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    String actualFirstNameAsterickContent =
            (String) jse.executeScript("return window.getComputedStyle(arguments[0],'::before')" + ".getPropertyValue('content');",FirstNameElement);
    Assert.assertTrue(actualFirstNameAsterickContent.contains("*"));
    String actualFirstNameAsterickColor =
            (String) jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');",FirstNameElement);
    Assert.assertEquals(actualFirstNameAsterickColor,"rgb(255, 0, 0)");


    WebElement lastNameLabel = driver.findElement(By.xpath("//label[@for='input-lastname']"));
    String actualLastNameAsterickContent =
            (String) jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');",lastNameLabel);
    Assert.assertTrue(actualLastNameAsterickContent.contains("*"));
    String actualLastNameAsterickColor =
            (String) jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');",lastNameLabel);
    Assert.assertEquals(actualLastNameAsterickColor,"rgb(255, 0, 0)");


    WebElement emailLabel = driver.findElement(By.xpath("//label[@for='input-email']"));
    String actualEmailAsterickContent =
            (String) jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');",emailLabel);
    Assert.assertTrue(actualEmailAsterickContent.contains("*"));
    String actualEmailAsterickColor =
            (String) jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');",emailLabel);
    Assert.assertEquals(actualEmailAsterickColor,"rgb(255, 0, 0)");


    WebElement telephoneLabel = driver.findElement(By.xpath("//label[@for='input-telephone']"));
    String actualTelephoneAsterickContent =
            (String) jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');",telephoneLabel);
    Assert.assertTrue(actualTelephoneAsterickContent.contains("*"));
    String actualTelephoneAsterickColor =
            (String) jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');",telephoneLabel);
    Assert.assertEquals(actualTelephoneAsterickColor,"rgb(255, 0, 0)");


    WebElement passwordLabel = driver.findElement(By.xpath("//label[@for='input-password']"));
    String actualPasswordAsterickContent =
            (String) jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');",passwordLabel);
    Assert.assertTrue(actualPasswordAsterickContent.contains("*"));
    String actualPasswordAsterickColor =
            (String) jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');",passwordLabel);
    Assert.assertEquals(actualPasswordAsterickColor,"rgb(255, 0, 0)");


    WebElement passwordConfirmLabel = driver.findElement(By.xpath("//label[@for='input-confirm']"));
    String actualPasswordConfirmAsterickContent =
            (String) jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');",passwordConfirmLabel);
    Assert.assertTrue(actualPasswordConfirmAsterickContent.contains("*"));
    String actualPasswordConfirmAsterickColor =
            (String) jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');",passwordConfirmLabel);
    Assert.assertEquals(actualPasswordConfirmAsterickColor,"rgb(255, 0, 0)");


    WebElement privacyPolicyLabel = driver.findElement(By.xpath("//div[@class='pull-right']"));
    String privacyPolicyAsterickContent =
            (String) jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');",privacyPolicyLabel);
    Assert.assertTrue(privacyPolicyAsterickContent.contains("*"));
    String privacyPolicyAsterickColor =
            (String) jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');",privacyPolicyLabel);
    Assert.assertEquals(privacyPolicyAsterickColor,"rgb(255, 0, 0)");



    }



    }





