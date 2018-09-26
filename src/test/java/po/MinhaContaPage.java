package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MinhaContaPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"user_lastname\"]")
    WebElement sobreNome;

    @FindBy(xpath = "//*[@id=\"my_account_form\"]/div[1]/input")
    WebElement salvar;

    @FindBy(xpath = "//*[@id=\"flash_notice\"]")
    WebElement confirmacaoSalvar;

    public MinhaContaPage(WebDriver driver) {
        super(driver);
        driver.get("https://www.redmine.org/my/account");
    }

    public MinhaContaPage setSobreNome(String nome) {
        this.sobreNome.sendKeys(nome);
        return this;
    }

    public MinhaContaPage buttonSalvar() {
        this.salvar.click();
        return this;
    }

    public MinhaContaPage getNotificacaoSalvar() {
        this.confirmacaoSalvar.getTagName();
        return this;
    }

    public HomePage esperarHomeCarregar() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until( (ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.className("my-account")) != null);
        return new HomePage(driver);
    }
}
