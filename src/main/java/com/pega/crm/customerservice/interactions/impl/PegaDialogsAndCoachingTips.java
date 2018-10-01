package customerservice.interactions.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.framework.elmt.DropDown;
import com.pega.ri.Wizard;
import com.pega.ri.WizardImpl;
import customerservice.interactions.DialogsAndCoachingTips;
import customerservice.utils.CommonMethods;

public abstract class PegaDialogsAndCoachingTips extends WizardImpl implements DialogsAndCoachingTips {
	public static String CaseID = null;
	public String frameId = null;
	public Wizard newWizard = null;
	public CommonMethods commonMethods = null;
	boolean pop = false;

	public boolean isPop() {
		return pop;
	}

	public void setPop(boolean pop) {
		this.pop = pop;
	}
	public PegaDialogsAndCoachingTips(WebElement elmt, String frameId) {
		super(elmt, frameId);
		commonMethods = new CommonMethods(pegaDriver);
	}

	public PegaDialogsAndCoachingTips(WebElement elmt) {
		super(elmt);
	}

	@Override
	public void ConfigDialog() {
		/*pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath("//a[@aria-label='menu Launch']")).click();
		pegaDriver.findElement(By.xpath("//*[text()='Interaction Portal']")).click();
		ArrayList<String> tabs = new ArrayList<String>(pegaDriver.getWindowHandles());
		pegaDriver.switchTo().window(tabs.get(1));*/
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath("//a[text()='New']")).click();
		scriptExecutor.mouseOver(pegaDriver.findElement(By.xpath("//span[text()='Demo Screen Pops']")));
		// pegaDriver.findElement(By.xpath("//span[text()='Demo Screen
		// Pops']")).click();
		pegaDriver.handleWaits().sleep(3);
		pegaDriver.findElement(By.xpath("//span[text()='Demo Pop - CONNOR']")).click();
		pegaDriver.findElement(By.xpath(Btn_Accept)).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame1);
		pegaDriver.findElement(By.xpath(Btn_AddTask_Xpath)).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame1);
		pegaDriver.findElement(By.xpath(Link_AddressChange_Xpath)).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame1);
		pegaDriver.findElement(By.xpath(Btn_AddTasks_Xpath)).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.xpath(ToolsMenu_Xpath)).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.xpath(ConfigurationTools_Xpath)).click();
		/*pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.xpath(Tab_Dialogs_Xpath)).click();*/
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.xpath(Btn_EditDialog_Xpath)).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		DropDown When = pegaDriver.findSelectBox(By.xpath(DDL_When_Xpath));
		String WhenSelectedValue = When.getFirstSelectedOption().getText();
		System.out.println(WhenSelectedValue + "***WhenSelectedValue");
		String Dialog = pegaDriver.findElement(By.id(Text_EditDialog_Id)).getText();
		System.out.println(Dialog + "***Dialog");
		System.out.println(WhenSelectedValue + "***WhenSelectedValue");
		DropDown ReferTo = pegaDriver.findSelectBox(By.xpath(DDL_ReferTo_Xpath));
		String ReferToSelectedValue = ReferTo.getFirstSelectedOption().getText();
		DropDown Attribute = pegaDriver.findSelectBox(By.xpath(DDL_Attribute_Xpath));
		String AttributeSelectedValue = Attribute.getFirstSelectedOption().getText();
		pegaDriver.findElement(By.xpath(Btn_DeleteDialog_Xpath)).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.xpath(Link_AddNew_Xpath)).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		/*Boolean flagDDLWhen=pegaDriver.findSelectBox(By.xpath(DDL_When_Xpath)).isVisible();
		if(!flagDDLWhen){
			pegaDriver.findElement(By.xpath(Link_AddNew_Xpath)).click();
		}*/
		DropDown When1 = pegaDriver.findSelectBox(By.xpath(DDL_When_Xpath));
		When1.selectByVisibleText(WhenSelectedValue);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.xpath(Txt_Dialog_Xpath)).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		if(Dialog.equalsIgnoreCase("")||Dialog.equalsIgnoreCase(null)){
			Dialog="May I have the new address and phone number for your Individual account, please?";
		}
		pegaDriver.findElement(By.xpath(Txt_Dialog_Xpath)).sendKeys(Dialog);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		DropDown ReferTo1 = pegaDriver.findSelectBox(By.xpath(DDL_ReferTo_Xpath));
		ReferTo1.selectByVisibleText(ReferToSelectedValue);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		DropDown Attribute1 = pegaDriver.findSelectBox(By.xpath(DDL_Attribute_Xpath));
		Attribute1.selectByVisibleText(AttributeSelectedValue);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.xpath(Btn_Save)).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.className(Btn_Close_CN)).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		Assert.assertTrue("Configured dialog not available.",pegaDriver.verifyElement(By.xpath("//div[contains(text(),'May I have the new address and phone number for your Individual account, please?')]")));
	}

	@Override
	public void ConfigureCoachingTip() {
		String CoachingTip = "Please collect address from user";
		Boolean CoachingTipExists = pegaDriver
				.verifyElementVisible(By.xpath("//*[contains(text(),'" + CoachingTip + "')]"));
		if (CoachingTipExists) {
			System.out.println("*****CoachingTip Exists");
			pegaDriver
					.findElement(By.xpath("//*[contains(text(),'" + CoachingTip
							+ "')]/ancestor::td[1]/following-sibling::td/descendant::i[contains(@title,'Delete Coaching')]"))
					.click();
		}
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("PegaGadget2Ifr");
		pegaDriver.findElement(By.xpath(Link_AddNewCoachingTip_Xpath)).click();
		pegaDriver.findElement(By.xpath(Txt_EnterName_Xpath)).sendKeys("Instruction");
		pegaDriver.findElement(By.xpath(Txt_EnterName_Xpath)).sendKeys("Txt_EnterCoachingTip_Xpath");
		pegaDriver.findElement(By.xpath(Tab_Assign_Xpath)).click();
		pegaDriver.findElement(By.xpath(Link_AssignTip_Xpath)).click();
		int NoOfAssignedRecords = pegaDriver.findElements(By.xpath("//i[contains(@title,'Delete Association Tip')]"))
				.size();
		System.out.println("NoOfAssignedRecords****" + NoOfAssignedRecords);
		for (int i = 1; i <= NoOfAssignedRecords; i++) {
			pegaDriver.findElement(By.xpath("(//i[contains(@title,'Delete Association Tip')])[1]")).click();
		}
		pegaDriver.findElement(By.xpath(Link_AssignTip_Xpath)).click();
		DropDown CoachingTipDDL = pegaDriver.findSelectBox(By.id("CoachingTip"));
		CoachingTipDDL.selectByVisibleText("Instruction");
		DropDown EntityType = pegaDriver.findSelectBox(By.id("EntityType"));
		EntityType.selectByVisibleText("User");
		DropDown Entity = pegaDriver.findSelectBox(By.id("Entity"));
		Entity.selectByVisibleText("CA Sys Admin");
		Calendar date = Calendar.getInstance();
		date.setTime(new Date());
		SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy");
		String StartDate = f.format(date.getTime());
		System.out.println(f.format(date.getTime()) + "Start Date***");
		date.add(Calendar.YEAR, 1);
		String EndDate = f.format(date.getTime());
		System.out.println(f.format(date.getTime()) + "End Date***");
		pegaDriver.findElement(By.xpath(Txt_StartDate_Xpath)).sendKeys(StartDate);
		pegaDriver.findElement(By.xpath(Txt_EndDate_Xpath)).sendKeys(EndDate);
		pegaDriver.findElement(By.xpath(Btn_CTSave)).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("PegaGadget2Ifr");
		pegaDriver.findElement(By.className("iconClose")).click();
		pegaDriver.handleWaits().sleep(5);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("PegaGadget2Ifr");
		pegaDriver.findElement(By.xpath("//img[contains(@src,'coachingtipicon')]")).click();
	
	}

	@Override
	public void UnlockRuleSet(String RuleSetName, String RulesetVersion) {

		pegaDriver.findElement(By.id("pySearchText")).clear();
		// pegaDriver.findElement(By.id("pySearchText")).sendKeys("CustomerService-Dialog");
		pegaDriver.findElement(By.id("pySearchText")).sendKeys(RuleSetName);
		pegaDriver.findElement(By.xpath("//*[contains(@class,'pi pi-search')]")).click();
		pegaDriver.findElement(By.xpath("(//a[contains(text(),'" + RuleSetName + "')])[1]")).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		String lockedOrUnlocked = pegaDriver.findElement(By.xpath("//span[contains(text(),'" + RulesetVersion
				+ "')]/ancestor::td[1]/preceding-sibling::td[1]/descendant::img")).getAttribute("src");
		if (!lockedOrUnlocked.contains("unlocked")) {
			/*
			 * String expandOrCollapse = pegaDriver .findElement(By .xpath(
			 * "//span[contains(text(),'07-22-02')]/ancestor::td[1]/preceding-sibling::td[2]/span"
			 * )) .getAttribute("title");
			 */
			String expandOrCollapse = pegaDriver.findElement(By.xpath(
					"//span[contains(text(),'" + RulesetVersion + "')]/ancestor::td[1]/preceding-sibling::td[2]/span"))
					.getAttribute("title");

			if (expandOrCollapse.contains("expand row")) {
				pegaDriver.findElement(By.xpath("//span[contains(text(),'" + RulesetVersion
						+ "')]/ancestor::td[1]/preceding-sibling::td[2]/span")).click();
			}
			pegaDriver.findElement(By.xpath("//div[text()='Unlock and Save']")).click();
			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("PegaGadget0Ifr");
			pegaDriver.findElement(By.id("pyVersionPasswordEnteredText")).sendKeys("install");
			pegaDriver.findElement(By.id("ModalButtonSubmit")).click();
			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("PegaGadget0Ifr");
			pegaDriver.findElement(By.xpath("//button[text()='Save']")).click();
		}
		pegaDriver.switchTo().defaultContent();
	}

}
