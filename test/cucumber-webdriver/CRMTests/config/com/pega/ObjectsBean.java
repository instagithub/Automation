package com.pega;
/**
 * 
 */

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

//import com.pega.explorer.CaseWorkerPortal.Calendar;
import com.pega.explorer.ReportBrowser;
import com.pega.misc.WorkObject;
import com.pega.page.DataType;
import com.pega.page.PegaCKEditor;
import com.pega.page.Tracer;
import com.pega.page.ui.properties.AutoCompleteProperties;
import com.pega.page.ui.properties.Properties;
import com.pega.page.ui.properties.Properties.ActionsTab;
import com.pega.page.ui.properties.RepeatingGridLayoutProperties;
import com.pega.page.ui.properties.TextInputProperties;
import com.pega.ri.RuleInstance;
import com.pega.ri.datamodel.DataPage;
import com.pega.ri.datamodel.DataTransform;
import com.pega.ri.datamodel.Property;
import com.pega.ri.decision.DecisionTable;
import com.pega.ri.decision.When;
import com.pega.ri.integration.ConnectRest;
import com.pega.ri.integration.XMLStream;
import com.pega.ri.integration.resources.FileListener;
import com.pega.ri.integration.resources.ServiceFile;
import com.pega.ri.integration.resources.ServicePackage;
import com.pega.ri.organisation.Application;
import com.pega.ri.organisation.Operator;
import com.pega.ri.process.Correspondence;
import com.pega.ri.process.Flow;
import com.pega.ri.process.WorkParties;
import com.pega.ri.process.editcase.CaseConfiguration.General;
import com.pega.ri.process.editcase.EditCaseType;
import com.pega.ri.reports.ReportDefinition;
import com.pega.ri.security.AccessGroup;
import com.pega.ri.security.AuthenticationProfile;
import com.pega.ri.technical.Activity;
import com.pega.ri.technical.Activity.StepDefinition;
import com.pega.ri.ui.FlowAction;
import com.pega.ri.ui.Harness;
import com.pega.ri.ui.Paragraph;
import com.pega.ri.ui.PortalRule;
import com.pega.ri.ui.Section;
import com.pega.util.DataUtil;
//import com.pega.wizard.DecisioningServices;

/**
 * @author Sachin Vellanki
 * @since 03-Feb-2016
 *
 */
public class ObjectsBean {
	
	String COPYRIGHT = "Copyright (c) 2014  Pegasystems Inc.";
	String VERSION = "$Id: ObjectsBean.java 199996 2016-06-23 12:45:16Z AnilBattinapati $";
	
	private static RepeatingGridLayoutProperties repeatGridLayoutProperties;
	private static ActionsTab actionsTab;
	private static DataType datatype;
	private static Property property;
	private static AccessGroup accessGroup;
	private static Section section;
	private static FlowAction flowAction;
	private static Harness harness;
	private static PortalRule portalRule;
	private static Flow flow;
	private static Application appRuleForm;
	private static Properties properties;
	private static DataTransform dataTransform;
	private static RuleInstance ruleInstance;
	private static DecisionTable decisionTable;
	private static Map<String, Object> objectsMap = new LinkedHashMap<String, Object>();
	private static Map<String, String> objectNames = new LinkedHashMap<String, String>();
	private static EditCaseType editCaseType;
	private static Paragraph paragraph;
	private static PegaCKEditor pegaCKEditor;
	private static Correspondence correspondence;
	private static WorkObject workobject;
	private static WorkParties workParties;
	private static ReportDefinition reportDefinition;
	private static DataPage dataPage;
	private static AutoCompleteProperties autoProps;
	private static TextInputProperties textProps;
	private static General general;
	private static com.pega.explorer.CaseWorkerPortal.WorkObject caseWorkerWorkObject;
	private static Operator operator;
	private static Activity activity;
	private static When when;
	//private static DecisioningServices decisioningServices;
	
	public static Map<String, Section> sections = new LinkedHashMap<String, Section>();
	public static Map<String, ReportDefinition> reportDefinitions = new LinkedHashMap<String, ReportDefinition>();
	public static Map<String, Activity> activities = new LinkedHashMap<String, Activity>();
	public static Map<String, EditCaseType> editCaseTypes = new LinkedHashMap<String, EditCaseType>();

	private static AuthenticationProfile authProfile;
	private static ConnectRest connectRest;
	private static XMLStream xmlStream;
	private static ServicePackage servicePackage;
	private static ServiceFile serviceFile;
	private static StepDefinition stepDef;
	private static FileListener fileListener;
//	private static Calendar calendar;
	private static Tracer tracer;
	private static ReportBrowser reports;
	
	public static Map<String, String> getTimestampedName(){
		return objectNames;
	}

	public static Properties getProperties() {
		return properties;
	}

	public static void setProperties(Properties properties) {
		ObjectsBean.properties = properties;
	}

	public static RepeatingGridLayoutProperties getRepeatGridLayoutProperties() {
		return repeatGridLayoutProperties;
	}

