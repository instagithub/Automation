package pegamarketing.pages;

import pegamarketing.rules.RuleInstance;

public interface ServiceRestInstance extends RuleInstance{
	/**
	 * Selects the HTTP method from the simulation window
	 * @param httpMethod type of method e.g. GET POST
	 */
	void selectHttpMethod(String httpMethod);
	/**
	 * clicks on execute button on  the simulation window	 */
	void executeSimulation();
	/**
	 * runs the service instance
	 */
	void run();

}
