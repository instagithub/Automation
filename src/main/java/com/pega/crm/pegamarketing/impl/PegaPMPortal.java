package pegamarketing.impl;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.framework.PegaWebDriver;
import com.pega.page.PortalImpl;
import pegamarketing.PMPortal;
import pegamarketing.dialog.ModalDialog;
import pegamarketing.impl.pages.PegaCampaignsFrame;
import pegamarketing.impl.pages.PegaDataFlows;
import pegamarketing.impl.pages.PegaDataManagement;
import pegamarketing.impl.pages.PegaEligibilities;
import pegamarketing.impl.pages.PegaImageLibrary;
import pegamarketing.impl.pages.PegaLandingPage;
import pegamarketing.impl.pages.PegaMicrosites;
import pegamarketing.impl.pages.PegaOffers;
import pegamarketing.impl.pages.PegaPaidMediaAudiences;
import pegamarketing.impl.pages.PegaProspectLists;
import pegamarketing.impl.pages.PegaRealTimeArtifacts;
import pegamarketing.impl.pages.PegaRecentReports;
import pegamarketing.impl.pages.PegaSegments;
import pegamarketing.impl.pages.PegaStrategies;
import pegamarketing.impl.pages.PegaSummaries;
import pegamarketing.impl.pages.PegaTreatments;
import pegamarketing.impl.rules.PegaDesigner;
import pegamarketing.pages.LandingPage;
import pegamarketing.pages.ProspectLists;
import pegamarketing.pages.RealTimeArtifacts;
import pegamarketing.pages.RecentReports;
import pegamarketing.pages.Segments;
import pegamarketing.pages.Strategies;
import pegamarketing.rules.Designer;
import pegamarketing.utils.PMXPathUtil;

public class PegaPMPortal extends PortalImpl implements PMPortal {

	protected PegaWebDriver pegaDriver = null;
	protected TestEnvironment testEnv = null;

	public PegaPMPortal(TestEnvironment testEnv) {
		super(testEnv);
		this.testEnv = testEnv;
		this.pegaDriver = testEnv.getPegaDriver();
	}

	public void expandAudiences() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(AUDIENCES_MENU).click();
	}

	public Segments openSegments() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(SEGMENTS_MENU).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		Segments segments = new PegaSegments(frameId, testEnv);
		return segments;
	}

	public void expandMenuItems(String menuName) {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(NEW_ICON).mouseOver();
		pegaDriver.findElement(HOME_ICON).mouseOver();
		pegaDriver.findElement(By.xpath(PMXPathUtil.getMenuItemXPath(menuName))).click();
	}

	public Designer openDesigner() {
		pegaDriver.findElement(DESIGNER_MENU_ITEM).click();
		String frameId1 = pegaDriver.getActiveFrameId(true);
		Designer designer = new PegaDesigner(frameId1, testEnv);
		designer._setEnvironment(testEnv, frameId1);
		return designer;
	}

	public void expandContent() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(CONTENT_MENU).click();

	}

	public RealTimeArtifacts OpenRealTimeArtifacts() {

		pegaDriver.findElement(REALTIME_ARTIFACTS).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		RealTimeArtifacts realTimeArtifacts = new PegaRealTimeArtifacts(frameId, testEnv);
		realTimeArtifacts._setEnvironment(testEnv, frameId);
		return realTimeArtifacts;

	}

	public Strategies openStrategies() {
		pegaDriver.waitForDocStateReady(false);
		pegaDriver.findElement(INTELLIGENCE_MENU).click(false);
		pegaDriver.findElement(STRATEGIES_MENU).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		Strategies strategies = new PegaStrategies(frameId, testEnv);
		return strategies;
	}

	public LandingPage openLandingPage(LandingPageType landingPage) {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(NEW_ICON).mouseOver();
		pegaDriver.findElement(HOME_ICON).mouseOver();
		pegaDriver.findElement(By.xpath(PMXPathUtil.getMenuItemXPath(landingPage.getLandingPageName()))).click();
		pegaDriver.waitForDocStateReady();
		String frameId = pegaDriver.getActiveFrameId(true);
		return CreateCorrectLandingPageObj(landingPage, frameId);
	}

	private LandingPage CreateCorrectLandingPageObj(LandingPageType landingPage, String activeFrameID) {
		LandingPage landingPageObj = null;
		switch (landingPage) {
		case SEGMENTS:
			landingPageObj = new PegaSegments(activeFrameID, testEnv);
			break;
		case OFFERS:
			landingPageObj = new PegaOffers(activeFrameID, testEnv);
			break;
		case TREATMENTS:
			landingPageObj = new PegaTreatments(activeFrameID, testEnv);
			break;
		case STRATEGIES:
			landingPageObj = new PegaStrategies(activeFrameID, testEnv);
			break;
		case CAMPAIGNS:
			landingPageObj = new PegaCampaignsFrame(activeFrameID, testEnv);
			break;
		case DESIGNER:
			landingPageObj = new PegaDesigner(activeFrameID, testEnv);
			break;
		case ELIGIBILITIES:
			landingPageObj = new PegaEligibilities(activeFrameID, testEnv);
			break;
		case REALTIMEARTIFACTS:
			landingPageObj = new PegaRealTimeArtifacts(activeFrameID, testEnv);
			break;
		case DATAFLOWS:
			landingPageObj = new PegaDataFlows(activeFrameID, testEnv);
			break;
		case SUMMARIES:
			landingPageObj = new PegaSummaries(activeFrameID, testEnv);
			break;
		case DATA_MANAGEMENT:
			landingPageObj = new PegaDataManagement(activeFrameID, testEnv);
			break;
		case MICROSITES:
			landingPageObj = new PegaMicrosites(activeFrameID, testEnv);
			break;
		case PAIDMEDIAAUDIENCES:
			landingPageObj = new PegaPaidMediaAudiences(activeFrameID, testEnv);
			break;
		case IMAGELIBRARY:
			landingPageObj = new PegaImageLibrary(activeFrameID, testEnv);
			break;
		default:
			landingPageObj = new PegaLandingPage(activeFrameID, testEnv);
		}
		return landingPageObj;
	}

	public void selectConfigurationMenu(String menuName) {
		pegaDriver.findElement(CONFIGURATION_MENU_XPATH).click(false);
		pegaDriver.findElement(By.xpath("//span[@class='menu-item-title' and text()='" + menuName + "']")).mouseOver();
	}

	public ProspectLists selectProspectLists() {
		pegaDriver.findElement(PROSPECT_LISTS_SUBMENU).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		ProspectLists prospectLists = new PegaProspectLists(frameId, testEnv);
		return prospectLists;
	}

	public RecentReports selectReportBrowser() {
		pegaDriver.findElement(REPORT_BROWSER_SUBMENU).click();
		String frameId1 = pegaDriver.getActiveFrameId(true);
		RecentReports recentReports = new PegaRecentReports(frameId1, testEnv);
		return recentReports;
	}

	public void selectReports() {
		pegaDriver.findElement(REPORTS_ICON).click(false);

	}

	public void closeWelcomeDialog() {
		pegaDriver.switchTo().defaultContent();
		findElement(ModalDialog.CLOSE_BUTTON).click();
	}
}
