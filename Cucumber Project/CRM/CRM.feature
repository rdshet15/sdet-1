@CRM
Feature: CRM Site
  
  @Activity1
  Scenario: Counting Dashlets
    Given Navigate to Alchemy CRM site and login
    Then Print count of dashlets
    And Close the Browser
    
  @Activity2
  Scenario: Create leads using parameterization
  	Then Navigate to Sales Leads and CreateLead
    Then Fill the details "Mr.", First Name "Hariprasad", Last Name "shanai"
    Then Navigate to View Leads page to see results "Mr.", First Name "Hariprasad", Last Name "shanai"
    And Close the Browser
    
  @Activity3
  Scenario Outline: Schedule a meeting and invite members
    And Navigate to Activities Meetings ScheduleaMeeting
    And Enter the details of the meeting
    And Search for members and add them to the meeting    
    |fname|lname|email|
    |Zelma|Newby|phone27@example.tw|
    |Sarah|Smith|sarah@example.com|
    Then Navigate to View Meetings page and confirm creation of the meeting
    And Close the Browser
    
  @Activity4
  Scenario Outline: Creating a Product
	  And Navigate to All Products CreateProduct
    And Enter Details of the Product "<productName>", "<productPrice>"
    And Click Save
    When Navigated to View Products Page
    Then All Products should be listed "<productName>"
    And Close the Browser

    Examples: 
      | productName  | productPrice |
      |laptop | 80000 |
      |phone| 12000|