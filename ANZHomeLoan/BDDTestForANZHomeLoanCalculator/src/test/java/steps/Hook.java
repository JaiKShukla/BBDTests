package steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Hook extends BaseUtil{


    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest() {

        System.out.println("Opening the browser : Chrome");      

        //Chrome driver
        //TODO: Set the path of the webdriver to be relative to the project by using user.property ?
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\BrowserDrivers\\chromedriver.exe");
        base.Driver = new ChromeDriver();
        // Few default timeouts to make sure we dont exception on load.
        //TODO Move the 30 and 20 seconds to a separate class file
        base.Driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        base.Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            //Take screenshot logic goes here
            System.out.println(scenario.getName());
        }
        base.Driver.quit(); 
        base.Driver.close(); 
        System.out.println("Closing the browser");
    }

}
