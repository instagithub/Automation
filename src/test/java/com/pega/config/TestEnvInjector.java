package com.pega.config;

import com.google.inject.AbstractModule;
import com.pega.Browser;
import com.pega.MyBrowser;
import com.pega.MyTestEnvironment;
import com.pega.TestEnvironment;

public class TestEnvInjector extends AbstractModule {
	
	String COPYRIGHT = "Copyright (c) 2014  Pegasystems Inc.";
	String VERSION = "$Id: TestEnvInjector.java 174698 2016-02-08 08:24:26Z SachinVellanki $";
	 
    @Override
    protected void configure() {
    	
        //bind the service to implementation class
        bind(TestEnvironment.class).to(MyTestEnvironment.class);
        bind(Browser.class).to(MyBrowser.class);
        //bind(DesignerStudio.class).to(DesignerStudioImpl.class);
        //bind(CaseExplorer.class).to(CaseExplorerImpl.class);
    }
}