	public static void setRepeatGridLayoutProperties(RepeatingGridLayoutProperties repeatGridLayoutProperties) {
		ObjectsBean.repeatGridLayoutProperties = repeatGridLayoutProperties;
	}

	public static ActionsTab getActionsTab() {
		return actionsTab;
	}

	public static void setActionsTab(ActionsTab actions) {
		ObjectsBean.actionsTab = actions;
	}

	public static DataType getDatatype() {
		return datatype;
	}

	public static void setDatatype(DataType datatype) {
		ObjectsBean.datatype = datatype;
	}
	
	public static void setXmlStream(XMLStream xmlStream){
		ObjectsBean.xmlStream = xmlStream;
	}
	
	public static XMLStream getXmlStream(){
		return xmlStream;
	}

	public static Property getProperty() {
		return property;
	}

	public static void setProperty(Property property) {
		ObjectsBean.property = property;
	}

	public static AccessGroup getAccessGroup() {
		return accessGroup;
	}

	public static void setAccessGroup(AccessGroup accessGroup) {
		ObjectsBean.accessGroup = accessGroup;
	}

	public static Section getSection() {
		return section;
	}

	public static void setSection(Section section) {
		sections.put(section.getId(), section);
		ObjectsBean.section = section;
	}
	
	public static FlowAction getFlowAction() {
		return flowAction;
	}

	public static void setFlowAction(FlowAction flowAction) {
		ObjectsBean.flowAction = flowAction;
	}

	public static Harness getHarness() {
		return harness;
	}

	public static void setHarness(Harness harness) {
		ObjectsBean.harness = harness;
	}

	public static void setEditCaseType(EditCaseType editCaseType) {
		editCaseTypes.put(editCaseType.getId(), editCaseType);
		ObjectsBean.editCaseType = editCaseType;
		
	}
	
	public static EditCaseType getEditCaseType() {
		return editCaseType;
	}

	public static PortalRule getPortalRule() {
		return portalRule;
	}

	public static void setPortalRule(PortalRule portalRule) {
		ObjectsBean.portalRule = portalRule;
	}

	public static Flow getFlow() {
		return flow;
	}

	public static void setFlow(Flow flow) {
		ObjectsBean.flow = flow;
	}

	public static Application getApplication() {
		return appRuleForm;
	}

	public static void setApplication(Application appRuleForm) {
		ObjectsBean.appRuleForm = appRuleForm;
	}

	public static String putTimeStampedValue(String name){
		String existingValue = objectNames.get(name);
		if(existingValue == null){
			String value = DataUtil.getRandomNumberString(name);
			objectNames.put(name, value);
			return value;
		}else{
			return existingValue;
		}
	}
	
	public static String getTimestampedValue(String name){
		String value = objectNames.get(name);
		if(value != null){
			return value; 
		}else{
			return name;
		}
	}

	public static void setParagraph(Paragraph paragraph) {
		ObjectsBean.paragraph = paragraph;
	}
	
	public static Paragraph getParagraph() {
		return ObjectsBean.paragraph;
	}

	public static PegaCKEditor getPegaCKEditor() {
		return pegaCKEditor;
	}

	public static void setPegaCKEditor(PegaCKEditor pegaCKEditor) {
		ObjectsBean.pegaCKEditor = pegaCKEditor;
	}
	
	public static void setWorkObject(WorkObject workObject) {
		ObjectsBean.workobject = workObject;
	}
	
	public static WorkObject getWorkObject(){
		return workobject;
	}
	
	public static void setCorrespondence(Correspondence correspondence) {
		ObjectsBean.correspondence = correspondence;
	}
	
	public static Correspondence getCorrespondence() {
		return correspondence;
	}
	
	public static void setDataTransform(DataTransform dataTransform) {
		ObjectsBean.dataTransform = dataTransform;
		ruleInstance = dataTransform;
	}

	public static DataTransform getDataTransform() {
		return ObjectsBean.dataTransform;
	}
	
	public static RuleInstance getRuleInstance() {
		return ObjectsBean.ruleInstance;
	}
	
	public static void removeSection(String activeFrameId){
		if(sections.containsKey(activeFrameId)){
			sections.remove(section.getId());
			if(sections.size() > 0){
				section = (new ArrayList<Section>(sections.values())).get(sections.size()-1);
			}
		}
	}
	
	public static void removeActivity(String activeFrameId){
		if(activities.containsKey(activeFrameId)){
			activities.remove(activity.getId());
			if(activities.size() > 0){
				activity = (new ArrayList<Activity>(activities.values())).get(activities.size()-1);
			}
		}
	}
	
	public static void removeReportDefinition(String activeFrameId){
		if(reportDefinitions.containsKey(activeFrameId)){
			reportDefinitions.remove(reportDefinition.getId());
			if(reportDefinitions.size() > 0){
				reportDefinition = (new ArrayList<ReportDefinition>(reportDefinitions.values())).get(reportDefinitions.size()-1);
			}
		}
	}
	
