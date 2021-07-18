Feature: Account Page feature

Background:
Given user has already logged into application
|username|password|
|yuvraj26707@gmail.com|Selenum@12345|


Scenario: Account page title
Given user is on account page
When user gets the title of the page
Then page title should be "My account - My Store"

Scenario: Account section count
Given user is on account page
Then user gets accounts section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
And account section count should be 6