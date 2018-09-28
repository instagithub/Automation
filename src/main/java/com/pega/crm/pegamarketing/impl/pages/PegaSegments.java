package pegamarketing.impl.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.pega.TestEnvironment;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.FrameImpl;
import pegamarketing.impl.rules.PegaSegment;
import pegamarketing.pages.Segments;
import pegamarketing.rules.Segment;

public class PegaSegments extends PegaLandingPage implements Segments {

	public PegaSegments(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	PegaWebElement elmt = null;

	public class ImageCatalogImpl extends FrameImpl implements ImageCatalog {

		public ImageCatalogImpl(WebElement elmt) {
			super(elmt);
		}

		public ImageCatalogImpl(WebElement elmt, String elmtId) {
			super(elmt, elmtId);
		}

		public void search(String picName) {
			elmt.findElement(By.id(SEARCH_TXTFIELD_ID)).sendKeys(picName + Keys.TAB);
			elmt.findElement(By.id(FIND_BUTTON_ID)).click();
		}

		public void chooseImage(String picName) {
			search(picName);
			elmt.findElement(By.xpath("//div[contains(@title,'" + picName + "')]")).click();
		}

		public void ok() {
			elmt.findElement(By.id(OK_BUTTON_ID)).click(false);
		}
	}

	public Segment createSegment() {
		pegaDriver.handleWaits().waitForElementVisibility(CREATE_BTN);
		findElement(CREATE_BTN).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		Segment segment = new PegaSegment(frameId, this.testEnv);
		return segment;
	}

	public Segment openSegmentRule(String segName) {
		pegaDriver.switchToActiveFrame();
		findElement(Segments.SEARCH_INPUT_BOX)
				.sendKeys(segName + Keys.TAB);
		findElement(Segments.VIEW_BTN).click();
		findElement(By.linkText(segName)).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		Segment segment = new PegaSegment(frameId, this.testEnv);
		return segment;
	}
}
