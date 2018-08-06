package com.pega;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.google.inject.Inject;
import com.pega.config.ObjectsBean;
import com.pega.config.test.TestBase1S1D;
import com.pega.cs.utils.CommonMethods;
import com.pega.util.GlobalConstants;
import com.pega.util.HTTPUtil;
import com.pega.util.RecorderUtil;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.runtime.java.guice.ScenarioScoped;
import mx4j.log.Logger;

/**
 * 
 * @author Sachin Vellanki
 * @since 29-Dec-2015
 *
 */
@ScenarioScoped
public class MyTestEnvironment extends TestBase1S1D {

	String COPYRIGHT = "Copyright (c) 2014  Pegasystems Inc.";
	String VERSION = "$Id: MyTestEnvironment.java 187193 2016-04-13 01:45:11Z SachinVellanki $";

	Browser browser;
	TestEnvironmentImpl testsdd;
	private static int passed = 0;
	private static int failed = 0;
	private static int total = 0;
	private String videoFilePath = null;
	private boolean isBrowserInitiailized = false;
	private boolean alwaysSaveVideo = false;
	private boolean isDebugMode = false;
	private CommonMethods commonMethods;
	
	@Override
	@Inject
	public Browser getBrowser() {
		if (browser == null) {
			browser = new MyBrowser(this);
		}
		return browser;
	}

	@Before
	public void setUp(Scenario scenario) {
		setUp(scenario, null);
		ObjectsBean.getObjectsMap().clear();
	}

	protected void setUp(Scenario scenario, String browserName) {
		initializeStatus();
		startRecording(scenario);
		configureBrowser();
		commonMethods = new CommonMethods(getPegaDriver());
	}

	@After
	public void tearDown(Scenario scenario) {
		tearDown(scenario, false, alwaysSaveVideo);
	}

	protected void tearDown(Scenario scenario, boolean performLogout) {
		tearDown(scenario, performLogout, alwaysSaveVideo);
	}

	protected void tearDown(Scenario scenario, boolean performLogout,
			boolean saveVideoForPassedScenario) {
		try {
			isDebugMode = getConfiguration().isDebugMode();
			captureScreenshot(scenario);

			if (!isDebugMode) {
				if (performLogout  && !scenario.isFailed()) {
					browser.switchToWindow(1);
					logout();
				}
				terminateSession();
			}
			killDrivers();
			captureVideo(scenario, saveVideoForPassedScenario);
		} finally {
			updateWithCurrentStatus("['" + total + "', " + passed + ", "
					+ failed + ", " + (total - passed - failed) + "]");
		}
	}

	protected void initializeStatus() {
		if (passed + failed == 0) {
			Properties p = new Properties();
			File f = new File("execution.properties");
			try {
				p.load(new FileInputStream(f));
				total = Integer.parseInt(p.getProperty("tests.total"));
			} catch (Exception e) {
				Reporter.log("Unable to read execution.properties file", true);
			}
			updateWithCurrentStatus("['" + total + "', " + passed + ", "
					+ failed + ", " + total + "]");
		}
	}

	protected void startRecording(Scenario scenario) {
		if (System.getenv("JENKINS_URL") != null) {
			String reportsDir = System.getProperty("testReportsDir");
			try {
				String videoFileName = System.getenv("tags");
				videoFilePath = reportsDir
						+ System.getProperty("file.separator") + videoFileName
						+ GlobalConstants.VIDEO_FILE_FORMAT;
				RecorderUtil.startRecording(reportsDir, videoFileName);
				Reporter.log("Video recording started...", true);
			} catch (Exception e) {
				e.printStackTrace();
				Reporter.log("Recording could not be started", true);
			}
		}
	}

	/*private void configureBrowser() {
		browser = getBrowser();
		browser.open();
		configuration = getConfiguration();
		isBrowserInitiailized = true;
		alwaysSaveVideo = configuration.isSaveVideoAlways();
	}
*/
	protected void stopRecording() throws Exception {
		if (System.getenv("JENKINS_URL") != null) {
			RecorderUtil.stopRecording();
		}
	}

	private void deleteVideoFile() {
		if (System.getenv("JENKINS_URL") != null) {
			try {
				File f = new File(videoFilePath);
				if (f.exists()) {
					f.delete();
				}
			} catch (Exception e) {
				Reporter.log("Unable to delete video file: " + videoFilePath,
						Logger.ERROR, true);
			}
		}
	}

