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
        System.setProperty("webdriver.chrome.driver", "D:\\JavaProjects\\libs\\Selenium\\BrowserDrivers\\chromedriver.exe");
        base.Driver = new ChromeDriver();
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
