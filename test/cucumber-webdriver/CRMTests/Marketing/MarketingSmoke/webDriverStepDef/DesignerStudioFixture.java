package webDriverStepDef;

import com.google.inject.Inject;
import com.pega.MyBrowser;
import com.pega.pm.DesignerStudio;
import com.pega.pm.PMPortal;
import com.pega.pm.explorer.RecordsExplorer;
import com.pega.pm.pages.ServiceRestRecords;
import com.pega.pm.utils.ObjectsBean;

import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class DesignerStudioFixture {

	private MyBrowser browser;
	private DesignerStudio designerStudio;
	private RecordsExplorer recordsExplorer;
	private ServiceRestRecords serviceRestRecords;
	private PMPortal pmPortal;

	@Inject
	DesignerStudioFixture(MyBrowser browser) {
		this.browser = browser;
		designerStudio=browser.getDesignerStudio();
	}
	
	@When("^Opens the Records Explorer$")
	public void opens_the_Records_Explorer(){
		recordsExplorer= designerStudio.getRecordsExplorer();
	}
	@When("^Opens \"([^\"]*)\" records page after expanding \"([^\"]*)\"$")
	public void opens_records_page_after_expanding(String pageTobeOpened, String navPage1) {
		serviceRestRecords = recordsExplorer.openRecord(ServiceRestRecords.class, navPage1,pageTobeOpened);
		ObjectsBean.setServiceRestRecords(serviceRestRecords);
	}

	@When("^User launches pega marketing portal$")
	public void user_launches_pega_marketing_portal() {
		pmPortal = designerStudio.launchPegaMarketingPortal();
		ObjectsBean.setPMPortal(pmPortal);
	}
	
}
