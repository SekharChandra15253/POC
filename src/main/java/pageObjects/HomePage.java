package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage
{
    WebDriver driver;

    @FindBy(xpath = "//span[@class='a-button a-spacing-top-base a-button-base glow-toaster-button glow-toaster-button-dismiss']" )
    private WebElement ele;

    @FindBy(xpath = "nav-search-bar-form" )
    private WebElement searchBar;

    @FindBy(xpath = "twotabsearchtextbox" )
    private WebElement searchBarTextBox;

    @FindBy(xpath = "//div[@class='s-suggestion-container']//div" )
    private List<WebElement> products;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void messageDismiss()
    {
        ele.click();

        if (ele.isDisplayed())
        {
            ele.click();
        }
    }

    public void clickSearchBar()
    {
        searchBar.click();
    }

    public void EnterTextSearchBox()
    {
        searchBarTextBox.sendKeys("Oneplus");
    }

    public void selectProduct() throws InterruptedException {
        for (WebElement elem : products)
        {
            if (elem.getText().equals("oneplus"))
            {
                Thread.sleep(3000);
                elem.click();
                break;
            }
        }
    }


}
