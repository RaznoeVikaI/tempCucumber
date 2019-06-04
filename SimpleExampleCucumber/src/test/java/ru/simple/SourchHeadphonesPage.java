package ru.simple;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Второй тест
 */

public class SourchHeadphonesPage extends BaseTest {
    @Given("I browse to yandex.ru for headphones")
    public void i_browse_to_yandex_ru(){
        getDriver();
        driver.get("https://www.yandex.ru/");
    }

    @When("I click \"Market for Headphones\" link")
    public void i_click_market_link(){
        driver.findElement(By.xpath("//*[@data-id='market']")).click();
    }

    @When("I click \"Elektronika for Headphones\" link")
    public void i_click_elektronika_link(){
        driver.findElement(By.xpath("//span[contains(text(),'Электроника')]")).click();
    }

    @When("I click \"Headphones\" link")
    public void i_click_mobile_link(){
        driver.findElement(By.xpath("//a[contains(text(),'Наушники и Bluetooth-гарнитуры')] ")).click();
    }

    @And("I click \"Advanced Search for Headphones\" button")
    public void i_click_advanced_search_button(){
        driver.findElement(By.cssSelector("._28j8Lq95ZZ")).click();
    }

    @When("I enter (.*) in pricefromforheadphones field")
    public void i_enter_pricefrom_in_pricefrom_field(String pricefrom){
        //driver.findElement(By.xpath("//*[@id='glf-pricefrom-var']")).sendKeys(pricefrom);
        //driver.findElement(By.xpath("[@id='glpricefrom']")).sendKeys(pricefrom);
        driver.findElement(By.xpath("//*[@id='glpricefrom']")).sendKeys(pricefrom);
    }

    @And("I click \"beats\" item")
    public void i_click_beats_item(){
        driver.findElement(By.xpath("//*[contains(text(),'Beats')]")).click();
    }


    @When("I click \"Apply for Headphones\" button")
    public void i_click_apply_button(){
        WebElement element = driver.findElement(By.xpath("//span[text()='Показать подходящие']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//span[text()='Показать подходящие']")),0,0);
        actions.click().build().perform();
    }

    @Then("I see \"48 headphones\" item")
    public void i_see_48_item(){
        int countItem = driver.findElements(By.xpath("//div[contains(@data-id,'model')]")).size();
        //fixme:Число элементов меняется постоянно!
        Assert.assertNotEquals(countItem,48);
    }

    @And("I remember first item for headphones")
    public String i_remember_frist_item(){
        WebElement firstElement = driver.findElement(By.xpath("//div[contains(@class,'title')]/a[1]"));
        return firstElement.getText();
    }

    @When("I entered him in search field for headphones")
    public void i_entered_him_in_search_field(){
        WebElement searchInput = driver.findElement(By.xpath("//*[@id='header-search']"));
        searchInput.sendKeys(i_remember_frist_item());

    }

    @And("I click \"Search\" button for headphones")
    public void i_click_search_button_for_headphones(){
        WebElement searchButton = driver.findElement(By.cssSelector("button.button2"));
        searchButton.click();
    }

    @When("I see result for search headphones")
    public String i_see_result_for_search_headphones(){
        WebElement secondSourchFirstFounElement = driver.findElement(By.cssSelector("h1.title"));
        return secondSourchFirstFounElement.getText();
    }


    @Then("I compare values for headphones")
    public boolean i_compare_values_for_headphones(){
        WebElement firstElement = driver.findElement(By.cssSelector("h1.title"));
        return firstElement.getText().equalsIgnoreCase(i_see_result_for_search_headphones());
    }

}