	public static void removeEditCaseType(String activeFrameId){
		if(editCaseTypes.containsKey(activeFrameId)){
			editCaseTypes.remove(editCaseType.getId());
			if(editCaseTypes.size() > 0){
				editCaseType = (new ArrayList<EditCaseType>(editCaseTypes.values())).get(editCaseTypes.size()-1);
			}
		}
	}

	public static void setWorkParties(WorkParties workParties) {
		ObjectsBean.workParties = workParties;
		
	}

	public static WorkParties getWorkParties() {
		return workParties;
		
	}

	public static void setReportDefinition(ReportDefinition reportDef) {
		reportDefinitions.put(reportDef.getId(), reportDef);
		ObjectsBean.reportDefinition = reportDef;		
	}
	
	public static ReportDefinition getReportDefinition(){
		return ObjectsBean.reportDefinition;
	}

	public static void setDataPage(DataPage dataPage) {
		ObjectsBean.dataPage = dataPage;		
	}
	
	public static DataPage getDataPage(){
		return ObjectsBean.dataPage;
	}
	
	public static void setDecisionTable(DecisionTable decisionTable){
		ObjectsBean.decisionTable = decisionTable;		
	}
	
	public static DecisionTable getDecisionTable() {
		return ObjectsBean.decisionTable;
	}
	
	public static void setAutoCompleteProperties(AutoCompleteProperties autoProp){
		ObjectsBean.autoProps = autoProp;		
	}
	
	public static AutoCompleteProperties getAutoCompleteProperties(){
		return ObjectsBean.autoProps;
	}

	public static void setTextInputProperties(TextInputProperties textProps){
		ObjectsBean.textProps = textProps;		
	}
	
	public static TextInputProperties getTextInputProperties() {
		return ObjectsBean.textProps;
	}

	public static void setGeneralCategory(General general) {
		ObjectsBean.general = general;	
	}
	
	public static General getGeneralCategory(){
		return ObjectsBean.general;
	}
	
	public static com.pega.explorer.CaseWorkerPortal.WorkObject getCaseWorkerWorkObject() {
		return caseWorkerWorkObject;
	}

	public static void setCaseWorkerWorkObject(com.pega.explorer.CaseWorkerPortal.WorkObject caseWorkerWorkObject) {
		ObjectsBean.caseWorkerWorkObject = caseWorkerWorkObject;
	}
	
	public static void setOperator(Operator operator){
		ObjectsBean.operator = operator;
	}
	
	public static Operator getOperator(){
		return operator;
	}
	
	public static Map<String, String> getObjectNames() {
		return objectNames;
	}

	public static Map<String, Object> getObjectsMap(){
		return objectsMap;
	}
	
	public static void setServicePackage(ServicePackage servicePacakge){
		ObjectsBean.servicePackage = servicePacakge;
	}
	
	public static ServicePackage getServicePackage(){
		return servicePackage;
	}
	
	public static void setServiceFile(ServiceFile serviceFile){
		ObjectsBean.serviceFile = serviceFile;
	}
	
	public static ServiceFile getServiceFile(){
		return serviceFile;
	}

	public static void setAuthenticationProfile(AuthenticationProfile authProfile) {
		ObjectsBean.authProfile = authProfile;
	}
	
	public static AuthenticationProfile getAuthenticationProfile(){
		return authProfile;
	}

	public static void setConnectRest(ConnectRest connectRest) {
		ObjectsBean.connectRest = connectRest;
	}
	
	public static ConnectRest getConnectRest(){
		return connectRest;
	}

	public static Activity getActivity() {
		return activity;
	}

	public static void setActivity(Activity activity) {
		activities.put(activity.getId(), activity);
		ObjectsBean.activity = activity;
	}
	
	public static StepDefinition getstepDef() {
		return stepDef;
	}

	public static void setStepDef(StepDefinition stepDef) {
		ObjectsBean.stepDef = stepDef;
	}
	
	public static void setFileListener(FileListener fileListener){
		ObjectsBean.fileListener = fileListener;
	}
	
	public static FileListener getFileListener(){
		return fileListener;
	}

	public static When getWhen() {
		return when;
	}

	public static void setWhen(When when) {
		ObjectsBean.when = when;
	}

	/*public static void setCaseWorkerCalendar(Calendar calendar) {
		ObjectsBean.calendar = calendar;
	}
	public static Calendar getCaseWorkerCalendar() {
		return calendar;
	}*/
	
	public static void setTracer(Tracer tracer) {
		ObjectsBean.tracer = tracer;
	}
	
	public static Tracer getTracer() {
		return tracer;
	}

	/*public static DecisioningServices getDecisioningServices() {
		return decisioningServices;
	}*/

	/*public static void setDecisioningServices(DecisioningServices decisioningServices) {
		ObjectsBean.decisioningServices = decisioningServices;
	}*/

	public static void setReportBrowser(ReportBrowser reports) {
		ObjectsBean.reports = reports;
		
	}
	public static ReportBrowser getReportBrowser() {
		return reports;
	}
}