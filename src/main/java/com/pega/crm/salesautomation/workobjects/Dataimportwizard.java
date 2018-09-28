package salesautomation.workobjects;
import com.pega.ri.Wizard;
public interface Dataimportwizard extends Wizard{
	

	public void SelectUploadtype(String Loader);
	public void Clickimport();
	public void Choosefile(String Loaercsv);
	public void Selectpurpose(String Purpose);
	public void ClickCancel();
	public void ClickNext();
	public void Selecttemplate(String LoaderTemplate);
	public void ClickBack();
	public void Nameforthisimport();
	public boolean Saveimportsettings_as_a_template();
	public void Templatename();
	public boolean Skiprunning_validaterules();
	public void Clickstartvalidation();
	public void Clickcontinueimport();
	public void Clickfinish();
	public void setDateformat();
	public void Uploadtypeopp(String Loader);
	
    
}