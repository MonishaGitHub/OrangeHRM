import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

//Write a Test Class which will extend Base Class 
public class EmpployeeDistributionTest extends IntegrationTest {

@Test
public void testGeneralInformationsPageAndFields(){
   //Login as user - use page object class method to login
   
       //Go to Dashboard tab
       WebElement element = driver.findElement(By.linkText("Dashboard"));
 
        Actions action = new Actions(driver);
 
        action.moveToElement(element).build().perform();
        
        //Go to Organizations tab
        element.click();
 
       //Mouse over the employee distribution map
        
        WebElement element = driver.findElement(By.id("div_graph_display_emp_distribution"));
        Actions action = new Actions(driver);
 
        action.moveToElement(element).build().perform();
        
        
 }


}
