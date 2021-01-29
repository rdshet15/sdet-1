@JobsActivity1
Feature: Create a new user

  @createUser
  Scenario: Visit the sites backend and create a new user
    Given Open a browser
    And Navigate to Alchemy Jobs site and log in
    When Locate the left hand menu and click the menu item that says Users
    And Locate the Add New button and click it
    And Fill in the necessary details
    Then Verify that the user was created
    And Close the browser

  @SearchJobAndAppy
  Scenario: Searching for jobs and apply
    Given Open browser with Alchemy Jobs site and navigate to Jobs page
    When Enter keyword and filter job type to show only Full Time jobs
    Then select a job see job details
    And Find the title of the job  and print it to the console
    And Click on the Apply for job button
    And Close the browser

  @Posting_job
  Scenario: ​ Post a job using details passed from the Feature file
    Given Open browser with Alchemy Jobs site
    And Go to post a job page
    And Fill the job details "tester" and "mumbai" and "writer" and "dedast ask "
    When Click submit
    And Go to jobs page
    Then Confirm job listing is shown on page "tester"
    And Close the browser

  @Posting_job_using_examples_parameterization
  Scenario Outline: ​ Post a job using details passed from the Feature file
    Given Open browser with Alchemy Jobs site
    And Go to post a job page
    And Fill the job details <JobTitle> and <Location> and <JobType> and <Description>
    When Click submit
    And Go to jobs page
    Then Confirm job listing is shown on page <JobTitle>
    And Close the browser

    Examples: 
      | JobTitle     | Location  | JobType | Description       |
      | Performance6 | bangalore | sdssd   | Alssdsdl activity |
