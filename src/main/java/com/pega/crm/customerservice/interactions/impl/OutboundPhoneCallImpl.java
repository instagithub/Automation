package customerservice.interactions.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.ri.Wizard;
import customerservice.interactions.OutboundPhoneCall;
import customerservice.utils.CommonMethods;

public class OutboundPhoneCallImpl extends InteractionsImpl implements OutboundPhoneCall {

	public String frameId = null;
	public Wizard newWizard = null;
	public CommonMethods commonMethods = null;

	public OutboundPhoneCallImpl(WebElement elmt, String frameId) {
		super(elmt, frameId);
		// TODO Auto-generated constructor stub
		commonMethods = new CommonMethods(pegaDriver);
	}

	public OutboundPhoneCallImpl(WebElement elmt) {
		super(elmt);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void CaptureCallReasonAndPlaceCall(String reason, String status) {
		  
		  frameId = pegaDriver.getActiveFrameId(false);
		  newWizard  = pegaDriver.findWizard(frameId);
		  pegaDriver.waitForDocStateReady(2);
		  DropDown reasonDropdown = newWizard.findSelectBox(By.xpath(OUTBOUND_REASON_XPATH));
		  reasonDropdown.selectByValue(reason);
		  pegaDriver.waitForDocStateReady(2);
		  String finalXpath =  new String(OUTBOUND_STATUS_XPATH).replace("#status#", status);
		  PegaWebElement rdbutton = newWizard.findElement(By.xpath(finalXpath));
		  rdbutton.click();
		  pegaDriver.waitForDocStateReady(3);
		  PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		  submitButton.click(false);
		
		  	
	}
	
	@Override
	public void CaptureCallReasonAndPlaceCallWithoutSubmit(String reason, String status) {
		  
		  frameId = pegaDriver.getActiveFrameId(false);
		  newWizard  = pegaDriver.findWizard(frameId);
		  DropDown reasonDropdown = newWizard.findSelectBox(By.xpath(OUTBOUND_REASON_XPATH));
		  reasonDropdown.selectByVisibleText(reason);
		  pegaDriver.waitForDocStateReady(2);
		  
		  String finalXpath =  new String(OUTBOUND_STATUS_XPATH).replace("#status#", status);
		  pegaDriver.findElement(By.xpath(finalXpath)).click();
		  pegaDriver.waitForDocStateReady(3);
		  		
	}
	
	public void exitInteraction(String exitComments)
	{
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		newWizard.findElement(By.xpath(EXITCOMMENT_TEXTAREA_XPATH)).sendKeys(exitComments);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);
		
	}
	
	public void launchOutboundWrapUp()
	{
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		PegaWebElement wrapUp = newWizard.findElement(By.xpath(OUTBOUND_WRAP_UP_XPATH));
		wrapUp.click();
	}
	
