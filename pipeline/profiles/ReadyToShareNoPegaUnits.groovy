import com.pega.pipeline.api.Profile

public class ReadyToShareNoPegaUnits extends Profile {

    public boolean runJunit() { false }

    public boolean runRspec() { false }

    public boolean runJSunit() { false }

    public boolean runCucumber() { true }

    public boolean runTrueUnit() { false }

    public boolean runPegaunit() { false }

    public String getPr3UnitTestSuites() { return "" }

    public String getRspecTestSuites() { return "" }

    public String getJSunitTestSuites() { return "" }

    public String getCucumberTestSuites() { return "" }

    public String getPegaUnitTestSuites() { return "PEGACA-WORK!TS_SMOKE_CICD"}
    public String JunitSelectionCriteria() { return "" }

    public String RspecSelectionCriteria() { return "" }

    public String JSunitSlectionCriteria() { return "" }

    public String CucumberSelectionCriteria() { return "@CRM-SMOKE" }

    public String RspecBrowser() { return "chrome" }

    public String JSunitBrowser() { return "chrome" }

    public String CucumberBrowser() { return "chrome" }

    public String getProfileName() { return "ReadyToShareNoPegaUnits" }

    public String getPegaUnitAccessGroup() {'CRMPegaUnits'}
    public String getPegaUnitOperator() { 'CRMPegaUnits' }
    public String getPegaUnitPassword() { 'install' }
    public String getPegaUnitActivityPath() { 'PRRestService/PegaUnit/Rule-Test-Unit-Case/pzExecuteTests' }

}
