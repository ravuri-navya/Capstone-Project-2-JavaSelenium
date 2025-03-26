Feature: 
Scenario: User Adding two products and verifying cart summary
Given User opens the Browser
And User navigate to the "https://www.tastynibbles.in/" web page
When User clicks on Account link
When User enters the login credentials
|Testdata.xlsx|
And User clicks on signIn button
Then User Search and add two products
|RequiredItemsData.xlsx|
And User Navigates to Cart
Then User Verifies the products and total price in the cart
|RequiredItemsData.xlsx|
And User closes the Browser