	public void launchOutboundInteraction(String contactName, String callStatus)
	{
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		String custName;
		String phType;
		
		PegaWebElement outboundCallTable = pegaDriver.findElement(By.xpath(OUTBOUND_SIMULATION_TABLE_XPATH));
		int outboundCallRows = outboundCallTable.findElements(By.tagName("tr")).size();
		System.out.println(outboundCallRows);
		for(int i=2; i <= outboundCallRows; i++)
		{
			custName = pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'D_ContactsCommsByAccountNumber')]/descendant::tr["+i+"]/td[1]/div/span")).getText();
			System.out.println(custName);
			phType = pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'D_ContactsCommsByAccountNumber')]/descendant::tr["+i+"]/td[4]/div/span")).getText();
			System.out.println(phType);
			DropDown callStatusDropdown = newWizard.findSelectBox(By.id("OutboundCallStatus"+(i-1)));
			if(!custName.equalsIgnoreCase(contactName) && phType.equalsIgnoreCase("Home Phone"))
			{
				
				callStatusDropdown.selectByValue("No Answer");
			}
			else if(custName.equalsIgnoreCase(contactName))
			{
				callStatusDropdown.selectByValue(callStatus);
			}
		}
		
		
		pegaDriver.waitForDocStateReady(3);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		  submitButton.click(false);
	}
	
	public void launchOutboundInteractionforFirst(String contactName, String callStatus)
	{
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		String custName;
		String phType;
		
		PegaWebElement outboundCallTable = pegaDriver.findElement(By.xpath(OUTBOUND_SIMULATION_TABLE_XPATH));
		int outboundCallRows = outboundCallTable.findElements(By.tagName("tr")).size();
		System.out.println(outboundCallRows);
		for(int i=2; i <= outboundCallRows; i++)
		{
			custName = pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'D_ContactsCommsByAccountNumber')]/descendant::tr["+i+"]/td[1]/div/span")).getText();
			System.out.println(custName);
			phType = pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'D_ContactsCommsByAccountNumber')]/descendant::tr["+i+"]/td[4]/div/span")).getText();
			System.out.println(phType);
			DropDown callStatusDropdown = newWizard.findSelectBox(By.xpath("//select[contains(@name,'l"+(i-1)+"$pOutboundCallStatus')]"));
			if (custName.equalsIgnoreCase(contactName) && phType.equalsIgnoreCase("Business Phone"))
			{
				callStatusDropdown.selectByValue(callStatus);
			}
			if (custName.equalsIgnoreCase(contactName) && (phType.equalsIgnoreCase("Home Phone")||phType.equalsIgnoreCase("HOM")))
			{
				System.out.println("IN IF loop");
				callStatusDropdown.selectByValue(callStatus);
			}
			
			if  (custName.equalsIgnoreCase(contactName) && (phType.equalsIgnoreCase("Mobile Phone")||phType.equalsIgnoreCase("MOB")))
			{
				System.out.println("IN IF loop");
				callStatusDropdown.selectByValue(callStatus);
			}
			
		}
		
		
	}

	public void launchOutboundInteractionforSecond(String contactName, String callStatus)
	{
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		System.out.println("In 2nd");
		String custName;
		String phType;
		
		PegaWebElement outboundCallTable = pegaDriver.findElement(By.xpath(OUTBOUND_SIMULATION_TABLE_XPATH));
		int outboundCallRows = outboundCallTable.findElements(By.tagName("tr")).size();
		System.out.println(outboundCallRows);
		for(int i=2; i <= outboundCallRows; i++)
		{
			custName = pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'D_ContactsCommsByAccountNumber')]/descendant::tr["+i+"]/td[1]/div/span")).getText();
			System.out.println(custName);
			custName=custName.trim();
			phType = pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'D_ContactsCommsByAccountNumber')]/descendant::tr["+i+"]/td[4]/div/span")).getText();
			System.out.println(phType);
			DropDown callStatusDropdown = newWizard.findSelectBox(By.xpath("//select[contains(@name,'l"+(i-1)+"$pOutboundCallStatus')]"));
			if (custName.equalsIgnoreCase(contactName) && (phType.equalsIgnoreCase("Home Phone")||phType.equalsIgnoreCase("HOM")))
			{
				callStatusDropdown.selectByValue(callStatus);
			}
			
			if  (custName.equalsIgnoreCase(contactName) && (phType.equalsIgnoreCase("Mobile Phone")||phType.equalsIgnoreCase("MOB")))
			{
				callStatusDropdown.selectByValue(callStatus);
			}
			
		}
		
		
	}

	public void submitChanges(){
	
		pegaDriver.waitForDocStateReady(3);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		  submitButton.click(false);
		 
	}
	public void submitoutboundverificationchanges() {
		 pegaDriver.switchToActiveFrame();
		  if(pegaDriver.verifyElement(By.xpath("//*[contains(text(),'Contact Verification')]")))
		  {
			  System.out.println("I am in IF loop");
		  int pageexists=pegaDriver.findElements(By.xpath("//*[contains(text(),'Contact Verification')]")).size();
			if(pageexists>0){
			int noOfQstns=pegaDriver.findElements(By.xpath("//input[contains(@id,'IsSecurityQuestionVerified')]")).size();
			if(noOfQstns>0){
			for(int i=1;i<=noOfQstns;i++){
				pegaDriver.waitForDocStateReady(5);
				PegaWebElement chkBox=pegaDriver.findElement(By.xpath("(//input[contains(@id,'IsSecurityQuestionVerified')])["+i+"]"));
				chkBox.check();
				pegaDriver.waitForDocStateReady(1);
				/*if(!chkBox.isSelected()){
					chkBox.check();
				}*/
				}
			}
			PegaWebElement submit = pegaDriver.findElement(By.xpath("//button[contains(.,'Submit')]"));
			submit.click(false);
			pegaDriver.waitForDocStateReady(3);
			}
		  }

	}

	
	
	

	
}
