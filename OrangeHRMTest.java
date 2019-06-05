import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

//Write a Test Class which will extend Base Class 
public class LoginPageTest extends IntegrationTest {

//Launch the firefox browser and open the url
@Before
public void setup() {
    WebDriver driver = new FirefoxDriver();
    driver.get("https://opensource-demo.orangehrmlive.com/");
}

//Test 1: Check if the user is able to enter the Orange HRM system with a successful ESS-User account.
@Test
public void testLogin(){
    //Enter the user Id
    driver.findElement(By.id("divUsername")).sendKeys("Admin");
    //Enter the password
    driver.findElement(By.id("divPassword")).sendKeys("admin123");
    //Click on Login button
    driver.findElement(By.id("divLoginButton")).click();
   
    //Verify the user has logged in successfully by verifying the url 
    assertTrue(driver.getCurrentUrl().endsWith("orangehrmlive.com"));
 }
 
//Test 2: Check if the user is able to see the “General Information” in "organization" tab under "admin" Tab on logging in the first time
/* TestCase3: Check if the user is able to edit the fields other than the following and save changes in Contact details
 • Country 
 • Street 1
 • Street 2
 • City/Town
 • State/Province
 • ZIP Code
 • Telephone
 • Email
 
 */
@Test
public void testGeneralInformationsPageAndEditFields(){
   //Login as user - write a method to login in a separate utility class and use the function here else use the method above
   
       //Go to Admin tab
       WebElement element = driver.findElement(By.linkText("Admin"));
 
        Actions action = new Actions(driver);
 
        action.moveToElement(element).build().perform();
        
        //Go to Organizations tab
        driver.findElement(By.linkText("Organizations"));
 
        //Go to General Informations
        assertTrue(driver.findElement(By.linkText("General Informations")));
        
        //Verify the "General Informations" link is shown to the user
        Assert.assertTrue(driver.findElement(By.linkText("General Informations")).isDisplayed(), "General Informations link is not shown");
        
        //Click On "General Informations" link.
        driver.findElement(By.linkText("General Informations")).click();
        
        //Click On Edit Button in  General Informations page"
        driver.findElement(By.id("btnSaveGenInfo")).click();
        
        //Click on fields to edit the info : Tax ID, Phone Number, Email id etc
        
        //Edit Tax ID
        driver.findElement(By.id("organization_taxId")).sendKeys("45678");
        
        //Phone Number
        driver.findElement(By.id("btnSaveGenInfo")).sendKeys("9437011");
        
        //Email
        driver.findElement(By.id("btnSaveGenInfo")).sendKeys("abc@hrm.com");
        //edit other fields as well
        
        //Click on Save
        
        driver.findElement(By.id("btnSaveGenInfo")).click();
        
        //Assert the saved info.
         Assert.assertEquals(driver.findElement(By.id("organization_taxId")).getText(), "45678", "Tax ID is not updated);
        
        //Assert all other fields too
 }
 
}
