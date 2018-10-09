package salesautomation.workobjects;


import com.pega.ri.Wizard;
import com.pega.util.XPathUtil;

public interface OperatorList extends Wizard {

Operators creasteOperator();
OperatorList searchOperator(String orgName);
Operators navigateOperator();
boolean isOperatorListEmpty();
Operators openFirstOperator();
boolean verifyOperatorListPage();
boolean validateListPage();
boolean validateOprListPage();

}