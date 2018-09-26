package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjudaPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/ul[6]/li/a")
    WebElement itemRakeTest;

    public AjudaPage(WebDriver driver) {
        super(driver);
        driver.get("https://www.redmine.org/my/account");
    }

    public AjudaPage buttonRakeTest() {
        this.itemRakeTest.click();
        return this;
    }

    public HomePage esperarHomeCarregar() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until( (ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.xpath("//*[@id=\"flash_notice\"]")) != null);
        return new HomePage(driver);
    }
}
