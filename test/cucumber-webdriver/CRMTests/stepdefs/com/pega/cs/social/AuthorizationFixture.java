package com.pega.cs.social;

import com.pega.MyTestEnvironment;
import com.pega.cs.SocialPortal;
import com.pega.cs.impl.SocialPortalImpl;
import com.pega.framework.PegaWebDriver;
import com.google.inject.Inject;

import cucumber.api.java.en.Then;
import cucumber.runtime.java.guice.ScenarioScoped;


@ScenarioScoped

public class AuthorizationFixture {

	private SocialPortal socialPortal;
	private PegaWebDriver pegaDriver;
	
	@Inject
	public AuthorizationFixture(MyTestEnvironment testEnv)
	{
		socialPortal = new SocialPortalImpl(testEnv);
		pegaDriver = testEnv.getPegaDriver();
	}

	@Then("^Launch Preferences$")
	public void launch_Preferences() throws Throwable {

		socialPortal.launchPreferences();
	}

	@Then("^Complete \"([^\"]*)\" Authorization with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void complete_Authorization_with_and(String source, String userID, String pwd) {

		socialPortal.authorizeCSR(source, userID, pwd);
	}

}
