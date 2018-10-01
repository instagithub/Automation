package customerservice.designerstudio.impl;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import customerservice.designerstudio.ApplicationWizard;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.ri.Wizard;

public class PegaApplicationWizard extends com.pega.wizard.ApplicationWizardImpl implements ApplicationWizard{

	private static final String CS_IMPL_OPERATOR_MENU_XPATH = "//i[@title='CS Admin']";
	private static final String CS_IMPL_OPERATOR_XPATH = "//span[text()='Operator']";
	private static final String CS_IMPL_OPERATOR_MENU_XPATH_DS = "//i[@title='CSC Admin']"; 
	
	public PegaApplicationWizard(WebElement elmt) {
		super(elmt);
		// TODO Auto-generated constructor stub
	}

	public PegaApplicationWizard(WebElement elmt, String elmtId) {
		super(elmt, elmtId);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void createNewApplication(String builton,String type,String organization){
		WebDriverWait wait = new WebDriverWait(pegaDriver, 120);
		String frameId = pegaDriver.getActiveFrameId(false);
		Wizard newWizard = pegaDriver.findWizard(frameId);
		
	 
		pegaDriver.switchToActiveFrame();
		int s;

		s = (int) Math.ceil(Math.random() * 100);
		PegaWebElement webElement=pegaDriver.findElement(By.xpath("//span/input[@id='pyApplicationNameAsEntered']"));
		webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		webElement.sendKeys(Keys.DELETE);
		webElement.sendKeys("Test"+s);
		
		DropDown builtOn = newWizard.findSelectBox(By.xpath("//select[@name='$PpyWorkPage$ppyBasedOnFrameworkNameAndVersion']"));
		builtOn.selectByVisibleText(builton);
		PegaWebElement orgName=pegaDriver.findElement(By.xpath("//input[@id='pyOrganizationName']"));
		orgName.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		orgName.sendKeys(Keys.DELETE);
		orgName.sendKeys(organization);
		
		pegaDriver.waitForDocStateReady(2);

		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		
		DropDown structure = newWizard.findSelectBox(By.xpath("//select[@name='$PpyWorkPage$ppyCreateLayerOptionSelected']"));
		structure.selectByVisibleText(type);;
		
			pegaDriver.findElement(By.xpath("//div[text()='Next >']")).click(false);
			pegaDriver.waitForDocStateReady(2);
			int i=pegaDriver.findElements(By.xpath("//span[@id='PegaRULESErrorFlag']")).size();
			System.out.println(i);
			if (i!=0) {
				
				createNewApplication(builton,type,organization);
			}
			else{
				//click Next for case types screen 
			
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Add business objective']")));
			
				pegaDriver.switchToActiveFrame();
				pegaDriver.findElement(By.xpath("//div[text()='Next >']")).click(false);
				pegaDriver.waitForDocStateReady(10);
				//click next
				
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[text()='"+builton+"']")));
				pegaDriver.findElement(By.xpath("//div[text()='Next >']")).click(false);
				//click next
				pegaDriver.waitForDocStateReady(10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Please address any issue(s) and review the class groups before generating this application')]")));
	            int j = pegaDriver.findElements(By.xpath("//div[contains(text(),'This application has  1 case(s) with naming conflicts')]")).size();
			    if (j!= 0)
			    {
			    	PegaWebElement survey=pegaDriver.findElement(By.xpath("//input[@id='pyNameNodeToken' and @value='Survey']"));
			    	survey.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			    	survey.sendKeys(Keys.DELETE);
			    	survey.sendKeys("survey1");
			    }
				pegaDriver.findElement(By.xpath("//div[text()='Next >']")).click(false);
				pegaDriver.waitForDocStateReady(10);
				pegaDriver.findElement(By.xpath("//div[text()='Create']")).click(false);
				pegaDriver.waitForDocStateReady(15);
				
			}
		}

	@Override
		public void createNewCase(String caseName,String stageName){
		pegaDriver.switchTo().defaultContent();
		//click on Cases
		pegaDriver.findElement(By.xpath("//label[text()='Cases']")).click(false);
		WebDriverWait wait = new WebDriverWait(pegaDriver, 1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Add a case type']")));
		pegaDriver.findElement(By.xpath("//a[text()='Add a case type']")).click(false);
		pegaDriver.waitForDocStateReady(2);
		//switching to a modal dialog
		 Set<String> handles = pegaDriver.getWindowHandles();
		    Iterator<String> itr = handles.iterator();
		    String  firstHandle = itr.next();
		    String lastHandle = firstHandle;
		    while (itr.hasNext()) {
		        lastHandle = itr.next();
		    }
		    pegaDriver.switchTo().window(lastHandle);
		    PegaWebElement casename = pegaDriver.findElement(By.xpath("//input[@placeholder='Case type name']"));
		    casename.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		    casename.sendKeys(Keys.DELETE);
		    casename.sendKeys(caseName);
		    pegaDriver.findElement(By.xpath("//button[contains(@name,'pzModalEditorButtons_D_pzCaseTypeConfiguration')][1]")).click(false);
		    pegaDriver.switchTo().defaultContent();
		    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+caseName+"']")));
		    pegaDriver.waitForDocStateReady(5);
		   /* String frameId = pegaDriver.getActiveFrameId(false);
			WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
			pegaDriver.switchTo().frame(frameElmt);*/
		    pegaDriver.switchToActiveFrame();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Edit case type:']")));
			pegaDriver.findElement(By.xpath("//label[text()='Life cycle']")).click(false);
			pegaDriver.waitForDocStateReady(2);
			pegaDriver.findElement(By.xpath("//button[contains(@name,'pzManageCaseTypeStages_CaseTypeStages')]")).click(false);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='$PCaseTypeStages$ppyStages$l1$ppyStageName']")));
			
