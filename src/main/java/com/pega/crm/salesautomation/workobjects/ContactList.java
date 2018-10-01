package salesautomation.workobjects;

import com.pega.ri.Wizard;
import salesautomation.workobjects.impl.PegaUtil;
import com.pega.util.XPathUtil;

public interface ContactList extends Wizard
{
	
	String CREATE_CONT_BTN_XPATH = PegaUtil.getStrongButtonXPath("Create contact");  
	String CONT_SEARCH_FIELD_ID = "FilterTermForContact";
	String CONT_FILTER_PLACEHOLDER_XPATH = "//input[@placeholder='Filter Contact']";
	String CONT_FILTERBUTTON_XPATH=PegaUtil.getButtonXpath("Filter");
	String CONT_NAME_XPATH="//table[@id='gridLayoutTable']//tr[@aria-rowindex='1']//a[1]";
	String NO_CONTACTS_XPATH = "//tr[@id='Grid_NoResults']";
	Contact createContact();
	Contact navigateContact(StringBuffer contactName);
	Contact navigateContact(String contactName);
	Contact openFirstContact();
	boolean isContactListEmpty();
}
