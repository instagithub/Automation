package pegamarketing.impl.dialog;

import org.openqa.selenium.By;

import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.Frame;
import pegamarketing.dialog.ConfigureOfferDialog;

public class PegaConfigureOfferDialog extends PegaConfigureDialog implements ConfigureOfferDialog {
	PegaWebElement elmt;
	PegaWebDriver pegaDriver;

	public PegaConfigureOfferDialog(Frame aElmt) {
		super(aElmt);
		this.elmt = aElmt;
		pegaDriver = elmt.getTestEnvironment().getPegaDriver();

	}

	public void addFirstSegment() {
		elmt.findElement(FIRST_ADD_BUTTON).click();
	}

	public void addOffer(String offerName) {
		elmt.findElement(By.xpath("//div[@node_name='SimpleMultiselectorCardContent'][.//span[text()='"+offerName+"']]//button[text()='Add']")).click();
	}

}