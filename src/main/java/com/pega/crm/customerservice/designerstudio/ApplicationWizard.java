package customerservice.designerstudio;

public interface ApplicationWizard extends com.pega.wizard.ApplicationWizard{

	void modifyAccessGroup();
	void createNewCase(String caseName, String stageName);
	void createNewApplication(String builton, String type, String organization);

}
