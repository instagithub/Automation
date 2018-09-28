package pegamarketing.elmt;

import org.openqa.selenium.By;

import com.pega.framework.PegaWebElement;
import pegamarketing.rules.Offer.Shape;
import pegamarketing.rules.Offer.ShapeProperties;

public interface OfferShape extends PegaWebElement{
	
	String COPYRIGHT = "Copyright (c) 2014  Pegasystems Inc.";
	String VERSION = "$Id: FlowShape.java 208361 2016-09-01 11:48:23Z PrashantSammeta $";
	
	String RULE_INPUT_ON_PROPERTIES_ID="pyImplementation";
	String OPEN_RULE_BUTTON_ON_PROPERTIES_XPATH="//label[.//*[text()='Rule']]//following-sibling::*//*[@class='iconOpenRule']";
	String RULE_TEXTBOX_ID = "pyImplementation";
	By TOOLBAR_PROPERTIES_BTN = By.xpath("//a[contains(@name,'ToolbarViewProperties')]");
	
	

	/**
	 * To make a connection with the target element. Drags a connector from middle of the shape
	 * @param shape target shape
	 * @param connectorName name of the connector
	 * @return reference to an object of type Connector
	 */
	Connector makeConnection(OfferShape shape, String connectorName);
	
	/**
	 * To make a connection with the target element. As position pass either 1 or 2 or 3 or 4
	 * @param shape target shape
	 * @param connectorName name of the connector
	 * @param position 1-8 in case of assignment, 1-4 in case of Decision etc, depends on no.of points
	 * in a shape from where we can initiate a connection
	 * @return reference to an object of type Connector
	 */
	Connector makeConnection(OfferShape shape, String connectorName, String position);
	
	/**
	 * To get the name of the connector
	 * @return name of the connector
	 */
	String getName();
	
	/**
	 * this method clicks on a particular shape to get the shape properties modal dialog
	 * @return reference to an object of type ShapeProperties
	 */
	ShapeProperties openProperties();
	/**
	 * this method sets the decision type for the decision shape in the shape properties modal dialog
	 * @param decisionType- decision type for ex:Fork
	 */
	void setDecisionType(String decisionType);
	
	/**
	 *@return this method is used for sub ui tests for getting the internal Name 
	 */
	public String getInternalName();	
	/**
	 * this method clicks on the submit button of the modal dialog
	 */
	void submit();
	/**
	 * this method deletes a particular shape
	 */
	void delete();
	
	/**
	 * this method opens the properties for a shape based on the shape type
	 * @param t any class extends ShapeProperties
	 * @return reference to an object of type ShapeProperties
	 */
	ShapeProperties openProperties(Shape shape);
}
