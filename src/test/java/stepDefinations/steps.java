package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;
import managers.PageObjectManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.AddToCart;
import pageObjects.HomePage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class steps
{
    WebDriver driver;
    PageObjectManager pageObjectManager;
    ConfigFileReader configFileReader;
    HomePage hp;
    AddToCart ac;
    @Given("^User is on HomePage$")
    public void user_is_on_HomePage() throws Throwable {
        configFileReader = new ConfigFileReader();
        System.setProperty("webdriver.chrome.driver",configFileReader.getDriverPath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitWait(), TimeUnit.SECONDS);
        driver.get(configFileReader.getAppURL());
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"Amazon.com. Spend less. Smile more.");

    }

    @When("^User Enters a required product in main search$")
    public void user_Enters_a_required_product_in_main_search() throws Throwable
    {

        pageObjectManager = new PageObjectManager(driver);
        hp = pageObjectManager.getHomePage();
        hp.messageDismiss();
        hp.clickSearchBar();
        Thread.sleep(1000);
        hp.EnterTextSearchBox();
        hp.selectProduct();

    }

    @Then("^user selects a product and click on AddToCart$")
    public void user_selects_a_product_and_click_on_AddToCart() throws Throwable {
        ac = pageObjectManager.getAddToCartPage();
        ac.selectMobile();
        Thread.sleep(10000);
        ac.clickAddToCart();
    }

    @Then("^Verify Product is added to the cart$")
    public void verify_Product_is_added_to_the_cart() throws Throwable {
        ac.verifyAddToCart();
        driver.quit();

    }
}
