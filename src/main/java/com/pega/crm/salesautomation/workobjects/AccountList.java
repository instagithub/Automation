package salesautomation.workobjects;

import java.util.ArrayList;

import com.pega.ri.Wizard;

public interface AccountList extends Wizard
{
	Accounts createAccount();
	Accounts navigateAccount(String accountName);
	Accounts navigateAccount(StringBuffer accountName);
	Accounts openFirstAccount();
	Boolean isAccountListEmpty();
	boolean isCreateButtonDisplayed();
	boolean isFilterTextBoxDisplayed();
	String getFilterPlaceHolder();
	boolean isFilterButtonDisplayed();
	boolean isAllButtonDisplayed();
	boolean isBusinessButtonDisplayed();
	boolean isIndividualButtonDisplayed();
	boolean isExportButtonDisplayed();
	boolean isRefreshButtonDisplayed();
	ArrayList<String> getTableHeaders();
	
}
