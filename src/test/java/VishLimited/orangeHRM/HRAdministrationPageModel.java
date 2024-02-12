package VishLimited.orangeHRM;

import VishLimited.excelDriven.DataDriven;
import VishLimited.pageObject.CreateHRAdmin;
import VishLimited.pageObject.EditHRAdmin;
import VishLimited.pageObject.HRAdminPage;
import VishLimited.pageObject.RemoveHRAdmin;
import VishLimited.testComponent.BaseTest;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HRAdministrationPageModel extends BaseTest {
	
	@Test(dataProvider = "dataSource")
	void main(String userName, String password, String employeeToAdd, String newUserName) throws InterruptedException {
		
		HRAdminPage hrObject = login.loginToSite(userName, password);
		
		CreateHRAdmin create = hrObject.mainHRAdminPage();
		
		EditHRAdmin edit = create.addUserToHRAdmin(employeeToAdd);
		
		RemoveHRAdmin remove = edit.updateHRAdmin(newUserName);
		
		remove.deleteHRAdimn();
		
		
	}
	
	@DataProvider(name = "dataSource")
	public Object[][] getDataFromExcel () throws IOException{
		DataDriven excelObj = new DataDriven();
		
		ArrayList<ArrayList<String>> data = excelObj.getExcelData();
		
		Object[][] object = new Object[data.size()-1][data.get(0).size()];
		
		for(int i=1; i<data.size(); i++)
			for(int j=0; j<data.get(0).size(); j++)
				object[i-1][j] = data.get(i).get(j);
		
		return object;
	}
	
}
