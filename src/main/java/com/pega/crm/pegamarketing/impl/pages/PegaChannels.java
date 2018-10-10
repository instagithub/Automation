package com.pega.crm.pegamarketing.impl.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.impl.dialog.PegaModalDialog;
import com.pega.crm.pegamarketing.pages.Channels;
import com.pega.crm.pegamarketing.pages.Channels.AddOutboundSMSConnection;
import com.pega.crm.pegamarketing.pages.Channels.PaidMediaSetting;
import com.pega.crm.pegamarketing.pages.Channels.TestConnectivityResults;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.WindowImpl;
import com.pega.framework.elmt.Frame;
import com.pega.framework.elmt.FrameImpl;

public class PegaChannels extends FrameImpl implements Channels {
	PegaWebDriver pegaDriver;

	public PegaChannels(WebElement elmt, String elmtId) {
		super(elmt, elmtId);
	}

	public AddOutboundSMSConnection addConnection() {
		findElement(ADD_CONNECTION_BTN).click();
		AddOutboundSMSConnection addOutboundSMSConnection = new PegaAddOutboundSMSConnection(this);
		return addOutboundSMSConnection;
	}

	public class PegaAddOutboundSMSConnection extends PegaModalDialog implements AddOutboundSMSConnection {
		PegaWebElement elmt;

		public PegaAddOutboundSMSConnection(Frame elmt) {
			super(elmt);
			this.elmt = elmt;
		}

		public void addConnectionSetup(String accountName, String hostAddress, String port, String userId,
				String password, String testNumber, String senderNumber) {
			elmt.findElement(ACCOUNT_NAME_TXTBOX).sendKeys(accountName);
			elmt.findElement(HOST_ADDRESS_TXTBOX).sendKeys(hostAddress);
			elmt.findElement(HOST_PORT_TXTBOX).sendKeys(port);
			elmt.findElement(USER_ID_TXTBOX).sendKeys(userId);
			elmt.findElement(PASSWORD_TXTBOX).sendKeys(password);
			elmt.findElement(TEST_NUMBER_TXTBOX).sendKeys(testNumber);
			elmt.findElement(SENDERS_NUMBER_TXTBOX).sendKeys(senderNumber);
		}
	}

	public TestConnectivityResults testConnection(String connectionName) {
		pegaDriver = testEnv.getPegaDriver();
		pegaDriver.switchToActiveFrame();
		String currentHandle = pegaDriver.getWindowHandle();
		findElement(By.xpath("//span[text()='" + connectionName + "']/ancestor::tr[1]//a[@title='Test']")).click(false);
		for (String handle : pegaDriver.getWindowHandles()) {
			if (handle.equals(currentHandle))
				continue;
			pegaDriver.switchTo().window(handle);
		}
		return new PegaTestConnectivityResults(testEnv);
	}

	public void deleteSMSAccount(String accountName) {
		findElement(
				By.xpath("//span[text()='" + accountName + "']/ancestor::tr[1]//i[@title='Delete this SMS Account ']"))
						.click();
		findElement(By.xpath("//div[@class='pzbtn-mid' and text()='Delete']")).click();
		testEnv.getPegaDriver().waitForDocStateReady();
	}

	public class PegaTestConnectivityResults extends WindowImpl implements TestConnectivityResults {
		public PegaTestConnectivityResults(TestEnvironment testEnv) {
			super(testEnv);
		}

		public String getAccountName() {
			String fullAccountName = pegaDriver.findElement(ACCOUNT_NAME).getText().trim();
			return fullAccountName.split(" ")[fullAccountName.split(" ").length - 1];
		}

		public String getOverallResult() {
			return pegaDriver.findElement(OVERALL_RESULT).getText().trim();
		}

		public String getResultDescription() {
			return pegaDriver.findElement(RESULT_DESCRIPTION).getText().trim();
		}

		public void closeWindow() {
			String currentHandle = pegaDriver.getWindowHandle();
			Set<String> handles = pegaDriver.getWindowHandles();
			pegaDriver.findElement(By.xpath("//input[@value='Close']")).click(false);
			for (String handle : handles) {
				if (handle.equals(currentHandle))
					continue;
				pegaDriver.switchTo().window(handle);
			}

		}

	}

	public PaidMediaSetting openPaidMedia() {
		findElement(lnkPaidMedia).click(true);
		PaidMediaSetting paidMedia = new PegaPaidmedia(testEnv);
		return paidMedia;
	}

	public class PegaPaidmedia implements PaidMediaSetting {

		PegaPaidmedia pegapaidmedia;

