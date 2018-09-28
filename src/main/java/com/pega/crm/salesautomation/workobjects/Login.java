package salesautomation.workobjects;

import com.pega.ri.Wizard;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.pega.framework.PegaWebElement;
import com.pega.ri.WizardImpl;
import com.pega.util.XPathUtil;

public interface Login extends Wizard {
	
	public String MYWORK_LISTPAGE="//span[text()='My Work']";
	public String WORK_LIST_XPATH="//h2[text()='Work list']";
	public String TO_DO_LIST_XPATH="//h2[text()='To-do list']";
	public String SUGGESTED_VISITS_XPATH="//h2[text()='Suggested visits']";
	public void validateOperator(String Title);
	public ArrayList<String> validateLeftNav();
	//public void validateLeftNav(String operator);
	public void clickMyWork();
	public boolean verifyWorkListSection();
	public boolean verifyToDoList();
	public boolean verifySuggestedVisits();

}
