
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/extentReport.html"})
public class RunCukesTest extends AbstractTestNGCucumberTests{
	
	String COPYRIGHT = "Copyright (c) 2018  Pegasystems Inc.";
	String VERSION = "$Id: RunCukesTest.java 121819 2018-01-26 07:29:51Z SachinVellanki $";

}