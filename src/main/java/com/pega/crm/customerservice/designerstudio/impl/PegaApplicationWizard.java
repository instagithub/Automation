package com.pega.crm.customerservice.designerstudio.impl;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pega.TestEnvironment;
import com.pega.crm.customerservice.designerstudio.ApplicationWizard;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.ri.Wizard;
import com.pega.ri.WizardImpl;

public class PegaApplicationWizard extends WizardImpl implements ApplicationWizard {

	private static final String CS_IMPL_OPERATOR_MENU_XPATH = "//i[@title='CS Admin']";
	private static final String CS_IMPL_OPERATOR_XPATH = "//span[text()='Operator']";
	private static final String CS_IMPL_OPERATOR_MENU_XPATH_DS = "//i[@title='CSC Admin']";

	public PegaApplicationWizard(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
	}

	public void createNewApplication(String builton, String type, String organization) {
		WebDriverWait wait = new WebDriverWait(pegaDriver, 120);
		int s;

		s = (int) Math.ceil(Math.random() * 100);
		PegaWebElement webElement = findElement(By.xpath("//span/input[@id='pyApplicationNameAsEntered']"));
		webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		webElement.sendKeys(Keys.DELETE);
		webElement.sendKeys("Test" + s);

		DropDown builtOn = findSelectBox(By.xpath("//select[@name='$PpyWorkPage$ppyBasedOnFrameworkNameAndVersion']"));
		builtOn.selectByVisibleText(builton);
		PegaWebElement orgName = findElement(By.xpath("//input[@id='pyOrganizationName']"));
		orgName.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		orgName.sendKeys(Keys.DELETE);
		orgName.sendKeys(organization);

	
		DropDown structure = findSelectBox(By.xpath("//select[@name='$PpyWorkPage$ppyCreateLayerOptionSelected']"));
		structure.selectByVisibleText(type);

		findElement(By.xpath("//div[text()='Next >']")).click(false);
		
		int i = findElements(By.xpath("//span[@id='PegaRULESErrorFlag']")).size();
		System.out.println(i);
		if (i != 0) {

			createNewApplication(builton, type, organization);
		} else {
			

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Add business objective']")));

			findElement(By.xpath("//div[text()='Next >']")).click(false);
			

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[text()='" + builton + "']")));
			findElement(By.xpath("//div[text()='Next >']")).click(false);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//div[contains(text(),'Please address any issue(s) and review the class groups before generating this application')]")));
			int j = findElements(By.xpath("//div[contains(text(),'This application has  1 case(s) with naming conflicts')]")).size();
			if (j != 0) {
				PegaWebElement survey = findElement(By.xpath("//input[@id='pyNameNodeToken' and @value='Survey']"));
				survey.sendKeys(Keys.chord(Keys.CONTROL, "a"));
				survey.sendKeys(Keys.DELETE);
				survey.sendKeys("survey1");
			}
			findElement(By.xpath("//div[text()='Next >']")).click(false);
		
			findElement(By.xpath("//div[text()='Create']")).click(false);
			

		}
	}

	@Override
	public void createNewCase(String caseName, String stageName) {
		findElement(By.xpath("//label[text()='Cases']")).click(false);
		WebDriverWait wait = new WebDriverWait(pegaDriver, 1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Add a case type']")));
		findElement(By.xpath("//a[text()='Add a case type']")).click(false);
		
		// switching to a modal dialog
		Set<String> handles = pegaDriver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		String firstHandle = itr.next();
		String lastHandle = firstHandle;
		while (itr.hasNext()) {
			lastHandle = itr.next();
		}
		pegaDriver.switchTo().window(lastHandle);
		PegaWebElement casename = findElement(By.xpath("//input[@placeholder='Case type name']"));
		casename.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		casename.sendKeys(Keys.DELETE);
		casename.sendKeys(caseName);
		
		findElement(By.xpath("//button[contains(@name,'pzModalEditorButtons_D_pzCaseTypeConfiguration')][1]")).click(false);
	
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='" + caseName + "']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Edit case type:']")));
		findElement(By.xpath("//label[text()='Life cycle']")).click(false);
		findElement(By.xpath("//button[contains(@name,'pzManageCaseTypeStages_CaseTypeStages')]")).click(false);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='$PCaseTypeStages$ppyStages$l1$ppyStageName']")));

		PegaWebElement StageName = findElement(By.xpath("//input[@name='$PCaseTypeStages$ppyStages$l1$ppyStageName']"));
		StageName.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		StageName.sendKeys(Keys.DELETE);
		StageName.sendKeys(stageName);
		findElement(By.xpath("//button[contains(@name,'pzCaseTypeScreensHelp_CaseTypeStages')]")).click(false);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='field-item dataLabelWrite' and text()='Add processes?']")));

		
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

		findElement(By.xpath("//div[text()='Add processes?']")).click(false);
		findElement(By.xpath("//button[@class='Confirm pzhc']")).click(false);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i[@class=' icons pi pi-caret-down']")));

		findElement(By.xpath("//i[@class=' icons pi pi-caret-down']")).click(false);
		findElement(By.xpath("//span[text()='Add process']")).click(false);
		findElement(By.xpath("//button[@title='Click to Save']"));
		findElement(By.xpath("//a[contains(@title,'" + stageName + "') and contains(@name,'pzDisplayCDCompatibleShapes')]")).click(false);
		findElement(By.xpath("//button[contains(@name,'pzCaseTypeScreensHelp_CaseTypeStages')]")).click(false);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Configure view']")));
		
		findElement(By.xpath("//button[contains(@name,'pzCDFlowActionPropertyPanel')]")).click(false);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'View description goes here')]")));
		findElement(By.xpath("//input[contains(@name,'$PSectionPage$ppyEmbeddedFields$l1$ppyLabel')]")).sendKeys("Travel date");
		findElement(By.xpath("//input[contains(@name,'$PSectionPage$ppyEmbeddedFields$l1$ppyLabel')]")).sendKeys(Keys.TAB);
		
		
		
		DropDown opName = findSelectBox(By.xpath("//select[contains(@name,'ppyPropertyType')]"));
		opName.selectByVisibleText("Date only");

		findElement(By.xpath("//button[contains(text(),'Submit')]")).click(false);
		findElement(By.xpath("//button[@title='Click to Save']")).click(false);
		

	}

	@Override
	public void modifyAccessGroup() {
		findElement(By.xpath(CS_IMPL_OPERATOR_MENU_XPATH)).click();
		findElement(By.xpath(CS_IMPL_OPERATOR_XPATH)).click(false);
		findElement(By.xpath("//input[@name='$PRH_$ppyaccessgroups_opid$l$ppyRadioButtonAG'][1]")).click(false);
		findElement(By.xpath("//button[@title='Save your changes to this record']")).click(false);
		
		
		

	}

}
