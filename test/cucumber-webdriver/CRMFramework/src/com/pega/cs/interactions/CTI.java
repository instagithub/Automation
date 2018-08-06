package com.pega.cs.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.framework.PegaWebElement;
import com.pega.ri.Wizard;

public interface CTI extends Wizard{
	
	void changeCallLogionOption(String option);	
	void agentLogout();
	void acceptCall();
	void answerCall();

}
