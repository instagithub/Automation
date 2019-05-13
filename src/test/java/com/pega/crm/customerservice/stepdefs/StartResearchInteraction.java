package com.pega.crm.customerservice.stepdefs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.google.inject.Inject;
import com.pega.CRMTestEnvironment;
import com.pega.TestEnvironment;
import com.pega.crm.customerservice.CSPortal;
import com.pega.crm.customerservice.interactions.Interactions;
import com.pega.crm.customerservice.interactions.PhoneCall;
import com.pega.crm.customerservice.interactions.ResearchInteraction;
import com.pega.crm.customerservice.interactions.impl.PegaNewInboundInteraction;
import com.pega.crm.customerservice.utils.CommonMethods;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.ri.Wizard;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped

public class StartResearchInteraction {

	private ResearchInteraction researchInteraction;
	private Interactions interaction;
	private PegaNewInboundInteraction inboundInteraction;
	private CommonMethods commonMethods;
	private PegaWebDriver pegaDriver;
	TestEnvironment testEnv;
	private CSPortal csPortal;
	public String frameId = null;
	public Wizard newWizard = null;
	public List<String> caseId = new ArrayList();
	public String[] caseStatus = new String[10];

	@Inject
	public StartResearchInteraction(NewTopNav topNavFixture, CRMTestEnvironment testEnv) {
		researchInteraction = topNavFixture.getResearchInteraction();
		interaction = topNavFixture.getInteractions();
		commonMethods = testEnv.getCommonMethods();
		pegaDriver = testEnv.getPegaDriver();

	}



	@Then("^verify left nav, header and composite sections for \"([^\"]*)\"$")
	public void verify_left_nav_header_and_composite_sections_for(String searchName)  {
		Assert.assertTrue("Lifetime header is not present",
				researchInteraction.verifyElement(By.xpath(PhoneCall.LIFETIME_XPATH)));
		Assert.assertTrue("Chrun risk is not present",
				researchInteraction.verifyElement(By.xpath(PhoneCall.CHURN_RISK_XPATH)));
		Assert.assertTrue("Customer since field is not present",
				researchInteraction.verifyElement(By.xpath(PhoneCall.CUSTOMER_SINCE_XPATH)));
		Assert.assertTrue("Call back field is not present",
				researchInteraction.verifyElement(By.xpath(PhoneCall.CALL1_BACK_XPATH)));

		String name = researchInteraction.findElement(By.xpath("//span[@class='interaction_header_title']")).getText();

		Assert.assertTrue("Call back field is not present",name.contains(searchName));

		Assert.assertTrue("Add Task button is not present",
				researchInteraction.verifyElement(By.xpath("//button[@title='Add Task']")));
		Assert.assertTrue("Wrap up button is not present",
				researchInteraction.verifyElement(By.xpath("//button[@class='Wrap_up_button pzhc pzbutton' and @title='Close']")));
		Assert.assertTrue("Overview tab is not present", researchInteraction.verifyElement(By.xpath("//h3[@class='layout-group-item-title'][text()='Overview']")));
		Assert.assertTrue("Notes tab is not present", researchInteraction.verifyElement(By.xpath("//h3[text()='Notes']")));
		Assert.assertTrue("News tab is not present", researchInteraction.verifyElement(By.xpath("//h3[text()='News']")));
		Assert.assertTrue("Recent service case section is not present",
				researchInteraction.verifyElement(By.xpath("//h2[text()='Recent cases']")));
		Assert.assertTrue("Recent Interactions section is not present",
				researchInteraction.verifyElement(By.xpath("//h2[text()='Recent interactions']")));
		Assert.assertTrue("Recent Sales engagements section is not present",
				researchInteraction.verifyElement(By.xpath("//h2[text()='Sales activities']")));
		
	}