		public PegaPaidmedia(TestEnvironment testEnv) {

		}

		public void clickOnLinkedInTab() {
			findElement(btnLinkedInTab).click(true);
		}

		public void clickOnLinkedInDestination() {
			findElement(btnAdsDestination).click(true);
		}

		public String verifyPopupHeaderText() {
			String popupHeadertext = "";
			if (findElement(txtLinkedInSettingPopUpHeader).isDisplayed()) {
				popupHeadertext = findElement(txtLinkedInSettingPopUpHeader).getText();
			}
			return popupHeadertext;
		}

		public void clickOnApplyButton() {
			if (findElement(btnApply).isDisplayed() && findElement(btnApply).isEnabled()) {
				findElement(btnApply).click();
			}
		}

		public String verifySubmittedPaidLinkedInSettingsInLandingPage() {
			String submittedSettingText = "";
			if (findElement(btnApply).isDisplayed()) {
				submittedSettingText = findElement(lnkLinkedInSubmittedSetting).getText();
			}
			return submittedSettingText;
		}

		public void clickOnFacebookAdsTab() {
			findElement(btnFacebookAdsTab).click();
		}

		public void clickOnNewFacebookAds() {
			findElement(btnAdsDestination).click();
		}

		public void clickOnEnableCampaignGeneration() {

			if (findElement(chkboxCampiagnGeneration).isDisplayed()
					&& findElement(chkboxCampiagnGeneration).isEnabled()) {
				findElement(chkboxCampiagnGeneration).click();
			}
		}

		public String verifySubmittedPaidSettingsInLandingPage() {

			String submittedSettingText = "";

			if (findElement(lnkSubmittedSetting).isDisplayed()) {
				submittedSettingText = findElement(lnkSubmittedSetting).getText();
			}
			return submittedSettingText;
		}

		public void clickOnGoogleAdWordsTab() {
			findElement(btnGoogleAdsTab).click();
		}

		public void clickOnGoogleAdWordsAddDestination() {
			findElement(btnAdsDestination).click();
		}

		public void clickOnAdobeTab() {
			findElement(btnAdobeAdsTab).click();
		}

		public void clickOnAdobeDestination() {
			findElement(btnAdsDestination).click();
		}

		public void clickOnFTP() {

			if (findElement(chkboxFTP).isDisplayed() && findElement(chkboxFTP).isEnabled()) {
				findElement(chkboxFTP).click();
			}
		}

		public void clickOnWebTab() {
			findElement(btnWebTab).click();
		}

		public void clickOnWebDestination() {
			findElement(btnAdsDestination).click();
		}

		public String verifyLinkedInPaidSettingPopupHeaderText() {
			String popupHeadertext = verifyPopupHeaderText();
			return popupHeadertext;
		}

		public void enterConnectionDetailsOnLinkedInPaidSettings(String linkedInDestinationName,
				String linkedInDescription, String accountIdLinkedIn, String accessToken, String sourcePlatform,
				String emailLinkedIn) {
			if (findElement(txtDestinationName).isEnabled() && findElement(txtDecsription).isEnabled()) {
				findElement(txtDestinationName).sendKeys(linkedInDestinationName);
				findElement(txtDecsription).sendKeys(linkedInDescription);
				findElement(txtboxAccountId).sendKeys(accountIdLinkedIn);
				findElement(txtboxAccessToken).sendKeys(accessToken);
				findElement(txtboxSourcePlatform).sendKeys(sourcePlatform);
				findElement(txtboxEmail).sendKeys(emailLinkedIn);
			}
		}

		public String verifyFBPaidSettingPopupHeaderText() {
			String popupHeadertext = verifyPopupHeaderText();
			return popupHeadertext;
		}

		public String verifyAdWordsPaidSettingPopupHeaderText() {
			String popupHeadertext = verifyPopupHeaderText();
			return popupHeadertext;
		}

		public String verifyAdobePaidSettingPopupHeaderText() {
			String popupHeadertext = verifyPopupHeaderText();
			return popupHeadertext;
		}

		public String verifyWebPaidSettingPopupHeaderText() {
			String popupHeadertext = verifyPopupHeaderText();
			return popupHeadertext;
		}

		public void enterConnectionDetailsOnFBPaidSettings(String destName, String desc, String accountId,
				String appToken, String phone, String email) {

			if (findElement(txtDestinationName).isEnabled() && findElement(txtDecsription).isEnabled()
					&& findElement(txtboxEmail).isEnabled() && findElement(txtboxPhone).isEnabled()) {

				findElement(txtDestinationName).sendKeys(destName);
				findElement(txtDecsription).sendKeys(desc);
				findElement(txtboxAccountId).sendKeys(accountId);
				findElement(txtboxAppToken).sendKeys(appToken);
				findElement(txtboxPhone).sendKeys(phone);
				findElement(txtboxEmail).sendKeys(email);

			}
		}

