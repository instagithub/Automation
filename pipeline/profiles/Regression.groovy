import com.pega.pipeline.api.Profile

public class Regression extends Profile {

    public boolean runJunit() { false }

    public boolean runRspec() { false }

    public boolean runJSunit() { false }

    public boolean runCucumber() { true }

    public boolean runTrueUnit() { false }

    public String getPr3UnitTestSuites() { return "" }

    public String getRspecTestSuites() { return "" }

    public String getJSunitTestSuites() { return "" }

    public String getCucumberTestSuites() { return "" }

    public String JunitSelectionCriteria() { return "" }

    public String RspecSelectionCriteria() { return "" }

    public String JSunitSlectionCriteria() { return "" }

    public String CucumberSelectionCriteria() { return "@CRM-REGRESSION" }

    public String RspecBrowser() { return "chrome" }

    public String JSunitBrowser() { return "chrome" }

    public String CucumberBrowser() { return "chrome" }

    public int getCucumberTimeout() {return 300}

    public String getProfileName() { return "Regression" }
}