	@Then("^verify \"([^\"]*)\" category under AddTask$")
	public void verify_category_under_AddTask(String category) {
		if(category.equalsIgnoreCase("contact"))
		{
			Assert.assertTrue("Modify account Links task is not present", researchInteraction.verifyElement(By.xpath("//a[@class='Add_task'][text()='Modify Account Links']")));
			Assert.assertTrue("Modify Contact to Organization Links task is not present", researchInteraction.verifyElement(By.xpath("//a[@class='Add_task'][text()='Modify Contact to Organization Links']")));
			Assert.assertTrue("Update Contact Profile task is not present", researchInteraction.verifyElement(By.xpath("//a[@class='Add_task'][text()='Update Contact Profile']")));
		}
		else if(category.equalsIgnoreCase("general"))
		{

			Assert.assertTrue("Send Correspondence task is not present", researchInteraction.verifyElement(By.xpath("//a[@class='Add_task'][text()='Send Correspondence']")));
			Assert.assertTrue("General service request task is not present", researchInteraction.verifyElement(By.xpath("//a[@class='Add_task'][text()='General Service Request']")));
			Assert.assertTrue("Open new account task is not present", researchInteraction.verifyElement(By.xpath("//a[@class='Add_task'][text()='Open New Account']")));
			Assert.assertTrue("Add new Organization task is not present", researchInteraction.verifyElement(By.xpath("//a[@class='Add_task'][text()='Add New Organization']")));
			Assert.assertTrue("schedule activity task is not present", researchInteraction.verifyElement(By.xpath("//a[@class='Add_task'][text()='Schedule Activity']")));
		}
		else if(category.equalsIgnoreCase("account")){

			Assert.assertTrue("Address Change is not present", researchInteraction.verifyElement(By.xpath("//a[contains(@title,'Address Change') and @class='Add_task']")));
			Assert.assertTrue("Close account task is not present", researchInteraction.verifyElement(By.xpath("//a[@class='Add_task'][text()='Close Account']")));
			Assert.assertTrue("Modify contact links task is not present", researchInteraction.verifyElement(By.xpath("//a[@class='Add_task'][text()='Modify Contact Links']")));
			Assert.assertTrue("Dispute transaction task is not present", researchInteraction.verifyElement(By.xpath("//a[@class='Add_task'][text()='Dispute Transaction']")));
			Assert.assertTrue("Lost or stolen card task is not present", researchInteraction.verifyElement(By.xpath("//a[@class='Add_task'][text()='Lost or Stolen Card']")));
			Assert.assertTrue("Statement copy task is not present", researchInteraction.verifyElement(By.xpath("//a[@class='Add_task'][text()='Statement Copy']")));
		}
		else if(category.equalsIgnoreCase("Organization")){
			Assert.assertTrue("Update Organization Profile is not present", researchInteraction.verifyElement(By.xpath("//a[@class='Add_task'][text()='Update Organization Profile']")));
			Assert.assertTrue("Modify organization links", researchInteraction.verifyElement(By.xpath("//a[@class='Add_task'][text()='Modify Organization Links']")));
		}

	}

	@Then("^verify confirm message, case name and status$")
	public void verify_confirm_message_case_name_and_status() {


		Assert.assertTrue("Confirmation message is not present",
				researchInteraction.verifyElement(By.xpath("//div[contains(text(),'has been created successfully')]")));
		Assert.assertTrue("Service case name is not present",
				researchInteraction.verifyElement(By.xpath("//span[text()='Complaint or Compliment']")));
		Assert.assertTrue("Service case status is not present", pegaDriver
				.verifyElement(By.xpath("//span[text()='Open'][@data-test-id='201602220830460492170260']")));

	}


	@When("^close the research interaction$")
	public void close_the_research_interaction() {
		interaction.closeInteraction();


	}

	@Then("^verify left nav, header and composite sections for Account with \"([^\"]*)\"$")
	public void verify_left_nav_header_and_composite_sections_for_Account_with(String accNum) {
		Assert.assertTrue("Add Task button is not present",
				researchInteraction.verifyElement(By.xpath("//button[@title='Add Task']")));
		Assert.assertTrue("Wrap up button is not present",
				researchInteraction.verifyElement(By.xpath("//button[@class='Wrap_up_button pzhc pzbutton' and @title='Close']")));
		Assert.assertTrue("Overview tab is not present", researchInteraction.verifyElement(By.xpath("//h3[@class='layout-group-item-title'][text()='Overview']")));
		Assert.assertTrue("Notes tab is not present", researchInteraction.verifyElement(By.xpath("//h3[text()='Notes']")));
		Assert.assertTrue("Recent service case section is not present",
				researchInteraction.verifyElement(By.xpath("//h2[text()='Recent cases']")));
		Assert.assertTrue("Recent Interactions section is not present",
				researchInteraction.verifyElement(By.xpath("//h2[text()='Recent interactions']")));
		Assert.assertTrue("Transactions section is not present",
				researchInteraction.verifyElement(By.xpath("//h2[text()='Transactions']")));
		Assert.assertTrue("Statements section is not present",
				researchInteraction.verifyElement(By.xpath("//h2[text()='Statements']")));
		}


