package com.pega.crm.salesautomation.workobjects;

import java.util.List;

import com.pega.crm.salesautomation.workobjects.impl.PegaUtil;
import com.pega.ri.Wizard;

public interface Tools extends Wizard
{
	String MRT_PLUS_BUTTON_XPATH="//a[contains(@title, 'Add a row')]";
	String MRT_ASSOCIATETO_XPATH="//select[contains(@name, 'AssociateTo')]";
	String MRT_RELATIONSHIP_TYPE_ID="RelationShipTypeName";
	String MRT_RELATIONSHIP_DESC_ID="RelationShipTypeDesc";
	String MRT_SELLINGMODE_ID="SellingType";
	String MC_Createcompetitor_XPATH=PegaUtil.getStrongButtonXPath("Create competitor") +"|"+PegaUtil.getStrongButtonXPath("Create relationship type") + "|"+PegaUtil.getStrongButtonXPath("Create time period");
	String MC_Createrelatioshiptype_xpath=PegaUtil.getStrongButtonXPath("Create new relationship type");
	String MC_Createtimperiod_xpath=PegaUtil.getStrongButtonXPath("Create new time period");
    
	//*[@id="RULE_KEY"]/div/div/div/div/span/button
	//String MRT_ROW_IDENTIFER_XPATH="//tr[contains(@oaargs, 'PegaCRM-Data-RelationShipTypes')]";
	String MRT_ROW_IDENTIFER_XPATH="//tr[contains(@oaargs, 'UPlus-SAPlus-Data-RelationShipTypes')]";
	//UPlus-SAPlus-Data-RelationShipTypes
	String MC_NAME_ID="Name";
	String MC_ROW_IDENTIFIER_XPATH="//tr[contains(@oaargs,'UPlus-SAPlus-Data-Competitor')]";
	String MC_COLUMN_IDENTIFIER_XPATH="//td[@data-attribute-name='Name']";
	String MC_BATTLE_FIELD_ID="BattleCard";
	
	void clickCreatecomp();
	void clickCreterelationship();
	void clickCreatetimeperiod();
	void clickPlusButton();
	void setAssociateTo(String Associate);
	void setRelationShipType(String RelationshipType);
	void setRelationshipDesc(String Desc);
	void clickOk();
	List<String> getRelationshipValues(String Associate, String Relationship);
	void setSellingMode(String smode);
	void setCompetitorName(String name);
	boolean isCompetitorPresent(String name);
	void doubleClickCompetitor(String name);
	void setBattleCard(String BattleName);
	
}

	
	
	

