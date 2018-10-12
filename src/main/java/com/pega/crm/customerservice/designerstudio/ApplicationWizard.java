package com.pega.crm.customerservice.designerstudio;

import com.pega.ri.Wizard;

public interface ApplicationWizard extends Wizard {

	void modifyAccessGroup();

	void createNewCase(String caseName, String stageName);

	void createNewApplication(String builton, String type, String organization);

}
