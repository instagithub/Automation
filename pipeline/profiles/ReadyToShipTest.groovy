
import com.pega.pipeline.api.Profile
import com.pega.pipeline.api.Profile.Browser
import com.pega.pipeline.api.Profile.CustomBuilder

public class ReadyToShipTest extends Profile  {

    public boolean runJunit()  {false}
    public boolean runRspec()  {false}
    public boolean runJSunit() {false}
    public boolean runCucumber()  {true}

    public String getPr3UnitTestSuites() {return ""}
    public String getRspecTestSuites()   {return ""}
    public String getJSunitTestSuites()  {return ""}
	public String getCucumberTestSuites()   {return ""}	

    public String JunitSelectionCriteria() {return ""}
    public String RspecSelectionCriteria() {return ""}
    public String JSunitSlectionCriteria() {return ""}
	public String CucumberSelectionCriteria() {return "@TC-39,@TC-311,@TC-34,@TC-22,@TC-310,@TC-33,@TC-29"}

    public String RspecBrowser()  {return "chrome"}
    public String JSunitBrowser() {return "chrome"}
	public String CucumberBrowser() {return "chrome"}

	public String getProfileName() {return "ReadyToShipTest"}
	
}