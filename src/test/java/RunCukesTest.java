
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions()
public class RunCukesTest extends AbstractTestNGCucumberTests{
	
	String COPYRIGHT = "Copyright (c) 2018  Pegasystems Inc.";
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}


