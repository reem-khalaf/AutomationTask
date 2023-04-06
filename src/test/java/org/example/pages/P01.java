package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.stepDefs.Hooks.driver;

public class P01 {

    public WebElement EnglishLang(){return driver.findElement(By.cssSelector("a[id=\"profile-tab\"]"));}

    public WebElement IphoneLogo(){return driver.findElement(By.xpath("/html/body/app-root/div/app-notfound-page/div/app-brand/div/div/div[1]/ul/li[7]/a"));}

   // public WebElement IphoneIteam(){return driver.findElement(By.xpath("//*[@id=\"home-0\"]/div/ul/li[8]/a/div/div[2]/a/img"));}
   public WebElement IphoneIteam(){return driver.findElement(By.xpath("//*[@id=\"home-0\"]/div/ul/li[5]/a/div/div[2]/a/img"));}

    public WebElement Cart(){return driver.findElement(By.cssSelector("button[class=\"btn btn-red btn-block fontLightEnAr\"]"));}

    public WebElement Checkout(){return driver.findElement(By.cssSelector("div[class=\"cart_checkout fontLightEnAr\"]"));}

    public WebElement City(){return driver.findElement(By.xpath("//*[@id=\"headingOne\"]/div[1]/select"));}

    public WebElement Area(){return driver.findElement(By.xpath("//*[@id=\"headingOne\"]/div[2]/select"));}

    public WebElement DeliverOrder(){return driver.findElement(By.cssSelector("div[class=\"checkout-DelivaryOptionsInfo checkout-DelivaryToAddress open firstOpen\"]"));}

    public WebElement Street(){return driver.findElement(By.cssSelector("input[formcontrolname=\"address1\"]"));}

    public WebElement Building(){return driver.findElement(By.cssSelector("input[formcontrolname=\"buildingNumber\"]"));}

    public WebElement Floor(){return driver.findElement(By.cssSelector("input[formcontrolname=\"floorNumber\"]"));}

    public WebElement Appartment(){return driver.findElement(By.cssSelector("input[formcontrolname=\"appartmentNumber\"]"));}

    public WebElement Continue(){return driver.findElement(By.cssSelector("div[class=\"checkout-addressBtn\"] button[type=\"submit\"]"));}

    public WebElement PersonalInfoFullName(){return driver.findElement(By.cssSelector("input[placeholder=\"Full Name\"]"));}

    public WebElement PersonalInfoEmail(){return driver.findElement(By.cssSelector("input[placeholder=\"Email\"]"));}

    public WebElement PersonalInfoMobNum(){return driver.findElement(By.cssSelector("input[placeholder=\"01012345678\"]"));}

    public WebElement ContinueButton(){return driver.findElement(By.cssSelector("button[class=\"btn checkout-btn btn-red checkoutDeliveryFamilyFont\"]"));}

    public WebElement AlertFullName(){return driver.findElement(By.xpath("//*[@id=\"collapseTwo\"]/form/div/div/div[1]/div[1]/app-alert/div/div/div/div[2]/div/div/div"));}



}
