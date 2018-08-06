package com.pega.explorer;

import com.google.inject.Inject;
import com.pega.TestEnvironment;

import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class MyDesignerStudio extends DesignerStudioImpl{
	
	String COPYRIGHT = "Copyright (c) 2014  Pegasystems Inc.";
	String VERSION = "$Id: MyDesignerStudio.java 186537 2016-04-10 05:18:30Z SachinVellanki $";
	
	TestEnvironment testEnv;
	

	@Inject
	public MyDesignerStudio(TestEnvironment testEnv) {
		super(testEnv);
		this.testEnv = testEnv;
	}
	
	@When("^user closes current tab$")
	public void closeCurrentTab() {
		 super.closeCurrentTab();
	}
}
