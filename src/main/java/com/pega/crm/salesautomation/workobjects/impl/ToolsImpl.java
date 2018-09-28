package salesautomation.workobjects.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.pega.ri.WizardImpl;
import salesautomation.workobjects.Tools;


public class ToolsImpl extends WizardImpl implements Tools
{
	public ToolsImpl(WebElement elmt, String elmtId) 
	{
		super(elmt, elmtId);
		
	}

	@Override
	public void clickPlusButton() {
		pegaDriver.getActiveFrameId(true);
		//pegaDriver.findElement(By.xpath(MRT_PLUS_BUTTON_XPATH)).scrollIntoView();
	//	pegaDriver.findElement(By.xpath(MRT_PLUS_BUTTON_XPATH)).click();
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath(MC_Createcompetitor_XPATH)).click();
	}

	@Override
	public void setAssociateTo(String Associate) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findSelectBox(By.xpath(MRT_ASSOCIATETO_XPATH)).selectByVisibleText(Associate);
		
	}

	@Override
	public void setRelationShipType(String RelationshipType) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(MRT_RELATIONSHIP_TYPE_ID)).sendKeys(RelationshipType);
		
	}

	@Override
	public void setRelationshipDesc(String Desc) {
		pegaDriver.findElement(By.id(MRT_RELATIONSHIP_DESC_ID)).sendKeys(Desc);
		
	}

	@Override
	public void clickOk() {
		UtilImpl.clickOK(pegaDriver);
		
	}

	@Override
	public List<String> getRelationshipValues(String Associate, String Relationship) {
		return (UtilImpl.getRowValues(pegaDriver, MRT_ROW_IDENTIFER_XPATH, Associate, Relationship));
	}

	@Override
	public void setSellingMode(String smode) {
		pegaDriver.findSelectBox(By.id(MRT_SELLINGMODE_ID)).selectByVisibleText(smode);
		
	}

	@Override
	public void setCompetitorName(String name) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(MC_NAME_ID)).sendKeys(UtilImpl.SelectAll);
		pegaDriver.findElement(By.id(MC_NAME_ID)).sendKeys(name);
		
	}
	
	@Override
	public boolean isCompetitorPresent(String name) {
		return (UtilImpl.isRowValuePresent(pegaDriver, MC_ROW_IDENTIFIER_XPATH, MC_COLUMN_IDENTIFIER_XPATH, name));
	}

	@Override
	public void doubleClickCompetitor(String name) {
		UtilImpl.openRowWithDoubleClick(pegaDriver, MC_ROW_IDENTIFIER_XPATH, MC_COLUMN_IDENTIFIER_XPATH, name);
		
	}

	@Override
	public void setBattleCard(String BattleName) {
		pegaDriver.findElement(By.id(MC_BATTLE_FIELD_ID)).sendKeys(BattleName);
		
	}
	

	
	public void clickCreterelationship(){
		
	}
	public void clickCreatetimeperiod(){
		
	}

	@Override
	public void clickCreatecomp() {
		// TODO Auto-generated method stub
		
	}
	
	
}

