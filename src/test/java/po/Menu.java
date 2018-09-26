package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Menu extends BasePage {
    @FindBy(className = "home")
    WebElement itemMinhaConta;

    @FindBy(className = "my-account")
    WebElement itemPaginaInicial;

    @FindBy(className = "user active")
    WebElement itemUsuario;

    @FindBy(className = "my-page")
    WebElement itemMinhaPagina;

    @FindBy(className = "projects")
    WebElement itemMeusProjetos;

    @FindBy(className = "help")
    WebElement itemAjuda;

    @FindBy(className = "logout")
    WebElement itemLogout;

    public Menu(WebDriver driver) {
        super(driver);
    }

    public Menu buttonItemPaginaInicial() {
        this.itemPaginaInicial.click();
        return this;
    }

    public Menu buttonItemUsuario() {
        this.itemUsuario.click();
        return this;
    }

    public Menu buttonItemMinhaPagina() {
        this.itemMinhaPagina.click();
        return this;
    }

    public Menu buttonItemMinhaConta() {
        this.itemMinhaConta.click();
        return this;
    }

    public Menu buttonItemAjuda() {
        this.itemAjuda.click();
        return this;
    }

    public Menu buttonItemMeusProjetos() {
        this.itemMeusProjetos.click();
        return this;
    }

    public Menu buttonItemLogout() {
        this.itemLogout.click();
        return this;
    }

    public HomePage esperarHomeCarregar() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until( (ExpectedCondition<Boolean>) (WebDriver d) -> d.getCurrentUrl().equals("http://demo.redmine.org/"));
        return new HomePage(driver);
    }

}
