package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class GeneralInfoPage {
    WebDriver driver;
    By userName = By.id("divUsername");

    By password = By.id("divUsername");

    By titleText =By.className("barone");

    By loginButton = By.id("divLoginButton");
    
    //Put other locators also in this page class

    public Login(WebDriver driver){

        this.driver = driver;

    }

    //Set user name in textbox

    public void setUserName(String strUserName){

        driver.findElement(userName).sendKeys(strUserName);

    }

    //Set password in password textbox

    public void setPassword(String strPassword){

         driver.findElement(password).sendKeys(strPassword);

    }

    //Click on login button

    public void clickLogin(){

            driver.findElement(login).click();

    }

    //Get the title of Login Page

    public String getLoginTitle(){

     return    driver.findElement(titleText).getText();

    }

    /**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     * @return

     */

    public void loginToOrangeHRM(String strUserName,String strPasword){

        //Fill user name

        this.setUserName(strUserName);

        //Fill password

        this.setPassword(strPasword);

        //Click Login button

        this.clickLogin();        
    }

}
