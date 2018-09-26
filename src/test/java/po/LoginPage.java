package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"username\"]")
    WebElement usuario;

    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement senha;

    @FindBy(xpath = "//*[@id=\"login-form\"]/form/table/tbody/tr[4]/td[2]/input")
    WebElement submit;

    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get("http://demo.redmine.org/login");
    }

    public LoginPage setUsuario(String usuario) {
        this.usuario.sendKeys(usuario);
        return this;
    }

    public LoginPage setSenha(String senha) {
        this.senha.sendKeys(senha);
        return this;
    }

    public LoginPage submit() {
        this.submit.submit();
        return this;
    }

    public HomePage esperarHomeCarregar() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until( (ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.className("my-account")) != null);
        return new HomePage(driver);
    }
}
