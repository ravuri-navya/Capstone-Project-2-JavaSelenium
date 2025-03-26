Feature: User Login with valid and invalid credentials
Scenario: User Login with invalid credentials
Given User opens the Browser
And User navigate to the "https://www.tastynibbles.in/" web page
When User clicks on Account link
When User enters the "navayas@gmail.com" invalid email
When User enters the "random" password
And User clicks on signIn button
And User verifies the "Incorrect email or password." error message
And User closes the Browser
Scenario: User Login with valid credentials
Given User opens the Browser
And User navigate to the "https://www.tastynibbles.in/" web page
When User clicks on Account link
When User enters the login credentials
|TestData.xlsx|
And User clicks on signIn button
And User verifies "My account" is displayed or not
And User closes the Browser