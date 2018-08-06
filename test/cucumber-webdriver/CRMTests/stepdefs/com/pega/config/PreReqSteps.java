package com.pega.config;

import org.openqa.selenium.By;

import com.pega.Browser;
import com.pega.MyTestEnvironment;

import com.pega.explorer.DesignerStudio;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.elmt.DropDown;
import com.pega.tiles.TopNav;
import com.pega.util.XPathUtil;
import com.pega.wizard.DecisioningServices;

public class PreReqSteps {
	private static PegaWebDriver pegaDriver;
	public static final String REFRESH_LINK_XPATH = XPathUtil.getButtonPzBtnMidXPath("Refresh");
	
       public static void main(String[] args) {
             MyTestEnvironment testEnv = new MyTestEnvironment();
             pegaDriver = testEnv.getPegaDriver();
             Browser browser = testEnv.getBrowser();
             browser.open();
             browser.login("socialqaadmin","install12345!");
             System.out.println("logged in");
             DesignerStudio designerStudio = browser.getPortal(DesignerStudio.class);
             System.out.println("got DS object");
             TopNav topNav = designerStudio.getTopNav();
             //topnav.openLandingPage("Decisioning","Infrastructure","Services");
             
            
            /* DecisioningServices decisioningServices1 = topNav.openLandingPage(DecisioningServices.class, "Decisioning","Infrastructure","Services","Decision Data Store");
             String ip = decisioningServices1.addDDSNode();
             
             DecisioningServices decisioningServices = topNav.openLandingPage(DecisioningServices.class, "Decisioning","Infrastructure","Services","Adaptive Decision Manager");
             decisioningServices.addADMNode();
             pegaDriver.findElement(By.xpath(REFRESH_LINK_XPATH)).click();
             pegaDriver.waitForDocStateReady();
             
             
             DecisioningServices decisioningServices2 = topNav.openLandingPage(DecisioningServices.class, "Decisioning","Infrastructure","Services","Data Flow");
             decisioningServices2.addDFNode(ip);
             
             pegaDriver.findElement(By.xpath(REFRESH_LINK_XPATH)).click();
             pegaDriver.waitForDocStateReady();
             
             DecisioningServices decisioningServices3 = topNav.openLandingPage(DecisioningServices.class, "Decisioning","Infrastructure","Services","Real Time Data Grid");
             decisioningServices3.addVBDNode(ip);
             
             pegaDriver.findElement(By.xpath(REFRESH_LINK_XPATH)).click();
             pegaDriver.waitForDocStateReady();
             */
             
             designerStudio.getTopNav().openLandingPage(DecisioningServices.class, "Decisioning","Infrastructure","Services","Data Flow");
             pegaDriver.waitForDocStateReady(2);
      		pegaDriver.switchTo().defaultContent();
      		pegaDriver.switchTo().frame("PegaGadget0Ifr");
             
             pegaDriver.findSelectBox(By.xpath("//select[@id='pyChosenInstance']")).selectByVisibleText("RealTime");
             
             pegaDriver.waitForDocStateReady(2);
       		pegaDriver.switchTo().defaultContent();
       		pegaDriver.switchTo().frame("PegaGadget0Ifr");
       		
       		pegaDriver.findElement(By.xpath("//button[@data-test-id='add_node']")).click(false);
       		
       		pegaDriver.waitForDocStateReady(2);
    		pegaDriver.switchTo().defaultContent();
    		pegaDriver.switchTo().frame("PegaGadget0Ifr");
    		
    		
    		pegaDriver.findElement(By.xpath("//i[@title='This node ']/ancestor::td/preceding-sibling::td[contains(@class,'gridCell')]/descendant::input[@id='pySelected1']")).click(false);
    		pegaDriver.waitForDocStateReady(2);
    		pegaDriver.switchTo().defaultContent();
    		pegaDriver.switchTo().frame("PegaGadget0Ifr");
    		
    		
    		pegaDriver.findElement(By.xpath("//button[@id='ModalButtonSubmit']")).click();
    	
//    		pegaDriver.findElement(By.xpath(REFRESH_LINK_XPATH)).click();
            pegaDriver.waitForDocStateReady();
             
             designerStudio.getTopNav().openLandingPage("Channel Services", "Pega Social");
             pegaDriver.waitForDocStateReady(2);
     		pegaDriver.switchTo().defaultContent();
     		pegaDriver.switchTo().frame("PegaGadget1Ifr");
     		  DropDown socialStreamDropDown = pegaDriver.findSelectBox(By.xpath("//select[@id='ProjectIDForStreams']"));
//     		  socialStreamDropDown.selectByValue("CSSocialQA");
     		  socialStreamDropDown.selectByVisibleText("SocialQAStream");
     		  
     		 int connectorsCount = 0;
//     		  PegaWebElement connectorsList = pegaDriver.findElement(By.xpath("//button[@title = 'Start connector']"));
     		  connectorsCount = pegaDriver.findElements(By.xpath("//button[@title = 'Start connector']")).size();
     		  
     		  
     		  while(connectorsCount!=0)
     		  {
     			  
     			  pegaDriver.findElement(By.xpath("(//button[@title = 'Start connector'])["+connectorsCount+"]")).click();
     			  pegaDriver.waitForDocStateReady(2);
     			  connectorsCount--;
     		  }
             
             
             
//            browser.logout();
            pegaDriver.quit();
           
          }
}

