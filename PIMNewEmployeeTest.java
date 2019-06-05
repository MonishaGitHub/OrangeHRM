import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

//Write a Test Class which will extend Base Class 
public class PIMNewEmployeeTest extends IntegrationTest {

//Launch the firefox browser and open the url
@Before
public void setup() {
    WebDriver driver = new FirefoxDriver();
    driver.get("https://opensource-demo.orangehrmlive.com/");
    driver.findElement(By.id("divUsername")).sendKeys("Admin");
    //Enter the password
    driver.findElement(By.id("divPassword")).sendKeys("admin123");
    //Click on Login button
    driver.findElement(By.id("divLoginButton")).click();
}

//Test 4 : Add new Employee under PIM, Employee list
//Test 5 : Check if user can upload a picture
@Test
public void testAddNewEmployee(){
   //Login as user - 
   
       //Go to PIM tab
        WebElement element = driver.findElement(By.linkText("PIM"));
 
        Actions action = new Actions(driver);
 
        action.moveToElement(element).build().perform();
        
        //Go to Employee List tab
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
        
        //Enter all the user info
        //Enter first name, last name
        //Do required mandatory field verification
        
        
        //Upload Picture
        driver.findElement(By.id("photofile")).click();
        
        //Click Save
        driver.findElement(By.id("btnSave")).click();
 
              
        //Assert the saved info.
         Assert.assertEquals(driver.findElement(By.id("firstName")).getText(), "user name", "First name is not matching);
        
        //Do other verification
        
 }


}
