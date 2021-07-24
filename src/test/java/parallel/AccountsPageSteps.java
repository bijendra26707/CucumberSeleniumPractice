package parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.Pages.AccountPage;
import com.Pages.LoginPage;
import com.qa.Factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {

	
	private LoginPage loginpage = new LoginPage(DriverFactory.getWebdrive());
	private AccountPage accountpage;
	
	@Given("user has already logged into application")
	public void user_has_already_logged_into_application(DataTable dataTable) {
		List<Map<String, String>> credList = dataTable.asMaps();
		String username = credList.get(0).get("username");
		String pwd = credList.get(0).get("password");
		DriverFactory.getWebdrive().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountpage = loginpage.doLogin(username, pwd);
		
	}

	@Given("user is on account page")
	public void user_is_on_account_page() {
		System.out.println("accountpage.getAccountspageTitle(); "+accountpage.getAccountspageTitle());
		accountpage.getAccountspageTitle();
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionslist) {
		List<String> expectedAccountSectionList = sectionslist.asList();
		System.out.println("expectedAccountSectionList:"+expectedAccountSectionList);
		
		List<String> actualAccountSectionList = accountpage.getAccountSectionList();
		System.out.println("expectedAccountSectionList:"+actualAccountSectionList);
		
		Assert.assertTrue(expectedAccountSectionList.containsAll(actualAccountSectionList));
		
	}

	@Then("account section count should be {int}")
	public void account_section_count_should_be(Integer int1) {
			Assert.assertTrue(int1 == accountpage.getAccountsSectionCount());}
}
