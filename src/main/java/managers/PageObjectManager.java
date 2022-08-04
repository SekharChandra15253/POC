package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.AddToCart;
import pageObjects.HomePage;

public class PageObjectManager
{
    private WebDriver driver;
    private HomePage homePage;
    private AddToCart addToCart;


    public PageObjectManager(WebDriver driver)
    {
        this.driver = driver;
    }

    public HomePage getHomePage()
    {
        return (homePage==null)?homePage = new HomePage(driver):homePage;
    }

    public AddToCart getAddToCartPage()
    {
        return (addToCart==null)?addToCart = new AddToCart(driver):addToCart;
    }
}
