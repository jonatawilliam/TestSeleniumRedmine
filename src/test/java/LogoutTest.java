import po.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class LogoutTest {

    private static int imageId = 0;

    WebDriver driver;

    @BeforeClass
    public static void beforeClass() { WebDriverManager.chromedriver().setup(); }

    @Before
    public void before() { driver = Setup.setup(); }

    @After
    public void after() { driver.close(); }

    @Test
    public void testLogout() {
        LoginPage loginPage = new LoginPage(driver);
        Menu menu = new Menu(driver);

        loginPage.setUsuario("utfpr");
        loginPage.setSenha("Utfpr@2018");
        loginPage.submit();

        takeScreenShot();

        HomePage homePage = loginPage.esperarHomeCarregar();

        takeScreenShot();

        assertEquals(homePage.getUrl(), "http://demo.redmine.org/my/page");

        menu.buttonItemLogout();

        HomePage homePage2 = menu.esperarHomeCarregar();

        takeScreenShot();

        assertEquals(homePage2.getUrl(), "http://demo.redmine.org/");
    }

    private void takeScreenShot() {
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            imageId++;
            FileUtils.copyFile(sourceFile, new File("./res/" + imageId + ".png"));
        } catch (IOException e) {
        }
    }
}
