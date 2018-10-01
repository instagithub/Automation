package salesautomation.workobjects.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.ri.WizardImpl;
import salesautomation.workobjects.Pulse;

public class PegaPulse extends WizardImpl implements Pulse{
	
	String FOLLOWING_SECTION_XPATH="//h2[contains(text(),'Following')]";
	String SALES_COACH_WIDGET_XPATH="//h2[contains(text(),'Coaching plans')]";
	String FOLLOWERS_SECTION_XPATH="//h2[contains(text(),'Followers')]";
	String FILTER_BUTTON_XPATH="//button[@title='Filter']";
	String PULSE_TEXTAREA_ID="pyMessage";
	String PULSE_POST_BUTTON_XPATH=PegaUtil.getButtonXpath("Post");
	String PULSE_FIRST_POST_XPATH="(//div[@data-node-id='pyPostDetails']//div[@class='pulse-display-post'])[1]";
	public PegaPulse(WebElement elmt, String elmtId) {
		super(elmt, elmtId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void enterCommentsinPulse(String pulseComment) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(PULSE_TEXTAREA_ID)).sendKeys(pulseComment);
	}

	@Override
	public void clickPost() {
		pegaDriver.findElement(By.xpath(PULSE_POST_BUTTON_XPATH)).click();
	}
	@Override
	public boolean isFollowingSectionDisplayed() {
		pegaDriver.getActiveFrameId(true);
		boolean b= pegaDriver.findElement(By.xpath(FOLLOWING_SECTION_XPATH)).isVisible();
		return b;
	}

	@Override
	public boolean isFollowersSectionDisplayed() {
		pegaDriver.getActiveFrameId(true);
		boolean b= pegaDriver.findElement(By.xpath(FOLLOWERS_SECTION_XPATH)).isVisible();
		return b;
	}

	@Override
	public boolean isFilterButtonDisplayed() {
		pegaDriver.getActiveFrameId(true);
		boolean b= pegaDriver.findElement(By.xpath(FILTER_BUTTON_XPATH)).isVisible();
		return b;
	}

	@Override
	public String getFirstPulsePost() {
		pegaDriver.getActiveFrameId(true);
		return(pegaDriver.findElement(By.xpath(PULSE_FIRST_POST_XPATH)).getText());
	}

	@Override
	public boolean isSalesCoachWidgetDisplayed() {
		pegaDriver.getActiveFrameId(true);
		boolean b= pegaDriver.findElement(By.xpath(SALES_COACH_WIDGET_XPATH)).isVisible();
		return b;
	}
}
