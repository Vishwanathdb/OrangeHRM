package VishLimited.orangeHRM;

import VishLimited.pageObject.CreateHRAdmin;
import VishLimited.pageObject.EditHRAdmin;
import VishLimited.pageObject.HRAdminPage;
import VishLimited.pageObject.RemoveHRAdmin;
import VishLimited.testComponent.BaseTest;
import org.testng.annotations.Test;

public class HRAdministrationPageModel extends BaseTest {
	
	@Test()
	void main() throws InterruptedException {
		
		String userName = "Admin", password = "OYs6MbnC2@";
		String employeeToAdd = "Aaron";
		String newUserName = "Aaron Update";
		
		HRAdminPage hrObject = login.loginToSite(userName, password);
		
		CreateHRAdmin create = hrObject.mainHRAdminPage();
		
		EditHRAdmin edit = create.addUserToHRAdmin(employeeToAdd);
		
		RemoveHRAdmin remove = edit.updateHRAdmin(newUserName);
		
		remove.deleteHRAdimn();
		
		
	}
	
}
