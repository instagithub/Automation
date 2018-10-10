package com.pega.crm.pegamarketing.impl.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.impl.dialog.PegaModalDialog;
import com.pega.crm.pegamarketing.impl.rules.PegaRuleInstance;
import com.pega.crm.pegamarketing.pages.Strategy;
import com.pega.crm.pegamarketing.pages.Strategy.AddCustomFieldsDialog;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.Frame;

public class PegaStrategy extends PegaRuleInstance implements Strategy {

	public PegaStrategy(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	public void addCustomField(String name, String value) {
		findElement(CUSTOM_FIELDS_ADD_FIELD).click();
		AddCustomFieldsDialog addCustomFieldsDialog = new PegaAddCustomFieldsDialog(this);
		addCustomFieldsDialog.setNameAndValue(name, value);
		addCustomFieldsDialog.submit();
	}

	public boolean isCustomFieldAdded(String name, String value) {
		boolean isNamePresent = verifyElement(By.xpath("//table[@summary='pyCustomFields']//span[text()='"+name+"']"));
		boolean isValuePresent = value.equals(findElement(By.xpath("//table[@summary='pyCustomFields']//span[text()='"+name+"']/ancestor::td[1]/following-sibling::td[1]/div[@class='oflowDivM ']")).getText());
		return isNamePresent && isValuePresent;
	}

	public boolean isCheckedIn() {
		return verifyElement(CHECKOUT_BUTTON);
	}

	public class PegaAddCustomFieldsDialog extends PegaModalDialog implements AddCustomFieldsDialog{
		PegaWebElement elmt;
		PegaWebDriver pegaDriver;
		public PegaAddCustomFieldsDialog(Frame elmt) {
			super(elmt);
			this.elmt = elmt;
			pegaDriver = elmt.getTestEnvironment().getPegaDriver();
		}

		public void setNameAndValue(String name, String value) {
			elmt.findElement(By.id("pyCustomFieldName")).sendKeys(name+Keys.TAB);
			pegaDriver.waitForDocStateReady();
			elmt.findElement(By.id("pyCustomFieldValue")).sendKeys(value+Keys.TAB);
		}
		
	}
	
}
