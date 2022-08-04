import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class E2E
{
    public static void main(String[] args) throws InterruptedException, AWTException {
//test1
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
            System.out.println(mobile.getText());
            if (mobile.getText().equals("OnePlus Nord N20 5G |Android Smart Phone |6.43\" AMOLED Display|6+128GB |U.S. Unlocked |4500 mAh Battery | 33W Fast Charging | Blue Smoke"))
            {
                mobile.click();
                break;
            }
        }
        Thread.sleep(10000);
        WebElement addToCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addToCart);

        driver.findElement(By.xpath("//div[@id='nav-cart-count-container']")).click();
        Thread.sleep(3000);
        String mble = driver.findElement(By.xpath("//span[@class='a-truncate-cut']")).getText();
        Assert.assertEquals("OnePlus Nord N20 5G |Android Smart Phone |6.43\" AMOLED Display|6+1…",mble);

        driver.quit();
    }
}
