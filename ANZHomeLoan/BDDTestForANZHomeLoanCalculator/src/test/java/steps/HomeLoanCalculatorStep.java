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
import java.util.Map;

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
    public void enters_the_following_details_in_Your_details_section(DataTable sectionTableDetails) throws Throwable {
    	Map <String,String> data =  (Map<String, String>) sectionTableDetails.asMaps(String.class,String.class);
    	//Get the value from the cuumber table
    	String dropdownSelection= data.get("Number of Dependents");
    	HomeLoanCalculator page = new HomeLoanCalculator(base.Driver);
    	page.SelectSingleApplicationType();   
    	page.SelectFromDropDown(dropdownSelection);
    
    }
 

    @Then("^I should see the userform page wrongly$")
    public void iShouldSeeTheUserformPageWrongly() throws Throwable {

        Assert.assertEquals("Its not displayed", base.Driver.findElement(By.id("sdfgdsfsd")).isDisplayed(), true);
    }




}
