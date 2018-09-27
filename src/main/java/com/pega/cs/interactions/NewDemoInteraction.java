package com.pega.cs.interactions;

public interface NewDemoInteraction extends Interactions {
	
	String ACCEPT_CALL_XPATH = "//div[@class='pzbtn-mid' and text()='Accept']";
	
	//void declineCall();
	
	void acceptCall();
	//void addTask();

}
