package com.pega.crm.salesautomation.workobjects;


import com.pega.ri.Wizard;

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