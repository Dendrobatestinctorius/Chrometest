package CTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.*;

public class test {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium lib\\chromedriver.exe");
        WebDriver drv = new ChromeDriver();

        String burl = "http://Google.com";
        drv.get(burl);
        drv.manage().deleteCookieNamed ("CONSENT");
        drv.manage().addCookie(new Cookie("CONSENT","YES+shp.gws-"+LocalDate.now().toString().replace("-","")+"-0-RC2.en+FX+374"));
        drv.navigate().refresh();
        WebElement querry = drv.findElement(By.name("q"));
        querry.sendKeys("Hello World");
        querry.submit();
        //WebDriverWait cwait = new WebDriverWait(drv, Duration.ofSeconds(10L) );
        //cwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("consent")));
        //drv.quit();
    }
}