	@Then("^verify the empty search results$")
	public void verify_the_empty_search_results() {

		int labelDisplayed=researchInteraction.findElements(By.xpath("//div[contains(text(),'result for')]")).size();//Updated by Prasanna Modugu
		Assert.assertFalse("Records displayed", labelDisplayed>0);
		
	}

	@Then("^select secondary address as primary address and click submit$")
	public void select_secondary_address_as_primary_address_and_click_submit(){
		
		PegaWebElement uncheckBox = newWizard.findElement(By.xpath("//input[@title='Make Primary']"));
		if(!uncheckBox.isSelected()){
		uncheckBox.click();
		}
		researchInteraction.findElement(By.xpath("//button[@title='Complete this assignment']")).click();


	}

	@Then("^verify left nav, header and composite sections for orginization with \"([^\"]*)\"$")
	public void verify_left_nav_header_and_composite_sections_for_orginization_with(String orgName) throws Throwable {
		Assert.assertTrue("Add Task button is not present",
				researchInteraction.verifyElement(By.xpath("//button[@title='Add Task']")));
		Assert.assertTrue("Wrap up button is not present",
				researchInteraction.verifyElement(By.xpath("//*[contains(@class,'Wrap_up') and contains(@title,'Close')]")));//changed from //a[@class='Wrap_up' and @title='Close']
		Assert.assertTrue("Organizations tab is not present", researchInteraction.verifyElement(By.xpath("//h3[@class='layout-group-item-title'][text()='Organization']")));
		Assert.assertTrue("News tab is not present", researchInteraction.verifyElement(By.xpath("//h3[text()='News']")));
		//Assert.assertTrue("Opportunities tab is not present", researchInteraction.verifyElement(By.xpath("//h3[text()='Opportunities']")));
		Assert.assertTrue("Customer Account Summary section is not present",
				researchInteraction.verifyElement(By.xpath("//h2[text()='Customer account summary']")));
		Assert.assertTrue("Recent service case section is not present",
				researchInteraction.verifyElement(By.xpath("//h2[text()='Recent cases']")));
		Assert.assertTrue("Recent Interactions section is not present",
				researchInteraction.verifyElement(By.xpath("//h2[text()='Recent interactions']")));
		Assert.assertTrue("Customers section is not present",
				researchInteraction.verifyElement(By.xpath("//h2[text()='Customers']")));
		Assert.assertTrue("Organization section is not present",
				researchInteraction.verifyElement(By.xpath("//h2[text()='Organization hierarchy']")));

	}


	@Then("^Verify the left nav header and search results$")
	public void verify_the_left_nav_header_and_search_results() {
		

		Assert.assertTrue("Search button is not present",
				researchInteraction.verifyElement(By.xpath("//button[@title='Search']")));
		Assert.assertTrue("Clear button is not present",
				researchInteraction.verifyElement(By.xpath("//button[@title='Clear']")));

		Assert.assertTrue("Account Number header is not present",
				researchInteraction.verifyElement(By.xpath("//label[text()='Account number']")));
		Assert.assertTrue("Type header is not present",
				researchInteraction.verifyElement(By.xpath("//label[text()='Account type']")));
		Assert.assertTrue("Status header is not present",
				researchInteraction.verifyElement(By.xpath("//label[text()='Status']")));
		Assert.assertTrue("Account open date header is not present",
				researchInteraction.verifyElement(By.xpath("//label[text()='Account open date']")));
		

	}

