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

    @FindBy(id = "application_type_single")
    public WebElement applicationTypeSingle;
    
    @FindBy(id = "application_type_joint")
    public WebElement applicationTypeJoint;
    
    @FindBy(id = "expenses")
    public WebElement expenses;
 
    @FindBy(name="Number of dependants")
    public WebElement dropdown;
  
    @FindBy(how = How.CSS, using = "select[title=\"Number of dependants\"]")
    public WebElement numberOfDependents;

    @FindBy(how = How.NAME, using = "Login")
    public WebElement btnLogin;  

    public void SelectSingleApplicationType() {
    	applicationTypeSingle.click();
    }
    
    public void SelectJointApplicationType() {
    	applicationTypeJoint.click();
    }
    
    public void EnterExpenses(String expenseAmount) {
    	expenses.sendKeys(expenseAmount);

    }
    
    public void SelectFromDropDown(String index) {    	
    	   Select statusDropdown=new Select(numberOfDependents);
    	    statusDropdown.selectByVisibleText(index);
    }
    
 


}
