package parallel;

import org.junit.Assert;

import com.Pages.LoginPage;
import com.qa.Factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private LoginPage loginpage = new LoginPage(DriverFactory.getWebdrive());
	
	String title;
	@Given("user is on login page")
	public void user_is_on_login_page() {
	  DriverFactory.getWebdrive().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginpage.getLoginPageTilte();
		System.out.println("title"+title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {		
		Assert.assertTrue(title.contains(expectedTitle));
	}


	@Then("Forgot password page should be displayed")
	public void forgot_password_page_should_be_displayed() {
	  Assert.assertTrue(loginpage.isForgotPwdLinkExists());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
	   loginpage.enterPassword(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginpage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
	    loginpage.clickOnlogin();
	}

}
