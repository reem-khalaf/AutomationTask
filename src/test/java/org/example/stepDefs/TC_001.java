package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

import java.time.Duration;

import static org.example.stepDefs.Hooks.driver;

public class TC_001 {

    P01 ele = new P01();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    @Given("Choose English Language")
    public void ChooseLang(){ele.EnglishLang().click();}


    @And("Go to Shop By Brand section and select IphoneLogo")
    public void ChooseCategory() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-notfound-page/div/app-brand/div/div/div[1]/ul/li[7]/a")));
        ele.IphoneLogo().click();
    }

    @And("Select any of returned iphone mobiles")
    public void SelectIphoneIteam() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"home-0\"]/div/ul/li[5]/a/div/div[2]/a/img")));
        ele.IphoneIteam().click();
    }

    @When("Press add to cart")
    public void AddtoCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class=\"btn btn-red btn-block fontLightEnAr\"]")));
        ele.Cart().click();
    }

    @And("Press Proceed to Checkout")
    public void ItemCheckout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"cart_checkout fontLightEnAr\"]")));
        ele.Checkout().click();
    }

    @And("Select Delivery Options as {string} and {string}")
    public void SelectData(String city, String address){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"headingOne\"]/div[1]/select")));
        WebElement SelectCity = ele.City();
        Select x = new Select(SelectCity);
        x.selectByVisibleText(city);

        WebElement SelectAddress = ele.Area();
        Select y = new Select(SelectAddress);
        y.selectByVisibleText(address);

    }

    @And("Select Deliver to My Address")
    public void Deliver() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"checkout-DelivaryOptionsInfo checkout-DelivaryToAddress open firstOpen\"]")));
        ele.DeliverOrder().click();
    }

    @And("Add address details then press continue")
    public void Address(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form[id=\"checkout-deliveryAdd\"]")));
        ele.Street().sendKeys("Elshrouq");
        ele.Building().sendKeys("200");
        ele.Floor().sendKeys("1");
        ele.Appartment().sendKeys("10", Keys.RETURN);
    }

    @And("Leave Personal info Tab empty and Press continue")
    public void EmptyInfo() throws InterruptedException {
        Thread.sleep(3000);
        ele.PersonalInfoFullName().sendKeys("");
        ele.PersonalInfoEmail().sendKeys(" ");
        ele.PersonalInfoMobNum().sendKeys(" ");
        ele.ContinueButton().click();
    }

    @Then("Assert on error message returned from Full Name field")
    public void AssertionFullName() throws InterruptedException {
        Thread.sleep(3000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("//*[@id=\"collapseTwo\"]/form/div/div/div[1]/div[1]/app-alert/div/div/div/div[2]/div/div/div")));
        Assert.assertTrue(ele.AlertFullName().getText().contains("enter a valid name"));
    }



    }
