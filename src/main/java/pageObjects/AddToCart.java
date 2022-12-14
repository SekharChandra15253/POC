package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;

import java.util.List;

public class AddToCart
{

    WebDriver driver;

    @FindBy(xpath = "//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']//span" )
    private List<WebElement> mobiles;

    @FindBy(xpath = "//input[@id='add-to-cart-button']" )
    private WebElement addToCart;

    @FindBy(xpath = "//div[@id='nav-cart-count-container']" )
    private WebElement VerifyaddToCart;

    @FindBy(xpath = "//span[@class='a-truncate-cut']")
    private WebElement ProductText;

    public AddToCart(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void selectMobile() {
        for (WebElement mobile : mobiles) {
            System.out.println(mobile.getText());
            if (mobile.getText().equals("OnePlus Nord N20 5G |Android Smart Phone |6.43\" AMOLED Display|6+128GB |U.S. Unlocked |4500 mAh Battery | 33W Fast Charging | Blue Smoke")) {
                mobile.click();
                break;
            }
        }
    }

    public void clickAddToCart()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addToCart);
    }

    public void verifyAddToCart()
    {
        VerifyaddToCart.click();
        String txt = ProductText.getText();
        //Assert.assertEquals("OnePlus Nord N20 5G |Android Smart Phone |6.43\" AMOLED Display|6+1…",txt);
        Assert.assertSame("OnePlus Nord N20 5G |Android Smart Phone |6.43\" AMOLED Display|6+1…",txt);

    }



}
