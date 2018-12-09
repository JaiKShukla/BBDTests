package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.BaseUtil;


public class HomeLoanCalculator extends BaseUtil {

    public HomeLoanCalculator(WebDriver driver) {
    	// Intialize the WebElements
        PageFactory.initElements(driver, this);
    }

    //Your Details WebElements
    @FindBy(id = "application_type_single")
    public WebElement applicationTypeSingle;
    
    @FindBy(id = "application_type_joint")
    public WebElement applicationTypeJoint;
    
    @FindBy(how = How.CSS, using = "select[title=\"Number of dependants\"]")
    public WebElement numberOfDependents;
    
    @FindBy(id = "borrow_type_investment")
    public WebElement investmentTypeBorrower;
    
    @FindBy(id = "borrow_type_home")
    public WebElement homeTypeBorrower;

    // Your Earning details
    
    //Not the correct way to get the webelemt.Need to get it through xpath
    @FindBy(id = "q2q1i1")
    public WebElement yourIncome;
    
    //Not the correct way to get the webelemt.Need to get it through xpath
    @FindBy(id = "q2q2i1")
    public WebElement yourOtherIncome;    

    //Your Expenses WebElements
    @FindBy(id = "expenses")
    public WebElement expenses;
  
    @FindBy(id = "homeloans")
    public WebElement homeloans;
    
    @FindBy(id = "otherloans")
    public WebElement otherloans;

    //Not the correct webelement.Need to get it through xpath or CSS
    @FindBy(id = "q3q4i1")
    public WebElement othercommitments;
    
    @FindBy(id = "credit")
    public WebElement credit;
    
    
    // Borrowing capacity calculation
    @FindBy(id = " borrow__result__text__amount")
    public WebElement borrowingCapacity;
  
  //Your Details Interaction with the Pages
    public void SelectSingleApplicationType() {
    	applicationTypeSingle.click();
    }
    
    public void SelectJointApplicationType() {
    	applicationTypeJoint.click();
    }
    
    
    public void SelectFromDropDown(String index) {    	
 	   Select statusDropdown=new Select(numberOfDependents);
 	    statusDropdown.selectByVisibleText(index);
    }
    
    public void SelectHomeTypeBorrower() {
    	homeTypeBorrower.click();
    }
    
    public void SelectInvestmentTypeBorrower() {
    	investmentTypeBorrower.click();
    }
    
    
    public String GetSingleApplicationType() {
    	return applicationTypeSingle.getText();
    }
    
    public String GetJointApplicationType() {
    	applicationTypeJoint.click();
    	return applicationTypeJoint.getText();
    }
    
    public String GetHomeTypeBorrower() {
    	homeTypeBorrower.click();
    	return homeTypeBorrower.getText();
    }
    
    public String GetInvestmentTypeBorrower() {
    	investmentTypeBorrower.click();
    	return investmentTypeBorrower.getText();
    }
    
    //Your earnings Interaction with the Pages
    public void EnterYourIncomeBeforeTax(String amount) {
    	yourIncome.click();
    	yourIncome.sendKeys(amount);
    }
    
    public void EnterOtherIncome(String amount) {
    	yourOtherIncome.click();
    	yourOtherIncome.sendKeys(amount);
    }
    
    public String GetYourIncomeBeforeTax(String amount) {
    	yourIncome.click();
    	return yourIncome.getText();
    }
    
    public String GetOtherIncome(String amount) {
    	yourOtherIncome.click();
    	return yourOtherIncome.getText();
    }
    
    //Your expenses Interaction with the Pages
    public void EnterExpenses(String amount) {
    	expenses.clear();
    	expenses.sendKeys(amount);

    }
    
    public void EnterCurrentHomeAmount(String amount) {
    	homeloans.clear();
    	homeloans.sendKeys(amount);

    }
    
    public void EnterOtherLoanAmount(String amount) {
    	otherloans.clear();
    	otherloans.sendKeys(amount);

    }
    
    public void EnterOtherCommitment(String amount) {
    	othercommitments.clear();
    	othercommitments.sendKeys(amount);

    }
    
    
    public void EnterTotalCredits(String amount) {
    	credit.clear();
    	credit.sendKeys(amount);

    }
    
 
    // Get Borrowing Capacity
    public String GetBorrowingCapacity() {
    	return borrowingCapacity.getText();
    }
 


}
