package com.pega.cs;


import com.pega.Browser;
import com.pega.config.test.TestBase1S1D;

/**
 * @author Chanu
 * @since 11 Dec 2013
 */
public class TestEnvironmentImpl extends TestBase1S1D{
	
	@SuppressWarnings("unused")
	private static final String COPYRIGHT = "Copyright (c) 2014  Pegasystems Inc.";
	public static final String VERSION = "$Id: TestEnvironmentImpl.java 117333 2014-12-18 09:12:21Z SachinVellanki $";
	
	private Browser browser = null;
	
/*	public TestEnvironmentImpl(String browserName, DesiredCapabilities desiredCapabilities)
	{
		super(browserName, desiredCapabilities);
		
	}
	
	public TestEnvironmentImpl()
	{
		
		
	}*/

	@Override
	public Browser getBrowser() {
		if(browser==null)
		{
			browser = new com.pega.cs.BrowserImpl(this);
		}
		return browser;
	}
}
