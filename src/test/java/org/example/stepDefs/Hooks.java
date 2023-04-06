package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class Hooks {

    public static WebDriver driver;
    public static Properties props = new Properties();

    public Hooks(){
        try {
            FileInputStream file = new FileInputStream(new File("src/test/java/org/example/propirities/config.propirities"));
            props.load(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Before
    public void OpenBrowser() throws InterruptedException {
        if(props.getProperty("browser").equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions co = new ChromeOptions();
            co.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(co);
        } else if (props.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver= new FirefoxDriver();
        }else {
            throw new Error("Browser not Supported");
        }
        driver.manage().window().maximize();
        driver.get(props.getProperty("url"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Thread.sleep(1000);
    }


    @After
    public static void quitDriver() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Thread.sleep(3000);
        driver.quit();
    }
}
