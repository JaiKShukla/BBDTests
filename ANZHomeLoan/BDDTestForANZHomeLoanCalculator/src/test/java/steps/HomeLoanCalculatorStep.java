package steps;

import Base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.HomeLoanCalculator;

import java.util.ArrayList;
import java.util.List;

public class HomeLoanCalculatorStep extends BaseUtil{

    private  BaseUtil base;
    protected String homeLoanCalculatorUrl ="https:\\www.anz.com.au\\personal\\home-loans\\calculators-tools\\much-borrow\\";

    public HomeLoanCalculatorStep(BaseUtil base) {
        this.base = base;
    }    
    
    @Given("^the customer in on the Borrowing Power Calcuator page$")
    public void the_customer_in_on_the_Borrowing_Power_Calcuator_page() throws Throwable {
    	base.Driver.navigate().to(homeLoanCalculatorUrl);    	
    }

    @And("^enters the following details in Your details section$")
    public void enters_the_following_details_in_Your_details_section(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
    	HomeLoanCalculator page = new HomeLoanCalculator(base.Driver);
    	 page.SelectJointApplicationType();
    
    	 page.SelectFromDropDown("2");
    
    }
 

    @Then("^I should see the userform page wrongly$")
    public void iShouldSeeTheUserformPageWrongly() throws Throwable {

        Assert.assertEquals("Its not displayed", base.Driver.findElement(By.id("sdfgdsfsd")).isDisplayed(), true);
    }




}
