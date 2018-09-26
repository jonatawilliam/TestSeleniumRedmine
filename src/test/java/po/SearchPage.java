package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"search-results\"]/dt[1]/a")
    WebElement resultado;

    @FindBy(xpath = "//*[@id=\"q\"]")
    WebElement search;

    public SearchPage(WebDriver driver) {
        super(driver);
        driver.get("https://www.redmine.org/login");
    }

    public SearchPage selecionarItemPesquisa() {
        this.resultado.click();
        return this;
    }

    public SearchPage setPesquisa(String texto) {
        this.search.sendKeys(texto);
        return this;
    }

    public HomePage esperarHomeCarregar() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until( (ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.className("my-account")) != null);
        return new HomePage(driver);
    }
}
