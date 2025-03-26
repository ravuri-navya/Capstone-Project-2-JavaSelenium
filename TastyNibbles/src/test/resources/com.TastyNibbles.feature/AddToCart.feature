Feature:
Background:
Given User opens the Browser
And User navigate to the "https://www.tastynibbles.in/" web page
When User clicks on Account link
Scenario:
When User enters the login credentials
|Testdata.xlxs|
And User clicks on signIn button
Then User Search "Pickles" for a product
And User selects "Prawn Pickle 200g" the product
Then User clicks on Add to cart button
And User Verifies the product "Prawn Pickle 200g" in cart
And User closes the Browser