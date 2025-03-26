Feature: User Registration
Background:
Given User opens the Browser
And User navigate to the "https://www.tastynibbles.in/" web page
When User clicks on Account link
When user clicks on Create account link

Scenario Outline: User Registration with Invalid Data
When User enters '<First Name>' in FirstName
And User enters  '<Last Name>' in LastName
And User enters '<Email>' in email
And User enters  '<Password>' in password
And User clicks on Create button
Then User verifies the error message
And User closes the Browser
Examples:
|First Name|Last Name|Email|Password|
|Navy|Ravu|navya12@gmail.com||


Scenario Outline: User Registration with Valid Data
When User enters '<First Name>' in FirstName
And User enters  '<Last Name>' in LastName
And User enters '<Email>' in email
And User enters  '<Password>' in password
And User clicks on Create button
Then User verifies  registered successfully
And User closes the Browser
Examples:
|First Name|Last Name|Email|Password|
|Navya|Ravuri|nbvch@gmail.com|Navya123|