	@Then("^Verify the left nav header and search results for \"([^\"]*)\"$")
	public void verify_the_left_nav_header_and_search_results_for(String orgName) throws Throwable {
		

		Assert.assertTrue("Search button is not present",
				researchInteraction.verifyElement(By.xpath("//button[@title='Search']")));
		Assert.assertTrue("Clear button is not present",
				researchInteraction.verifyElement(By.xpath("//button[@title='Clear']")));

		//Verify the search types displayed

		Assert.assertTrue("Organization name header is not present",
				researchInteraction.verifyElement(By.xpath("//label[text()='Organization']")));
		//Assert.assertTrue("Type header is not present",researchInteraction.verifyElement(By.xpath("//label[text()='Type']")));
		Assert.assertTrue("Tax ID header is not present",
				researchInteraction.verifyElement(By.xpath("//label[text()='Tax ID']")));
		Assert.assertTrue("Industry header is not present",
				researchInteraction.verifyElement(By.xpath("//label[text()='Industry']")));
		/*Assert.assertTrue("Owner header is not present",
				researchInteraction.verifyElement(By.xpath("//label[text()='Owner']")));*/
		Assert.assertTrue("Country header is not present",
				researchInteraction.verifyElement(By.xpath("//label[text()='Country']")));
		Assert.assertTrue("City header is not present",
				researchInteraction.verifyElement(By.xpath("//label[text()='City']")));
		Assert.assertTrue("State header is not present",
				researchInteraction.verifyElement(By.xpath("//label[text()='State']")));

		//check for the organizations displayed

		Assert.assertTrue("Acme Anvils is not present",
				researchInteraction.verifyElement(By.xpath("//span[text()='Acme Anvils']")));
		Assert.assertTrue("Acme Parachutes is not present",
				researchInteraction.verifyElement(By.xpath("//span[text()='Acme Parachutes']")));
		Assert.assertTrue("Acme Robots is not present",
				researchInteraction.verifyElement(By.xpath("//span[text()='Acme Robots']")));
		Assert.assertTrue("Acme Software is not present",
				researchInteraction.verifyElement(By.xpath("//span[text()='Acme Software']")));
		//Assert.assertTrue("Acme Technology Group is not present",researchInteraction.verifyElement(By.xpath("//span/a[text()='Acme Technology Group']")));

	}


	@Then("^verify the result displayed for the \"([^\"]*)\" filter$")
	public void verify_the_result_displayed_for_the_filter(String filter) {
		
		if(filter.equalsIgnoreCase("12345000")){
			Assert.assertTrue("12345000 is not present",
					researchInteraction.verifyElement(By.xpath("//span/a[contains(text(),'1234500078963456')]")));

		}

		if(filter.equalsIgnoreCase("Acme Software")){
			Assert.assertTrue("Acme Software is not present",
					researchInteraction.verifyElement(By.xpath("//span[contains(text(),'Acme Software')]")));
			Assert.assertTrue("Industry is not present",
					researchInteraction.verifyElement(By.xpath("//div[@class='oflowDivM ']/span[contains(text(),'MEDIA')]")));
			Assert.assertTrue("Country is not present",
					researchInteraction.verifyElement(By.xpath("//div[@class='oflowDivM ']/span[contains(text(),'USA')]")));
			Assert.assertTrue("City is not present",
					researchInteraction.verifyElement(By.xpath("//div[@class='oflowDivM ']/span[contains(text(),'Boston')]")));
			Assert.assertTrue("State is not present",
					researchInteraction.verifyElement(By.xpath("//div[@class='oflowDivM ']/span[contains(text(),'MA')]")));
		}


		if(filter.equalsIgnoreCase("Rebecca")){
			Assert.assertTrue("Rebecca is not present",
					researchInteraction.verifyElement(By.xpath("//span[contains(text(),'Rebecca')]")));

		}

		if(filter.equalsIgnoreCase("Credit Card Fees & Charges")){
			Assert.assertTrue("Credit Card Fees & Charges title is not present",
					researchInteraction.verifyElement(By.xpath("//span/a[contains(text(),'Credit card fees & charges')]")));

		}
		
		if(filter.equalsIgnoreCase("Understanding Foreign Transaction Fees")){
			Assert.assertTrue("Understanding Foreign Transaction Fees title is not present",
					researchInteraction.verifyElement(By.xpath("//span/a[contains(text(),'Understanding Foreign Transaction Fees')]")));
			Assert.assertTrue("Authored title is not present",
					researchInteraction.verifyElement(By.xpath("//span[contains(text(),'Authored')]")));

		}
	}
	@When("^Click on Favorites$")
	public void click_on_Favorites() throws Throwable {
		String Favorites= "//i[@title='Add to Favorites']";
		PegaWebElement FavoritesIcon = researchInteraction.findElement(By.xpath(Favorites));
		FavoritesIcon.click();
	}
	@When("^Validate Favorites details \"([^\"]*)\" in My Favorites$")
	public void validate_Favorites_details_in_My_Favorites(String arg1) throws Throwable {
	
		String Refresh= "//i[@class='icons pi pi-refresh pi-blue']";
		PegaWebElement RefreshIcon = researchInteraction.findElement(By.xpath(Refresh));
		RefreshIcon.click();
		Assert.assertTrue("Favorites is Validated",
				researchInteraction.verifyElement(By.xpath("//a[contains(text(),'Rebecca')]")));
	}
	@When("^Favorites already Exist in My Favorites$")
	public void favorites_already_Exist_in_My_Favorites() throws Throwable {
	   	if(researchInteraction.verifyElement(By.xpath("//a[contains(@title,'Remove favourite')]"))){
			String Remove = "//a[contains(@title,'Remove favourite')]";
			PegaWebElement RemoveButton = researchInteraction.findElement(By.xpath(Remove));
			RemoveButton.click();
		
		}
	}

	


