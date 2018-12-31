import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class TestCases{
    private static WebDriver driver ;
    @BeforeMethod
    public void open_browser(){
        System.setProperty("webdriver.chrome.driver","src\\main\\java\\ChromeDriver\\chromedriver.exe");
       driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

    }
   // @AfterMethod
  //  public void close_browser(){
//driver.close();
  //  }

    @Test
    public void user_login_sucessfully() {

        // Click on regitser
        click_element(By.linkText("Register"));
        // click on female gender
        click_element(By.id("gender-female"));
        //click on first name box and type first name
        enterText(By.name("FirstName"), "ghghg");
        //click on last name box and type last name
        enterText(By.id("LastName"), "hhfdjh");
        //choose date of birth day
        click_element(By.xpath("//select[@name=\"DateOfBirthDay\"] / option[7]"));
        //choose date of birth month
        click_element(By.xpath("//select[@name=\"DateOfBirthMonth\"]/option[6]"));
        //choose date of birth year
        click_element(By.xpath("//select[@name=\"DateOfBirthYear\"]/option[6]"));
        DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHmmss");
        //made objet for date
        Date date = new Date();
        String date1 = dateFormat.format(date);
        //click on email box and type email id
        enterText(By.id("Email"), "nidhi_tondon" + date1 + "@yahoo.com");
        //click on company box and type company name
        enterText(By.id("Company"), "1234");
        //click on newsletter box
        click_element(By.id("Newsletter"));
        //click on password box and type password
        enterText(By.id("Password"), "vgy789");
        //click on confirm password box and type confirm password
        enterText(By.id("ConfirmPassword"), "vgy789");
        //click on register button
        click_element(By.id("register-button"));
        // expected registration sucessfull message confirmation displayed
        String expectedRegistrationSucessMessage = "Your registration completed";
        //actual sucessfull message confirmation displayed to be verified
        String actualRegistrationSucessMessage = driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
        //comparing actual and expected results
        Assert.assertEquals(expectedRegistrationSucessMessage, actualRegistrationSucessMessage, "test case fail");

    }


    @Test
   // click on continue button
     public void email_with_product_sucessfully(){
        // Click on regitser
        click_element(By.linkText("Register"));
        // click on female gender
        click_element(By.id("gender-female"));
        //click on first name box and type first name
        enterText(By.name("FirstName"), "ghghg");
        //click on last name box and type last name
        enterText(By.id("LastName"), "hhfdjh");
        //choose date of birth day
        click_element(By.xpath("//select[@name=\"DateOfBirthDay\"] / option[7]"));
        //choose date of birth month
        click_element(By.xpath("//select[@name=\"DateOfBirthMonth\"]/option[6]"));
        //choose date of birth year
        click_element(By.xpath("//select[@name=\"DateOfBirthYear\"]/option[6]"));
        DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHmmss");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        //click on email box and type email id
        enterText(By.id("Email"),"nidhi_tondon" + date1 + "@yahoo.com");
        //click on company box and type company name
        enterText(By.id("Company"), "1234");
        //click on newsletter box
        click_element(By.id("Newsletter"));
        //click on password box and type password
        enterText(By.id("Password"), "vgy789");
        //click on confirm password box and type confirm password
        enterText(By.id("ConfirmPassword"), "vgy789");
        //click on register button
        click_element(By.id("register-button"));
       //click on continue button
        click_element(By.name("register-continue"));
        //click on computers
        click_element(By.xpath("//div[@class=\"header-menu\"]/ul[@class=\"top-menu\"]//a[@href=\"/computers\"]"));
        //select and click on notebook
        click_element(By.xpath("//div[@class=\"sub-category-item\"]/h2//a[@href=\"/notebooks\"]"));
        click_element(By.xpath("//div[@class=\"item-grid\"]/div[4]/div/div[2]/h2//a[@href=\"/hp-spectre-xt-pro-ultrabook\"]"));
        //click on email a friend
        click_element(By.xpath("//input[@value=\"Email a friend\"]"));
        //type friends email id
        enterText(By.id("FriendEmail"),"nhp@m.com");
        //type your email id
        enterText(By.name("YourEmailAddress"),"");
        //type any message optional
        enterText(By.id("PersonalMessage"),"check this product");
        //click on send email
        click_element(By.xpath("//div[@class=\"buttons\"]//input[@name=\"send-email\"]"));
        // store expected result in string
        String expectedemailwithproductsucessfully ="Your message has been sent.";
        //store actual result in string
        String actualemailwithproductsucessfully = driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
        //comparing actual and expected results
        Assert.assertEquals(expectedemailwithproductsucessfully,actualemailwithproductsucessfully,"test case fail");
    }


    @Test
    public void unregister_user_not_able_to_send_email(){
        //click on apparel
      click_element(By.xpath("//div[@class=\"master-wrapper-page\"]//ul[@class=\"top-menu\"]/li[3]//a[@href=\"/apparel\"]"));
      //click on shoes
      click_element(By.xpath("//h2/a[@title=\"Show products in category Shoes\"]"));
     // click on choosen shoe
      click_element(By.xpath("//div[@class=\"details\"]/h2//a[@href=\"/nike-floral-roshe-customized-running-shoes\"]"));
      //click on email a friend
        click_element(By.xpath("//input[@value=\"Email a friend\"]"));
        //click on friends email
        //type friends email id
        enterText(By.id("FriendEmail"),"nhp@m.com");
        //type your email id
        enterText(By.name("YourEmailAddress"),"aaa@k.com");
        //type any message optional
        enterText(By.id("PersonalMessage"),"check this product");
        //click on send email
        click_element(By.xpath("//div[@class=\"buttons\"]//input[@name=\"send-email\"]"));
        // store expected result in string
        String expectedsucessmessage ="Only registered customers can use email a friend feature";
        //store actual result in string
        String actualsucessmessage = driver.findElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]//li")).getText();
        //compare expected and actual result
        Assert.assertEquals(expectedsucessmessage,actualsucessmessage,"test case fail");
    }
   @Test
   public void accept_terms_and_conditions() {
       //click on jewelry
       click_element(By.xpath("//div[@class=\"header-menu\"]//ul[@class=\"top-menu\"]/li[6]//a[@href=\"/jewelry\"]"));
       //click on flower girl bracelet
       click_element(By.xpath("//div[@class=\"details\"]//h2//a[@href=\"/flower-girl-bracelet\"]"));
       driver.findElement(By.xpath("//div[@class=\"add-to-cart-panel\"]//input[@type=\"text\"]")).clear();
       //enter quantity
       enterText(By.xpath("//input[@id=\"addtocart_41_EnteredQuantity\"]"),"1");
       //click on add to cart button
       click_element(By.id("add-to-cart-button-41"));
       //click on shopping cart
       click_element(By.className("cart-label"));
       //click on terms and condition
      // click_element(By.xpath("//label[@for=\"termsofservice\"]"));
       //click on checkout button
       click_element(By.xpath("//button[@id=\"checkout\"]"));
       // store expected result in string
       String expecteddisplaymessage="Please accept the terms of service before the next step.";
       //store actual result in string
       String actualdisplaymessage =driver.findElement(By.xpath("//div[@id=\"terms-of-service-warning-box\"]/p")).getText();
       //compare expected and actual result
       Assert.assertEquals(expecteddisplaymessage,actualdisplaymessage,"test case failed");

   }
   @Test
   public void buy_single_product_sucessfully(){
       // Click on regitser
       click_element(By.linkText("Register"));
       // click on female gender
       click_element(By.id("gender-female"));
       //click on first name box and type first name
       enterText(By.name("FirstName"), "ghghg");
       //click on last name box and type last name
       enterText(By.id("LastName"), "hhfdjh");
       //choose date of birth day
       click_element(By.xpath("//select[@name=\"DateOfBirthDay\"] / option[7]"));
       //choose date of birth month
       click_element(By.xpath("//select[@name=\"DateOfBirthMonth\"]/option[6]"));
       //choose date of birth year
       click_element(By.xpath("//select[@name=\"DateOfBirthYear\"]/option[6]"));
       DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHmmss");
       Date date = new Date();
       String date1 = dateFormat.format(date);
       //click on email box and type email id
       enterText(By.id("Email"),"nidhi_tondon" + date1 + "@yahoo.com");
       //click on company box and type company name
       enterText(By.id("Company"), "1234");
       //click on newsletter box
       click_element(By.id("Newsletter"));
       //click on password box and type password
       enterText(By.id("Password"), "vgy789");
       //click on confirm password box and type confirm password
       enterText(By.id("ConfirmPassword"), "vgy789");
       //click on register button
       click_element(By.id("register-button"));
       //click on continue button
       click_element(By.name("register-continue"));
       //click on giftcard
       click_element(By.xpath("//div[@class=\"master-wrapper-page\"]//div[@class=\"header-menu\"]/ul[@class=\"top-menu\"]/li[7]//a[@href=\"/gift-cards\"]"));
       //click on selected giftcard
       click_element(By.xpath("//div[@class=\"product-grid\"]/div/div[3]/div//div[@class=\"details\"]/h2/a[@href=\"/100-physical-gift-card\"]"));
       //enter recepitant name
       enterText(By.className("recipient-name"),"fgghj");
       //clear sender name box
        driver.findElement(By.xpath("//input[@id=\"giftcard_45_SenderName\"]")).clear();
       //enter sender name
       enterText(By.id("giftcard_45_SenderName"),"hghhg");
       //enter message in box
       enterText(By.id("giftcard_45_Message"),"Happy Birthday");
       //clear text from box
       driver.findElement(By.xpath("//input[@id=\"addtocart_45_EnteredQuantity\"]")).clear();
       //enter the quantity
       enterText(By.xpath("//input[@id=\"addtocart_45_EnteredQuantity\"]"),"1");
       //click on add to cart
       click_element(By.id("add-to-cart-button-45"));
       //click on shopping cart
       click_element(By.xpath("//span[@class=\"cart-label\"]"));
       //click on terms and condition checkbox
       click_element(By.xpath("//input[@id=\"termsofservice\"]"));
       //click on checkout button
       click_element(By.id("checkout"));
       //select and click on country
       click_element(By.xpath("//select[@id=\"BillingNewAddress_CountryId\"]/option[233]"));
       //click on state
       enterText(By.xpath("//select[@id=\"BillingNewAddress_StateProvinceId\"]"),"ggg");
       //click on city
       enterText(By.xpath("//input[@id=\"BillingNewAddress_City\"]"),"frjhj");
       //enter on address 1
       enterText(By.xpath("//input[@id=\"BillingNewAddress_Address1\"]"),"1122abc");
       //enter postcode
       enterText(By.xpath("//input[@id=\"BillingNewAddress_ZipPostalCode\"]"),"s4g5");
       //enter phone number
       enterText(By.id("BillingNewAddress_PhoneNumber"),"789066555");
       //click on continue button
       click_element(By.xpath("//div[@id=\"checkout-step-billing\"]/div//input[@type=\"button\"]"));
       //click on shpping method ground
       click_element(By.xpath("//label[@for=\"shippingoption_0\"]"));
       //click on continue button
       click_element(By.xpath("//div[@id=\"shipping-method-buttons-container\"]//input[@type=\"button\"]"));
       //click on credit card
       click_element(By.id("paymentmethod_1"));
       //click on continue button
       click_element(By.xpath("//div[@id=\"payment-method-buttons-container\"]//input[@type=\"button\"]"));
       //select visa card from drop down list
       click_element(By.xpath("//select[@id=\"CreditCardType\"]/option[@value=\"visa\"]"));
       //enter cardholder name
       enterText(By.id("CardholderName"),"nmhh");
       //enter cardholder number
       enterText(By.id("CardNumber"),"4111 1111 1111 1111");
       //select  and click month of expiry
       click_element(By.xpath("//select[@id=\"ExpireMonth\"]/option[@value=\"2\"]"));
       //select  and click year of expiry
       click_element(By.xpath("//select[@id=\"ExpireYear\"]/option[@value=\"2021\"]"));
       //enter cvv card code
       enterText(By.xpath("//input[@name=\"CardCode\"]"),"737");
       //click on continue button
       click_element(By.xpath("//div[@id=\"payment-info-buttons-container\"]/input[@type=\"button\"]"));
       //click on confirm button
       click_element(By.xpath("//div[@id=\"confirm-order-buttons-container\"]/input[@type=\"button\"]"));
       String expectedordersucessmessage ="Your order has been successfully processed!";
       //store actual result in string
       String actualordersucessmessage =driver.findElement(By.xpath("//div[@class=\"page-body checkout-data\"]/div/div/strong")).getText();
       //compare expected and actual result
       Assert.assertEquals(expectedordersucessmessage,actualordersucessmessage,"test case fail");
   }
   @Test
   public void sort_by_High_to_low(){
       //click on computers
       click_element(By.xpath("//div[@class=\"header-menu\"]/ul[@class=\"top-menu\"]//a[@href=\"/computers\"]"));
       //select and click on notebook
       click_element(By.xpath("//div[@class=\"sub-category-item\"]/h2//a[@href=\"/notebooks\"]"));
       //click to sort high to low
       click_element(By.xpath("//select[@id=\"products-orderby\"]/option[5]"));
       //getting first product price
       String first_product_price = driver.findElement(By.xpath("//div[@data-productid=\"4\"]//div[@class=\"prices\"]/span")).getText();
       //getting last product price;
       String last_product_price=driver.findElement(By.xpath("//div[@data-productid=\"7\"]//div[@class=\"prices\"]//span")).getText();
       //
       String value = first_product_price.replaceAll("[$,]","");
       String value1 =last_product_price.replaceAll("[$,]","");
       //convert first product string into float value
      float first_value=Float.parseFloat(value);
      //convert last product string into float value
      float last_value=Float.parseFloat(value1);
      //
       Assert.assertTrue(first_value>last_value,"test case fail");


       }


    public  void click_element(By by){
        driver.findElement(by).click();


    }
    public void enterText(By by,String text){
        driver.findElement(by).sendKeys(text);

    }
    public void clear_element(By by){

        driver.findElement(by).clear();
    }

    @AfterMethod
    public void close_browser(){
        driver.quit();
    }
}