		public void enterConnectionDetailsOnAdWordsPaidSettings(String destNameAdWords, String descAdWords,
				String clientidAdWords, String clientsecretAdWords, String devtokenAdWords, String emailAdWords, String phoneAdwords,
				String refreshtokenAdWords, String customeridAdWords) {
			if (findElement(txtDestinationName).isEnabled() && findElement(txtDecsription).isEnabled()) {
				findElement(txtDestinationName).sendKeys(destNameAdWords);
				findElement(txtDecsription).sendKeys(descAdWords);
				findElement(txtGoogleClientID).sendKeys(clientidAdWords);
				findElement(txtGoogleClientSecret).sendKeys(clientsecretAdWords);
				findElement(txtGoogleDeveloperToken).sendKeys(devtokenAdWords);
				findElement(txtboxEmail).sendKeys(emailAdWords);
				findElement(txtboxPhone).sendKeys(phoneAdwords);
				findElement(txtGoogleRefreshToken).sendKeys(refreshtokenAdWords);
				findElement(txtGoogleClientCustomerID).sendKeys(customeridAdWords);				
			}
		}
		
		public void clickAppId() {
			findElement(lnkAddAppID).click();
		}
		
		public void addAppId(String appId) {
			if (findElement(txtAppID).isEnabled()){
				findElement(txtAppID).sendKeys(appId);
			}
		}
		
		public void clickDeviceId() {
			findElement(lnkAddDeviceID).click();
		}
		
		public void addDeviceId(String deviceId) {
			if (findElement(txtDeviceID).isEnabled()){
				findElement(txtDeviceID).sendKeys(deviceId);
			}
		}

		public void enterConnectionDetailsOnAdobePaidSettings(String destNameAdobe, String descAdobe, String dPIdAdobe,
				String dataSourceIdAdobe, String apiUserNameAdobe, String apiPasswordAdobe, String apiClientIdAdobe,
				String apiSecretKeyAdobe, String syncIdAdobe, String s3bucketname, String s3AccessKey,
				String s3SecretKey, String s3Region, String s3Folder) {

			if (findElement(txtDestinationName).isEnabled() && findElement(txtDecsription).isEnabled()
					&& findElement(txtAdobeDPId).isEnabled() && findElement(txtDataSourceId).isEnabled()
					&& findElement(txtAPIUserName).isEnabled() && findElement(txtAPIPassword).isEnabled()
					&& findElement(txtAPIClientId).isEnabled() && findElement(txtAPISecretKey).isEnabled()
					&& findElement(txtSyncId).isEnabled() && findElement(txtBucketName).isEnabled()
					&& findElement(txtAccessKey).isEnabled() && findElement(txtSecretKey).isEnabled()
					&& findElement(txtRegion).isEnabled() && findElement(txtFolder).isEnabled()) {

				findElement(txtDestinationName).sendKeys(destNameAdobe);
				findElement(txtDecsription).sendKeys(descAdobe);
				findElement(txtAdobeDPId).sendKeys(dPIdAdobe);
				findElement(txtDataSourceId).sendKeys(dataSourceIdAdobe);
				findElement(txtAPIUserName).sendKeys(apiUserNameAdobe);
				findElement(txtAPIPassword).sendKeys(apiPasswordAdobe);
				findElement(txtAPIClientId).sendKeys(apiClientIdAdobe);
				findElement(txtAPISecretKey).sendKeys(apiSecretKeyAdobe);
				findElement(txtSyncId).sendKeys(syncIdAdobe);

				findElement(txtBucketName).sendKeys(s3bucketname);
				findElement(txtAccessKey).sendKeys(s3AccessKey);
				findElement(txtSecretKey).sendKeys(s3SecretKey);
				findElement(txtRegion).sendKeys(s3Region);
				findElement(txtFolder).sendKeys(s3Folder);
			}
		}

		public void enterConnectionDetailsOnWebPaidSettings(String webDestinationName, String webDescription) {

			if (findElement(txtDestinationName).isEnabled() && findElement(txtDecsription).isEnabled()) {

				findElement(txtDestinationName).sendKeys(webDestinationName);
				findElement(txtDecsription).sendKeys(webDescription);
			}
		}


	}

}