	@Then("^verify the title and account details for \"([^\"]*)\"$")
	public void verify_the_title_and_account_details_for(String account)  {
	
		if(account.equalsIgnoreCase("12345000")){
			Assert.assertTrue("Account number is not present",
					researchInteraction.verifyElement(By.xpath("//span[contains(text(),'12345000')]")));
			Assert.assertTrue("Account header is not present",
					researchInteraction.verifyElement(By.xpath("//span[text()='Account']")));
			Assert.assertTrue("Owner header is not present",
					researchInteraction.verifyElement(By.xpath("//label[text()='Owner:']")));
			Assert.assertTrue("Owner name is not present",
					researchInteraction.verifyElement(By.xpath("//span/a[text()='Sara Connor']")));
			Assert.assertTrue("Type header is not present",
					researchInteraction.verifyElement(By.xpath("//span[text()='Type:']")));
			Assert.assertTrue("Type header is not present",
					researchInteraction.verifyElement(By.xpath("//span[text()='Credit Card']")));
			Assert.assertTrue("Type header is not present",
					researchInteraction.verifyElement(By.xpath("//img[@src='webwb/addtofavouriteoff_13429280830.svg!!.svg']")));
		}

		if(account.equalsIgnoreCase("Acme Software")){
			
			Assert.assertTrue("Org Name is not present",
					researchInteraction.verifyElement(By.xpath("//span[contains(text(),'Acme Software')]")));
			Assert.assertTrue("Reason field is not present",
					researchInteraction.verifyElement(By.xpath("//span[contains(text(),'Reason')]")));
			Assert.assertTrue("Status field is not present",
					researchInteraction.verifyElement(By.xpath("//span[contains(text(),'Status')]")));
			Assert.assertTrue("Phone field is not present",
					researchInteraction.verifyElement(By.xpath("//span[contains(text(),'Phone')]")));
			Assert.assertTrue("Email field is not present",researchInteraction.verifyElement(By.xpath("//span[text()='Email']")));
			Assert.assertTrue("Address field is not present",
					researchInteraction.verifyElement(By.xpath("//span[contains(text(),'Address')]")));
			
			Assert.assertTrue("Organization type field is not present",
					researchInteraction.verifyElement(By.xpath("//span[contains(text(),'Organization type')]")));
			Assert.assertTrue("Total revenue field is not present",
					researchInteraction.verifyElement(By.xpath("//span[contains(text(),'Total revenue')]")));
			Assert.assertTrue("Industry field is not present",
					researchInteraction.verifyElement(By.xpath("//span[contains(text(),'Industry')]")));
			Assert.assertTrue("Website field is not present",
					researchInteraction.verifyElement(By.xpath("//span[contains(text(),'Website')]")));
			
			Assert.assertTrue("Twitter Id field is not present",
					researchInteraction.verifyElement(By.xpath("//span[contains(text(),'Twitter Id')]")));
			Assert.assertTrue("Tax ID field is not present",
					researchInteraction.verifyElement(By.xpath("//span[contains(text(),'Tax ID')]")));
			Assert.assertTrue("LinkedinURL field is not present",
					researchInteraction.verifyElement(By.xpath("//span[contains(text(),'LinkedinURL')]")));
			Assert.assertTrue("Organization Since field is not present",
					researchInteraction.verifyElement(By.xpath("//span[contains(text(),'Organization Since')]")));
			}
		if(account.equalsIgnoreCase("Rebecca")){
			Assert.assertTrue("Org Name is not present",
					researchInteraction.verifyElement(By.xpath("//span[contains(text(),'Rebecca  Biggs')]")));
			}
		if(account.equalsIgnoreCase("Connor")){
			Assert.assertTrue("Connor name is not present",
					researchInteraction.verifyElement(By.xpath("//span[contains(text(),'Sara') and contains(text(),'Connor')]")));
			
		}
		
	}


