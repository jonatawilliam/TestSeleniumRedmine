package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjetoPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/a[1]")
    WebElement botaoNovoProjeto;

    @FindBy(xpath = "//*[@id=\"project_name\"]")
    WebElement nomeProjeto;

    @FindBy(xpath = "//*[@id=\"new_project\"]/input[3]")
    WebElement botaoSalvar;

    @FindBy(xpath = "//*[@id=\"flash_notice\"]")
    WebElement confirmacaoSalvar;

    public ProjetoPage(WebDriver driver) {
        super(driver);
        driver.get("https://www.redmine.org/my/account");
    }

    public ProjetoPage buttonNovoProjeto() {
        this.botaoNovoProjeto.click();
        return this;
    }

    public ProjetoPage setNomeProjeto(String nome) {
        this.nomeProjeto.sendKeys(nome);
        return this;
    }

    public ProjetoPage buttonSalvar() {
        this.botaoSalvar.click();
        return this;
    }

    public ProjetoPage getConfirmacaoSalvar() {
        this.confirmacaoSalvar.getText();
        return this;
    }

    public HomePage esperarHomeCarregar() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until( (ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.xpath("//*[@id=\"flash_notice\"]")) != null);
        return new HomePage(driver);
    }
}