			PegaWebElement StageName = pegaDriver.findElement(By.xpath("//input[@name='$PCaseTypeStages$ppyStages$l1$ppyStageName']"));
			StageName.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			StageName.sendKeys(Keys.DELETE);
			//StageName.sendKeys("Collect Travel info");
			StageName.sendKeys(stageName);
			pegaDriver.waitForDocStateReady(2);
			pegaDriver.findElement(By.xpath("//button[contains(@name,'pzCaseTypeScreensHelp_CaseTypeStages')]")).click(false);
			pegaDriver.waitForDocStateReady(5);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='field-item dataLabelWrite' and text()='Add processes?']")));
			
			//pegaDriver.findElement(By.xpath("//div[@node_name='pzCaseTypeScreens']")).click(false);
			//pegaDriver.findElement(By.xpath("//div[@node_name='pzCaseTypeScreens']")).click(false);
			//pegaDriver.findElement(By.xpath("//div[@section_index='1' and @class='layout-body clearfix']//div[contains(@data-click,'pzDoCaseDesignerAction')]")).click(false);
			
				Robot bot;
				try {
					bot = new Robot();
					bot.mouseMove(1680, 989);    
					bot.mousePress(InputEvent.BUTTON1_MASK);
					bot.mouseRelease(InputEvent.BUTTON1_MASK);
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			pegaDriver.waitForDocStateReady(2);
			pegaDriver.switchToActiveFrame();
			pegaDriver.findElement(By.xpath("//div[text()='Add processes?']")).click(false);
			pegaDriver.waitForDocStateReady(1);
			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchToActiveFrame();
			pegaDriver.findElement(By.xpath("//button[@class='Confirm pzhc']")).click(false);
			pegaDriver.switchToActiveFrame();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i[@class=' icons pi pi-caret-down']")));
			           
			pegaDriver.findElement(By.xpath("//i[@class=' icons pi pi-caret-down']")).click(false);

			pegaDriver.findElement(By.xpath("//span[text()='Add process']")).click(false);                  

			pegaDriver.findElement(By.xpath("//button[@title='Click to Save']"));
			pegaDriver.waitForDocStateReady(5);
			//pegaDriver.findElement(By.xpath("//button[contains(@name,'pzCaseTypeScreensHelp_CaseTypeStages')]")).click(false);
			//pegaDriver.waitForDocStateReady(2);
			pegaDriver.switchToActiveFrame();
			pegaDriver.findElement(By.xpath("//a[contains(@title,'"+stageName+"') and contains(@name,'pzDisplayCDCompatibleShapes')]")).click(false);
			pegaDriver.waitForDocStateReady(2);
			pegaDriver.switchToActiveFrame();
			pegaDriver.findElement(By.xpath("//button[contains(@name,'pzCaseTypeScreensHelp_CaseTypeStages')]")).click(false);
			pegaDriver.waitForDocStateReady(5);
			pegaDriver.switchToActiveFrame();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Configure view']")));
			pegaDriver.switchToActiveFrame();
			pegaDriver.findElement(By.xpath("//button[contains(@name,'pzCDFlowActionPropertyPanel')]")).click(false);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'View description goes here')]")));
			pegaDriver.findElement(By.xpath("//input[contains(@name,'$PSectionPage$ppyEmbeddedFields$l1$ppyLabel')]")).sendKeys("Travel date");
			pegaDriver.findElement(By.xpath("//input[contains(@name,'$PSectionPage$ppyEmbeddedFields$l1$ppyLabel')]")).sendKeys(Keys.TAB);
			pegaDriver.waitForDocStateReady(1);
			String frameId = pegaDriver.getActiveFrameId(false);
			Wizard newWizard = pegaDriver.findWizard(frameId);
			/*Select dropdown1 = new Select(pegaDriver.findElement(By.xpath("//select[contains(@name,'ppyPropertyType')]")));
			dropdown1.selectByVisibleText("Date only");*/
			DropDown opName = newWizard.findSelectBox(By.xpath("//select[contains(@name,'ppyPropertyType')]"));
			opName.selectByVisibleText("Date only");

			pegaDriver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click(false);
			pegaDriver.waitForDocStateReady(5);
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='field-item dataLabelWrite' and text()='Add processes?']")));
			pegaDriver.findElement(By.xpath("//button[@title='Click to Save']")).click(false);
			pegaDriver.waitForDocStateReady(5);
			
	}

	@Override
	public void modifyAccessGroup(){
		pegaDriver.waitForDocStateReady(2);
		WebDriverWait wait = new WebDriverWait(pegaDriver, 10);
	    pegaDriver.switchTo().defaultContent();
	    pegaDriver.findElement(By.xpath(CS_IMPL_OPERATOR_MENU_XPATH)).click();
	    pegaDriver.switchTo().defaultContent();
	    // List<WebElement> list = pegaDriver.findElements(By.xpath(CS_IMPL_LOG_OFF_XPATH));
	    pegaDriver.findElement(By.xpath(CS_IMPL_OPERATOR_XPATH)).click(false);
	   /* String frameId = pegaDriver.getActiveFrameId(false);
		WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
		pegaDriver.switchTo().frame(frameElmt);*/
	    pegaDriver.switchToActiveFrame();
	    //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Click to edit' and text()='CSC System Administrator']"))); 
	    pegaDriver.findElement(By.xpath("//input[@name='$PRH_$ppyaccessgroups_opid$l$ppyRadioButtonAG'][1]")).click(false);
	    pegaDriver.findElement(By.xpath("//button[@title='Save your changes to this record']")).click(false);
	    pegaDriver.waitForDocStateReady(2);
	   
	}


}
