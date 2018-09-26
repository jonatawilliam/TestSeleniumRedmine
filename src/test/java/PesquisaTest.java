import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import po.*;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class PesquisaTest {
    private static int imageId = 0;

    WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void before() {
        driver = Setup.setup();
    }

    @After
    public void after() {
        driver.close();
    }

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        Menu menu = new Menu(driver);

        loginPage.setUsuario("utfpr_test");
        loginPage.setSenha("Utfpr@2018");
        loginPage.submit();

        takeScreenShot();

        HomePage homePage = loginPage.esperarHomeCarregar();

        takeScreenShot();

        assertEquals(homePage.getUrl(), "https://www.redmine.org/my/page");

        menu.buttonItemPaginaInicial();

        searchPage.setPesquisa("test");
        takeScreenShot();

        searchPage.selecionarItemPesquisa();
        takeScreenShot();

//        assertEquals(, "http://demo.redmine.org/my/page");





    }

    private void takeScreenShot() {
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            imageId++;
            FileUtils.copyFile(sourceFile, new File("./res/" + imageId + ".png"));
        } catch(IOException e) {}
    }
}
