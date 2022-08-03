import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class E2E
{
    public static void main(String[] args) throws InterruptedException, AWTException {

        System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"Amazon.com. Spend less. Smile more.");

        WebElement ele = driver.findElement(By.xpath("//span[@class='a-button a-spacing-top-base a-button-base glow-toaster-button glow-toaster-button-dismiss']"));

        if (ele.isDisplayed())
        {
            ele.click();
        }
        driver.findElement(By.id("nav-search-bar-form")).click();
        Thread.sleep(1000);
       // JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//set the text
       // jsExecutor.executeScript("document.getElementById('twotabsearchtextbox').value='testuser'");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Oneplus");
        Thread.sleep(3000);
        List<WebElement> eles = driver.findElements(By.xpath("//div[@class='s-suggestion-container']//div"));
        for (WebElement elem : eles)
        {
           if (elem.getText().equals("oneplus"))
           {
               Thread.sleep(3000);
               elem.click();
               break;
           }
        }

        List<WebElement> mobiles = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement mobile : mobiles)
        {
            if (mobile.getText().equals("OnePlus 9 Pro Pine Green | 5G Unlocked Android Smartphone | 120Hz Fluid Display | Hasselblad Quad Camera | 65W Ultra Fast Charge | 50W Wireless Charge | U.S Version |12GB RAM+256GB | Alexa Built-in"))
            {
                Robot r = new Robot();
                r.keyPress(KeyEvent.VK_CONTROL);
                r.keyRelease(KeyEvent.VK_CONTROL);
                r.keyPress(KeyEvent.VK_ENTER);
                r.keyRelease(KeyEvent.VK_ENTER);
               // mobile.sendKeys(Keys.CONTROL);
                //mobile.sendKeys(Keys.ENTER);
               // mobile.click();
                break;
            }
        }

        //driver.quit();
    }
}