	@Then("^Verify the left nav header and search results for biggs$")
	public void verify_the_left_nav_header_and_search_results_for_biggs() {
		Assert.assertTrue("Search button is not present",
				researchInteraction.verifyElement(By.xpath("//button[@title='Search']")));
		Assert.assertTrue("Search button is not present",
				researchInteraction.verifyElement(By.xpath("//button[@title='Clear']")));

		//check for the results displayed

		Assert.assertTrue("Rebecca is not present",
				researchInteraction.verifyElement(By.xpath("//span[text()='Rebecca']")));
		//Assert.assertTrue("Jo Anne is not present",researchInteraction.verifyElement(By.xpath("//span[text()='Jo Anne']")));

		//Verify the search types displayed

		Assert.assertTrue("First name header is not present",researchInteraction.verifyElement(By.xpath("//label[text()='First name']")));
		Assert.assertTrue("Last name header is not present",researchInteraction.verifyElement(By.xpath("//label[text()='Last name']")));
		//Assert.assertTrue("Organization header is not present",researchInteraction.verifyElement(By.xpath("//label[text()='Organization']")));
		Assert.assertTrue("SSN header is not present",researchInteraction.verifyElement(By.xpath("//label[text()='SSN']")));
		//Assert.assertTrue("Phone header is not present",researchInteraction.verifyElement(By.xpath("//label[text()='Phone number']")));
		Assert.assertTrue("Email header is not present",researchInteraction.verifyElement(By.xpath("//label[text()='Email']")));
		Assert.assertTrue("City header is not present",researchInteraction.verifyElement(By.xpath("//label[text()='City']")));
		

	}


	@Then("^Verify the search results for \"([^\"]*)\" content$")
	public void verify_the_search_results_for_content(String contentType) {
		Assert.assertTrue("Search button is not present",
				researchInteraction.verifyElement(By.xpath("//button[@title='Search']")));
		Assert.assertTrue("Search button is not present",
				researchInteraction.verifyElement(By.xpath("//button[@title='Clear']")));

		//verify the left nav headers
		Assert.assertTrue("Article Title header is not present",researchInteraction.verifyElement(By.xpath("//label[text()='Article title']")));
		Assert.assertTrue("Content Title header is not present",researchInteraction.verifyElement(By.xpath("//label[text()='Content type']")));
		Assert.assertTrue("Average Rating Title header is not present",researchInteraction.verifyElement(By.xpath("//label[text()='Average rating (>)']")));
		Assert.assertTrue("Content Views Title header is not present",researchInteraction.verifyElement(By.xpath("//label[text()='Content views (>)']")));


		if(contentType.equalsIgnoreCase("fees")){
			//verify the results displayed

			Assert.assertTrue("Understanding Forigen is not present",
					researchInteraction.verifyElement(By.xpath("//span/a[text()='Understanding Foreign Transaction Fees']")));
			//Assert.assertTrue("Apply for auto loan is not present",researchInteraction.verifyElement(By.xpath("//span/a[text()='Applying for an auto loan']")));
			Assert.assertTrue("Credit Card Fees & Charges is not present",
					researchInteraction.verifyElement(By.xpath("//span/a[text()='Credit card fees & charges']")));
			
		}

	}