	private void updateWithCurrentStatus(String result) {

		String filePath = "Data/BuildWatcher/TestRunExecutionStatus.html";
		String template = "";
		try {
			Scanner sc = new Scanner(new File(filePath));
			while (sc.hasNextLine()) {
				String currLine = sc.nextLine();
				template = template + currLine + "\r\n";
			}
			sc.close();

			template = template.replaceFirst("\\['\\d+',[\\d,\\s]*\\]", result);
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(
					filePath)));
			writer.write(template);
			writer.close();
		} catch (IOException e) {
			Reporter.log("Error updating status", true);
			e.printStackTrace();
		}
	}

	private void captureScreenshot(Scenario scenario) {
		if (System.getenv("JENKINS_URL") != null) {
			if (scenario.isFailed()) {
				try {
					final byte[] screenshot = ((TakesScreenshot)getPegaDriver().getDriver()).getScreenshotAs(OutputType.BYTES);
					scenario.embed(screenshot, "image/png");
				} catch (Exception e) {
					scenario.write("Unable to take screenshot<br/>");
				}
			}
		}
	}
	
	private void terminateSession(){
		try{
			if (!isDebugMode) {
				terminate();
				Reporter.log("Browser terminated...", true);
			}
		}catch(Exception e){
			Reporter.log("BROWSER_TERMINATE_FAILED::"+e.getMessage(),true);
		}
	}
	
	private void killDrivers(){
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			getPegaDriver().handleWaits().sleep(5);
			Reporter.log("Driver processes killed...", true);
		} catch (IOException e) {
			Reporter.log("TASK_KILL_FAILED::"+e.getMessage(),true);
		}
	}
	
	/*private void captureVideo(Scenario scenario, boolean saveVideoForPassedScenario){
		try{
			stopRecording();
			if(System.getenv("JENKINS_URL") != null){
				if (scenario.isFailed()) {
					try{
						String url = null;
						String tags = getTCIDTag(scenario.getSourceTagNames().toString());
						if(tags != null){
							tags = tags.trim();
						}
						if(tags != null && tags.endsWith("-")){
							tags = tags.substring(0, tags.lastIndexOf('-'));
						}
						if(tags != null && tags.endsWith(",")){
							tags = tags.substring(0, tags.lastIndexOf(','));
						}
						if(System.getenv("job.name") != null){
							String buildId = System.getenv("workspace.path");
							buildId = buildId.substring(buildId.lastIndexOf('-')+1);
							url = System.getenv("JENKINS_URL") + "job/" + System.getenv("job.name") 
									+ "/ws/" + GlobalConstants.ARCHIVED_REPORTS_FOLDER_NAME + "/%23" 
									+ buildId +  "- " + System.getenv("team.name") + "/" + tags + "/" + tags + GlobalConstants.VIDEO_FILE_FORMAT;  
						}else{
							url = System.getenv("JOB_URL") +"ws/" + GlobalConstants.ARCHIVED_REPORTS_FOLDER_NAME + "/%23" + System.getenv("BUILD_ID") + "- " + System.getenv("team.name") + "/" + tags + "/" + tags + GlobalConstants.VIDEO_FILE_FORMAT;
						}
						url.replace(" ", "%20");
						scenario.write("<a target='_blank' href='"+url+"'>Execution Video</a> (This video will be available for 3 days only)");
					}catch(Exception e){
						scenario.write("ERROR: Unable to add video link");
					}
					failed++;
				}else{
					passed++;
					if(!saveVideoForPassedScenario && System.getenv("save.all.videos")==null){
						deleteVideoFile();
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			Reporter.log("ERROR: Unable to capture video: "+e.getMessage(), true);
			scenario.write("ERROR: Unable to capture video");
		}
	}*/
	
	private String getTCIDTag(String tags){
		int i = tags.indexOf("@TC");
		int j = tags.lastIndexOf("@TC");
		Pattern p;
		Matcher m;
		if (i != j) {
			p = Pattern.compile("@TC-\\d+-.*?(\\s)|@TC-\\d+-.*");
		} else {
			p = Pattern.compile("@TC-\\d+");
		}
		m = p.matcher(tags);
		if(m.find()){
			return m.group();
		}else{
			return null;
		}
	}
	
	private void logout(){
		try {
			if (isBrowserInitiailized) {
				browser.logout();
				browser.close();
				Reporter.log("Log out successful...", true);
			}
		} catch(Exception e){
			Reporter.log("LOGOUT_FAILED::"+e.getMessage(),true);
		}
	}
	
	private void importUIKits(Collection<String> collection) {
		
		String applications = getConfiguration().getApplicationsForTag(collection);
		if(applications!=null){
			String[] allApps=applications.split(",");
			for(String application:allApps)
			{
				String appName = application.split(":")[0];
				String appVersion = application.split(":")[1];
				HTTPUtil.addUIKitToApplication(this,appName, appVersion);
			}
		}
	}
	
	
	public CommonMethods getCommonMethods(){
		return commonMethods;
	}
	
	/*@Before("@traceFiddler")
    public void setupFiddler(Scenario scenario) throws IOException{
           FiddlerUtils.runFiddler(scenario);
    }
	
    @After("@traceFiddler")
    public void tearDownFiddler(Scenario scenario) throws IOException, InterruptedException{
           FiddlerUtils.stopFiddler(scenario);     
    } */
	
	
}
