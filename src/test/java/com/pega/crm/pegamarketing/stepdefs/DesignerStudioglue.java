package pegamarketing.stepdefs;

import com.google.inject.Inject;
import com.pega.MyBrowser;
import pegamarketing.DesignerStudio;
import pegamarketing.PMPortal;
import pegamarketing.explorer.RecordsExplorer;
import pegamarketing.pages.ServiceRestRecords;
import pegamarketing.utils.ObjectsBean;

import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class DesignerStudioglue {

	private MyBrowser browser;
	private DesignerStudio designerStudio;
	private RecordsExplorer recordsExplorer;
	private ServiceRestRecords serviceRestRecords;
	private PMPortal pmPortal;

	@Inject
	DesignerStudioglue(MyBrowser browser) {
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
