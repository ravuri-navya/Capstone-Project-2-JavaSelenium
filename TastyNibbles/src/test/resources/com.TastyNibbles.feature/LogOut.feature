Feature: User LogOut
Scenario: Successful Logout and Session Verification
Given User opens the Browser
And User navigate to the "https://www.tastynibbles.in/" web page
When User clicks on Account link
When User enters the login credentials
|Testdata.xlsx|
And User clicks on signIn button
And User selects Logout option
Then User Verify that the session ends and the user is redirected to the "https://www.tastynibbles.in/" homepage.
And User closes the Browser