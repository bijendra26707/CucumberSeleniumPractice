Feature: Login page feature


Scenario:Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Login - My Store"

Scenario: Forgot password link
Given user is on login page
Then Forgot password page should be displayed

Scenario:Login with Correct credentials
Given user is on login page
When user enters username "yuvraj26707@gmail.com"
And user enters password "Selenum@12345"
And user clicks on Login button
Then user gets the title of the page
And page title should be "My account - My Store"
