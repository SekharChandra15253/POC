package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class steps
{
    WebDriver driver;
    @Given("^User is on HomePage$")
    public void user_is_on_HomePage() throws Throwable {
        System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"Amazon.com. Spend less. Smile more.");

    }

    @When("^User Enters a required product in main search$")
    public void user_Enters_a_required_product_in_main_search() throws Throwable {
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

    }

    @Then("^user selects a product and click on AddToCart$")
    public void user_selects_a_product_and_click_on_AddToCart() throws Throwable {
        List<WebElement> mobiles = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement mobile : mobiles)
        {
            System.out.println(mobile.getText());
            if (mobile.getText().equals("OnePlus Nord N20 5G |Android Smart Phone |6.43\" AMOLED Display|6+128GB |U.S. Unlocked |4500 mAh Battery | 33W Fast Charging | Blue Smoke"))
            {

                //String clicklnk = Keys.chord(Keys.CONTROL,Keys.ENTER);
                // mobile.sendKeys(clicklnk);
                mobile.click();
                break;
            }
        }
        Thread.sleep(10000);
        WebElement addToCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
        //WebDriverWait wait = new WebDriverWait(driver,10);
        //wait.until(ExpectedConditions.visibilityOf(addToCart));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addToCart);
    }

    @Then("^Verify Product is added to the cart$")
    public void verify_Product_is_added_to_the_cart() throws Throwable {
        driver.findElement(By.xpath("//div[@id='nav-cart-count-container']")).click();
        Thread.sleep(3000);
        WebElement mble = driver.findElement(By.xpath("//div[@id='nav-cart-count-container']"));
        Assert.assertEquals("OnePlus Nord N20 5G |Android Smart Phone |6.43\" AMOLED Display|6+1…",mble);


        driver.quit();

    }
}