	@Then("^Verify the icon present in the new window and switch back$")
	public void verify_the_icon_present_in_the_new_window_and_switch_back() {
		
		String Parent_Window = pegaDriver.getWindowHandle();
		
		Set<String> handles =  pegaDriver.getWindowHandles();

		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(Parent_Window))
			{
				pegaDriver.switchTo().window(windowHandle);
				//Assert.assertTrue("Rate article is not present",researchInteraction.verifyElement(By.xpath("//div[text()='Rate article']")));

				Assert.assertTrue("like icon is not present",
						researchInteraction.verifyElement(By.xpath("//i[@title='Like article']")));

				Assert.assertTrue("dislike icon is not present",
						researchInteraction.verifyElement(By.xpath("//i[@title='Dislike article']")));

				researchInteraction.close();
				pegaDriver.switchTo().window(Parent_Window);


			}

		}
	}


	@When("^CSR searches for \"([^\"]*)\" research interaction under \"([^\"]*)\"$")
	public void csr_searches_for_research_interaction_under(String name, String interactionType) throws Throwable {
		
		researchInteraction.findElement(By.xpath("//input[@id='pySearchText']")).sendKeys(Keys.CLEAR);
		researchInteraction.findElement(By.xpath("//input[@id='pySearchText']")).sendKeys(name);
		researchInteraction.findElement(By.xpath("//i[@name='CPMSearch_pyDisplayHarness_3']")).click();
		
		PegaWebElement searchTypeTab = researchInteraction.findElement(By.xpath("//h3[@class='layout-group-item-title'][text()='"+interactionType+"']"));
		searchTypeTab.click();
		
		
	}

	@Then("^Verify the results displayed for tag \"([^\"]*)\"$")
	public void verify_the_results_displayed_for_tag(String arg1) throws Throwable {
		
		Assert.assertTrue("Content Type header is not present",
				researchInteraction.verifyElement(By.xpath("//div[@class='divCont ']/div[contains(text(),'Content type')]")));
		
		Assert.assertTrue("Average rating header is not present",
				researchInteraction.verifyElement(By.xpath("//div[@class='divCont ']/div[contains(text(),'Average rating')]")));
		
		Assert.assertTrue("Content views header is not present",
				researchInteraction.verifyElement(By.xpath("//div[@class='divCont ']/div[contains(text(),'Content views')]")));
	}
	
	

	@Then("^Verify the left nav header displayed for cases$")
	public void verify_the_left_nav_header_displayed_for_cases()  {
		Assert.assertTrue("Case Id header is not present",researchInteraction.verifyElement(By.xpath("//label[text()='Case ID']")));
		Assert.assertTrue("Description header is not present",researchInteraction.verifyElement(By.xpath("//label[text()='Description']")));
		Assert.assertTrue("Account Number header is not present",researchInteraction.verifyElement(By.xpath("//label[text()='Account number']")));
		Assert.assertTrue("Customer Name header is not present",researchInteraction.verifyElement(By.xpath("//label[text()='Customer name']")));
		Assert.assertTrue("Status header is not present",researchInteraction.verifyElement(By.xpath("//label[text()='Status']")));
	}

	

	@Then("^Verify the result displayed for the search$")
	public void verify_the_result_displayed_for_the_search() {
		Assert.assertTrue("Customer Name text is not present",researchInteraction.verifyElement(By.xpath("//span[text()='Sara Connor' or contains(text(),'Rebecca  Biggs')]")));
	    
	}


	@Then("^Verify the options displayed for the case$")
	public void verify_the_options_displayed_for_the_case() {
		Assert.assertTrue("Last interaction field is not present",researchInteraction.verifyElement(By.xpath("//span[contains(text(),'Last interaction')]")));
		Assert.assertTrue("Reason field is not present",researchInteraction.verifyElement(By.xpath("//span[contains(text(),'Reason')]")));
		Assert.assertTrue("Status field is not present",researchInteraction.verifyElement(By.xpath("//span[contains(text(),'Status')]")));
		Assert.assertTrue("NPS field is not present",researchInteraction.verifyElement(By.xpath("//span[contains(text(),'NPS')]")));
		Assert.assertTrue("Phone field is not present",researchInteraction.verifyElement(By.xpath("//span[contains(text(),'Phone')]")));
		Assert.assertTrue("Address field is not present",researchInteraction.verifyElement(By.xpath("//span[contains(text(),'Address')]")));
		
		Assert.assertTrue("Phone channel is not present",researchInteraction.verifyElement(By.xpath("//span[text()='Phone']")));
		Assert.assertTrue("Phone Icon is not present",researchInteraction.verifyElement(By.xpath("//img[@src='webwb/InteractionPhone.svg']")));
		Assert.assertTrue("reason for interaction is not present",researchInteraction.verifyElement(By.xpath("//span[text()='Other']")));
		Assert.assertTrue("Bottom Close button is not present",researchInteraction.verifyElement(By.xpath("//div[@class='pzbtn-mid' and text()='Close']")));
	   
	}
	
	


	@Then("^Verify the results displayed for cases$")
	public void verify_the_results_displayed_for_cases()   {
		Assert.assertTrue("Phone Call text is not present",
				researchInteraction.verifyElement(By.xpath("//span[text()='Phone Call']")));
	}

	@Then("^Verify the options displayed for \"([^\"]*)\" case$")
	public void verify_the_options_displayed_for_case(String ServiceProcess) {
		
		Assert.assertTrue("Service process header is not present",researchInteraction.verifyElement(By.xpath("//span[@data-test-id='2016011906264301103689' and contains(text(),'"+ServiceProcess+"')]")));
		Assert.assertTrue("Status header is not present",researchInteraction.verifyElement(By.xpath("//span[contains(text(),'Status')]")));
	}



	@When("^click on \"([^\"]*)\" link$")
	public void click_on_link(String linkName) {
		researchInteraction.selectLinkUnderShareandFeedback(linkName);
		

	}

	@When("^Select \"([^\"]*)\" and serach for \"([^\"]*)\"$")
	public void select_and_serach_for(String searchType, String value) {
		researchInteraction.selectandSearchResearchType(searchType, value);
		
	}

	@Then("^Verify Operator name \"([^\"]*)\"$")
	public void verify_Operator_name(String username) throws Throwable {
		
		if (username.equalsIgnoreCase("CA Sys Admin")) {
			String FinalXpath = "//div[@class='content-item content-field item-1 remove-all-spacing   dataValueWrite flex flex-row ']/i[@title='"
					+ username + "']";
			researchInteraction.verifyElement(By.xpath(FinalXpath));
		} else if (username.equalsIgnoreCase("Dan Percival")) {
			String FinalXpath = "//div[@class='field-item dataValueWrite']/img[contains(@title,'" + username + "')]";
			researchInteraction.verifyElement(By.xpath(FinalXpath));
		} else {
			String FinalXpath = "//div[@class='field-item dataValueWrite']/span/a[contains(@title,'" + username + "')]";
			researchInteraction.verifyElement(By.xpath(FinalXpath));
		}
		if (username.equalsIgnoreCase("Back office user ")) {
			String FinalXpath = "//a[text()='" + username + "']";
			researchInteraction.verifyElement(By.xpath(FinalXpath));

		}
		if (username.equalsIgnoreCase("Back office manager ")) {
			String FinalXpath = "//a[text()='" + username + "']";
			researchInteraction.verifyElement(By.xpath(FinalXpath));

		}
	}
	
	@When("^Filter the result with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void filter_the_result_with_and(String searchBox, String searchString) {
		inboundInteraction.filterwithInitialValues(searchBox, searchString);

	}
	
	@When("^Filter with Account number \"([^\"]*)\" Type \"([^\"]*)\" Status \"([^\"]*)\" and owner \"([^\"]*)\"$")
	public void filter_with_Account_number_Type_Status_and_owner(String AcNo, String Type, String Status,
			String OwnerName) {

		inboundInteraction.filterWithAllForAccount(AcNo, Type, Status, OwnerName);

	}
	

}
