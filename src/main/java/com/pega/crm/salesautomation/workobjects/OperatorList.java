package salesautomation.workobjects;


import com.pega.ri.Wizard;
import com.pega.util.XPathUtil;

public interface OperatorList extends Wizard {

Operator creasteOperator();
OperatorList searchOperator(String orgName);
Operator navigateOperator();
boolean isOperatorListEmpty();
Operator openFirstOperator();
boolean verifyOperatorListPage();
boolean validateListPage();
boolean validateOprListPage();

}